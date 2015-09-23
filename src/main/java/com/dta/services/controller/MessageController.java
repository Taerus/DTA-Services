package com.dta.services.controller;

import com.dta.services.model.PrivateMessage;
import com.dta.services.model.User;
import com.dta.services.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Date;

@Controller
public class MessageController {

    @Autowired
    private IMessageService messageService;

    @ModelAttribute(value="user")
    public User user(){
        return new User();
    }

    @RequestMapping(value = "/message/new", method = RequestMethod.GET)
    public String writeMessage(Model model) {
        PrivateMessage message = new PrivateMessage();

        model.addAttribute("message", message);

        return "NewPrivateMessage";
    }

    @RequestMapping(value = "/message/send", method = RequestMethod.POST)
    public String sendMessage(@Valid PrivateMessage message, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "NewPrivateMessage";
        }

        message.setAuthor(getLoggedUser());
        message.setCreationDate(new Date());
        messageService.postMessage(message);

        return "Home";
    }

    @RequestMapping(value = "/user/messages", method = RequestMethod.GET)
    public String getUserMessages(Model model) {

        User user = getLoggedUser();
        if (user != null) {
            user.getId();
        }

        return "ListPrivateMessages";
    }

    private User getLoggedUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Object user = (auth != null) ? auth.getPrincipal() :  null;

        //return (user instanceof User) ? (User)user : null;
//        return userService.getAll().get(0);
        return new User();
    }
}
