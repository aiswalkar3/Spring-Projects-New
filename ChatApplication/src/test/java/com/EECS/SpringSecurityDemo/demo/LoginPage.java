package com.EECS.SpringSecurityDemo.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(id = "inputUsername")
    private WebElement username;

    @FindBy(id = "inputPassword")
    private WebElement password;

    @FindBy(id = "submit-button")
    private WebElement submit;

    @FindBy(className = "error-msg")
    private WebElement errorMsg;

    public LoginPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    public String loginUser(String username, String password)
    {
        String result = "success";
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.submit.click();

        /*
        if(errorMsg.isEnabled())
            result = errorMsg.getText();
        */
        return result;
    }
}
