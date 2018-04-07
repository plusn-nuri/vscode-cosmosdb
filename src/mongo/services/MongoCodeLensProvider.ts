/*---------------------------------------------------------------------------------------------
 *  Copyright (c) Microsoft Corporation. All rights reserved.
 *  Licensed under the MIT License. See License.txt in the project root for license information.
 *--------------------------------------------------------------------------------------------*/

import * as vscode from "vscode";
import { MongoCommands } from "../MongoCommands";

//import { CodeLensProvider, Position, Range, TextDocument, ProviderResult } from "vscode";

export class MongoCodeLensProvider implements vscode.CodeLensProvider {
	public provideCodeLenses(document: vscode.TextDocument, token: vscode.CancellationToken): vscode.ProviderResult<vscode.CodeLens[]> {
		let lenses: vscode.CodeLens[] = [];

		lenses.push(<vscode.CodeLens>{
			command: {
				title: "Run all",
				command: 'cosmosDB.executeAllMongoCommands'
			},
			range: new vscode.Range(new vscode.Position(0, 0), new vscode.Position(0, 0))
		});

		let commands = MongoCommands.getAllCommandsFromTextDocument(document)
		for (let command of commands) {
			lenses.push(<vscode.CodeLens>{
				command: {
					title: "Run",
					command: 'cosmosDB.executeMongoCommand'
				},
				range: command.range
			});
		}

		return lenses;
	}
}
