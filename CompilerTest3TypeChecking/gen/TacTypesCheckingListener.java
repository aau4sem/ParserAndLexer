// Generated from E:/SourceTree/ParserAndLexer/CompilerTest3TypeChecking\TacTypesChecking.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TacTypesCheckingParser}.
 */
public interface TacTypesCheckingListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TacTypesCheckingParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(TacTypesCheckingParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link TacTypesCheckingParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(TacTypesCheckingParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link TacTypesCheckingParser#exprs}.
	 * @param ctx the parse tree
	 */
	void enterExprs(TacTypesCheckingParser.ExprsContext ctx);
	/**
	 * Exit a parse tree produced by {@link TacTypesCheckingParser#exprs}.
	 * @param ctx the parse tree
	 */
	void exitExprs(TacTypesCheckingParser.ExprsContext ctx);
	/**
	 * Enter a parse tree produced by {@link TacTypesCheckingParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(TacTypesCheckingParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link TacTypesCheckingParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(TacTypesCheckingParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TacTypesCheckingParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(TacTypesCheckingParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link TacTypesCheckingParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(TacTypesCheckingParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link TacTypesCheckingParser#intDcl}.
	 * @param ctx the parse tree
	 */
	void enterIntDcl(TacTypesCheckingParser.IntDclContext ctx);
	/**
	 * Exit a parse tree produced by {@link TacTypesCheckingParser#intDcl}.
	 * @param ctx the parse tree
	 */
	void exitIntDcl(TacTypesCheckingParser.IntDclContext ctx);
	/**
	 * Enter a parse tree produced by {@link TacTypesCheckingParser#floatDcl}.
	 * @param ctx the parse tree
	 */
	void enterFloatDcl(TacTypesCheckingParser.FloatDclContext ctx);
	/**
	 * Exit a parse tree produced by {@link TacTypesCheckingParser#floatDcl}.
	 * @param ctx the parse tree
	 */
	void exitFloatDcl(TacTypesCheckingParser.FloatDclContext ctx);
	/**
	 * Enter a parse tree produced by {@link TacTypesCheckingParser#intPlus}.
	 * @param ctx the parse tree
	 */
	void enterIntPlus(TacTypesCheckingParser.IntPlusContext ctx);
	/**
	 * Exit a parse tree produced by {@link TacTypesCheckingParser#intPlus}.
	 * @param ctx the parse tree
	 */
	void exitIntPlus(TacTypesCheckingParser.IntPlusContext ctx);
}