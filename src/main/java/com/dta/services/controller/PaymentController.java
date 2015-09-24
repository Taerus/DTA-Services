package com.dta.services.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dta.services.model.User;
import com.dta.services.service.IUserService;

@Controller
public class PaymentController {
	@Autowired
	IUserService userService;

	@ModelAttribute("user")
	public User user() {
		return new User();
	}

	@RequestMapping(value = "/payment/{toId}", method = RequestMethod.GET)
	public String doPayment(@PathVariable("toId") Long toId, Model model) {
		User user = userService.get(toId);
		model.addAttribute("userTo", user);

		return "Paymentview";
	}
	
	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	public String Pay(@RequestParam("toId") Long toId, @RequestParam("credits") int credits, Principal principal) {
		User userFrom = userService.getByLogin(principal.getName());
		User userTo = userService.get(toId);
		
		userService.creditTranfert(userFrom, userTo, credits);
		
		return "redirect:/user/" + toId;
	}

}
