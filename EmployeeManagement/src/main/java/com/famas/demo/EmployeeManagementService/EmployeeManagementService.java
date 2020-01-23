package com.famas.demo.EmployeeManagementService;

import java.util.List;

import com.famas.demo.model.Employee;

public interface EmployeeManagementService {
			
	public List<Employee> getAllEmployee();
	public Employee getEmployeeById(int employeeId);
	public String deleteEmployeeById(int employeeId);
}
