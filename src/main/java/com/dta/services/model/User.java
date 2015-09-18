package com.dta.services.model;

import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class User {

	/*Attributes*/
	@Id
	@GeneratedValue
	private long id;
	
	@NotNull
	private String login;
	
	@NotNull	
	private String password;
	
	private int balance;
	
	@NotNull
	private String email;
	
	private Role role;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date creation;
		
	@Temporal(TemporalType.TIMESTAMP)
	private Date birth;	
	
	@NotNull
	private String department;
	
	@NotNull
	private String country;
	
	/*Constructors*/
    public User() {
    }
    
	public User(String login, String password, int balance, String email, Role role) {
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

	public Date getCreation() {
		return creation;
	}

	public void setCreation(Date creation) {
		this.creation = creation;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	

}
