package com.dta.services.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
	public User getById(long id) {
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

	@Override
	public User getByLogin(String login) {
		TypedQuery<User> query = em.createQuery("SELECT u from User u Where u.login  = :login",User.class);
		
		query.setParameter("login", login);
		
		return query.getSingleResult();	
	}

}
