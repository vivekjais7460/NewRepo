package com.tweet.model;

public class User {
	private String firstname;
	private String email;
	private String password;
	private String dob;
	private int online;
	public String getDob() {
		return dob;
	}

	

	public User(String firstname, String email, String password, String dob) {
		super();
		this.firstname = firstname;
		this.email = email;
		this.password = password;
		this.dob = dob;
	}



	public void setDob(String dob) {
		this.dob = dob;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getOnline() {
		return online;
	}
	public void setOnline(int online) {
		this.online = online;
	}

}
