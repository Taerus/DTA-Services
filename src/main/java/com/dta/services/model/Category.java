package com.dta.services.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Category {

	/*Attributes*/
	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	
	/*Constructors*/
    public Category() {
    }

	public Category(String name) {
		this.name = name;
	}
    
    
	/*Getters*/
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	
	/*Setters*/
	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
