package com.dta.services.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.eclipse.persistence.annotations.CascadeOnDelete;

/**
 * 
 * Entity of category
 * 
 * @author Hugo Dumont
 *
 */
@Entity
public class Category {

	/*Attributes*/
		@Id
		@GeneratedValue
		private long id; //Id to recover a category
		
		private String name; //Name of the category
		
		@OneToMany( mappedBy = "category", cascade = CascadeType.ALL)
		@CascadeOnDelete
		private List<Advert> adverts; //List of associated advert
	
		
	/*Constructors*/
		/**
		 * Default constructeur
		 */
	    public Category() {
	    }
	
	    /**
	     * Constructor with parameters
	     * 
	     * @param name
	     */
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
