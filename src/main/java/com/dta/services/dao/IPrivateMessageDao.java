package com.dta.services.dao;

import java.util.List;

import com.dta.services.model.PrivateMessage;

public interface IPrivateMessageDao {
	void create(PrivateMessage privateMessage);
	PrivateMessage getById(int id);
	List<PrivateMessage> list();
	void update(PrivateMessage privateMessage);
	void delete(int id);
}
