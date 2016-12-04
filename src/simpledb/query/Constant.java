package simpledb.query;

/**
 * The interface that denotes values stored in the database.
 * @author Edward Sciore
 */
public interface Constant extends Comparable<Constant> {
   
   /**
    * Returns the Java object corresponding to this constant.
    * @return the Java value of the constant
    */
   public Object  asJavaVal();
   
   public Object addition(Object obj);
   
   public Object division(Object obj);
}
