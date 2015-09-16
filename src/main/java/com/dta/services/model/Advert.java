package com.dta.services.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Advert {

	/*Attributes*/
	@Id
	@GeneratedValue
	private long id;
	
	private String title;
	
	private Date creation;
	
	private String description;
	
	private int price;
	
	private AdvertType type;
	
	private Category category; 
	
	
	/*Constructors*/
    public Advert() {
    }
    
    public Advert(String title, Date creation, String description, int price, AdvertType type, Category category) {
		this.title = title;
		this.creation = creation;
		this.description = description;
		this.price = price;
		this.type = type;
		this.category = category;
	}


	/*Getters*/
    public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Date getCreation() {
		return creation;
	}

	public String getDescription() {
		return description;
	}

	public int getPrice() {
		return price;
	}
	
	public AdvertType getType() {
		return type;
	}
	
	public Category getCategory() {
		return category;
	}


	/*Setters*/
	public void setId(long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCreation(Date creation) {
		this.creation = creation;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setType(AdvertType type) {
		this.type = type;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}
