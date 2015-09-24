package com.dta.services.dao;

import java.util.List;

import com.dta.services.model.Advert;

public interface IAdvertDao {
	void create(Advert advert);
	List<Advert> list();
	void update(Advert advert);
	void delete(long id);
	Advert getById(long id);
}
