// Generated from E:/SourceTree/ParserAndLexer/CompilerSmallLanguageTest2\TacTypes.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TacTypesParser}.
 */
public interface TacTypesListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TacTypesParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(TacTypesParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link TacTypesParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(TacTypesParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link TacTypesParser#exprs}.
	 * @param ctx the parse tree
	 */
	void enterExprs(TacTypesParser.ExprsContext ctx);
	/**
	 * Exit a parse tree produced by {@link TacTypesParser#exprs}.
	 * @param ctx the parse tree
	 */
	void exitExprs(TacTypesParser.ExprsContext ctx);
	/**
	 * Enter a parse tree produced by {@link TacTypesParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(TacTypesParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link TacTypesParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(TacTypesParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TacTypesParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(TacTypesParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link TacTypesParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(TacTypesParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link TacTypesParser#intDcl}.
	 * @param ctx the parse tree
	 */
	void enterIntDcl(TacTypesParser.IntDclContext ctx);
	/**
	 * Exit a parse tree produced by {@link TacTypesParser#intDcl}.
	 * @param ctx the parse tree
	 */
	void exitIntDcl(TacTypesParser.IntDclContext ctx);
	/**
	 * Enter a parse tree produced by {@link TacTypesParser#floatDcl}.
	 * @param ctx the parse tree
	 */
	void enterFloatDcl(TacTypesParser.FloatDclContext ctx);
	/**
	 * Exit a parse tree produced by {@link TacTypesParser#floatDcl}.
	 * @param ctx the parse tree
	 */
	void exitFloatDcl(TacTypesParser.FloatDclContext ctx);
}