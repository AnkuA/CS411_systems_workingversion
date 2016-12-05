package simpledb.query;

import java.util.*;

/**
 * The scan class corresponding to the <i>project</i> relational
 * algebra operator.
 * All methods except hasField delegate their work to the
 * underlying scan.
 * @author Edward Sciore
 */
public class ProjectScan implements Scan {
   private Scan s;
   private Collection<String> fieldlist;
   private HashMap<String, Aggregate> aggr;
   private ArrayList<Constant> thold  = null;
   private ArrayList<ArrayList<Constant>> kl = null;
   private int curll = -1;
   
   /**
    * Creates a project scan having the specified
    * underlying scan and field list.
    * @param s the underlying scan
    * @param fieldlist the list of field names
    */
   public ProjectScan(Scan s, Collection<String> fieldlist, HashMap<String, Aggregate> aggr) {
      this.s = s;
      this.fieldlist = fieldlist;
      this.aggr = aggr;
      GroupByScan gbs = (GroupByScan)s;
      if(aggr != null & gbs.hasGroup()) {
    	  kl = gbs.getKL();
    	  gbs.beforeFirst();
    	  while(gbs.next()) {
			  ArrayList<Constant> key = gbs.getKey();
			  for(String field : aggr.keySet()) {
				  aggr.get(field).addValue(key, s);
			  }
    	  }
    	  gbs.beforeFirst();
      }
   }
   
   public void beforeFirst() {
      s.beforeFirst();
   }
   
   public boolean next() {
	  // No Aggregate
	  if(aggr == null){
		  GroupByScan gbs = (GroupByScan)s;
		  ArrayList<Constant> temp = gbs.getKey();
		  // Have Group By
		  if(gbs.hasGroup()){
			  if(this.thold == null){
				  boolean curr = s.next();
				  temp = gbs.getKey();
				  this.thold = temp;
				  temp = null;
				  return curr;
			  }
			  else{
				  boolean curr = true;
				  while(temp == this.thold){
					 curr = s.next();
					 if(curr == true){
						 temp = gbs.getKey();
					 }else{
						 break;
					 }
				  }
				  this.thold = temp;
				  temp = null;
				  return curr;
			  }
		  }
		  // No Group By
		  else{
			  return s.next();
		  }
	  }
	  // Have Aggregate
	  else {
		  GroupByScan gbs = (GroupByScan)s;
		  // Have Group By
		  if(gbs.hasGroup()) {
			  if(curll< kl.size() - 1){
				  //this.thold = kl.get(curll);
				  curll+=1;
				  return true;
				  
			  }else{
				  return false;
			  }
		  }
		  // No Group By
		  else {
			  ArrayList<Constant> noGroup = new ArrayList<Constant>();
			  while(s.next()) {
				  for(String field : aggr.keySet()) {
					  aggr.get(field).addValue(noGroup, s);
				  }
			  }
			  return false;
		  }
	  }
   }
   
   public void close() {
      s.close();
   }
   
   public Constant getVal(String fldname) {
	   // No Aggregate
	   if(aggr == null) {
	      if (hasField(fldname))
	          return s.getVal(fldname);
	       else
	          throw new RuntimeException("field " + fldname + " not found.");
	   }
	   // Have Aggregate
	   else {
		   GroupByScan gbs = (GroupByScan)s;
		   // Have Group By
		   if(gbs.hasGroup()) {
			   if(aggr.containsKey(fldname)) {
				   return aggr.get(fldname).getValue(kl.get(curll));
			   }

			   else
				   return kl.get(curll).get(gbs.getGroup(fldname));
		   }
		   // No Group By
		   else {
			   ArrayList<Constant> noGroup = new ArrayList<Constant>();
			   if(aggr.containsKey(fldname)) {
				   return aggr.get(fldname).getValue(noGroup);
			   }
			   else
				   throw new RuntimeException("field " + fldname + " not found.");
			   
		   }
	   }
   }
   
   public int getInt(String fldname) {
	   // No Aggregate
	   if(aggr == null) {
	      if (hasField(fldname))
	          return s.getInt(fldname);
	       else
	          throw new RuntimeException("field " + fldname + " not found.");
	   }
	   // Have Aggregate
	   else {
		   GroupByScan gbs = (GroupByScan)s;
		   // Have Group By
		   if(gbs.hasGroup()) {
			   if(aggr.containsKey(fldname)) {
				   IntConstant ic = (IntConstant)aggr.get(fldname).getValue(kl.get(curll));
				   return (Integer)ic.asJavaVal();
			   }
			   else {
				   IntConstant ic = (IntConstant)kl.get(curll).get(gbs.getGroup(fldname));
				   return (Integer)ic.asJavaVal();
			   } 
		   }
		   // No Group By
		   else {
			   ArrayList<Constant> noGroup = new ArrayList<Constant>();
			   if(aggr.containsKey(fldname)) {
				   IntConstant ic = (IntConstant)aggr.get(fldname).getValue(noGroup);
				   return (Integer)ic.asJavaVal();
			   }
			   else
				   throw new RuntimeException("field " + fldname + " not found.");
		   }
	   }

   }
   
   public String getString(String fldname) {
	   // No Aggregate
	   if(aggr == null) {
			System.out.println("fdname: " + fldname);
	      if (hasField(fldname))
	          return s.getString(fldname);
	       else
	          throw new RuntimeException("field " + fldname + " not found.");
	   }
	   // Have Aggregate
	   else {
		   GroupByScan gbs = (GroupByScan)s;
		   // Have Group By
		   if(gbs.hasGroup()) {
			   if(aggr.containsKey(fldname)) {
				   StringConstant sc = (StringConstant)aggr.get(fldname).getValue(kl.get(curll));
				   return (String)sc.asJavaVal();
			   }
			   else {
				   StringConstant sc = (StringConstant)kl.get(curll).get(gbs.getGroup(fldname));
				   return (String)sc.asJavaVal();
			   }
		   }
		   // No Group By
		   else {
			   ArrayList<Constant> noGroup = new ArrayList<Constant>();
			   if(aggr.containsKey(fldname)) {
				   StringConstant ic = (StringConstant)aggr.get(fldname).getValue(noGroup);
				   return (String)ic.asJavaVal();
			   }
			   else
				   throw new RuntimeException("field " + fldname + " not found.");
			   
		   }
	   }

   }
   
   /**
    * Returns true if the specified field
    * is in the projection list.
    * @see simpledb.query.Scan#hasField(java.lang.String)
    */
   public boolean hasField(String fldname) {
      return fieldlist.contains(fldname);
   }
}
