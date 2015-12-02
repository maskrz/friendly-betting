package com.herokuapp.friendlybetting.database.dao;

import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.friendlybetting.database.entities.User;

public interface TestService {

	@Transactional
	public void test(User user);
		
	public User getUser();
}
