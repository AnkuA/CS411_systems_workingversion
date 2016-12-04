package simpledb.planner;

import simpledb.tx.Transaction;
import simpledb.query.*;
import simpledb.record.RID;
import simpledb.record.RecordFile;
import simpledb.record.Schema;
import simpledb.record.TableInfo;
import simpledb.parse.*;
import simpledb.server.SimpleDB;
import java.util.*;
import static java.sql.Types.INTEGER;

/**
 * The simplest, most naive query planner possible.
 * @author Edward Sciore
 */
public class BasicQueryPlanner implements QueryPlanner {
   
   /**
    * Creates a query plan as follows.  It first takes
    * the product of all tables and views; it then selects on the predicate;
    * and finally it projects on the field list. 
    */
//   public Plan createPlan(QueryData data, Transaction tx) {
//      //Step 1: Create a plan for each mentioned table or view
//      List<Plan> plans = new ArrayList<Plan>();
//      for (String tblname : data.tables()) {
//         String viewdef = SimpleDB.mdMgr().getViewDef(tblname, tx);
//         if (viewdef != null)
//            plans.add(SimpleDB.planner().createQueryPlan(viewdef, tx));
//         else
//            plans.add(new TablePlan(tblname, tx));
//      }
//      
//      //Step 2: Create the product of all table plans
//      Plan p = plans.remove(0);
//      for (Plan nextplan : plans)
//         p = new ProductPlan(p, nextplan);
//      
//      //Step 3: Add a selection plan for the predicate
//      p = new SelectPlan(p, data.pred());
//      
//      //Step 4: Project on the field names
//      //p = new ProjectPlan(p, data.fields());
//      //return p;
//      //Step 4: Project on the field names
//      // Collection <String> temp;
//       
//       Iterator<String> it = data.fields().iterator();
//       if( data.fields().size() == 1){
//     	  String hold = it.next();
//     	  if(hold.equals("*")){
//     		 it.remove();
//     		 for(String tblname : data.tables()){
//     			 //System.out.println(tblname);
//     			 TableInfo curr =SimpleDB.mdMgr().getTableInfo(tblname, tx);
//     			 Schema curSchema = curr.schema();
//     			 //for(String names: curSchema.fields()){
//     			//	 System.out.println(names);
//     			 //}
//     			 data.fields().addAll(curSchema.fields());
//     		 }
//     	  }  	  
//       }
//       p = new ProjectPlan(p, data.fields());
//       
//       return p;
//   }
   
   public Plan createPlan(QueryData data, Transaction tx) {
	      //Step 1: Create a plan for each mentioned table or view
	      //System.out.println("Create Plan initially");
	      List<Plan> plans = new ArrayList<Plan>();
	      for (String tblname : data.tables()) {
	         String viewdef = SimpleDB.mdMgr().getViewDef(tblname, tx);
	         if (viewdef != null){
//	       System.out.println(viewdef);
	            plans.add(SimpleDB.planner().createQueryPlan(viewdef, tx));
	         }else
	            plans.add(new TablePlan(tblname, tx));
	      }
	      int numtbls = plans.size();

	      //Step 2: Create the product of all table plans
	      Plan p = plans.remove(0);
	      for (Plan nextplan : plans)
	         p = new ProductPlan(p, nextplan);

	      //Step 3: Add a selection plan for the predicate
	      p = new SelectPlan(p, data.pred());
	      //System.out.println("pred size "+data.pred().getSize());
	      //Step 4: groupby
//	      GroupByPlan(Plan p, Collection<String> group, int numbtbls)
	      p = new GroupByPlan(p, data.groupby(), numtbls);
	      //ProjectPlan(Plan p, Collection<String> fieldlist, HashMap<String, Aggregate> aggr)
	       Iterator<String> it = data.fields().iterator();
	       if( data.fields().size() == 1){
	     	  String hold = it.next();
	     	  if(hold.equals("*")){
	     		 it.remove();
	     		 for(String tblname : data.tables()){
	     			 TableInfo curr =SimpleDB.mdMgr().getTableInfo(tblname, tx);
	     			 Schema curSchema = curr.schema();
	     			 data.fields().addAll(curSchema.fields());
	     		 }
	     	  }
//	     	  else if(hold.equals("count(*)")) {
//	     		 it.remove();
//	     		 for(String tblname : data.tables()){
//	     			 TableInfo curr =SimpleDB.mdMgr().getTableInfo(tblname, tx);
//	     			 Schema curSchema = curr.schema();
//	     			 data.fields().addAll(curSchema.fields());
//	     		 }
//	     	  }
	       }
	      p = new ProjectPlan(p, data.fields(), data.aggregate());
	      
////	      //get hashmap and recordfile list;
//	      GroupByScan testScan = (GroupByScan) p.open();
//	      Min testSum = new Min("sid");
//	      ArrayList<Constant> key = new ArrayList<Constant>();
//	      while(testScan.next()) {
//	    	  key = testScan.getKey();
//	    	  testSum.addValue(key, testScan);
//	      }
//	      Constant result = testSum.getValue(key);
//	      for(Constant k : key) {
//	    	  System.out.println(k.asJavaVal());
//	      }
//	      System.out.println();
//	      System.out.println(result.asJavaVal());
//	      HashMap<String, Aggregate> aggr = data.aggregate();
//	      for(String field : aggr.keySet()) {
//	    	  Aggregate ag = aggr.get(field);
//	    	  System.out.println(ag.getClass() + ag.field());
//	      }
//	      HashMap<ArrayList<Constant>, ArrayList<ArrayList<RID>>> testHash = testScan.getHash();
//	      //System.out.println(testHash.size());
//	      List<RecordFile> testRFS = testScan.getRFS();
//	      //print the hashmap records;
//	      Collection <String> tempfield = null;
//	      RecordFile tempRF = null;
//	      RID tempRID  =null;
//	      Schema tempSch = null;
//	      //System.out.println("Here");
//	      for(ArrayList<Constant> tempK:testHash.keySet()){
//	    	//System.out.println("1");
//	        ArrayList<ArrayList<RID>> tempValue = testHash.get(tempK);
//	        for(ArrayList<RID> tempRL:tempValue){
//	        	//System.out.println("2");
//	            for(int i=0; i<tempRL.size(); i++){
//	            	//System.out.println("3");
//	                tempRF = testRFS.get(i);
//	                tempSch = tempRF.getSchema();
//	                tempfield = tempSch.fields();
//	                tempRID = tempRL.get(i);
//	                tempRF.moveToRid(tempRID);
//	                for(String tfield: tempfield){
//	                	//System.out.println("4");
//	                    if(tempSch.type(tfield) == INTEGER)
//	                        System.out.print(tempRF.getInt(tfield)+",");
//	                    else
//	                        System.out.print(tempRF.getString(tfield)+",");
//	                }
//	            }
//	            System.out.println();
//
//	        }
//	      }
	      //System.out.println("end");
	      return p;//TODO need to change test studentClient file.
	   }
}
