package com.famas.demo.ExceptionHandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.famas.demo.UserInfoModel.ExceptionResponse;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handleUserNotFoundException ( UserNotFoundException ex) {
			
		ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), ex.getStatus().value());
	return new ResponseEntity<ExceptionResponse>(exceptionResponse, ex.getStatus());
	}
	
	@ExceptionHandler(SqlSyntaxError.class)
	public ResponseEntity<ExceptionResponse> handleSqlSyntaxError ( SqlSyntaxError ex) {
		
		ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), ex.getStatus().value());
	return new ResponseEntity<ExceptionResponse>(exceptionResponse, ex.getStatus());
	}
	
}
