// Generated from Pil.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PilParser}.
 */
public interface PilListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PilParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(PilParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link PilParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(PilParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link PilParser#statementComposition}.
	 * @param ctx the parse tree
	 */
	void enterStatementComposition(PilParser.StatementCompositionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PilParser#statementComposition}.
	 * @param ctx the parse tree
	 */
	void exitStatementComposition(PilParser.StatementCompositionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PilParser#statementWithBreak}.
	 * @param ctx the parse tree
	 */
	void enterStatementWithBreak(PilParser.StatementWithBreakContext ctx);
	/**
	 * Exit a parse tree produced by {@link PilParser#statementWithBreak}.
	 * @param ctx the parse tree
	 */
	void exitStatementWithBreak(PilParser.StatementWithBreakContext ctx);
	/**
	 * Enter a parse tree produced by {@link PilParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(PilParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PilParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(PilParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfElse}
	 * labeled alternative in {@link PilParser#if}.
	 * @param ctx the parse tree
	 */
	void enterIfElse(PilParser.IfElseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfElse}
	 * labeled alternative in {@link PilParser#if}.
	 * @param ctx the parse tree
	 */
	void exitIfElse(PilParser.IfElseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LoopFull}
	 * labeled alternative in {@link PilParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterLoopFull(PilParser.LoopFullContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LoopFull}
	 * labeled alternative in {@link PilParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitLoopFull(PilParser.LoopFullContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LoopSimple}
	 * labeled alternative in {@link PilParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterLoopSimple(PilParser.LoopSimpleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LoopSimple}
	 * labeled alternative in {@link PilParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitLoopSimple(PilParser.LoopSimpleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WritelnExpr}
	 * labeled alternative in {@link PilParser#write}.
	 * @param ctx the parse tree
	 */
	void enterWritelnExpr(PilParser.WritelnExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WritelnExpr}
	 * labeled alternative in {@link PilParser#write}.
	 * @param ctx the parse tree
	 */
	void exitWritelnExpr(PilParser.WritelnExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WriteExpr}
	 * labeled alternative in {@link PilParser#write}.
	 * @param ctx the parse tree
	 */
	void enterWriteExpr(PilParser.WriteExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WriteExpr}
	 * labeled alternative in {@link PilParser#write}.
	 * @param ctx the parse tree
	 */
	void exitWriteExpr(PilParser.WriteExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PilParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(PilParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PilParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(PilParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprRead}
	 * labeled alternative in {@link PilParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprRead(PilParser.ExprReadContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprRead}
	 * labeled alternative in {@link PilParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprRead(PilParser.ExprReadContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprBinaryLogical}
	 * labeled alternative in {@link PilParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprBinaryLogical(PilParser.ExprBinaryLogicalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprBinaryLogical}
	 * labeled alternative in {@link PilParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprBinaryLogical(PilParser.ExprBinaryLogicalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprBoolean}
	 * labeled alternative in {@link PilParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprBoolean(PilParser.ExprBooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprBoolean}
	 * labeled alternative in {@link PilParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprBoolean(PilParser.ExprBooleanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprFloat}
	 * labeled alternative in {@link PilParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprFloat(PilParser.ExprFloatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprFloat}
	 * labeled alternative in {@link PilParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprFloat(PilParser.ExprFloatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprText}
	 * labeled alternative in {@link PilParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprText(PilParser.ExprTextContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprText}
	 * labeled alternative in {@link PilParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprText(PilParser.ExprTextContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprParenthesis}
	 * labeled alternative in {@link PilParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprParenthesis(PilParser.ExprParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprParenthesis}
	 * labeled alternative in {@link PilParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprParenthesis(PilParser.ExprParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprMultDivMod}
	 * labeled alternative in {@link PilParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprMultDivMod(PilParser.ExprMultDivModContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprMultDivMod}
	 * labeled alternative in {@link PilParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprMultDivMod(PilParser.ExprMultDivModContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprError}
	 * labeled alternative in {@link PilParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprError(PilParser.ExprErrorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprError}
	 * labeled alternative in {@link PilParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprError(PilParser.ExprErrorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprUnary}
	 * labeled alternative in {@link PilParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprUnary(PilParser.ExprUnaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprUnary}
	 * labeled alternative in {@link PilParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprUnary(PilParser.ExprUnaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprAddMinus}
	 * labeled alternative in {@link PilParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprAddMinus(PilParser.ExprAddMinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprAddMinus}
	 * labeled alternative in {@link PilParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprAddMinus(PilParser.ExprAddMinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprInteger}
	 * labeled alternative in {@link PilParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprInteger(PilParser.ExprIntegerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprInteger}
	 * labeled alternative in {@link PilParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprInteger(PilParser.ExprIntegerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprId}
	 * labeled alternative in {@link PilParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprId(PilParser.ExprIdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprId}
	 * labeled alternative in {@link PilParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprId(PilParser.ExprIdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprBinaryRelational}
	 * labeled alternative in {@link PilParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprBinaryRelational(PilParser.ExprBinaryRelationalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprBinaryRelational}
	 * labeled alternative in {@link PilParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprBinaryRelational(PilParser.ExprBinaryRelationalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprTypeConversion}
	 * labeled alternative in {@link PilParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprTypeConversion(PilParser.ExprTypeConversionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprTypeConversion}
	 * labeled alternative in {@link PilParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprTypeConversion(PilParser.ExprTypeConversionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PilParser#idset}.
	 * @param ctx the parse tree
	 */
	void enterIdset(PilParser.IdsetContext ctx);
	/**
	 * Exit a parse tree produced by {@link PilParser#idset}.
	 * @param ctx the parse tree
	 */
	void exitIdset(PilParser.IdsetContext ctx);
}