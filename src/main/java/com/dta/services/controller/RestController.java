package com.dta.services.controller;

import java.security.Principal;
import java.util.List;

import com.dta.services.model.PrivateMessage;
import com.dta.services.model.*;
import com.dta.services.service.IAdvertService;
import com.dta.services.service.IMessageService;
import com.dta.services.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
	public List<ReceivedMessage> getUserReceivedMessages(@PathVariable("user_id") long userId) {
		return messageService.listReceivedPrivateMessages(userId);
	}

	@RequestMapping(value = "/user/{user_id}/message/sent", method = RequestMethod.GET)
	@ResponseBody
	public List<SentMessage> getUserSentMessages(@PathVariable("user_id") long userId) {
		return messageService.listSentPrivateMessages(userId);
	}

	@RequestMapping(value = "/message/sent/{id}")
    @ResponseStatus(HttpStatus.OK)
	public void deleteSentMessage(@PathVariable("id") long id) {
		messageService.deleteSentMessage(id);
	}

    @RequestMapping(value = "/message/received/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteReceivedMessage(@PathVariable("id") long id) {
        messageService.deleteReceivedMessage(id);
    }
	
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@RequestMapping(value="/user/balance", method=RequestMethod.GET)
	@ResponseBody
	public int getBalance(Principal principal){
		return userService.getByLogin(principal.getName()).getBalance();
	}
	
	
}
