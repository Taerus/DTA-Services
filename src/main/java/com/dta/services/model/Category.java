package com.dta.services.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.eclipse.persistence.annotations.CascadeOnDelete;

@Entity
public class Category {

	/*Attributes*/
	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	@OneToMany( mappedBy = "category", cascade = CascadeType.ALL)
	@CascadeOnDelete
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
