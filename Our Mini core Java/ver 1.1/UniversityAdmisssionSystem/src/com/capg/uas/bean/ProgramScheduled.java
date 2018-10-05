package com.capg.uas.bean;

import java.sql.Date;

public class ProgramScheduled {
	
	//Variable Declaration
	private String scheduleProgId; 
	private String progName;
	private String location;
	private Date start;
	private Date end;
	private int sessionsPerWeek;
	
	//Getters and Setters Methods
	public Date getEnd() {
		return end;
	}
	public String getLocation() {
		return location;
	}
	public String getProgName() {
		return progName;
	}
	public String getScheduleProgId() {
		return scheduleProgId;
	}
	public int getSessionsPerWeek() {
		return sessionsPerWeek;
	}
	public Date getStart() {
		return start;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setProgName(String progName) {
		this.progName = progName;
	}
	public void setScheduleProgId(String scheduleProgId) {
		this.scheduleProgId = scheduleProgId;
	}
	public void setSessionsPerWeek(int sessionsPerWeek) {
		this.sessionsPerWeek = sessionsPerWeek;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	
	//toString() Method Overriden
	@Override
	public String toString() {
		return "Program Scheduled\nScheduled Progam Id = " + scheduleProgId
				+ "\n Program Name = " + progName + "\nLocation = " + location
				+ "\nStart Date = " + start + "\nEnd Date = " + end + "\nSessions Per Week = "
				+ sessionsPerWeek + "]";
	}
	
	// Parameterized Constructor
	public ProgramScheduled(String scheduleProgId, String progName,
			String location, Date start, Date end, int sessionsPerWeek) {

		this.scheduleProgId = scheduleProgId;
		this.progName = progName;
		this.location = location;
		this.start = start;
		this.end = end;
		this.sessionsPerWeek = sessionsPerWeek;
	}
	
	//Default Constructor
	public ProgramScheduled() {
		
	}
	
	

}
