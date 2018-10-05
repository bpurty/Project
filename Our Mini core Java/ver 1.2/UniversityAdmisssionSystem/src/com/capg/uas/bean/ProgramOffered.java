package com.capg.uas.bean;

public class ProgramOffered {
	
	//Variable Declaration
	private String progName;
	private String desc;
	private String appEligibility;
	private int duration;
	private String degreeOffered;
	
	
	//Getters and Setters Methods
	public String getProgName() {
		return progName;
	}
	public void setProgName(String progName) {
		this.progName = progName;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getAppEligibility() {
		return appEligibility;
	}
	public void setAppEligibility(String appEligibility) {
		this.appEligibility = appEligibility;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getDegreeOffered() {
		return degreeOffered;
	}
	public void setDegreeOffered(String degreeOffered) {
		this.degreeOffered = degreeOffered;
	}
	
	//toString() Method Overriden
	@Override
	public String toString() {
		return "Program Offered\nName = " + progName + "\nDescription = " + desc
				+ "\nEligibility Criteria = " + appEligibility + "\nDuration = "
				+ duration + "\nDegree Offered = " + degreeOffered + "]";
	}
	
	
	// Parameterized Constructor
	public ProgramOffered(String progName, String desc, String appEligibility,
			int duration, String degreeOffered) {

		this.progName = progName;
		this.desc = desc;
		this.appEligibility = appEligibility;
		this.duration = duration;
		this.degreeOffered = degreeOffered;
	}
	
	// Default Constructor
	public ProgramOffered() {
		
	}
	
	
	
	

}
