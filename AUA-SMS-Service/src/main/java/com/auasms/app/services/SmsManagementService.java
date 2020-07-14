package com.auasms.app.services;

import java.util.List;

import com.auasms.app.models.SmsManagement;

public interface SmsManagementService {
	public SmsManagement getSmsManagementInfoById(int id);
	public boolean deleteSmsManagementInfoById(int id);
	public List<SmsManagement> getAllSmsManagementInfo();
	public void updateSmsManagementInfo(int id);
//	public int getSentSmsById(int id);
}
