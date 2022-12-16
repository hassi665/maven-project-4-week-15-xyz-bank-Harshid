package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class HomePage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Home')]")
    WebElement homeButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='borderM box padT20']//button")
    List<WebElement> homePageOptions;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Customer Login')]")
    WebElement customerLoginButton;

    public void clickOnHomeButton() {
        Reporter.log("Click on Home Button " + homeButton.toString());
        clickOnElement(homeButton);
        CustomListeners.test.log(Status.PASS, "Click on Home Button " + homeButton.toString() + "\"");
    }


    public void selectHomePageOptions(String homeOptions) {
        Reporter.log("The home page options " + homePageOptions.toString());
        List<WebElement> homePageOption = homePageOptions;

        for (WebElement options : homePageOption) {
            if (options.getText().equalsIgnoreCase(homeOptions))
                options.click();
        }
        CustomListeners.test.log(Status.PASS, "options : " + homeOptions.toString() + "\"");
    }

    public void handleAlertMsg() {
        acceptAlert();
    }

    public String getTextFromAlertMsg() {
        return getTextFromAlert();
    }

    public void clickOnCustomerLoginButton() {
        Reporter.log("Click on login button" + customerLoginButton.toString());
        clickOnElement(customerLoginButton);
        CustomListeners.test.log(Status.PASS, "Clicked on Login button ");
    }
}
