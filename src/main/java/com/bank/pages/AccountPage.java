package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class AccountPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement enterDepositAmount;

    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement depositAmountButn;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Withdrawl')]")
    WebElement withdrawOption;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Deposit')]")
    WebElement depositOption;

    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement withdrawSubmit;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Deposit Successful')]")
    WebElement depositSuccessful;

    @CacheLookup
    @FindBy(xpath = "//div[@class='ng-scope']/span[@ng-show='message']")
    WebElement transactionSuccessful;

    @CacheLookup
    @FindBy(xpath = "//input[@type='number']")
    WebElement withdrawAmount;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Logout')]")
    WebElement logoutButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='borderM box padT20 ng-scope']/div[3]//button")
    List<WebElement> customerAccountPageOptions;


    public void selectCustomerAccountPageOption(String customerOption) {
        Reporter.log("The customer options are " + customerAccountPageOptions.toString());
        List<WebElement> options = customerAccountPageOptions;

        for (WebElement e : options) {
            if (e.getText().equalsIgnoreCase(customerOption)) {
                e.click();
            }
        }
        CustomListeners.test.log(Status.PASS, "The customer options are \"" + customerAccountPageOptions.toString() + "\"");

    }
    public void sendAmountToDepositField(String amount) {
        Reporter.log("Enter Deposit Amount" + enterDepositAmount.toString());
        sendTextToElement(enterDepositAmount, amount);
        CustomListeners.test.log(Status.PASS, "Enter Deposit Amount" + amount.toString() + "\"");
    }


    public void clickOnDepositOption() {
        Reporter.log("Click on Deposit Option " + depositOption.toString());
        clickOnElement(depositOption);
        CustomListeners.test.log(Status.PASS, "Click on Deposit Option ");
    }
    public void clickOnDepositButton() {
        Reporter.log("Click on Deposit Button " + depositAmountButn.toString());
        clickOnElement(depositAmountButn);
        CustomListeners.test.log(Status.PASS, "Click on Deposit Button ");
    }

    public String getDepositSuccessfulMsg() {
        Reporter.log("Deposit successful " + depositSuccessful.toString());
        CustomListeners.test.log(Status.PASS, "Deposit successful \"" + depositSuccessful.getText() + "\"");
        return getTextFromElement(depositSuccessful);
    }

    public String getTransactionSuccessfulMsg() {
        Reporter.log("Transaction successful " + transactionSuccessful.toString());
        CustomListeners.test.log(Status.PASS, "Transaction successful ");
        return getTextFromElement(transactionSuccessful);
    }

    public void depositAmount(String amount) {
        Reporter.log("Send Amount to deposit field & than click on deposit button ");
        sendAmountToDepositField(amount);
        clickOnDepositButton();
        CustomListeners.test.log(Status.PASS, "Amount deposited " + amount);

    }

    public void withdrawAmount(String amount) {
        Reporter.log("Send Amount to  Withdrawn field " + withdrawAmount.toString());
        sendTextToElement(withdrawAmount, amount);
        CustomListeners.test.log(Status.PASS, "Amount Withdrawn " + amount);

    }

    public void clickOnWithdrawAmountButton() {
        Reporter.log("Click on Withdraw Button " + withdrawSubmit.toString());
        clickOnElement(withdrawSubmit);
        CustomListeners.test.log(Status.PASS, "Click on Withdraw Button ");
    }

    public void clickOnWithdrawOption() {
        Reporter.log("Click on Withdraw Option " + withdrawOption.toString());
        clickOnElement(withdrawOption);
        CustomListeners.test.log(Status.PASS, "Click on Withdraw Option");
    }
    public void clickOnLogoutButton() {
        Reporter.log("Click on Logout Button " + logoutButton.toString());
        clickOnElement(logoutButton);
        CustomListeners.test.log(Status.PASS, "Click on Logout Button ");
    }
    public boolean verifyLogoutButtonText() {
        Reporter.log("Click on Login Button " + logoutButton.toString());
        CustomListeners.test.log(Status.PASS, "Click on Login Button ");
        return verifyThatElementIsDisplayed(logoutButton);
    }

}
