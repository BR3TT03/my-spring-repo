package com.auasms.app.auaSmsController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.auasms.app.models.SmsManagement;
import com.auasms.app.services.SmsManagementService;

@RestController
@CrossOrigin(origins = "*")
public class SmsManagementController {
	
	@Autowired 
	SmsManagementService smsManagementService;
	
	@GetMapping("/smsManagement")
	public List<SmsManagement> getAllSmsManagementInfo(){
		return smsManagementService.getAllSmsManagementInfo();
	}
	
	@GetMapping("/smsManagement/{id}")
	public SmsManagement getSmsManagementInfoById(@PathVariable int id) {
		return smsManagementService.getSmsManagementInfoById(id);
	}
	
	@PatchMapping("/updateSmsManagementInfo/{id}")
	public String updateSmsManagementInfoById(@PathVariable int id) {
		smsManagementService.updateSmsManagementInfo(id);
			return "Successfully Updated";
	}
	
	@DeleteMapping("/deleteSmsManagementInfo/{id}")
	public String deleteSmsManagementInfoById(@PathVariable int id) {
		if(smsManagementService.deleteSmsManagementInfoById(id)) {
			return "Sucessfully Deleted";
		}
		return "User with userId "+id+" doesn't exist";
	}
}
