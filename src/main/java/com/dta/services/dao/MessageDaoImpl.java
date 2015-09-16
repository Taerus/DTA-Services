package com.dta.services.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.dta.services.model.Message;

public class MessageDaoImpl implements IMessageDao {
	@Autowired
	EntityManager em;

	@Override
	public void create(Message message) {
		em.persist(message);
	}

	@Override
	public Message getById(int id) {
		return em.find(Message.class, id);
	}

	@Override
	public List<Message> list() {
		return em.createQuery("SELECT m FROM Message m").getResultList();
	}

	@Override
	public void update(Message message) {
		em.merge(message);
	}

	@Override
	public void delete(int id) {
		em.remove(em.find(Message.class, id));
	}

}
