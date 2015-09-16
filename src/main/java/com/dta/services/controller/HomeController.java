package com.dta.services.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value="/")
public class HomeController {

	@RequestMapping
	public String home(){
		return "Home";
	}
	
	@RequestMapping(value="adverts")
	public String listAdverts(){
		return "Advertsview";
	}
}
