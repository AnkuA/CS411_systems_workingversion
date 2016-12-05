package simpledb.query;

import simpledb.record.Schema;
import java.util.*;
/**
 * A predicate is a Boolean combination of terms.
 * @author Edward Sciore
 *
 */
public class JoinedPredicate extends Predicate {
	//private List<Term> terms = new ArrayList<Term>();
	private Predicate pred1;
	private Predicate pred2;
	private boolean isconj = false;
	private boolean isinv = false;
	/**
	 * Creates an empty predicate, corresponding to "true".
	 */
	public JoinedPredicate(Predicate p1) {
		this.pred1 = p1;
		this.pred2 = null;
	}

	public JoinedPredicate(Predicate p1, Predicate p2, boolean andOp, boolean notOp) {
		this.pred1 = p1;
		this.pred2 = p2;
		this.isconj = andOp;
		this.isinv = notOp;
	}
	/**
	 * Creates a predicate containing a single term.
	 * @param t the term
	 */
	public void setIsconj(boolean inconj){
		isconj = inconj;
	}
	public void setIsinv(boolean inv){
		isinv = inv;
	}
	/**
	 * Modifies the predicate to be the conjunction of
	 * itself and the specified predicate.
	 * @param pred the other predicate
	 */
	public void conjoinWith(Predicate pred) {
		System.out.println("ConjoinWith called - undefined behaviour");

		if(this.pred2 == null) {
			this.pred2 = pred;
		} else {
			this.pred2 = new JoinedPredicate(this.pred2, pred, this.isconj, this.isinv);
		}
	}
	
	/**
	 * Returns true if the predicate evaluates to true
	 * with respect to the specified scan.
	 * @param s the scan
	 * @return true if the predicate is true in the scan
	 */
	public boolean isSatisfied(Scan s) {
		boolean result;
		if(pred1.isSatisfied(s)) {
			if(isconj) {
				result = pred2.isSatisfied(s);
			} else {
				result = true;
			}
		} else {
			if(isconj) {
				result =  false;
			} else {
				result = pred2.isSatisfied(s);
			}
		}

		if(isinv) {
			return !result;
		}
		return result;
	}/*


//		for (Term t : terms)
//			if (!t.isSatisfied(s))
//			return false;
//		return true;
		if (isconj == true){
		  for (Term t : terms){
			  //System.out.println(t.toString());
			  if (!t.isSatisfied(s))
				  return false;
		  }
		  return true;
	  }else{
		  for(Term t: terms){
			 // System.out.println(t.toString());
			  if(t.isSatisfied(s))
				  return true;
		  }
		  return false;  
	  }
	}(/
	
	/** 
	 * Calculates the extent to which selecting on the predicate 
	 * reduces the number of records output by a query.
	 * For example if the reduction factor is 2, then the
	 * predicate cuts the size of the output in half.
	 * @param p the query's plan
	 * @return the integer reduction factor.
	 */ 
	public int reductionFactor(Plan p) {
		return pred1.reductionFactor(p) * pred2.reductionFactor(p);
		//int factor = 1;
		//for (Term t : terms)
		//	factor *= t.reductionFactor(p);
		//return factor;
	}
	
	/**
	 * Returns the subpredicate that applies to the specified schema.
	 * @param sch the schema
	 * @return the subpredicate applying to the schema
	 */
	public Predicate selectPred(Schema sch) {
		Predicate subp1 = pred1.selectPred(sch);
		Predicate subp2 = pred2.selectPred(sch);
		return new JoinedPredicate(subp1, subp2, isconj, isinv);
		//Predicate result = new Predicate();
		//for (Term t : terms)
		//	if (t.appliesTo(sch))
		//	result.terms.add(t);
		//if (result.terms.size() == 0)
		//	return null;
		//else
		//	return result;
	}
	
	/**
	 * Returns the subpredicate consisting of terms that apply
	 * to the union of the two specified schemas, 
	 * but not to either schema separately.
	 * @param sch1 the first schema
	 * @param sch2 the second schema
	 * @return the subpredicate whose terms apply to the union of the two schemas but not either schema separately.
	 */
	public Predicate joinPred(Schema sch1, Schema sch2) {
		Predicate subp1 = pred1.joinPred(sch1, sch2);
		Predicate subp2 = pred2.joinPred(sch1, sch2);
		return new JoinedPredicate(subp1, subp2, isconj, isinv);
		//Predicate result = new Predicate();
		//Schema newsch = new Schema();
		//newsch.addAll(sch1);
		//newsch.addAll(sch2);
		//for (Term t : terms)
		//	if (!t.appliesTo(sch1)  &&
		//		 !t.appliesTo(sch2) &&
		//		 t.appliesTo(newsch))
		//	result.terms.add(t);
		//if (result.terms.size() == 0)
		//	return null;
		//else
		//	return result;
	}
	
	/**
	 * Determines if there is a term of the form "F=c"
	 * where F is the specified field and c is some constant.
	 * If so, the method returns that constant.
	 * If not, the method returns null.
	 * @param fldname the name of the field
	 * @return either the constant or null
	 */
	public Constant equatesWithConstant(String fldname) {
		Constant c = pred1.equatesWithConstant(fldname);

		if(c == null) {
			c = pred2.equatesWithConstant(fldname);
		}
		return c;
		//for (Term t : terms) {
		//	Constant c = t.equatesWithConstant(fldname);
		//	if (c != null)
		//		return c;
		//}
		//return null;
	}
	
	/**
	 * Determines if there is a term of the form "F1=F2"
	 * where F1 is the specified field and F2 is another field.
	 * If so, the method returns the name of that field.
	 * If not, the method returns null.
	 * @param fldname the name of the field
	 * @return the name of the other field, or null
	 */
	public String equatesWithField(String fldname) {
		String c = pred1.equatesWithField(fldname);

		if(c == null) {
			c = pred2.equatesWithField(fldname);
		}
		return c;
		//for (Term t : terms) {
		//	String s = t.equatesWithField(fldname);
		//	if (s != null)
		//		return s;
		//}
		//return null;
	}
	
	public String toString() {
		String result1 = pred1.toString();
		String result2 = pred2.toString();
		String joiner = isconj? ") and (":") or (";
		return (isinv?"not " : "") + "(" + result1 + joiner + result2 + ")";
		//Iterator<Term> iter = terms.iterator();
		//if (!iter.hasNext()) 
		//	return "";
		//String result = iter.next().toString();
		//while (iter.hasNext())
		//	result += (isconj?" and ":" or") + iter.next().toString();
		//return result;
	}
}
