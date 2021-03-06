package simpledb.query;

/**
 * The class that wraps Java floats as database constants.
 * @author Edward Sciore
 */
public class FloatConstant implements Constant {
   private Float val;
   
   /**
    * Create a constant by wrapping the specified float.
    * @param n the float value
    */
   public FloatConstant(float n) {
      val = new Float(n);
   }
   
   /**
    * Unwraps the Float and returns it.
    * @see simpledb.query.Constant#asJavaVal()
    */
   public Object asJavaVal() {
      return val;
   }
   
   public boolean equals(Object obj) {
      FloatConstant ic = (FloatConstant) obj;
      return ic != null && val.equals(ic.val);
   }
   
   public int compareTo(Constant c) {
      FloatConstant ic = (FloatConstant) c;
      return val.compareTo(ic.val);
   }
   
   public int hashCode() {
      return val.hashCode();
   }
   
   public String toString() {
      return val.toString();
   }


   public Object addition(Object obj) {
	  FloatConstant oc = (FloatConstant)obj;
	  return new FloatConstant(val + oc.val);
   }

	public Object division(Object obj) {
		Integer oint = (Integer)obj;
		return new FloatConstant(val / oint);
	}
}
