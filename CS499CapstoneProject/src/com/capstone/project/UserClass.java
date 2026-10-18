package com.capstone.project;

public class UserClass {
	
	private String username;
	char[] password;
	
	public UserClass(String username, char[] password) {
		
		setUsername(username);
		setPassword(password);
	}
	
	// set user login name
	public void setUsername(String username) {
		this.username = username;
	}
	
	// set user password
	public void setPassword(char[] password) {
		this.password = password;
	}
	
	// output user login name
	public String getUsername(String username) {
		return username;
	}
	
	// output user encrypted password
	public char[] getPassword(char[] password) {
		return password;
	}

}
