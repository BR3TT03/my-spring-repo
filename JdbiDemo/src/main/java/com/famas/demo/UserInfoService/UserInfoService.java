package com.famas.demo.UserInfoService;

import java.util.List;

import com.famas.demo.UserInfoModel.UserInfo;

public interface UserInfoService {
	
	public List<UserInfo> getAllUserInfo();
	public Integer addUserInfo(UserInfo userInfo);

}
