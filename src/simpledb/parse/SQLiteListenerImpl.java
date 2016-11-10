package simpledb.parse;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.*;

import simpledb.parse.antlr.*;
import java.util.*;
import simpledb.query.*;


//   public Plan createQueryPlan(String qry, Transaction tx) {
//      Parser parser = new Parser(qry);
//      QueryData data = parser.query();
//      return qplanner.createPlan(data, tx);
//   }

public class SQLiteListenerImpl extends SQLiteBaseListener {

	private QueryData query;

	public SQLiteListenerImpl() {
		super();
		query = null;
	}

	//only valid after a walk
	public QueryData getWalkResult() {
		return query;
	}

	@Override
	public void enterParse(SQLiteParser.ParseContext ctx) {
		System.out.println("enterParse");
	}

	@Override
	public void exitParse(SQLiteParser.ParseContext ctx) {
		System.out.println("exitParse: " + ctx.getText());
	}

	@Override
	public void enterSql_stmt(SQLiteParser.Sql_stmtContext ctx) {
		System.out.println("enterSql_stmt");
	}

	@Override
	public void exitSql_stmt(SQLiteParser.Sql_stmtContext ctx) {
		System.out.println("exitSql_stmt: " + ctx.getText());
	}

	@Override
	public void enterSelect_stmt(SQLiteParser.Select_stmtContext ctx) {
		System.out.println("enterSelect_stmt");
	}

	@Override
	public void exitSelect_stmt(SQLiteParser.Select_stmtContext ctx) {
		System.out.println("exitSelect_stmt: " + ctx.getText());
		System.out.println("children: " + ctx.getChildCount());
	}

	@Override
	public void enterSimple_select_stmt(SQLiteParser.Simple_select_stmtContext ctx) {

	}

	@Override
	public void exitSimple_select_stmt(SQLiteParser.Simple_select_stmtContext ctx) {
		System.out.println("exitSimple_select_stmt: " + ctx.getText());
		System.out.println("children: " + ctx.getChildCount());
	}

	@Override
	public void enterCompound_select_stmt(SQLiteParser.Compound_select_stmtContext ctx) {

	}

	@Override
	public void exitCompound_select_stmt(SQLiteParser.Compound_select_stmtContext ctx) {
		System.out.println("exitCompound_select_stmt: " + ctx.getText());
		System.out.println("children: " + ctx.getChildCount());
	}

	@Override
	public void enterFactored_select_stmt(SQLiteParser.Factored_select_stmtContext ctx) {

	}

	@Override
	public void exitFactored_select_stmt(SQLiteParser.Factored_select_stmtContext ctx) {
		System.out.println("exitFactored_select_stmt: " + ctx.getText());
		System.out.println("children: " + ctx.getChildCount());
		System.out.println(ctx.getChild(0).getClass().getSimpleName());
	}

	@Override
	public void enterSelect_core(SQLiteParser.Select_coreContext ctx) {

	}

	@Override
	public void exitSelect_core(SQLiteParser.Select_coreContext ctx) {
		System.out.println("exitSelect_core: " + ctx.getText());
		System.out.println("children: " + ctx.getChildCount());

/*
select_core
 : K_SELECT ( K_DISTINCT | K_ALL )? result_column ( ',' result_column )*
   ( K_FROM ( table_or_subquery ( ',' table_or_subquery )* | join_clause ) )?
   ( K_WHERE expr )?
   ( K_GROUP K_BY expr ( ',' expr )* ( K_HAVING expr )? )?
 | K_VALUES '(' expr ( ',' expr )* ')' ( ',' '(' expr ( ',' expr )* ')' )*
 ;
*/

		int i=1;

		//Step 1. collect fields
		Collection<String> fields = new ArrayList<String>();

		for(; i<ctx.getChildCount(); i++) {
			ParseTree node = ctx.getChild(i);
			System.out.println(node.getClass().getName());


			//hard code parse tree
			if(node instanceof org.antlr.v4.runtime.tree.TerminalNode) {
				TerminalNode n = (TerminalNode)node;
				System.out.println("terminal: " + n.getText());

				if(n.getText().equals(",")) {
					continue;
				} else {
					if(n.getText().equalsIgnoreCase("FROM")) {
						i++;
						break;
					}
				}
				throw new BadSyntaxException();
			} else {
				if(node instanceof simpledb.parse.antlr.SQLiteParser.Result_columnContext) {
					fields.add(((ParserRuleContext)node).getText());
				} else {
					throw new BadSyntaxException();
				}
			}
		}

		if(fields.size() == 0) {
			throw new BadSyntaxException();
		}

		//Step 2. collect tables
		Collection<String> tables = new ArrayList<String>();

		for(; i<ctx.getChildCount(); i++) {
			ParseTree node = ctx.getChild(i);
			System.out.println(node.getClass().getName());


			//hard code parse tree
			if(node instanceof org.antlr.v4.runtime.tree.TerminalNode) {
				TerminalNode n = (TerminalNode)node;
				System.out.println("terminal: " + n.getText());

				if(n.getText().equals(",")) {
					continue;
				} else {
					break;
				}
			} else {
				if(node instanceof simpledb.parse.antlr.SQLiteParser.Table_or_subqueryContext) {
					tables.add(((ParserRuleContext)node).getText());
				} else {
					throw new BadSyntaxException();
				}
			}
		}

		if(tables.size() == 0) {
			throw new BadSyntaxException();
		}

		//Step 3. add predicate if present

		if(i < ctx.getChildCount()) {
			ParseTree node = ctx.getChild(i);

			if(node instanceof org.antlr.v4.runtime.tree.TerminalNode) {
				TerminalNode n = (TerminalNode)node;
				System.out.println("terminal: " + n.getText());

				if(n.getText().equalsIgnoreCase("WHERE")) {
					//predicates not yet implemented
					throw new BadSyntaxException();
				}
			}
		}
		query = new QueryData(fields, tables, new Predicate());
	}

	@Override
	public void visitTerminal(TerminalNode node) {
		System.out.println("visitTerminal: " + node.getText());
	}
}
