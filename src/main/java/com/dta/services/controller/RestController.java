package com.dta.services.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dta.services.model.Advert;
import com.dta.services.service.IAdvertService;

@Controller
@RequestMapping(value="/API")
public class RestController {

	@Autowired
	private IAdvertService advert;
	
	@RequestMapping(value="/advert", method = RequestMethod.GET)
	@ResponseBody
	public List<Advert> getAdverts () {
		return advert.list();
	}
	
}
