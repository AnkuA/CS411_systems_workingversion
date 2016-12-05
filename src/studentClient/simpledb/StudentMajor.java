package studentClient.simpledb;

import java.sql.*;
import simpledb.remote.SimpleDriver;

public class StudentMajor {
    public static void main(String[] args) {
		Connection conn = null;
		try {
			// Step 1: connect to database server
			Driver d = new SimpleDriver();
			conn = d.connect("jdbc:simpledb://localhost", null);

			// Step 2: execute the query
			Statement stmt = conn.createStatement();
			String qry = "SELECT SNAME, DNAME, majorid "
			           + "FROM DEPT, STUDENT "
			           + "WHERE MAJORID = DID and majorid <= 20;";
			ResultSet rs = stmt.executeQuery(qry);

			// Step 3: loop through the result set
			System.out.println("Name\tMajor");
			while (rs.next()) {
				String sname = rs.getString("sname");
				String dname = rs.getString("dname");
				int majorid = rs.getInt("majorid");
				System.out.println(sname + "\t" +dname + "\t" + majorid);
			}
			rs.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			// Step 4: close the connection
			try {
				if (conn != null)
					conn.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
