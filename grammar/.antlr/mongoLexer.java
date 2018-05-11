// Generated from c:\repo\vscode-cosmosdb\grammar\mongo.g4 by ANTLR 4.7.1

/*---------------------------------------------------------------------------------------------
 *  Copyright (c) Microsoft Corporation. All rights reserved.
 *  Licensed under the MIT License. See License.txt in the project root for license information.
 *--------------------------------------------------------------------------------------------*/

 /*tslint:disable */

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class mongoLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "SingleLineComment", 
		"MultiLineComment", "StringLiteral", "NullLiteral", "BooleanLiteral", 
		"NumericLiteral", "DecimalLiteral", "LineTerminator", "SEMICOLON", "DOT", 
		"DB", "STRING_LITERAL", "DOUBLE_QUOTED_STRING_LITERAL", "SINGLE_QUOTED_STRING_LITERAL", 
		"STRING_ESCAPE", "DecimalIntegerLiteral", "ExponentPart", "DecimalDigit", 
		"WHITESPACE"
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


		private isExternalIdentifierText(text) {
			return text === 'db';
		}


	public mongoLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "mongo.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 19:
			return STRING_LITERAL_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean STRING_LITERAL_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return !this.isExternalIdentifierText(this.text)
				;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\31\u00d8\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3"+
		"\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\7\nN\n\n\f\n\16\nQ\13\n"+
		"\3\n\3\n\3\13\3\13\3\13\3\13\7\13Y\n\13\f\13\16\13\\\13\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\f\3\f\5\fe\n\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\5\16u\n\16\3\17\5\17x\n\17\3\17\3\17\3\20\3"+
		"\20\3\20\7\20\177\n\20\f\20\16\20\u0082\13\20\3\20\5\20\u0085\n\20\3\20"+
		"\3\20\6\20\u0089\n\20\r\20\16\20\u008a\3\20\5\20\u008e\n\20\3\20\3\20"+
		"\5\20\u0092\n\20\5\20\u0094\n\20\3\21\3\21\3\21\3\21\3\22\3\22\3\23\3"+
		"\23\3\24\3\24\3\24\3\25\3\25\6\25\u00a3\n\25\r\25\16\25\u00a4\3\25\3\25"+
		"\3\26\3\26\3\26\7\26\u00ac\n\26\f\26\16\26\u00af\13\26\3\26\3\26\3\27"+
		"\3\27\3\27\7\27\u00b6\n\27\f\27\16\27\u00b9\13\27\3\27\3\27\3\30\3\30"+
		"\3\30\3\31\3\31\3\31\7\31\u00c3\n\31\f\31\16\31\u00c6\13\31\5\31\u00c8"+
		"\n\31\3\32\3\32\5\32\u00cc\n\32\3\32\6\32\u00cf\n\32\r\32\16\32\u00d0"+
		"\3\33\3\33\3\34\3\34\3\34\3\34\3Z\2\35\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\2\61\2\63\2\65\2\67\31\3\2\f\5\2\f\f\17\17\u202a\u202b\13\2\13\f\"\""+
		"$$*+.\60<=^^}}\177\177\4\2$$^^\4\2))^^\5\2$$))^^\3\2\63;\4\2GGgg\4\2-"+
		"-//\3\2\62;\4\2\13\13\"\"\2\u00e9\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2"+
		"\2\2+\3\2\2\2\2-\3\2\2\2\2\67\3\2\2\2\39\3\2\2\2\5;\3\2\2\2\7=\3\2\2\2"+
		"\t?\3\2\2\2\13A\3\2\2\2\rC\3\2\2\2\17E\3\2\2\2\21G\3\2\2\2\23I\3\2\2\2"+
		"\25T\3\2\2\2\27d\3\2\2\2\31f\3\2\2\2\33t\3\2\2\2\35w\3\2\2\2\37\u0093"+
		"\3\2\2\2!\u0095\3\2\2\2#\u0099\3\2\2\2%\u009b\3\2\2\2\'\u009d\3\2\2\2"+
		")\u00a2\3\2\2\2+\u00a8\3\2\2\2-\u00b2\3\2\2\2/\u00bc\3\2\2\2\61\u00c7"+
		"\3\2\2\2\63\u00c9\3\2\2\2\65\u00d2\3\2\2\2\67\u00d4\3\2\2\29:\7*\2\2:"+
		"\4\3\2\2\2;<\7.\2\2<\6\3\2\2\2=>\7+\2\2>\b\3\2\2\2?@\7}\2\2@\n\3\2\2\2"+
		"AB\7\177\2\2B\f\3\2\2\2CD\7]\2\2D\16\3\2\2\2EF\7_\2\2F\20\3\2\2\2GH\7"+
		"<\2\2H\22\3\2\2\2IJ\7\61\2\2JK\7\61\2\2KO\3\2\2\2LN\n\2\2\2ML\3\2\2\2"+
		"NQ\3\2\2\2OM\3\2\2\2OP\3\2\2\2PR\3\2\2\2QO\3\2\2\2RS\b\n\2\2S\24\3\2\2"+
		"\2TU\7\61\2\2UV\7,\2\2VZ\3\2\2\2WY\13\2\2\2XW\3\2\2\2Y\\\3\2\2\2Z[\3\2"+
		"\2\2ZX\3\2\2\2[]\3\2\2\2\\Z\3\2\2\2]^\7,\2\2^_\7\61\2\2_`\3\2\2\2`a\b"+
		"\13\2\2a\26\3\2\2\2be\5-\27\2ce\5+\26\2db\3\2\2\2dc\3\2\2\2e\30\3\2\2"+
		"\2fg\7p\2\2gh\7w\2\2hi\7n\2\2ij\7n\2\2j\32\3\2\2\2kl\7v\2\2lm\7t\2\2m"+
		"n\7w\2\2nu\7g\2\2op\7h\2\2pq\7c\2\2qr\7n\2\2rs\7u\2\2su\7g\2\2tk\3\2\2"+
		"\2to\3\2\2\2u\34\3\2\2\2vx\7/\2\2wv\3\2\2\2wx\3\2\2\2xy\3\2\2\2yz\5\37"+
		"\20\2z\36\3\2\2\2{|\5\61\31\2|\u0080\7\60\2\2}\177\5\65\33\2~}\3\2\2\2"+
		"\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0084\3\2"+
		"\2\2\u0082\u0080\3\2\2\2\u0083\u0085\5\63\32\2\u0084\u0083\3\2\2\2\u0084"+
		"\u0085\3\2\2\2\u0085\u0094\3\2\2\2\u0086\u0088\7\60\2\2\u0087\u0089\5"+
		"\65\33\2\u0088\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u0088\3\2\2\2\u008a"+
		"\u008b\3\2\2\2\u008b\u008d\3\2\2\2\u008c\u008e\5\63\32\2\u008d\u008c\3"+
		"\2\2\2\u008d\u008e\3\2\2\2\u008e\u0094\3\2\2\2\u008f\u0091\5\61\31\2\u0090"+
		"\u0092\5\63\32\2\u0091\u0090\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0094\3"+
		"\2\2\2\u0093{\3\2\2\2\u0093\u0086\3\2\2\2\u0093\u008f\3\2\2\2\u0094 \3"+
		"\2\2\2\u0095\u0096\t\2\2\2\u0096\u0097\3\2\2\2\u0097\u0098\b\21\2\2\u0098"+
		"\"\3\2\2\2\u0099\u009a\7=\2\2\u009a$\3\2\2\2\u009b\u009c\7\60\2\2\u009c"+
		"&\3\2\2\2\u009d\u009e\7f\2\2\u009e\u009f\7d\2\2\u009f(\3\2\2\2\u00a0\u00a3"+
		"\n\3\2\2\u00a1\u00a3\5/\30\2\u00a2\u00a0\3\2\2\2\u00a2\u00a1\3\2\2\2\u00a3"+
		"\u00a4\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6\3\2"+
		"\2\2\u00a6\u00a7\6\25\2\2\u00a7*\3\2\2\2\u00a8\u00ad\7$\2\2\u00a9\u00ac"+
		"\n\4\2\2\u00aa\u00ac\5/\30\2\u00ab\u00a9\3\2\2\2\u00ab\u00aa\3\2\2\2\u00ac"+
		"\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00b0\3\2"+
		"\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b1\7$\2\2\u00b1,\3\2\2\2\u00b2\u00b7"+
		"\7)\2\2\u00b3\u00b6\n\5\2\2\u00b4\u00b6\5/\30\2\u00b5\u00b3\3\2\2\2\u00b5"+
		"\u00b4\3\2\2\2\u00b6\u00b9\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2"+
		"\2\2\u00b8\u00ba\3\2\2\2\u00b9\u00b7\3\2\2\2\u00ba\u00bb\7)\2\2\u00bb"+
		".\3\2\2\2\u00bc\u00bd\7^\2\2\u00bd\u00be\t\6\2\2\u00be\60\3\2\2\2\u00bf"+
		"\u00c8\7\62\2\2\u00c0\u00c4\t\7\2\2\u00c1\u00c3\5\65\33\2\u00c2\u00c1"+
		"\3\2\2\2\u00c3\u00c6\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5"+
		"\u00c8\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c7\u00bf\3\2\2\2\u00c7\u00c0\3\2"+
		"\2\2\u00c8\62\3\2\2\2\u00c9\u00cb\t\b\2\2\u00ca\u00cc\t\t\2\2\u00cb\u00ca"+
		"\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00ce\3\2\2\2\u00cd\u00cf\5\65\33\2"+
		"\u00ce\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1"+
		"\3\2\2\2\u00d1\64\3\2\2\2\u00d2\u00d3\t\n\2\2\u00d3\66\3\2\2\2\u00d4\u00d5"+
		"\t\13\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d7\b\34\3\2\u00d78\3\2\2\2\30\2"+
		"OZdtw\u0080\u0084\u008a\u008d\u0091\u0093\u00a2\u00a4\u00ab\u00ad\u00b5"+
		"\u00b7\u00c4\u00c7\u00cb\u00d0\4\2\3\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}