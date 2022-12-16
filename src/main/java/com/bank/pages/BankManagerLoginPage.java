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

public class BankManagerLoginPage extends Utility {

    By addCustomer = By.xpath("//button[contains(text(),'Add Customer')]");

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
    List<WebElement> bankManagerLogin;

    public void selectBankManagerLoginPageOptions(String managersOptions) {
        Reporter.log("Bank manager options are " + bankManagerLogin.toString());
        List<WebElement> managerOptions = bankManagerLogin;

        for (WebElement options : managerOptions) {
            if (options.getText().equalsIgnoreCase(managersOptions))
                options.click();
        }
        CustomListeners.test.log(Status.PASS, "Bank manager options are " + bankManagerLogin.toString() + "\"");
    }
}
