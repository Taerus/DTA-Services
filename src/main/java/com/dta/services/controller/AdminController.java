package com.dta.services.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dta.services.model.Advert;
import com.dta.services.model.User;
import com.dta.services.service.IAdvertService;
import com.dta.services.service.IUserService;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAnyRole('ADMIN')")
public class AdminController {

	@Autowired
	IAdvertService advertService;
	
	@Autowired
	IUserService userService;
	
	@ModelAttribute(value="advert")
	public Advert advert(){
		return new Advert();
	}
	
	@ModelAttribute(value="user")
	public User user(){
		return new User();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "advert/deleteSelected", method = RequestMethod.POST)
	public String deleteAdvertsSelected(Model model){
		
		model.addAttribute("isAdmin",true);
		
		return "Advertsview";
	}
	
	/*Root to listing all adverts*/
	@RequestMapping(value = "/adverts")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public String listAdverts(Model model) {

		model.addAttribute("isAdmin",true);
		
		return "Advertsview";
	}
}
