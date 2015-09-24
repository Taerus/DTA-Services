package com.dta.services.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.dta.services.model.Advert;

/**
 * 
 * Implementation of layout dao of category
 * 
 * @author Hugo Dumont
 *
 */
@Repository("advertDao")
public class AdvertDaoImpl implements IAdvertDao {
	
	/*Definition of an entity manager*/
		@PersistenceContext
		EntityManager em;
	
	
	/*DAOs*/
		/**
		 * Create dao
		 */
		@Override
		public void create(Advert advert) {
			em.persist(advert);
		}
	
		/**
		 * Getting by id dao
		 */
		@Override
		public Advert getById(long id) {
			return em.find(Advert.class, id);
		}
	
		/**
		 * Get all adverts dao
		 */
		@Override
		public List<Advert> list() {
			return em.createQuery("SELECT a FROM Advert a").getResultList();
		}
	
		/**
		 * Update dao
		 */
		@Override
		public void update(Advert advert) {
			em.merge(advert);
	
		}
	
		/**
		 * Delete dao
		 */
		@Override
		public void delete(long id) {
			em.remove(em.find(Advert.class, id));
		}

}
