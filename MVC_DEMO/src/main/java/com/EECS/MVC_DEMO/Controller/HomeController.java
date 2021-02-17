package com.EECS.MVC_DEMO.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;

@Controller
public class HomeController {
    private MessageListService messageListService;

    public HomeController(MessageListService messageListService)
    {
        this.messageListService = messageListService;
    }

    @GetMapping("/home")
    public String getHomePage(@ModelAttribute("newMessage") MessageForm newMessage, Model model)
    {
        //model.addAttribute("welcomeMessage", Instant.now().toString());
        //model.addAttribute("greetings", new String[]{"Hi", "Hello", "Good Bye!"});
        //model.addAttribute("greetings", this.messageListService.getMessages());
        System.out.println("getHomePage called");
        model.addAttribute("greetings", this.messageListService.getMessages());
        return "home";
    }

    @PostMapping("/home")
    public String addMessage(@ModelAttribute("newMessage") MessageForm newMessage, Model model)
    {
        System.out.println("addMessage called");
        //System.out.println("Model attributes" + model.asMap().get("home").equals(messageForm));
        messageListService.addMessage(newMessage.getText());
        model.addAttribute("greetings", this.messageListService.getMessages());
        newMessage.setText("");
        return "home";
    }
}
