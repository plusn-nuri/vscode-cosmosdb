/*---------------------------------------------------------------------------------------------
 *  Copyright (c) Microsoft Corporation. All rights reserved.
 *  Licensed under the MIT License. See License.txt in the project root for license information.
 *--------------------------------------------------------------------------------------------*/

import { CollectionMeta, DocumentClient, CollectionPartitionKey } from 'documentdb';
import { IAzureNode, IAzureTreeItem, UserCancelledError, IAzureParentTreeItem, DialogResponses } from 'vscode-azureextensionui';
import * as vscode from 'vscode';
import { getDocumentClient } from "../getDocumentClient";
import * as path from "path";
import { DocDBStoredProceduresTreeItem } from './DocDBStoredProceduresTreeItem';
import { DocDBStoredProcedureTreeItem } from './DocDBStoredProcedureTreeItem';
import { DocDBDocumentsTreeItem } from './DocDBDocumentsTreeItem';
import { DocDBDocumentTreeItem } from './DocDBDocumentTreeItem';

/**
 * Represents a DocumentDB collection
 */
export class DocDBCollectionTreeItem implements IAzureParentTreeItem {
    public static contextValue: string = "cosmosDBDocumentCollection";
    public readonly contextValue: string = DocDBCollectionTreeItem.contextValue;

    private readonly _documentsTreeItem: DocDBDocumentsTreeItem;
    private readonly _storedProceduresTreeItem: DocDBStoredProceduresTreeItem;

    constructor(
        private _documentEndpoint: string,
        private _masterKey: string,
        private _collection: CollectionMeta,
        private _isEmulator: boolean) {
        this._documentsTreeItem = new DocDBDocumentsTreeItem(this._documentEndpoint, this._masterKey, this, this._isEmulator);
        this._storedProceduresTreeItem = new DocDBStoredProceduresTreeItem(this._documentEndpoint, this._masterKey, this, this._isEmulator);
    }

    public get id(): string {
        return this._collection.id;
    }

    public get label(): string {
        return this._collection.id;
    }

    public get iconPath(): string | vscode.Uri | { light: string | vscode.Uri; dark: string | vscode.Uri } {
        return {
            light: path.join(__filename, '..', '..', '..', '..', '..', 'resources', 'icons', 'theme-agnostic', 'Collection.svg'),
            dark: path.join(__filename, '..', '..', '..', '..', '..', 'resources', 'icons', 'theme-agnostic', 'Collection.svg')
        };
    }

    public get link(): string {
        return this._collection._self;
    }

    public get partitionKey(): CollectionPartitionKey | undefined {
        return this._collection.partitionKey;
    }

    public getDocumentClient(): DocumentClient {
        return getDocumentClient(this._documentEndpoint, this._masterKey, this._isEmulator);
    }

    public async deleteTreeItem(_node: IAzureNode): Promise<void> {
        const message: string = `Are you sure you want to delete collection '${this.label}' and its contents?`;
        const result = await vscode.window.showWarningMessage(message, { modal: true }, DialogResponses.deleteResponse, DialogResponses.cancel);
        if (result === DialogResponses.deleteResponse) {
            const client = this.getDocumentClient();
            await new Promise((resolve, reject) => {
                client.deleteCollection(this.link, function (err) {
                    err ? reject(err) : resolve();
                });
            });
        } else {
            throw new UserCancelledError();
        }
    }

    public async loadMoreChildren(_node: IAzureNode<IAzureTreeItem>, _clearCache: boolean): Promise<IAzureTreeItem[]> {
        return [this._documentsTreeItem, this._storedProceduresTreeItem];
    }

    public hasMoreChildren(): boolean {
        return false;
    }

    public pickTreeItem?(expectedContextValue: string): IAzureTreeItem | undefined {
        switch (expectedContextValue) {
            case DocDBDocumentsTreeItem.contextValue:
            case DocDBDocumentTreeItem.contextValue:
                return this._documentsTreeItem;

            case DocDBStoredProceduresTreeItem.contextValue:
            case DocDBStoredProcedureTreeItem.contextValue:
                return this._storedProceduresTreeItem;

            default:
                return undefined;
        }
    }
}
