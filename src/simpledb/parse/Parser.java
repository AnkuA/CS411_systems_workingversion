package simpledb.parse;

import java.util.*;
import simpledb.query.*;
import simpledb.record.Schema;

/**
 * The SimpleDB parser.
 * @author Edward Sciore
 */
public class Parser {
   private Lexer lex;
   
   public Parser(String s) {
      lex = new Lexer(s);
   }
   
// Methods for parsing predicates, terms, expressions, constants, and fields
   
   public String field() {
      return lex.eatId();
   }
   
   public Constant constant() {
      if (lex.matchStringConstant()){
         return new StringConstant(lex.eatStringConstant());
      }
      //AA: Check Int constant status
      else if (lex.matchIntConstant()){
          return new IntConstant(lex.eatIntConstant());
       }
      //AA: Added this
      else {
          return new FloatConstant(lex.eatFloatConstant());
      }
   }
   
   public Expression expression() {
      if (lex.matchId())
         return new FieldNameExpression(field());
      else
         return new ConstantExpression(constant());
   }
   
   public Term term() {
      Expression lhs = expression();
      lex.eatDelim('=');
      Expression rhs = expression();
      return new Term(lhs, "=", rhs);
   }
   
   public Predicate predicate() {
//      Predicate pred = new Predicate(term());
//      if (lex.matchKeyword("and")) {
//         lex.eatKeyword("and");
//         pred.conjoinWith(predicate());
//      }
//      return pred;
      Predicate pred = new Predicate(term());
      if (lex.matchKeyword("and")) {
         lex.eatKeyword("and");
         pred.setIsconj(true);
         pred.conjoinWith(predicate());
      }else if(lex.matchKeyword("or")){
    	  lex.eatKeyword("or");
    	  pred.setIsconj(false);
    	  pred.conjoinWith(predicate());
      }
      return pred;
   }
   
// Methods for parsing queries
   
   public QueryData query() {
      lex.eatKeyword("select");
      HashMap<String, Aggregate> aggr = new HashMap<String, Aggregate>();
      Collection<String> fields = selectList(aggr);
      lex.eatKeyword("from");
      Collection<String> tables = tableList();
      Predicate pred = new Predicate();
      if (lex.matchKeyword("where")) {
         lex.eatKeyword("where");
         pred = predicate();
      }
      Collection<String> groupby = null;
      if(lex.matchKeyword("group")) {
          lex.eatKeyword("group");
          lex.eatKeyword("by");
          groupby = groupbyList();
          // Check for valid fields
//          for(String field : fields)
//        	  if(!groupby.contains(field))
//        		  throw new BadSyntaxException();
      }
      
      if(aggr.size() == 0)
    	  aggr = null;
      return new QueryData(fields, tables, pred, groupby, aggr);
   }
  

private Collection<String> selectList(HashMap<String, Aggregate> aggr) {
     /* Collection<String> L = new ArrayList<String>();
      L.add(field());
      if (lex.matchDelim(',')) {
         lex.eatDelim(',');
         L.addAll(selectList());
      }
      return L;*/
      Collection<String> L = new ArrayList<String>();
	  if(lex.matchDelim('*')){
		  //return all field
		  lex.eatDelim('*');
		  L.add("*");
		  return L;
	  }
	  else {
	  if(lex.matchKeyword("max")) {
		  lex.eatKeyword("max");
		  lex.eatDelim('(');
		  String field = field();
		  L.add(field);
		  aggr.put("max(" + field + ")", new Max(field));
		  lex.eatDelim(')');
	  }
	  else if(lex.matchKeyword("min")) {
		  lex.eatKeyword("min");
		  lex.eatDelim('(');
		  String field = field();
		  L.add(field);
		  aggr.put("min(" + field + ")", new Min(field));
		  lex.eatDelim(')');
	  }
	  else if(lex.matchKeyword("avg")) {
		  lex.eatKeyword("avg");
		  lex.eatDelim('(');
		  String field = field();
		  L.add(field);
		  aggr.put("avg(" + field + ")", new Average(field));
		  lex.eatDelim(')');
	  }
	  else if(lex.matchKeyword("sum")) {
		  lex.eatKeyword("sum");
		  lex.eatDelim('(');
		  String field = field();
		  L.add(field);
		  aggr.put("sum(" + field + ")", new Sum(field));
		  lex.eatDelim(')');
	  }
	  else if(lex.matchKeyword("count")) {
		  lex.eatKeyword("count");
		  lex.eatDelim('(');
		  String field = field();
		  L.add(field);
		  aggr.put("count(" + field + ")", new Count(field));
		  lex.eatDelim(')');
	  }
	  else
		  L.add(field());
      if (lex.matchDelim(',')) {
         lex.eatDelim(',');
         L.addAll(selectList(aggr));
      }
      return L;
	  }
   }
   
   private Collection<String> tableList() {
      Collection<String> L = new ArrayList<String>();
      L.add(lex.eatId());
      if (lex.matchDelim(',')) {
         lex.eatDelim(',');
         L.addAll(tableList());
      }
      return L;
   }
   
   private Collection<String> groupbyList() {
	  Collection<String> L = new ArrayList<String>();
	  L.add(field());
      if (lex.matchDelim(',')) {
         lex.eatDelim(',');
         L.addAll(groupbyList());
      }
	  return L;
   }
// Methods for parsing the various update commands
   
   public Object updateCmd() {
      if (lex.matchKeyword("insert"))
         return insert();
      else if (lex.matchKeyword("delete"))
         return delete();
      else if (lex.matchKeyword("update"))
         return modify();
      else
         return create();
   }
   
   private Object create() {
      lex.eatKeyword("create");
      if (lex.matchKeyword("table"))
         return createTable();
      else if (lex.matchKeyword("view"))
         return createView();
      else
         return createIndex();
   }
   
// Method for parsing delete commands
   
   public DeleteData delete() {
      lex.eatKeyword("delete");
      lex.eatKeyword("from");
      String tblname = lex.eatId();
      Predicate pred = new Predicate();
      if (lex.matchKeyword("where")) {
         lex.eatKeyword("where");
         pred = predicate();
      }
      return new DeleteData(tblname, pred);
   }
   
// Methods for parsing insert commands
   
   public InsertData insert() {
      lex.eatKeyword("insert");
      lex.eatKeyword("into");
      String tblname = lex.eatId();
      lex.eatDelim('(');
      List<String> flds = fieldList();
      lex.eatDelim(')');
      lex.eatKeyword("values");
      lex.eatDelim('(');
      List<Constant> vals = constList();
      lex.eatDelim(')');
      return new InsertData(tblname, flds, vals);
   }
   
   private List<String> fieldList() {
      List<String> L = new ArrayList<String>();
      L.add(field());
      if (lex.matchDelim(',')) {
         lex.eatDelim(',');
         L.addAll(fieldList());
      }
      return L;
   }
   
   private List<Constant> constList() {
      List<Constant> L = new ArrayList<Constant>();
      L.add(constant());
      if (lex.matchDelim(',')) {
         lex.eatDelim(',');
         L.addAll(constList());
      }
      return L;
   }
   
// Method for parsing modify commands
   
   public ModifyData modify() {
      lex.eatKeyword("update");
      String tblname = lex.eatId();
      lex.eatKeyword("set");
      String fldname = field();
      lex.eatDelim('=');
      Expression newval = expression();
      Predicate pred = new Predicate();
      if (lex.matchKeyword("where")) {
         lex.eatKeyword("where");
         pred = predicate();
      }
      return new ModifyData(tblname, fldname, newval, pred);
   }
   
// Method for parsing create table commands
   
   public CreateTableData createTable() {
      lex.eatKeyword("table");
      String tblname = lex.eatId();
      lex.eatDelim('(');
      Schema sch = fieldDefs();
      lex.eatDelim(')');
      return new CreateTableData(tblname, sch);
   }
   
   private Schema fieldDefs() {
      Schema schema = fieldDef();
      if (lex.matchDelim(',')) {
         lex.eatDelim(',');
         Schema schema2 = fieldDefs();
         schema.addAll(schema2);
      }
      return schema;
   }
   
   private Schema fieldDef() {
      String fldname = field();
      return fieldType(fldname);
   }
   
   private Schema fieldType(String fldname) {
      Schema schema = new Schema();
      if (lex.matchKeyword("int")) {
         lex.eatKeyword("int");
         schema.addIntField(fldname);
      }
      //AA:
      else if (lex.matchKeyword("float")) {
          lex.eatKeyword("float");
          schema.addFloatField(fldname);
      }
      else {
         lex.eatKeyword("varchar");
         lex.eatDelim('(');
         int strLen = lex.eatIntConstant();
         lex.eatDelim(')');
         schema.addStringField(fldname, strLen);
      }
      return schema;
   }
   
// Method for parsing create view commands
   
   public CreateViewData createView() {
      lex.eatKeyword("view");
      String viewname = lex.eatId();
      lex.eatKeyword("as");
      QueryData qd = query();
      return new CreateViewData(viewname, qd);
   }
   
   
//  Method for parsing create index commands
   
   public CreateIndexData createIndex() {
      lex.eatKeyword("index");
      String idxname = lex.eatId();
      lex.eatKeyword("on");
      String tblname = lex.eatId();
      lex.eatDelim('(');
      String fldname = field();
      lex.eatDelim(')');
      return new CreateIndexData(idxname, tblname, fldname);
   }
}

