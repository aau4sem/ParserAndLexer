package gen;// Generated from E:/SourceTree/ParserAndLexer/CompilerSmallLanguageTest\Tac.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TacParser}.
 */
public interface TacListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TacParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(TacParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link TacParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(TacParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link TacParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(TacParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TacParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(TacParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TacParser#let}.
	 * @param ctx the parse tree
	 */
	void enterLet(TacParser.LetContext ctx);
	/**
	 * Exit a parse tree produced by {@link TacParser#let}.
	 * @param ctx the parse tree
	 */
	void exitLet(TacParser.LetContext ctx);
	/**
	 * Enter a parse tree produced by {@link TacParser#show}.
	 * @param ctx the parse tree
	 */
	void enterShow(TacParser.ShowContext ctx);
	/**
	 * Exit a parse tree produced by {@link TacParser#show}.
	 * @param ctx the parse tree
	 */
	void exitShow(TacParser.ShowContext ctx);
}