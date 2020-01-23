package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public Iterable<com.example.demo.model.User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public Optional<com.example.demo.model.User> getUserById(int userId) {
		// TODO Auto-generated method stub
		return userRepository.findById(userId);
	}

	@Override
	public String createUser(User users) {
		// TODO Auto-generated method stub
		userRepository.save(users);
		return "Save Successful";
	}

	@Override
	public User updateUser(int userId, User user) {
		// TODO Auto-generated method stub
		if (userRepository.existsById(userId)) {
			Optional<User> data = userRepository.findById(userId);
			User info = data.get();
			info.setFirstName(user.getFirstName());
			info.setLastName(user.getLastName());
			info.setPhoneNumber(user.getPhoneNumber());
			userRepository.save(info);
			return info;
		}

		return null;

	}

	@Override
	public int deleteByUserId(int userId) {
		// TODO Auto-generated method stub
		if (userRepository.existsById(userId)) {
			userRepository.deleteById(userId);
			return 1;
		}
		return 0;
	}

	@Override
	public User updatePartial(int userId, User user) {
		if (userRepository.existsById(userId)) {
			Optional<User> data = userRepository.findById(userId);
			User info = data.get();
			info.setPhoneNumber(user.getPhoneNumber());
			userRepository.save(info);
			return info;

		}
		return null;
	}
}
