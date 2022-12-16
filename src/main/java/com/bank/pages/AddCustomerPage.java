package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AddCustomerPage extends Utility {

    //------------------------AddCutomer Detils -------------------------------------//


    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstNameAdd;
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastNameAdd;
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postcodeAdd;
    @CacheLookup
    @FindBy(xpath = "//button[@class='btn btn-default']")
    WebElement addCustomerAddButton;

    public void sendTextToFirstNameField(String fName) {
        Reporter.log("Enter First Name  " + fName + firstNameAdd.toString());
        sendTextToElement(firstNameAdd, fName + getAlphaNumericString(3));
        CustomListeners.test.log(Status.PASS, "First Name is : " + fName + "\"");
    }

    public void sendTextToLastNameField(String lName) {
        Reporter.log("Enter Last Name  " + lName + lastNameAdd.toString());
        sendTextToElement(lastNameAdd, lName + getAlphaNumericString(3));
        CustomListeners.test.log(Status.PASS, "Last Name is : " + lName + "\"");
    }

    public void sendTextToPostCodeField(String postCode) {
        Reporter.log("Enter Postcode  " + postCode + postcodeAdd.toString());
        sendTextToElement(postcodeAdd, postCode + getAlphaNumericString(3));
        CustomListeners.test.log(Status.PASS, "Postcode is : " + postCode + "\"");
    }

    public void clickOnAddCustomerButton() {
        Reporter.log("Click on Add Customer " + addCustomerAddButton.toString());
        clickOnElement(addCustomerAddButton);
        CustomListeners.test.log(Status.PASS, "Click on Add Customer ");
    }
    public void addCustomerInput() {
        sendTextToFirstNameField("John");
        sendTextToLastNameField("Cena");
        sendTextToPostCodeField("EN15JK");
        clickOnAddCustomerButton();
        acceptAlert();
    }
}
