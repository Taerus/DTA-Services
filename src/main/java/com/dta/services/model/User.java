package com.dta.services.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

	/*Attributes*/
	@Id
	@GeneratedValue
	private long id;
	
	private String login;
	
	private String password;
	
	private int balance;
	
	private String email;
	
	private Role role;
	
	
	/*Constructors*/
    public User() {
    }

	public User(long id, String login, String password, int balance,
			String email, Role role) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.balance = balance;
		this.email = email;
		this.role = role;
	}

	
	/*Getters*/
	public long getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public int getBalance() {
		return balance;
	}

	public String getEmail() {
		return email;
	}

	public Role getRole() {
		return role;
	}

	
	/*Setters*/
	public void setId(long id) {
		this.id = id;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
