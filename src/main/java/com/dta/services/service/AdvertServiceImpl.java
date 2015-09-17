package com.dta.services.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dta.services.dao.IAdvertDao;
import com.dta.services.model.Advert;

@Service("advertService")
public class AdvertServiceImpl implements IAdvertService {

	@Autowired
	private IAdvertDao advert;
	
	@Override
	public List<Advert> list() {
		// TODO Auto-generated method stub
		return advert.list();
	}

}
