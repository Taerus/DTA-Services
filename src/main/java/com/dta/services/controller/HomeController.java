package com.dta.services.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dta.services.model.Role;
import com.dta.services.model.User;
import com.dta.services.service.IUserService;
import com.dta.services.utils.PasswordEncoder;

@Controller
@RequestMapping(value="/")
public class HomeController {
	@Autowired
	private IUserService userService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@ModelAttribute(value="user")
	public User user(){
		return new User();
	}
	
	@RequestMapping
	public String home(){
		return "Home";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String registerUser(@Valid User user,BindingResult bindingResult){
		
		if(bindingResult.hasErrors()){
			return "Home";
		}
		
		user.setBalance(0);
		user.setRole(Role.USER);
		user.setPassword(passwordEncoder.encodePassword(user.getPassword(),null));
		
		userService.createUser(user);
		
		return "Home";
	}

}
