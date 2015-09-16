package com.dta.services.dao;

import java.util.List;

import com.dta.services.model.Message;

public interface IMessageDao {
	void create(Message message);
	Message getById(long id);
	List<Message> list();
	void update(Message message);
	void delete(int id);
}
