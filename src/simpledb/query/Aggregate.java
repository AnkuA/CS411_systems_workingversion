package simpledb.query;

import java.util.ArrayList;

public interface Aggregate {
	
	public void addValue(ArrayList<Constant> groupValue, Scan currentScan);
	
	public Constant getValue(ArrayList<Constant> groupValue);
	
	public String field();
}
