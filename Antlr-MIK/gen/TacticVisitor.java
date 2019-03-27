// Generated from /Users/mathiashindsgaul/Documents/4.Semester/ParserAndLexer/Antlr-MIK/Tactic.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Tactic}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TacticVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Tactic#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(Tactic.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tactic#exprs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprs(Tactic.ExprsContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tactic#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(Tactic.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tactic#exprNEs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprNEs(Tactic.ExprNEsContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tactic#integer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger(Tactic.IntegerContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tactic#word}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWord(Tactic.WordContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tactic#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(Tactic.StringContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tactic#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(Tactic.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tactic#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(Tactic.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tactic#dotStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDotStmt(Tactic.DotStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tactic#boardDcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoardDcl(Tactic.BoardDclContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tactic#intDcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntDcl(Tactic.IntDclContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tactic#boolDcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolDcl(Tactic.BoolDclContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tactic#arithExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithExpr(Tactic.ArithExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tactic#addExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExpr(Tactic.AddExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tactic#subExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubExpr(Tactic.SubExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tactic#divExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivExpr(Tactic.DivExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tactic#mulExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulExpr(Tactic.MulExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tactic#modExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModExpr(Tactic.ModExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tactic#buildInClass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuildInClass(Tactic.BuildInClassContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tactic#instantiation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstantiation(Tactic.InstantiationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tactic#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(Tactic.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tactic#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(Tactic.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tactic#condStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondStmt(Tactic.CondStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tactic#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(Tactic.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tactic#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(Tactic.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tactic#elseifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseifStmt(Tactic.ElseifStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tactic#elseStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseStmt(Tactic.ElseStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tactic#loopStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopStmt(Tactic.LoopStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tactic#forStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStmt(Tactic.ForStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tactic#whileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(Tactic.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tactic#boolStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolStmt(Tactic.BoolStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tactic#bool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(Tactic.BoolContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tactic#boolOperaters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolOperaters(Tactic.BoolOperatersContext ctx);
}