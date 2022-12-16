package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CustomersPage extends Utility {

    @CacheLookup
    @FindBy(id = "userSelect")
    WebElement selectYourName;

    public void selectYourNameFromDropdownMenu(){
        Reporter.log("Selected Name :" + selectYourName.toString());
        selectLastIndexOfDropdownBox(selectYourName);
        CustomListeners.test.log(Status.PASS, "Selected Name :");

    }


}
