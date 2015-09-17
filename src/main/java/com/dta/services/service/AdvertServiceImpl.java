package com.dta.services.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dta.services.dao.IAdvertDao;
import com.dta.services.model.Advert;
import org.springframework.transaction.annotation.Transactional;

@Service("advertService")
@Transactional
public class AdvertServiceImpl implements IAdvertService {
	private final static Logger logger = LogManager.getLogger();

	@Autowired
	private IAdvertDao advertDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Advert> list() {
		return advertDao.list();
	}

	@Override
	public void createAdvert(Advert advert) {
		advertDao.create(advert);
		logger.debug("advert created : {}", advert);
	}

}
