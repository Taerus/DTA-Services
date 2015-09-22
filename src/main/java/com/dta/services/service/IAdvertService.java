package com.dta.services.service;

import java.util.List;

import com.dta.services.model.Advert;
import com.dta.services.model.Category;

public interface IAdvertService {

	public List<Advert> list();
	public void createAdvert(Advert advert);
	public Advert getAdvertById(long id);
	public List<Category> getAllCategory();
	public void deleteAdvert(long id);
	public void editAdvert(Advert advert);
	
}
