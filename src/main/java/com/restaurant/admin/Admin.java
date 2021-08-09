package com.restaurant.admin;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.restaurant.sqlconnection.MySQLConnection;

public class Admin {
	
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
		int choose = scanner.nextInt();
		switch(choose) {
		case 1: totalSale();
			break;
		case 2: billsToday();
			break;
		}
	}
	
	public void billsToday() {
		
	}
	
	public void totalSale() {
		
	}
	

}
