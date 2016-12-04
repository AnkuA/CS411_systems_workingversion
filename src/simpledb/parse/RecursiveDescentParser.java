package simpledb.parse;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.*;
import java.io.*;

import simpledb.query.*;
import simpledb.parse.antlr.*;

//import SQLiteParser;


public class RecursiveDescentParser {
	public static void main(String[] args) {
		for(int i=0; i<args.length; i++) {
			System.out.println("arg " + i + ": " + args[i]);
		}
		//String query = "Select * from apples where apples.color = 'red' group by apples.brand;";
		//String query = "Select color, price from apples;";
		//String query = "select something;";

		String query = "";

		if(args.length > 0) {
			query = args[0];
		}

		if(query.equals("")) {
			query = "Select top 5 * from apples where apples.color = 'red' group by apples.brand;";
		}

		System.out.println("parsing: " + query);

		try{
			//InputStream stream = new ByteArrayInputStream(query.getBytes());
			//CharStream input = new UnbufferedCharStream(stream);
			CharStream input = new ANTLRInputStream(query);
			SQLBasicLexer lex = new SQLBasicLexer(input);
			TokenStream ts = new CommonTokenStream(lex);
			SQLBasicParser p = new SQLBasicParser(ts);
			ParseTree tree = p.parse();

//			System.out.println(tree.getClass());
//
//			for(int i=0; i<tree.getChildCount(); i++) {
//				System.out.println("  child " + i + ": " + tree.getChild(i).getClass());
//
//				for(int j=0; j<tree.getChild(i).getChildCount(); j++) {
//					System.out.println("    child " + j + ": " + tree.getChild(i).getChild(j).getClass());
//
//					for(int k=0; k<tree.getChild(i).getChild(j).getChildCount(); k++) {
//						System.out.println("      child " + k + ": " + tree.getChild(i).getChild(j).getChild(k).getClass());
//					}
//				}
//			}
			printParseTree(tree, 0);
			processQueryTree(tree);

		} catch(Throwable t) {
			System.out.println("Error: " + t);
			t.printStackTrace();
		}
	}

	public static QueryData query(String query) {
		CharStream input = new ANTLRInputStream(query);
		SQLBasicLexer lex = new SQLBasicLexer(input);
		TokenStream ts = new CommonTokenStream(lex);
		SQLBasicParser p = new SQLBasicParser(ts);
		ParseTree tree = p.parse();
			printParseTree(tree, 0);
		return processQueryTree(tree);
	}

	public static QueryData processQueryTree(ParseTree root) {
		SQLBasicParser.SelectContext selectCtx = (SQLBasicParser.SelectContext) root.getChild(0);

		int childIndex = 1;
		/* K_SELECT
		optional_top_term?
		distinct_or_all?
		selectexpressions
		K_FROM fromexpressions
		optional_where_expression?
		optional_group_by_expression?
		optional_having_expression?
		optional_order_by_expression?
		optional_limit_expression?
		optional_offset_expression? */

		//TODO: error messages should be sent to logger instead of system out

		if(selectCtx.getChild(childIndex) instanceof SQLBasicParser.Optional_top_termContext) {
			int top = Integer.parseInt(selectCtx.getChild(childIndex).getChild(1).getText());
			System.out.println("'TOP' parameter (" + top + ") found, but not supported.");
			childIndex++;
		}

		if(selectCtx.getChild(childIndex) instanceof SQLBasicParser.Distinct_or_allContext) {
			TerminalNode node = (TerminalNode) selectCtx.getChild(childIndex).getChild(0);

			if(node.getSymbol().getType() == SQLBasicParser.K_DISTINCT) {
				System.out.println("'DISTINCT' parameter specified, but not supported");
			}
			childIndex++;
		}

		System.out.println("Select expressions: " + selectCtx.getChild(childIndex).getText());
		Collection<String> fields = parseSelectExpressions((SQLBasicParser.SelectexpressionsContext) selectCtx.getChild(childIndex));
		childIndex += 2;
		System.out.println("From expressions: " + selectCtx.getChild(childIndex).getText());
		Collection<String> tables = parseFromExpressions((SQLBasicParser.FromexpressionsContext) selectCtx.getChild(childIndex));
		childIndex ++;

		simpledb.query.Predicate pred;

		if(selectCtx.getChildCount() > childIndex && selectCtx.getChild(childIndex) instanceof SQLBasicParser.Optional_where_expressionContext) {
			//use a helper function for this
			System.out.println("where clause");
			pred = parseWhereExpression((SQLBasicParser.Optional_where_expressionContext) selectCtx.getChild(childIndex));
			childIndex++;
		} else {
			pred = new simpledb.query.Predicate();
		}

		if(selectCtx.getChildCount() > childIndex && selectCtx.getChild(childIndex) instanceof SQLBasicParser.Optional_group_by_expressionContext) {
			//use a helper function for this
			System.out.println("group by clause specified, but not supported");
			childIndex++;
		}

		if(selectCtx.getChildCount() > childIndex && selectCtx.getChild(childIndex) instanceof SQLBasicParser.Optional_having_expressionContext) {
			//use a helper function for this
			System.out.println("having clause specified, but not supported");
			childIndex++;
		}

		if(selectCtx.getChildCount() > childIndex && selectCtx.getChild(childIndex) instanceof SQLBasicParser.Optional_order_by_expressionContext) {
			//use a helper function for this
			System.out.println("order by clause specified, but not supported");
			childIndex++;
		}

		if(selectCtx.getChildCount() > childIndex && selectCtx.getChild(childIndex) instanceof SQLBasicParser.Optional_limit_expressionContext) {
			//use a helper function for this
			System.out.println("limit by clause specified, but not supported");
			childIndex++;
		}

		if(selectCtx.getChildCount() > childIndex && selectCtx.getChild(childIndex) instanceof SQLBasicParser.Optional_offset_expressionContext) {
			//use a helper function for this
			System.out.println("offset clause (should be unmatchable)");
			childIndex++;
		}
		// TODO Group By + Aggregate
		return new QueryData(fields, tables, pred, null, null);
	}

	public static Collection<String> parseSelectExpressions(SQLBasicParser.SelectexpressionsContext root) {
		Collection<String> fields = new ArrayList<String>();
		ParseTree node = root.getChild(0).getChild(0);

		if(node instanceof SQLBasicParser.AggregateselectexpressionContext) {
			System.out.println("Aggregation specified, but not supported.");
			fields.add(parseSimpleSelectExpression((SQLBasicParser.SimpleselectexpressionContext) node.getChild(2)));
		} else {
			fields.add(parseSimpleSelectExpression((SQLBasicParser.SimpleselectexpressionContext) node));
		}

		if(root.getChildCount() > 2) {
			fields.addAll(parseSelectExpressions((SQLBasicParser.SelectexpressionsContext) root.getChild(2)));
		}
		return fields;
	}

	public static Collection<String> parseFromExpressions(SQLBasicParser.FromexpressionsContext root) {
		Collection<String> tables = new ArrayList<String>();

		tables.add(root.getChild(0).getText());

		if(root.getChildCount() > 2) {
			tables.addAll(parseFromExpressions((SQLBasicParser.FromexpressionsContext) root.getChild(2)));
		}
		return tables;
	}

	public static simpledb.query.Predicate parseWhereExpression(SQLBasicParser.Optional_where_expressionContext root) {
		//TODO
		SQLBasicParser.ExpressionContext exp = (SQLBasicParser.ExpressionContext) root.getChild(1);
		simpledb.query.Predicate pred = parseExpression(exp);
		return pred;
	}

	public static simpledb.query.Predicate parseExpression(SQLBasicParser.ExpressionContext exp) {
		SQLBasicParser.AndconditionContext e1 = (SQLBasicParser.AndconditionContext) exp.getChild(0);
		simpledb.query.Predicate pred = parseAndCondition(e1);

		if(exp.getChildCount() > 2) {
			simpledb.query.Predicate pred2 = parseExpression((SQLBasicParser.ExpressionContext) exp.getChild(2));
			pred.setIsconj(false);
			pred.conjoinWith(pred2);
		}
		return pred;
	}

	public static simpledb.query.Predicate parseAndCondition(SQLBasicParser.AndconditionContext exp) {
		SQLBasicParser.ConditionContext e1 = (SQLBasicParser.ConditionContext) exp.getChild(0);
		simpledb.query.Predicate pred = parseCondition(e1);

		if(exp.getChildCount() > 2) {
			simpledb.query.Predicate pred2 = parseAndCondition((SQLBasicParser.AndconditionContext) exp.getChild(2));
			pred.setIsconj(true);
			pred.conjoinWith(pred2);
		}
		return pred;
	}

	public static simpledb.query.Predicate parseCondition(SQLBasicParser.ConditionContext exp) {
		if(exp.getChild(0) instanceof TerminalNode) {
			TerminalNode node = (TerminalNode) exp.getChild(0);

			if(node.getSymbol().getType() == SQLBasicParser.K_NOT) {
				System.out.println("NOT operand used, but not supported");

				return parseCondition((SQLBasicParser.ConditionContext) exp.getChild(1));
			} else {
				//expression in parenthesis
				return parseExpression((SQLBasicParser.ExpressionContext) exp.getChild(1));
			}
		} else {
			SQLBasicParser.OperandContext o1 = (SQLBasicParser.OperandContext) exp.getChild(0);
			SQLBasicParser.OperandContext o2 = (SQLBasicParser.OperandContext) exp.getChild(2);
			Expression e1 = parseOperand(o1);
			Expression e2 = parseOperand(o2);

			TerminalNode comparator = (TerminalNode) exp.getChild(1);

			if(!comparator.getText().equals("=")) {
				System.out.println("Unsupported comparator used: " + comparator.getText());
			}
			return new simpledb.query.Predicate(new Term(e1, e2));
		}
	}

	public static Expression parseOperand(SQLBasicParser.OperandContext op) {
		ParseTree node = op.getChild(0);

		if(node instanceof SQLBasicParser.ConstantContext) {
			ParseTree constant = node.getChild(0);

			if(constant instanceof SQLBasicParser.IntconstantContext) {
				return new ConstantExpression(new IntConstant(Integer.parseInt(constant.getText())));
			} else if(constant instanceof SQLBasicParser.FloatconstantContext) {
				return new ConstantExpression(new FloatConstant(Float.parseFloat(constant.getText())));
			} else {
				//string constant
				return new ConstantExpression(new StringConstant(constant.getText()));
			}
		} else {
			//name
			return new FieldNameExpression(node.getText());
		}
	}

	public static String parseSimpleSelectExpression(SQLBasicParser.SimpleselectexpressionContext ctx) {
		if(ctx.getChildCount() > 1 && ctx.getChild(1) instanceof SQLBasicParser.As_alias_expressionContext) {
			System.out.println("As alias expression used, but not supported");
			return ctx.getChild(0).getText();
		}
		return ctx.getText();
	}

	public static void printParseTree(ParseTree node, int depth) {
		for(int i=0; i<depth; i++) {
			System.out.print("|  ");
		}
		String classname = node.getClass().getSimpleName();

		if(node.getChildCount() > 0) {
			System.out.println(classname);

			for(int i=0; i<node.getChildCount(); i++) {
				printParseTree(node.getChild(i), depth+1);
			}
		} else {
			System.out.println(classname + ": " + node.getText());
		}
	}
}

