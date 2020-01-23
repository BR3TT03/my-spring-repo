package com.famas.demo.ExceptionHandler;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -2630200799428494345L;
	private String message;
	private HttpStatus status;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public UserNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	public UserNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public UserNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public UserNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	public UserNotFoundException(String message, HttpStatus status) {
		super();
		this.message = message;
		this.status = status;
	}
	
}
