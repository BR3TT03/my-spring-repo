package com.famas.demo.UserInfoRepository;

import java.util.List;

import javax.persistence.GeneratedValue;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import com.famas.demo.UserInfoModel.UserInfo;

public interface UserInfoRepository {

	@SqlQuery("SELECT * FROM UserInfo")
	@RegisterBeanMapper(UserInfo.class)
	public List<UserInfo> getAllUserInfo();
	
	@GeneratedValue
	@SqlUpdate("INSERT INTO UserInfo (userName,userEmail) VALUES (:userName, :userEmail)")
	public Integer addUserInfo(@BindBean UserInfo userInfo);
	
}
