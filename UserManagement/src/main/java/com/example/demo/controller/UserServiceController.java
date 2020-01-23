package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.User;
import com.example.demo.service.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class UserServiceController {

	UserServiceImpl userService;
	
	public UserServiceController(UserServiceImpl userService) {
		//super();@GetMapping
		this.userService = userService;
	}

	@GetMapping
	@ResponseBody public Iterable<User> AllUser() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/createUser")
	public String AddUser()
	{	
		return "createUser";
	}
	
	@PostMapping
	@ResponseBody public String createUser(@RequestBody User user)
	{
		
		return userService.createUser(user);
	}
	

	@GetMapping("/userList")
	public String SendUserList(Model model)
	{
		model.addAttribute("list",userService.getAllUsers());
		return "userList";
		
	}
	
	@GetMapping("/{userId}")
	public String ViewMore( @PathVariable int userId, Model model)
	{
		model.addAttribute("userDetails",userService.getUserById(userId).get());
		return "ViewMore";
		
	}

	/*
	 * @GetMapping("/{userId}") public Optional<User> getUserById(@PathVariable int
	 * userId) { return userService.getUserById(userId); }
	 */
	
	
	@PutMapping("/{userId}")
	public User updateUser(@PathVariable int userId, @RequestBody User user)
	{
		return userService.updateUser(userId, user);
	}
		
	@DeleteMapping("/{userId}")
	public String deleteUser(@PathVariable int userId)
	{
		userService.deleteByUserId(userId);
		return "redirect:userList";
	}
	
	@PatchMapping("/{userId}")
	public User updatePartial(int userId, @RequestBody User user)
	{
		return userService.updatePartial(userId, user);
	}
	
	

}
