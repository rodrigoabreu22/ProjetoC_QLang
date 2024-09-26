package qlang_interpreter;

// Generated from Pil.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PilParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PilVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PilParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(PilParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link PilParser#statementComposition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementComposition(PilParser.StatementCompositionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PilParser#statementWithBreak}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementWithBreak(PilParser.StatementWithBreakContext ctx);
	/**
	 * Visit a parse tree produced by {@link PilParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(PilParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfElse}
	 * labeled alternative in {@link PilParser#if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElse(PilParser.IfElseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LoopFull}
	 * labeled alternative in {@link PilParser#loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopFull(PilParser.LoopFullContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LoopSimple}
	 * labeled alternative in {@link PilParser#loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopSimple(PilParser.LoopSimpleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WritelnExpr}
	 * labeled alternative in {@link PilParser#write}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWritelnExpr(PilParser.WritelnExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WriteExpr}
	 * labeled alternative in {@link PilParser#write}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWriteExpr(PilParser.WriteExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PilParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(PilParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprRead}
	 * labeled alternative in {@link PilParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprRead(PilParser.ExprReadContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprBinaryLogical}
	 * labeled alternative in {@link PilParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprBinaryLogical(PilParser.ExprBinaryLogicalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprBoolean}
	 * labeled alternative in {@link PilParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprBoolean(PilParser.ExprBooleanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprFloat}
	 * labeled alternative in {@link PilParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprFloat(PilParser.ExprFloatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprText}
	 * labeled alternative in {@link PilParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprText(PilParser.ExprTextContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprParenthesis}
	 * labeled alternative in {@link PilParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprParenthesis(PilParser.ExprParenthesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprMultDivMod}
	 * labeled alternative in {@link PilParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMultDivMod(PilParser.ExprMultDivModContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprError}
	 * labeled alternative in {@link PilParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprError(PilParser.ExprErrorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprUnary}
	 * labeled alternative in {@link PilParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprUnary(PilParser.ExprUnaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprAddMinus}
	 * labeled alternative in {@link PilParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAddMinus(PilParser.ExprAddMinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprInteger}
	 * labeled alternative in {@link PilParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprInteger(PilParser.ExprIntegerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprId}
	 * labeled alternative in {@link PilParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprId(PilParser.ExprIdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprBinaryRelational}
	 * labeled alternative in {@link PilParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprBinaryRelational(PilParser.ExprBinaryRelationalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprTypeConversion}
	 * labeled alternative in {@link PilParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprTypeConversion(PilParser.ExprTypeConversionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PilParser#idset}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdset(PilParser.IdsetContext ctx);
}