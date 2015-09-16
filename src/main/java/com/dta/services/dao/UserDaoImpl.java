package com.dta.services.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.dta.services.model.User;

public class UserDaoImpl implements IUserDao {
	@Autowired
	EntityManager em;
	
	@Override
	public void create(User user) {
		em.persist(user);
	}

	@Override
	public User getById(int id) {
		return em.find(User.class, id);
	}

	@Override
	public List<User> list() {
		return em.createQuery("SELECT u FROM User u").getResultList();
	}

	@Override
	public void update(User user) {
		em.merge(user);
	}

	@Override
	public void delete(int id) {
		em.remove(em.find(User.class, id));
	}

}
