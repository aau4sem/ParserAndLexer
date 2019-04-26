// Generated from E:/SourceTree/ParserAndLexer/CompilerSmallLanguageTest2\TacTypes.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TacTypesParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TacTypesVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TacTypesParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(TacTypesParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link TacTypesParser#exprs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprs(TacTypesParser.ExprsContext ctx);
	/**
	 * Visit a parse tree produced by {@link TacTypesParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(TacTypesParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link TacTypesParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(TacTypesParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link TacTypesParser#intDcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntDcl(TacTypesParser.IntDclContext ctx);
	/**
	 * Visit a parse tree produced by {@link TacTypesParser#floatDcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatDcl(TacTypesParser.FloatDclContext ctx);
}