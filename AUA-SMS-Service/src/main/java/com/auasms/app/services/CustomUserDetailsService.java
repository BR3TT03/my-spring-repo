package com.auasms.app.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.auasms.app.models.CustomUserByUserName;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	CustomUserByUserName user;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Logger log = LoggerFactory.getLogger(this.getClass());

		UserDetails userExists = user.getUser(username);
		if(userExists!=null) {
		return userExists;	
		}
		throw new UsernameNotFoundException("Unauthorized");
	}
	
}
