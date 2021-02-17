package com.EECS.SpringSecurityDemo.demo.Service;

import com.EECS.SpringSecurityDemo.demo.Mapper.MessageMapper;
import com.EECS.SpringSecurityDemo.demo.Model.ChatForm;
import com.EECS.SpringSecurityDemo.demo.Model.ChatMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageListService {
    MessageMapper messageMapper;

    public MessageListService(MessageMapper messageMapper){
        this.messageMapper = messageMapper;
    }

    public void addMessage(ChatForm chatForm){
        ChatMessage newMessage = new ChatMessage();
        newMessage.setUsername(chatForm.getUsername());
        switch(chatForm.getMessageType()){
            case "Say":
                newMessage.setMessageText(chatForm.getMessageText());
                break;
            case "Shout":
                newMessage.setMessageText(chatForm.getMessageText().toUpperCase());
                break;
            case "Whisper":
                newMessage.setMessageText(chatForm.getMessageText().toLowerCase());
                break;
        }

        messageMapper.addMessage(newMessage);
    }

    public List<ChatMessage> getMessages()
    {
        return messageMapper.getAllMessages();
    }
}
