package com.dta.services.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dta.services.service.IUserService;

@Controller
public class PaymentController {
	@Autowired
	IUserService userService;

	@Secured("isAuthenticated()")
	@RequestMapping(value = "/payment/{toId}", method = RequestMethod.GET)
	public String doPayment(@PathVariable("toId") Long toId, Model model, Principal principal) {
		
		model.addAttribute("user", userService.get(toId));

		return "Paymentview";
	}
}
