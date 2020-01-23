package com.famas.demo.EmployeeManagementService.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import com.famas.demo.EmployeeManagementService.EmployeeDatabaseService;
import com.famas.demo.EmployeeManagementService.EmployeeManagementService;
import com.famas.demo.EmployeeRepository.EmployeeRepository;
import com.famas.demo.model.Employee;

@Service
public class EmployeeManagementServiceImpl implements EmployeeManagementService {

	EmployeeDatabaseService databaseService;
	EmployeeRepository employeeRepository;

	public EmployeeManagementServiceImpl(EmployeeDatabaseService databaseService) {
		this.databaseService = databaseService;
		this.employeeRepository = databaseService.getDaoClass(EmployeeRepository.class);

	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.getAllEmployee();

	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		return employeeRepository.getEmployeeById(employeeId);
	}
	
	@Override
	public String deleteEmployeeById(int employeeId) {
	employeeRepository.deleteEmployeeById(employeeId);
	return "deletion successful";	 
	}

}
