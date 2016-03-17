package com.lyon4j.pojo;

import java.math.BigDecimal;

public class User {
	private BigDecimal userId;
	private String username;
	private String password;	
	
	

	public User() {
		super();
	}
	
	public User(BigDecimal userId, String username, String password) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
	}

	public BigDecimal getUserId() {
		return userId;
	}

	public void setUserId(BigDecimal userId) {
		this.userId = userId;
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
