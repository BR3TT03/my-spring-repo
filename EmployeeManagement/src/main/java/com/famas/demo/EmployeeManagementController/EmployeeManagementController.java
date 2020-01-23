package com.famas.demo.EmployeeManagementController;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.famas.demo.EmployeeManagementService.EmployeeManagementService;
import com.famas.demo.ExceptionHandler.model.EmployeeNotFoundException;
import com.famas.demo.model.Employee;

@Controller
@RequestMapping("/employee")
public class EmployeeManagementController {

	EmployeeManagementService employeeMgmtService;

	public EmployeeManagementController(EmployeeManagementService employeeMgmtService) {
		this.employeeMgmtService = employeeMgmtService;
	}

	@GetMapping
		public String getAllEmployee(Model model) {

		List<Employee> allEmployee = employeeMgmtService.getAllEmployee();
		// System.out.println("data ###"+allEmployee);
		model.addAttribute("allEmployee", allEmployee);

		return "EmployeeManagement";

	}

	@GetMapping("/{employeeId}")
	public String getEmployeeById(@PathVariable("employeeId") int employeeId,
			Model model) /* throws EmployeeNotFoundException */ {
		Employee employeeDetails = null;
		try{
			 employeeDetails = employeeMgmtService.getEmployeeById(employeeId);
			
		} catch(Exception ex) {
			
		}
	
		if(employeeDetails != null) {
			model.addAttribute("employeeDetails", employeeDetails);
		} else {
			model.addAttribute("employeeNotFound", new EmployeeNotFoundException("Employee Not found", HttpStatus.NOT_FOUND));
		}
		
		//System.out.println(employeeDetails);
		return "EmployeeDetails";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "Login";
	}

	
	@PostMapping("/{employeeId}")
	 public String deleteEmployeeById(@PathVariable("employeeId") int employeeId) {
		employeeMgmtService.deleteEmployeeById(employeeId);
		return "redirect:/getAllEmployee";
	}
}
