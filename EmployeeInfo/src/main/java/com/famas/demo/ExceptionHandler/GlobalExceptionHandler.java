package com.famas.demo.ExceptionHandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.famas.demo.ExceptionHandler.model.EmployeeNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler  {
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<EmployeeNotFoundException> handleEmployeeNotFoundException ( EmployeeNotFoundException ex){
		
		return new ResponseEntity<EmployeeNotFoundException>(ex, ex.getStatus());
		
	}
}
