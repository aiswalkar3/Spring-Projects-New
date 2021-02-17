package com.EECS.SpringSecurityDemo.demo;

import com.EECS.SpringSecurityDemo.demo.Model.ChatMessage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    @FindBy(id = "newMessageText")
    private WebElement messageText;

    @FindBy(id = "messageType")
    private WebElement messageType;

    @FindBy(id = "submitMessage")
    private WebElement submitMessage;

    @FindBy(className = "chatMessageUsername")
    private WebElement messageUsername;

    @FindBy(className = "chatMessageText")
    private WebElement firstMessageText;

    public HomePage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    public void setMessage(String message, String messageType)
    {
        messageText.sendKeys(message);
        this.messageType.sendKeys(messageType);
        this.submitMessage.click();
    }

    public ChatMessage getMessage()
    {
        ChatMessage result = new ChatMessage();
        result.setUsername(messageUsername.getText());
        result.setMessageText(firstMessageText.getText());
        return result;
    }
}
