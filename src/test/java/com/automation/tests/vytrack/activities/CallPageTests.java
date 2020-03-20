package com.automation.tests.vytrack.activities;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CallPageTests {
    private WebDriver driver;
    private Actions actions;
    private String userName="storemanager85";
    private String password="UserUser123";
    private By userNameBy= By.id("prependedInput");
    private By passwordBy=By.id("prependedInput2");
    private By activitiesBy=By.xpath("//span[@class='title title-level-1' and contains(text(), 'Activities')]");
    private By logCallBtnBy=By.cssSelector("a[title='Log call']");
    private By createBtnBy=By.cssSelector("a[title='Create Calendar event']");



    @Test
    public void verifyLogCallButton(){

        Assert.assertTrue(driver.findElement(logCallBtnBy).isDisplayed());

    }


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
        driver.get("https://qa2.vytrack.com/user/login");
        driver.manage().window().maximize();
        actions=new Actions(driver);
        BrowserUtils.wait(3);
        driver.findElement(userNameBy).sendKeys(userName);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(3);
        //hover over activities
        actions.moveToElement(driver.findElement(activitiesBy)).perform();
        BrowserUtils.wait(3);
        driver.findElement(By.linkText("Calls")).click();
        BrowserUtils.wait(5);

    }

    @AfterMethod
    public void tearDown(){
        if (driver!=null) {
            driver.quit();
            driver=null;
        }
    }
}
