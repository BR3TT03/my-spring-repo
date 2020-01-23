package com.famas.demo.EmployeeRepository;

import java.util.List;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import com.famas.demo.mapper.EmployeeMapper;
import com.famas.demo.model.Employee;

public interface EmployeeRepository {
	
	@RegisterRowMapper(EmployeeMapper.class)
	@SqlQuery("SELECT * FROM Employee_Details ed INNER JOIN Employee_Images ei ON ed.employeeID = ei.employeeID")
	public List<Employee> getAllEmployee();

	@SqlQuery("SELECT * FROM Employee_Details ed INNER JOIN Employee_Images ei ON ed.employeeID = ei.employeeID WHERE ed.employeeID = :employeeID")
	@RegisterRowMapper(value = EmployeeMapper.class)
	public Employee getEmployeeById(@Bind("employeeID") int employeeID);

	@SqlUpdate("DELETE Employee_Details,Employee_Images FROM Employee_Details INNER JOIN Employee_Images on Employee_Details.employeeID = Employee_Images.employeeID WHERE employeeID = :employeeId")
	@RegisterRowMapper(value = EmployeeMapper.class)
	public String deleteEmployeeById(@Bind("employeeID") int employeeId);
}
