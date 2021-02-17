package com.EECS.MVC_DEMO.ChatController;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChatService {
    private List<ChatMessage> listChatMessage;

    public void addMessage(String username, String message)
    {
        listChatMessage.add(new ChatMessage(username, message));
    }

    public List<ChatMessage> getMessages()
    {
        return new ArrayList<>(listChatMessage);
    }

    @PostConstruct
    public void postConstruct()
    {
        listChatMessage = new ArrayList<>();
    }
}
