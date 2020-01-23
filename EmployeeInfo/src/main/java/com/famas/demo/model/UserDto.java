package com.famas.demo.model;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	
	@ColumnName("Id")
	private int Id;
	
	@ColumnName("Role_Id")
	private int Role_Id;
	@ColumnName("UserName")
	private String UserName;
	@ColumnName("Password")
	private String Password;
	@ColumnName("FirstName")
	private String FirstName;
	@ColumnName("Role")
	private Role Role;

}
