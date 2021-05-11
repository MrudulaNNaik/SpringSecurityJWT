package com.example.demorest.model;

public class AuthenticateReq {
	String username;
	String password;
	
	
	
	
	
	public AuthenticateReq() {
	}
	
	
	public AuthenticateReq(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
