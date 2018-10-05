package com.capg.uas.bean;

public class Users {

	//Variable Declaration
	private String loginId;
	private String password;
	private String role;
	
	//Getters and Setters Methods
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	//toString() Method Overriden
	@Override
	public String toString() {
		return "Users\nLogin Id = " + loginId + "\nPassword = " + password
				+ "\nRole = " + role + "]";
	}
	
	// Parameterized Constructor
	public Users(String loginId, String password, String role) {
		
		this.loginId = loginId;
		this.password = password;
		this.role = role;
	}
	
	// Default Constructor
	public Users() {

	}
	
	
	
}
