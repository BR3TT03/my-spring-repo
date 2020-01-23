package com.famas.demo.EmployeeManagementService.impl;

import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.famas.demo.EmployeeManagementService.EmployeeDatabaseService;
@Service
public class EmployeeDatabaseServiceImpl implements EmployeeDatabaseService {

	private final Logger LOGGER = LoggerFactory.getLogger(EmployeeDatabaseServiceImpl.class);
	private Jdbi jdbi;
	public EmployeeDatabaseServiceImpl(Jdbi jdbi) {
		super();
		this.jdbi = jdbi;
	}
	@Override
	public <T> T getDaoClass(Class<T> daoClass) {
		try {
			if(jdbi != null) {
				return jdbi.onDemand(daoClass);
			}
		
			throw new NullPointerException("jdbi object is not initialized...");
		}	catch(Exception ex) {
				LOGGER.info(ex.getMessage());
			}
		
		// TODO Auto-generated method stub
		return null;
	}

}
