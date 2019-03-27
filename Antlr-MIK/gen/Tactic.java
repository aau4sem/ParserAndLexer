// Generated from /Users/mathiashindsgaul/Documents/4.Semester/ParserAndLexer/Antlr-MIK/Tactic.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Tactic extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NEW=1, LPAREN=2, RPAREN=3, LCURLY=4, RCURLY=5, TEAM=6, PLAYER=7, BOARD=8, 
		INTEGER=9, BOOL=10, SEPERATOR=11, IF=12, ELSEIF=13, ELSE=14, TRUE=15, 
		FLASE=16, FOR=17, WHILE=18, DOT=19, STRING_MARK=20, DIGIT=21, LETTER=22, 
		WORD=23, NUMBER=24, ASSIGN=25, ADDITION=26, SUBTRACTION=27, DIVISION=28, 
		MULTIPLY=29, MODULO=30, ENDSTNT=31, BOOL_EQUAL=32, BOOL_N_EQUAL=33, BOOL_COND_AND=34, 
		BOOL_COND_OR=35, BOOL_LESS=36, BOOL_GREATER=37, BOOL_LESS_OR_EQUAL=38, 
		BOOL_GREATER_OR_EQUAL=39, INCREMENT=40, WS=41, COMMENT=42, LINE_COMMENT=43, 
		BLOCK=44, FALSE=45;
	public static final int
		RULE_start = 0, RULE_exprs = 1, RULE_expr = 2, RULE_exprNEs = 3, RULE_integer = 4, 
		RULE_word = 5, RULE_string = 6, RULE_identifier = 7, RULE_value = 8, RULE_dotStmt = 9, 
		RULE_boardDcl = 10, RULE_intDcl = 11, RULE_boolDcl = 12, RULE_arithExpr = 13, 
		RULE_addExpr = 14, RULE_subExpr = 15, RULE_divExpr = 16, RULE_mulExpr = 17, 
		RULE_modExpr = 18, RULE_buildInClass = 19, RULE_instantiation = 20, RULE_type = 21, 
		RULE_arguments = 22, RULE_condStmt = 23, RULE_block = 24, RULE_ifStmt = 25, 
		RULE_elseifStmt = 26, RULE_elseStmt = 27, RULE_loopStmt = 28, RULE_forStmt = 29, 
		RULE_whileStmt = 30, RULE_boolStmt = 31, RULE_bool = 32, RULE_boolOperaters = 33;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "exprs", "expr", "exprNEs", "integer", "word", "string", "identifier", 
			"value", "dotStmt", "boardDcl", "intDcl", "boolDcl", "arithExpr", "addExpr", 
			"subExpr", "divExpr", "mulExpr", "modExpr", "buildInClass", "instantiation", 
			"type", "arguments", "condStmt", "block", "ifStmt", "elseifStmt", "elseStmt", 
			"loopStmt", "forStmt", "whileStmt", "boolStmt", "bool", "boolOperaters"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'new'", "'('", "')'", "'{'", "'}'", "'Team'", "'Player'", "'Board'", 
			"'int'", "'bool'", "','", "'if'", "'elseif'", "'else'", "'true'", "'false'", 
			"'for'", "'while'", "'.'", "'\"'", null, null, null, null, "'='", "'+'", 
			"'-'", "' / '", "'*'", "'%'", "';'", "'=='", "'!='", "'&&'", "'||'", 
			"'<'", "'>'", "'<='", "'>='", "'++'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NEW", "LPAREN", "RPAREN", "LCURLY", "RCURLY", "TEAM", "PLAYER", 
			"BOARD", "INTEGER", "BOOL", "SEPERATOR", "IF", "ELSEIF", "ELSE", "TRUE", 
			"FLASE", "FOR", "WHILE", "DOT", "STRING_MARK", "DIGIT", "LETTER", "WORD", 
			"NUMBER", "ASSIGN", "ADDITION", "SUBTRACTION", "DIVISION", "MULTIPLY", 
			"MODULO", "ENDSTNT", "BOOL_EQUAL", "BOOL_N_EQUAL", "BOOL_COND_AND", "BOOL_COND_OR", 
			"BOOL_LESS", "BOOL_GREATER", "BOOL_LESS_OR_EQUAL", "BOOL_GREATER_OR_EQUAL", 
			"INCREMENT", "WS", "COMMENT", "LINE_COMMENT", "BLOCK", "FALSE"
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
	public String getGrammarFileName() { return "Tactic.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Tactic(TokenStream input) {
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
			if ( listener instanceof TacticListener ) ((TacticListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacticVisitor ) return ((TacticVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
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
		public TerminalNode ENDSTNT() { return getToken(Tactic.ENDSTNT, 0); }
		public ExprNEsContext exprNEs() {
			return getRuleContext(ExprNEsContext.class,0);
		}
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
			if ( listener instanceof TacticListener ) ((TacticListener)listener).enterExprs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).exitExprs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacticVisitor ) return ((TacticVisitor<? extends T>)visitor).visitExprs(this);
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
			setState(75);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TEAM:
			case PLAYER:
			case BOARD:
			case INTEGER:
			case BOOL:
			case DIGIT:
			case LETTER:
			case WORD:
			case NUMBER:
				{
				setState(71);
				expr();
				setState(72);
				match(ENDSTNT);
				}
				break;
			case IF:
			case FOR:
			case WHILE:
				{
				setState(74);
				exprNEs(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(81);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprsContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_exprs);
					setState(77);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(78);
					exprs(3);
					}
					} 
				}
				setState(83);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
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
		public ArithExprContext arithExpr() {
			return getRuleContext(ArithExprContext.class,0);
		}
		public InstantiationContext instantiation() {
			return getRuleContext(InstantiationContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public DotStmtContext dotStmt() {
			return getRuleContext(DotStmtContext.class,0);
		}
		public BoardDclContext boardDcl() {
			return getRuleContext(BoardDclContext.class,0);
		}
		public IntDclContext intDcl() {
			return getRuleContext(IntDclContext.class,0);
		}
		public BoolDclContext boolDcl() {
			return getRuleContext(BoolDclContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacticVisitor ) return ((TacticVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_expr);
		try {
			setState(91);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(84);
				arithExpr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(85);
				instantiation();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(86);
				identifier();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(87);
				dotStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(88);
				boardDcl();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(89);
				intDcl();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(90);
				boolDcl();
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

	public static class ExprNEsContext extends ParserRuleContext {
		public CondStmtContext condStmt() {
			return getRuleContext(CondStmtContext.class,0);
		}
		public LoopStmtContext loopStmt() {
			return getRuleContext(LoopStmtContext.class,0);
		}
		public List<ExprNEsContext> exprNEs() {
			return getRuleContexts(ExprNEsContext.class);
		}
		public ExprNEsContext exprNEs(int i) {
			return getRuleContext(ExprNEsContext.class,i);
		}
		public ExprNEsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprNEs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).enterExprNEs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).exitExprNEs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacticVisitor ) return ((TacticVisitor<? extends T>)visitor).visitExprNEs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprNEsContext exprNEs() throws RecognitionException {
		return exprNEs(0);
	}

	private ExprNEsContext exprNEs(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprNEsContext _localctx = new ExprNEsContext(_ctx, _parentState);
		ExprNEsContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_exprNEs, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				{
				setState(94);
				condStmt();
				}
				break;
			case FOR:
			case WHILE:
				{
				setState(95);
				loopStmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(102);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprNEsContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_exprNEs);
					setState(98);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(99);
					exprNEs(4);
					}
					} 
				}
				setState(104);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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

	public static class IntegerContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(Tactic.NUMBER, 0); }
		public TerminalNode DIGIT() { return getToken(Tactic.DIGIT, 0); }
		public IntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).exitInteger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacticVisitor ) return ((TacticVisitor<? extends T>)visitor).visitInteger(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegerContext integer() throws RecognitionException {
		IntegerContext _localctx = new IntegerContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_integer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			_la = _input.LA(1);
			if ( !(_la==DIGIT || _la==NUMBER) ) {
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

	public static class WordContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(Tactic.WORD, 0); }
		public TerminalNode LETTER() { return getToken(Tactic.LETTER, 0); }
		public WordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_word; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).enterWord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).exitWord(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacticVisitor ) return ((TacticVisitor<? extends T>)visitor).visitWord(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WordContext word() throws RecognitionException {
		WordContext _localctx = new WordContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_word);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			_la = _input.LA(1);
			if ( !(_la==LETTER || _la==WORD) ) {
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

	public static class StringContext extends ParserRuleContext {
		public List<TerminalNode> STRING_MARK() { return getTokens(Tactic.STRING_MARK); }
		public TerminalNode STRING_MARK(int i) {
			return getToken(Tactic.STRING_MARK, i);
		}
		public WordContext word() {
			return getRuleContext(WordContext.class,0);
		}
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).exitString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacticVisitor ) return ((TacticVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(STRING_MARK);
			setState(110);
			word();
			setState(111);
			match(STRING_MARK);
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

	public static class IdentifierContext extends ParserRuleContext {
		public WordContext word() {
			return getRuleContext(WordContext.class,0);
		}
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacticVisitor ) return ((TacticVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			word();
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

	public static class ValueContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacticVisitor ) return ((TacticVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_value);
		try {
			setState(118);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LETTER:
			case WORD:
				enterOuterAlt(_localctx, 1);
				{
				setState(115);
				identifier();
				}
				break;
			case DIGIT:
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
				integer();
				}
				break;
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 3);
				{
				setState(117);
				bool();
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

	public static class DotStmtContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(Tactic.DOT, 0); }
		public TerminalNode LPAREN() { return getToken(Tactic.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(Tactic.RPAREN, 0); }
		public BuildInClassContext buildInClass() {
			return getRuleContext(BuildInClassContext.class,0);
		}
		public TerminalNode BOARD() { return getToken(Tactic.BOARD, 0); }
		public List<ArgumentsContext> arguments() {
			return getRuleContexts(ArgumentsContext.class);
		}
		public ArgumentsContext arguments(int i) {
			return getRuleContext(ArgumentsContext.class,i);
		}
		public DotStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dotStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).enterDotStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).exitDotStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacticVisitor ) return ((TacticVisitor<? extends T>)visitor).visitDotStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DotStmtContext dotStmt() throws RecognitionException {
		DotStmtContext _localctx = new DotStmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_dotStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TEAM:
			case PLAYER:
				{
				setState(120);
				buildInClass();
				}
				break;
			case BOARD:
				{
				setState(121);
				match(BOARD);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(124);
			match(DOT);
			setState(125);
			match(LPAREN);
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << STRING_MARK) | (1L << DIGIT) | (1L << LETTER) | (1L << WORD) | (1L << NUMBER) | (1L << FALSE))) != 0)) {
				{
				{
				setState(126);
				arguments(0);
				}
				}
				setState(131);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(132);
			match(RPAREN);
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

	public static class BoardDclContext extends ParserRuleContext {
		public TerminalNode BOARD() { return getToken(Tactic.BOARD, 0); }
		public TerminalNode LPAREN() { return getToken(Tactic.LPAREN, 0); }
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Tactic.RPAREN, 0); }
		public BoardDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boardDcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).enterBoardDcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).exitBoardDcl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacticVisitor ) return ((TacticVisitor<? extends T>)visitor).visitBoardDcl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoardDclContext boardDcl() throws RecognitionException {
		BoardDclContext _localctx = new BoardDclContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_boardDcl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(BOARD);
			setState(135);
			match(LPAREN);
			setState(136);
			string();
			setState(137);
			match(RPAREN);
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
		public TerminalNode INTEGER() { return getToken(Tactic.INTEGER, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(Tactic.ASSIGN, 0); }
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public IntDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intDcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).enterIntDcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).exitIntDcl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacticVisitor ) return ((TacticVisitor<? extends T>)visitor).visitIntDcl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntDclContext intDcl() throws RecognitionException {
		IntDclContext _localctx = new IntDclContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_intDcl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(INTEGER);
			setState(140);
			identifier();
			setState(141);
			match(ASSIGN);
			setState(142);
			integer();
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

	public static class BoolDclContext extends ParserRuleContext {
		public TerminalNode BOOL() { return getToken(Tactic.BOOL, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(Tactic.ASSIGN, 0); }
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public BoolDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolDcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).enterBoolDcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).exitBoolDcl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacticVisitor ) return ((TacticVisitor<? extends T>)visitor).visitBoolDcl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolDclContext boolDcl() throws RecognitionException {
		BoolDclContext _localctx = new BoolDclContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_boolDcl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(BOOL);
			setState(145);
			identifier();
			setState(146);
			match(ASSIGN);
			setState(147);
			bool();
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

	public static class ArithExprContext extends ParserRuleContext {
		public AddExprContext addExpr() {
			return getRuleContext(AddExprContext.class,0);
		}
		public SubExprContext subExpr() {
			return getRuleContext(SubExprContext.class,0);
		}
		public DivExprContext divExpr() {
			return getRuleContext(DivExprContext.class,0);
		}
		public MulExprContext mulExpr() {
			return getRuleContext(MulExprContext.class,0);
		}
		public ModExprContext modExpr() {
			return getRuleContext(ModExprContext.class,0);
		}
		public ArithExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).enterArithExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).exitArithExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacticVisitor ) return ((TacticVisitor<? extends T>)visitor).visitArithExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithExprContext arithExpr() throws RecognitionException {
		ArithExprContext _localctx = new ArithExprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_arithExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(149);
				addExpr();
				}
				break;
			case 2:
				{
				setState(150);
				subExpr();
				}
				break;
			case 3:
				{
				setState(151);
				divExpr();
				}
				break;
			case 4:
				{
				setState(152);
				mulExpr();
				}
				break;
			case 5:
				{
				setState(153);
				modExpr();
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

	public static class AddExprContext extends ParserRuleContext {
		public TerminalNode ADDITION() { return getToken(Tactic.ADDITION, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<IntegerContext> integer() {
			return getRuleContexts(IntegerContext.class);
		}
		public IntegerContext integer(int i) {
			return getRuleContext(IntegerContext.class,i);
		}
		public AddExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).enterAddExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).exitAddExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacticVisitor ) return ((TacticVisitor<? extends T>)visitor).visitAddExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddExprContext addExpr() throws RecognitionException {
		AddExprContext _localctx = new AddExprContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_addExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LETTER:
			case WORD:
				{
				setState(156);
				identifier();
				}
				break;
			case DIGIT:
			case NUMBER:
				{
				setState(157);
				integer();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(160);
			match(ADDITION);
			setState(163);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LETTER:
			case WORD:
				{
				setState(161);
				identifier();
				}
				break;
			case DIGIT:
			case NUMBER:
				{
				setState(162);
				integer();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class SubExprContext extends ParserRuleContext {
		public TerminalNode SUBTRACTION() { return getToken(Tactic.SUBTRACTION, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<IntegerContext> integer() {
			return getRuleContexts(IntegerContext.class);
		}
		public IntegerContext integer(int i) {
			return getRuleContext(IntegerContext.class,i);
		}
		public SubExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).enterSubExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).exitSubExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacticVisitor ) return ((TacticVisitor<? extends T>)visitor).visitSubExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubExprContext subExpr() throws RecognitionException {
		SubExprContext _localctx = new SubExprContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_subExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LETTER:
			case WORD:
				{
				setState(165);
				identifier();
				}
				break;
			case DIGIT:
			case NUMBER:
				{
				setState(166);
				integer();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(169);
			match(SUBTRACTION);
			setState(172);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LETTER:
			case WORD:
				{
				setState(170);
				identifier();
				}
				break;
			case DIGIT:
			case NUMBER:
				{
				setState(171);
				integer();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class DivExprContext extends ParserRuleContext {
		public TerminalNode DIVISION() { return getToken(Tactic.DIVISION, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<IntegerContext> integer() {
			return getRuleContexts(IntegerContext.class);
		}
		public IntegerContext integer(int i) {
			return getRuleContext(IntegerContext.class,i);
		}
		public DivExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_divExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).enterDivExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).exitDivExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacticVisitor ) return ((TacticVisitor<? extends T>)visitor).visitDivExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DivExprContext divExpr() throws RecognitionException {
		DivExprContext _localctx = new DivExprContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_divExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LETTER:
			case WORD:
				{
				setState(174);
				identifier();
				}
				break;
			case DIGIT:
			case NUMBER:
				{
				setState(175);
				integer();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(178);
			match(DIVISION);
			setState(181);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LETTER:
			case WORD:
				{
				setState(179);
				identifier();
				}
				break;
			case DIGIT:
			case NUMBER:
				{
				setState(180);
				integer();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class MulExprContext extends ParserRuleContext {
		public TerminalNode MULTIPLY() { return getToken(Tactic.MULTIPLY, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<IntegerContext> integer() {
			return getRuleContexts(IntegerContext.class);
		}
		public IntegerContext integer(int i) {
			return getRuleContext(IntegerContext.class,i);
		}
		public MulExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).enterMulExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).exitMulExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacticVisitor ) return ((TacticVisitor<? extends T>)visitor).visitMulExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MulExprContext mulExpr() throws RecognitionException {
		MulExprContext _localctx = new MulExprContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_mulExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LETTER:
			case WORD:
				{
				setState(183);
				identifier();
				}
				break;
			case DIGIT:
			case NUMBER:
				{
				setState(184);
				integer();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(187);
			match(MULTIPLY);
			setState(190);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LETTER:
			case WORD:
				{
				setState(188);
				identifier();
				}
				break;
			case DIGIT:
			case NUMBER:
				{
				setState(189);
				integer();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ModExprContext extends ParserRuleContext {
		public TerminalNode MODULO() { return getToken(Tactic.MODULO, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<IntegerContext> integer() {
			return getRuleContexts(IntegerContext.class);
		}
		public IntegerContext integer(int i) {
			return getRuleContext(IntegerContext.class,i);
		}
		public ModExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).enterModExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).exitModExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacticVisitor ) return ((TacticVisitor<? extends T>)visitor).visitModExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModExprContext modExpr() throws RecognitionException {
		ModExprContext _localctx = new ModExprContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_modExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LETTER:
			case WORD:
				{
				setState(192);
				identifier();
				}
				break;
			case DIGIT:
			case NUMBER:
				{
				setState(193);
				integer();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(196);
			match(MODULO);
			setState(199);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LETTER:
			case WORD:
				{
				setState(197);
				identifier();
				}
				break;
			case DIGIT:
			case NUMBER:
				{
				setState(198);
				integer();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class BuildInClassContext extends ParserRuleContext {
		public TerminalNode TEAM() { return getToken(Tactic.TEAM, 0); }
		public TerminalNode PLAYER() { return getToken(Tactic.PLAYER, 0); }
		public BuildInClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_buildInClass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).enterBuildInClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).exitBuildInClass(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacticVisitor ) return ((TacticVisitor<? extends T>)visitor).visitBuildInClass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BuildInClassContext buildInClass() throws RecognitionException {
		BuildInClassContext _localctx = new BuildInClassContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_buildInClass);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			_la = _input.LA(1);
			if ( !(_la==TEAM || _la==PLAYER) ) {
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

	public static class InstantiationContext extends ParserRuleContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(Tactic.ASSIGN, 0); }
		public TerminalNode NEW() { return getToken(Tactic.NEW, 0); }
		public TerminalNode LPAREN() { return getToken(Tactic.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(Tactic.RPAREN, 0); }
		public List<ArgumentsContext> arguments() {
			return getRuleContexts(ArgumentsContext.class);
		}
		public ArgumentsContext arguments(int i) {
			return getRuleContext(ArgumentsContext.class,i);
		}
		public InstantiationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instantiation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).enterInstantiation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).exitInstantiation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacticVisitor ) return ((TacticVisitor<? extends T>)visitor).visitInstantiation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstantiationContext instantiation() throws RecognitionException {
		InstantiationContext _localctx = new InstantiationContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_instantiation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			type();
			setState(204);
			identifier();
			setState(205);
			match(ASSIGN);
			setState(206);
			match(NEW);
			setState(207);
			type();
			setState(208);
			match(LPAREN);
			setState(212);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << STRING_MARK) | (1L << DIGIT) | (1L << LETTER) | (1L << WORD) | (1L << NUMBER) | (1L << FALSE))) != 0)) {
				{
				{
				setState(209);
				arguments(0);
				}
				}
				setState(214);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(215);
			match(RPAREN);
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

	public static class TypeContext extends ParserRuleContext {
		public BuildInClassContext buildInClass() {
			return getRuleContext(BuildInClassContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacticVisitor ) return ((TacticVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			buildInClass();
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
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public List<ArgumentsContext> arguments() {
			return getRuleContexts(ArgumentsContext.class);
		}
		public ArgumentsContext arguments(int i) {
			return getRuleContext(ArgumentsContext.class,i);
		}
		public TerminalNode SEPERATOR() { return getToken(Tactic.SEPERATOR, 0); }
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).exitArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacticVisitor ) return ((TacticVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		return arguments(0);
	}

	private ArgumentsContext arguments(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, _parentState);
		ArgumentsContext _prevctx = _localctx;
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_arguments, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(220);
				identifier();
				}
				break;
			case 2:
				{
				setState(221);
				string();
				}
				break;
			case 3:
				{
				setState(222);
				value();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(230);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArgumentsContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_arguments);
					setState(225);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(226);
					match(SEPERATOR);
					setState(227);
					arguments(4);
					}
					} 
				}
				setState(232);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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

	public static class CondStmtContext extends ParserRuleContext {
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public List<ElseifStmtContext> elseifStmt() {
			return getRuleContexts(ElseifStmtContext.class);
		}
		public ElseifStmtContext elseifStmt(int i) {
			return getRuleContext(ElseifStmtContext.class,i);
		}
		public ElseStmtContext elseStmt() {
			return getRuleContext(ElseStmtContext.class,0);
		}
		public CondStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).enterCondStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).exitCondStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacticVisitor ) return ((TacticVisitor<? extends T>)visitor).visitCondStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondStmtContext condStmt() throws RecognitionException {
		CondStmtContext _localctx = new CondStmtContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_condStmt);
		try {
			int _alt;
			setState(244);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(233);
				ifStmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(234);
				ifStmt();
				setState(238);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(235);
						elseifStmt();
						}
						} 
					}
					setState(240);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
				}
				setState(242);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(241);
					elseStmt();
					}
					break;
				}
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

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LCURLY() { return getToken(Tactic.LCURLY, 0); }
		public ExprsContext exprs() {
			return getRuleContext(ExprsContext.class,0);
		}
		public TerminalNode RCURLY() { return getToken(Tactic.RCURLY, 0); }
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacticVisitor ) return ((TacticVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_block);
		try {
			setState(252);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(246);
				match(LCURLY);
				setState(247);
				exprs(0);
				setState(248);
				match(RCURLY);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(250);
				match(LCURLY);
				setState(251);
				match(RCURLY);
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

	public static class IfStmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(Tactic.IF, 0); }
		public TerminalNode LPAREN() { return getToken(Tactic.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(Tactic.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BoolStmtContext boolStmt() {
			return getRuleContext(BoolStmtContext.class,0);
		}
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).enterIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).exitIfStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacticVisitor ) return ((TacticVisitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_ifStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			match(IF);
			setState(255);
			match(LPAREN);
			{
			setState(256);
			boolStmt();
			}
			setState(257);
			match(RPAREN);
			setState(258);
			block();
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

	public static class ElseifStmtContext extends ParserRuleContext {
		public TerminalNode ELSEIF() { return getToken(Tactic.ELSEIF, 0); }
		public TerminalNode LPAREN() { return getToken(Tactic.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(Tactic.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BoolStmtContext boolStmt() {
			return getRuleContext(BoolStmtContext.class,0);
		}
		public ElseifStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseifStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).enterElseifStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).exitElseifStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacticVisitor ) return ((TacticVisitor<? extends T>)visitor).visitElseifStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseifStmtContext elseifStmt() throws RecognitionException {
		ElseifStmtContext _localctx = new ElseifStmtContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_elseifStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			match(ELSEIF);
			setState(261);
			match(LPAREN);
			{
			setState(262);
			boolStmt();
			}
			setState(263);
			match(RPAREN);
			setState(264);
			block();
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

	public static class ElseStmtContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(Tactic.ELSE, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ElseStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).enterElseStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).exitElseStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacticVisitor ) return ((TacticVisitor<? extends T>)visitor).visitElseStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseStmtContext elseStmt() throws RecognitionException {
		ElseStmtContext _localctx = new ElseStmtContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_elseStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			match(ELSE);
			setState(267);
			block();
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

	public static class LoopStmtContext extends ParserRuleContext {
		public ForStmtContext forStmt() {
			return getRuleContext(ForStmtContext.class,0);
		}
		public WhileStmtContext whileStmt() {
			return getRuleContext(WhileStmtContext.class,0);
		}
		public LoopStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).enterLoopStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).exitLoopStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacticVisitor ) return ((TacticVisitor<? extends T>)visitor).visitLoopStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopStmtContext loopStmt() throws RecognitionException {
		LoopStmtContext _localctx = new LoopStmtContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_loopStmt);
		try {
			setState(271);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(269);
				forStmt();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(270);
				whileStmt();
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

	public static class ForStmtContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(Tactic.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(Tactic.LPAREN, 0); }
		public List<TerminalNode> ENDSTNT() { return getTokens(Tactic.ENDSTNT); }
		public TerminalNode ENDSTNT(int i) {
			return getToken(Tactic.ENDSTNT, i);
		}
		public BoolStmtContext boolStmt() {
			return getRuleContext(BoolStmtContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Tactic.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public IntDclContext intDcl() {
			return getRuleContext(IntDclContext.class,0);
		}
		public TerminalNode INCREMENT() { return getToken(Tactic.INCREMENT, 0); }
		public ForStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).enterForStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).exitForStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacticVisitor ) return ((TacticVisitor<? extends T>)visitor).visitForStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStmtContext forStmt() throws RecognitionException {
		ForStmtContext _localctx = new ForStmtContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_forStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			match(FOR);
			setState(274);
			match(LPAREN);
			setState(277);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LETTER:
			case WORD:
				{
				setState(275);
				identifier();
				}
				break;
			case INTEGER:
				{
				setState(276);
				intDcl();
				}
				break;
			case ENDSTNT:
				break;
			default:
				break;
			}
			setState(279);
			match(ENDSTNT);
			setState(280);
			boolStmt();
			setState(281);
			match(ENDSTNT);
			setState(285);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LETTER || _la==WORD) {
				{
				setState(282);
				identifier();
				setState(283);
				match(INCREMENT);
				}
			}

			setState(287);
			match(RPAREN);
			setState(288);
			block();
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

	public static class WhileStmtContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(Tactic.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(Tactic.LPAREN, 0); }
		public BoolStmtContext boolStmt() {
			return getRuleContext(BoolStmtContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Tactic.RPAREN, 0); }
		public TerminalNode BLOCK() { return getToken(Tactic.BLOCK, 0); }
		public WhileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).enterWhileStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).exitWhileStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacticVisitor ) return ((TacticVisitor<? extends T>)visitor).visitWhileStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStmtContext whileStmt() throws RecognitionException {
		WhileStmtContext _localctx = new WhileStmtContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_whileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			match(WHILE);
			setState(291);
			match(LPAREN);
			setState(292);
			boolStmt();
			setState(293);
			match(RPAREN);
			setState(294);
			match(BLOCK);
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

	public static class BoolStmtContext extends ParserRuleContext {
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public BoolOperatersContext boolOperaters() {
			return getRuleContext(BoolOperatersContext.class,0);
		}
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public BoolStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).enterBoolStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).exitBoolStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacticVisitor ) return ((TacticVisitor<? extends T>)visitor).visitBoolStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolStmtContext boolStmt() throws RecognitionException {
		BoolStmtContext _localctx = new BoolStmtContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_boolStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(296);
				value();
				setState(297);
				boolOperaters();
				setState(298);
				value();
				}
				break;
			case 2:
				{
				setState(300);
				bool();
				}
				break;
			case 3:
				{
				setState(301);
				identifier();
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

	public static class BoolContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(Tactic.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(Tactic.FALSE, 0); }
		public BoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).exitBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacticVisitor ) return ((TacticVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolContext bool() throws RecognitionException {
		BoolContext _localctx = new BoolContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_bool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
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

	public static class BoolOperatersContext extends ParserRuleContext {
		public TerminalNode BOOL_EQUAL() { return getToken(Tactic.BOOL_EQUAL, 0); }
		public TerminalNode BOOL_N_EQUAL() { return getToken(Tactic.BOOL_N_EQUAL, 0); }
		public TerminalNode BOOL_COND_AND() { return getToken(Tactic.BOOL_COND_AND, 0); }
		public TerminalNode BOOL_COND_OR() { return getToken(Tactic.BOOL_COND_OR, 0); }
		public TerminalNode BOOL_LESS() { return getToken(Tactic.BOOL_LESS, 0); }
		public TerminalNode BOOL_GREATER() { return getToken(Tactic.BOOL_GREATER, 0); }
		public TerminalNode BOOL_LESS_OR_EQUAL() { return getToken(Tactic.BOOL_LESS_OR_EQUAL, 0); }
		public TerminalNode BOOL_GREATER_OR_EQUAL() { return getToken(Tactic.BOOL_GREATER_OR_EQUAL, 0); }
		public BoolOperatersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolOperaters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).enterBoolOperaters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).exitBoolOperaters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacticVisitor ) return ((TacticVisitor<? extends T>)visitor).visitBoolOperaters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolOperatersContext boolOperaters() throws RecognitionException {
		BoolOperatersContext _localctx = new BoolOperatersContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_boolOperaters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL_EQUAL) | (1L << BOOL_N_EQUAL) | (1L << BOOL_COND_AND) | (1L << BOOL_COND_OR) | (1L << BOOL_LESS) | (1L << BOOL_GREATER) | (1L << BOOL_LESS_OR_EQUAL) | (1L << BOOL_GREATER_OR_EQUAL))) != 0)) ) {
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
		case 3:
			return exprNEs_sempred((ExprNEsContext)_localctx, predIndex);
		case 22:
			return arguments_sempred((ArgumentsContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exprs_sempred(ExprsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean exprNEs_sempred(ExprNEsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean arguments_sempred(ArgumentsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3/\u0137\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\3\2\3\3\3\3\3\3\3\3\3\3\5\3N\n\3\3\3\3\3\7\3R\n"+
		"\3\f\3\16\3U\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4^\n\4\3\5\3\5\3\5\5\5"+
		"c\n\5\3\5\3\5\7\5g\n\5\f\5\16\5j\13\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b"+
		"\3\t\3\t\3\n\3\n\3\n\5\ny\n\n\3\13\3\13\5\13}\n\13\3\13\3\13\3\13\7\13"+
		"\u0082\n\13\f\13\16\13\u0085\13\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3"+
		"\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\5\17"+
		"\u009d\n\17\3\20\3\20\5\20\u00a1\n\20\3\20\3\20\3\20\5\20\u00a6\n\20\3"+
		"\21\3\21\5\21\u00aa\n\21\3\21\3\21\3\21\5\21\u00af\n\21\3\22\3\22\5\22"+
		"\u00b3\n\22\3\22\3\22\3\22\5\22\u00b8\n\22\3\23\3\23\5\23\u00bc\n\23\3"+
		"\23\3\23\3\23\5\23\u00c1\n\23\3\24\3\24\5\24\u00c5\n\24\3\24\3\24\3\24"+
		"\5\24\u00ca\n\24\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\7\26\u00d5"+
		"\n\26\f\26\16\26\u00d8\13\26\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\30\5"+
		"\30\u00e2\n\30\3\30\3\30\3\30\7\30\u00e7\n\30\f\30\16\30\u00ea\13\30\3"+
		"\31\3\31\3\31\7\31\u00ef\n\31\f\31\16\31\u00f2\13\31\3\31\5\31\u00f5\n"+
		"\31\5\31\u00f7\n\31\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u00ff\n\32\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35"+
		"\3\36\3\36\5\36\u0112\n\36\3\37\3\37\3\37\3\37\5\37\u0118\n\37\3\37\3"+
		"\37\3\37\3\37\3\37\3\37\5\37\u0120\n\37\3\37\3\37\3\37\3 \3 \3 \3 \3 "+
		"\3 \3!\3!\3!\3!\3!\3!\5!\u0131\n!\3\"\3\"\3#\3#\3#\2\5\4\b.$\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BD\2\7\4\2\27\27"+
		"\32\32\3\2\30\31\3\2\b\t\4\2\21\21//\3\2\")\2\u013e\2F\3\2\2\2\4M\3\2"+
		"\2\2\6]\3\2\2\2\bb\3\2\2\2\nk\3\2\2\2\fm\3\2\2\2\16o\3\2\2\2\20s\3\2\2"+
		"\2\22x\3\2\2\2\24|\3\2\2\2\26\u0088\3\2\2\2\30\u008d\3\2\2\2\32\u0092"+
		"\3\2\2\2\34\u009c\3\2\2\2\36\u00a0\3\2\2\2 \u00a9\3\2\2\2\"\u00b2\3\2"+
		"\2\2$\u00bb\3\2\2\2&\u00c4\3\2\2\2(\u00cb\3\2\2\2*\u00cd\3\2\2\2,\u00db"+
		"\3\2\2\2.\u00e1\3\2\2\2\60\u00f6\3\2\2\2\62\u00fe\3\2\2\2\64\u0100\3\2"+
		"\2\2\66\u0106\3\2\2\28\u010c\3\2\2\2:\u0111\3\2\2\2<\u0113\3\2\2\2>\u0124"+
		"\3\2\2\2@\u0130\3\2\2\2B\u0132\3\2\2\2D\u0134\3\2\2\2FG\5\4\3\2G\3\3\2"+
		"\2\2HI\b\3\1\2IJ\5\6\4\2JK\7!\2\2KN\3\2\2\2LN\5\b\5\2MH\3\2\2\2ML\3\2"+
		"\2\2NS\3\2\2\2OP\f\4\2\2PR\5\4\3\5QO\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2"+
		"\2\2T\5\3\2\2\2US\3\2\2\2V^\5\34\17\2W^\5*\26\2X^\5\20\t\2Y^\5\24\13\2"+
		"Z^\5\26\f\2[^\5\30\r\2\\^\5\32\16\2]V\3\2\2\2]W\3\2\2\2]X\3\2\2\2]Y\3"+
		"\2\2\2]Z\3\2\2\2][\3\2\2\2]\\\3\2\2\2^\7\3\2\2\2_`\b\5\1\2`c\5\60\31\2"+
		"ac\5:\36\2b_\3\2\2\2ba\3\2\2\2ch\3\2\2\2de\f\5\2\2eg\5\b\5\6fd\3\2\2\2"+
		"gj\3\2\2\2hf\3\2\2\2hi\3\2\2\2i\t\3\2\2\2jh\3\2\2\2kl\t\2\2\2l\13\3\2"+
		"\2\2mn\t\3\2\2n\r\3\2\2\2op\7\26\2\2pq\5\f\7\2qr\7\26\2\2r\17\3\2\2\2"+
		"st\5\f\7\2t\21\3\2\2\2uy\5\20\t\2vy\5\n\6\2wy\5B\"\2xu\3\2\2\2xv\3\2\2"+
		"\2xw\3\2\2\2y\23\3\2\2\2z}\5(\25\2{}\7\n\2\2|z\3\2\2\2|{\3\2\2\2}~\3\2"+
		"\2\2~\177\7\25\2\2\177\u0083\7\4\2\2\u0080\u0082\5.\30\2\u0081\u0080\3"+
		"\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084"+
		"\u0086\3\2\2\2\u0085\u0083\3\2\2\2\u0086\u0087\7\5\2\2\u0087\25\3\2\2"+
		"\2\u0088\u0089\7\n\2\2\u0089\u008a\7\4\2\2\u008a\u008b\5\16\b\2\u008b"+
		"\u008c\7\5\2\2\u008c\27\3\2\2\2\u008d\u008e\7\13\2\2\u008e\u008f\5\20"+
		"\t\2\u008f\u0090\7\33\2\2\u0090\u0091\5\n\6\2\u0091\31\3\2\2\2\u0092\u0093"+
		"\7\f\2\2\u0093\u0094\5\20\t\2\u0094\u0095\7\33\2\2\u0095\u0096\5B\"\2"+
		"\u0096\33\3\2\2\2\u0097\u009d\5\36\20\2\u0098\u009d\5 \21\2\u0099\u009d"+
		"\5\"\22\2\u009a\u009d\5$\23\2\u009b\u009d\5&\24\2\u009c\u0097\3\2\2\2"+
		"\u009c\u0098\3\2\2\2\u009c\u0099\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009b"+
		"\3\2\2\2\u009d\35\3\2\2\2\u009e\u00a1\5\20\t\2\u009f\u00a1\5\n\6\2\u00a0"+
		"\u009e\3\2\2\2\u00a0\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a5\7\34"+
		"\2\2\u00a3\u00a6\5\20\t\2\u00a4\u00a6\5\n\6\2\u00a5\u00a3\3\2\2\2\u00a5"+
		"\u00a4\3\2\2\2\u00a6\37\3\2\2\2\u00a7\u00aa\5\20\t\2\u00a8\u00aa\5\n\6"+
		"\2\u00a9\u00a7\3\2\2\2\u00a9\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ae"+
		"\7\35\2\2\u00ac\u00af\5\20\t\2\u00ad\u00af\5\n\6\2\u00ae\u00ac\3\2\2\2"+
		"\u00ae\u00ad\3\2\2\2\u00af!\3\2\2\2\u00b0\u00b3\5\20\t\2\u00b1\u00b3\5"+
		"\n\6\2\u00b2\u00b0\3\2\2\2\u00b2\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4"+
		"\u00b7\7\36\2\2\u00b5\u00b8\5\20\t\2\u00b6\u00b8\5\n\6\2\u00b7\u00b5\3"+
		"\2\2\2\u00b7\u00b6\3\2\2\2\u00b8#\3\2\2\2\u00b9\u00bc\5\20\t\2\u00ba\u00bc"+
		"\5\n\6\2\u00bb\u00b9\3\2\2\2\u00bb\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd"+
		"\u00c0\7\37\2\2\u00be\u00c1\5\20\t\2\u00bf\u00c1\5\n\6\2\u00c0\u00be\3"+
		"\2\2\2\u00c0\u00bf\3\2\2\2\u00c1%\3\2\2\2\u00c2\u00c5\5\20\t\2\u00c3\u00c5"+
		"\5\n\6\2\u00c4\u00c2\3\2\2\2\u00c4\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6"+
		"\u00c9\7 \2\2\u00c7\u00ca\5\20\t\2\u00c8\u00ca\5\n\6\2\u00c9\u00c7\3\2"+
		"\2\2\u00c9\u00c8\3\2\2\2\u00ca\'\3\2\2\2\u00cb\u00cc\t\4\2\2\u00cc)\3"+
		"\2\2\2\u00cd\u00ce\5,\27\2\u00ce\u00cf\5\20\t\2\u00cf\u00d0\7\33\2\2\u00d0"+
		"\u00d1\7\3\2\2\u00d1\u00d2\5,\27\2\u00d2\u00d6\7\4\2\2\u00d3\u00d5\5."+
		"\30\2\u00d4\u00d3\3\2\2\2\u00d5\u00d8\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6"+
		"\u00d7\3\2\2\2\u00d7\u00d9\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d9\u00da\7\5"+
		"\2\2\u00da+\3\2\2\2\u00db\u00dc\5(\25\2\u00dc-\3\2\2\2\u00dd\u00de\b\30"+
		"\1\2\u00de\u00e2\5\20\t\2\u00df\u00e2\5\16\b\2\u00e0\u00e2\5\22\n\2\u00e1"+
		"\u00dd\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e0\3\2\2\2\u00e2\u00e8\3\2"+
		"\2\2\u00e3\u00e4\f\5\2\2\u00e4\u00e5\7\r\2\2\u00e5\u00e7\5.\30\6\u00e6"+
		"\u00e3\3\2\2\2\u00e7\u00ea\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e8\u00e9\3\2"+
		"\2\2\u00e9/\3\2\2\2\u00ea\u00e8\3\2\2\2\u00eb\u00f7\5\64\33\2\u00ec\u00f0"+
		"\5\64\33\2\u00ed\u00ef\5\66\34\2\u00ee\u00ed\3\2\2\2\u00ef\u00f2\3\2\2"+
		"\2\u00f0\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f4\3\2\2\2\u00f2\u00f0"+
		"\3\2\2\2\u00f3\u00f5\58\35\2\u00f4\u00f3\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5"+
		"\u00f7\3\2\2\2\u00f6\u00eb\3\2\2\2\u00f6\u00ec\3\2\2\2\u00f7\61\3\2\2"+
		"\2\u00f8\u00f9\7\6\2\2\u00f9\u00fa\5\4\3\2\u00fa\u00fb\7\7\2\2\u00fb\u00ff"+
		"\3\2\2\2\u00fc\u00fd\7\6\2\2\u00fd\u00ff\7\7\2\2\u00fe\u00f8\3\2\2\2\u00fe"+
		"\u00fc\3\2\2\2\u00ff\63\3\2\2\2\u0100\u0101\7\16\2\2\u0101\u0102\7\4\2"+
		"\2\u0102\u0103\5@!\2\u0103\u0104\7\5\2\2\u0104\u0105\5\62\32\2\u0105\65"+
		"\3\2\2\2\u0106\u0107\7\17\2\2\u0107\u0108\7\4\2\2\u0108\u0109\5@!\2\u0109"+
		"\u010a\7\5\2\2\u010a\u010b\5\62\32\2\u010b\67\3\2\2\2\u010c\u010d\7\20"+
		"\2\2\u010d\u010e\5\62\32\2\u010e9\3\2\2\2\u010f\u0112\5<\37\2\u0110\u0112"+
		"\5> \2\u0111\u010f\3\2\2\2\u0111\u0110\3\2\2\2\u0112;\3\2\2\2\u0113\u0114"+
		"\7\23\2\2\u0114\u0117\7\4\2\2\u0115\u0118\5\20\t\2\u0116\u0118\5\30\r"+
		"\2\u0117\u0115\3\2\2\2\u0117\u0116\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u0119"+
		"\3\2\2\2\u0119\u011a\7!\2\2\u011a\u011b\5@!\2\u011b\u011f\7!\2\2\u011c"+
		"\u011d\5\20\t\2\u011d\u011e\7*\2\2\u011e\u0120\3\2\2\2\u011f\u011c\3\2"+
		"\2\2\u011f\u0120\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0122\7\5\2\2\u0122"+
		"\u0123\5\62\32\2\u0123=\3\2\2\2\u0124\u0125\7\24\2\2\u0125\u0126\7\4\2"+
		"\2\u0126\u0127\5@!\2\u0127\u0128\7\5\2\2\u0128\u0129\7.\2\2\u0129?\3\2"+
		"\2\2\u012a\u012b\5\22\n\2\u012b\u012c\5D#\2\u012c\u012d\5\22\n\2\u012d"+
		"\u0131\3\2\2\2\u012e\u0131\5B\"\2\u012f\u0131\5\20\t\2\u0130\u012a\3\2"+
		"\2\2\u0130\u012e\3\2\2\2\u0130\u012f\3\2\2\2\u0131A\3\2\2\2\u0132\u0133"+
		"\t\5\2\2\u0133C\3\2\2\2\u0134\u0135\t\6\2\2\u0135E\3\2\2\2 MS]bhx|\u0083"+
		"\u009c\u00a0\u00a5\u00a9\u00ae\u00b2\u00b7\u00bb\u00c0\u00c4\u00c9\u00d6"+
		"\u00e1\u00e8\u00f0\u00f4\u00f6\u00fe\u0111\u0117\u011f\u0130";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}