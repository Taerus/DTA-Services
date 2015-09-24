package com.dta.services.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * 
 * Entity for an advert
 * 
 * @author Hugo Dumont
 *
 */
@Entity
public class Advert {

	/*Attributes*/
		@Id
		@GeneratedValue
		private long id; //Id to recover an advert

		private String title; //Title for an advert
		
		private Date creation; //Date of creation of an advert
	
		@Column(length = 4096)
		private String description; //Description of an advert
		
		private int price; //Price assignes to an advert
		
		private AdvertType type; //Type of the advert
	
		@ManyToOne
		@JoinColumn(name = "category_id")
		private Category category; //Category associated
		
		@ManyToOne
		@JoinColumn(name="author_id")
		private User author; //User associated
	
		
	/*Constructors*/
		/**
		 * Default constructor of the entity advert
		 */
	    public Advert() {
	    }
	    
	    /**
	     * Constructor with parameters for the entity advert
	     * 
	     * @param title
	     * @param creation
	     * @param description
	     * @param price
	     * @param type
	     * @param category
	     */
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
	
		public User getAuthor() {
			return author;
		}
	
		public void setAuthor(User author) {
			this.author = author;
		}
	
}
