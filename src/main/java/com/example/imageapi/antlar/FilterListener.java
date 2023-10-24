// Generated from /Users/sakibademovic/Desktop/imageapi/src/main/java/com/example/imageapi/support/Filter.g4 by ANTLR 4.13.1
package com.example.imageapi.antlar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FilterParser}.
 */
public interface FilterListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FilterParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(FilterParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link FilterParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(FilterParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by {@link FilterParser#query}.
	 * @param ctx the parse tree
	 */
	void enterQuery(FilterParser.QueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link FilterParser#query}.
	 * @param ctx the parse tree
	 */
	void exitQuery(FilterParser.QueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link FilterParser#nestedQuery}.
	 * @param ctx the parse tree
	 */
	void enterNestedQuery(FilterParser.NestedQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link FilterParser#nestedQuery}.
	 * @param ctx the parse tree
	 */
	void exitNestedQuery(FilterParser.NestedQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link FilterParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(FilterParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FilterParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(FilterParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FilterParser#property}.
	 * @param ctx the parse tree
	 */
	void enterProperty(FilterParser.PropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link FilterParser#property}.
	 * @param ctx the parse tree
	 */
	void exitProperty(FilterParser.PropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link FilterParser#operand}.
	 * @param ctx the parse tree
	 */
	void enterOperand(FilterParser.OperandContext ctx);
	/**
	 * Exit a parse tree produced by {@link FilterParser#operand}.
	 * @param ctx the parse tree
	 */
	void exitOperand(FilterParser.OperandContext ctx);
}