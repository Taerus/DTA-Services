package com.dta.services.controller;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
import com.dta.services.service.IUserService;


/**
 * 
 * Advert's controller with all method for simple user
 * 
 * @author Hugo Dumont
 *
 */
@Controller
@RequestMapping("/")
public class AdvertController {
	
	/*Services' definitions*/
		@Autowired
		IAdvertService advertService;
		
		@Autowired
		IUserService userService;
	
	
	/*Usercases' definitions*/
		@ModelAttribute(value="user")
		public User user(){
			return new User();
		}
		
		@ModelAttribute(value="advert")
		public Advert advert(){
			return new Advert();
		}
	
	
	/*Root to home page*/
	@RequestMapping
	public String home(Model model){
		
		return "Home";
	}
	
	
	/*Root to listing all adverts*/
	@RequestMapping(value = "adverts")
	public String listAdverts(Model model) {

		return "Advertsview";
	}

	
	/*Root to show the form add of adverts*/
	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "advert/new", method = RequestMethod.GET)
	public String postAdvert(Model model, Principal principal) {

		List<Category> categories = advertService.getAllCategory();
		model.addAttribute("categories", categories);
		
		model.addAttribute("advert", new Advert());
			
		return "PostAdvert";
	}

	
	/*Root to adding/updating adverts*/
	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "advert/new", method = RequestMethod.POST)
	public String postAdvert(@Valid Advert advert, BindingResult bindingResult, Model model, Principal principal) {

		if (bindingResult.hasErrors()) { //Testing for error
			return "Advertsview";
		}
		
		List<Category> categories = advertService.getAllCategory(); //Getting all existing categories
		Advert advertCurrent = advertService.getAdvertById(advert.getId()); //Getting the id of current advert
		
		if (advertCurrent != null) { //Edit part, advert already exits
			/*Keeping date, user, type of the origin's advert*/
			Date date = advertCurrent.getCreation();
			User user = advertCurrent.getAuthor();
			AdvertType type = advertCurrent.getType();
			
			/*Adding all origin's information*/
			advert.setType(type);
			advert.setCreation(date);
			advert.setAuthor(user);
			
			/*Using the update service*/
			advertService.editAdvert(advert);
		} 
		else { //Create part, advert doesn't already exist
			/*Recovery the author of the advert*/
			String login = principal.getName();
			User author = userService.getByLogin(login);
			
			/*Adding information about the author, the date and the type of the advert*/
			advert.setAuthor(author);
			advert.setType(AdvertType.ADVERT);
			advert.setCreation(new Date());
			
			/*Using the add service*/
			advertService.createAdvert(advert);
		}

		/*Testing for connected user*/
		if(principal != null){
			/*Recovery the current user*/
			String login = principal.getName();
			User currentUser = userService.getByLogin(login);
			
			if(advert.getAuthor().getId()==currentUser.getId()){ //Allows the user to delete or update his advert
				model.addAttribute("isAuthor",true);
			}
		}	
		
		/*Return the values to display*/
		model.addAttribute("categories", categories); //Categories
		model.addAttribute("myAdvert", advert); //Current advert

		return "Advertshow";
	}

	
	/*Root to show the complete details of an advert*/
	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "advert/show/{id}", method = RequestMethod.GET)
	public String showAdvert(@PathVariable long id, Model model,Principal principal) {
		
		List<Category> categories = advertService.getAllCategory(); //Getting all existing categories
		Advert advert = advertService.getAdvertById(id); //Getting current advert
		
		/*Testing for connected user*/
		if(principal != null){
			/*Recovery the current user*/
			String login = principal.getName();
			User currentUser = userService.getByLogin(login);
			
			if(advert.getAuthor().getId()==currentUser.getId()){ //Allows the user to delete or update his advert
				model.addAttribute("isAuthor",true);
			}
		}	

		/*Return the values to display*/
		model.addAttribute("categories", categories); //Categories
		model.addAttribute("myAdvert", advert); //Current advert
		
		return "Advertshow";
	}

	
	/*Root to delete an advert*/
	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "advert/delete/{id}", method = RequestMethod.GET)
	public String deleteAdvert(@PathVariable long id, Model model, Principal principal) {

		/*Testing for connected user*/
		if(principal != null){
			/*Recovery the current user*/
			String login = principal.getName();
			User currentUser = userService.getByLogin(login);
			
			Advert advert = advertService.getAdvertById(id); //Getting current advert
			
			if(advert.getAuthor().getId()==currentUser.getId()){ //Allows the user to delete his advert
				advertService.deleteAdvert(id);
			}
		}	

		return "Advertsview";
	}

}
