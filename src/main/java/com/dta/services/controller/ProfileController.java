package com.dta.services.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dta.services.model.User;
import com.dta.services.service.IUserService;


@Controller
@PreAuthorize("hasAnyRole('USER','ADMIN')")
@RequestMapping(value="/profile")
public class ProfileController {
	
	@Autowired
	private IUserService userService;
	
	@ModelAttribute(value="user")
	public User user(){
		return new User();
	}	 
	
	@RequestMapping(value="")
	public String viewProfile(Model model,Principal principal){
		String login = principal.getName();		
			
		model.addAttribute("userProfile",userService.getByLogin(login));
		
		return "Profile";
	}
	
	@RequestMapping(value="/edit")
	public String editProfile(Model model,Principal principal){
		String login = principal.getName();		
		
		model.addAttribute("userProfile",userService.getByLogin(login));
		
		return "Editprofile";
	}	
	
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String saveProfile(@Valid User userProfile,BindingResult bindingResult,Model model,Principal principal){
		String login = principal.getName();	
		User user = userService.getByLogin(login);			
		
		if(bindingResult.hasErrors()){
			return "Editprofile";
		}
		
		user.setDepartment(userProfile.getDepartment());
		user.setCountry(userProfile.getCountry());
		user.setEmail(userProfile.getEmail());
		
		userService.updateUser(user);
		
		model.addAttribute("userProfile",user);
		model.addAttribute("edited",true);
		
		return "Profile";
	}
		
}
