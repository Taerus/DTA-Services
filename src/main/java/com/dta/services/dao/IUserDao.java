package com.dta.services.dao;

import java.util.List;

import com.dta.services.model.User;

public interface IUserDao {
	void create(User user);
	User getById(long id);
	List<User> list();
	void update(User user);
	void delete(int id);
	public User getByLogin(String login);
}
