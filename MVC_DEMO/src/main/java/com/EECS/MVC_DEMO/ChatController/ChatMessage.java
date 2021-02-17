package com.EECS.MVC_DEMO.ChatController;

public class ChatMessage {
    private String username;
    private String messageText;

    public ChatMessage(String username, String messageText)
    {
        this.username = username;
        this.messageText = messageText;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}
