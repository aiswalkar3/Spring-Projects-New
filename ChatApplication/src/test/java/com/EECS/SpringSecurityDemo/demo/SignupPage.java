package com.EECS.SpringSecurityDemo.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {
    @FindBy(id = "inputFirstName")
    private WebElement firstName;

    @FindBy(id = "inputLastName")
    private WebElement lastName;

    @FindBy(id = "inputUsername")
    private WebElement username;

    @FindBy(id = "inputPassword")
    private WebElement password;

    @FindBy(id = "submit-button")
    private WebElement submit;

    @FindBy(id = "success-msg")
    private WebElement successMessage;

    @FindBy(id = "error-msg")
    private WebElement errorMessage;

    public SignupPage(WebDriver webDriver)
    {
        PageFactory.initElements(webDriver,this);
    }

    public String signupUser(String firstName, String lastName, String username, String password)
    {
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.submit.click();

        String successMsg = "", errorMsg = "";

        successMsg = this.successMessage.getText();

        if(successMsg.isEmpty())
            errorMsg = this.errorMessage.getText();

        if(!successMsg.isEmpty())
        {
            return successMsg;
        }
        else{
            return errorMsg;
        }
    }
}
