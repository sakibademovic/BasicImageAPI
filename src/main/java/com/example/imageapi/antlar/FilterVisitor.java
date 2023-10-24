// Generated from /Users/sakibademovic/Desktop/imageapi/src/main/java/com/example/imageapi/support/Filter.g4 by ANTLR 4.13.1
package com.example.imageapi.antlar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FilterParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FilterVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FilterParser#parse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParse(FilterParser.ParseContext ctx);
	/**
	 * Visit a parse tree produced by {@link FilterParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery(FilterParser.QueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link FilterParser#nestedQuery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNestedQuery(FilterParser.NestedQueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link FilterParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(FilterParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FilterParser#property}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperty(FilterParser.PropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link FilterParser#operand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperand(FilterParser.OperandContext ctx);
}