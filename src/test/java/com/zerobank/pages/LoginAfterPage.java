package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginAfterPage {

    public LoginAfterPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "button#details-button")
    public WebElement advanced;

    @FindBy(css = "a#proceed-link")
    public WebElement proceed;

}
