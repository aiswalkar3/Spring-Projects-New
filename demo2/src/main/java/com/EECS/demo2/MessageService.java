package com.EECS.demo2;


import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class MessageService {
    String message;

    public MessageService(String message)
    {
        this.message = message;
    }

    public String uppercase()
    {
        return message.toUpperCase();
    }

    public String lowercase()
    {
        return message.toLowerCase();
    }

    @PostConstruct
    public void postConstruct()
    {
        System.out.println("Creating MessageService Bean");
    }
}
