package com.capg.uas.bean;

import java.sql.Date;

public class Applicant {
	
	//Variable Declaration
	private int appId;
	private String appName;
	private Date appDOB;
	private String qualification;
	private int marks;
	private String goals;
	private String emailId;
	private String scheduleProgId;
	private String status;
	private Date dateOfInterview;
	
	//Getters and Setters Methods
	public int getAppId() {
		return appId;
	}
	public void setAppId(int appId) {
		this.appId = appId;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public Date getAppDOB() {
		return appDOB;
	}
	public void setAppDOB(Date appDOB) {
		this.appDOB = appDOB;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getGoals() {
		return goals;
	}
	public void setGoals(String goals) {
		this.goals = goals;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getScheduleProgId() {
		return scheduleProgId;
	}
	public void setScheduleProgId(String scheduleProgId) {
		this.scheduleProgId = scheduleProgId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDateOfInterview() {
		return dateOfInterview;
	}
	public void setDateOfInterview(Date dateOfInterview) {
		this.dateOfInterview = dateOfInterview;
	}
	
	//toString() Method Overriden
	@Override
	public String toString() {
		return "Applicant \nId = " + appId + "\nName = " + appName
				+ "\nDOB = " + appDOB + "\nQualification = " + qualification
				+ "\nMarks = " + marks + "\nGoals = " + goals + "\nEmail-Id = "
				+ emailId + "\nScheduled Program Id = " + scheduleProgId + "\n Application status = "
				+ status + "\nInterview Date = " + dateOfInterview + "]";
	}
	
	// Parameterized Constructor
	public Applicant(int appId, String appName, Date appDOB,
			String qualification, int marks, String goals, String emailId,
			String scheduleProgId, String status, Date dateOfInterview) {
		
		this.appId = appId;
		this.appName = appName;
		this.appDOB = appDOB;
		this.qualification = qualification;
		this.marks = marks;
		this.goals = goals;
		this.emailId = emailId;
		this.scheduleProgId = scheduleProgId;
		this.status = status;
		this.dateOfInterview = dateOfInterview;
	}
	
	//Default Constructor
	public Applicant() {
		
	}
	
	

}
