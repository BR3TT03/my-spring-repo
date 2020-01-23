package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.User;


public interface UserService {

	public Iterable<com.example.demo.model.User> getAllUsers();

	public Optional<com.example.demo.model.User> getUserById(int userId);

	public String createUser(User user);

	public User updateUser(int userId, User user);

	public int deleteByUserId(int userId);
	
	public User updatePartial(int userId,User user);
}
