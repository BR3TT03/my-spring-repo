package com.famas.demo.Security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.famas.demo.Utility.PasswordUtility;
import com.fasterxml.jackson.databind.ObjectMapper;
@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

	@Autowired
	private ObjectMapper objectMapper;
	
	public CustomAuthenticationFailureHandler() {
	}


	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		response.getOutputStream().write(objectMapper.writeValueAsBytes("authentication failed.!"));
		response.getOutputStream().write(objectMapper.writeValueAsBytes(PasswordUtility.encryptPassword("userpass")));
	}

}
