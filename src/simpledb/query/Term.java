package simpledb.query;

import simpledb.record.Schema;

/**
 * A term is a comparison between two expressions.
 * @author Edward Sciore
 *
 */

public class Term {
	//AA: added Comparator enum types declarations
	public static enum Comptype{
	     NOTEQUAL, GREATER, LESS, GREATEREQL, LESSEQL, EQUALS, INVALID
	};
	//AA: added name for enum
   //private Comptype compare;
	private Comptype compare;
   /** comparators
    * **/
   
   
	   
   private Expression lhs, rhs;
   
   /**
    * Creates a new term that compares two expressions
    * for equality.
    * @param lhs  the LHS expression
    * @param rhs  the RHS expression
    */
   //AA: added String compstr variable that is checked for what comparator it denotes
   public Term(Expression lhs, String compstr, Expression rhs) {
      this.compare = Term.stringToComparator(compstr);

      if(this.compare == Comptype.INVALID) {
         this.compare = Comptype.EQUALS;
      }
      /**
       * AA: previous code**/
      this.lhs = lhs;
      this.rhs = rhs;
   }

   public static Comptype stringToComparator(String compstr) {
      switch(compstr){
         case "!=":
        	 return Comptype.NOTEQUAL;
         case "=":
        	 return Comptype.EQUALS;                  
         case ">":
        	 return Comptype.GREATER;
         case "<":
        	 return Comptype.LESS;
         case ">=":
        	 return Comptype.GREATEREQL;
         case "<=":
        	 return Comptype.LESSEQL;        	 
      }
      return Comptype.INVALID;
   }
   
   /**
    * Calculates the extent to which selecting on the term reduces 
    * the number of records output by a query.
    * For example if the reduction factor is 2, then the
    * term cuts the size of the output in half.
    * @param p the query's plan
    * @return the integer reduction factor.
    */
   public int reductionFactor(Plan p) {
      String lhsName, rhsName;
      if (lhs.isFieldName() && rhs.isFieldName()) {
         lhsName = lhs.asFieldName();
         rhsName = rhs.asFieldName();
         return Math.max(p.distinctValues(lhsName),
                         p.distinctValues(rhsName));
      }
      if (lhs.isFieldName()) {
         lhsName = lhs.asFieldName();
         return p.distinctValues(lhsName);
      }
      if (rhs.isFieldName()) {
         rhsName = rhs.asFieldName();
         return p.distinctValues(rhsName);
      }
      // otherwise, the term equates constants
      if (lhs.asConstant().equals(rhs.asConstant()))
         return 1;
      else
         return Integer.MAX_VALUE;
   }
   
   /**
    * Determines if this term is of the form "F=c"
    * where F is the specified field and c is some constant.
    * If so, the method returns that constant.
    * If not, the method returns null.
    * @param fldname the name of the field
    * @return either the constant or null
    */
   public Constant equatesWithConstant(String fldname) {
	   //AA: check if case first
	  if (compare!=Comptype.EQUALS){
		  return null;				  
	  }
	  //AA: upto here
      if (lhs.isFieldName() &&
          lhs.asFieldName().equals(fldname) &&
          rhs.isConstant())
         return rhs.asConstant();
      else if (rhs.isFieldName() &&
               rhs.asFieldName().equals(fldname) &&
               lhs.isConstant())
         return lhs.asConstant();
      else
         return null;
   }
   
   /**
    * Determines if this term is of the form "F1=F2"
    * where F1 is the specified field and F2 is another field.
    * If so, the method returns the name of that field.
    * If not, the method returns null.
    * @param fldname the name of the field
    * @return either the name of the other field, or null
    */
   public String equatesWithField(String fldname) {
	   //AA: check if case first
	  if (compare!=Comptype.EQUALS){
		  return null;				  
	  }
	  //AA: upto here
      if (lhs.isFieldName() &&
          lhs.asFieldName().equals(fldname) &&
          rhs.isFieldName())
         return rhs.asFieldName();
      else if (rhs.isFieldName() &&
               rhs.asFieldName().equals(fldname) &&
               lhs.isFieldName())
         return lhs.asFieldName();
      else
         return null;
   }
   
   /**
    * Returns true if both of the term's expressions
    * apply to the specified schema.
    * @param sch the schema
    * @return true if both expressions apply to the schema
    */
   public boolean appliesTo(Schema sch) {
      return lhs.appliesTo(sch) && rhs.appliesTo(sch);
   }
   
   /**
    * Returns true if both of the term's expressions
    * evaluate to the same constant,
    * with respect to the specified scan.
    * @param s the scan
    * @return true if both expressions have the same value in the scan
    */
   public boolean isSatisfied(Scan s) {
      Constant lhsval = lhs.evaluate(s);
      Constant rhsval = rhs.evaluate(s);
      switch(compare){
         case EQUALS:
            return rhsval.equals(lhsval);
         case NOTEQUAL:
        	 return !rhsval.equals(lhsval);
	     case GREATER:
		    return lhsval.compareTo(rhsval)==1;
	     case LESS:
	    	 return lhsval.compareTo(rhsval)==-1;
	     case GREATEREQL:
	    	 return lhsval.compareTo(rhsval)>=0;
	     case LESSEQL:
	    	 return lhsval.compareTo(rhsval)<=0;
	     default:
	    	 return false;
	  }
       
   }
   
   public String toString() {
	   //AA: check if case first and assign accordingly
	  switch(compare){
	     case EQUALS:
		    return lhs.toString() + "=" + rhs.toString();
	     case NOTEQUAL:
			return lhs.toString() + "!=" + rhs.toString();
	     case GREATER:
			return lhs.toString() + ">" + rhs.toString();
	     case LESS:
			return lhs.toString() + "<" + rhs.toString();
	     case GREATEREQL:
			return lhs.toString() + ">=" + rhs.toString();
	     case LESSEQL:
		    return lhs.toString() + "<=" + rhs.toString();
	     default:
	    	return lhs.toString() + "=" + rhs.toString();
	  }
   }
}
