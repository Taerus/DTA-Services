package com.dta.services.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.dta.services.model.User;

@Repository("userDao")
public class UserDaoImpl implements IUserDao {
	@PersistenceContext
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
