package simpledb.parse.antlr; 
// Generated from .\simpledb\parse\antlr\SQLBasic.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SQLBasicParser extends Parser {
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
	public static final int
		RULE_parse = 0, RULE_error = 1, RULE_select = 2, RULE_optional_top_term = 3, 
		RULE_distinct_or_all = 4, RULE_selectexpressions = 5, RULE_selectexpression = 6, 
		RULE_simpleselectexpression = 7, RULE_aggregateselectexpression = 8, RULE_aggregation = 9, 
		RULE_fromexpressions = 10, RULE_fromexpression = 11, RULE_subqueryfromexpression = 12, 
		RULE_name = 13, RULE_fullname = 14, RULE_optional_where_expression = 15, 
		RULE_optional_group_by_expression = 16, RULE_grouplist = 17, RULE_optional_having_expression = 18, 
		RULE_optional_order_by_expression = 19, RULE_sort_order = 20, RULE_null_order = 21, 
		RULE_optional_limit_expression = 22, RULE_optional_offset_expression = 23, 
		RULE_expression = 24, RULE_andcondition = 25, RULE_condition = 26, RULE_operand = 27, 
		RULE_constant = 28, RULE_intconstant = 29, RULE_floatconstant = 30, RULE_as_alias_expression = 31, 
		RULE_nothing = 32, RULE_unmatchable = 33;
	public static final String[] ruleNames = {
		"parse", "error", "select", "optional_top_term", "distinct_or_all", "selectexpressions", 
		"selectexpression", "simpleselectexpression", "aggregateselectexpression", 
		"aggregation", "fromexpressions", "fromexpression", "subqueryfromexpression", 
		"name", "fullname", "optional_where_expression", "optional_group_by_expression", 
		"grouplist", "optional_having_expression", "optional_order_by_expression", 
		"sort_order", "null_order", "optional_limit_expression", "optional_offset_expression", 
		"expression", "andcondition", "condition", "operand", "constant", "intconstant", 
		"floatconstant", "as_alias_expression", "nothing", "unmatchable"
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
	public String getGrammarFileName() { return "SQLBasic.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	  @Override
	  public void notifyErrorListeners(Token offendingToken, String msg, RecognitionException ex)
	  {
	    throw new RuntimeException(msg); 
	  }

	public SQLBasicParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ParseContext extends ParserRuleContext {
		public SelectContext select() {
			return getRuleContext(SelectContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SQLBasicParser.EOF, 0); }
		public List<ErrorContext> error() {
			return getRuleContexts(ErrorContext.class);
		}
		public ErrorContext error(int i) {
			return getRuleContext(ErrorContext.class,i);
		}
		public ParseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).enterParse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).exitParse(this);
		}
	}

	public final ParseContext parse() throws RecognitionException {
		ParseContext _localctx = new ParseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parse);
		int _la;
		try {
			setState(79);
			switch (_input.LA(1)) {
			case K_SELECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				select();
				setState(69);
				match(T__0);
				setState(70);
				match(EOF);
				}
				break;
			case EOF:
			case UNEXPECTED_CHAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==UNEXPECTED_CHAR) {
					{
					{
					setState(72);
					error();
					}
					}
					setState(77);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(78);
				match(EOF);
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

	public static class ErrorContext extends ParserRuleContext {
		public Token UNEXPECTED_CHAR;
		public TerminalNode UNEXPECTED_CHAR() { return getToken(SQLBasicParser.UNEXPECTED_CHAR, 0); }
		public ErrorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_error; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).enterError(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).exitError(this);
		}
	}

	public final ErrorContext error() throws RecognitionException {
		ErrorContext _localctx = new ErrorContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_error);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			((ErrorContext)_localctx).UNEXPECTED_CHAR = match(UNEXPECTED_CHAR);
			 throw new RuntimeException("UNEXPECTED_CHAR=" + (((ErrorContext)_localctx).UNEXPECTED_CHAR!=null?((ErrorContext)_localctx).UNEXPECTED_CHAR.getText():null)); 
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

	public static class SelectContext extends ParserRuleContext {
		public TerminalNode K_SELECT() { return getToken(SQLBasicParser.K_SELECT, 0); }
		public SelectexpressionsContext selectexpressions() {
			return getRuleContext(SelectexpressionsContext.class,0);
		}
		public TerminalNode K_FROM() { return getToken(SQLBasicParser.K_FROM, 0); }
		public FromexpressionsContext fromexpressions() {
			return getRuleContext(FromexpressionsContext.class,0);
		}
		public Optional_top_termContext optional_top_term() {
			return getRuleContext(Optional_top_termContext.class,0);
		}
		public Distinct_or_allContext distinct_or_all() {
			return getRuleContext(Distinct_or_allContext.class,0);
		}
		public Optional_where_expressionContext optional_where_expression() {
			return getRuleContext(Optional_where_expressionContext.class,0);
		}
		public Optional_group_by_expressionContext optional_group_by_expression() {
			return getRuleContext(Optional_group_by_expressionContext.class,0);
		}
		public Optional_having_expressionContext optional_having_expression() {
			return getRuleContext(Optional_having_expressionContext.class,0);
		}
		public Optional_order_by_expressionContext optional_order_by_expression() {
			return getRuleContext(Optional_order_by_expressionContext.class,0);
		}
		public Optional_limit_expressionContext optional_limit_expression() {
			return getRuleContext(Optional_limit_expressionContext.class,0);
		}
		public Optional_offset_expressionContext optional_offset_expression() {
			return getRuleContext(Optional_offset_expressionContext.class,0);
		}
		public SelectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).enterSelect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).exitSelect(this);
		}
	}

	public final SelectContext select() throws RecognitionException {
		SelectContext _localctx = new SelectContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_select);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(K_SELECT);
			setState(86);
			_la = _input.LA(1);
			if (_la==K_TOP) {
				{
				setState(85);
				optional_top_term();
				}
			}

			setState(89);
			_la = _input.LA(1);
			if (_la==K_ALL || _la==K_DISTINCT) {
				{
				setState(88);
				distinct_or_all();
				}
			}

			setState(91);
			selectexpressions();
			setState(92);
			match(K_FROM);
			setState(93);
			fromexpressions();
			setState(95);
			_la = _input.LA(1);
			if (_la==K_WHERE) {
				{
				setState(94);
				optional_where_expression();
				}
			}

			setState(98);
			_la = _input.LA(1);
			if (_la==K_GROUP) {
				{
				setState(97);
				optional_group_by_expression();
				}
			}

			setState(101);
			_la = _input.LA(1);
			if (_la==K_HAVING) {
				{
				setState(100);
				optional_having_expression();
				}
			}

			setState(104);
			_la = _input.LA(1);
			if (_la==K_ORDER) {
				{
				setState(103);
				optional_order_by_expression();
				}
			}

			setState(107);
			_la = _input.LA(1);
			if (_la==K_LIMIT) {
				{
				setState(106);
				optional_limit_expression();
				}
			}

			setState(110);
			_la = _input.LA(1);
			if (_la==EOF) {
				{
				setState(109);
				optional_offset_expression();
				}
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

	public static class Optional_top_termContext extends ParserRuleContext {
		public TerminalNode K_TOP() { return getToken(SQLBasicParser.K_TOP, 0); }
		public TerminalNode POSITIVE_INT() { return getToken(SQLBasicParser.POSITIVE_INT, 0); }
		public Optional_top_termContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optional_top_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).enterOptional_top_term(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).exitOptional_top_term(this);
		}
	}

	public final Optional_top_termContext optional_top_term() throws RecognitionException {
		Optional_top_termContext _localctx = new Optional_top_termContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_optional_top_term);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(K_TOP);
			setState(113);
			match(POSITIVE_INT);
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

	public static class Distinct_or_allContext extends ParserRuleContext {
		public TerminalNode K_DISTINCT() { return getToken(SQLBasicParser.K_DISTINCT, 0); }
		public TerminalNode K_ALL() { return getToken(SQLBasicParser.K_ALL, 0); }
		public Distinct_or_allContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_distinct_or_all; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).enterDistinct_or_all(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).exitDistinct_or_all(this);
		}
	}

	public final Distinct_or_allContext distinct_or_all() throws RecognitionException {
		Distinct_or_allContext _localctx = new Distinct_or_allContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_distinct_or_all);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			_la = _input.LA(1);
			if ( !(_la==K_ALL || _la==K_DISTINCT) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class SelectexpressionsContext extends ParserRuleContext {
		public SelectexpressionContext selectexpression() {
			return getRuleContext(SelectexpressionContext.class,0);
		}
		public SelectexpressionsContext selectexpressions() {
			return getRuleContext(SelectexpressionsContext.class,0);
		}
		public SelectexpressionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectexpressions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).enterSelectexpressions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).exitSelectexpressions(this);
		}
	}

	public final SelectexpressionsContext selectexpressions() throws RecognitionException {
		SelectexpressionsContext _localctx = new SelectexpressionsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_selectexpressions);
		try {
			setState(122);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(117);
				selectexpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(118);
				selectexpression();
				setState(119);
				match(T__1);
				setState(120);
				selectexpressions();
				}
				break;
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

	public static class SelectexpressionContext extends ParserRuleContext {
		public SimpleselectexpressionContext simpleselectexpression() {
			return getRuleContext(SimpleselectexpressionContext.class,0);
		}
		public AggregateselectexpressionContext aggregateselectexpression() {
			return getRuleContext(AggregateselectexpressionContext.class,0);
		}
		public SelectexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectexpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).enterSelectexpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).exitSelectexpression(this);
		}
	}

	public final SelectexpressionContext selectexpression() throws RecognitionException {
		SelectexpressionContext _localctx = new SelectexpressionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_selectexpression);
		try {
			setState(126);
			switch (_input.LA(1)) {
			case T__2:
			case T__6:
			case T__7:
			case T__8:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(124);
				simpleselectexpression();
				}
				break;
			case K_COUNT:
			case K_AVG:
			case K_MAX:
			case K_MIN:
			case K_SUM:
				enterOuterAlt(_localctx, 2);
				{
				setState(125);
				aggregateselectexpression();
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

	public static class SimpleselectexpressionContext extends ParserRuleContext {
		public FullnameContext fullname() {
			return getRuleContext(FullnameContext.class,0);
		}
		public As_alias_expressionContext as_alias_expression() {
			return getRuleContext(As_alias_expressionContext.class,0);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public SimpleselectexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleselectexpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).enterSimpleselectexpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).exitSimpleselectexpression(this);
		}
	}

	public final SimpleselectexpressionContext simpleselectexpression() throws RecognitionException {
		SimpleselectexpressionContext _localctx = new SimpleselectexpressionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_simpleselectexpression);
		int _la;
		try {
			setState(137);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(128);
				match(T__2);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(129);
				fullname();
				setState(131);
				_la = _input.LA(1);
				if (_la==K_AS) {
					{
					setState(130);
					as_alias_expression();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(133);
				name();
				setState(134);
				match(T__3);
				setState(135);
				match(T__2);
				}
				break;
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

	public static class AggregateselectexpressionContext extends ParserRuleContext {
		public AggregationContext aggregation() {
			return getRuleContext(AggregationContext.class,0);
		}
		public SimpleselectexpressionContext simpleselectexpression() {
			return getRuleContext(SimpleselectexpressionContext.class,0);
		}
		public AggregateselectexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggregateselectexpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).enterAggregateselectexpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).exitAggregateselectexpression(this);
		}
	}

	public final AggregateselectexpressionContext aggregateselectexpression() throws RecognitionException {
		AggregateselectexpressionContext _localctx = new AggregateselectexpressionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_aggregateselectexpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			aggregation();
			setState(140);
			match(T__4);
			setState(141);
			simpleselectexpression();
			setState(142);
			match(T__5);
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

	public static class AggregationContext extends ParserRuleContext {
		public TerminalNode K_COUNT() { return getToken(SQLBasicParser.K_COUNT, 0); }
		public TerminalNode K_AVG() { return getToken(SQLBasicParser.K_AVG, 0); }
		public TerminalNode K_MAX() { return getToken(SQLBasicParser.K_MAX, 0); }
		public TerminalNode K_MIN() { return getToken(SQLBasicParser.K_MIN, 0); }
		public TerminalNode K_SUM() { return getToken(SQLBasicParser.K_SUM, 0); }
		public AggregationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggregation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).enterAggregation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).exitAggregation(this);
		}
	}

	public final AggregationContext aggregation() throws RecognitionException {
		AggregationContext _localctx = new AggregationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_aggregation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << K_COUNT) | (1L << K_AVG) | (1L << K_MAX) | (1L << K_MIN) | (1L << K_SUM))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class FromexpressionsContext extends ParserRuleContext {
		public FromexpressionContext fromexpression() {
			return getRuleContext(FromexpressionContext.class,0);
		}
		public FromexpressionsContext fromexpressions() {
			return getRuleContext(FromexpressionsContext.class,0);
		}
		public FromexpressionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fromexpressions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).enterFromexpressions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).exitFromexpressions(this);
		}
	}

	public final FromexpressionsContext fromexpressions() throws RecognitionException {
		FromexpressionsContext _localctx = new FromexpressionsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_fromexpressions);
		try {
			setState(151);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(146);
				fromexpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(147);
				fromexpression();
				setState(148);
				match(T__1);
				setState(149);
				fromexpressions();
				}
				break;
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

	public static class FromexpressionContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public As_alias_expressionContext as_alias_expression() {
			return getRuleContext(As_alias_expressionContext.class,0);
		}
		public SubqueryfromexpressionContext subqueryfromexpression() {
			return getRuleContext(SubqueryfromexpressionContext.class,0);
		}
		public FromexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fromexpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).enterFromexpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).exitFromexpression(this);
		}
	}

	public final FromexpressionContext fromexpression() throws RecognitionException {
		FromexpressionContext _localctx = new FromexpressionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_fromexpression);
		int _la;
		try {
			setState(158);
			switch (_input.LA(1)) {
			case T__6:
			case T__7:
			case T__8:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(153);
				name();
				setState(155);
				_la = _input.LA(1);
				if (_la==K_AS) {
					{
					setState(154);
					as_alias_expression();
					}
				}

				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(157);
				subqueryfromexpression();
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

	public static class SubqueryfromexpressionContext extends ParserRuleContext {
		public SelectContext select() {
			return getRuleContext(SelectContext.class,0);
		}
		public As_alias_expressionContext as_alias_expression() {
			return getRuleContext(As_alias_expressionContext.class,0);
		}
		public SubqueryfromexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subqueryfromexpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).enterSubqueryfromexpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).exitSubqueryfromexpression(this);
		}
	}

	public final SubqueryfromexpressionContext subqueryfromexpression() throws RecognitionException {
		SubqueryfromexpressionContext _localctx = new SubqueryfromexpressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_subqueryfromexpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(T__4);
			setState(161);
			select();
			setState(162);
			match(T__5);
			setState(163);
			as_alias_expression();
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

	public static class NameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SQLBasicParser.IDENTIFIER, 0); }
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).exitName(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_name);
		try {
			setState(175);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(165);
				match(T__6);
				setState(166);
				match(IDENTIFIER);
				setState(167);
				match(T__6);
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(168);
				match(T__7);
				setState(169);
				match(IDENTIFIER);
				setState(170);
				match(T__7);
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 3);
				{
				setState(171);
				match(T__8);
				setState(172);
				match(IDENTIFIER);
				setState(173);
				match(T__8);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 4);
				{
				setState(174);
				match(IDENTIFIER);
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

	public static class FullnameContext extends ParserRuleContext {
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public FullnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fullname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).enterFullname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).exitFullname(this);
		}
	}

	public final FullnameContext fullname() throws RecognitionException {
		FullnameContext _localctx = new FullnameContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_fullname);
		try {
			setState(182);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(177);
				name();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(178);
				name();
				setState(179);
				match(T__3);
				setState(180);
				name();
				}
				break;
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

	public static class Optional_where_expressionContext extends ParserRuleContext {
		public TerminalNode K_WHERE() { return getToken(SQLBasicParser.K_WHERE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Optional_where_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optional_where_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).enterOptional_where_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).exitOptional_where_expression(this);
		}
	}

	public final Optional_where_expressionContext optional_where_expression() throws RecognitionException {
		Optional_where_expressionContext _localctx = new Optional_where_expressionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_optional_where_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			match(K_WHERE);
			setState(185);
			expression();
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

	public static class Optional_group_by_expressionContext extends ParserRuleContext {
		public TerminalNode K_GROUP() { return getToken(SQLBasicParser.K_GROUP, 0); }
		public TerminalNode K_BY() { return getToken(SQLBasicParser.K_BY, 0); }
		public GrouplistContext grouplist() {
			return getRuleContext(GrouplistContext.class,0);
		}
		public Optional_group_by_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optional_group_by_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).enterOptional_group_by_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).exitOptional_group_by_expression(this);
		}
	}

	public final Optional_group_by_expressionContext optional_group_by_expression() throws RecognitionException {
		Optional_group_by_expressionContext _localctx = new Optional_group_by_expressionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_optional_group_by_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			match(K_GROUP);
			setState(188);
			match(K_BY);
			setState(189);
			grouplist();
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

	public static class GrouplistContext extends ParserRuleContext {
		public FullnameContext fullname() {
			return getRuleContext(FullnameContext.class,0);
		}
		public GrouplistContext grouplist() {
			return getRuleContext(GrouplistContext.class,0);
		}
		public GrouplistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grouplist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).enterGrouplist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).exitGrouplist(this);
		}
	}

	public final GrouplistContext grouplist() throws RecognitionException {
		GrouplistContext _localctx = new GrouplistContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_grouplist);
		try {
			setState(196);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(191);
				fullname();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(192);
				fullname();
				setState(193);
				match(T__1);
				setState(194);
				grouplist();
				}
				break;
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

	public static class Optional_having_expressionContext extends ParserRuleContext {
		public TerminalNode K_HAVING() { return getToken(SQLBasicParser.K_HAVING, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Optional_having_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optional_having_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).enterOptional_having_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).exitOptional_having_expression(this);
		}
	}

	public final Optional_having_expressionContext optional_having_expression() throws RecognitionException {
		Optional_having_expressionContext _localctx = new Optional_having_expressionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_optional_having_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(K_HAVING);
			setState(199);
			expression();
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

	public static class Optional_order_by_expressionContext extends ParserRuleContext {
		public TerminalNode K_ORDER() { return getToken(SQLBasicParser.K_ORDER, 0); }
		public TerminalNode K_BY() { return getToken(SQLBasicParser.K_BY, 0); }
		public FullnameContext fullname() {
			return getRuleContext(FullnameContext.class,0);
		}
		public Sort_orderContext sort_order() {
			return getRuleContext(Sort_orderContext.class,0);
		}
		public Null_orderContext null_order() {
			return getRuleContext(Null_orderContext.class,0);
		}
		public Optional_order_by_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optional_order_by_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).enterOptional_order_by_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).exitOptional_order_by_expression(this);
		}
	}

	public final Optional_order_by_expressionContext optional_order_by_expression() throws RecognitionException {
		Optional_order_by_expressionContext _localctx = new Optional_order_by_expressionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_optional_order_by_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			match(K_ORDER);
			setState(202);
			match(K_BY);
			setState(203);
			fullname();
			setState(205);
			_la = _input.LA(1);
			if (_la==K_ASC || _la==K_DESC) {
				{
				setState(204);
				sort_order();
				}
			}

			setState(208);
			_la = _input.LA(1);
			if (_la==K_NULLS) {
				{
				setState(207);
				null_order();
				}
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

	public static class Sort_orderContext extends ParserRuleContext {
		public TerminalNode K_ASC() { return getToken(SQLBasicParser.K_ASC, 0); }
		public TerminalNode K_DESC() { return getToken(SQLBasicParser.K_DESC, 0); }
		public Sort_orderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sort_order; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).enterSort_order(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).exitSort_order(this);
		}
	}

	public final Sort_orderContext sort_order() throws RecognitionException {
		Sort_orderContext _localctx = new Sort_orderContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_sort_order);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			_la = _input.LA(1);
			if ( !(_la==K_ASC || _la==K_DESC) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class Null_orderContext extends ParserRuleContext {
		public TerminalNode K_NULLS() { return getToken(SQLBasicParser.K_NULLS, 0); }
		public TerminalNode K_LAST() { return getToken(SQLBasicParser.K_LAST, 0); }
		public TerminalNode K_FIRST() { return getToken(SQLBasicParser.K_FIRST, 0); }
		public Null_orderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_null_order; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).enterNull_order(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).exitNull_order(this);
		}
	}

	public final Null_orderContext null_order() throws RecognitionException {
		Null_orderContext _localctx = new Null_orderContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_null_order);
		try {
			setState(216);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(212);
				match(K_NULLS);
				setState(213);
				match(K_LAST);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(214);
				match(K_NULLS);
				setState(215);
				match(K_FIRST);
				}
				break;
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

	public static class Optional_limit_expressionContext extends ParserRuleContext {
		public TerminalNode K_LIMIT() { return getToken(SQLBasicParser.K_LIMIT, 0); }
		public TerminalNode POSITIVE_INT() { return getToken(SQLBasicParser.POSITIVE_INT, 0); }
		public Optional_limit_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optional_limit_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).enterOptional_limit_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).exitOptional_limit_expression(this);
		}
	}

	public final Optional_limit_expressionContext optional_limit_expression() throws RecognitionException {
		Optional_limit_expressionContext _localctx = new Optional_limit_expressionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_optional_limit_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			match(K_LIMIT);
			setState(219);
			match(POSITIVE_INT);
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

	public static class Optional_offset_expressionContext extends ParserRuleContext {
		public UnmatchableContext unmatchable() {
			return getRuleContext(UnmatchableContext.class,0);
		}
		public Optional_offset_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optional_offset_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).enterOptional_offset_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).exitOptional_offset_expression(this);
		}
	}

	public final Optional_offset_expressionContext optional_offset_expression() throws RecognitionException {
		Optional_offset_expressionContext _localctx = new Optional_offset_expressionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_optional_offset_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			unmatchable();
			 /*nothing, not to be implemented*/ 
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

	public static class ExpressionContext extends ParserRuleContext {
		public AndconditionContext andcondition() {
			return getRuleContext(AndconditionContext.class,0);
		}
		public TerminalNode K_OR() { return getToken(SQLBasicParser.K_OR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_expression);
		try {
			setState(229);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(224);
				andcondition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(225);
				andcondition();
				setState(226);
				match(K_OR);
				setState(227);
				expression();
				}
				break;
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

	public static class AndconditionContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode K_AND() { return getToken(SQLBasicParser.K_AND, 0); }
		public AndconditionContext andcondition() {
			return getRuleContext(AndconditionContext.class,0);
		}
		public AndconditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andcondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).enterAndcondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).exitAndcondition(this);
		}
	}

	public final AndconditionContext andcondition() throws RecognitionException {
		AndconditionContext _localctx = new AndconditionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_andcondition);
		try {
			setState(236);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(231);
				condition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(232);
				condition();
				setState(233);
				match(K_AND);
				setState(234);
				andcondition();
				}
				break;
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

	public static class ConditionContext extends ParserRuleContext {
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
		}
		public TerminalNode COMPARATOR() { return getToken(SQLBasicParser.COMPARATOR, 0); }
		public TerminalNode K_NOT() { return getToken(SQLBasicParser.K_NOT, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).exitCondition(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_condition);
		try {
			setState(248);
			switch (_input.LA(1)) {
			case T__6:
			case T__7:
			case T__8:
			case STRINGCONSTANT:
			case FLOATCONTENTS:
			case POSITIVE_INT:
			case PLUS_OR_MINUS:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(238);
				operand();
				setState(239);
				match(COMPARATOR);
				setState(240);
				operand();
				}
				break;
			case K_NOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(242);
				match(K_NOT);
				setState(243);
				condition();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 3);
				{
				setState(244);
				match(T__4);
				setState(245);
				expression();
				setState(246);
				match(T__5);
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

	public static class OperandContext extends ParserRuleContext {
		public FullnameContext fullname() {
			return getRuleContext(FullnameContext.class,0);
		}
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public OperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).enterOperand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).exitOperand(this);
		}
	}

	public final OperandContext operand() throws RecognitionException {
		OperandContext _localctx = new OperandContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_operand);
		try {
			setState(252);
			switch (_input.LA(1)) {
			case T__6:
			case T__7:
			case T__8:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(250);
				fullname();
				}
				break;
			case STRINGCONSTANT:
			case FLOATCONTENTS:
			case POSITIVE_INT:
			case PLUS_OR_MINUS:
				enterOuterAlt(_localctx, 2);
				{
				setState(251);
				constant();
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

	public static class ConstantContext extends ParserRuleContext {
		public IntconstantContext intconstant() {
			return getRuleContext(IntconstantContext.class,0);
		}
		public TerminalNode STRINGCONSTANT() { return getToken(SQLBasicParser.STRINGCONSTANT, 0); }
		public FloatconstantContext floatconstant() {
			return getRuleContext(FloatconstantContext.class,0);
		}
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).exitConstant(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_constant);
		try {
			setState(257);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(254);
				intconstant();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(255);
				match(STRINGCONSTANT);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(256);
				floatconstant();
				}
				break;
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

	public static class IntconstantContext extends ParserRuleContext {
		public TerminalNode POSITIVE_INT() { return getToken(SQLBasicParser.POSITIVE_INT, 0); }
		public TerminalNode PLUS_OR_MINUS() { return getToken(SQLBasicParser.PLUS_OR_MINUS, 0); }
		public IntconstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intconstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).enterIntconstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).exitIntconstant(this);
		}
	}

	public final IntconstantContext intconstant() throws RecognitionException {
		IntconstantContext _localctx = new IntconstantContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_intconstant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			_la = _input.LA(1);
			if (_la==PLUS_OR_MINUS) {
				{
				setState(259);
				match(PLUS_OR_MINUS);
				}
			}

			setState(262);
			match(POSITIVE_INT);
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

	public static class FloatconstantContext extends ParserRuleContext {
		public TerminalNode FLOATCONTENTS() { return getToken(SQLBasicParser.FLOATCONTENTS, 0); }
		public TerminalNode PLUS_OR_MINUS() { return getToken(SQLBasicParser.PLUS_OR_MINUS, 0); }
		public FloatconstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_floatconstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).enterFloatconstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).exitFloatconstant(this);
		}
	}

	public final FloatconstantContext floatconstant() throws RecognitionException {
		FloatconstantContext _localctx = new FloatconstantContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_floatconstant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			_la = _input.LA(1);
			if (_la==PLUS_OR_MINUS) {
				{
				setState(264);
				match(PLUS_OR_MINUS);
				}
			}

			setState(267);
			match(FLOATCONTENTS);
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

	public static class As_alias_expressionContext extends ParserRuleContext {
		public TerminalNode K_AS() { return getToken(SQLBasicParser.K_AS, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public As_alias_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_as_alias_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).enterAs_alias_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).exitAs_alias_expression(this);
		}
	}

	public final As_alias_expressionContext as_alias_expression() throws RecognitionException {
		As_alias_expressionContext _localctx = new As_alias_expressionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_as_alias_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			match(K_AS);
			setState(270);
			name();
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

	public static class NothingContext extends ParserRuleContext {
		public List<TerminalNode> EOF() { return getTokens(SQLBasicParser.EOF); }
		public TerminalNode EOF(int i) {
			return getToken(SQLBasicParser.EOF, i);
		}
		public NothingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nothing; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).enterNothing(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).exitNothing(this);
		}
	}

	public final NothingContext nothing() throws RecognitionException {
		NothingContext _localctx = new NothingContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_nothing);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(272);
				match(EOF);
				setState(273);
				match(EOF);
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

	public static class UnmatchableContext extends ParserRuleContext {
		public List<TerminalNode> EOF() { return getTokens(SQLBasicParser.EOF); }
		public TerminalNode EOF(int i) {
			return getToken(SQLBasicParser.EOF, i);
		}
		public UnmatchableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unmatchable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).enterUnmatchable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBasicListener ) ((SQLBasicListener)listener).exitUnmatchable(this);
		}
	}

	public final UnmatchableContext unmatchable() throws RecognitionException {
		UnmatchableContext _localctx = new UnmatchableContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_unmatchable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			match(EOF);
			setState(277);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3=\u011a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\3\2\3\2\3\2\3\2\7\2L\n\2\f\2\16\2O\13\2\3\2\5\2"+
		"R\n\2\3\3\3\3\3\3\3\4\3\4\5\4Y\n\4\3\4\5\4\\\n\4\3\4\3\4\3\4\3\4\5\4b"+
		"\n\4\3\4\5\4e\n\4\3\4\5\4h\n\4\3\4\5\4k\n\4\3\4\5\4n\n\4\3\4\5\4q\n\4"+
		"\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\5\7}\n\7\3\b\3\b\5\b\u0081\n"+
		"\b\3\t\3\t\3\t\5\t\u0086\n\t\3\t\3\t\3\t\3\t\5\t\u008c\n\t\3\n\3\n\3\n"+
		"\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\5\f\u009a\n\f\3\r\3\r\5\r\u009e"+
		"\n\r\3\r\5\r\u00a1\n\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\5\17\u00b2\n\17\3\20\3\20\3\20\3\20\3\20"+
		"\5\20\u00b9\n\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23"+
		"\3\23\5\23\u00c7\n\23\3\24\3\24\3\24\3\25\3\25\3\25\3\25\5\25\u00d0\n"+
		"\25\3\25\5\25\u00d3\n\25\3\26\3\26\3\27\3\27\3\27\3\27\5\27\u00db\n\27"+
		"\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\5\32\u00e8\n\32"+
		"\3\33\3\33\3\33\3\33\3\33\5\33\u00ef\n\33\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\5\34\u00fb\n\34\3\35\3\35\5\35\u00ff\n\35\3\36\3"+
		"\36\3\36\5\36\u0104\n\36\3\37\5\37\u0107\n\37\3\37\3\37\3 \5 \u010c\n"+
		" \3 \3 \3!\3!\3!\3\"\3\"\5\"\u0115\n\"\3#\3#\3#\3#\2\2$\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BD\2\5\3\2\25\26\4\2"+
		"\62\6588\4\2\33\33\35\35\u011b\2Q\3\2\2\2\4S\3\2\2\2\6V\3\2\2\2\br\3\2"+
		"\2\2\nu\3\2\2\2\f|\3\2\2\2\16\u0080\3\2\2\2\20\u008b\3\2\2\2\22\u008d"+
		"\3\2\2\2\24\u0092\3\2\2\2\26\u0099\3\2\2\2\30\u00a0\3\2\2\2\32\u00a2\3"+
		"\2\2\2\34\u00b1\3\2\2\2\36\u00b8\3\2\2\2 \u00ba\3\2\2\2\"\u00bd\3\2\2"+
		"\2$\u00c6\3\2\2\2&\u00c8\3\2\2\2(\u00cb\3\2\2\2*\u00d4\3\2\2\2,\u00da"+
		"\3\2\2\2.\u00dc\3\2\2\2\60\u00df\3\2\2\2\62\u00e7\3\2\2\2\64\u00ee\3\2"+
		"\2\2\66\u00fa\3\2\2\28\u00fe\3\2\2\2:\u0103\3\2\2\2<\u0106\3\2\2\2>\u010b"+
		"\3\2\2\2@\u010f\3\2\2\2B\u0114\3\2\2\2D\u0116\3\2\2\2FG\5\6\4\2GH\7\3"+
		"\2\2HI\7\2\2\3IR\3\2\2\2JL\5\4\3\2KJ\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2"+
		"\2\2NP\3\2\2\2OM\3\2\2\2PR\7\2\2\3QF\3\2\2\2QM\3\2\2\2R\3\3\2\2\2ST\7"+
		"=\2\2TU\b\3\1\2U\5\3\2\2\2VX\7,\2\2WY\5\b\5\2XW\3\2\2\2XY\3\2\2\2Y[\3"+
		"\2\2\2Z\\\5\n\6\2[Z\3\2\2\2[\\\3\2\2\2\\]\3\2\2\2]^\5\f\7\2^_\7\37\2\2"+
		"_a\5\26\f\2`b\5 \21\2a`\3\2\2\2ab\3\2\2\2bd\3\2\2\2ce\5\"\22\2dc\3\2\2"+
		"\2de\3\2\2\2eg\3\2\2\2fh\5&\24\2gf\3\2\2\2gh\3\2\2\2hj\3\2\2\2ik\5(\25"+
		"\2ji\3\2\2\2jk\3\2\2\2km\3\2\2\2ln\5.\30\2ml\3\2\2\2mn\3\2\2\2np\3\2\2"+
		"\2oq\5\60\31\2po\3\2\2\2pq\3\2\2\2q\7\3\2\2\2rs\7\61\2\2st\7\17\2\2t\t"+
		"\3\2\2\2uv\t\2\2\2v\13\3\2\2\2w}\5\16\b\2xy\5\16\b\2yz\7\4\2\2z{\5\f\7"+
		"\2{}\3\2\2\2|w\3\2\2\2|x\3\2\2\2}\r\3\2\2\2~\u0081\5\20\t\2\177\u0081"+
		"\5\22\n\2\u0080~\3\2\2\2\u0080\177\3\2\2\2\u0081\17\3\2\2\2\u0082\u008c"+
		"\7\5\2\2\u0083\u0085\5\36\20\2\u0084\u0086\5@!\2\u0085\u0084\3\2\2\2\u0085"+
		"\u0086\3\2\2\2\u0086\u008c\3\2\2\2\u0087\u0088\5\34\17\2\u0088\u0089\7"+
		"\6\2\2\u0089\u008a\7\5\2\2\u008a\u008c\3\2\2\2\u008b\u0082\3\2\2\2\u008b"+
		"\u0083\3\2\2\2\u008b\u0087\3\2\2\2\u008c\21\3\2\2\2\u008d\u008e\5\24\13"+
		"\2\u008e\u008f\7\7\2\2\u008f\u0090\5\20\t\2\u0090\u0091\7\b\2\2\u0091"+
		"\23\3\2\2\2\u0092\u0093\t\3\2\2\u0093\25\3\2\2\2\u0094\u009a\5\30\r\2"+
		"\u0095\u0096\5\30\r\2\u0096\u0097\7\4\2\2\u0097\u0098\5\26\f\2\u0098\u009a"+
		"\3\2\2\2\u0099\u0094\3\2\2\2\u0099\u0095\3\2\2\2\u009a\27\3\2\2\2\u009b"+
		"\u009d\5\34\17\2\u009c\u009e\5@!\2\u009d\u009c\3\2\2\2\u009d\u009e\3\2"+
		"\2\2\u009e\u00a1\3\2\2\2\u009f\u00a1\5\32\16\2\u00a0\u009b\3\2\2\2\u00a0"+
		"\u009f\3\2\2\2\u00a1\31\3\2\2\2\u00a2\u00a3\7\7\2\2\u00a3\u00a4\5\6\4"+
		"\2\u00a4\u00a5\7\b\2\2\u00a5\u00a6\5@!\2\u00a6\33\3\2\2\2\u00a7\u00a8"+
		"\7\t\2\2\u00a8\u00a9\79\2\2\u00a9\u00b2\7\t\2\2\u00aa\u00ab\7\n\2\2\u00ab"+
		"\u00ac\79\2\2\u00ac\u00b2\7\n\2\2\u00ad\u00ae\7\13\2\2\u00ae\u00af\79"+
		"\2\2\u00af\u00b2\7\13\2\2\u00b0\u00b2\79\2\2\u00b1\u00a7\3\2\2\2\u00b1"+
		"\u00aa\3\2\2\2\u00b1\u00ad\3\2\2\2\u00b1\u00b0\3\2\2\2\u00b2\35\3\2\2"+
		"\2\u00b3\u00b9\5\34\17\2\u00b4\u00b5\5\34\17\2\u00b5\u00b6\7\6\2\2\u00b6"+
		"\u00b7\5\34\17\2\u00b7\u00b9\3\2\2\2\u00b8\u00b3\3\2\2\2\u00b8\u00b4\3"+
		"\2\2\2\u00b9\37\3\2\2\2\u00ba\u00bb\7.\2\2\u00bb\u00bc\5\62\32\2\u00bc"+
		"!\3\2\2\2\u00bd\u00be\7 \2\2\u00be\u00bf\7\34\2\2\u00bf\u00c0\5$\23\2"+
		"\u00c0#\3\2\2\2\u00c1\u00c7\5\36\20\2\u00c2\u00c3\5\36\20\2\u00c3\u00c4"+
		"\7\4\2\2\u00c4\u00c5\5$\23\2\u00c5\u00c7\3\2\2\2\u00c6\u00c1\3\2\2\2\u00c6"+
		"\u00c2\3\2\2\2\u00c7%\3\2\2\2\u00c8\u00c9\7!\2\2\u00c9\u00ca\5\62\32\2"+
		"\u00ca\'\3\2\2\2\u00cb\u00cc\7+\2\2\u00cc\u00cd\7\34\2\2\u00cd\u00cf\5"+
		"\36\20\2\u00ce\u00d0\5*\26\2\u00cf\u00ce\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0"+
		"\u00d2\3\2\2\2\u00d1\u00d3\5,\27\2\u00d2\u00d1\3\2\2\2\u00d2\u00d3\3\2"+
		"\2\2\u00d3)\3\2\2\2\u00d4\u00d5\t\4\2\2\u00d5+\3\2\2\2\u00d6\u00d7\7\60"+
		"\2\2\u00d7\u00db\7\67\2\2\u00d8\u00d9\7\60\2\2\u00d9\u00db\7\66\2\2\u00da"+
		"\u00d6\3\2\2\2\u00da\u00d8\3\2\2\2\u00db-\3\2\2\2\u00dc\u00dd\7$\2\2\u00dd"+
		"\u00de\7\17\2\2\u00de/\3\2\2\2\u00df\u00e0\5D#\2\u00e0\u00e1\b\31\1\2"+
		"\u00e1\61\3\2\2\2\u00e2\u00e8\5\64\33\2\u00e3\u00e4\5\64\33\2\u00e4\u00e5"+
		"\7*\2\2\u00e5\u00e6\5\62\32\2\u00e6\u00e8\3\2\2\2\u00e7\u00e2\3\2\2\2"+
		"\u00e7\u00e3\3\2\2\2\u00e8\63\3\2\2\2\u00e9\u00ef\5\66\34\2\u00ea\u00eb"+
		"\5\66\34\2\u00eb\u00ec\7\31\2\2\u00ec\u00ed\5\64\33\2\u00ed\u00ef\3\2"+
		"\2\2\u00ee\u00e9\3\2\2\2\u00ee\u00ea\3\2\2\2\u00ef\65\3\2\2\2\u00f0\u00f1"+
		"\58\35\2\u00f1\u00f2\7\f\2\2\u00f2\u00f3\58\35\2\u00f3\u00fb\3\2\2\2\u00f4"+
		"\u00f5\7%\2\2\u00f5\u00fb\5\66\34\2\u00f6\u00f7\7\7\2\2\u00f7\u00f8\5"+
		"\62\32\2\u00f8\u00f9\7\b\2\2\u00f9\u00fb\3\2\2\2\u00fa\u00f0\3\2\2\2\u00fa"+
		"\u00f4\3\2\2\2\u00fa\u00f6\3\2\2\2\u00fb\67\3\2\2\2\u00fc\u00ff\5\36\20"+
		"\2\u00fd\u00ff\5:\36\2\u00fe\u00fc\3\2\2\2\u00fe\u00fd\3\2\2\2\u00ff9"+
		"\3\2\2\2\u0100\u0104\5<\37\2\u0101\u0104\7\r\2\2\u0102\u0104\5> \2\u0103"+
		"\u0100\3\2\2\2\u0103\u0101\3\2\2\2\u0103\u0102\3\2\2\2\u0104;\3\2\2\2"+
		"\u0105\u0107\7\20\2\2\u0106\u0105\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0108"+
		"\3\2\2\2\u0108\u0109\7\17\2\2\u0109=\3\2\2\2\u010a\u010c\7\20\2\2\u010b"+
		"\u010a\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u010e\7\16"+
		"\2\2\u010e?\3\2\2\2\u010f\u0110\7\32\2\2\u0110\u0111\5\34\17\2\u0111A"+
		"\3\2\2\2\u0112\u0113\7\2\2\3\u0113\u0115\7\2\2\3\u0114\u0112\3\2\2\2\u0114"+
		"\u0115\3\2\2\2\u0115C\3\2\2\2\u0116\u0117\7\2\2\3\u0117\u0118\7\2\2\3"+
		"\u0118E\3\2\2\2!MQX[adgjmp|\u0080\u0085\u008b\u0099\u009d\u00a0\u00b1"+
		"\u00b8\u00c6\u00cf\u00d2\u00da\u00e7\u00ee\u00fa\u00fe\u0103\u0106\u010b"+
		"\u0114";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}