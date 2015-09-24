package com.dta.services.dao;

import java.util.List;

import com.dta.services.model.Advert;

/**
 * 
 * Interface of dao layout for category
 * 
 * @author Hugo Dumont
 *
 */
public interface IAdvertDao {
	void create(Advert advert);
	List<Advert> list();
	void update(Advert advert);
	void delete(long id);
	Advert getById(long id);
}
