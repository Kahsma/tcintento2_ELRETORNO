// Generated from Expr.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExprParser}.
 */
public interface ExprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExprParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(ExprParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(ExprParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code imprimir}
	 * labeled alternative in {@link ExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterImprimir(ExprParser.ImprimirContext ctx);
	/**
	 * Exit a parse tree produced by the {@code imprimir}
	 * labeled alternative in {@link ExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitImprimir(ExprParser.ImprimirContext ctx);
	/**
	 * Enter a parse tree produced by the {@code asignar}
	 * labeled alternative in {@link ExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterAsignar(ExprParser.AsignarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code asignar}
	 * labeled alternative in {@link ExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitAsignar(ExprParser.AsignarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blanco}
	 * labeled alternative in {@link ExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterBlanco(ExprParser.BlancoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blanco}
	 * labeled alternative in {@link ExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitBlanco(ExprParser.BlancoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SumRes}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSumRes(ExprParser.SumResContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SumRes}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSumRes(ExprParser.SumResContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDiv(ExprParser.MulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDiv(ExprParser.MulDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Ent}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEnt(ExprParser.EntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Ent}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEnt(ExprParser.EntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Paren}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParen(ExprParser.ParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Paren}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParen(ExprParser.ParenContext ctx);
}