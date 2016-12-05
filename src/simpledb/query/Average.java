package simpledb.query;

import java.util.ArrayList;
import java.util.HashMap;

public class Average implements Aggregate {
	private String field;
	private HashMap<ArrayList<Constant>, Constant> data;
	private HashMap<ArrayList<Constant>, Integer> count;

	public Average(String field) {
		this.field = field;
		this.data = new HashMap<ArrayList<Constant>, Constant>();
		this.count = new HashMap<ArrayList<Constant>, Integer>();
	}

	@Override
	public void addValue(ArrayList<Constant> groupValue, Scan currentScan) {
		Constant new_val = currentScan.getVal(field);
		if(new_val.getClass().getName() == "simpledb.query.StringConstant")
			throw new IllegalAggregationException("String Inside Average");
		if(data.containsKey(groupValue)) {
			Constant old_val = data.get(groupValue);
			Integer old_count = count.get(groupValue);
			if(new_val != null) {
				data.put(groupValue, (Constant)old_val.addition(new_val));
				count.put(groupValue, old_count + 1);
			}
		}
		else {
			if(new_val != null) {
				data.put(groupValue, new_val);
				count.put(groupValue, 1);
			}
		}

	}

	public Constant getValue(ArrayList<Constant> groupValue) {
		return (Constant)data.get(groupValue).division(count.get(groupValue));
	}

	public String field() {
		// TODO Auto-generated method stub
		return field;
	}

}
