package studentClient.simpledb;

import java.sql.*;
import static java.sql.Types.*;
import java.util.*;
import simpledb.remote.SimpleDriver;

public class GenericSQL {
    public static void main(String[] args) {
		//for(int i=0; i<args.length; i++) {
		//	System.out.println(i + ": " + args[i]);
		//}

		//if(args.length == 0) {
		//	return;
		//}

		Connection conn = null;
		Scanner sc = new Scanner(System.in);
		try {
			while(true) {
				System.out.print("> ");
				String input = sc.nextLine();

				if(input.length() == 0) {
					continue;
				}

				if(input.equals("quit")) {
					break;
				}
				// Step 1: connect to database server
				Driver d = new SimpleDriver();
				conn = d.connect("jdbc:simpledb://localhost", null);

				// Step 2: execute the query
				Statement stmt = conn.createStatement();
				String qry = input;
				ResultSet rs = stmt.executeQuery(qry);
				ResultSetMetaData md = rs.getMetaData();
				List<String> fields = new ArrayList<String>();
				List<Integer> types = new ArrayList<Integer>();

				for(int i=0; i<md.getColumnCount(); i++) {
					String field = md.getColumnName(i+1);
					fields.add(field);
					types.add(md.getColumnType(i+1));
					System.out.print(field);
	
					if(i == md.getColumnCount()-1) {
						System.out.print("\n");
					} else {
						System.out.print("\t");
					}
				}

				// Step 3: loop through the result set
				try {
					do {
						for(int i=0; i<md.getColumnCount(); i++) {
							String item = "";
							if(types.get(i) == INTEGER) {
								item = String.valueOf(rs.getInt(fields.get(i)));
							} else {
								item = rs.getString(fields.get(i));
							}
							System.out.print(item);

							if(i == md.getColumnCount()-1) {
								System.out.print("\n");
							} else {
								System.out.print("\t");
							}
						}
					} while (rs.next());
				} catch(Exception e) {
					e.printStackTrace();
				}
				rs.close();
			}
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
