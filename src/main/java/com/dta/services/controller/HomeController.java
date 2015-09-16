package com.dta.services.controller;

import com.dta.services.model.Advert;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@RequestMapping
	public String home(){
		return "Home";
	}

	@RequestMapping(value = "advert/new", method = RequestMethod.GET)
	public String postAdvert(Model model) {
        model.addAttribute("advert", new Advert());

		return "PostAdvert";
	}

    @RequestMapping(value = "advert/new", method = RequestMethod.POST)
    public String postAdvert(Advert advert, Model model) {
        // TODO persist new advert

        return "redirect:/DTA-Services/";
    }

}
