package com.capg.uas.client;

import java.util.Scanner;

public class MainClientScreen {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//PropertyConfigurator.configure("res/log4j.properties");
		int choice = -1;

		while (true) {
			System.out.println("\n\n**************************************************");
			System.out.println("Welcome to University Admission System Portal");
			System.out.println("\n**************************************************");
			System.out.println("\nEnter as:");
			System.out.println("\t1. Student/Applicant\n\t"
					+ "2. Member of admission committee\n\t"
					+ "3. Administrator");
			System.out.println("\n**************************************************");
			System.out.println("Enter 0 to Exit");
			System.out.println("Enter your choice:");
			choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Accessing Portal as Student/Applicant...\n");
				break;
			case 2:
				System.out.println("Accessing Portal as "
						+ "Member of admission committee...");
				MacClientScreen mClient = new MacClientScreen();
				mClient.start();
				break;
			case 3:
				System.out.println("Accessing Portal as Administrator...\n");
				break;
			case 0:
				System.out.println("Thank you! Exiting from Application...\n");
				scan.close();
				System.exit(0);
				break;
			default:
				System.err.println("You have selected an Invalid option. "
						+ "Please try again\n");
				break;
			}
		}
	}
}
