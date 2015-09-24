package com.dta.services.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dta.services.dao.IAdvertDao;
import com.dta.services.dao.ICategoryDao;
import com.dta.services.model.Advert;
import com.dta.services.model.Category;

/**
 * 
 * Implementation of the advert interface for service layout
 * 
 * @author Hugo Dumont
 *
 */
@Service("advertService")
@Transactional
public class AdvertServiceImpl implements IAdvertService {
	
	/*Definitopn of used services*/
		private final static Logger logger = LogManager.getLogger(); //Control of the logger debugging
	
		@Autowired
		private IAdvertDao advertDao; //Using advert DAO layout
		
		@Autowired
		private ICategoryDao categoryDao; //Using category DAO layout
	
		
	/*Services for advert*/
		/**
		 * Return all advert from the database
		 */
		@Override
		@Transactional(readOnly = true)
		public List<Advert> list() {
			return advertDao.list();
		}
	
		/**
		 * Create a new advert
		 */
		@Override
		public void createAdvert(Advert advert) {
			advertDao.create(advert);
			logger.debug("advert created : {}", advert);
		}
	
		/**
		 * Get an advert from it id
		 */
		@Override
		public Advert getAdvertById(long id) {
			return advertDao.getById(id);
		}
	
		/**
		 * Return all category from the database
		 */
		@Override
		public List<Category> getAllCategory() {
			return categoryDao.list();
		}
	
		/**
		 * Delete an advert with an id
		 */
		@Override
		public void deleteAdvert(long id) {
			advertDao.delete(id);
		}
	
		/**
		 * Update an advert from it id
		 */
		@Override
		public void editAdvert(Advert advert) {
	
			advertDao.update(advert);
		}

}
