package com.dta.services.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.dta.services.model.Category;

public class CategoryDaoImpl implements ICategoryDao {

	@Autowired
	EntityManager em;
	
	@Override
	public void create(Category category) {
		// TODO Auto-generated method stub
		em.persist(category);
	}

	@Override
	public Category getById(int id) {
		// TODO Auto-generated method stub
		return em.find(Category.class, id);
	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		Query req = em.createQuery("SELECT c FROM Category c");
		return req.getResultList();
	}

	@Override
	public void update(Category category) {
		// TODO Auto-generated method stub
		em.merge(category);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Category category = em.find(Category.class, id);
		em.remove(category);
	}

}
