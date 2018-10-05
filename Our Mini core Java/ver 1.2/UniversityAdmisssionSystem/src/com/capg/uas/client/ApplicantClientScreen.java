package com.capg.uas.client;

import java.util.List;
import java.util.Scanner;

import com.capg.uas.bean.ProgramScheduled;
import com.capg.uas.exception.UASException;
import com.capg.uas.service.ApplicantServiceImpl;
import com.capg.uas.service.IApplicantService;

public class ApplicantClientScreen {	
	private IApplicantService applicantService;
	
	
	public void ApplicantStart() {
		
		Scanner applicantScan = new Scanner(System.in);
		int applicantChoice = -1;
		applicantService = new ApplicantServiceImpl();
		
		System.out.println("\n\n**************************************************");
		System.out.println("\nOptions for Applicant:");
		System.out.println("\t1. View List of Scheduled Programs\n\t"
				+ "2. Track Application Status");
		System.out.println("\n**************************************************");
		System.out.println("Enter 0 to Exit");
		System.out.println("Enter your choice:");
		applicantChoice = applicantScan.nextInt();
		
		switch (applicantChoice) {
		case 1:
			System.out.println("List of Scheduled Programs are as follows:\n");
			try {
				List<ProgramScheduled> prgsch = applicantService.getAllScheduledPrograms();
			} catch (UASException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case 2:
			System.out.println("Application Status");
			break;
			
		case 0:
			System.out.println("Thank you! Exiting from Application...\n");
			applicantScan.close();
			System.exit(0);
			break;
			
		default:
			System.err.println("You have selected an Invalid option. "
					+ "Please try again\n");
			break;
		}
	}

}
