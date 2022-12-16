package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class OpenAccountPage extends Utility {

    HomePage homePage = new HomePage();

    @CacheLookup
    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement customerSelect;
    @CacheLookup
    @FindBy(id ="currency")
    List<WebElement> currency;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Process')]")
    WebElement processBtn;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Open Account')]")
    WebElement openAccountClick;

    public void selectName(String name) {
        Reporter.log("Select Your Name " + customerSelect.toString());
        selectByContainsTextFromDropDown(customerSelect, name);
        CustomListeners.test.log(Status.PASS, "Your Name is " + name.toString() + "\"");
    }

    public void selectYourName() {
        Reporter.log("Select Your Name " + customerSelect.toString());
        selectLastIndexOfDropdownBox(customerSelect);
        CustomListeners.test.log(Status.PASS, "Your Name is ");
    }

    public void selectCurrency(String sCurrency) {
        Reporter.log("Select preferred currency " + currency.toString());
        List<WebElement> currencyName = currency;
        for (WebElement currency : currencyName) {
            if (currency.getText().equalsIgnoreCase(sCurrency)) {
                currency.click();
            }
            CustomListeners.test.log(Status.PASS, "Selected preferred Currency " + sCurrency.toString() + "\"");
        }
    }

    public void clickOnProcessButton() {
        Reporter.log("Click on Process Button " + processBtn.toString());
        clickOnElement(processBtn);
        CustomListeners.test.log(Status.PASS, "Click on Process Button ");
    }

    public void clickOnOpenAccount(){
        Reporter.log("Click on Open Account Button " + openAccountClick.toString());
        clickOnElement(openAccountClick);
        CustomListeners.test.log(Status.PASS, "Click on Open Account Button ");
    }

    public void openAccountMethod() {
        selectYourName();
        selectCurrency("Pound");
        clickOnProcessButton();
        acceptAlert();
        clickOnElement(homePage.homeButton);
        clickOnElement(homePage.customerLoginButton);
    }


}
