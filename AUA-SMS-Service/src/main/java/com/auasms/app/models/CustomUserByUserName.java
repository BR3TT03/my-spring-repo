package com.auasms.app.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.auasms.app.services.UserService;
import com.auasms.app.util.CustomUserDetails;

@Service
public class CustomUserByUserName {
	CustomUserDetails userDetails = new CustomUserDetails();
	private User user;
	
	@Autowired 
	UserService userService;
	
	public CustomUserByUserName() {
		
	}
	public CustomUserDetails getUser(String username) {
		//call database if the user exists or not if exists return user else return Usernotfoundexception 
		try {
		user = userService.userExistsByEmail(username);
		userDetails.setUser(user);
		return  userDetails;
		
		}
		catch(UsernameNotFoundException e) {
			throw new UsernameNotFoundException("User with "+ username + "not found.");
		}
		
	}
	
}
