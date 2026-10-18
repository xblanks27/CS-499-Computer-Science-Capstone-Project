package com.capstone.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SqlConnect {
	
	// connects the application to the SQL database local host
	public void connect() {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orc1", "login1", "pwd1");
		
		if (con != null) {
			System.out.println("Connected");
		}
		else {
			System.out.println("Not Connected");
		}
		con.close();
	}
	catch(Exception e) {
		System.out.print(e);
	}

	}
	
	// SQL insert command to add items to the database
	public void insert(String user, String password) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin@localhost:1521:orc1");
			Statement stmt = con.createStatement();
			
			String insert = "insert into user values('" + user + "','" + password + "',)'";
			
			int x = stmt.executeUpdate(insert);
			if (x > 0) {
				System.out.println("Successfully Inserted");
			}
			else {
				System.out.println("Insert Failed");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	// SQL select command to find items in the database
	public void select(String user, String password) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin@localhost:1521:orc1");
			Statement stmt = con.createStatement();
			
			String output = "select * from user WHERE user = '" + user + "' AND password = '" + password + "'";
			ResultSet rs = stmt.executeQuery(output);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
