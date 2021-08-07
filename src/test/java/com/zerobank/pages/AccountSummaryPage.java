package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountSummaryPage extends BasePage{
    //http://zero.webappsecurity.com/bank/account-summary.html

    @FindBy(xpath = "(//a[text()='Savings'])[1]")
    public WebElement savings1;

    @FindBy(xpath = "(//a[text()='Savings'])[2]")
    public WebElement savings2;

    @FindBy(linkText = "Loan")
    public WebElement loan;

    @FindBy(linkText = "Brokerage")
    public WebElement brokerage;

    @FindBy(linkText = "Checking")
    public WebElement checking;

    @FindBy(linkText = "Credit Card")
    public WebElement creditCard;

    @FindBy(tagName = "h2")
    public List<WebElement> accountTypes;

    @FindBy(xpath = "(//table)[3]//th")
    public List<WebElement> tableHeadColumn;

    public List<WebElement> getTableHeadColumns(int index){
        return Driver.get().findElements(By.xpath("(//table)[" + index + "]//thead//th"));
    }

    public WebElement getTable(int index){
        return Driver.get().findElement(By.xpath("(//table)[" + index + "]"));
    }

}
