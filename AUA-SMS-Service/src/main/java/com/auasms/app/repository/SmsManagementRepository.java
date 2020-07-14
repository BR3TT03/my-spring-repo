package com.auasms.app.repository;

import java.util.List;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.springframework.stereotype.Repository;

import com.auasms.app.models.SmsManagement;

@Repository
public interface SmsManagementRepository {
	
	@SqlQuery("SELECT * FROM SmsManagement")
	@RegisterBeanMapper(SmsManagement.class)
	public List<SmsManagement> getAllSmsManagementInfo();
	
	@SqlQuery("SELECT * FROM SmsManagement WHERE userId = :id")
	@RegisterBeanMapper(SmsManagement.class)
	public SmsManagement getSmsManagementInfoById(@Bind int id);
	
	@SqlUpdate("UPDATE SmsManagement SET smsLimit = smsLimit-1,sent = sent+1 WHERE userId = :id")
	public void updateSmsManagementInfo(@Bind int id);
	
	@SqlUpdate("DELETE * FROM SmsManagement WHERE userId = :id")
	public boolean deleteSmsManagementInfoById(@Bind int id);
}
