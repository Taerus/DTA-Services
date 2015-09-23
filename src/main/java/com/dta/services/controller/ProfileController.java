package com.dta.services.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dta.services.model.User;
import com.dta.services.service.IUserService;

@Controller
@Secured("isAuthenticated()")
@RequestMapping(value="/profile")
public class ProfileController {
	
	@Autowired
	private IUserService userService;
	
	@ModelAttribute(value="user")
	public User user(){
		return new User();
	}	 
	
	@Secured("isAuthenticated()")
	@RequestMapping(value="")
	public String viewProfile(Model model,Principal principal){
		String login = principal.getName();
		
		model.addAttribute("userProfile",userService.getByLogin(login));
		
		return "Profile";
	}
	
	@Secured("isAuthenticated()")
	@RequestMapping(value="/edit")
	public String editProfile(){
		return "Editprofile";
	}	
	
	@Secured("isAuthenticated()")
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String saveProfile(){
		return "Profile";
	}
		
}
