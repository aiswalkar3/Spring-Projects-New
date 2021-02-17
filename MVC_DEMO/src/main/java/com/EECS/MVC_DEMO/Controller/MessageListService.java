package com.EECS.MVC_DEMO.Controller;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageListService {
    private List<String> messages;

    public MessageListService(){

    }

    public void addMessage(String newMessage){
        messages.add(newMessage);
    }

    public List<String> getMessages()
    {
        return new ArrayList<>(messages);
    }

    @PostConstruct
    public void postConstruct()
    {
        this.messages = new ArrayList<>();
    }
}
