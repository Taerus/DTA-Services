package com.dta.services.service;

import java.util.List;

import com.dta.services.model.User;

public interface IUserService {
	public void createUser(User user);
	public List<User> getAll();
	public User get(Long id);
	public User getByLogin(String login);
	public void updateUser(User user);
	public void creditTranfert(User from, User to, int sum);
}
