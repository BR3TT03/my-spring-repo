package com.auasms.app.models;

import java.io.Serializable;

public class SmsManagement implements Serializable {
	private static final long serialVersionUID = -1003674083995168395L;
	private int userId;
	private int smsLimit;
	private int sent;
	
	public SmsManagement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public SmsManagement(int userId, int smsLimit, int sent) {
		super();
		this.userId = userId;
		this.smsLimit = smsLimit;
		this.sent = sent;
	}


	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getSmsLimit() {
		return smsLimit;
	}
	
	public void setSmsLimit(int smsLimit) {
		this.smsLimit = smsLimit;
	}
	public int getSent() {
		return sent;
	}
	public void setSent(int sent) {
		this.sent = sent;
	}
}
