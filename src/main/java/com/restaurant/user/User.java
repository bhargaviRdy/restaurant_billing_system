package com.restaurant.user;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;

import com.restaurant.sqlconnection.MySQLConnection;

public class User implements Runnable {
	String name;
	String password;
	MySQLConnection connection;
	Statement statement;
	Scanner scanner;
	
	public User() throws Exception{
		connection = MySQLConnection.getConnection();
		statement = connection.connection.createStatement();
		scanner = new Scanner(System.in);
	}
	
	public void run() {
		try {
			login();
		} catch (Exception e) {
			System.out.println("login failed");
			e.printStackTrace();
		}
	}
	public void login() throws Exception {
		
		
		System.out.println("Please enter name:  ");
		this.name = scanner.nextLine();

		System.out.println("Please enter password:  ");
		this.password = scanner.nextLine();
		
		  String str = "select * from user where name = '"+this.name+"' && password = '"+this.password+"'";
			ResultSet rset = statement.executeQuery(str);
			int rowCount = 0;
			while (rset.next()) {
				rowCount++;
				
			}
			if(rowCount != 0) {
				System.out.println("logged in successfully!!");
				showMenu();
			}
			else {
				System.out.println("Öops!! Username or password is incorrect!, Please enter the details again");
				login();
			}
	}
	
	public void showMenu() throws SQLException {
		
		System.out.println("Enjoy yourself with the list of items we offer along with their prices : ");
		System.out.println("Please select from the below list of items. Enter 0 to stop");
		String str = "select * from menu";
		
		ResultSet resultSet = statement.executeQuery(str);
		
		ResultSetMetaData rsmd = resultSet.getMetaData();
		int columns = rsmd.getColumnCount();
		int count = 1;
		
		HashMap<Integer, Integer> itemprice = new HashMap<Integer, Integer>();
		
		while (resultSet.next()) {
			System.out.print(count++ + ". ");
		    for (int i = 1; i <= columns; i++) {
		        if (i > 1) System.out.print(",  ");
		        String columnValue = resultSet.getString(i);
		        System.out.print(columnValue);
		        
		    }
		    itemprice.put(count-1, Integer.parseInt(resultSet.getString(2)));
		    System.out.println("");
		}
		
		System.out.println("itemprice:  "+itemprice);
		int item = scanner.nextInt();
		int totalcost = 0;
		while(item != 0) {
			totalcost+= itemprice.get(item);
			item = scanner.nextInt();
		}
		
		System.out.println("Your total bill is "+ totalcost+". Please pay the amout at the counter. Thank You");
		
	}
	public void logout() {
		return;
	}

}
