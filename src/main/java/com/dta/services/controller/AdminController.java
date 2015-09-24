package com.dta.services.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dta.services.model.Advert;
import com.dta.services.model.User;
import com.dta.services.service.IAdvertService;

@Controller
@RequestMapping("/")
public class AdminController {

	@Autowired
	IAdvertService advertService;
	
	@ModelAttribute(value="advert")
	public Advert advert(){
		return new Advert();
	}
	
	@ModelAttribute(value="user")
	public User user(){
		return new User();
	}
	
	@PreAuthorize("IS_AUTHENTICATED")
	@RequestMapping(value = "advert/deleteSelected", method = RequestMethod.GET)
	public String deleteAdvertsSelected(){
		return "Advertsview";
	}
}
