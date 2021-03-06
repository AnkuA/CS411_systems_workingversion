package simpledb.query;

import static java.sql.Types.INTEGER;
import static java.sql.Types.FLOAT;
import simpledb.tx.Transaction;
import simpledb.record.*;

/**
 * The Scan class corresponding to a table.
 * A table scan is just a wrapper for a RecordFile object;
 * most methods just delegate to the corresponding
 * RecordFile methods.
 * @author Edward Sciore
 *
 */
public class TableScan implements UpdateScan {
   private RecordFile rf;
   private Schema sch;
   
   /**
    * Creates a new table scan,
    * and opens its corresponding record file. 
    * @param ti the table's metadata
    * @param tx the calling transaction
    */
   public TableScan(TableInfo ti, Transaction tx) {
      rf  = new RecordFile(ti, tx);
      sch = ti.schema();
   }
   
   // Scan methods
   
   public void beforeFirst() {
      rf.beforeFirst();
   }
   
   public boolean next() {
      return rf.next();
   }
   
   public void close() {
      rf.close();
   }
   
   /**
    * Returns the value of the specified field, as a Constant.
    * The schema is examined to determine the field's type.
    * If INTEGER, then the record file's getInt method is called;
    * otherwise, the getString method is called.
    * @see simpledb.query.Scan#getVal(java.lang.String)
    */
   public Constant getVal(String fldname) {
      if (sch.type(fldname) == INTEGER)
         return new IntConstant(rf.getInt(fldname));
      // AA: Added this
      else if (sch.type(fldname) == FLOAT)
          return new FloatConstant(rf.getFloat(fldname));
      else
         return new StringConstant(rf.getString(fldname));
   }
   
   // AA: Added this
   public float getFloat(String fldname) {
	      return rf.getFloat(fldname);
	   }
   
   public int getInt(String fldname) {
      return rf.getInt(fldname);
   }
   
   public String getString(String fldname) {
      return rf.getString(fldname);
   }
   
   public boolean hasField(String fldname) {
      return sch.hasField(fldname);
   }
   
   // UpdateScan methods
   
   /**
    * Sets the value of the specified field, as a Constant.
    * The schema is examined to determine the field's type.
    * If INTEGER, then the record file's setInt method is called;
    * otherwise, the setString method is called.
    * @see simpledb.query.UpdateScan#setVal(java.lang.String, simpledb.query.Constant)
    */ 
   public void setVal(String fldname, Constant val) {
	   
      if (sch.type(fldname) == INTEGER) {
    	  System.out.format("setting field %s to int %s\n", fldname, val.toString());
    	  rf.setInt(fldname, (Integer)val.asJavaVal());
      }
      // AA: Added this
      else if (sch.type(fldname) == FLOAT) {
    	  System.out.format("setting field %s to float %s\n", fldname, val.toString());
    	  rf.setFloat(fldname, (Float)val.asJavaVal());
      }
      else {
    	  System.out.format("setting field %s to str %s\n", fldname, val.toString());
         rf.setString(fldname, (String)val.asJavaVal());
      }
   }
   
   // AA: Added this
   public void setFloat(String fldname, float val) {
      rf.setFloat(fldname, val);
   }
   
   public void setInt(String fldname, int val) {
      rf.setInt(fldname, val);
   }
   
   public void setString(String fldname, String val) {
      rf.setString(fldname, val);
   }
   
   public void delete() {
      rf.delete();
   }
   
   public void insert() {
      rf.insert();
   }
   
   public RID getRid() {
      return rf.currentRid();
   }
   
   public void moveToRid(RID rid) {
      rf.moveToRid(rid);
   }
   
   public RecordFile getRecordFile() {
	   return rf;
   }
}
