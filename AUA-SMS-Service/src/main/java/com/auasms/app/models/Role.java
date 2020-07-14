package com.auasms.app.models;

import java.io.Serializable;

public class Role implements Serializable {

	private static final long serialVersionUID = -1508476117033888166L;
	private int id;
	String role;

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(int id, String role) {
		super();
		this.id = id;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
