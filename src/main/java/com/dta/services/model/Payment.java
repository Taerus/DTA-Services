package com.dta.services.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Payment {

	/*Attributes*/
	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne
	private User userFrom;
	
	@ManyToOne
	private User userTo;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date creation;
	
	@NotNull
	private int amount;
	
	@Enumerated(EnumType.STRING)
	private StatePayment state;
	
	/*Constructors*/
    public Payment() {
    }

	public Payment(User userFrom, User userTo, int amount, StatePayment state) {
		this.userFrom = userFrom;
		this.userTo = userTo;
		this.creation = new Date();
		this.amount = amount;
		this.state = state;
	}

	
	/*Getters*/
	public long getId() {
		return id;
	}

	public User getUserFrom() {
		return userFrom;
	}

	public User getUserTo() {
		return userTo;
	}

	public Date getCreation() {
		return creation;
	}

	public int getAmount() {
		return amount;
	}

	public StatePayment getState() {
		return state;
	}

	
	/*Setters*/
	public void setId(long id) {
		this.id = id;
	}

	public void setUserFrom(User userFrom) {
		this.userFrom = userFrom;
	}

	public void setUserTo(User userTo) {
		this.userTo = userTo;
	}

	public void setCreation(Date creation) {
		this.creation = creation;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setState(StatePayment state) {
		this.state = state;
	}
    
}
