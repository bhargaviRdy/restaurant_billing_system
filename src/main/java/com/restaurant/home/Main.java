package com.restaurant.home;

import java.util.Scanner;

import com.restaurant.admin.Admin;
import com.restaurant.user.User;

public class Main{
	public static void main(String args[]) throws Exception{
		System.out.println("Welcome to Surabhi Restaurant !!");
		System.out.println("We are glab you are back :)");
		System.out.println("Choose one of the following option to continue"+"\n"+
		"1. As User"+"\n"+"2. As Admin");
		
		Scanner scanner = new Scanner(System.in);
		
//		while(true) {/
			int input = scanner.nextInt();
			switch(input) {
				case 1:
					
					User user = new User();
					Thread userThread = new Thread(user);
					synchronized(userThread) {
						userThread.start();
						userThread.interrupt();
					}
					break;
				case 2 : 
					Admin admin = new Admin();
					Thread adminThread = new Thread(admin);
					synchronized(adminThread) {
						adminThread.start();
						adminThread.interrupt();
					}
					break;
			}
//			input = scanner.nextInt();
//		}
	}
}