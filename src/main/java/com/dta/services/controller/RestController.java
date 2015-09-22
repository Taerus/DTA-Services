package com.dta.services.controller;

import java.util.List;

import com.dta.services.model.PrivateMessage;
import com.dta.services.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dta.services.model.Advert;
import com.dta.services.model.User;
import com.dta.services.service.IAdvertService;
import com.dta.services.service.IUserService;

@Controller
@RequestMapping(value="/API")
public class RestController {

	@Autowired
	private IAdvertService advert;
	
	@Autowired
	private IUserService userService;

	@Autowired
	private IMessageService messageService;
	
	@RequestMapping("/users")
	@ResponseBody
	public List<User> getAllUsers(){
		return userService.getAll();
	}
	
	@RequestMapping(value="/adverts", method = RequestMethod.GET)
	@ResponseBody
	public List<Advert> getAdverts () {
		return advert.list();
	}

	@RequestMapping(value = "/user/{user_id}/message/received", method = RequestMethod.GET)
	@ResponseBody
	public List<PrivateMessage> getUserReceivedMessages(@PathVariable("user_id") long userId) {
		return messageService.listReceivedPrivateMessages(userId);
	}

	@RequestMapping(value = "/user/{user_id}/message/sent", method = RequestMethod.GET)
	@ResponseBody
	public List<PrivateMessage> getUserSentMessages(@PathVariable("user_id") long userId) {
		return messageService.listSentPrivateMessages(userId);
	}
	
}
