package simpledb.query;

import java.util.ArrayList;
import java.util.HashMap;

public class Max implements Aggregate {
	private String field;
	private HashMap<ArrayList<Constant>, Constant> data;

	public Max(String field) {
		this.field = field;
		this.data = new HashMap<ArrayList<Constant>, Constant>();
	}


	public void addValue(ArrayList<Constant> groupValue, Scan currentScan) {
		Constant new_val = currentScan.getVal(field);
		if(new_val.getClass().getName() == "simpledb.query.StringConstant")
			throw new IllegalAggregationException("String Inside Max");
		if(data.containsKey(groupValue)) {
			Constant old_val = data.get(groupValue);
			if(old_val.compareTo(new_val) < 0)
				data.put(groupValue, new_val);
		}
		else {
			data.put(groupValue, new_val);
		}
	}

	public Constant getValue(ArrayList<Constant> groupValue) {
		return data.get(groupValue);
	}
	
	public String field() {
		// TODO Auto-generated method stub
		return field;
	}

}
