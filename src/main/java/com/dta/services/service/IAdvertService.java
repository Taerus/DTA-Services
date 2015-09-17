package com.dta.services.service;

import java.util.List;

import com.dta.services.model.Advert;

public interface IAdvertService {

	public List<Advert> list();

	public void createAdvert(Advert advert);
	
}
