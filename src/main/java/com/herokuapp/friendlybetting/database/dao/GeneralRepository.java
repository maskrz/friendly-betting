package com.herokuapp.friendlybetting.database.dao;

public interface GeneralRepository {

	public <T> T add(T entity);
	
	public <T> T findById(Class<? extends T> entityClass, Object key);
}
