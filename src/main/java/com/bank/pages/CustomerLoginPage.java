package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CustomerLoginPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//label[contains(text(),'Your Name :')]")
    WebElement yourNameText;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement customerLogin;
    @CacheLookup
    @FindBy(id = "userSelect")
    WebElement selectYourName;

    public String getYourNameTextOnCustomerLoginPage() {
        Reporter.log("Your Name Text is " + yourNameText.toString());
        CustomListeners.test.log(Status.PASS, "Your Name Text is \"" + yourNameText.getText() + "\"");
        return getTextFromElement(yourNameText);

    }

    public void clickOnCustomerLoginButton() {
        Reporter.log("Click on Customer Login Button " + customerLogin.toString());
        clickOnElement(customerLogin);
        CustomListeners.test.log(Status.PASS, "Click on Customer Login Button ");
    }

    public void selectYourNameFromDropDownOption() throws InterruptedException {
        Reporter.log("Select Your Name " + selectYourName.toString());
        selectLastIndexOfDropdownBox(selectYourName);
        CustomListeners.test.log(Status.PASS, "Your Name is ");
    }

}
