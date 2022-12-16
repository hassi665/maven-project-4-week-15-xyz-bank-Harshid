package com.bank.testbase.testsuite;

import com.bank.customlisteners.CustomListeners;
import com.bank.pages.*;
import com.bank.testbase.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class BankTest extends BaseTest {
    HomePage homePage;
    BankManagerLoginPage bankManagerLoginPage;
    CustomerLoginPage customerLoginPage;
    CustomersPage customersPage;
    AccountPage accountPage;
    AddCustomerPage addCustomerPage;
    OpenAccountPage openAccountPage;


    @BeforeMethod(alwaysRun = true)
    public void pageObjects() {
        homePage = new HomePage();
        bankManagerLoginPage = new BankManagerLoginPage();
        customerLoginPage = new CustomerLoginPage();
        customersPage = new CustomersPage();
        accountPage = new AccountPage();
        addCustomerPage = new AddCustomerPage();
        openAccountPage = new OpenAccountPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void bankManagerShouldAddCustomerSuccessfully() {
        //click On "Bank Manager Login" Tab
        homePage.selectHomePageOptions("Bank Manager Login");
        //click On "Add Customer" Tab
        bankManagerLoginPage.selectBankManagerLoginPageOptions("Add Customer");
        //enter FirstName
        addCustomerPage.sendTextToFirstNameField("Shaun");
        //enter LastName
        addCustomerPage.sendTextToLastNameField("Dead");
        //enter PostCode
        addCustomerPage.sendTextToPostCodeField("BB1 ");
        //click On "Add Customer" Button
        addCustomerPage.clickOnAddCustomerButton();
        //verify message "Customer added successfully"
        Assert.assertTrue(homePage.getTextFromAlertMsg().contains("Customer added successfully with customer"), "New Customer Not Added");
        //click on "ok" button on popup.
        homePage.handleAlertMsg();
    }


    @Test(groups = {"smoke", "regression"})
    public void bankManagerShouldOpenAccountSuccessfully() throws InterruptedException {
        homePage.selectHomePageOptions("Bank Manager Login");
        bankManagerLoginPage.selectBankManagerLoginPageOptions("Add Customer");
        addCustomerPage.addCustomerInput();
        Thread.sleep(1500);
        //	click On "Open Account" Tab
        bankManagerLoginPage.selectBankManagerLoginPageOptions("Open Account");
        //	Search customer that created in first test
        openAccountPage.selectYourName();
        //	Select currency "Pound"
        openAccountPage.selectCurrency("Pound");
        //	click on "process" button
        openAccountPage.clickOnProcessButton();
        //	verify message "Account created successfully"
        Assert.assertTrue(homePage.getTextFromAlertMsg().contains("Account created successfully with account Number"));
        //	click on "ok" button on popup.
        homePage.acceptAlert();
    }


    @Test(groups = "regression")
    public void customerShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        homePage.selectHomePageOptions("Bank Manager Login");
        bankManagerLoginPage.selectBankManagerLoginPageOptions("Add Customer");
        addCustomerPage.addCustomerInput();
        //click On "Open Account" Tab
        bankManagerLoginPage.selectBankManagerLoginPageOptions("Open Account");
        openAccountPage.openAccountMethod();
        homePage.clickOnHomeButton();
        //click on "Customer Login" Tab
        homePage.clickOnCustomerLoginButton();
        //search customer that you created.
        customersPage.selectYourNameFromDropdownMenu();
        //click on "Login" Button
        customerLoginPage.clickOnCustomerLoginButton();
        //verify "Logout" Tab displayed.
        Assert.assertTrue(accountPage.verifyLogoutButtonText(), "Logout");
        Thread.sleep(1000);
        //click on "Logout"
        accountPage.clickOnLogoutButton();
        //verify "Your Name" text displayed.
        Assert.assertTrue(customerLoginPage.getYourNameTextOnCustomerLoginPage().contains("Your Name"), "Your Name");
    }


    @Test(groups = "regression")
    public void customerShouldDepositMoneySuccessfully() throws InterruptedException {
        //Select Bank Manager Login button
        homePage.selectHomePageOptions("Bank Manager Login");
        bankManagerLoginPage.selectBankManagerLoginPageOptions("Add Customer");
        addCustomerPage.addCustomerInput();
        //	click On "Open Account" Tab
        bankManagerLoginPage.selectBankManagerLoginPageOptions("Open Account");
        openAccountPage.openAccountMethod();
        homePage.clickOnHomeButton();
        //click on "Customer Login" Tab
        homePage.clickOnCustomerLoginButton();
        //	search customer that you created.
        customersPage.selectYourNameFromDropdownMenu();
        //	click on "Login" Button
        customerLoginPage.clickOnCustomerLoginButton();
        //	click on "Deposit" Tab.
        accountPage.clickOnDepositOption();
        //	Enter amount 100
        accountPage.sendAmountToDepositField("100");
        //	click on "Deposit" Button
        accountPage.clickOnDepositButton();
        //	verify message "Deposit Successful"
        Assert.assertEquals(accountPage.getDepositSuccessfulMsg(), "Deposit Successful");
    }


    @Test(groups = "regression")
    public void customerShouldWithdrawMoneySuccessfully() throws InterruptedException {
        homePage.selectHomePageOptions("Bank Manager Login");
        //Select Add customer option from Manager Menu
        bankManagerLoginPage.selectBankManagerLoginPageOptions("Add Customer");
        addCustomerPage.addCustomerInput();
        //click On "Open Account" Tab
        bankManagerLoginPage.selectBankManagerLoginPageOptions("Open Account");
        //Add details of customer
        openAccountPage.openAccountMethod();
        //Select customer name
        customersPage.selectYourNameFromDropdownMenu();
        //click on "Login" Button
        customerLoginPage.clickOnCustomerLoginButton();
        //click on "Deposit Menu" Button
        accountPage.clickOnDepositButton();
        //Enter"Deposit Amount"
        accountPage.depositAmount("100");
        homePage.clickOnHomeButton();
        //click on "Login" Button
        homePage.clickOnCustomerLoginButton();
        Thread.sleep(1000);
        //click on "Select Name from menu"
        customerLoginPage.selectYourNameFromDropDownOption();
        Thread.sleep(1000);
        customerLoginPage.clickOnCustomerLoginButton();
        accountPage.clickOnWithdrawOption();
        //	Enter amount 50
        accountPage.withdrawAmount("50");
        //	click on "Withdraw" Button
        accountPage.clickOnWithdrawAmountButton();
        //	verify message "Transaction Successful"
        Assert.assertEquals(accountPage.getTransactionSuccessfulMsg(), "Transaction successful");
    }

}
