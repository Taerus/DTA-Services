package com.dta.services.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.dta.services.model.AdvertMessage;

public class AdvertMessageImpl implements IAdvertMessageDao {
	@Autowired
	EntityManager em;
	
	@Override
	public void create(com.dta.services.model.AdvertMessage advertMessage) {
		em.persist(advertMessage);
	}

	@Override
	public AdvertMessage getById(int id) {
		return em.find(AdvertMessage.class, id);
	}

	@Override
	public List<com.dta.services.model.AdvertMessage> list() {
		return em.createQuery("SELECT am FROM AdvertMessage am").getResultList();
	}

	@Override
	public void update(com.dta.services.model.AdvertMessage advertMessage) {
		em.merge(advertMessage);
	}

	@Override
	public void delete(int id) {
		em.remove(em.find(AdvertMessage.class, id));
	}

}
