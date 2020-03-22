package com.automation.tests.day9;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutor {
    private RemoteWebDriver driver;

    @Test
    public void scrollTest(){
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        driver.manage().window().maximize();
        //you need to cast if reference type is webdriver
        //JavascriptExecutor js=(JavascriptExecutor) driver;
        //scroll down 250 pixels
        // x,y

        for (int i = 0; i < 10; i++) {
            driver.executeScript("window.scrollBy(0,250)");
            BrowserUtils.wait(1);
        }

    }

    @Test
    public void scrollToElementTest(){
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);

        WebElement link=driver.findElement(By.linkText("Cybertek School"));

        //arguments[0] - means 1st webelement after comma
        driver.executeScript("arguments[0].scrollIntoView(true)",link);

    }



    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();

    }

    @AfterMethod
    public void tearDown(){
        BrowserUtils.wait(3);
        driver.quit();
    }
}
