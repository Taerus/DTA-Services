package com.dta.services.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.dta.services.model.Advert;

@Repository("advertDao")
public class AdvertDaoImpl implements IAdvertDao {
	@PersistenceContext
	EntityManager em;
	
	@Override
	public void create(Advert advert) {
		em.persist(advert);
	}

	@Override
	public Advert getById(int id) {
		return em.find(Advert.class, id);
	}

	@Override
	public List<Advert> list() {
		return em.createQuery("SELECT a FROM Advert a").getResultList();
	}

	@Override
	public void update(Advert advert) {
		em.merge(advert);

	}

	@Override
	public void delete(int id) {
		em.remove(em.find(Advert.class, id));
	}

}
