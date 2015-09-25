package com.dta.services.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.eclipse.persistence.annotations.UnionPartitioning;
import org.hibernate.validator.constraints.Email;


@Entity
@Cacheable(false)
public class User {

	/*Attributes*/
	@Id
	@GeneratedValue
	private long id;
	
	
	@NotNull
	@Column(unique=true)
	@Size(min=6,max=15)
	private String login;
	
	@NotNull
	@Size(min=6)
	private String password;
	
	private int balance;
	
	@NotNull
	@Email
	@Size(min=1)
	private String email;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date creation;
		
	@Temporal(TemporalType.TIMESTAMP)
	private Date birth;	
	
	@NotNull
	private Department department;
	
	@NotNull
	private Country country;
	
	@OneToMany(mappedBy="author",cascade=CascadeType.PERSIST)
	private List<Advert> adverts;
	
	private boolean enabled;
	
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

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	@JsonIgnore
	public int getBalance() {
		return balance;
	}

	public String getEmail() {
		return email;
	}
	
	@JsonIgnore
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@JsonIgnore
	public List<Advert> getAdverts() {
		return adverts;
	}

	public void setAdverts(List<Advert> adverts) {
		this.adverts = adverts;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
	
	

}
