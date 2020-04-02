package com.automation.tests.vytrack.login;

import com.automation.pages.LoginPage;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewLoginTests extends AbstractTestBase {

    /*
    Login and verify that page title is "Dashboard"
     */
    @Test
    public void verifyPageTitle(){
        //test --> ExtentTest object
        //we must add to every test at the beginning
        //test = report.createTest("Test name");
        test=report.createTest("Verify page title");
        LoginPage loginPage=new LoginPage();
        loginPage.login();
        test.info("Login as store manager");
        Assert.assertEquals(Driver.getDriver().getTitle(),"Dashboard");
        test.pass("Page title Dashboard was verified");
    }

    /*
    Enter wrong credentials and verify warning message
     */
    @Test
    public void verifyWarningMessage(){
        test=report.createTest("Verify warning message");
        LoginPage loginPage=new LoginPage();
        loginPage.login("wrong","wrong");
        Assert.assertEquals(loginPage.getWarningMessageText(),"Invalid user name or password.");
        //take a screenshot
        BrowserUtils.getScreenshot("warning_message");
        test.pass("Warning message is displayed");

    }

}
