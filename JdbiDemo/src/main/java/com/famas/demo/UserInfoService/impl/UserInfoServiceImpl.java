package com.famas.demo.UserInfoService.impl;

import java.sql.SQLSyntaxErrorException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.famas.demo.ExceptionHandler.SqlSyntaxError;
import com.famas.demo.UserInfoModel.UserInfo;
import com.famas.demo.UserInfoRepository.UserInfoRepository;
import com.famas.demo.UserInfoService.DatabaseService;
import com.famas.demo.UserInfoService.UserInfoService;
@Service
public class UserInfoServiceImpl implements UserInfoService {

	DatabaseService databaseService;
	UserInfoRepository userInfoRepository;

	public UserInfoServiceImpl(DatabaseService databaseService)
	{
		this.databaseService = databaseService;
		this.userInfoRepository = databaseService.getDaoClass(UserInfoRepository.class);
	
	}

	@Override
	public List<UserInfo> getAllUserInfo() {

		return userInfoRepository.getAllUserInfo();
	}

	@Override
	public Integer addUserInfo(UserInfo userInfo) {
		return userInfoRepository.addUserInfo(userInfo);
	}

}
