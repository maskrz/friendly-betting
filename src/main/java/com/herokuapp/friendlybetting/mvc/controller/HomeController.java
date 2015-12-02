package com.herokuapp.friendlybetting.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.herokuapp.friendlybetting.database.dao.TestService;
import com.herokuapp.friendlybetting.database.entities.User;

@Controller
public class HomeController {
	
	@Autowired
	private TestService testService;
	
	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {
 
		User user = new User();
		user.setActive(Boolean.TRUE);
		user.setEmail("email");
		user.setFirstName("fname");
		user.setLastName("lname");
		user.setLogin("login");
		user.setPassoword("pass");
		user.setPasswordHash("passHash");
		getTestService().test(user);
		
		user = getTestService().getUser();
		System.out.println(user);
		
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>" + user;
		return new ModelAndView("welcome", "message", message);
	}

	public TestService getTestService() {
		return testService;
	}

	public void setTestService(TestService testService) {
		this.testService = testService;
	}
}
