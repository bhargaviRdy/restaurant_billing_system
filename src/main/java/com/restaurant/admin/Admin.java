package com.restaurant.admin;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.restaurant.sqlconnection.MySQLConnection;

public class Admin implements Runnable{
	
	String name;
	String password;
	MySQLConnection connection;
	Statement statement;
	Scanner scanner;
	
	public Admin() throws Exception{
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
		return;
	}
	public void login() throws Exception {
		
		System.out.println("Please enter name:  ");
		this.name = scanner.nextLine();

		System.out.println("Please enter password:  ");
		this.password = scanner.nextLine();
		
		String str = "select * from admin where name = '"+this.name+"' && password = '"+this.password+"'";
		ResultSet rset = statement.executeQuery(str);
		int rowCount = 0;
		while (rset.next()) {
			rowCount++;
			
		}
		if(rowCount != 0) {
			System.out.println("logged in successfully!!");
		}
		else {
			System.out.println("Öops!! Username or password is incorrect!, Please enter the details again");
			login();
		}
		System.out.println("Choose any option: ");
		System.out.println("1. Show the total sale of this month");
		System.out.println("2. Show the bills for today");
		System.out.println("0. To Logout");
		int choose = scanner.nextInt();
		while(choose!=0) {
			switch(choose) {
			case 1: totalSale();
				break;
			case 2: billsToday();
				break;
			case 0:
				return;
			}
			System.out.println("Choose any option: ");
			System.out.println("1. Show the total sale of this month");
			System.out.println("2. Show the bills for today");
			System.out.println("0. To Logout");
			choose = scanner.nextInt();
		}
	}
	
	public void billsToday() throws SQLException {
		System.out.println("Today's bills: ");
		String str = "select username, item, price from bills where date = curdate()";
		ResultSet resultSet = statement.executeQuery(str);
		ResultSetMetaData rsmd = resultSet.getMetaData();
		int columns = rsmd.getColumnCount();
		while (resultSet.next()) {
		    for (int i = 1; i <= columns; i++) {
		        if (i > 1) System.out.print(",  ");
		        String columnValue = resultSet.getString(i);
		        System.out.print(columnValue);
		        
		    }
		    System.out.println("");
		}
	}
	
	public void totalSale() throws SQLException {
		
		String str = "select sum(price) from bills where monthname(date) = 'August'";
		ResultSet resultSet = statement.executeQuery(str);
		resultSet.next();
		System.out.println("Total Sale for this month is : "+ resultSet.getString(1));
		
	}
	
	public void logout() {
		System.out.println("Thank You! See you soon :)");
		return;
	}
	

}
