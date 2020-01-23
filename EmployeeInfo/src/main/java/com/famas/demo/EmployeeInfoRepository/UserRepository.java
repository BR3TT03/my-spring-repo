package com.famas.demo.EmployeeInfoRepository;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import com.famas.demo.mapper.CustomUserMapper;

import com.famas.demo.model.CustomUserDetail;

public interface UserRepository {
	@SqlQuery("SELECT * FROM User u INNER JOIN Role r ON r.id = u.Role_Id WHERE UserName = :username")
	@RegisterRowMapper(value = CustomUserMapper.class)
	public CustomUserDetail loadUserByUsername(@Bind("username") String username);

}
