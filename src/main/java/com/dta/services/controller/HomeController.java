package com.dta.services.controller;

import javax.validation.Valid;

import com.dta.services.model.*;
import com.dta.services.service.IAdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import com.dta.services.service.IUserService;
import com.dta.services.utils.PasswordEncoder;

import java.util.Date;


@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private IUserService userService;

	@Autowired
	private IAdvertService advertService;

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
	
	@RequestMapping(value="register",method=RequestMethod.POST)
	public String registerUser(@Valid User user,BindingResult bindingResult){
		
		if(bindingResult.hasErrors()){
			return "Home";
		}
		
		user.setBalance(0);
		user.setRole(Role.USER);
		user.setPassword(passwordEncoder.encodePassword(user.getPassword(),null));
		
		userService.createUser(user);
		
		return "Registered";
	}
	
	@RequestMapping(value="users",method=RequestMethod.GET)
	public String viewUsers(){
		return "Usersview";
	}
	
	@RequestMapping(value="adverts")
	public String listAdverts(){
		return "Advertsview";
	}

	@RequestMapping(value = "advert/new", method = RequestMethod.GET)
	public String postAdvert(Model model) {
        Advert advert = new Advert();
        advert.setPrice(1);

        model.addAttribute("advert", advert);

		return "PostAdvert";
	}

    @RequestMapping(value = "advert/new", method = RequestMethod.POST)
    public String postAdvert(@Valid Advert advert, Model model, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "PostAdvert";
		}

        advert.setType(AdvertType.ADVERT);
        advert.setCreation(new Date());
		advertService.createAdvert(advert);

        return "redirect:/";
    }

}
