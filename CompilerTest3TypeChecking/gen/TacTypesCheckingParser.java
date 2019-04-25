// Generated from E:/SourceTree/ParserAndLexer/CompilerTest3TypeChecking\TacTypesChecking.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TacTypesCheckingParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ASSIGN=1, DIGIT=2, LETTER=3, ENDSTNT=4, PRINT=5, PLUS=6, INT=7, FLOAT=8, 
		WS=9;
	public static final int
		RULE_start = 0, RULE_exprs = 1, RULE_expr = 2, RULE_print = 3, RULE_intDcl = 4, 
		RULE_floatDcl = 5, RULE_intPlus = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "exprs", "expr", "print", "intDcl", "floatDcl", "intPlus"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", null, null, "';'", "'print'", "'+'", "'int'", "'float'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ASSIGN", "DIGIT", "LETTER", "ENDSTNT", "PRINT", "PLUS", "INT", 
			"FLOAT", "WS"
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

	@Override
	public String getGrammarFileName() { return "TacTypesChecking.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TacTypesCheckingParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public ExprsContext exprs() {
			return getRuleContext(ExprsContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacTypesCheckingListener ) ((TacTypesCheckingListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacTypesCheckingListener ) ((TacTypesCheckingListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacTypesCheckingVisitor ) return ((TacTypesCheckingVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			exprs(0);
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

	public static class ExprsContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ENDSTNT() { return getToken(TacTypesCheckingParser.ENDSTNT, 0); }
		public List<ExprsContext> exprs() {
			return getRuleContexts(ExprsContext.class);
		}
		public ExprsContext exprs(int i) {
			return getRuleContext(ExprsContext.class,i);
		}
		public ExprsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacTypesCheckingListener ) ((TacTypesCheckingListener)listener).enterExprs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacTypesCheckingListener ) ((TacTypesCheckingListener)listener).exitExprs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacTypesCheckingVisitor ) return ((TacTypesCheckingVisitor<? extends T>)visitor).visitExprs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprsContext exprs() throws RecognitionException {
		return exprs(0);
	}

	private ExprsContext exprs(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprsContext _localctx = new ExprsContext(_ctx, _parentState);
		ExprsContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_exprs, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(17);
			expr();
			setState(18);
			match(ENDSTNT);
			}
			_ctx.stop = _input.LT(-1);
			setState(24);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprsContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_exprs);
					setState(20);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(21);
					exprs(2);
					}
					} 
				}
				setState(26);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public IntDclContext intDcl() {
			return getRuleContext(IntDclContext.class,0);
		}
		public FloatDclContext floatDcl() {
			return getRuleContext(FloatDclContext.class,0);
		}
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public IntPlusContext intPlus() {
			return getRuleContext(IntPlusContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacTypesCheckingListener ) ((TacTypesCheckingListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacTypesCheckingListener ) ((TacTypesCheckingListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacTypesCheckingVisitor ) return ((TacTypesCheckingVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_expr);
		try {
			setState(31);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(27);
				intDcl();
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(28);
				floatDcl();
				}
				break;
			case PRINT:
				enterOuterAlt(_localctx, 3);
				{
				setState(29);
				print();
				}
				break;
			case DIGIT:
			case LETTER:
				enterOuterAlt(_localctx, 4);
				{
				setState(30);
				intPlus();
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

	public static class PrintContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(TacTypesCheckingParser.PRINT, 0); }
		public TerminalNode LETTER() { return getToken(TacTypesCheckingParser.LETTER, 0); }
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacTypesCheckingListener ) ((TacTypesCheckingListener)listener).enterPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacTypesCheckingListener ) ((TacTypesCheckingListener)listener).exitPrint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacTypesCheckingVisitor ) return ((TacTypesCheckingVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			match(PRINT);
			setState(34);
			match(LETTER);
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

	public static class IntDclContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(TacTypesCheckingParser.INT, 0); }
		public TerminalNode LETTER() { return getToken(TacTypesCheckingParser.LETTER, 0); }
		public TerminalNode ASSIGN() { return getToken(TacTypesCheckingParser.ASSIGN, 0); }
		public TerminalNode DIGIT() { return getToken(TacTypesCheckingParser.DIGIT, 0); }
		public IntDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intDcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacTypesCheckingListener ) ((TacTypesCheckingListener)listener).enterIntDcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacTypesCheckingListener ) ((TacTypesCheckingListener)listener).exitIntDcl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacTypesCheckingVisitor ) return ((TacTypesCheckingVisitor<? extends T>)visitor).visitIntDcl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntDclContext intDcl() throws RecognitionException {
		IntDclContext _localctx = new IntDclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_intDcl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(INT);
			setState(37);
			match(LETTER);
			setState(38);
			match(ASSIGN);
			setState(39);
			match(DIGIT);
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

	public static class FloatDclContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(TacTypesCheckingParser.FLOAT, 0); }
		public TerminalNode LETTER() { return getToken(TacTypesCheckingParser.LETTER, 0); }
		public TerminalNode ASSIGN() { return getToken(TacTypesCheckingParser.ASSIGN, 0); }
		public TerminalNode DIGIT() { return getToken(TacTypesCheckingParser.DIGIT, 0); }
		public FloatDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_floatDcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacTypesCheckingListener ) ((TacTypesCheckingListener)listener).enterFloatDcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacTypesCheckingListener ) ((TacTypesCheckingListener)listener).exitFloatDcl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacTypesCheckingVisitor ) return ((TacTypesCheckingVisitor<? extends T>)visitor).visitFloatDcl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FloatDclContext floatDcl() throws RecognitionException {
		FloatDclContext _localctx = new FloatDclContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_floatDcl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(FLOAT);
			setState(42);
			match(LETTER);
			setState(43);
			match(ASSIGN);
			setState(44);
			match(DIGIT);
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

	public static class IntPlusContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(TacTypesCheckingParser.PLUS, 0); }
		public List<TerminalNode> LETTER() { return getTokens(TacTypesCheckingParser.LETTER); }
		public TerminalNode LETTER(int i) {
			return getToken(TacTypesCheckingParser.LETTER, i);
		}
		public List<TerminalNode> DIGIT() { return getTokens(TacTypesCheckingParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(TacTypesCheckingParser.DIGIT, i);
		}
		public IntPlusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intPlus; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacTypesCheckingListener ) ((TacTypesCheckingListener)listener).enterIntPlus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacTypesCheckingListener ) ((TacTypesCheckingListener)listener).exitIntPlus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacTypesCheckingVisitor ) return ((TacTypesCheckingVisitor<? extends T>)visitor).visitIntPlus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntPlusContext intPlus() throws RecognitionException {
		IntPlusContext _localctx = new IntPlusContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_intPlus);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			_la = _input.LA(1);
			if ( !(_la==DIGIT || _la==LETTER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(47);
			match(PLUS);
			setState(48);
			_la = _input.LA(1);
			if ( !(_la==DIGIT || _la==LETTER) ) {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return exprs_sempred((ExprsContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exprs_sempred(ExprsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\13\65\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\7\3\31\n\3\f\3\16\3\34\13\3\3\4\3\4\3\4\3\4\5\4\"\n\4\3\5\3\5\3"+
		"\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\2\3\4\t"+
		"\2\4\6\b\n\f\16\2\3\3\2\4\5\2\61\2\20\3\2\2\2\4\22\3\2\2\2\6!\3\2\2\2"+
		"\b#\3\2\2\2\n&\3\2\2\2\f+\3\2\2\2\16\60\3\2\2\2\20\21\5\4\3\2\21\3\3\2"+
		"\2\2\22\23\b\3\1\2\23\24\5\6\4\2\24\25\7\6\2\2\25\32\3\2\2\2\26\27\f\3"+
		"\2\2\27\31\5\4\3\4\30\26\3\2\2\2\31\34\3\2\2\2\32\30\3\2\2\2\32\33\3\2"+
		"\2\2\33\5\3\2\2\2\34\32\3\2\2\2\35\"\5\n\6\2\36\"\5\f\7\2\37\"\5\b\5\2"+
		" \"\5\16\b\2!\35\3\2\2\2!\36\3\2\2\2!\37\3\2\2\2! \3\2\2\2\"\7\3\2\2\2"+
		"#$\7\7\2\2$%\7\5\2\2%\t\3\2\2\2&\'\7\t\2\2\'(\7\5\2\2()\7\3\2\2)*\7\4"+
		"\2\2*\13\3\2\2\2+,\7\n\2\2,-\7\5\2\2-.\7\3\2\2./\7\4\2\2/\r\3\2\2\2\60"+
		"\61\t\2\2\2\61\62\7\b\2\2\62\63\t\2\2\2\63\17\3\2\2\2\4\32!";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}