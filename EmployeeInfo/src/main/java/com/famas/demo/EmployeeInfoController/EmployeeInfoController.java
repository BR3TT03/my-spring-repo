package com.famas.demo.EmployeeInfoController;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.famas.demo.EmployeeInfoService.EmployeeInfoService;
import com.famas.demo.ExceptionHandler.model.EmployeeNotFoundException;
import com.famas.demo.model.Employee;

@Controller
@RequestMapping("/employeeInfo")
public class EmployeeInfoController {

	EmployeeInfoService employeeInfoService;

	public EmployeeInfoController(EmployeeInfoService employeeInfoService) {
		this.employeeInfoService = employeeInfoService;
	}

	@GetMapping
	public String getAllEmployee(Model model) {

		List<Employee> allEmployee = employeeInfoService.getAllEmployee();
		model.addAttribute("allEmployee", allEmployee);
		return "EmployeeInfo";

	}

	@GetMapping("/{employeeId}")
	public String getEmployeeById(@PathVariable("employeeId") int employeeId,
			Model model) /* throws EmployeeNotFoundException */ {
		Employee employeeDetails = null;
		try {
			employeeDetails = employeeInfoService.getEmployeeById(employeeId);

		} catch (Exception ex) {

		}

		if (employeeDetails != null) {
			model.addAttribute("employeeDetails", employeeDetails);
		} else {
			model.addAttribute("employeeNotFound",
					new EmployeeNotFoundException("Employee Not found", HttpStatus.NOT_FOUND));
		}

		// System.out.println(employeeDetails);
		return "EmployeeDetails";
	}

	
	@DeleteMapping("/{employeeId}")
	public @ResponseBody String deleteEmployeeById(@PathVariable("employeeId") int employeeId) {
		employeeInfoService.deleteEmployeeById(employeeId);
		return "deletion successful";
	}

}
