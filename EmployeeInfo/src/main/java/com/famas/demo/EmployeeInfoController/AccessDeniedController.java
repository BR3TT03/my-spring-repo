package com.famas.demo.EmployeeInfoController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller


public class AccessDeniedController {
	@GetMapping("/accessDenied")
	public String accessDenied() {
		return "AccessDenied";
	}
}
