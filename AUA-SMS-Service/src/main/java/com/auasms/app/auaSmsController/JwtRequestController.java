package com.auasms.app.auaSmsController;

import org.springframework.web.bind.annotation.RestController;

import com.auasms.app.models.JwtRequest;
import com.auasms.app.util.CustomUserDetails;
import com.auasms.app.util.JwtTokenUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtRequestController {

	@Autowired
	AuthenticationProvider authenticationManager;
	
	@Autowired
	JwtTokenUtil jwtUtil;
	
	Logger log = LoggerFactory.getLogger(this.getClass());

	@PostMapping("/authenticate")
	public ResponseEntity<?> userToJwtToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		authenticateUser(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return ResponseEntity.ok(new String("Your JWT " + jwtUtil.generateToken( userDetails)));
	}

	private void authenticateUser(String username, String password) {
				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
	}
	
}
