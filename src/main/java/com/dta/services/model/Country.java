package com.dta.services.model;


public enum Country {
	BELGIUM("Belgium"),
	FRANCE("France"),
	GERMANY("Germany");
	
	
	private final String name;
	
	Country(String name){
		this.name= name;
	}
	
	public String getName(){
		return name;
	}
	
}
