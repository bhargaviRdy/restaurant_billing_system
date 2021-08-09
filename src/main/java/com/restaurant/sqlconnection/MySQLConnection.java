package com.restaurant.sqlconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySQLConnection {
	private static MySQLConnection single_connection =null;
	public Connection connection;
	
	// Singleton factory pattern
	// only one connection has to be present to connect to database
	private MySQLConnection() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","Bavi9932;");
	}
	static public MySQLConnection getConnection() throws Exception {
		if(single_connection == null) {
			single_connection = new MySQLConnection();
		}
		return single_connection;
		
	}
}
