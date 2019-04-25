// Generated from E:/SourceTree/ParserAndLexer/Antlr-MIK\Tactic.g4 by ANTLR 4.7.2
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
		LPAREN=1, RPAREN=2, LCURLY=3, RCURLY=4, LBRACKET=5, RBRACKET=6, GAMEPIECE=7, 
		BOARD=8, INTEGER=9, FLOAT=10, VEC=11, BOOL=12, SEPERATOR=13, IF=14, ELSEIF=15, 
		ELSE=16, TRUE=17, FALSE=18, FOR=19, WHILE=20, DOT=21, STRING_MARK=22, 
		STRING=23, VOID=24, RETURN=25, DIGIT=26, LETTER=27, WORD=28, NUMBER=29, 
		ASSIGN=30, ADDITION=31, SUBTRACTION=32, DIVISION=33, MULTIPLY=34, MODULO=35, 
		ENDSTNT=36, BOOL_EQUAL=37, BOOL_N_EQUAL=38, BOOL_COND_AND=39, BOOL_COND_OR=40, 
		BOOL_LESS=41, BOOL_GREATER=42, BOOL_LESS_OR_EQUAL=43, BOOL_GREATER_OR_EQUAL=44, 
		INCREMENT=45, WS=46, COMMENT=47, LINE_COMMENT=48, BLOCK=49;
	public static final int
		RULE_start = 0, RULE_exprs = 1, RULE_expr = 2, RULE_dcl = 3, RULE_exprNEs = 4, 
		RULE_integer = 5, RULE_floatVal = 6, RULE_number = 7, RULE_word = 8, RULE_string = 9, 
		RULE_identifier = 10, RULE_value = 11, RULE_vec = 12, RULE_function = 13, 
		RULE_functionDef = 14, RULE_functionBlock = 15, RULE_dotStmt = 16, RULE_dotAssignment = 17, 
		RULE_boardDcl = 18, RULE_intDcl = 19, RULE_floatDcl = 20, RULE_vecDcl = 21, 
		RULE_boolDcl = 22, RULE_stringDcl = 23, RULE_gpDcl = 24, RULE_arrayDcl = 25, 
		RULE_type = 26, RULE_arrayExpr = 27, RULE_arrayAssign = 28, RULE_arithExpr = 29, 
		RULE_addExpr = 30, RULE_subExpr = 31, RULE_divExpr = 32, RULE_mulExpr = 33, 
		RULE_modExpr = 34, RULE_arguments = 35, RULE_condStmt = 36, RULE_block = 37, 
		RULE_ifStmt = 38, RULE_elseifStmt = 39, RULE_elseStmt = 40, RULE_loopStmt = 41, 
		RULE_forStmt = 42, RULE_whileStmt = 43, RULE_boolStmt = 44, RULE_bool = 45, 
		RULE_boolOperaters = 46;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "exprs", "expr", "dcl", "exprNEs", "integer", "floatVal", "number", 
			"word", "string", "identifier", "value", "vec", "function", "functionDef", 
			"functionBlock", "dotStmt", "dotAssignment", "boardDcl", "intDcl", "floatDcl", 
			"vecDcl", "boolDcl", "stringDcl", "gpDcl", "arrayDcl", "type", "arrayExpr", 
			"arrayAssign", "arithExpr", "addExpr", "subExpr", "divExpr", "mulExpr", 
			"modExpr", "arguments", "condStmt", "block", "ifStmt", "elseifStmt", 
			"elseStmt", "loopStmt", "forStmt", "whileStmt", "boolStmt", "bool", "boolOperaters"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'{'", "'}'", "'['", "']'", "'GamePiece'", "'Board'", 
			"'int'", "'float'", "'vec'", "'bool'", "','", "'if'", "'elseif'", "'else'", 
			"'true'", "'false'", "'for'", "'while'", "'.'", "'\"'", "'string'", "'void'", 
			"'return'", null, null, null, null, "'='", "'+'", "'-'", "'/'", "'*'", 
			"'%'", "';'", "'=='", "'!='", "'&&'", "'||'", "'<'", "'>'", "'<='", "'>='", 
			"'++'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LPAREN", "RPAREN", "LCURLY", "RCURLY", "LBRACKET", "RBRACKET", 
			"GAMEPIECE", "BOARD", "INTEGER", "FLOAT", "VEC", "BOOL", "SEPERATOR", 
			"IF", "ELSEIF", "ELSE", "TRUE", "FALSE", "FOR", "WHILE", "DOT", "STRING_MARK", 
			"STRING", "VOID", "RETURN", "DIGIT", "LETTER", "WORD", "NUMBER", "ASSIGN", 
			"ADDITION", "SUBTRACTION", "DIVISION", "MULTIPLY", "MODULO", "ENDSTNT", 
			"BOOL_EQUAL", "BOOL_N_EQUAL", "BOOL_COND_AND", "BOOL_COND_OR", "BOOL_LESS", 
			"BOOL_GREATER", "BOOL_LESS_OR_EQUAL", "BOOL_GREATER_OR_EQUAL", "INCREMENT", 
			"WS", "COMMENT", "LINE_COMMENT", "BLOCK"
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
			setState(94);
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
			setState(101);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case GAMEPIECE:
			case BOARD:
			case INTEGER:
			case FLOAT:
			case VEC:
			case BOOL:
			case STRING:
			case VOID:
			case DIGIT:
			case LETTER:
			case WORD:
			case NUMBER:
				{
				setState(97);
				expr();
				setState(98);
				match(ENDSTNT);
				}
				break;
			case IF:
			case FOR:
			case WHILE:
				{
				setState(100);
				exprNEs(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(107);
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
					setState(103);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(104);
					exprs(3);
					}
					} 
				}
				setState(109);
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
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public DotStmtContext dotStmt() {
			return getRuleContext(DotStmtContext.class,0);
		}
		public DotAssignmentContext dotAssignment() {
			return getRuleContext(DotAssignmentContext.class,0);
		}
		public DclContext dcl() {
			return getRuleContext(DclContext.class,0);
		}
		public ArrayAssignContext arrayAssign() {
			return getRuleContext(ArrayAssignContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public FunctionDefContext functionDef() {
			return getRuleContext(FunctionDefContext.class,0);
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
			setState(118);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(110);
				arithExpr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(111);
				identifier();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(112);
				dotStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(113);
				dotAssignment();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(114);
				dcl();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(115);
				arrayAssign();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(116);
				function();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(117);
				functionDef();
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

	public static class DclContext extends ParserRuleContext {
		public BoardDclContext boardDcl() {
			return getRuleContext(BoardDclContext.class,0);
		}
		public IntDclContext intDcl() {
			return getRuleContext(IntDclContext.class,0);
		}
		public BoolDclContext boolDcl() {
			return getRuleContext(BoolDclContext.class,0);
		}
		public ArrayDclContext arrayDcl() {
			return getRuleContext(ArrayDclContext.class,0);
		}
		public StringDclContext stringDcl() {
			return getRuleContext(StringDclContext.class,0);
		}
		public GpDclContext gpDcl() {
			return getRuleContext(GpDclContext.class,0);
		}
		public FloatDclContext floatDcl() {
			return getRuleContext(FloatDclContext.class,0);
		}
		public VecDclContext vecDcl() {
			return getRuleContext(VecDclContext.class,0);
		}
		public DclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).enterDcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).exitDcl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacticVisitor ) return ((TacticVisitor<? extends T>)visitor).visitDcl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DclContext dcl() throws RecognitionException {
		DclContext _localctx = new DclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_dcl);
		try {
			setState(128);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(120);
				boardDcl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				intDcl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(122);
				boolDcl();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(123);
				arrayDcl();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(124);
				stringDcl();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(125);
				gpDcl();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(126);
				floatDcl();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(127);
				vecDcl();
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
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_exprNEs, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				{
				setState(131);
				condStmt();
				}
				break;
			case FOR:
			case WHILE:
				{
				setState(132);
				loopStmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(139);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprNEsContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_exprNEs);
					setState(135);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(136);
					exprNEs(4);
					}
					} 
				}
				setState(141);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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
		enterRule(_localctx, 10, RULE_integer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
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

	public static class FloatValContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(Tactic.DOT, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(Tactic.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(Tactic.NUMBER, i);
		}
		public List<TerminalNode> DIGIT() { return getTokens(Tactic.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(Tactic.DIGIT, i);
		}
		public FloatValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_floatVal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).enterFloatVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).exitFloatVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacticVisitor ) return ((TacticVisitor<? extends T>)visitor).visitFloatVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FloatValContext floatVal() throws RecognitionException {
		FloatValContext _localctx = new FloatValContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_floatVal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			_la = _input.LA(1);
			if ( !(_la==DIGIT || _la==NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(145);
			match(DOT);
			setState(146);
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

	public static class NumberContext extends ParserRuleContext {
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public FloatValContext floatVal() {
			return getRuleContext(FloatValContext.class,0);
		}
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacticVisitor ) return ((TacticVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_number);
		try {
			setState(150);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(148);
				integer();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(149);
				floatVal();
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
		enterRule(_localctx, 16, RULE_word);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
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
		enterRule(_localctx, 18, RULE_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(STRING_MARK);
			setState(155);
			word();
			setState(156);
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
		public List<TerminalNode> DIGIT() { return getTokens(Tactic.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(Tactic.DIGIT, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(Tactic.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(Tactic.NUMBER, i);
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
		enterRule(_localctx, 20, RULE_identifier);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			word();
			setState(162);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(159);
					match(DIGIT);
					}
					} 
				}
				setState(164);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(168);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(165);
					match(NUMBER);
					}
					} 
				}
				setState(170);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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

	public static class ValueContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
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
		enterRule(_localctx, 22, RULE_value);
		try {
			setState(175);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LETTER:
			case WORD:
				enterOuterAlt(_localctx, 1);
				{
				setState(171);
				identifier();
				}
				break;
			case DIGIT:
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(172);
				number();
				}
				break;
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 3);
				{
				setState(173);
				bool();
				}
				break;
			case STRING_MARK:
				enterOuterAlt(_localctx, 4);
				{
				setState(174);
				string();
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

	public static class VecContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(Tactic.LPAREN, 0); }
		public List<NumberContext> number() {
			return getRuleContexts(NumberContext.class);
		}
		public NumberContext number(int i) {
			return getRuleContext(NumberContext.class,i);
		}
		public List<TerminalNode> SEPERATOR() { return getTokens(Tactic.SEPERATOR); }
		public TerminalNode SEPERATOR(int i) {
			return getToken(Tactic.SEPERATOR, i);
		}
		public TerminalNode RPAREN() { return getToken(Tactic.RPAREN, 0); }
		public VecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).enterVec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).exitVec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacticVisitor ) return ((TacticVisitor<? extends T>)visitor).visitVec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VecContext vec() throws RecognitionException {
		VecContext _localctx = new VecContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_vec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			match(LPAREN);
			setState(178);
			number();
			setState(179);
			match(SEPERATOR);
			setState(180);
			number();
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEPERATOR) {
				{
				setState(181);
				match(SEPERATOR);
				setState(182);
				number();
				}
			}

			setState(185);
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

	public static class FunctionContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(Tactic.LPAREN, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Tactic.RPAREN, 0); }
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacticVisitor ) return ((TacticVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			identifier();
			setState(188);
			match(LPAREN);
			setState(189);
			arguments(0);
			setState(190);
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

	public static class FunctionDefContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode LPAREN() { return getToken(Tactic.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(Tactic.RPAREN, 0); }
		public FunctionBlockContext functionBlock() {
			return getRuleContext(FunctionBlockContext.class,0);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> VOID() { return getTokens(Tactic.VOID); }
		public TerminalNode VOID(int i) {
			return getToken(Tactic.VOID, i);
		}
		public List<TerminalNode> SEPERATOR() { return getTokens(Tactic.SEPERATOR); }
		public TerminalNode SEPERATOR(int i) {
			return getToken(Tactic.SEPERATOR, i);
		}
		public FunctionDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).enterFunctionDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).exitFunctionDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacticVisitor ) return ((TacticVisitor<? extends T>)visitor).visitFunctionDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDefContext functionDef() throws RecognitionException {
		FunctionDefContext _localctx = new FunctionDefContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_functionDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case GAMEPIECE:
			case BOARD:
			case INTEGER:
			case FLOAT:
			case VEC:
			case BOOL:
			case STRING:
				{
				setState(192);
				type();
				}
				break;
			case VOID:
				{
				setState(193);
				match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(196);
			identifier();
			setState(197);
			match(LPAREN);
			setState(214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GAMEPIECE) | (1L << BOARD) | (1L << INTEGER) | (1L << FLOAT) | (1L << VEC) | (1L << BOOL) | (1L << STRING) | (1L << VOID))) != 0)) {
				{
				setState(200);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case GAMEPIECE:
				case BOARD:
				case INTEGER:
				case FLOAT:
				case VEC:
				case BOOL:
				case STRING:
					{
					setState(198);
					type();
					}
					break;
				case VOID:
					{
					setState(199);
					match(VOID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(202);
				identifier();
				setState(211);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEPERATOR) {
					{
					{
					setState(203);
					match(SEPERATOR);
					setState(206);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case GAMEPIECE:
					case BOARD:
					case INTEGER:
					case FLOAT:
					case VEC:
					case BOOL:
					case STRING:
						{
						setState(204);
						type();
						}
						break;
					case VOID:
						{
						setState(205);
						match(VOID);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(208);
					identifier();
					}
					}
					setState(213);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(216);
			match(RPAREN);
			setState(217);
			functionBlock();
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

	public static class FunctionBlockContext extends ParserRuleContext {
		public TerminalNode LCURLY() { return getToken(Tactic.LCURLY, 0); }
		public ExprsContext exprs() {
			return getRuleContext(ExprsContext.class,0);
		}
		public TerminalNode RCURLY() { return getToken(Tactic.RCURLY, 0); }
		public TerminalNode RETURN() { return getToken(Tactic.RETURN, 0); }
		public TerminalNode ENDSTNT() { return getToken(Tactic.ENDSTNT, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public VecContext vec() {
			return getRuleContext(VecContext.class,0);
		}
		public FunctionBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).enterFunctionBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).exitFunctionBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacticVisitor ) return ((TacticVisitor<? extends T>)visitor).visitFunctionBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionBlockContext functionBlock() throws RecognitionException {
		FunctionBlockContext _localctx = new FunctionBlockContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_functionBlock);
		int _la;
		try {
			setState(245);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(219);
				match(LCURLY);
				setState(220);
				exprs(0);
				setState(229);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RETURN) {
					{
					setState(221);
					match(RETURN);
					setState(225);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						setState(222);
						value();
						}
						break;
					case 2:
						{
						setState(223);
						identifier();
						}
						break;
					case 3:
						{
						setState(224);
						vec();
						}
						break;
					}
					setState(227);
					match(ENDSTNT);
					}
				}

				setState(231);
				match(RCURLY);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(233);
				match(LCURLY);
				setState(242);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RETURN) {
					{
					setState(234);
					match(RETURN);
					setState(238);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						setState(235);
						value();
						}
						break;
					case 2:
						{
						setState(236);
						identifier();
						}
						break;
					case 3:
						{
						setState(237);
						vec();
						}
						break;
					}
					setState(240);
					match(ENDSTNT);
					}
				}

				setState(244);
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

	public static class DotStmtContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode BOARD() { return getToken(Tactic.BOARD, 0); }
		public List<TerminalNode> DOT() { return getTokens(Tactic.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(Tactic.DOT, i);
		}
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public List<TerminalNode> LBRACKET() { return getTokens(Tactic.LBRACKET); }
		public TerminalNode LBRACKET(int i) {
			return getToken(Tactic.LBRACKET, i);
		}
		public List<TerminalNode> RBRACKET() { return getTokens(Tactic.RBRACKET); }
		public TerminalNode RBRACKET(int i) {
			return getToken(Tactic.RBRACKET, i);
		}
		public List<NumberContext> number() {
			return getRuleContexts(NumberContext.class);
		}
		public NumberContext number(int i) {
			return getRuleContext(NumberContext.class,i);
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
		enterRule(_localctx, 32, RULE_dotStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LETTER:
			case WORD:
				{
				setState(247);
				identifier();
				}
				break;
			case BOARD:
				{
				setState(248);
				match(BOARD);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(267);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				setState(265);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					{
					setState(251);
					match(DOT);
					setState(252);
					identifier();
					setState(260);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==LBRACKET) {
						{
						{
						setState(253);
						match(LBRACKET);
						setState(255);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==DIGIT || _la==NUMBER) {
							{
							setState(254);
							number();
							}
						}

						setState(257);
						match(RBRACKET);
						}
						}
						setState(262);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					break;
				case 2:
					{
					setState(263);
					match(DOT);
					setState(264);
					function();
					}
					break;
				}
				}
				setState(269);
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

	public static class DotAssignmentContext extends ParserRuleContext {
		public DotStmtContext dotStmt() {
			return getRuleContext(DotStmtContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(Tactic.ASSIGN, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public VecContext vec() {
			return getRuleContext(VecContext.class,0);
		}
		public DotAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dotAssignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).enterDotAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).exitDotAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacticVisitor ) return ((TacticVisitor<? extends T>)visitor).visitDotAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DotAssignmentContext dotAssignment() throws RecognitionException {
		DotAssignmentContext _localctx = new DotAssignmentContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_dotAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			dotStmt();
			setState(271);
			match(ASSIGN);
			setState(274);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
			case STRING_MARK:
			case DIGIT:
			case LETTER:
			case WORD:
			case NUMBER:
				{
				setState(272);
				value();
				}
				break;
			case LPAREN:
				{
				setState(273);
				vec();
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
		enterRule(_localctx, 36, RULE_boardDcl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			match(BOARD);
			setState(277);
			match(LPAREN);
			setState(278);
			string();
			setState(279);
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
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode ASSIGN() { return getToken(Tactic.ASSIGN, 0); }
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public ArithExprContext arithExpr() {
			return getRuleContext(ArithExprContext.class,0);
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
		enterRule(_localctx, 38, RULE_intDcl);
		try {
			setState(291);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(281);
				match(INTEGER);
				setState(282);
				identifier();
				setState(283);
				match(ASSIGN);
				setState(287);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
				case 1:
					{
					setState(284);
					number();
					}
					break;
				case 2:
					{
					setState(285);
					arithExpr();
					}
					break;
				case 3:
					{
					setState(286);
					identifier();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(289);
				match(INTEGER);
				setState(290);
				identifier();
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

	public static class FloatDclContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(Tactic.FLOAT, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode ASSIGN() { return getToken(Tactic.ASSIGN, 0); }
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public ArithExprContext arithExpr() {
			return getRuleContext(ArithExprContext.class,0);
		}
		public FloatDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_floatDcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).enterFloatDcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).exitFloatDcl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacticVisitor ) return ((TacticVisitor<? extends T>)visitor).visitFloatDcl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FloatDclContext floatDcl() throws RecognitionException {
		FloatDclContext _localctx = new FloatDclContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_floatDcl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			match(FLOAT);
			setState(294);
			identifier();
			setState(301);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(295);
				match(ASSIGN);
				setState(299);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
				case 1:
					{
					setState(296);
					number();
					}
					break;
				case 2:
					{
					setState(297);
					identifier();
					}
					break;
				case 3:
					{
					setState(298);
					arithExpr();
					}
					break;
				}
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

	public static class VecDclContext extends ParserRuleContext {
		public TerminalNode VEC() { return getToken(Tactic.VEC, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(Tactic.ASSIGN, 0); }
		public VecContext vec() {
			return getRuleContext(VecContext.class,0);
		}
		public VecDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vecDcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).enterVecDcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).exitVecDcl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacticVisitor ) return ((TacticVisitor<? extends T>)visitor).visitVecDcl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VecDclContext vecDcl() throws RecognitionException {
		VecDclContext _localctx = new VecDclContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_vecDcl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
			match(VEC);
			setState(304);
			identifier();
			setState(307);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(305);
				match(ASSIGN);
				setState(306);
				vec();
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

	public static class BoolDclContext extends ParserRuleContext {
		public TerminalNode BOOL() { return getToken(Tactic.BOOL, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(Tactic.ASSIGN, 0); }
		public BoolStmtContext boolStmt() {
			return getRuleContext(BoolStmtContext.class,0);
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
		enterRule(_localctx, 44, RULE_boolDcl);
		try {
			setState(316);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(309);
				match(BOOL);
				setState(310);
				identifier();
				setState(311);
				match(ASSIGN);
				setState(312);
				boolStmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(314);
				match(BOOL);
				setState(315);
				identifier();
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

	public static class StringDclContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(Tactic.STRING, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode ASSIGN() { return getToken(Tactic.ASSIGN, 0); }
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public StringDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringDcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).enterStringDcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).exitStringDcl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacticVisitor ) return ((TacticVisitor<? extends T>)visitor).visitStringDcl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringDclContext stringDcl() throws RecognitionException {
		StringDclContext _localctx = new StringDclContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_stringDcl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318);
			match(STRING);
			setState(319);
			identifier();
			setState(320);
			match(ASSIGN);
			setState(323);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING_MARK:
				{
				setState(321);
				string();
				}
				break;
			case LETTER:
			case WORD:
				{
				setState(322);
				identifier();
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

	public static class GpDclContext extends ParserRuleContext {
		public TerminalNode GAMEPIECE() { return getToken(Tactic.GAMEPIECE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public GpDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gpDcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).enterGpDcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).exitGpDcl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacticVisitor ) return ((TacticVisitor<? extends T>)visitor).visitGpDcl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GpDclContext gpDcl() throws RecognitionException {
		GpDclContext _localctx = new GpDclContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_gpDcl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			match(GAMEPIECE);
			setState(326);
			identifier();
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

	public static class ArrayDclContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(Tactic.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(Tactic.RBRACKET, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode INTEGER() { return getToken(Tactic.INTEGER, 0); }
		public TerminalNode GAMEPIECE() { return getToken(Tactic.GAMEPIECE, 0); }
		public TerminalNode BOOL() { return getToken(Tactic.BOOL, 0); }
		public TerminalNode ASSIGN() { return getToken(Tactic.ASSIGN, 0); }
		public TerminalNode LCURLY() { return getToken(Tactic.LCURLY, 0); }
		public TerminalNode RCURLY() { return getToken(Tactic.RCURLY, 0); }
		public List<ArrayExprContext> arrayExpr() {
			return getRuleContexts(ArrayExprContext.class);
		}
		public ArrayExprContext arrayExpr(int i) {
			return getRuleContext(ArrayExprContext.class,i);
		}
		public List<TerminalNode> SEPERATOR() { return getTokens(Tactic.SEPERATOR); }
		public TerminalNode SEPERATOR(int i) {
			return getToken(Tactic.SEPERATOR, i);
		}
		public ArrayDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayDcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).enterArrayDcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).exitArrayDcl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacticVisitor ) return ((TacticVisitor<? extends T>)visitor).visitArrayDcl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayDclContext arrayDcl() throws RecognitionException {
		ArrayDclContext _localctx = new ArrayDclContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_arrayDcl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GAMEPIECE) | (1L << INTEGER) | (1L << BOOL))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(329);
			match(LBRACKET);
			setState(330);
			match(RBRACKET);
			setState(331);
			identifier();
			setState(344);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(332);
				match(ASSIGN);
				setState(333);
				match(LCURLY);
				{
				setState(334);
				arrayExpr();
				setState(339);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEPERATOR) {
					{
					{
					setState(335);
					match(SEPERATOR);
					setState(336);
					arrayExpr();
					}
					}
					setState(341);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(342);
				match(RCURLY);
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode BOARD() { return getToken(Tactic.BOARD, 0); }
		public TerminalNode INTEGER() { return getToken(Tactic.INTEGER, 0); }
		public TerminalNode FLOAT() { return getToken(Tactic.FLOAT, 0); }
		public TerminalNode VEC() { return getToken(Tactic.VEC, 0); }
		public TerminalNode BOOL() { return getToken(Tactic.BOOL, 0); }
		public TerminalNode STRING() { return getToken(Tactic.STRING, 0); }
		public TerminalNode GAMEPIECE() { return getToken(Tactic.GAMEPIECE, 0); }
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
		enterRule(_localctx, 52, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(346);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GAMEPIECE) | (1L << BOARD) | (1L << INTEGER) | (1L << FLOAT) | (1L << VEC) | (1L << BOOL) | (1L << STRING))) != 0)) ) {
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

	public static class ArrayExprContext extends ParserRuleContext {
		public BoolStmtContext boolStmt() {
			return getRuleContext(BoolStmtContext.class,0);
		}
		public ArithExprContext arithExpr() {
			return getRuleContext(ArithExprContext.class,0);
		}
		public GpDclContext gpDcl() {
			return getRuleContext(GpDclContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public DotStmtContext dotStmt() {
			return getRuleContext(DotStmtContext.class,0);
		}
		public ArrayDclContext arrayDcl() {
			return getRuleContext(ArrayDclContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ArrayExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).enterArrayExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).exitArrayExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacticVisitor ) return ((TacticVisitor<? extends T>)visitor).visitArrayExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayExprContext arrayExpr() throws RecognitionException {
		ArrayExprContext _localctx = new ArrayExprContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_arrayExpr);
		try {
			setState(355);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(348);
				boolStmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(349);
				arithExpr();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(350);
				gpDcl();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(351);
				identifier();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(352);
				dotStmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(353);
				arrayDcl();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(354);
				value();
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

	public static class ArrayAssignContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(Tactic.ASSIGN, 0); }
		public List<ArrayExprContext> arrayExpr() {
			return getRuleContexts(ArrayExprContext.class);
		}
		public ArrayExprContext arrayExpr(int i) {
			return getRuleContext(ArrayExprContext.class,i);
		}
		public List<TerminalNode> LBRACKET() { return getTokens(Tactic.LBRACKET); }
		public TerminalNode LBRACKET(int i) {
			return getToken(Tactic.LBRACKET, i);
		}
		public List<TerminalNode> RBRACKET() { return getTokens(Tactic.RBRACKET); }
		public TerminalNode RBRACKET(int i) {
			return getToken(Tactic.RBRACKET, i);
		}
		public TerminalNode LCURLY() { return getToken(Tactic.LCURLY, 0); }
		public TerminalNode RCURLY() { return getToken(Tactic.RCURLY, 0); }
		public List<NumberContext> number() {
			return getRuleContexts(NumberContext.class);
		}
		public NumberContext number(int i) {
			return getRuleContext(NumberContext.class,i);
		}
		public List<TerminalNode> SEPERATOR() { return getTokens(Tactic.SEPERATOR); }
		public TerminalNode SEPERATOR(int i) {
			return getToken(Tactic.SEPERATOR, i);
		}
		public ArrayAssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayAssign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).enterArrayAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TacticListener ) ((TacticListener)listener).exitArrayAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TacticVisitor ) return ((TacticVisitor<? extends T>)visitor).visitArrayAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayAssignContext arrayAssign() throws RecognitionException {
		ArrayAssignContext _localctx = new ArrayAssignContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_arrayAssign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(357);
			identifier();
			setState(383);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				{
				{
				setState(362); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(358);
					match(LBRACKET);
					setState(359);
					number();
					setState(360);
					match(RBRACKET);
					}
					}
					setState(364); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==LBRACKET );
				setState(366);
				match(ASSIGN);
				setState(367);
				arrayExpr();
				}
				}
				break;
			case 2:
				{
				{
				setState(369);
				match(LBRACKET);
				setState(370);
				match(RBRACKET);
				setState(371);
				match(ASSIGN);
				setState(372);
				match(LCURLY);
				{
				setState(373);
				arrayExpr();
				setState(378);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEPERATOR) {
					{
					{
					setState(374);
					match(SEPERATOR);
					setState(375);
					arrayExpr();
					}
					}
					setState(380);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(381);
				match(RCURLY);
				}
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
		public List<TerminalNode> ADDITION() { return getTokens(Tactic.ADDITION); }
		public TerminalNode ADDITION(int i) {
			return getToken(Tactic.ADDITION, i);
		}
		public List<TerminalNode> SUBTRACTION() { return getTokens(Tactic.SUBTRACTION); }
		public TerminalNode SUBTRACTION(int i) {
			return getToken(Tactic.SUBTRACTION, i);
		}
		public List<TerminalNode> DIVISION() { return getTokens(Tactic.DIVISION); }
		public TerminalNode DIVISION(int i) {
			return getToken(Tactic.DIVISION, i);
		}
		public List<TerminalNode> MULTIPLY() { return getTokens(Tactic.MULTIPLY); }
		public TerminalNode MULTIPLY(int i) {
			return getToken(Tactic.MULTIPLY, i);
		}
		public List<TerminalNode> MODULO() { return getTokens(Tactic.MODULO); }
		public TerminalNode MODULO(int i) {
			return getToken(Tactic.MODULO, i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<NumberContext> number() {
			return getRuleContexts(NumberContext.class);
		}
		public NumberContext number(int i) {
			return getRuleContext(NumberContext.class,i);
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
		enterRule(_localctx, 58, RULE_arithExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(390);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				{
				setState(385);
				addExpr();
				}
				break;
			case 2:
				{
				setState(386);
				subExpr();
				}
				break;
			case 3:
				{
				setState(387);
				divExpr();
				}
				break;
			case 4:
				{
				setState(388);
				mulExpr();
				}
				break;
			case 5:
				{
				setState(389);
				modExpr();
				}
				break;
			}
			setState(399);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADDITION) | (1L << SUBTRACTION) | (1L << DIVISION) | (1L << MULTIPLY) | (1L << MODULO))) != 0)) {
				{
				{
				setState(392);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADDITION) | (1L << SUBTRACTION) | (1L << DIVISION) | (1L << MULTIPLY) | (1L << MODULO))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(395);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LETTER:
				case WORD:
					{
					setState(393);
					identifier();
					}
					break;
				case DIGIT:
				case NUMBER:
					{
					setState(394);
					number();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(401);
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

	public static class AddExprContext extends ParserRuleContext {
		public TerminalNode ADDITION() { return getToken(Tactic.ADDITION, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<NumberContext> number() {
			return getRuleContexts(NumberContext.class);
		}
		public NumberContext number(int i) {
			return getRuleContext(NumberContext.class,i);
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
		enterRule(_localctx, 60, RULE_addExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(404);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LETTER:
			case WORD:
				{
				setState(402);
				identifier();
				}
				break;
			case DIGIT:
			case NUMBER:
				{
				setState(403);
				number();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(406);
			match(ADDITION);
			setState(409);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LETTER:
			case WORD:
				{
				setState(407);
				identifier();
				}
				break;
			case DIGIT:
			case NUMBER:
				{
				setState(408);
				number();
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
		public List<NumberContext> number() {
			return getRuleContexts(NumberContext.class);
		}
		public NumberContext number(int i) {
			return getRuleContext(NumberContext.class,i);
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
		enterRule(_localctx, 62, RULE_subExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(413);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LETTER:
			case WORD:
				{
				setState(411);
				identifier();
				}
				break;
			case DIGIT:
			case NUMBER:
				{
				setState(412);
				number();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(415);
			match(SUBTRACTION);
			setState(418);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LETTER:
			case WORD:
				{
				setState(416);
				identifier();
				}
				break;
			case DIGIT:
			case NUMBER:
				{
				setState(417);
				number();
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
		public List<NumberContext> number() {
			return getRuleContexts(NumberContext.class);
		}
		public NumberContext number(int i) {
			return getRuleContext(NumberContext.class,i);
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
		enterRule(_localctx, 64, RULE_divExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(422);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LETTER:
			case WORD:
				{
				setState(420);
				identifier();
				}
				break;
			case DIGIT:
			case NUMBER:
				{
				setState(421);
				number();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(424);
			match(DIVISION);
			setState(427);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LETTER:
			case WORD:
				{
				setState(425);
				identifier();
				}
				break;
			case DIGIT:
			case NUMBER:
				{
				setState(426);
				number();
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
		public List<NumberContext> number() {
			return getRuleContexts(NumberContext.class);
		}
		public NumberContext number(int i) {
			return getRuleContext(NumberContext.class,i);
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
		enterRule(_localctx, 66, RULE_mulExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(431);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LETTER:
			case WORD:
				{
				setState(429);
				identifier();
				}
				break;
			case DIGIT:
			case NUMBER:
				{
				setState(430);
				number();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(433);
			match(MULTIPLY);
			setState(436);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LETTER:
			case WORD:
				{
				setState(434);
				identifier();
				}
				break;
			case DIGIT:
			case NUMBER:
				{
				setState(435);
				number();
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
		public List<NumberContext> number() {
			return getRuleContexts(NumberContext.class);
		}
		public NumberContext number(int i) {
			return getRuleContext(NumberContext.class,i);
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
		enterRule(_localctx, 68, RULE_modExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(440);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LETTER:
			case WORD:
				{
				setState(438);
				identifier();
				}
				break;
			case DIGIT:
			case NUMBER:
				{
				setState(439);
				number();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(442);
			match(MODULO);
			setState(445);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LETTER:
			case WORD:
				{
				setState(443);
				identifier();
				}
				break;
			case DIGIT:
			case NUMBER:
				{
				setState(444);
				number();
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
		int _startState = 70;
		enterRecursionRule(_localctx, 70, RULE_arguments, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(451);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				{
				setState(448);
				identifier();
				}
				break;
			case 2:
				{
				setState(449);
				string();
				}
				break;
			case 3:
				{
				setState(450);
				value();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(458);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArgumentsContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_arguments);
					setState(453);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(454);
					match(SEPERATOR);
					setState(455);
					arguments(4);
					}
					} 
				}
				setState(460);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
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
		enterRule(_localctx, 72, RULE_condStmt);
		try {
			int _alt;
			setState(472);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(461);
				ifStmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(462);
				ifStmt();
				setState(466);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(463);
						elseifStmt();
						}
						} 
					}
					setState(468);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
				}
				setState(470);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
				case 1:
					{
					setState(469);
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
		enterRule(_localctx, 74, RULE_block);
		try {
			setState(480);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(474);
				match(LCURLY);
				setState(475);
				exprs(0);
				setState(476);
				match(RCURLY);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(478);
				match(LCURLY);
				setState(479);
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
		enterRule(_localctx, 76, RULE_ifStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(482);
			match(IF);
			setState(483);
			match(LPAREN);
			{
			setState(484);
			boolStmt();
			}
			setState(485);
			match(RPAREN);
			setState(486);
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
		enterRule(_localctx, 78, RULE_elseifStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(488);
			match(ELSEIF);
			setState(489);
			match(LPAREN);
			{
			setState(490);
			boolStmt();
			}
			setState(491);
			match(RPAREN);
			setState(492);
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
		enterRule(_localctx, 80, RULE_elseStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(494);
			match(ELSE);
			setState(495);
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
		enterRule(_localctx, 82, RULE_loopStmt);
		try {
			setState(499);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(497);
				forStmt();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(498);
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
		public TerminalNode ASSIGN() { return getToken(Tactic.ASSIGN, 0); }
		public ArithExprContext arithExpr() {
			return getRuleContext(ArithExprContext.class,0);
		}
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
		enterRule(_localctx, 84, RULE_forStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(501);
			match(FOR);
			setState(502);
			match(LPAREN);
			setState(505);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LETTER:
			case WORD:
				{
				setState(503);
				identifier();
				}
				break;
			case INTEGER:
				{
				setState(504);
				intDcl();
				}
				break;
			case ENDSTNT:
				break;
			default:
				break;
			}
			setState(507);
			match(ENDSTNT);
			setState(508);
			boolStmt();
			setState(509);
			match(ENDSTNT);
			setState(517);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
			case 1:
				{
				{
				setState(510);
				identifier();
				setState(511);
				match(INCREMENT);
				}
				}
				break;
			case 2:
				{
				{
				setState(513);
				identifier();
				setState(514);
				match(ASSIGN);
				setState(515);
				arithExpr();
				}
				}
				break;
			}
			setState(519);
			match(RPAREN);
			setState(520);
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
		enterRule(_localctx, 86, RULE_whileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(522);
			match(WHILE);
			setState(523);
			match(LPAREN);
			setState(524);
			boolStmt();
			setState(525);
			match(RPAREN);
			setState(526);
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
		enterRule(_localctx, 88, RULE_boolStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(534);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
			case 1:
				{
				setState(528);
				value();
				setState(529);
				boolOperaters();
				setState(530);
				value();
				}
				break;
			case 2:
				{
				setState(532);
				bool();
				}
				break;
			case 3:
				{
				setState(533);
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
		enterRule(_localctx, 90, RULE_bool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(536);
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
		enterRule(_localctx, 92, RULE_boolOperaters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(538);
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
		case 4:
			return exprNEs_sempred((ExprNEsContext)_localctx, predIndex);
		case 35:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\63\u021f\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\3\2\3\3\3\3\3\3\3\3\3\3\5\3h\n\3"+
		"\3\3\3\3\7\3l\n\3\f\3\16\3o\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4y"+
		"\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u0083\n\5\3\6\3\6\3\6\5\6\u0088"+
		"\n\6\3\6\3\6\7\6\u008c\n\6\f\6\16\6\u008f\13\6\3\7\3\7\3\b\3\b\3\b\3\b"+
		"\3\t\3\t\5\t\u0099\n\t\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\7\f\u00a3\n"+
		"\f\f\f\16\f\u00a6\13\f\3\f\7\f\u00a9\n\f\f\f\16\f\u00ac\13\f\3\r\3\r\3"+
		"\r\3\r\5\r\u00b2\n\r\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00ba\n\16\3\16"+
		"\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\5\20\u00c5\n\20\3\20\3\20\3\20"+
		"\3\20\5\20\u00cb\n\20\3\20\3\20\3\20\3\20\5\20\u00d1\n\20\3\20\7\20\u00d4"+
		"\n\20\f\20\16\20\u00d7\13\20\5\20\u00d9\n\20\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\5\21\u00e4\n\21\3\21\3\21\5\21\u00e8\n\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\5\21\u00f1\n\21\3\21\3\21\5\21\u00f5\n\21"+
		"\3\21\5\21\u00f8\n\21\3\22\3\22\5\22\u00fc\n\22\3\22\3\22\3\22\3\22\5"+
		"\22\u0102\n\22\3\22\7\22\u0105\n\22\f\22\16\22\u0108\13\22\3\22\3\22\7"+
		"\22\u010c\n\22\f\22\16\22\u010f\13\22\3\23\3\23\3\23\3\23\5\23\u0115\n"+
		"\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u0122"+
		"\n\25\3\25\3\25\5\25\u0126\n\25\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u012e"+
		"\n\26\5\26\u0130\n\26\3\27\3\27\3\27\3\27\5\27\u0136\n\27\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\5\30\u013f\n\30\3\31\3\31\3\31\3\31\3\31\5\31"+
		"\u0146\n\31\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\7\33\u0154\n\33\f\33\16\33\u0157\13\33\3\33\3\33\5\33\u015b\n\33\3\34"+
		"\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u0166\n\35\3\36\3\36\3\36"+
		"\3\36\3\36\6\36\u016d\n\36\r\36\16\36\u016e\3\36\3\36\3\36\3\36\3\36\3"+
		"\36\3\36\3\36\3\36\3\36\7\36\u017b\n\36\f\36\16\36\u017e\13\36\3\36\3"+
		"\36\5\36\u0182\n\36\3\37\3\37\3\37\3\37\3\37\5\37\u0189\n\37\3\37\3\37"+
		"\3\37\5\37\u018e\n\37\7\37\u0190\n\37\f\37\16\37\u0193\13\37\3 \3 \5 "+
		"\u0197\n \3 \3 \3 \5 \u019c\n \3!\3!\5!\u01a0\n!\3!\3!\3!\5!\u01a5\n!"+
		"\3\"\3\"\5\"\u01a9\n\"\3\"\3\"\3\"\5\"\u01ae\n\"\3#\3#\5#\u01b2\n#\3#"+
		"\3#\3#\5#\u01b7\n#\3$\3$\5$\u01bb\n$\3$\3$\3$\5$\u01c0\n$\3%\3%\3%\3%"+
		"\5%\u01c6\n%\3%\3%\3%\7%\u01cb\n%\f%\16%\u01ce\13%\3&\3&\3&\7&\u01d3\n"+
		"&\f&\16&\u01d6\13&\3&\5&\u01d9\n&\5&\u01db\n&\3\'\3\'\3\'\3\'\3\'\3\'"+
		"\5\'\u01e3\n\'\3(\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3*\3*\3*\3+\3+\5+\u01f6"+
		"\n+\3,\3,\3,\3,\5,\u01fc\n,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\5,\u0208\n,"+
		"\3,\3,\3,\3-\3-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3.\5.\u0219\n.\3/\3/\3\60\3"+
		"\60\3\60\2\5\4\nH\61\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\62\64\668:<>@BDFHJLNPRTVXZ\\^\2\t\4\2\34\34\37\37\3\2\35\36\5\2\t\t\13"+
		"\13\16\16\4\2\t\16\31\31\3\2!%\3\2\23\24\3\2\'.\2\u024c\2`\3\2\2\2\4g"+
		"\3\2\2\2\6x\3\2\2\2\b\u0082\3\2\2\2\n\u0087\3\2\2\2\f\u0090\3\2\2\2\16"+
		"\u0092\3\2\2\2\20\u0098\3\2\2\2\22\u009a\3\2\2\2\24\u009c\3\2\2\2\26\u00a0"+
		"\3\2\2\2\30\u00b1\3\2\2\2\32\u00b3\3\2\2\2\34\u00bd\3\2\2\2\36\u00c4\3"+
		"\2\2\2 \u00f7\3\2\2\2\"\u00fb\3\2\2\2$\u0110\3\2\2\2&\u0116\3\2\2\2(\u0125"+
		"\3\2\2\2*\u0127\3\2\2\2,\u0131\3\2\2\2.\u013e\3\2\2\2\60\u0140\3\2\2\2"+
		"\62\u0147\3\2\2\2\64\u014a\3\2\2\2\66\u015c\3\2\2\28\u0165\3\2\2\2:\u0167"+
		"\3\2\2\2<\u0188\3\2\2\2>\u0196\3\2\2\2@\u019f\3\2\2\2B\u01a8\3\2\2\2D"+
		"\u01b1\3\2\2\2F\u01ba\3\2\2\2H\u01c5\3\2\2\2J\u01da\3\2\2\2L\u01e2\3\2"+
		"\2\2N\u01e4\3\2\2\2P\u01ea\3\2\2\2R\u01f0\3\2\2\2T\u01f5\3\2\2\2V\u01f7"+
		"\3\2\2\2X\u020c\3\2\2\2Z\u0218\3\2\2\2\\\u021a\3\2\2\2^\u021c\3\2\2\2"+
		"`a\5\4\3\2a\3\3\2\2\2bc\b\3\1\2cd\5\6\4\2de\7&\2\2eh\3\2\2\2fh\5\n\6\2"+
		"gb\3\2\2\2gf\3\2\2\2hm\3\2\2\2ij\f\4\2\2jl\5\4\3\5ki\3\2\2\2lo\3\2\2\2"+
		"mk\3\2\2\2mn\3\2\2\2n\5\3\2\2\2om\3\2\2\2py\5<\37\2qy\5\26\f\2ry\5\"\22"+
		"\2sy\5$\23\2ty\5\b\5\2uy\5:\36\2vy\5\34\17\2wy\5\36\20\2xp\3\2\2\2xq\3"+
		"\2\2\2xr\3\2\2\2xs\3\2\2\2xt\3\2\2\2xu\3\2\2\2xv\3\2\2\2xw\3\2\2\2y\7"+
		"\3\2\2\2z\u0083\5&\24\2{\u0083\5(\25\2|\u0083\5.\30\2}\u0083\5\64\33\2"+
		"~\u0083\5\60\31\2\177\u0083\5\62\32\2\u0080\u0083\5*\26\2\u0081\u0083"+
		"\5,\27\2\u0082z\3\2\2\2\u0082{\3\2\2\2\u0082|\3\2\2\2\u0082}\3\2\2\2\u0082"+
		"~\3\2\2\2\u0082\177\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0081\3\2\2\2\u0083"+
		"\t\3\2\2\2\u0084\u0085\b\6\1\2\u0085\u0088\5J&\2\u0086\u0088\5T+\2\u0087"+
		"\u0084\3\2\2\2\u0087\u0086\3\2\2\2\u0088\u008d\3\2\2\2\u0089\u008a\f\5"+
		"\2\2\u008a\u008c\5\n\6\6\u008b\u0089\3\2\2\2\u008c\u008f\3\2\2\2\u008d"+
		"\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\13\3\2\2\2\u008f\u008d\3\2\2"+
		"\2\u0090\u0091\t\2\2\2\u0091\r\3\2\2\2\u0092\u0093\t\2\2\2\u0093\u0094"+
		"\7\27\2\2\u0094\u0095\t\2\2\2\u0095\17\3\2\2\2\u0096\u0099\5\f\7\2\u0097"+
		"\u0099\5\16\b\2\u0098\u0096\3\2\2\2\u0098\u0097\3\2\2\2\u0099\21\3\2\2"+
		"\2\u009a\u009b\t\3\2\2\u009b\23\3\2\2\2\u009c\u009d\7\30\2\2\u009d\u009e"+
		"\5\22\n\2\u009e\u009f\7\30\2\2\u009f\25\3\2\2\2\u00a0\u00a4\5\22\n\2\u00a1"+
		"\u00a3\7\34\2\2\u00a2\u00a1\3\2\2\2\u00a3\u00a6\3\2\2\2\u00a4\u00a2\3"+
		"\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00aa\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7"+
		"\u00a9\7\37\2\2\u00a8\u00a7\3\2\2\2\u00a9\u00ac\3\2\2\2\u00aa\u00a8\3"+
		"\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\27\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad"+
		"\u00b2\5\26\f\2\u00ae\u00b2\5\20\t\2\u00af\u00b2\5\\/\2\u00b0\u00b2\5"+
		"\24\13\2\u00b1\u00ad\3\2\2\2\u00b1\u00ae\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1"+
		"\u00b0\3\2\2\2\u00b2\31\3\2\2\2\u00b3\u00b4\7\3\2\2\u00b4\u00b5\5\20\t"+
		"\2\u00b5\u00b6\7\17\2\2\u00b6\u00b9\5\20\t\2\u00b7\u00b8\7\17\2\2\u00b8"+
		"\u00ba\5\20\t\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bb\3"+
		"\2\2\2\u00bb\u00bc\7\4\2\2\u00bc\33\3\2\2\2\u00bd\u00be\5\26\f\2\u00be"+
		"\u00bf\7\3\2\2\u00bf\u00c0\5H%\2\u00c0\u00c1\7\4\2\2\u00c1\35\3\2\2\2"+
		"\u00c2\u00c5\5\66\34\2\u00c3\u00c5\7\32\2\2\u00c4\u00c2\3\2\2\2\u00c4"+
		"\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7\5\26\f\2\u00c7\u00d8\7"+
		"\3\2\2\u00c8\u00cb\5\66\34\2\u00c9\u00cb\7\32\2\2\u00ca\u00c8\3\2\2\2"+
		"\u00ca\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00d5\5\26\f\2\u00cd\u00d0"+
		"\7\17\2\2\u00ce\u00d1\5\66\34\2\u00cf\u00d1\7\32\2\2\u00d0\u00ce\3\2\2"+
		"\2\u00d0\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d4\5\26\f\2\u00d3"+
		"\u00cd\3\2\2\2\u00d4\u00d7\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d6\3\2"+
		"\2\2\u00d6\u00d9\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d8\u00ca\3\2\2\2\u00d8"+
		"\u00d9\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00db\7\4\2\2\u00db\u00dc\5 "+
		"\21\2\u00dc\37\3\2\2\2\u00dd\u00de\7\5\2\2\u00de\u00e7\5\4\3\2\u00df\u00e3"+
		"\7\33\2\2\u00e0\u00e4\5\30\r\2\u00e1\u00e4\5\26\f\2\u00e2\u00e4\5\32\16"+
		"\2\u00e3\u00e0\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e3\u00e2\3\2\2\2\u00e4\u00e5"+
		"\3\2\2\2\u00e5\u00e6\7&\2\2\u00e6\u00e8\3\2\2\2\u00e7\u00df\3\2\2\2\u00e7"+
		"\u00e8\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ea\7\6\2\2\u00ea\u00f8\3\2"+
		"\2\2\u00eb\u00f4\7\5\2\2\u00ec\u00f0\7\33\2\2\u00ed\u00f1\5\30\r\2\u00ee"+
		"\u00f1\5\26\f\2\u00ef\u00f1\5\32\16\2\u00f0\u00ed\3\2\2\2\u00f0\u00ee"+
		"\3\2\2\2\u00f0\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f3\7&\2\2\u00f3"+
		"\u00f5\3\2\2\2\u00f4\u00ec\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f6\3\2"+
		"\2\2\u00f6\u00f8\7\6\2\2\u00f7\u00dd\3\2\2\2\u00f7\u00eb\3\2\2\2\u00f8"+
		"!\3\2\2\2\u00f9\u00fc\5\26\f\2\u00fa\u00fc\7\n\2\2\u00fb\u00f9\3\2\2\2"+
		"\u00fb\u00fa\3\2\2\2\u00fc\u010d\3\2\2\2\u00fd\u00fe\7\27\2\2\u00fe\u0106"+
		"\5\26\f\2\u00ff\u0101\7\7\2\2\u0100\u0102\5\20\t\2\u0101\u0100\3\2\2\2"+
		"\u0101\u0102\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0105\7\b\2\2\u0104\u00ff"+
		"\3\2\2\2\u0105\u0108\3\2\2\2\u0106\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107"+
		"\u010c\3\2\2\2\u0108\u0106\3\2\2\2\u0109\u010a\7\27\2\2\u010a\u010c\5"+
		"\34\17\2\u010b\u00fd\3\2\2\2\u010b\u0109\3\2\2\2\u010c\u010f\3\2\2\2\u010d"+
		"\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e#\3\2\2\2\u010f\u010d\3\2\2\2"+
		"\u0110\u0111\5\"\22\2\u0111\u0114\7 \2\2\u0112\u0115\5\30\r\2\u0113\u0115"+
		"\5\32\16\2\u0114\u0112\3\2\2\2\u0114\u0113\3\2\2\2\u0115%\3\2\2\2\u0116"+
		"\u0117\7\n\2\2\u0117\u0118\7\3\2\2\u0118\u0119\5\24\13\2\u0119\u011a\7"+
		"\4\2\2\u011a\'\3\2\2\2\u011b\u011c\7\13\2\2\u011c\u011d\5\26\f\2\u011d"+
		"\u0121\7 \2\2\u011e\u0122\5\20\t\2\u011f\u0122\5<\37\2\u0120\u0122\5\26"+
		"\f\2\u0121\u011e\3\2\2\2\u0121\u011f\3\2\2\2\u0121\u0120\3\2\2\2\u0122"+
		"\u0126\3\2\2\2\u0123\u0124\7\13\2\2\u0124\u0126\5\26\f\2\u0125\u011b\3"+
		"\2\2\2\u0125\u0123\3\2\2\2\u0126)\3\2\2\2\u0127\u0128\7\f\2\2\u0128\u012f"+
		"\5\26\f\2\u0129\u012d\7 \2\2\u012a\u012e\5\20\t\2\u012b\u012e\5\26\f\2"+
		"\u012c\u012e\5<\37\2\u012d\u012a\3\2\2\2\u012d\u012b\3\2\2\2\u012d\u012c"+
		"\3\2\2\2\u012e\u0130\3\2\2\2\u012f\u0129\3\2\2\2\u012f\u0130\3\2\2\2\u0130"+
		"+\3\2\2\2\u0131\u0132\7\r\2\2\u0132\u0135\5\26\f\2\u0133\u0134\7 \2\2"+
		"\u0134\u0136\5\32\16\2\u0135\u0133\3\2\2\2\u0135\u0136\3\2\2\2\u0136-"+
		"\3\2\2\2\u0137\u0138\7\16\2\2\u0138\u0139\5\26\f\2\u0139\u013a\7 \2\2"+
		"\u013a\u013b\5Z.\2\u013b\u013f\3\2\2\2\u013c\u013d\7\16\2\2\u013d\u013f"+
		"\5\26\f\2\u013e\u0137\3\2\2\2\u013e\u013c\3\2\2\2\u013f/\3\2\2\2\u0140"+
		"\u0141\7\31\2\2\u0141\u0142\5\26\f\2\u0142\u0145\7 \2\2\u0143\u0146\5"+
		"\24\13\2\u0144\u0146\5\26\f\2\u0145\u0143\3\2\2\2\u0145\u0144\3\2\2\2"+
		"\u0146\61\3\2\2\2\u0147\u0148\7\t\2\2\u0148\u0149\5\26\f\2\u0149\63\3"+
		"\2\2\2\u014a\u014b\t\4\2\2\u014b\u014c\7\7\2\2\u014c\u014d\7\b\2\2\u014d"+
		"\u015a\5\26\f\2\u014e\u014f\7 \2\2\u014f\u0150\7\5\2\2\u0150\u0155\58"+
		"\35\2\u0151\u0152\7\17\2\2\u0152\u0154\58\35\2\u0153\u0151\3\2\2\2\u0154"+
		"\u0157\3\2\2\2\u0155\u0153\3\2\2\2\u0155\u0156\3\2\2\2\u0156\u0158\3\2"+
		"\2\2\u0157\u0155\3\2\2\2\u0158\u0159\7\6\2\2\u0159\u015b\3\2\2\2\u015a"+
		"\u014e\3\2\2\2\u015a\u015b\3\2\2\2\u015b\65\3\2\2\2\u015c\u015d\t\5\2"+
		"\2\u015d\67\3\2\2\2\u015e\u0166\5Z.\2\u015f\u0166\5<\37\2\u0160\u0166"+
		"\5\62\32\2\u0161\u0166\5\26\f\2\u0162\u0166\5\"\22\2\u0163\u0166\5\64"+
		"\33\2\u0164\u0166\5\30\r\2\u0165\u015e\3\2\2\2\u0165\u015f\3\2\2\2\u0165"+
		"\u0160\3\2\2\2\u0165\u0161\3\2\2\2\u0165\u0162\3\2\2\2\u0165\u0163\3\2"+
		"\2\2\u0165\u0164\3\2\2\2\u01669\3\2\2\2\u0167\u0181\5\26\f\2\u0168\u0169"+
		"\7\7\2\2\u0169\u016a\5\20\t\2\u016a\u016b\7\b\2\2\u016b\u016d\3\2\2\2"+
		"\u016c\u0168\3\2\2\2\u016d\u016e\3\2\2\2\u016e\u016c\3\2\2\2\u016e\u016f"+
		"\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u0171\7 \2\2\u0171\u0172\58\35\2\u0172"+
		"\u0182\3\2\2\2\u0173\u0174\7\7\2\2\u0174\u0175\7\b\2\2\u0175\u0176\7 "+
		"\2\2\u0176\u0177\7\5\2\2\u0177\u017c\58\35\2\u0178\u0179\7\17\2\2\u0179"+
		"\u017b\58\35\2\u017a\u0178\3\2\2\2\u017b\u017e\3\2\2\2\u017c\u017a\3\2"+
		"\2\2\u017c\u017d\3\2\2\2\u017d\u017f\3\2\2\2\u017e\u017c\3\2\2\2\u017f"+
		"\u0180\7\6\2\2\u0180\u0182\3\2\2\2\u0181\u016c\3\2\2\2\u0181\u0173\3\2"+
		"\2\2\u0182;\3\2\2\2\u0183\u0189\5> \2\u0184\u0189\5@!\2\u0185\u0189\5"+
		"B\"\2\u0186\u0189\5D#\2\u0187\u0189\5F$\2\u0188\u0183\3\2\2\2\u0188\u0184"+
		"\3\2\2\2\u0188\u0185\3\2\2\2\u0188\u0186\3\2\2\2\u0188\u0187\3\2\2\2\u0189"+
		"\u0191\3\2\2\2\u018a\u018d\t\6\2\2\u018b\u018e\5\26\f\2\u018c\u018e\5"+
		"\20\t\2\u018d\u018b\3\2\2\2\u018d\u018c\3\2\2\2\u018e\u0190\3\2\2\2\u018f"+
		"\u018a\3\2\2\2\u0190\u0193\3\2\2\2\u0191\u018f\3\2\2\2\u0191\u0192\3\2"+
		"\2\2\u0192=\3\2\2\2\u0193\u0191\3\2\2\2\u0194\u0197\5\26\f\2\u0195\u0197"+
		"\5\20\t\2\u0196\u0194\3\2\2\2\u0196\u0195\3\2\2\2\u0197\u0198\3\2\2\2"+
		"\u0198\u019b\7!\2\2\u0199\u019c\5\26\f\2\u019a\u019c\5\20\t\2\u019b\u0199"+
		"\3\2\2\2\u019b\u019a\3\2\2\2\u019c?\3\2\2\2\u019d\u01a0\5\26\f\2\u019e"+
		"\u01a0\5\20\t\2\u019f\u019d\3\2\2\2\u019f\u019e\3\2\2\2\u01a0\u01a1\3"+
		"\2\2\2\u01a1\u01a4\7\"\2\2\u01a2\u01a5\5\26\f\2\u01a3\u01a5\5\20\t\2\u01a4"+
		"\u01a2\3\2\2\2\u01a4\u01a3\3\2\2\2\u01a5A\3\2\2\2\u01a6\u01a9\5\26\f\2"+
		"\u01a7\u01a9\5\20\t\2\u01a8\u01a6\3\2\2\2\u01a8\u01a7\3\2\2\2\u01a9\u01aa"+
		"\3\2\2\2\u01aa\u01ad\7#\2\2\u01ab\u01ae\5\26\f\2\u01ac\u01ae\5\20\t\2"+
		"\u01ad\u01ab\3\2\2\2\u01ad\u01ac\3\2\2\2\u01aeC\3\2\2\2\u01af\u01b2\5"+
		"\26\f\2\u01b0\u01b2\5\20\t\2\u01b1\u01af\3\2\2\2\u01b1\u01b0\3\2\2\2\u01b2"+
		"\u01b3\3\2\2\2\u01b3\u01b6\7$\2\2\u01b4\u01b7\5\26\f\2\u01b5\u01b7\5\20"+
		"\t\2\u01b6\u01b4\3\2\2\2\u01b6\u01b5\3\2\2\2\u01b7E\3\2\2\2\u01b8\u01bb"+
		"\5\26\f\2\u01b9\u01bb\5\20\t\2\u01ba\u01b8\3\2\2\2\u01ba\u01b9\3\2\2\2"+
		"\u01bb\u01bc\3\2\2\2\u01bc\u01bf\7%\2\2\u01bd\u01c0\5\26\f\2\u01be\u01c0"+
		"\5\20\t\2\u01bf\u01bd\3\2\2\2\u01bf\u01be\3\2\2\2\u01c0G\3\2\2\2\u01c1"+
		"\u01c2\b%\1\2\u01c2\u01c6\5\26\f\2\u01c3\u01c6\5\24\13\2\u01c4\u01c6\5"+
		"\30\r\2\u01c5\u01c1\3\2\2\2\u01c5\u01c3\3\2\2\2\u01c5\u01c4\3\2\2\2\u01c6"+
		"\u01cc\3\2\2\2\u01c7\u01c8\f\5\2\2\u01c8\u01c9\7\17\2\2\u01c9\u01cb\5"+
		"H%\6\u01ca\u01c7\3\2\2\2\u01cb\u01ce\3\2\2\2\u01cc\u01ca\3\2\2\2\u01cc"+
		"\u01cd\3\2\2\2\u01cdI\3\2\2\2\u01ce\u01cc\3\2\2\2\u01cf\u01db\5N(\2\u01d0"+
		"\u01d4\5N(\2\u01d1\u01d3\5P)\2\u01d2\u01d1\3\2\2\2\u01d3\u01d6\3\2\2\2"+
		"\u01d4\u01d2\3\2\2\2\u01d4\u01d5\3\2\2\2\u01d5\u01d8\3\2\2\2\u01d6\u01d4"+
		"\3\2\2\2\u01d7\u01d9\5R*\2\u01d8\u01d7\3\2\2\2\u01d8\u01d9\3\2\2\2\u01d9"+
		"\u01db\3\2\2\2\u01da\u01cf\3\2\2\2\u01da\u01d0\3\2\2\2\u01dbK\3\2\2\2"+
		"\u01dc\u01dd\7\5\2\2\u01dd\u01de\5\4\3\2\u01de\u01df\7\6\2\2\u01df\u01e3"+
		"\3\2\2\2\u01e0\u01e1\7\5\2\2\u01e1\u01e3\7\6\2\2\u01e2\u01dc\3\2\2\2\u01e2"+
		"\u01e0\3\2\2\2\u01e3M\3\2\2\2\u01e4\u01e5\7\20\2\2\u01e5\u01e6\7\3\2\2"+
		"\u01e6\u01e7\5Z.\2\u01e7\u01e8\7\4\2\2\u01e8\u01e9\5L\'\2\u01e9O\3\2\2"+
		"\2\u01ea\u01eb\7\21\2\2\u01eb\u01ec\7\3\2\2\u01ec\u01ed\5Z.\2\u01ed\u01ee"+
		"\7\4\2\2\u01ee\u01ef\5L\'\2\u01efQ\3\2\2\2\u01f0\u01f1\7\22\2\2\u01f1"+
		"\u01f2\5L\'\2\u01f2S\3\2\2\2\u01f3\u01f6\5V,\2\u01f4\u01f6\5X-\2\u01f5"+
		"\u01f3\3\2\2\2\u01f5\u01f4\3\2\2\2\u01f6U\3\2\2\2\u01f7\u01f8\7\25\2\2"+
		"\u01f8\u01fb\7\3\2\2\u01f9\u01fc\5\26\f\2\u01fa\u01fc\5(\25\2\u01fb\u01f9"+
		"\3\2\2\2\u01fb\u01fa\3\2\2\2\u01fb\u01fc\3\2\2\2\u01fc\u01fd\3\2\2\2\u01fd"+
		"\u01fe\7&\2\2\u01fe\u01ff\5Z.\2\u01ff\u0207\7&\2\2\u0200\u0201\5\26\f"+
		"\2\u0201\u0202\7/\2\2\u0202\u0208\3\2\2\2\u0203\u0204\5\26\f\2\u0204\u0205"+
		"\7 \2\2\u0205\u0206\5<\37\2\u0206\u0208\3\2\2\2\u0207\u0200\3\2\2\2\u0207"+
		"\u0203\3\2\2\2\u0207\u0208\3\2\2\2\u0208\u0209\3\2\2\2\u0209\u020a\7\4"+
		"\2\2\u020a\u020b\5L\'\2\u020bW\3\2\2\2\u020c\u020d\7\26\2\2\u020d\u020e"+
		"\7\3\2\2\u020e\u020f\5Z.\2\u020f\u0210\7\4\2\2\u0210\u0211\7\63\2\2\u0211"+
		"Y\3\2\2\2\u0212\u0213\5\30\r\2\u0213\u0214\5^\60\2\u0214\u0215\5\30\r"+
		"\2\u0215\u0219\3\2\2\2\u0216\u0219\5\\/\2\u0217\u0219\5\26\f\2\u0218\u0212"+
		"\3\2\2\2\u0218\u0216\3\2\2\2\u0218\u0217\3\2\2\2\u0219[\3\2\2\2\u021a"+
		"\u021b\t\7\2\2\u021b]\3\2\2\2\u021c\u021d\t\b\2\2\u021d_\3\2\2\2Agmx\u0082"+
		"\u0087\u008d\u0098\u00a4\u00aa\u00b1\u00b9\u00c4\u00ca\u00d0\u00d5\u00d8"+
		"\u00e3\u00e7\u00f0\u00f4\u00f7\u00fb\u0101\u0106\u010b\u010d\u0114\u0121"+
		"\u0125\u012d\u012f\u0135\u013e\u0145\u0155\u015a\u0165\u016e\u017c\u0181"+
		"\u0188\u018d\u0191\u0196\u019b\u019f\u01a4\u01a8\u01ad\u01b1\u01b6\u01ba"+
		"\u01bf\u01c5\u01cc\u01d4\u01d8\u01da\u01e2\u01f5\u01fb\u0207\u0218";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}