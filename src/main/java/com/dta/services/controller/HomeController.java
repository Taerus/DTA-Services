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

import com.dta.services.model.Category;
import com.dta.services.model.Role;
import com.dta.services.model.User;
import com.dta.services.service.IUserService;
import com.dta.services.utils.PasswordEncoder;

import java.util.Date;
import java.util.List;


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
	
	@ModelAttribute(value="advert")
	public Advert advert(){
		return new Advert();
	}
	
	@RequestMapping
	public String home(Model model){
		
		List<Category> categories = advertService.getAllCategory();
		model.addAttribute("categories", categories);
		
		return "Home";
	}
	
	@RequestMapping(value="register",method=RequestMethod.POST)
	public String registerUser(@Valid User user,BindingResult bindingResult, Model model){
		
		if(bindingResult.hasErrors()){
			return "Home";
		}
		
		user.setBalance(0);
		user.setRole(Role.USER);
		user.setPassword(passwordEncoder.encodePassword(user.getPassword(),null));
		
		userService.createUser(user);
		
		model.addAttribute("user",new User());
		
		return "Registered";
	}
	
	@RequestMapping(value="users",method=RequestMethod.GET)
	public String registerUser(Model model){
		
		List<Category> categories = advertService.getAllCategory();
		model.addAttribute("categories", categories);
		
		return "Usersview";
	}
	
	@RequestMapping(value="adverts")
	public String listAdverts(Model model){
		
		List<Category> categories = advertService.getAllCategory();
		model.addAttribute("categories", categories);
		
		return "Advertsview";
	}

    @RequestMapping(value = "advert/new", method = RequestMethod.POST)
    public String postAdvert(@Valid Advert advert, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "Advertsview";
		}
		
        advert.setType(AdvertType.ADVERT);
        advert.setCreation(new Date());
		advertService.createAdvert(advert);
		
		model.addAttribute("advert", new Advert());
		model.addAttribute("myAdvert", advert);

        return "Advertshow";
    }
    
    @RequestMapping(value="advert/show/{id}", method = RequestMethod.GET)
    public String showAdvert(@PathVariable long id, Model model){
    	
    	Advert advert = advertService.getAdvertById(id);
    	
    	model.addAttribute("myAdvert", advert);
    	
    	return "Advertshow";
    }
    
    @RequestMapping(value="advert/delete/{id}", method = RequestMethod.GET)
    public String deleteAdvert(@PathVariable long id, Model model){
    	
    	advertService.deleteAdvert(id);
    	
    	return "Advertsview";
    }

}
