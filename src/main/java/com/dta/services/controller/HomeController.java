package com.dta.services.controller;

import javax.validation.Valid;

import com.dta.services.model.AdvertType;
import com.dta.services.service.IAdvertService;

import org.springframework.beans.factory.annotation.Autowired;

import com.dta.services.model.Advert;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dta.services.model.Role;
import com.dta.services.model.User;
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
	public String registerUser(@Valid User user,BindingResult bindingResult,Model model){
		
		if(bindingResult.hasErrors()){
			model.addAttribute("user", user);
			model.addAttribute("showModal",true);
			return "Home";
		}
		
		user.setBalance(0);
		user.setRole(Role.USER);
		user.setCreation(new Date());
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
    
    @RequestMapping(value="user/{id}",method=RequestMethod.GET)
    public String userDetails(@PathVariable("id") Long id,Model model){
    	model.addAttribute("userDetails",userService.get(id));
    	
    	return "Userdetails";
    }

}
