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
import com.dta.services.model.Role;
import com.dta.services.model.User;
import com.dta.services.service.IAdvertService;
import com.dta.services.service.IUserService;
import com.dta.services.utils.PasswordEncoder;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAnyRole('ADMIN')")
public class AdminController {

	@Autowired
	IAdvertService advertService;
	
	@Autowired
	IUserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
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
	
	@RequestMapping(value = "/advert/new", method = RequestMethod.GET)
	@PreAuthorize("hasAnyRole('ADMIN')")
	public String postAdvert(Model model, Principal principal) {

		List<Category> categories = advertService.getAllCategory();
		model.addAttribute("categories", categories);
		
		model.addAttribute("advert", new Advert());
		model.addAttribute("isAdmin",true);
			
		return "PostAdvert";
	}
	
	@RequestMapping(value = "/advert/new", method = RequestMethod.POST)
	@PreAuthorize("hasAnyRole('ADMIN')")
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
		model.addAttribute("isAdmin",true);

		return "Advertshow";
	}
	
	@RequestMapping(value = "/advert/show/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAnyRole('ADMIN')")
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
		model.addAttribute("isAdmin",true);
		
		return "Advertshow";
	}
	
	@RequestMapping(value = "/advert/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAnyRole('ADMIN')")
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
	
	@RequestMapping(value = "/users")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public String listUsers(Model model) {

		model.addAttribute("isAdmin",true);
		
		return "Usersview";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	@PreAuthorize("hasAnyRole('ADMIN')")
	public String registerUser(@Valid User user,BindingResult bindingResult, Model model){
		
		if(bindingResult.hasErrors()){
			model.addAttribute("user", user);
			model.addAttribute("showModal",true);
			return "Home";
		}
		
		user.setBalance(0);
		user.setRole(Role.USER);
		user.setCreation(new Date());
		user.setPassword(passwordEncoder.encodePassword(user.getPassword(),null));
		user.setEnabled(true);		
		
		try{
			userService.createUser(user);
		}	
		catch(Exception e){
			user.setLogin("");
			user.setPassword("");
			model.addAttribute("user", user);
			model.addAttribute("showModal",true);
			model.addAttribute("errorMessage",true);
			return "Home";
		}		
		
		model.addAttribute("isAdmin",true);
		model.addAttribute("user",new User());
		model.addAttribute("isAdmin",true);
		
		return "Registered";
	}
	
	@RequestMapping(value="user/{id}",method=RequestMethod.GET)
	@PreAuthorize("hasAnyRole('ADMIN')")
    public String userDetails(@PathVariable("id") Long id,Model model){
    	model.addAttribute("userDetails",userService.get(id));
    	
    	model.addAttribute("isAdmin",true);
    	return "Userdetails";
    }
}
