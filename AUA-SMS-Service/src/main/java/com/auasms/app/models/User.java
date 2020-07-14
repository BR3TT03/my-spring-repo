package com.auasms.app.models;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 156327496352503601L;
	private int userId;
	private String name;
	private String email;
	private String phone;
	private int userStatus;
	private String role;
	private String password;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int userId, String name, String email, String phone, int userStatus, String role, String password) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.userStatus = userStatus;
		this.role = role;
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
