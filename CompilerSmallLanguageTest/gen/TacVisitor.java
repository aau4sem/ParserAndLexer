// Generated from E:/SourceTree/ParserAndLexer/CompilerSmallLanguageTest\Tac.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TacParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TacVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TacParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(TacParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link TacParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(TacParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TacParser#let}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLet(TacParser.LetContext ctx);
	/**
	 * Visit a parse tree produced by {@link TacParser#show}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShow(TacParser.ShowContext ctx);
}