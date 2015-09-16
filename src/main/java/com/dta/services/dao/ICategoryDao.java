package com.dta.services.dao;

import java.util.List;

import com.dta.services.model.Category;

public interface ICategoryDao {
	void create(Category category);
	Category getById(long id);
	List<Category> list();
	void update(Category category);
	void delete(int id);
}
