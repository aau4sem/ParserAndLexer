// Generated from E:/SourceTree/AAU-Notes/4-Semester/Misc/Antlr\Tactic.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TacticParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TacticVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TacticParser#r}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitR(TacticParser.RContext ctx);
}