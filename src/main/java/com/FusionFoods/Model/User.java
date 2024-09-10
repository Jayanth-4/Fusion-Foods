package com.FusionFoods.Model;

import java.util.Date;

public class User {
	
	private int userId;
	private String username;
	private String email;
	private long phonenumber;
	private String password;
	private String address;
	private Date registeredDate;
	
	public User() {
		super();
	}
	
	public User(int userId, String username, String email, long phonenumber, String password, String address) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.phonenumber = phonenumber;
		this.password = password;
		this.address = address;
	}

	

	public User(String username, String email, long phonenumber, String password, String address) {
		super();
		this.username = username;
		this.email = email;
		this.phonenumber = phonenumber;
		this.password = password;
		this.address = address;
	}
	public User(int userId,String username, String email, long phonenumber, String password, String address,Date registeredDate) {
		super();
		this.userId=userId;
		this.username = username;
		this.email = email;
		this.phonenumber = phonenumber;
		this.password = password;
		this.address = address;
		this.registeredDate=registeredDate;
	}

	public int getUser_id() {
		return userId;
	}

	public void setUser_id(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", email=" + email + ", phonenumber=" + phonenumber
				+ ", password=" + password + ", address=" + address + ", registeredDate=" + registeredDate + "]";
	}

	

}
