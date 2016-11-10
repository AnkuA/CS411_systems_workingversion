package simpledb.parse;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import java.io.*;

import simpledb.parse.antlr.*;

//import SQLiteParser;


public class Init {
	public static void main(String[] args) {
		String query = "Select * from apples where apples.color = 'red' group by apples.brand;";
		//String query = "select something;";

		try{
			//InputStream stream = new ByteArrayInputStream(query.getBytes());
			//CharStream input = new UnbufferedCharStream(stream);
			CharStream input = new ANTLRInputStream(query);
			SQLiteLexer lex = new SQLiteLexer(input);
			TokenStream ts = new CommonTokenStream(lex);
			SQLiteParser p = new SQLiteParser(ts);
			ParseTree tree = p.parse();
			SQLiteListenerImpl walker = new SQLiteListenerImpl();
			ParseTreeWalker.DEFAULT.walk(walker, tree);

			//System.out.println(p.parse().getClass());
			//SQLiteParser.ParseContext c = p.parse();
			//System.out.println("statementcount: " + c.sql_stmt_list().size());

		} catch(Throwable t) {
			System.out.println("Error: " + t);
			t.printStackTrace();
		}
	}
}
