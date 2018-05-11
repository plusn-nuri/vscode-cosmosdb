/*---------------------------------------------------------------------------------------------
 *  Copyright (c) Microsoft Corporation. All rights reserved.
 *  Licensed under the MIT License. See License.txt in the project root for license information.
 *--------------------------------------------------------------------------------------------*/

import { ParseTree } from 'antlr4ts/tree/ParseTree';
import { TerminalNode } from 'antlr4ts/tree/TerminalNode';
import { ErrorNode } from 'antlr4ts/tree/ErrorNode';
import { ParserRuleContext } from 'antlr4ts/ParserRuleContext';
import { CommandsContext, CommandContext, FunctionCallContext, MongoCommandsContext, CollectionContext, ArgumentContext, ArgumentsContext } from './mongoParser';
import { mongoVisitor } from './mongoVisitor';

export class MongoVisitor<T> implements mongoVisitor<T> {

	visitMongoCommands(ctx: MongoCommandsContext): T {
		return this.visitChildren(ctx);
	}

	visitCommands(ctx: CommandsContext): T {
		return this.visitChildren(ctx);
	}

	visitCommand(ctx: CommandContext): T {
		return this.visitChildren(ctx);
	}

	visitCollection(ctx: CollectionContext): T {
		return this.visitChildren(ctx);
	}

	visitFunctionCall(ctx: FunctionCallContext): T {
		return this.visitChildren(ctx);
	}

	visitArgument(ctx: ArgumentContext): T {
		return this.visitChildren(ctx);
	}

	visitArguments(ctx: ArgumentsContext): T {
		return this.visitChildren(ctx);
	}

	visitArguments(ctx: ArgumentsContext): T {
		return this.visitChildren(ctx);
	}

	visit(tree: ParseTree): T {
		return tree.accept(this);
	}

	visitChildren(ctx: ParserRuleContext): T {
		var result = this.defaultResult(ctx);
		var n = ctx.childCount
		for (var i = 0; i < n; i++) {
			if (!this.shouldVisitNextChild(ctx, result)) {
				break;
			}

			var childNode = ctx.getChild(i);
			var childResult = childNode.accept(this);
			result = this.aggregateResult(result, childResult);
		}
		return result;
	}

	visitTerminal(node: TerminalNode): T {
		return this.defaultResult(node);
	}

	visitErrorNode(node: ErrorNode): T {
		throw new Error(`Error at line ${node._symbol.line}, from ${node.symbol.startIndex} to ${node.symbol.stopIndex}, near '${node.text}'. Please check syntax.`);
	}

	protected defaultResult(_node: ParseTree): T {
		return null;
	}

	protected aggregateResult(aggregate: T, nextResult: T): T {
		return nextResult === null ? aggregate : nextResult;
	}

	shouldVisitNextChild(_node, _currentResult: T): boolean {
		return true;
	}
}
