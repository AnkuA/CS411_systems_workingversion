package simpledb.query;

import java.util.ArrayList;
import java.util.HashMap;

public class Count implements Aggregate {
	private String field;
	private HashMap<ArrayList<Constant>, Integer> data;

	public Count(String field) {
		this.field = field;
		this.data = new HashMap<ArrayList<Constant>, Integer>();
	}

	public void addValue(ArrayList<Constant> groupValue, Scan currentScan) {
		Object new_val = null;
		if(field.equals("*")) {
			new_val = "*";
		}
		else {
			new_val = currentScan.getVal(field);
		}
		
		if(data.containsKey(groupValue)) {
			Integer old_val = data.get(groupValue);
			if(new_val != null)
				data.put(groupValue, old_val + 1);
		}
		else {
			if(new_val != null)
				data.put(groupValue, 1);
			else 
				data.put(groupValue, 0);
		}
	}

	public Constant getValue(ArrayList<Constant> groupValue) {
		return new IntConstant(data.get(groupValue));
	}
	
	public String field() {
		// TODO Auto-generated method stub
		return field;
	}

}
