package simpledb.query;

import java.util.ArrayList;
import java.util.HashMap;

public class Sum implements Aggregate {
	private String field;
	private HashMap<ArrayList<Constant>, Constant> data;

	public Sum(String field) {
		this.field = field;
		this.data = new HashMap<ArrayList<Constant>, Constant>();
	}

	public void addValue(ArrayList<Constant> groupValue, Scan currentScan) {
		Constant new_val = currentScan.getVal(field);
		if(new_val.getClass().getName() == "simpledb.query.StringConstant")
			throw new IllegalAggregationException("String Inside Sum");
		if(data.containsKey(groupValue)) {
			Constant old_val = data.get(groupValue);
			if(new_val != null) {
				data.put(groupValue, (Constant)old_val.addition(new_val));
			}
		}
		else {
			if(new_val != null)
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
