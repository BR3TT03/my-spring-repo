package com.auasms.app.auaSmsController;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.auasms.app.models.User;
import com.auasms.app.services.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String homePage() {
		return "Welcome to AUA-SMS-Service!!";
	}
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		userService.addUser(user);
		return user;
		
	}
	
	@GetMapping("/user")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable("id") int id) {
		return userService.getUserById(id);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable("id") List<Integer> id) {
		for(int userId : id)
			if (userService.userExists(userId) == 1) {
				userService.deleteUser(userId);
			} else {
				return "UserId " + userId + " does not exists!";
			}
		return "Successfully deleted!";
	}
	
	@PatchMapping("/updateUserDetails/{id}")
	public String updateClientInfo(@RequestBody Map<Object, Object> userInfo, @PathVariable("id") int id) {

		if (userService.userExists(id) == 1) {
//			System.out.println("before null pointer exception");
			User existingData = userService.getUserById(id);
//			System.out.println("After null pointer exception");
			userInfo.forEach((k, v) -> {
				Field field = ReflectionUtils.findField(User.class, (String) k);
//				System.out.println("#######Field: " + field.getName() + "############# " + k);
				field.setAccessible(true);
				ReflectionUtils.setField(field, existingData, v);
			});

			userService.updateUserDetails(existingData, id);
			return "Successfully updated";
//		    claimService.saveOrUpdate(claim);
		}
		return "Client with clientId " + id + " does not exist";

	}

}
