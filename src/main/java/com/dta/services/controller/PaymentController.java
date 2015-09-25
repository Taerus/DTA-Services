package com.dta.services.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dta.services.model.User;
import com.dta.services.service.IPaymentService;
import com.dta.services.service.IUserService;

@PreAuthorize("isAuthenticated()")
@Controller
public class PaymentController {
	@Autowired
	IUserService userService;
	
	@Autowired
	IPaymentService paymentService;

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
	public String pay(@RequestParam("toId") Long toId,
			@RequestParam("credits") int credits, Principal principal) {
		User userFrom = userService.getByLogin(principal.getName());
		User userTo = userService.get(toId);

		userService.creditTranfert(userFrom, userTo, credits);
		paymentService.creditTransfert(userFrom, userTo, credits);

		return "redirect:/user/" + toId;
	}

	@RequestMapping(value = "/payment/request/{fromId}", method = RequestMethod.GET)
	public String reqPayment(@PathVariable("fromId") long fromId, Model model) {
		User user = userService.get(fromId);
		model.addAttribute("userFrom", user);

		return "PaymentReqview";
	}

	@RequestMapping(value = "/payment/request", method = RequestMethod.POST)
	public String sendReqPayment(@RequestParam("fromId") Long fromId,
			@RequestParam("credits") int credits, Principal principal) {
		User userFrom = userService.getByLogin(principal.getName());
		User userTo = userService.get(fromId);

		paymentService.creditRequest(userFrom, userTo, credits);

		return "redirect:/user/" + fromId;
	}
}
