package com.famas.demo.ExceptionHandler;

import org.springframework.http.HttpStatus;

public class SqlSyntaxError extends RuntimeException {
	private static final long serialVersionUID = 4484155400656864634L;
	private String message;
	private HttpStatus status;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public SqlSyntaxError(String message, HttpStatus status) {
		super();
		this.message = message;
		this.status = status;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public SqlSyntaxError() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SqlSyntaxError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	public SqlSyntaxError(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public SqlSyntaxError(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public SqlSyntaxError(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
