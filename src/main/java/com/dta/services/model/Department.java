package com.dta.services.model;

public enum Department {
	EURE("Eure"),
	LOIRE_ATLANTIQUE("Loire-Atlantique"),
	PUY_DE_DOME("Puy-de-Dôme");
	
	private final String name;
	
	Department(String name) {
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
}
