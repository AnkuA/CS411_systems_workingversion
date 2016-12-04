package simpledb.parse.antlr; 
// Generated from .\simpledb\parse\antlr\SQLBasic.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SQLBasicParser}.
 */
public interface SQLBasicListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SQLBasicParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(SQLBasicParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBasicParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(SQLBasicParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBasicParser#error}.
	 * @param ctx the parse tree
	 */
	void enterError(SQLBasicParser.ErrorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBasicParser#error}.
	 * @param ctx the parse tree
	 */
	void exitError(SQLBasicParser.ErrorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBasicParser#select}.
	 * @param ctx the parse tree
	 */
	void enterSelect(SQLBasicParser.SelectContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBasicParser#select}.
	 * @param ctx the parse tree
	 */
	void exitSelect(SQLBasicParser.SelectContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBasicParser#optional_top_term}.
	 * @param ctx the parse tree
	 */
	void enterOptional_top_term(SQLBasicParser.Optional_top_termContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBasicParser#optional_top_term}.
	 * @param ctx the parse tree
	 */
	void exitOptional_top_term(SQLBasicParser.Optional_top_termContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBasicParser#distinct_or_all}.
	 * @param ctx the parse tree
	 */
	void enterDistinct_or_all(SQLBasicParser.Distinct_or_allContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBasicParser#distinct_or_all}.
	 * @param ctx the parse tree
	 */
	void exitDistinct_or_all(SQLBasicParser.Distinct_or_allContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBasicParser#selectexpressions}.
	 * @param ctx the parse tree
	 */
	void enterSelectexpressions(SQLBasicParser.SelectexpressionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBasicParser#selectexpressions}.
	 * @param ctx the parse tree
	 */
	void exitSelectexpressions(SQLBasicParser.SelectexpressionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBasicParser#selectexpression}.
	 * @param ctx the parse tree
	 */
	void enterSelectexpression(SQLBasicParser.SelectexpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBasicParser#selectexpression}.
	 * @param ctx the parse tree
	 */
	void exitSelectexpression(SQLBasicParser.SelectexpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBasicParser#simpleselectexpression}.
	 * @param ctx the parse tree
	 */
	void enterSimpleselectexpression(SQLBasicParser.SimpleselectexpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBasicParser#simpleselectexpression}.
	 * @param ctx the parse tree
	 */
	void exitSimpleselectexpression(SQLBasicParser.SimpleselectexpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBasicParser#aggregateselectexpression}.
	 * @param ctx the parse tree
	 */
	void enterAggregateselectexpression(SQLBasicParser.AggregateselectexpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBasicParser#aggregateselectexpression}.
	 * @param ctx the parse tree
	 */
	void exitAggregateselectexpression(SQLBasicParser.AggregateselectexpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBasicParser#aggregation}.
	 * @param ctx the parse tree
	 */
	void enterAggregation(SQLBasicParser.AggregationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBasicParser#aggregation}.
	 * @param ctx the parse tree
	 */
	void exitAggregation(SQLBasicParser.AggregationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBasicParser#fromexpressions}.
	 * @param ctx the parse tree
	 */
	void enterFromexpressions(SQLBasicParser.FromexpressionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBasicParser#fromexpressions}.
	 * @param ctx the parse tree
	 */
	void exitFromexpressions(SQLBasicParser.FromexpressionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBasicParser#fromexpression}.
	 * @param ctx the parse tree
	 */
	void enterFromexpression(SQLBasicParser.FromexpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBasicParser#fromexpression}.
	 * @param ctx the parse tree
	 */
	void exitFromexpression(SQLBasicParser.FromexpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBasicParser#subqueryfromexpression}.
	 * @param ctx the parse tree
	 */
	void enterSubqueryfromexpression(SQLBasicParser.SubqueryfromexpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBasicParser#subqueryfromexpression}.
	 * @param ctx the parse tree
	 */
	void exitSubqueryfromexpression(SQLBasicParser.SubqueryfromexpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBasicParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(SQLBasicParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBasicParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(SQLBasicParser.NameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBasicParser#fullname}.
	 * @param ctx the parse tree
	 */
	void enterFullname(SQLBasicParser.FullnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBasicParser#fullname}.
	 * @param ctx the parse tree
	 */
	void exitFullname(SQLBasicParser.FullnameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBasicParser#optional_where_expression}.
	 * @param ctx the parse tree
	 */
	void enterOptional_where_expression(SQLBasicParser.Optional_where_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBasicParser#optional_where_expression}.
	 * @param ctx the parse tree
	 */
	void exitOptional_where_expression(SQLBasicParser.Optional_where_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBasicParser#optional_group_by_expression}.
	 * @param ctx the parse tree
	 */
	void enterOptional_group_by_expression(SQLBasicParser.Optional_group_by_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBasicParser#optional_group_by_expression}.
	 * @param ctx the parse tree
	 */
	void exitOptional_group_by_expression(SQLBasicParser.Optional_group_by_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBasicParser#optional_having_expression}.
	 * @param ctx the parse tree
	 */
	void enterOptional_having_expression(SQLBasicParser.Optional_having_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBasicParser#optional_having_expression}.
	 * @param ctx the parse tree
	 */
	void exitOptional_having_expression(SQLBasicParser.Optional_having_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBasicParser#optional_order_by_expression}.
	 * @param ctx the parse tree
	 */
	void enterOptional_order_by_expression(SQLBasicParser.Optional_order_by_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBasicParser#optional_order_by_expression}.
	 * @param ctx the parse tree
	 */
	void exitOptional_order_by_expression(SQLBasicParser.Optional_order_by_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBasicParser#sort_order}.
	 * @param ctx the parse tree
	 */
	void enterSort_order(SQLBasicParser.Sort_orderContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBasicParser#sort_order}.
	 * @param ctx the parse tree
	 */
	void exitSort_order(SQLBasicParser.Sort_orderContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBasicParser#null_order}.
	 * @param ctx the parse tree
	 */
	void enterNull_order(SQLBasicParser.Null_orderContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBasicParser#null_order}.
	 * @param ctx the parse tree
	 */
	void exitNull_order(SQLBasicParser.Null_orderContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBasicParser#optional_limit_expression}.
	 * @param ctx the parse tree
	 */
	void enterOptional_limit_expression(SQLBasicParser.Optional_limit_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBasicParser#optional_limit_expression}.
	 * @param ctx the parse tree
	 */
	void exitOptional_limit_expression(SQLBasicParser.Optional_limit_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBasicParser#optional_offset_expression}.
	 * @param ctx the parse tree
	 */
	void enterOptional_offset_expression(SQLBasicParser.Optional_offset_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBasicParser#optional_offset_expression}.
	 * @param ctx the parse tree
	 */
	void exitOptional_offset_expression(SQLBasicParser.Optional_offset_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBasicParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(SQLBasicParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBasicParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(SQLBasicParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBasicParser#andcondition}.
	 * @param ctx the parse tree
	 */
	void enterAndcondition(SQLBasicParser.AndconditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBasicParser#andcondition}.
	 * @param ctx the parse tree
	 */
	void exitAndcondition(SQLBasicParser.AndconditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBasicParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(SQLBasicParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBasicParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(SQLBasicParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBasicParser#operand}.
	 * @param ctx the parse tree
	 */
	void enterOperand(SQLBasicParser.OperandContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBasicParser#operand}.
	 * @param ctx the parse tree
	 */
	void exitOperand(SQLBasicParser.OperandContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBasicParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(SQLBasicParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBasicParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(SQLBasicParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBasicParser#intconstant}.
	 * @param ctx the parse tree
	 */
	void enterIntconstant(SQLBasicParser.IntconstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBasicParser#intconstant}.
	 * @param ctx the parse tree
	 */
	void exitIntconstant(SQLBasicParser.IntconstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBasicParser#floatconstant}.
	 * @param ctx the parse tree
	 */
	void enterFloatconstant(SQLBasicParser.FloatconstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBasicParser#floatconstant}.
	 * @param ctx the parse tree
	 */
	void exitFloatconstant(SQLBasicParser.FloatconstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBasicParser#as_alias_expression}.
	 * @param ctx the parse tree
	 */
	void enterAs_alias_expression(SQLBasicParser.As_alias_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBasicParser#as_alias_expression}.
	 * @param ctx the parse tree
	 */
	void exitAs_alias_expression(SQLBasicParser.As_alias_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBasicParser#nothing}.
	 * @param ctx the parse tree
	 */
	void enterNothing(SQLBasicParser.NothingContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBasicParser#nothing}.
	 * @param ctx the parse tree
	 */
	void exitNothing(SQLBasicParser.NothingContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBasicParser#unmatchable}.
	 * @param ctx the parse tree
	 */
	void enterUnmatchable(SQLBasicParser.UnmatchableContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBasicParser#unmatchable}.
	 * @param ctx the parse tree
	 */
	void exitUnmatchable(SQLBasicParser.UnmatchableContext ctx);
}