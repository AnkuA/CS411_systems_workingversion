package simpledb.query;

import java.util.Collection;

import simpledb.record.Schema;

public class GroupByPlan implements Plan {
    private Plan p;
    private Collection<String> group;
    private int nbtbls;

	public GroupByPlan(Plan p, Collection<String> group, int numbtbls) {
		this.p = p;
		this.group = group;
		this.nbtbls = numbtbls;
	}

	public Scan open() {
		Scan s = p.open();
		return new GroupByScan(s, group, nbtbls);
	}

	public int blocksAccessed() {
		return p.blocksAccessed();
	}
	
	// For now
	public int recordsOutput() {
		int combination = 1;
		for(String field : group) {
			combination *= distinctValues(field);
		}
		return combination;
	}

	public int distinctValues(String fldname) {
		return p.distinctValues(fldname);
	}

	public Schema schema() {
		return p.schema();
	}

}
