package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "input#user_login")
    public WebElement username;

    @FindBy(css = "input#user_password")
    public WebElement password;

    @FindBy(xpath = "//input[@value='Sign in']")
    public WebElement signIn;

    @FindBy(xpath = "//div[@class='alert alert-error'][contains(text(),'Login and/or password are wrong.')]")
    public WebElement loginErrorMessage;

}
