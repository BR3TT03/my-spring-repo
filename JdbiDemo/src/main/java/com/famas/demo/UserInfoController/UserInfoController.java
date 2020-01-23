package com.famas.demo.UserInfoController;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.famas.demo.ExceptionHandler.SqlSyntaxError;
import com.famas.demo.ExceptionHandler.UserNotFoundException;
import com.famas.demo.UserInfoModel.UserInfo;
import com.famas.demo.UserInfoService.UserInfoService;


@RestController
@RequestMapping("/userInfo")
public class UserInfoController {
	private final Logger LOGGER = LoggerFactory.getLogger(UserInfoController.class);
	UserInfoService userInfoService;

	public UserInfoController(UserInfoService userInfoService) {
	
		this.userInfoService = userInfoService;
	}

	@GetMapping
	public List<UserInfo> getAllUserInfo()
	{
		List<UserInfo> userInfo = userInfoService.getAllUserInfo();
		//List<UserInfo> userInfo = null;

		if(userInfo == null)
		{
			throw new UserNotFoundException("No user found in the database", HttpStatus.NOT_FOUND);
			
		}
		
		return userInfo;
	}
	
	@PostMapping
	public UserInfo addUserInfo(@RequestBody UserInfo userInfo) throws SqlSyntaxError {
		try {
			
			userInfoService.addUserInfo(userInfo);
			
		} catch (Exception e) {
			//LOGGER.info(e.getMessage());
			throw new SqlSyntaxError("Transaction could not be completed due to system error", HttpStatus.NOT_FOUND);
			/*if(e instanceof SQLSyntaxErrorException462) {
				ExceptionResponse ex = new ExceptionResponse("SqlError",404);
				return ex;*/
			}
			
		
		
		return userInfo;
	}
}
