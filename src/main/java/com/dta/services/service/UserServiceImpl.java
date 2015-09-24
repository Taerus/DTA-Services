package com.dta.services.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dta.services.dao.IUserDao;
import com.dta.services.model.User;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserDao userDao;

	@Transactional(rollbackFor=Exception.class)
	public void createUser(User user) {
		userDao.create(user);		
	}

	@Transactional(readOnly=true)
	public List<User> getAll() {
		return userDao.list();
	}

	@Transactional(readOnly=true)
	public User get(Long id) {
		return userDao.getById(id);
	}

	@Transactional(readOnly=true)
	public User getByLogin(String login) {
		return userDao.getByLogin(login);
	}

}
