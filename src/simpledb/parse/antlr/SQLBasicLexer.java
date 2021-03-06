package simpledb.parse.antlr; 
// Generated from .\simpledb\parse\antlr\SQLBasic.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SQLBasicLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		COMPARATOR=10, STRINGCONSTANT=11, FLOATCONTENTS=12, POSITIVE_INT=13, PLUS_OR_MINUS=14, 
		K_ABORT=15, K_ACTION=16, K_ADD=17, K_AFTER=18, K_ALL=19, K_DISTINCT=20, 
		K_ALTER=21, K_ANALYZE=22, K_AND=23, K_AS=24, K_ASC=25, K_BY=26, K_DESC=27, 
		K_FOR=28, K_FROM=29, K_GROUP=30, K_HAVING=31, K_IN=32, K_IS=33, K_LIMIT=34, 
		K_NOT=35, K_NULL=36, K_OF=37, K_OFFSET=38, K_ON=39, K_OR=40, K_ORDER=41, 
		K_SELECT=42, K_TO=43, K_WHERE=44, K_WITH=45, K_NULLS=46, K_TOP=47, K_COUNT=48, 
		K_AVG=49, K_MAX=50, K_MIN=51, K_FIRST=52, K_LAST=53, K_SUM=54, IDENTIFIER=55, 
		SINGLE_LINE_COMMENT=56, MULTILINE_COMMENT=57, SPACES=58, UNEXPECTED_CHAR=59;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"COMPARATOR", "STRINGCONSTANT", "FLOATCONTENTS", "POSITIVE_INT", "PLUS_OR_MINUS", 
		"K_ABORT", "K_ACTION", "K_ADD", "K_AFTER", "K_ALL", "K_DISTINCT", "K_ALTER", 
		"K_ANALYZE", "K_AND", "K_AS", "K_ASC", "K_BY", "K_DESC", "K_FOR", "K_FROM", 
		"K_GROUP", "K_HAVING", "K_IN", "K_IS", "K_LIMIT", "K_NOT", "K_NULL", "K_OF", 
		"K_OFFSET", "K_ON", "K_OR", "K_ORDER", "K_SELECT", "K_TO", "K_WHERE", 
		"K_WITH", "K_NULLS", "K_TOP", "K_COUNT", "K_AVG", "K_MAX", "K_MIN", "K_FIRST", 
		"K_LAST", "K_SUM", "IDENTIFIER", "SINGLE_LINE_COMMENT", "MULTILINE_COMMENT", 
		"SPACES", "UNEXPECTED_CHAR", "DIGIT", "A", "B", "C", "D", "E", "F", "G", 
		"H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", 
		"V", "W", "X", "Y", "Z"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "','", "'*'", "'.'", "'('", "')'", "'`'", "'\"'", "'''"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "COMPARATOR", 
		"STRINGCONSTANT", "FLOATCONTENTS", "POSITIVE_INT", "PLUS_OR_MINUS", "K_ABORT", 
		"K_ACTION", "K_ADD", "K_AFTER", "K_ALL", "K_DISTINCT", "K_ALTER", "K_ANALYZE", 
		"K_AND", "K_AS", "K_ASC", "K_BY", "K_DESC", "K_FOR", "K_FROM", "K_GROUP", 
		"K_HAVING", "K_IN", "K_IS", "K_LIMIT", "K_NOT", "K_NULL", "K_OF", "K_OFFSET", 
		"K_ON", "K_OR", "K_ORDER", "K_SELECT", "K_TO", "K_WHERE", "K_WITH", "K_NULLS", 
		"K_TOP", "K_COUNT", "K_AVG", "K_MAX", "K_MIN", "K_FIRST", "K_LAST", "K_SUM", 
		"IDENTIFIER", "SINGLE_LINE_COMMENT", "MULTILINE_COMMENT", "SPACES", "UNEXPECTED_CHAR"
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
	  public void recover(RecognitionException ex) 
	  {
	    throw new RuntimeException(ex.getMessage()); 
	  }


	public SQLBasicLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SQLBasic.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2=\u020e\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b"+
		"\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13"+
		"\u00cb\n\13\3\f\3\f\3\f\3\f\7\f\u00d1\n\f\f\f\16\f\u00d4\13\f\3\f\3\f"+
		"\3\r\7\r\u00d9\n\r\f\r\16\r\u00dc\13\r\3\r\3\r\6\r\u00e0\n\r\r\r\16\r"+
		"\u00e1\3\16\6\16\u00e5\n\16\r\16\16\16\u00e6\3\17\3\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32"+
		"\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35"+
		"\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3"+
		" \3 \3 \3!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3%\3%\3%\3"+
		"%\3%\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3)\3)\3)\3*\3*\3*\3"+
		"*\3*\3*\3+\3+\3+\3+\3+\3+\3+\3,\3,\3,\3-\3-\3-\3-\3-\3-\3.\3.\3.\3.\3"+
		".\3/\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\61\3\61"+
		"\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\65\3\65"+
		"\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\38\3"+
		"8\78\u01b3\n8\f8\168\u01b6\138\39\39\39\39\79\u01bc\n9\f9\169\u01bf\13"+
		"9\39\39\3:\3:\3:\3:\7:\u01c7\n:\f:\16:\u01ca\13:\3:\3:\3:\5:\u01cf\n:"+
		"\3:\3:\3;\3;\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3A\3A\3B\3B\3C\3C\3D"+
		"\3D\3E\3E\3F\3F\3G\3G\3H\3H\3I\3I\3J\3J\3K\3K\3L\3L\3M\3M\3N\3N\3O\3O"+
		"\3P\3P\3Q\3Q\3R\3R\3S\3S\3T\3T\3U\3U\3V\3V\3W\3W\3\u01c8\2X\3\3\5\4\7"+
		"\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C"+
		"#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w"+
		"=y\2{\2}\2\177\2\u0081\2\u0083\2\u0085\2\u0087\2\u0089\2\u008b\2\u008d"+
		"\2\u008f\2\u0091\2\u0093\2\u0095\2\u0097\2\u0099\2\u009b\2\u009d\2\u009f"+
		"\2\u00a1\2\u00a3\2\u00a5\2\u00a7\2\u00a9\2\u00ab\2\u00ad\2\3\2#\3\2))"+
		"\4\2--//\5\2C\\aac|\6\2\62;C\\aac|\4\2\f\f\17\17\5\2\13\r\17\17\"\"\3"+
		"\2\62;\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2IIii\4\2JJj"+
		"j\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4\2"+
		"SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4"+
		"\2\\\\||\u01ff\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2"+
		"\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\2"+
		"9\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3"+
		"\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2"+
		"\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2"+
		"_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3"+
		"\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2"+
		"\2\3\u00af\3\2\2\2\5\u00b1\3\2\2\2\7\u00b3\3\2\2\2\t\u00b5\3\2\2\2\13"+
		"\u00b7\3\2\2\2\r\u00b9\3\2\2\2\17\u00bb\3\2\2\2\21\u00bd\3\2\2\2\23\u00bf"+
		"\3\2\2\2\25\u00ca\3\2\2\2\27\u00cc\3\2\2\2\31\u00da\3\2\2\2\33\u00e4\3"+
		"\2\2\2\35\u00e8\3\2\2\2\37\u00ea\3\2\2\2!\u00f0\3\2\2\2#\u00f7\3\2\2\2"+
		"%\u00fb\3\2\2\2\'\u0101\3\2\2\2)\u0105\3\2\2\2+\u010e\3\2\2\2-\u0114\3"+
		"\2\2\2/\u011c\3\2\2\2\61\u0120\3\2\2\2\63\u0123\3\2\2\2\65\u0127\3\2\2"+
		"\2\67\u012a\3\2\2\29\u012f\3\2\2\2;\u0133\3\2\2\2=\u0138\3\2\2\2?\u013e"+
		"\3\2\2\2A\u0145\3\2\2\2C\u0148\3\2\2\2E\u014b\3\2\2\2G\u0151\3\2\2\2I"+
		"\u0155\3\2\2\2K\u015a\3\2\2\2M\u015d\3\2\2\2O\u0164\3\2\2\2Q\u0167\3\2"+
		"\2\2S\u016a\3\2\2\2U\u0170\3\2\2\2W\u0177\3\2\2\2Y\u017a\3\2\2\2[\u0180"+
		"\3\2\2\2]\u0185\3\2\2\2_\u018b\3\2\2\2a\u018f\3\2\2\2c\u0195\3\2\2\2e"+
		"\u0199\3\2\2\2g\u019d\3\2\2\2i\u01a1\3\2\2\2k\u01a7\3\2\2\2m\u01ac\3\2"+
		"\2\2o\u01b0\3\2\2\2q\u01b7\3\2\2\2s\u01c2\3\2\2\2u\u01d2\3\2\2\2w\u01d6"+
		"\3\2\2\2y\u01d8\3\2\2\2{\u01da\3\2\2\2}\u01dc\3\2\2\2\177\u01de\3\2\2"+
		"\2\u0081\u01e0\3\2\2\2\u0083\u01e2\3\2\2\2\u0085\u01e4\3\2\2\2\u0087\u01e6"+
		"\3\2\2\2\u0089\u01e8\3\2\2\2\u008b\u01ea\3\2\2\2\u008d\u01ec\3\2\2\2\u008f"+
		"\u01ee\3\2\2\2\u0091\u01f0\3\2\2\2\u0093\u01f2\3\2\2\2\u0095\u01f4\3\2"+
		"\2\2\u0097\u01f6\3\2\2\2\u0099\u01f8\3\2\2\2\u009b\u01fa\3\2\2\2\u009d"+
		"\u01fc\3\2\2\2\u009f\u01fe\3\2\2\2\u00a1\u0200\3\2\2\2\u00a3\u0202\3\2"+
		"\2\2\u00a5\u0204\3\2\2\2\u00a7\u0206\3\2\2\2\u00a9\u0208\3\2\2\2\u00ab"+
		"\u020a\3\2\2\2\u00ad\u020c\3\2\2\2\u00af\u00b0\7=\2\2\u00b0\4\3\2\2\2"+
		"\u00b1\u00b2\7.\2\2\u00b2\6\3\2\2\2\u00b3\u00b4\7,\2\2\u00b4\b\3\2\2\2"+
		"\u00b5\u00b6\7\60\2\2\u00b6\n\3\2\2\2\u00b7\u00b8\7*\2\2\u00b8\f\3\2\2"+
		"\2\u00b9\u00ba\7+\2\2\u00ba\16\3\2\2\2\u00bb\u00bc\7b\2\2\u00bc\20\3\2"+
		"\2\2\u00bd\u00be\7$\2\2\u00be\22\3\2\2\2\u00bf\u00c0\7)\2\2\u00c0\24\3"+
		"\2\2\2\u00c1\u00cb\4>@\2\u00c2\u00c3\7>\2\2\u00c3\u00cb\7?\2\2\u00c4\u00c5"+
		"\7@\2\2\u00c5\u00cb\7?\2\2\u00c6\u00c7\7>\2\2\u00c7\u00cb\7@\2\2\u00c8"+
		"\u00c9\7#\2\2\u00c9\u00cb\7?\2\2\u00ca\u00c1\3\2\2\2\u00ca\u00c2\3\2\2"+
		"\2\u00ca\u00c4\3\2\2\2\u00ca\u00c6\3\2\2\2\u00ca\u00c8\3\2\2\2\u00cb\26"+
		"\3\2\2\2\u00cc\u00d2\7)\2\2\u00cd\u00d1\n\2\2\2\u00ce\u00cf\7)\2\2\u00cf"+
		"\u00d1\7)\2\2\u00d0\u00cd\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d1\u00d4\3\2"+
		"\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d5\3\2\2\2\u00d4"+
		"\u00d2\3\2\2\2\u00d5\u00d6\7)\2\2\u00d6\30\3\2\2\2\u00d7\u00d9\5y=\2\u00d8"+
		"\u00d7\3\2\2\2\u00d9\u00dc\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00db\3\2"+
		"\2\2\u00db\u00dd\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd\u00df\7\60\2\2\u00de"+
		"\u00e0\5y=\2\u00df\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00df\3\2\2"+
		"\2\u00e1\u00e2\3\2\2\2\u00e2\32\3\2\2\2\u00e3\u00e5\5y=\2\u00e4\u00e3"+
		"\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7"+
		"\34\3\2\2\2\u00e8\u00e9\t\3\2\2\u00e9\36\3\2\2\2\u00ea\u00eb\5{>\2\u00eb"+
		"\u00ec\5}?\2\u00ec\u00ed\5\u0097L\2\u00ed\u00ee\5\u009dO\2\u00ee\u00ef"+
		"\5\u00a1Q\2\u00ef \3\2\2\2\u00f0\u00f1\5{>\2\u00f1\u00f2\5\177@\2\u00f2"+
		"\u00f3\5\u00a1Q\2\u00f3\u00f4\5\u008bF\2\u00f4\u00f5\5\u0097L\2\u00f5"+
		"\u00f6\5\u0095K\2\u00f6\"\3\2\2\2\u00f7\u00f8\5{>\2\u00f8\u00f9\5\u0081"+
		"A\2\u00f9\u00fa\5\u0081A\2\u00fa$\3\2\2\2\u00fb\u00fc\5{>\2\u00fc\u00fd"+
		"\5\u0085C\2\u00fd\u00fe\5\u00a1Q\2\u00fe\u00ff\5\u0083B\2\u00ff\u0100"+
		"\5\u009dO\2\u0100&\3\2\2\2\u0101\u0102\5{>\2\u0102\u0103\5\u0091I\2\u0103"+
		"\u0104\5\u0091I\2\u0104(\3\2\2\2\u0105\u0106\5\u0081A\2\u0106\u0107\5"+
		"\u008bF\2\u0107\u0108\5\u009fP\2\u0108\u0109\5\u00a1Q\2\u0109\u010a\5"+
		"\u008bF\2\u010a\u010b\5\u0095K\2\u010b\u010c\5\177@\2\u010c\u010d\5\u00a1"+
		"Q\2\u010d*\3\2\2\2\u010e\u010f\5{>\2\u010f\u0110\5\u0091I\2\u0110\u0111"+
		"\5\u00a1Q\2\u0111\u0112\5\u0083B\2\u0112\u0113\5\u009dO\2\u0113,\3\2\2"+
		"\2\u0114\u0115\5{>\2\u0115\u0116\5\u0095K\2\u0116\u0117\5{>\2\u0117\u0118"+
		"\5\u0091I\2\u0118\u0119\5\u00abV\2\u0119\u011a\5\u00adW\2\u011a\u011b"+
		"\5\u0083B\2\u011b.\3\2\2\2\u011c\u011d\5{>\2\u011d\u011e\5\u0095K\2\u011e"+
		"\u011f\5\u0081A\2\u011f\60\3\2\2\2\u0120\u0121\5{>\2\u0121\u0122\5\u009f"+
		"P\2\u0122\62\3\2\2\2\u0123\u0124\5{>\2\u0124\u0125\5\u009fP\2\u0125\u0126"+
		"\5\177@\2\u0126\64\3\2\2\2\u0127\u0128\5}?\2\u0128\u0129\5\u00abV\2\u0129"+
		"\66\3\2\2\2\u012a\u012b\5\u0081A\2\u012b\u012c\5\u0083B\2\u012c\u012d"+
		"\5\u009fP\2\u012d\u012e\5\177@\2\u012e8\3\2\2\2\u012f\u0130\5\u0085C\2"+
		"\u0130\u0131\5\u0097L\2\u0131\u0132\5\u009dO\2\u0132:\3\2\2\2\u0133\u0134"+
		"\5\u0085C\2\u0134\u0135\5\u009dO\2\u0135\u0136\5\u0097L\2\u0136\u0137"+
		"\5\u0093J\2\u0137<\3\2\2\2\u0138\u0139\5\u0087D\2\u0139\u013a\5\u009d"+
		"O\2\u013a\u013b\5\u0097L\2\u013b\u013c\5\u00a3R\2\u013c\u013d\5\u0099"+
		"M\2\u013d>\3\2\2\2\u013e\u013f\5\u0089E\2\u013f\u0140\5{>\2\u0140\u0141"+
		"\5\u00a5S\2\u0141\u0142\5\u008bF\2\u0142\u0143\5\u0095K\2\u0143\u0144"+
		"\5\u0087D\2\u0144@\3\2\2\2\u0145\u0146\5\u008bF\2\u0146\u0147\5\u0095"+
		"K\2\u0147B\3\2\2\2\u0148\u0149\5\u008bF\2\u0149\u014a\5\u009fP\2\u014a"+
		"D\3\2\2\2\u014b\u014c\5\u0091I\2\u014c\u014d\5\u008bF\2\u014d\u014e\5"+
		"\u0093J\2\u014e\u014f\5\u008bF\2\u014f\u0150\5\u00a1Q\2\u0150F\3\2\2\2"+
		"\u0151\u0152\5\u0095K\2\u0152\u0153\5\u0097L\2\u0153\u0154\5\u00a1Q\2"+
		"\u0154H\3\2\2\2\u0155\u0156\5\u0095K\2\u0156\u0157\5\u00a3R\2\u0157\u0158"+
		"\5\u0091I\2\u0158\u0159\5\u0091I\2\u0159J\3\2\2\2\u015a\u015b\5\u0097"+
		"L\2\u015b\u015c\5\u0085C\2\u015cL\3\2\2\2\u015d\u015e\5\u0097L\2\u015e"+
		"\u015f\5\u0085C\2\u015f\u0160\5\u0085C\2\u0160\u0161\5\u009fP\2\u0161"+
		"\u0162\5\u0083B\2\u0162\u0163\5\u00a1Q\2\u0163N\3\2\2\2\u0164\u0165\5"+
		"\u0097L\2\u0165\u0166\5\u0095K\2\u0166P\3\2\2\2\u0167\u0168\5\u0097L\2"+
		"\u0168\u0169\5\u009dO\2\u0169R\3\2\2\2\u016a\u016b\5\u0097L\2\u016b\u016c"+
		"\5\u009dO\2\u016c\u016d\5\u0081A\2\u016d\u016e\5\u0083B\2\u016e\u016f"+
		"\5\u009dO\2\u016fT\3\2\2\2\u0170\u0171\5\u009fP\2\u0171\u0172\5\u0083"+
		"B\2\u0172\u0173\5\u0091I\2\u0173\u0174\5\u0083B\2\u0174\u0175\5\177@\2"+
		"\u0175\u0176\5\u00a1Q\2\u0176V\3\2\2\2\u0177\u0178\5\u00a1Q\2\u0178\u0179"+
		"\5\u0097L\2\u0179X\3\2\2\2\u017a\u017b\5\u00a7T\2\u017b\u017c\5\u0089"+
		"E\2\u017c\u017d\5\u0083B\2\u017d\u017e\5\u009dO\2\u017e\u017f\5\u0083"+
		"B\2\u017fZ\3\2\2\2\u0180\u0181\5\u00a7T\2\u0181\u0182\5\u008bF\2\u0182"+
		"\u0183\5\u00a1Q\2\u0183\u0184\5\u0089E\2\u0184\\\3\2\2\2\u0185\u0186\5"+
		"\u0095K\2\u0186\u0187\5\u00a3R\2\u0187\u0188\5\u0091I\2\u0188\u0189\5"+
		"\u0091I\2\u0189\u018a\5\u009fP\2\u018a^\3\2\2\2\u018b\u018c\5\u00a1Q\2"+
		"\u018c\u018d\5\u0097L\2\u018d\u018e\5\u0099M\2\u018e`\3\2\2\2\u018f\u0190"+
		"\5\177@\2\u0190\u0191\5\u0097L\2\u0191\u0192\5\u00a3R\2\u0192\u0193\5"+
		"\u0095K\2\u0193\u0194\5\u00a1Q\2\u0194b\3\2\2\2\u0195\u0196\5{>\2\u0196"+
		"\u0197\5\u00a5S\2\u0197\u0198\5\u0087D\2\u0198d\3\2\2\2\u0199\u019a\5"+
		"\u0093J\2\u019a\u019b\5{>\2\u019b\u019c\5\u00a9U\2\u019cf\3\2\2\2\u019d"+
		"\u019e\5\u0093J\2\u019e\u019f\5\u008bF\2\u019f\u01a0\5\u0095K\2\u01a0"+
		"h\3\2\2\2\u01a1\u01a2\5\u0085C\2\u01a2\u01a3\5\u008bF\2\u01a3\u01a4\5"+
		"\u009dO\2\u01a4\u01a5\5\u009fP\2\u01a5\u01a6\5\u00a1Q\2\u01a6j\3\2\2\2"+
		"\u01a7\u01a8\5\u0091I\2\u01a8\u01a9\5{>\2\u01a9\u01aa\5\u009fP\2\u01aa"+
		"\u01ab\5\u00a1Q\2\u01abl\3\2\2\2\u01ac\u01ad\5\u009fP\2\u01ad\u01ae\5"+
		"\u00a3R\2\u01ae\u01af\5\u0093J\2\u01afn\3\2\2\2\u01b0\u01b4\t\4\2\2\u01b1"+
		"\u01b3\t\5\2\2\u01b2\u01b1\3\2\2\2\u01b3\u01b6\3\2\2\2\u01b4\u01b2\3\2"+
		"\2\2\u01b4\u01b5\3\2\2\2\u01b5p\3\2\2\2\u01b6\u01b4\3\2\2\2\u01b7\u01b8"+
		"\7/\2\2\u01b8\u01b9\7/\2\2\u01b9\u01bd\3\2\2\2\u01ba\u01bc\n\6\2\2\u01bb"+
		"\u01ba\3\2\2\2\u01bc\u01bf\3\2\2\2\u01bd\u01bb\3\2\2\2\u01bd\u01be\3\2"+
		"\2\2\u01be\u01c0\3\2\2\2\u01bf\u01bd\3\2\2\2\u01c0\u01c1\b9\2\2\u01c1"+
		"r\3\2\2\2\u01c2\u01c3\7\61\2\2\u01c3\u01c4\7,\2\2\u01c4\u01c8\3\2\2\2"+
		"\u01c5\u01c7\13\2\2\2\u01c6\u01c5\3\2\2\2\u01c7\u01ca\3\2\2\2\u01c8\u01c9"+
		"\3\2\2\2\u01c8\u01c6\3\2\2\2\u01c9\u01ce\3\2\2\2\u01ca\u01c8\3\2\2\2\u01cb"+
		"\u01cc\7,\2\2\u01cc\u01cf\7\61\2\2\u01cd\u01cf\7\2\2\3\u01ce\u01cb\3\2"+
		"\2\2\u01ce\u01cd\3\2\2\2\u01cf\u01d0\3\2\2\2\u01d0\u01d1\b:\2\2\u01d1"+
		"t\3\2\2\2\u01d2\u01d3\t\7\2\2\u01d3\u01d4\3\2\2\2\u01d4\u01d5\b;\2\2\u01d5"+
		"v\3\2\2\2\u01d6\u01d7\13\2\2\2\u01d7x\3\2\2\2\u01d8\u01d9\t\b\2\2\u01d9"+
		"z\3\2\2\2\u01da\u01db\t\t\2\2\u01db|\3\2\2\2\u01dc\u01dd\t\n\2\2\u01dd"+
		"~\3\2\2\2\u01de\u01df\t\13\2\2\u01df\u0080\3\2\2\2\u01e0\u01e1\t\f\2\2"+
		"\u01e1\u0082\3\2\2\2\u01e2\u01e3\t\r\2\2\u01e3\u0084\3\2\2\2\u01e4\u01e5"+
		"\t\16\2\2\u01e5\u0086\3\2\2\2\u01e6\u01e7\t\17\2\2\u01e7\u0088\3\2\2\2"+
		"\u01e8\u01e9\t\20\2\2\u01e9\u008a\3\2\2\2\u01ea\u01eb\t\21\2\2\u01eb\u008c"+
		"\3\2\2\2\u01ec\u01ed\t\22\2\2\u01ed\u008e\3\2\2\2\u01ee\u01ef\t\23\2\2"+
		"\u01ef\u0090\3\2\2\2\u01f0\u01f1\t\24\2\2\u01f1\u0092\3\2\2\2\u01f2\u01f3"+
		"\t\25\2\2\u01f3\u0094\3\2\2\2\u01f4\u01f5\t\26\2\2\u01f5\u0096\3\2\2\2"+
		"\u01f6\u01f7\t\27\2\2\u01f7\u0098\3\2\2\2\u01f8\u01f9\t\30\2\2\u01f9\u009a"+
		"\3\2\2\2\u01fa\u01fb\t\31\2\2\u01fb\u009c\3\2\2\2\u01fc\u01fd\t\32\2\2"+
		"\u01fd\u009e\3\2\2\2\u01fe\u01ff\t\33\2\2\u01ff\u00a0\3\2\2\2\u0200\u0201"+
		"\t\34\2\2\u0201\u00a2\3\2\2\2\u0202\u0203\t\35\2\2\u0203\u00a4\3\2\2\2"+
		"\u0204\u0205\t\36\2\2\u0205\u00a6\3\2\2\2\u0206\u0207\t\37\2\2\u0207\u00a8"+
		"\3\2\2\2\u0208\u0209\t \2\2\u0209\u00aa\3\2\2\2\u020a\u020b\t!\2\2\u020b"+
		"\u00ac\3\2\2\2\u020c\u020d\t\"\2\2\u020d\u00ae\3\2\2\2\r\2\u00ca\u00d0"+
		"\u00d2\u00da\u00e1\u00e6\u01b4\u01bd\u01c8\u01ce\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}