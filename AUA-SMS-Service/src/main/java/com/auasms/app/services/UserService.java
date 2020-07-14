package com.auasms.app.services;

import java.util.List;

import com.auasms.app.models.User;

public interface UserService {
	public void addUser(User user);
	public User getUserById(int id);
	public void updateUserDetails(User user, int id);
	public boolean deleteUser(int id);
	public List<User> getAllUsers();
	public int userExists(int id);
	public User userExistsByEmail(String email);
}
