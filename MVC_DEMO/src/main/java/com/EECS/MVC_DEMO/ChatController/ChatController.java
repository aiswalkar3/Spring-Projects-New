package com.EECS.MVC_DEMO.ChatController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class ChatController {
    private ChatService chatService;

    public ChatController(ChatService chatService)
    {
        this.chatService = chatService;
    }

    @GetMapping
    public String getMessages(@ModelAttribute("userMessage") ChatForm chatForm, Model model)
    {
        model.addAttribute("messageList",chatService.getMessages());
        return "chat";
    }

    @PostMapping
    public String postMessage(@ModelAttribute("userMessage") ChatForm chatForm, Model model)
    {
        //also we can set the ChatForm to service class and have the below logic written there.
        if(chatForm.getMessageType() == 'U')
        {
            chatService.addMessage(chatForm.getUsername(),chatForm.getMessageText().toUpperCase());
        }
        else if(chatForm.getMessageType() == 'L')
        {
            chatService.addMessage(chatForm.getUsername(),chatForm.getMessageText().toLowerCase());
        }
        else{
            chatService.addMessage(chatForm.getUsername(),chatForm.getMessageText());
        }

        model.addAttribute("messageList",chatService.getMessages());
        chatForm.setUsername("");
        chatForm.setMessageText("");
        chatForm.setMessageType('N');
        return "chat";
    }
    /*
    //good way to fill the dropdowns. In this way with change in the dropdown values, no need to change UI.
    @ModelAttribute("allMessageTypes")
    public String[] allMessageTypes()
    {
        return new String[]{"Say", "Shout", "Whisper"};
    }
    */
}
