package com.dta.services.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dta.services.model.PrivateMessage;

@Repository("privateMessageDao")
public class PrivateMessageDaoImpl implements IPrivateMessageDao {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public void create(PrivateMessage privateMessage) {
		// TODO Auto-generated method stub
		em.persist(privateMessage);
	}

	@Override
	public PrivateMessage getById(int id) {
		// TODO Auto-generated method stub
		return em.find(PrivateMessage.class, id);
	}

	@Override
	public List<PrivateMessage> list() {
		// TODO Auto-generated method stub
		Query req = em.createQuery("SELECT p FROM PrivateMessage p");
		return req.getResultList();
	}

	@Override
	public void update(PrivateMessage privateMessage) {
		// TODO Auto-generated method stub
		em.merge(privateMessage);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		PrivateMessage privateMessage = em.find(PrivateMessage.class, id);
		em.remove(privateMessage);
	}

}
