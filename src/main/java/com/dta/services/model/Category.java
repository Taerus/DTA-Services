package com.dta.services.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {

	/*Attributes*/
	@Id
	@GeneratedValue
	private long id;
	
	private String name;

	@OneToMany(mappedBy = "category")
	private List<Advert> adverts;
	
	
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
