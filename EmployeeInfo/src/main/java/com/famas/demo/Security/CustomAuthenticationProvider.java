package com.famas.demo.Security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.famas.demo.model.CustomUserDetail;
import com.famas.demo.EmployeeInfoService.impl.UserDetailsServiceImpl;

@Component

public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	private final Logger LOGGER = LoggerFactory.getLogger(CustomAuthenticationProvider.class);
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	UserDetailsServiceImpl userDetailService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		UsernamePasswordAuthenticationToken formUser = (UsernamePasswordAuthenticationToken) authentication;
		CustomUserDetail databaseUser = (CustomUserDetail) userDetailService.loadUserByUsername(formUser.getName());
		System.out.println(databaseUser.toString());
		if(databaseUser != null) {
			if(passwordEncoder.matches(""+formUser.getCredentials(), databaseUser.getPassword())) {
				authentication = new UsernamePasswordAuthenticationToken(databaseUser, null, databaseUser.getAuthorities());
				return authentication;
			} 
			
			throw new BadCredentialsException("Invlid credentials");
		}
		
		throw new UsernameNotFoundException("User not found!");
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.equals(authentication);
	}

}
