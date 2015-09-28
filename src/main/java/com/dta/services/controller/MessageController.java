package com.dta.services.controller;

import com.dta.services.model.PrivateMessage;
import com.dta.services.model.SentMessage;
import com.dta.services.model.User;
import com.dta.services.service.IMessageService;
import com.dta.services.service.IUserService;
import com.dta.services.utils.MessageForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class MessageController {

    @Autowired
    private IMessageService messageService;

    @Autowired
    private IUserService userService;

    @ModelAttribute(value="user")
    public User user(){
        return new User();
    }

    @RequestMapping(value = "/message/new", method = RequestMethod.GET)
    public String writeMessage(
            @RequestParam("to") Long targetId,
            @RequestParam(value = "re", required = false) Long messageId,
            Model model) {

        ArrayList<Long> targets = new ArrayList<>(5);
        if (targetId != null) targets.add(targetId);

        MessageForm messageForm = new MessageForm();
        messageForm.setTargets(targets);

        if (messageId != null) {
            PrivateMessage message = messageService.getPrivateMessage(messageId);
            messageForm.setSubject("RE:"+message.getTitle());
            messageForm.setContent("\n\n\n" +
                    "=====================================\n" +
                    message.getAuthor().getLogin()+" a écrit ("+message.getCreationDate()+")\n" +
                    "------------------------------------------------------------------\n" +
                    message.getContent());
        }

        model.addAttribute("message", messageForm);

        return "NewPrivateMessage";
    }

    @RequestMapping(value = "/message/send", method = RequestMethod.POST)
    public String sendMessage(@Valid MessageForm messageForm, BindingResult bindingResult, Principal principal) {

        if (bindingResult.hasErrors()) {
            return "NewPrivateMessage";
        }

        ArrayList<User> targets = new ArrayList<>();

        for (Long targetId : messageForm.getTargets()) {
            User target = userService.get(targetId);
            if (target != null) targets.add(target);
        }

        PrivateMessage message = new PrivateMessage();
        message.setAuthor(getLoggedUser(principal));
        message.setTargets(targets);
        message.setCreationDate(new Date());
        message.setTitle(messageForm.getSubject());
        message.setContent(messageForm.getContent());
        messageService.postMessage(message);

        return "redirect:/user/messages";
    }

    @RequestMapping(value = "/user/messages", method = RequestMethod.GET)
    public String getUserMessages(Model model, Principal principal) {

        User user = getLoggedUser(principal);

        model.addAttribute("userId", user.getId());

        return "ListPrivateMessages";
    }

    private User getLoggedUser(Principal principal) {
        return userService.getByLogin(principal.getName());
    }


}
