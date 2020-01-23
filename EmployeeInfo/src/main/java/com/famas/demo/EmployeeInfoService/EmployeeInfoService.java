package com.famas.demo.EmployeeInfoService;

import java.util.List;

import com.famas.demo.model.Employee;

public interface EmployeeInfoService {
			
	public List<Employee> getAllEmployee();
	public Employee getEmployeeById(int employeeId);
	public String deleteEmployeeById(int employeeId);
}
