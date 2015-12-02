package com.herokuapp.friendlybetting.database.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herokuapp.friendlybetting.database.entities.User;

@Service("testService")
public class TestServiceImpl implements TestService {

	@Autowired
	private GeneralRepository generalRepository;
	
	@Override
	public void test(User user) {
		getGeneralRepository().add(user);		
	}

	@Override
	public User getUser() {
		return getGeneralRepository().findById(User.class, 1);
	}

	public GeneralRepository getGeneralRepository() {
		return generalRepository;
	}

	public void setGeneralRepository(GeneralRepository generalRepository) {
		this.generalRepository = generalRepository;
	}

}
