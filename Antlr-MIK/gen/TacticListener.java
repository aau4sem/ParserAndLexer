// Generated from E:/SourceTree/ParserAndLexer/Antlr-MIK\Tactic.g4 by ANTLR 4.7.2
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
	 * Enter a parse tree produced by {@link Tactic#dcl}.
	 * @param ctx the parse tree
	 */
	void enterDcl(Tactic.DclContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tactic#dcl}.
	 * @param ctx the parse tree
	 */
	void exitDcl(Tactic.DclContext ctx);
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
	 * Enter a parse tree produced by {@link Tactic#floatVal}.
	 * @param ctx the parse tree
	 */
	void enterFloatVal(Tactic.FloatValContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tactic#floatVal}.
	 * @param ctx the parse tree
	 */
	void exitFloatVal(Tactic.FloatValContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tactic#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(Tactic.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tactic#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(Tactic.NumberContext ctx);
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
	 * Enter a parse tree produced by {@link Tactic#vec}.
	 * @param ctx the parse tree
	 */
	void enterVec(Tactic.VecContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tactic#vec}.
	 * @param ctx the parse tree
	 */
	void exitVec(Tactic.VecContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tactic#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(Tactic.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tactic#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(Tactic.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tactic#functionDef}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDef(Tactic.FunctionDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tactic#functionDef}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDef(Tactic.FunctionDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tactic#functionBlock}.
	 * @param ctx the parse tree
	 */
	void enterFunctionBlock(Tactic.FunctionBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tactic#functionBlock}.
	 * @param ctx the parse tree
	 */
	void exitFunctionBlock(Tactic.FunctionBlockContext ctx);
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
	 * Enter a parse tree produced by {@link Tactic#dotAssignment}.
	 * @param ctx the parse tree
	 */
	void enterDotAssignment(Tactic.DotAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tactic#dotAssignment}.
	 * @param ctx the parse tree
	 */
	void exitDotAssignment(Tactic.DotAssignmentContext ctx);
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
	 * Enter a parse tree produced by {@link Tactic#floatDcl}.
	 * @param ctx the parse tree
	 */
	void enterFloatDcl(Tactic.FloatDclContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tactic#floatDcl}.
	 * @param ctx the parse tree
	 */
	void exitFloatDcl(Tactic.FloatDclContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tactic#vecDcl}.
	 * @param ctx the parse tree
	 */
	void enterVecDcl(Tactic.VecDclContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tactic#vecDcl}.
	 * @param ctx the parse tree
	 */
	void exitVecDcl(Tactic.VecDclContext ctx);
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
	 * Enter a parse tree produced by {@link Tactic#stringDcl}.
	 * @param ctx the parse tree
	 */
	void enterStringDcl(Tactic.StringDclContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tactic#stringDcl}.
	 * @param ctx the parse tree
	 */
	void exitStringDcl(Tactic.StringDclContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tactic#gpDcl}.
	 * @param ctx the parse tree
	 */
	void enterGpDcl(Tactic.GpDclContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tactic#gpDcl}.
	 * @param ctx the parse tree
	 */
	void exitGpDcl(Tactic.GpDclContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tactic#arrayDcl}.
	 * @param ctx the parse tree
	 */
	void enterArrayDcl(Tactic.ArrayDclContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tactic#arrayDcl}.
	 * @param ctx the parse tree
	 */
	void exitArrayDcl(Tactic.ArrayDclContext ctx);
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
	 * Enter a parse tree produced by {@link Tactic#arrayExpr}.
	 * @param ctx the parse tree
	 */
	void enterArrayExpr(Tactic.ArrayExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tactic#arrayExpr}.
	 * @param ctx the parse tree
	 */
	void exitArrayExpr(Tactic.ArrayExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tactic#arrayAssign}.
	 * @param ctx the parse tree
	 */
	void enterArrayAssign(Tactic.ArrayAssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tactic#arrayAssign}.
	 * @param ctx the parse tree
	 */
	void exitArrayAssign(Tactic.ArrayAssignContext ctx);
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