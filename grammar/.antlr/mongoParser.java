// Generated from c:\repo\vscode-cosmosdb\grammar\mongo.g4 by ANTLR 4.7.1

/*---------------------------------------------------------------------------------------------
 *  Copyright (c) Microsoft Corporation. All rights reserved.
 *  Licensed under the MIT License. See License.txt in the project root for license information.
 *--------------------------------------------------------------------------------------------*/

 /*tslint:disable */

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class mongoParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, SingleLineComment=9, 
		MultiLineComment=10, StringLiteral=11, NullLiteral=12, BooleanLiteral=13, 
		NumericLiteral=14, DecimalLiteral=15, LineTerminator=16, SEMICOLON=17, 
		DOT=18, DB=19, STRING_LITERAL=20, DOUBLE_QUOTED_STRING_LITERAL=21, SINGLE_QUOTED_STRING_LITERAL=22, 
		WHITESPACE=23;
	public static final int
		RULE_mongoCommands = 0, RULE_commands = 1, RULE_command = 2, RULE_emptyCommand = 3, 
		RULE_collection = 4, RULE_functionCall = 5, RULE_arguments = 6, RULE_argument = 7, 
		RULE_objectLiteral = 8, RULE_arrayLiteral = 9, RULE_elementList = 10, 
		RULE_propertyNameAndValueList = 11, RULE_propertyAssignment = 12, RULE_propertyValue = 13, 
		RULE_literal = 14, RULE_propertyName = 15, RULE_comment = 16;
	public static final String[] ruleNames = {
		"mongoCommands", "commands", "command", "emptyCommand", "collection", 
		"functionCall", "arguments", "argument", "objectLiteral", "arrayLiteral", 
		"elementList", "propertyNameAndValueList", "propertyAssignment", "propertyValue", 
		"literal", "propertyName", "comment"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "','", "')'", "'{'", "'}'", "'['", "']'", "':'", null, null, 
		null, "'null'", null, null, null, null, "';'", "'.'", "'db'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, "SingleLineComment", 
		"MultiLineComment", "StringLiteral", "NullLiteral", "BooleanLiteral", 
		"NumericLiteral", "DecimalLiteral", "LineTerminator", "SEMICOLON", "DOT", 
		"DB", "STRING_LITERAL", "DOUBLE_QUOTED_STRING_LITERAL", "SINGLE_QUOTED_STRING_LITERAL", 
		"WHITESPACE"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "mongo.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public mongoParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class MongoCommandsContext extends ParserRuleContext {
		public CommandsContext commands() {
			return getRuleContext(CommandsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(mongoParser.EOF, 0); }
		public MongoCommandsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mongoCommands; }
	}

	public final MongoCommandsContext mongoCommands() throws RecognitionException {
		MongoCommandsContext _localctx = new MongoCommandsContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_mongoCommands);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			commands();
			setState(35);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CommandsContext extends ParserRuleContext {
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
		}
		public List<EmptyCommandContext> emptyCommand() {
			return getRuleContexts(EmptyCommandContext.class);
		}
		public EmptyCommandContext emptyCommand(int i) {
			return getRuleContext(EmptyCommandContext.class,i);
		}
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public CommandsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commands; }
	}

	public final CommandsContext commands() throws RecognitionException {
		CommandsContext _localctx = new CommandsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_commands);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(40);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DB:
					{
					setState(37);
					command();
					}
					break;
				case SEMICOLON:
					{
					setState(38);
					emptyCommand();
					}
					break;
				case SingleLineComment:
				case MultiLineComment:
					{
					setState(39);
					comment();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(42); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SingleLineComment) | (1L << MultiLineComment) | (1L << SEMICOLON) | (1L << DB))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CommandContext extends ParserRuleContext {
		public TerminalNode DB() { return getToken(mongoParser.DB, 0); }
		public List<TerminalNode> DOT() { return getTokens(mongoParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(mongoParser.DOT, i);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(mongoParser.SEMICOLON, 0); }
		public CollectionContext collection() {
			return getRuleContext(CollectionContext.class,0);
		}
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_command);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(DB);
			setState(45);
			match(DOT);
			setState(51);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(46);
				functionCall();
				}
				break;
			case 2:
				{
				{
				setState(47);
				collection();
				setState(48);
				match(DOT);
				setState(49);
				functionCall();
				}
				}
				break;
			}
			setState(54);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(53);
				match(SEMICOLON);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EmptyCommandContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(mongoParser.SEMICOLON, 0); }
		public EmptyCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emptyCommand; }
	}

	public final EmptyCommandContext emptyCommand() throws RecognitionException {
		EmptyCommandContext _localctx = new EmptyCommandContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_emptyCommand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CollectionContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL() { return getToken(mongoParser.STRING_LITERAL, 0); }
		public CollectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_collection; }
	}

	public final CollectionContext collection() throws RecognitionException {
		CollectionContext _localctx = new CollectionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_collection);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(STRING_LITERAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionCallContext extends ParserRuleContext {
		public Token FUNCTION_NAME;
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode STRING_LITERAL() { return getToken(mongoParser.STRING_LITERAL, 0); }
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_functionCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			((FunctionCallContext)_localctx).FUNCTION_NAME = match(STRING_LITERAL);
			setState(61);
			arguments();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentsContext extends ParserRuleContext {
		public Token OPEN_PARENTHESIS;
		public Token CLOSED_PARENTHESIS;
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			((ArgumentsContext)_localctx).OPEN_PARENTHESIS = match(T__0);
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__5) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << BooleanLiteral) | (1L << NumericLiteral))) != 0)) {
				{
				setState(64);
				argument();
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(65);
					match(T__1);
					setState(66);
					argument();
					}
					}
					setState(71);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(74);
			((ArgumentsContext)_localctx).CLOSED_PARENTHESIS = match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public ObjectLiteralContext objectLiteral() {
			return getRuleContext(ObjectLiteralContext.class,0);
		}
		public ArrayLiteralContext arrayLiteral() {
			return getRuleContext(ArrayLiteralContext.class,0);
		}
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_argument);
		try {
			setState(79);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case StringLiteral:
			case NullLiteral:
			case BooleanLiteral:
			case NumericLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				literal();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
				objectLiteral();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 3);
				{
				setState(78);
				arrayLiteral();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjectLiteralContext extends ParserRuleContext {
		public PropertyNameAndValueListContext propertyNameAndValueList() {
			return getRuleContext(PropertyNameAndValueListContext.class,0);
		}
		public ObjectLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectLiteral; }
	}

	public final ObjectLiteralContext objectLiteral() throws RecognitionException {
		ObjectLiteralContext _localctx = new ObjectLiteralContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_objectLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(T__3);
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==StringLiteral) {
				{
				setState(82);
				propertyNameAndValueList();
				}
			}

			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(85);
				match(T__1);
				}
			}

			setState(88);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayLiteralContext extends ParserRuleContext {
		public ElementListContext elementList() {
			return getRuleContext(ElementListContext.class,0);
		}
		public ArrayLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayLiteral; }
	}

	public final ArrayLiteralContext arrayLiteral() throws RecognitionException {
		ArrayLiteralContext _localctx = new ArrayLiteralContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_arrayLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(T__5);
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__5) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << BooleanLiteral) | (1L << NumericLiteral) | (1L << STRING_LITERAL))) != 0)) {
				{
				setState(91);
				elementList();
				}
			}

			setState(94);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElementListContext extends ParserRuleContext {
		public List<PropertyValueContext> propertyValue() {
			return getRuleContexts(PropertyValueContext.class);
		}
		public PropertyValueContext propertyValue(int i) {
			return getRuleContext(PropertyValueContext.class,i);
		}
		public ElementListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementList; }
	}

	public final ElementListContext elementList() throws RecognitionException {
		ElementListContext _localctx = new ElementListContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_elementList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			propertyValue();
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(97);
				match(T__1);
				setState(98);
				propertyValue();
				}
				}
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PropertyNameAndValueListContext extends ParserRuleContext {
		public List<PropertyAssignmentContext> propertyAssignment() {
			return getRuleContexts(PropertyAssignmentContext.class);
		}
		public PropertyAssignmentContext propertyAssignment(int i) {
			return getRuleContext(PropertyAssignmentContext.class,i);
		}
		public PropertyNameAndValueListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyNameAndValueList; }
	}

	public final PropertyNameAndValueListContext propertyNameAndValueList() throws RecognitionException {
		PropertyNameAndValueListContext _localctx = new PropertyNameAndValueListContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_propertyNameAndValueList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			propertyAssignment();
			setState(109);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(105);
					match(T__1);
					setState(106);
					propertyAssignment();
					}
					} 
				}
				setState(111);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PropertyAssignmentContext extends ParserRuleContext {
		public PropertyNameContext propertyName() {
			return getRuleContext(PropertyNameContext.class,0);
		}
		public PropertyValueContext propertyValue() {
			return getRuleContext(PropertyValueContext.class,0);
		}
		public PropertyAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyAssignment; }
	}

	public final PropertyAssignmentContext propertyAssignment() throws RecognitionException {
		PropertyAssignmentContext _localctx = new PropertyAssignmentContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_propertyAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			propertyName();
			setState(113);
			match(T__7);
			setState(114);
			propertyValue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PropertyValueContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public ObjectLiteralContext objectLiteral() {
			return getRuleContext(ObjectLiteralContext.class,0);
		}
		public ArrayLiteralContext arrayLiteral() {
			return getRuleContext(ArrayLiteralContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public PropertyValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyValue; }
	}

	public final PropertyValueContext propertyValue() throws RecognitionException {
		PropertyValueContext _localctx = new PropertyValueContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_propertyValue);
		try {
			setState(120);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case StringLiteral:
			case NullLiteral:
			case BooleanLiteral:
			case NumericLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(116);
				literal();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(117);
				objectLiteral();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 3);
				{
				setState(118);
				arrayLiteral();
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(119);
				functionCall();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode NullLiteral() { return getToken(mongoParser.NullLiteral, 0); }
		public TerminalNode BooleanLiteral() { return getToken(mongoParser.BooleanLiteral, 0); }
		public TerminalNode StringLiteral() { return getToken(mongoParser.StringLiteral, 0); }
		public TerminalNode NumericLiteral() { return getToken(mongoParser.NumericLiteral, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_literal);
		int _la;
		try {
			setState(124);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case StringLiteral:
			case NullLiteral:
			case BooleanLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(122);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << StringLiteral) | (1L << NullLiteral) | (1L << BooleanLiteral))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case NumericLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(123);
				match(NumericLiteral);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PropertyNameContext extends ParserRuleContext {
		public TerminalNode StringLiteral() { return getToken(mongoParser.StringLiteral, 0); }
		public PropertyNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyName; }
	}

	public final PropertyNameContext propertyName() throws RecognitionException {
		PropertyNameContext _localctx = new PropertyNameContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_propertyName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(StringLiteral);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CommentContext extends ParserRuleContext {
		public TerminalNode SingleLineComment() { return getToken(mongoParser.SingleLineComment, 0); }
		public TerminalNode MultiLineComment() { return getToken(mongoParser.MultiLineComment, 0); }
		public CommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment; }
	}

	public final CommentContext comment() throws RecognitionException {
		CommentContext _localctx = new CommentContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_comment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			_la = _input.LA(1);
			if ( !(_la==SingleLineComment || _la==MultiLineComment) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\31\u0085\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\2\3\3\3\3\3\3\6\3+\n\3\r\3\16\3,\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\5\4\66\n\4\3\4\5\49\n\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b"+
		"\7\bF\n\b\f\b\16\bI\13\b\5\bK\n\b\3\b\3\b\3\t\3\t\3\t\5\tR\n\t\3\n\3\n"+
		"\5\nV\n\n\3\n\5\nY\n\n\3\n\3\n\3\13\3\13\5\13_\n\13\3\13\3\13\3\f\3\f"+
		"\3\f\7\ff\n\f\f\f\16\fi\13\f\3\r\3\r\3\r\7\rn\n\r\f\r\16\rq\13\r\3\16"+
		"\3\16\3\16\3\16\3\17\3\17\3\17\3\17\5\17{\n\17\3\20\3\20\5\20\177\n\20"+
		"\3\21\3\21\3\22\3\22\3\22\2\2\23\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"\2\4\3\2\r\17\3\2\13\f\2\u0085\2$\3\2\2\2\4*\3\2\2\2\6.\3\2\2\2\b:"+
		"\3\2\2\2\n<\3\2\2\2\f>\3\2\2\2\16A\3\2\2\2\20Q\3\2\2\2\22S\3\2\2\2\24"+
		"\\\3\2\2\2\26b\3\2\2\2\30j\3\2\2\2\32r\3\2\2\2\34z\3\2\2\2\36~\3\2\2\2"+
		" \u0080\3\2\2\2\"\u0082\3\2\2\2$%\5\4\3\2%&\7\2\2\3&\3\3\2\2\2\'+\5\6"+
		"\4\2(+\5\b\5\2)+\5\"\22\2*\'\3\2\2\2*(\3\2\2\2*)\3\2\2\2+,\3\2\2\2,*\3"+
		"\2\2\2,-\3\2\2\2-\5\3\2\2\2./\7\25\2\2/\65\7\24\2\2\60\66\5\f\7\2\61\62"+
		"\5\n\6\2\62\63\7\24\2\2\63\64\5\f\7\2\64\66\3\2\2\2\65\60\3\2\2\2\65\61"+
		"\3\2\2\2\668\3\2\2\2\679\7\23\2\28\67\3\2\2\289\3\2\2\29\7\3\2\2\2:;\7"+
		"\23\2\2;\t\3\2\2\2<=\7\26\2\2=\13\3\2\2\2>?\7\26\2\2?@\5\16\b\2@\r\3\2"+
		"\2\2AJ\7\3\2\2BG\5\20\t\2CD\7\4\2\2DF\5\20\t\2EC\3\2\2\2FI\3\2\2\2GE\3"+
		"\2\2\2GH\3\2\2\2HK\3\2\2\2IG\3\2\2\2JB\3\2\2\2JK\3\2\2\2KL\3\2\2\2LM\7"+
		"\5\2\2M\17\3\2\2\2NR\5\36\20\2OR\5\22\n\2PR\5\24\13\2QN\3\2\2\2QO\3\2"+
		"\2\2QP\3\2\2\2R\21\3\2\2\2SU\7\6\2\2TV\5\30\r\2UT\3\2\2\2UV\3\2\2\2VX"+
		"\3\2\2\2WY\7\4\2\2XW\3\2\2\2XY\3\2\2\2YZ\3\2\2\2Z[\7\7\2\2[\23\3\2\2\2"+
		"\\^\7\b\2\2]_\5\26\f\2^]\3\2\2\2^_\3\2\2\2_`\3\2\2\2`a\7\t\2\2a\25\3\2"+
		"\2\2bg\5\34\17\2cd\7\4\2\2df\5\34\17\2ec\3\2\2\2fi\3\2\2\2ge\3\2\2\2g"+
		"h\3\2\2\2h\27\3\2\2\2ig\3\2\2\2jo\5\32\16\2kl\7\4\2\2ln\5\32\16\2mk\3"+
		"\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2p\31\3\2\2\2qo\3\2\2\2rs\5 \21\2s"+
		"t\7\n\2\2tu\5\34\17\2u\33\3\2\2\2v{\5\36\20\2w{\5\22\n\2x{\5\24\13\2y"+
		"{\5\f\7\2zv\3\2\2\2zw\3\2\2\2zx\3\2\2\2zy\3\2\2\2{\35\3\2\2\2|\177\t\2"+
		"\2\2}\177\7\20\2\2~|\3\2\2\2~}\3\2\2\2\177\37\3\2\2\2\u0080\u0081\7\r"+
		"\2\2\u0081!\3\2\2\2\u0082\u0083\t\3\2\2\u0083#\3\2\2\2\20*,\658GJQUX^"+
		"goz~";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}