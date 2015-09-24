package com.dta.services.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dta.services.model.Advert;
import com.dta.services.model.AdvertType;
import com.dta.services.model.Category;
import com.dta.services.model.User;
import com.dta.services.service.IAdvertService;

@Controller
@RequestMapping("/")
public class AdvertController {
	@Autowired
	IAdvertService advertService;
	
	
	/*
	 * Trucs chiants
	 */
	
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
		
		return "Home";
	}
	
	@RequestMapping(value = "adverts")
	public String listAdverts(Model model) {

		return "Advertsview";
	}

	@Secured("hasAnyRole('USER', 'ADMIN')")
	@RequestMapping(value = "advert/new", method = RequestMethod.GET)
	public String postAdvert(Model model) {

		List<Category> categories = advertService.getAllCategory();
		model.addAttribute("categories", categories);

		model.addAttribute("advert", new Advert());

		return "PostAdvert";
	}

	@Secured("hasAnyRole('USER', 'ADMIN')")
	@RequestMapping(value = "advert/new", method = RequestMethod.POST)
	public String postAdvert(@Valid Advert advert, BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {
			return "Advertsview";
		}

		Advert advertCurrent = advertService.getAdvertById(advert.getId());
		if (advertCurrent != null) {
			advert.setType(AdvertType.ADVERT);
			advert.setCreation(new Date());
			advertService.editAdvert(advert);
		} else {
			advert.setType(AdvertType.ADVERT);
			advert.setCreation(new Date());
			advertService.createAdvert(advert);
		}

		model.addAttribute("myAdvert", advert);

		return "Advertshow";
	}

	@RequestMapping(value = "advert/show/{id}", method = RequestMethod.GET)
	public String showAdvert(@PathVariable long id, Model model) {

		List<Category> categories = advertService.getAllCategory();
		model.addAttribute("categories", categories);

		Advert advert = advertService.getAdvertById(id);
		model.addAttribute("myAdvert", advert);

		return "Advertshow";
	}

	@RequestMapping(value = "advert/delete/{id}", method = RequestMethod.GET)
	public String deleteAdvert(@PathVariable long id, Model model) {

		advertService.deleteAdvert(id);

		return "Advertsview";
	}
}
