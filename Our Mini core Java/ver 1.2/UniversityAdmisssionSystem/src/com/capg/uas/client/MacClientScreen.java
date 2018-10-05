package com.capg.uas.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capg.uas.bean.Applicant;
import com.capg.uas.bean.ProgramScheduled;
import com.capg.uas.exception.UASException;
import com.capg.uas.service.IMacService;
import com.capg.uas.service.MacServiceImpl;

public class MacClientScreen {
	static Logger logger=Logger.getRootLogger();
	static int loginAttempts = 0;

	public void start() {
		int choice = -1;

		IMacService macService = new MacServiceImpl();
		Scanner scan = new Scanner(System.in);
		while (choice != 2 && loginAttempts <= 3) {
			System.out.print("[1]Login [2]Quit >");
			choice = scan.nextInt();

			if (choice == 1) {
				System.out.print("Login ID? ");
				String userName = scan.next();
				System.out.print("Password? ");
				String password = scan.next();
				loginAttempts++;
				try {
					if (macService.validateMac(userName, password)) {
						System.out.println("Susscessfully Login");
						// switch options
						int option = 0;
						System.out
								.println("Enter 1 for View all. 2 for updating after interview 3. for exit");
						option = scan.nextInt();

						switch (option) {
						case 1:
							System.out.println("It is in viewing mode");

							try {
								List<ProgramScheduled> programScheduled = macService
										.listPrograms();
								if (programScheduled != null) {
									System.out.println("Program Name");
									System.out
											.println("-----------------------");
									for (ProgramScheduled program : programScheduled) {
										System.out.println(String.format(
												"\t%s", program.getProgName()));
									}
								} else {
									System.out.println("No Records Found!");
								}
							} catch (UASException e) {
								System.err.println(e.getMessage());
							}

							System.out.println("Showing all Applications");
							System.out
									.println("Enter name of program from the options shown above");
							String pName = scan.next().toUpperCase();
							try {
								List<Applicant> appList = macService
										.findProgApplicant(pName);
								if (appList != null) {
									System.out
											.println("\tApp Id\tApp Name\tDOB\tQualification\tMarks\tGoals\t\tEmail\t\tProg Id\t\tStatus\t\tInterview date");
									System.out
											.println("-----------------------------------------------------------------------------------------------------------------------------------");
									for (Applicant applicant : appList) {
										System.out
												.println(String
														.format("\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t\t%s\t%s",
																applicant
																		.getAppId(),
																applicant
																		.getAppName(),
																applicant
																		.getAppDOB(),
																applicant
																		.getQualification(),
																applicant
																		.getMarks(),
																applicant
																		.getGoals(),
																applicant
																		.getEmailId(),
																applicant
																		.getScheduleProgId(),
																applicant
																		.getStatus(),
																applicant
																		.getDateOfInterview()));
									}
								} else {
									System.out.println("No Records Found!");
									break;
								}
							} catch (UASException e) {
								System.err.println(e.getMessage());
							}

							System.out
									.println("Enter applicant's Id to update status before interview: ");
							int aId = scan.nextInt();
							System.out
									.println("Enter 1 to Accept and 2 to Reject the Application");

							int opt = scan.nextInt();
							if (opt == 2) {

								int isDone = macService.updateStatus(aId);
								System.out
										.println("Application with ID "
												+ isDone
												+ " is rejected for interview");
								logger.info("Application is rejected");
							} else if (opt == 1) {
								
								System.out
										.println("Enter Interview Date in 'dd/MM/yyyy' format: ");
								String doi = scan.next();

								SimpleDateFormat myFormat = new SimpleDateFormat(
										"dd/MM/yyyy");
								myFormat.setLenient(false);
								boolean isDate = macService.isValidDoi(doi);
								if (isDate) {
									try {
										Date date = myFormat.parse(doi);
										java.sql.Date doiSql = new java.sql.Date(
												date.getTime());

										int isDone = macService
												.assignInterview(aId, doiSql);
										System.out
												.println("Application with ID "
														+ isDone
														+ " is accepted and the Interview is scheduled on "
														+ doiSql);
										logger.info("Application is accepted");
									} catch (ParseException e) {
										logger.error("Please enter correct Date of Interview");
										throw new UASException(
												"Please enter Date of Interview in valid format");
										/* e.printStackTrace(); */
									}
								} else {
									logger.error("Please enter correct Date of Interview");
									System.out
											.println("Please enter correct Date of Interview");
								}

							}

							break;

						case 2:
							System.out.println("After Interview Process");
							List<Applicant> appList = macService
									.viewInterviewedCandidates();
							if (appList != null) {
								System.out
										.println("\tApp Id\tApp Name\tDOB\tQualification\tMarks\tGoals\t\tEmail\t\tProg Id\t\tStatus\t\tInterview date");
								System.out
										.println("-----------------------------------------------------------------------------------------------------------------------------------");
								for (Applicant applicant : appList) {
									System.out
											.println(String
													.format("\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t\t%s\t%s",
															applicant
																	.getAppId(),
															applicant
																	.getAppName(),
															applicant
																	.getAppDOB(),
															applicant
																	.getQualification(),
															applicant
																	.getMarks(),
															applicant
																	.getGoals(),
															applicant
																	.getEmailId(),
															applicant
																	.getScheduleProgId(),
															applicant
																	.getStatus(),
															applicant
																	.getDateOfInterview()));
								}
							} else {
								System.out.println("No Records Found!");
								
							}

							System.out
									.println("Enter applicant's Id to update status after interview:");
							
							int intrwId = scan.nextInt();
							System.out
									.println("Enter 1 to Confirm and 2 to Reject the Application");

							int value = scan.nextInt();

							if (value == 2) {

								int isDone = macService.updateStatus(intrwId);
								System.out
										.println("Application with ID "
												+ isDone
												+ " is rejected for admission");
							} else if (value == 1) {
								int isDone = macService
										.updateInterviewStatus(intrwId);
								System.out.println("Application with ID "
										+ isDone
										+ " is confirmed for admission");
								int isConfirmed = macService
										.addParticipant(intrwId);
							}
							break;

						case 3:
							System.exit(0);

						default:
							System.out.println("Please enter valid input");

						}
					} else {
						System.out.println("Please Login Again");
						// start();
					}
				} catch (UASException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (choice == 2) {
				System.out.println("Exiting the Application");
				logger.info("Exiting the Application");
				System.exit(0);
			}
		}
		scan.close();
		System.out.println("Program Terminated");
		logger.info("Program Terminated");
	}
}
