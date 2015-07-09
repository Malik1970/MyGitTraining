/**
 * 
 */
package com.nlsinc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.sql.XAConnection;
import javax.sql.XADataSource;

import oracle.jdbc.pool.OracleDataSource;

/**
 * @author Jagadesh Babu Munta
 *
 */
public class JDBCStandalone {

	//static Logger log = Logger.
	static final String DB_USER="jagadesh";
	static final String DB_PASS="jagadesh123";
	/**
	 * @param args
	 * @throws  
	 */
	public static void main(String[] args) {
		
		/*
		 * Loading of drivers - 3 ways as below 1.1, 1.2, 1.3 and need if non datasource approach is used.
		 * 
		 * 1.1 Register the driver approach
		 * 
		 * NOTE: Uncomment the below lines if you use other approaches
		 */
		/*System.out.println("Registering the driver with driver manager..."); 
		try {
			DriverManager.registerDriver (new oracle.jdbc.OracleDriver());
		} catch (SQLException e) {			
			e.printStackTrace();
			return;
		}*/

		
		/*
		 *  1.2 Load the driver class
		 *  
		 * NOTE: Uncomment the below lines if you use other approaches
		 */
		
		/*System.out.println("Loading the driver class using Class.forName()..."); 
		try {
			Class.forName ("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
			return;
		}*/

		
		/*
		 * 1.3
		 * NOTE: Supply the below system property while running the java program for loading the driver
		 * 
		 *  java -Djdbc.drivers = oracle.jdbc.OracleDriver <ClassName>;
		 */

		/*
		 * 
		 *  2. Get DB connection
		 *  
		 *  3 ways to do. As below 2.1, 2.2, 2.3
		 */
		Connection conn = null;

		/*
		 * 2.1 Driver manager approach
		 * 
		 * NOTE: Uncomment below if you would like to use this approach.
		 * 
		 */
		/*System.out.println("Using DriverManager for DB connection..."); 
		// Using Driver Manager
		try {
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",DB_USER,DB_PASS);
		} catch (SQLException e) {			
			e.printStackTrace();
		}*/
		
		/*
		 * 2.2. Using Oracle Data Source
		 * NOTE: Uncomment below if you would like to use this approach. 
		 */
		
		/*System.out.println("Using OracleDataSource for DB connection..."); 
		OracleDataSource ods = null;
		try {
			ods = new OracleDataSource();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		ods.setURL("jdbc:oracle:thin:jagadesh/jagadesh123@localhost:1521:xe");
		try {
			conn = ods.getConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}*/
		
		Context ctx = null;
		DataSource ds = null;
		
		/*
		 * 2.3. Using Data Source from WebLogic application server
		 * NOTE: please comment/uncomment if needed. 
		 * 
		 */
		System.out.println("Using Middleware Data Source...");
		try {
			Properties props = new Properties();
			props.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
			props.put(Context.PROVIDER_URL,"t3://localhost:7001");

			ctx = new InitialContext(props);		
			
			// Get the data source
			//ds = (DataSource) ctx.lookup("jdbc/employeedb");
			ds = (DataSource) ctx.lookup("jdbc/testempdb");//"jdbc/myfirstjdbcdb");
					
			// Get the connection
			conn = ds.getConnection();
		} catch (NamingException e2) {			
			e2.printStackTrace();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		
		if (conn==null) {
			System.out.println("ERROR: No DB connection obtained!");
			return;
		}
		
		/*
		 * 3. Create Statement
		 */
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//4. ResultSet
		ResultSet rs = null;
		try {
			rs  = stmt.executeQuery("SELECT * FROM EMPLOYEE");
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		String name = null;
		int age = 0;
		try {
			while (rs.next()) {
				name = rs.getString("name");
				age = rs.getInt("age");
				System.out.println("Employee Name:"+name+";age="+age);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		// Update
		PreparedStatement pstmt = null;
		try {
			 conn.setAutoCommit(false);
			 pstmt = conn.prepareStatement(
					"UPDATE employee SET name=? WHERE name like ?");	
			 
			 pstmt.setString(1, "New Employee1");
			 pstmt.setString(2, "%Employee1");
			 int count = pstmt.executeUpdate();
			 conn.commit();
			 System.out.println(count+ " rows updated.");
		} catch (SQLException e1) {
			try {
				System.out.println("Rolling back the changes...");
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			e1.printStackTrace();
		} finally {
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		
		
		// 5. Close resources
		try {
			if (rs!=null) { rs.close(); }
			if (stmt!=null) { stmt.close(); }
			if (conn!=null) {conn.close(); }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
