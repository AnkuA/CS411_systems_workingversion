package simpledb.query;

import simpledb.record.Schema;

public class AggregationPlan implements Plan {
	private Plan p;
	private Schema schema = new Schema();

	public AggregationPlan() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Scan open() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int blocksAccessed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int recordsOutput() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int distinctValues(String fldname) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Schema schema() {
		// TODO Auto-generated method stub
		return null;
	}

}
