package com.famas.demo.EmployeeInfoService.impl;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.famas.demo.EmployeeInfoService.EmployeeDatabaseService;
import com.famas.demo.model.CustomUserDetail;
import com.famas.demo.EmployeeInfoRepository.UserRepository;;

@Service

public class UserDetailsServiceImpl implements UserDetailsService {

EmployeeDatabaseService databaseService;
	
	public UserDetailsServiceImpl(EmployeeDatabaseService databaseService) {
		this.databaseService = databaseService;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		CustomUserDetail user = databaseService.getDaoClass(UserRepository.class).loadUserByUsername(username);
		return user;
	}

}
