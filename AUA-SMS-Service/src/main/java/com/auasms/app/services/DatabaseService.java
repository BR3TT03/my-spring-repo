package com.auasms.app.services;

public interface DatabaseService {
	public <T> T getDaoClass(Class<T> daoClass);
}
