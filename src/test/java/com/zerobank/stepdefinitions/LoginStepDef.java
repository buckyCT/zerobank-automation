package com.zerobank.stepdefinitions;

import com.zerobank.pages.LoginAfterPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class LoginStepDef {

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        Driver.get().get(ConfigurationReader.get("url"));

        LoginPage loginPage = new LoginPage();
        loginPage.username.sendKeys("username");
        loginPage.password.sendKeys("password");
        loginPage.signIn.click();

        LoginAfterPage loginAfterPage = new LoginAfterPage();
        loginAfterPage.advanced.click();
        loginAfterPage.proceed.click();
    }

    @Given("the user logs in with {string} and {string}")
    public void the_user_logs_in_with_and(String username, String password) {
        Driver.get().get(ConfigurationReader.get("url"));

        LoginPage loginPage = new LoginPage();
        loginPage.username.sendKeys(username);
        loginPage.password.sendKeys(password);
        loginPage.signIn.click();
    }

    @Then("the user should see login or password are wrong error")
    public void the_user_should_see_login_or_password_are_wrong_error() {
        Assert.assertTrue(new LoginPage().loginErrorMessage.isDisplayed());
    }

    @Then("the user should be on Account Summary page")
    public void the_user_should_be_on_Account_Summary_page() {
        String actualUrl = Driver.get().getCurrentUrl();
        String expected = "http://zero.webappsecurity.com/bank/account-summary.html";
        Assert.assertEquals(expected,actualUrl);
    }

}
