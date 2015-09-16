package com.dta.services.dao;

import java.util.List;

import com.dta.services.model.User;

public interface IUserDao {
	void create(User user);
	User getById(int id);
	List<User> list();
	void update(User user);
	void delete(int id);
}
