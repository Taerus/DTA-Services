package com.dta.services.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.dta.services.model.Role;
import com.dta.services.model.User;
import com.dta.services.service.IUserService;


public class TestUserService {
	private ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
	
	@Test
	public void create(){
		IUserService userService = (IUserService) context.getBean("userService");
		
		User user = new User();
		user.setLogin("toto");
		user.setPassword("test");
		user.setEmail("test@test.fr");
		user.setBalance(0);
		user.setRole(Role.USER);
		
		userService.createUser(user);
		
		assertEquals(userService.getAll().size(),1);
		
	}
}
