package com.dta.services.dao;

import java.util.List;

import com.dta.services.model.AdvertMessage;

public interface IAdvertMessageDao {
	void create(AdvertMessage advertMessage);
	AdvertMessage getById(int id);
	List<AdvertMessage> list();
	void update(AdvertMessage advertMessage);
	void delete(int id);
}
