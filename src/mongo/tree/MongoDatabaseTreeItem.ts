/*---------------------------------------------------------------------------------------------
 *  Copyright (c) Microsoft Corporation. All rights reserved.
 *  Licensed under the MIT License. See License.txt in the project root for license information.
 *--------------------------------------------------------------------------------------------*/

import * as cp from "child_process";
import * as vscode from 'vscode';
import * as os from "os";
import * as path from 'path';
import * as fse from 'fs-extra';
import { MongoClient, Db, Collection } from 'mongodb';
import { Shell } from '../shell';
import { IAzureParentTreeItem, IAzureTreeItem, IAzureNode, UserCancelledError } from 'vscode-azureextensionui';
import { DialogBoxResponses } from '../../constants';
import { MongoCollectionTreeItem } from './MongoCollectionTreeItem';
import { MongoCommand } from '../MongoCommand';
import * as vscodeUtils from '../../utils/vscodeUtils';
import { resolve } from "vscode-languageserver/lib/files";
import { cpUtils } from "../../utils/cpUtils";

const mongoShellPathSettingKey = 'mongo.shell.path';
let outputChannel = vscodeUtils.getOutputChannel();

export class MongoDatabaseTreeItem implements IAzureParentTreeItem {
	public static contextValue: string = "mongoDb";
	public readonly contextValue: string = MongoDatabaseTreeItem.contextValue;
	public readonly childTypeLabel: string = "Collection";
	public readonly connectionString: string;
	public readonly databaseName: string;

	public isConnected: boolean = false;

	constructor(databaseName: string, connectionString: string) {
		this.databaseName = databaseName;
		this.connectionString = connectionString;
	}

	public get label(): string {
		if (this.isConnected) {
			return this.databaseName + " (Connected)";
		}
		return this.databaseName;
	}

	public get id(): string {
		return this.databaseName;
	}

	public get iconPath(): string | vscode.Uri | { light: string | vscode.Uri; dark: string | vscode.Uri } {
		return {
			light: path.join(__filename, '..', '..', '..', '..', '..', 'resources', 'icons', 'theme-agnostic', 'Database.svg'),
			dark: path.join(__filename, '..', '..', '..', '..', '..', 'resources', 'icons', 'theme-agnostic', 'Database.svg')
		};
	}

	public hasMoreChildren(): boolean {
		return false;
	}

	public async loadMoreChildren(_node: IAzureNode, _clearCache: boolean): Promise<IAzureTreeItem[]> {
		const db: Db = await this.getDb();
		const collections: Collection[] = await db.collections();
		return collections.map(collection => new MongoCollectionTreeItem(collection));
	}

	public async createChild(_node: IAzureNode, showCreatingNode: (label: string) => void): Promise<IAzureTreeItem> {
		const collectionName = await vscode.window.showInputBox({
			placeHolder: "Collection Name",
			prompt: "Enter the name of the collection",
			validateInput: validateMongoCollectionName,
			ignoreFocusOut: true
		});

		if (collectionName) {
			showCreatingNode(collectionName);
			return await this.createCollection(collectionName);
		}

		throw new UserCancelledError();
	}

	public async deleteTreeItem(_node: IAzureNode): Promise<void> {
		const message: string = `Are you sure you want to delete database '${this.label}'?`;
		const result = await vscode.window.showWarningMessage(message, DialogBoxResponses.Yes, DialogBoxResponses.Cancel);
		if (result === DialogBoxResponses.Yes) {
			const db = await this.getDb();
			await db.dropDatabase();
		} else {
			throw new UserCancelledError();
		}
	}

	public async getDb(): Promise<Db> {
		const accountConnection = await MongoClient.connect(this.connectionString);
		return accountConnection.db(this.databaseName);
	}

	executeCommand(command: MongoCommand): Thenable<string> {
		if (command.collection) {
			return this.getDb()
				.then(db => {
					const collection = db.collection(command.collection);
					if (collection) {
						const result = new MongoCollectionTreeItem(collection, command.arguments).executeCommand(command.name, command.arguments);
						if (result) {
							return result;
						}
					}
					return reportProgress(this.executeCommandInShell(command), 'Executing command');
				});
		}

		if (command.name === 'createCollection') {
			return reportProgress(this.createCollection(stripQuotes(command.arguments)).then(() => JSON.stringify({ 'Created': 'Ok' })), 'Creating collection');
		} else {
			return reportProgress(this.executeCommandInShell(command), 'Executing command');
		}
	}

	async createCollection(collectionName: string): Promise<MongoCollectionTreeItem> {
		const db: Db = await this.getDb();
		const newCollection: Collection = db.collection(collectionName);
		// db.createCollection() doesn't create empty collections for some reason
		// However, we can 'insert' and then 'delete' a document, which has the side-effect of creating an empty collection
		const result = await newCollection.insertOne({});
		await newCollection.deleteOne({ _id: result.insertedId });
		return new MongoCollectionTreeItem(newCollection);
	}

	executeCommandInShell(command: MongoCommand): Thenable<string> {
		outputChannel.appendLine(`Running command in Mongo shell: "${command.text}"...`);

		return this.getShell().then(shell => shell.exec(command.text));
	}

	private async validateMongoShellPath(path: string): Promise<boolean> {
		// We can't simply check if the file exists, because it may consist of arguments, or be a docker exec etc. ("docker exec -it mongodb mongo")
		try {
			let output = await cpUtils.executeCommand(outputChannel, undefined, path);
			return !!output.match(/^MongoDB shell/);
		} catch (error) {
			return false;
		}
	}

	private async getShell(): Promise<Shell> {
		let shellPath = <string>vscode.workspace.getConfiguration().get(mongoShellPathSettingKey)

		if (!shellPath) {
			let userValue = await vscode.window.showInputBox({
				prompt: `Specify the full path to the mongo shell executable (this value can be changed later via the VS Code setting '${mongoShellPathSettingKey}')`,
				ignoreFocusOut: true
			});
			try {
				let stats: fse.Stats = await fse.stat(userValue);
				const mongoExe = os.platform().startsWith('win') ? "mongo.exe" : "mongo";
				if (stats.isDirectory()) {
					// Automatically add the executable name to the folder
					userValue = path.join(userValue, mongoExe);
				}
			}
			catch (error) {
				// ignore
			}

			if (!(await this.validateMongoShellPath(userValue))) {
				if (DialogBoxResponses.Yes !== await vscode.window.showWarningMessage(
					`The location "${userValue}" does not appear to point to a valid executable file. Do you still want to use this location for the mongo shell executable?`,
					DialogBoxResponses.Yes, DialogBoxResponses.Cancel)) {
					throw new UserCancelledError();
				}
			}

			vscode.workspace.getConfiguration().update(mongoShellPathSettingKey, userValue, true);
			shellPath = userValue;
		}

		if (await this.validateMongoShellPath(shellPath)) {
			vscode.window.showWarningMessage('yes');
		} else {
			vscode.window.showWarningMessage('no')
		}

		return await this.createShell(shellPath);
	}

	private async createShell(shellPath: string): Promise<Shell> {
		return <Promise<null>>Shell.create(shellPath, this.connectionString)
			.then(
				shell => {
					return shell.useDatabase(this.databaseName).then(() => shell);
				},
				error => vscode.window.showErrorMessage(error));
	}
}

export function validateMongoCollectionName(collectionName: string): string | undefined | null {
	// https://docs.mongodb.com/manual/reference/limits/#Restriction-on-Collection-Names
	if (!collectionName) {
		return "Collection name cannot be empty";
	}
	const systemPrefix = "system."
	if (collectionName.startsWith(systemPrefix)) {
		return `"${systemPrefix}" prefix is reserved for internal use`;
	}
	if (/[$]/.test(collectionName)) {
		return "Collection name cannot contain $";
	}
	return undefined;
}

function reportProgress<T>(promise: Thenable<T>, title: string): Thenable<T> {
	return vscode.window.withProgress<T>(
		{
			location: vscode.ProgressLocation.Window,
			title
		},
		(progress) => {
			return promise;
		})
}

function stripQuotes(term: string): string {
	if ((term.startsWith('\'') && term.endsWith('\''))
		|| (term.startsWith('"') && term.endsWith('"'))) {
		return term.substring(1, term.length - 1);
	}
	return term;
}
