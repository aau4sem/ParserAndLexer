// Generated from E:/SourceTree/ParserAndLexer/CompilerTest3TypeChecking\TacTypesChecking.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TacTypesCheckingParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TacTypesCheckingVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TacTypesCheckingParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(TacTypesCheckingParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link TacTypesCheckingParser#exprs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprs(TacTypesCheckingParser.ExprsContext ctx);
	/**
	 * Visit a parse tree produced by {@link TacTypesCheckingParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(TacTypesCheckingParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link TacTypesCheckingParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(TacTypesCheckingParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link TacTypesCheckingParser#intDcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntDcl(TacTypesCheckingParser.IntDclContext ctx);
	/**
	 * Visit a parse tree produced by {@link TacTypesCheckingParser#floatDcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatDcl(TacTypesCheckingParser.FloatDclContext ctx);
	/**
	 * Visit a parse tree produced by {@link TacTypesCheckingParser#intPlus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntPlus(TacTypesCheckingParser.IntPlusContext ctx);
}