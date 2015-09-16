package com.dta.services.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Payment {

	/*Attributes*/
	@Id
	@GeneratedValue
	private long id;
	
	private User user1;
	
	private User user2;
	
	private Date creation;
	
	private int amount;
	
	private StatePayment state;
	
	
	/*Constructors*/
    public Payment() {
    }

	public Payment(User user1, User user2, Date creation, int amount, StatePayment state) {
		this.user1 = user1;
		this.user2 = user2;
		this.creation = creation;
		this.amount = amount;
		this.state = state;
	}

	
	/*Getters*/
	public long getId() {
		return id;
	}

	public User getUser1() {
		return user1;
	}

	public User getUser2() {
		return user2;
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

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
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
