package com.auasms.app.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.auasms.app.models.User;
import com.auasms.app.repository.UserRepository;
import com.auasms.app.services.DatabaseService;
import com.auasms.app.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	DatabaseService databaseService;
	UserRepository userRepository;
	

	public UserServiceImpl(DatabaseService databaseService) {
		super();
		this.databaseService = databaseService;
		this.userRepository = databaseService.getDaoClass(UserRepository.class);
	}

	@Override
	public void addUser(User user) {
		userRepository.addUser(user);
		
	}

	@Override
	public User getUserById(int id) {
		User user;
		try {
			 user = userRepository.getUserById(id);
		} catch (Exception e) {
			System.out.println(e);
			return null;
			// TODO: handle exception
		}
		return user;
	}

	@Override
	public void updateUserDetails(User user,int id) {
		userRepository.updateUserDetails(user,id);
	}

	@Override
	public boolean deleteUser(int id) {
		return userRepository.deleteUser(id);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.getAllUsers();
	}
	
	public int userExists(int id) {
		try {
			return userRepository.userExists(id);
		} catch (Exception e) {
			System.out.println(e);		
			return 0;
		}
		
	}

	@Override
	public User userExistsByEmail(String email) {
		return userRepository.userExistsByEmail(email);
	}

}
