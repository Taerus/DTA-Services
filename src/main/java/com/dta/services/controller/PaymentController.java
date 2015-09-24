package com.dta.services.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dta.services.model.User;
import com.dta.services.service.IUserService;

@Controller
public class PaymentController {
	private static final Logger logger = LogManager.getLogger();
	@Autowired
	IUserService userService;

	@ModelAttribute("user")
	public User user() {
		return new User();
	}

	@RequestMapping(value = "/payment/{toId}", method = RequestMethod.GET)
	public String doPayment(@PathVariable("toId") Long toId, Model model) {
		String user = userService.get(toId).getLogin();
		logger.debug(user);
		model.addAttribute("userTo", user);

		return "Paymentview";
	}

}
