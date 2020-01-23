package com.famas.demo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import com.famas.demo.model.CustomUserDetail;
import com.famas.demo.model.Role;
import com.famas.demo.model.UserDto;

public class CustomUserMapper implements RowMapper<CustomUserDetail>{

	@Override
	public CustomUserDetail map(ResultSet rs, StatementContext ctx) throws SQLException {
		UserDto user = new UserDto();
		Role role = new Role();
		role.setRole(rs.getString("Role"));
		user.setFirstName(rs.getString("FirstName"));
		user.setUserName(rs.getString("UserName"));
		user.setPassword(rs.getString("Password"));
		user.setRole_Id(rs.getInt("Role_Id"));
		user.setRole(role);
		
		CustomUserDetail loggedInUserDetail = new CustomUserDetail(user);
		return loggedInUserDetail;
	}
	
	

}
