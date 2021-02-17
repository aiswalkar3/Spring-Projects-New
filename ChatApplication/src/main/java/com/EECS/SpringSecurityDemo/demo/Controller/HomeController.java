package com.EECS.SpringSecurityDemo.demo.Controller;

import com.EECS.SpringSecurityDemo.demo.Model.ChatForm;
import com.EECS.SpringSecurityDemo.demo.Service.MessageListService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
    private MessageListService messageListService;

    public HomeController(MessageListService messageListService)
    {
        this.messageListService = messageListService;
    }

    @GetMapping
    public String getHomePage(@ModelAttribute("messageForm") ChatForm messageForm, Model model)
    {
        model.addAttribute("greetings", messageListService.getMessages());
        return "home";
    }

    @PostMapping
    public String postChatMessage(Authentication authentication, @ModelAttribute("messageForm") ChatForm messageForm,
                                  Model model)
    {
        messageForm.setUsername(authentication.getName());
        messageListService.addMessage(messageForm);
        model.addAttribute("greetings", messageListService.getMessages());
        messageForm.setMessageText("");
        return "home";
    }

    @ModelAttribute("allMessageTypes")
    public String[] allMessageTypes()
    {
        return new String[]{"Say", "Shout", "Whisper"};
    }
}
