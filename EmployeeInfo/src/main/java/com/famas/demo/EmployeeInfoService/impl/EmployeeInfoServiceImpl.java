package com.famas.demo.EmployeeInfoService.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.famas.demo.EmployeeInfoRepository.EmployeeInfoRepository;
import com.famas.demo.EmployeeInfoService.EmployeeDatabaseService;
import com.famas.demo.EmployeeInfoService.EmployeeInfoService;
import com.famas.demo.model.Employee;

@Service
public class EmployeeInfoServiceImpl implements EmployeeInfoService {

	EmployeeDatabaseService databaseService;

	public EmployeeInfoServiceImpl(EmployeeDatabaseService databaseService) {
		this.databaseService = databaseService;

	}

	@Override
	public List<Employee> getAllEmployee() {
		EmployeeInfoRepository employeeRepo = databaseService.getDaoClass(EmployeeInfoRepository.class);
		return employeeRepo.getAllEmployee();

	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		EmployeeInfoRepository employeeRepo = databaseService.getDaoClass(EmployeeInfoRepository.class);
		return employeeRepo.getEmployeeById(employeeId);
	}

	@Override
	public String deleteEmployeeById(int employeeId) {
		EmployeeInfoRepository employeeRepo = databaseService.getDaoClass(EmployeeInfoRepository.class);
		employeeRepo.deleteEmployeeById(employeeId);
		return "deletion successful";
	}

}
