/*---------------------------------------------------------------------------------------------
 *  Copyright (c) Microsoft Corporation. All rights reserved.
 *  Licensed under the MIT License. See License.txt in the project root for license information.
 *--------------------------------------------------------------------------------------------*/
import * as path from 'path';
import * as nls from 'vscode-nls';
import { ExtensionContext } from 'vscode';
import { LanguageClient, LanguageClientOptions, ServerOptions, TransportKind } from 'vscode-languageclient';

const localize = nls.loadMessageBundle();

export default class MongoDBLanguageClient {

	public client: LanguageClient;

	constructor(context: ExtensionContext) {
		// The server is implemented in node
		let serverModule = context.asAbsolutePath(path.join('out', 'src', 'mongo', 'languageServer.js'));
		// The debug options for the server
		let debugOptions = { execArgv: ['--nolazy', '--debug=6005', '--inspect'] };

		// If the extension is launch in debug mode the debug server options are use
		// Otherwise the run options are used
		let serverOptions: ServerOptions = {
			run: { module: serverModule, transport: TransportKind.ipc, options: debugOptions },
			debug: { module: serverModule, transport: TransportKind.ipc, options: debugOptions }
		};

		// Options to control the language client
		let clientOptions: LanguageClientOptions = {
			// Register the server for mongo javascript documents
			documentSelector: [
				{ language: 'mongo', scheme: 'file' },
				{ language: 'mongo', scheme: 'untitled' }
			],
		};

		// Create the language client and start the client.
		this.client = new LanguageClient('mongo', localize('mongo.server.name', 'Mongo Language Server'), serverOptions, clientOptions);
		let disposable = this.client.start();

		// Push the disposable to the context's subscriptions so that the
		// client can be deactivated on extension deactivation
		context.subscriptions.push(disposable);
	}

	async connect(connectionString: string, databaseName: string) {
		await this.client.sendRequest('connect', { connectionString: connectionString, databaseName: databaseName });
	}

	disconnect(): void {
		this.client.sendRequest('disconnect');
	}
}
