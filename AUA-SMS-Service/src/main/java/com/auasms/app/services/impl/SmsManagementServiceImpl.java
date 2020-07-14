package com.auasms.app.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.auasms.app.models.SmsManagement;
import com.auasms.app.repository.SmsManagementRepository;
import com.auasms.app.services.DatabaseService;
import com.auasms.app.services.SmsManagementService;

@Service
public class SmsManagementServiceImpl implements SmsManagementService {
	
	DatabaseService databaseService;
	SmsManagementRepository smsManagementRepository; 
	public SmsManagementServiceImpl(DatabaseService databaseService) {
		super();
		this.databaseService = databaseService;
		this.smsManagementRepository = databaseService.getDaoClass(SmsManagementRepository.class);
	}

	@Override
	public SmsManagement getSmsManagementInfoById(int id) {
		return smsManagementRepository.getSmsManagementInfoById(id);
	}

	@Override
	public boolean deleteSmsManagementInfoById(int id) {
		return smsManagementRepository.deleteSmsManagementInfoById(id);
	}

	@Override
	public List<SmsManagement> getAllSmsManagementInfo() {
		return smsManagementRepository.getAllSmsManagementInfo();
	}

	@Override
	public void updateSmsManagementInfo(int id) {
		smsManagementRepository.updateSmsManagementInfo(id);
	}

}
