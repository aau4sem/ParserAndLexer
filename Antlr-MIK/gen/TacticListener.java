// Generated from /Users/mathiashindsgaul/Documents/4.Semester/ParserAndLexer/Antlr-MIK/Tactic.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Tactic}.
 */
public interface TacticListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Tactic#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(Tactic.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tactic#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(Tactic.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tactic#exprs}.
	 * @param ctx the parse tree
	 */
	void enterExprs(Tactic.ExprsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tactic#exprs}.
	 * @param ctx the parse tree
	 */
	void exitExprs(Tactic.ExprsContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tactic#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(Tactic.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tactic#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(Tactic.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tactic#exprNEs}.
	 * @param ctx the parse tree
	 */
	void enterExprNEs(Tactic.ExprNEsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tactic#exprNEs}.
	 * @param ctx the parse tree
	 */
	void exitExprNEs(Tactic.ExprNEsContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tactic#integer}.
	 * @param ctx the parse tree
	 */
	void enterInteger(Tactic.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tactic#integer}.
	 * @param ctx the parse tree
	 */
	void exitInteger(Tactic.IntegerContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tactic#word}.
	 * @param ctx the parse tree
	 */
	void enterWord(Tactic.WordContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tactic#word}.
	 * @param ctx the parse tree
	 */
	void exitWord(Tactic.WordContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tactic#string}.
	 * @param ctx the parse tree
	 */
	void enterString(Tactic.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tactic#string}.
	 * @param ctx the parse tree
	 */
	void exitString(Tactic.StringContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tactic#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(Tactic.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tactic#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(Tactic.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tactic#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(Tactic.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tactic#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(Tactic.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tactic#dotStmt}.
	 * @param ctx the parse tree
	 */
	void enterDotStmt(Tactic.DotStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tactic#dotStmt}.
	 * @param ctx the parse tree
	 */
	void exitDotStmt(Tactic.DotStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tactic#boardDcl}.
	 * @param ctx the parse tree
	 */
	void enterBoardDcl(Tactic.BoardDclContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tactic#boardDcl}.
	 * @param ctx the parse tree
	 */
	void exitBoardDcl(Tactic.BoardDclContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tactic#intDcl}.
	 * @param ctx the parse tree
	 */
	void enterIntDcl(Tactic.IntDclContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tactic#intDcl}.
	 * @param ctx the parse tree
	 */
	void exitIntDcl(Tactic.IntDclContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tactic#boolDcl}.
	 * @param ctx the parse tree
	 */
	void enterBoolDcl(Tactic.BoolDclContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tactic#boolDcl}.
	 * @param ctx the parse tree
	 */
	void exitBoolDcl(Tactic.BoolDclContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tactic#arithExpr}.
	 * @param ctx the parse tree
	 */
	void enterArithExpr(Tactic.ArithExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tactic#arithExpr}.
	 * @param ctx the parse tree
	 */
	void exitArithExpr(Tactic.ArithExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tactic#addExpr}.
	 * @param ctx the parse tree
	 */
	void enterAddExpr(Tactic.AddExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tactic#addExpr}.
	 * @param ctx the parse tree
	 */
	void exitAddExpr(Tactic.AddExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tactic#subExpr}.
	 * @param ctx the parse tree
	 */
	void enterSubExpr(Tactic.SubExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tactic#subExpr}.
	 * @param ctx the parse tree
	 */
	void exitSubExpr(Tactic.SubExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tactic#divExpr}.
	 * @param ctx the parse tree
	 */
	void enterDivExpr(Tactic.DivExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tactic#divExpr}.
	 * @param ctx the parse tree
	 */
	void exitDivExpr(Tactic.DivExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tactic#mulExpr}.
	 * @param ctx the parse tree
	 */
	void enterMulExpr(Tactic.MulExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tactic#mulExpr}.
	 * @param ctx the parse tree
	 */
	void exitMulExpr(Tactic.MulExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tactic#modExpr}.
	 * @param ctx the parse tree
	 */
	void enterModExpr(Tactic.ModExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tactic#modExpr}.
	 * @param ctx the parse tree
	 */
	void exitModExpr(Tactic.ModExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tactic#buildInClass}.
	 * @param ctx the parse tree
	 */
	void enterBuildInClass(Tactic.BuildInClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tactic#buildInClass}.
	 * @param ctx the parse tree
	 */
	void exitBuildInClass(Tactic.BuildInClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tactic#instantiation}.
	 * @param ctx the parse tree
	 */
	void enterInstantiation(Tactic.InstantiationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tactic#instantiation}.
	 * @param ctx the parse tree
	 */
	void exitInstantiation(Tactic.InstantiationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tactic#type}.
	 * @param ctx the parse tree
	 */
	void enterType(Tactic.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tactic#type}.
	 * @param ctx the parse tree
	 */
	void exitType(Tactic.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tactic#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(Tactic.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tactic#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(Tactic.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tactic#condStmt}.
	 * @param ctx the parse tree
	 */
	void enterCondStmt(Tactic.CondStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tactic#condStmt}.
	 * @param ctx the parse tree
	 */
	void exitCondStmt(Tactic.CondStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tactic#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(Tactic.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tactic#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(Tactic.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tactic#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(Tactic.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tactic#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(Tactic.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tactic#elseifStmt}.
	 * @param ctx the parse tree
	 */
	void enterElseifStmt(Tactic.ElseifStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tactic#elseifStmt}.
	 * @param ctx the parse tree
	 */
	void exitElseifStmt(Tactic.ElseifStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tactic#elseStmt}.
	 * @param ctx the parse tree
	 */
	void enterElseStmt(Tactic.ElseStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tactic#elseStmt}.
	 * @param ctx the parse tree
	 */
	void exitElseStmt(Tactic.ElseStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tactic#loopStmt}.
	 * @param ctx the parse tree
	 */
	void enterLoopStmt(Tactic.LoopStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tactic#loopStmt}.
	 * @param ctx the parse tree
	 */
	void exitLoopStmt(Tactic.LoopStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tactic#forStmt}.
	 * @param ctx the parse tree
	 */
	void enterForStmt(Tactic.ForStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tactic#forStmt}.
	 * @param ctx the parse tree
	 */
	void exitForStmt(Tactic.ForStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tactic#whileStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(Tactic.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tactic#whileStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(Tactic.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tactic#boolStmt}.
	 * @param ctx the parse tree
	 */
	void enterBoolStmt(Tactic.BoolStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tactic#boolStmt}.
	 * @param ctx the parse tree
	 */
	void exitBoolStmt(Tactic.BoolStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tactic#bool}.
	 * @param ctx the parse tree
	 */
	void enterBool(Tactic.BoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tactic#bool}.
	 * @param ctx the parse tree
	 */
	void exitBool(Tactic.BoolContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tactic#boolOperaters}.
	 * @param ctx the parse tree
	 */
	void enterBoolOperaters(Tactic.BoolOperatersContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tactic#boolOperaters}.
	 * @param ctx the parse tree
	 */
	void exitBoolOperaters(Tactic.BoolOperatersContext ctx);
}