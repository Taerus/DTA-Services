package com.dta.services.dao;

import java.util.List;

import com.dta.services.model.Category;

/**
 * 
 * Interface of dao layout of category
 * 
 * @author Hugo Dumont
 *
 */
public interface ICategoryDao {
	void create(Category category);
	Category getById(long id);
	List<Category> list();
	void update(Category category);
	void delete(int id);
}
