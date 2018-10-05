package com.capg.uas.bean;

public class Participant {
	
	//Variable Declaration
	private String rollNo;
	private String emailId;
	private int appId;
	private String scheduleProgId;
	
	//Getters and Setters Methods
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getAppId() {
		return appId;
	}
	public void setAppId(int appId) {
		this.appId = appId;
	}
	public String getScheduleProgId() {
		return scheduleProgId;
	}
	public void setScheduleProgId(String scheduleProgId) {
		this.scheduleProgId = scheduleProgId;
	}
	
	//toString() Method Overriden
	@Override
	public String toString() {
		return "Participant [rollNo=" + rollNo + ", emailId=" + emailId
				+ ", appId=" + appId + ", scheduleProgId=" + scheduleProgId
				+ "]";
	}
	
	// Parameterized Constructor
	public Participant(String rollNo, String emailId, int appId,
			String scheduleProgId) {
		
		this.rollNo = rollNo;
		this.emailId = emailId;
		this.appId = appId;
		this.scheduleProgId = scheduleProgId;
	}
	
	// Default Constructor
	public Participant() {
		
	}
	
	
	

}
