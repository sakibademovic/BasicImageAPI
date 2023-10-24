// Generated from /Users/sakibademovic/Desktop/imageapi/src/main/java/com/example/imageapi/support/Filter.g4 by ANTLR 4.13.1
package com.example.imageapi.antlar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class FilterLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, ANDOPERATOR=4, OROPERATOR=5, OPERATOR=6, STRING=7, 
		LPAREN=8, RPAREN=9, WS=10;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "ANDOPERATOR", "OROPERATOR", "OPERATOR", "STRING", 
			"LPAREN", "RPAREN", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'tag'", "'author'", "'name'", "'and'", "'or'", null, null, "'('", 
			"')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "ANDOPERATOR", "OROPERATOR", "OPERATOR", "STRING", 
			"LPAREN", "RPAREN", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public FilterLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Filter.g4"; }

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

	public static final String _serializedATN =
		"\u0004\u0000\nN\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0003\u00059\b\u0005\u0001\u0006\u0001"+
		"\u0006\u0005\u0006=\b\u0006\n\u0006\f\u0006@\t\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0004\tI\b\t\u000b"+
		"\t\f\tJ\u0001\t\u0001\t\u0000\u0000\n\u0001\u0001\u0003\u0002\u0005\u0003"+
		"\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0001"+
		"\u0000\u0002\u0001\u0000\'\'\u0003\u0000\t\n\r\r  Q\u0000\u0001\u0001"+
		"\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001"+
		"\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000"+
		"\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000"+
		"\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000"+
		"\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0001\u0015\u0001\u0000\u0000"+
		"\u0000\u0003\u0019\u0001\u0000\u0000\u0000\u0005 \u0001\u0000\u0000\u0000"+
		"\u0007%\u0001\u0000\u0000\u0000\t)\u0001\u0000\u0000\u0000\u000b8\u0001"+
		"\u0000\u0000\u0000\r:\u0001\u0000\u0000\u0000\u000fC\u0001\u0000\u0000"+
		"\u0000\u0011E\u0001\u0000\u0000\u0000\u0013H\u0001\u0000\u0000\u0000\u0015"+
		"\u0016\u0005t\u0000\u0000\u0016\u0017\u0005a\u0000\u0000\u0017\u0018\u0005"+
		"g\u0000\u0000\u0018\u0002\u0001\u0000\u0000\u0000\u0019\u001a\u0005a\u0000"+
		"\u0000\u001a\u001b\u0005u\u0000\u0000\u001b\u001c\u0005t\u0000\u0000\u001c"+
		"\u001d\u0005h\u0000\u0000\u001d\u001e\u0005o\u0000\u0000\u001e\u001f\u0005"+
		"r\u0000\u0000\u001f\u0004\u0001\u0000\u0000\u0000 !\u0005n\u0000\u0000"+
		"!\"\u0005a\u0000\u0000\"#\u0005m\u0000\u0000#$\u0005e\u0000\u0000$\u0006"+
		"\u0001\u0000\u0000\u0000%&\u0005a\u0000\u0000&\'\u0005n\u0000\u0000\'"+
		"(\u0005d\u0000\u0000(\b\u0001\u0000\u0000\u0000)*\u0005o\u0000\u0000*"+
		"+\u0005r\u0000\u0000+\n\u0001\u0000\u0000\u0000,-\u0005e\u0000\u0000-"+
		"9\u0005q\u0000\u0000./\u0005n\u0000\u0000/9\u0005e\u0000\u000001\u0005"+
		"c\u0000\u000012\u0005o\u0000\u000023\u0005n\u0000\u000034\u0005t\u0000"+
		"\u000045\u0005a\u0000\u000056\u0005i\u0000\u000067\u0005n\u0000\u0000"+
		"79\u0005s\u0000\u00008,\u0001\u0000\u0000\u00008.\u0001\u0000\u0000\u0000"+
		"80\u0001\u0000\u0000\u00009\f\u0001\u0000\u0000\u0000:>\u0005\'\u0000"+
		"\u0000;=\b\u0000\u0000\u0000<;\u0001\u0000\u0000\u0000=@\u0001\u0000\u0000"+
		"\u0000><\u0001\u0000\u0000\u0000>?\u0001\u0000\u0000\u0000?A\u0001\u0000"+
		"\u0000\u0000@>\u0001\u0000\u0000\u0000AB\u0005\'\u0000\u0000B\u000e\u0001"+
		"\u0000\u0000\u0000CD\u0005(\u0000\u0000D\u0010\u0001\u0000\u0000\u0000"+
		"EF\u0005)\u0000\u0000F\u0012\u0001\u0000\u0000\u0000GI\u0007\u0001\u0000"+
		"\u0000HG\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000JH\u0001\u0000"+
		"\u0000\u0000JK\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000LM\u0006"+
		"\t\u0000\u0000M\u0014\u0001\u0000\u0000\u0000\u0004\u00008>J\u0001\u0006"+
		"\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}