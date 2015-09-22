package com.dta.services.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dta.services.dao.ICategoryDao;
import com.dta.services.model.Category;

public class TestCategory {

	private ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
	
	@Test
	public void create(){
		ICategoryDao categoryDao = (ICategoryDao) context.getBean("categoryDao");
		
		Category c1 = new Category();
		c1.setId(1);
		c1.setName("électronique");
		
		Category c2 = new Category();
		c2.setId(150);
		c2.setName("musique");
		

		categoryDao.create(c1);
		categoryDao.create(c2);
		
	}
}
