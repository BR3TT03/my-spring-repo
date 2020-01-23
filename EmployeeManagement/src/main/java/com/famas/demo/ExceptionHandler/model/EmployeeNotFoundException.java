package com.famas.demo.ExceptionHandler.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -3477323417825402543L;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public EmployeeNotFoundException(String message, HttpStatus status) {
		this.message = message;
		this.status = status;
	}
	
	public EmployeeNotFoundException() {
		
	}
}
