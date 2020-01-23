package com.famas.demo.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import com.famas.demo.model.Avatar;
import com.famas.demo.model.Employee;

public class EmployeeMapper implements RowMapper<Employee>{

	@Override
	public Employee map(ResultSet rs, StatementContext ctx) throws SQLException {
		// TODO Auto-generated method stub
		Employee employee = new Employee();
		employee.setEmployeeID(rs.getInt("employeeID"));
		employee.setEmployeeEmail(rs.getString("employeeEmail"));
		employee.setEmployeeName(rs.getString("employeeName"));
		employee.setEmployeePost(rs.getString("employeePost"));
		employee.setEmployeeSalary(rs.getInt("employeeSalary"));
		
		Avatar avatar = new Avatar();
		avatar.setEmployeeID(rs.getInt("employeeID"));
		avatar.setEmployeeImages(rs.getString("employeeImages"));
		
		employee.setAvatar(avatar);
		return employee;
	}

}
