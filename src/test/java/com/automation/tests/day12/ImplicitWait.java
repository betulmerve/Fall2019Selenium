package com.automation.tests.day12;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class ImplicitWait {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver= DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_loading/2");
        //this is how we applied implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


    @Test
    public void waitTest(){

        driver.findElement(By.tagName("button")).click();
        WebElement finishElement=driver.findElement(By.id("finish"));
        System.out.println(finishElement.getText());
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
