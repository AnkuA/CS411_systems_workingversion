package studentClient.simpledb;

import simpledb.tx.Transaction;
import simpledb.query.*;
import simpledb.server.SimpleDB;

/* This is a version of the StudentMajor program that
 * accesses the SimpleDB classes directly (instead of
 * connecting to it as a JDBC client).  You can run it
 * without having the server also run.
 * 
 * These kind of programs are useful for debugging
 * your changes to the SimpleDB source code.
 */

public class StudentMajorNoServer {
	public static void main(String[] args) {
		try {
			// analogous to the driver
			SimpleDB.init("MP7");
			
			// analogous to the connection
			Transaction tx = new Transaction();
			
			// analogous to the statement
			String qry = "select sname from STUDENT;";//where majorid = 10 or majorid = 20
//		        + "from DEPT, STUDENT "
//		        + "where MajorId = DId";	
			Plan p = SimpleDB.planner().createQueryPlan(qry, tx);
			
			// analogous to the result set
			Scan s = p.open();
		
			System.out.println("Here");
			while (s.next()) {
				System.out.println("Name\tMajor");
				//String sname = s.getString("sname"); //SimpleDB stores field names
//				int dname = s.getVal("gradyear"); //in lower case
//				int name = s.getInt("majorid");
				//System.out.println(sname + "\t" + dname);
				System.out.println(s.getVal("sname").asJavaVal());
			}
//			int dname = s.getInt("gradyear"); //in lower case
//			int name = s.getInt("majorid");
//			System.out.println(dname+" "+ name);
			s.close();
			tx.commit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
