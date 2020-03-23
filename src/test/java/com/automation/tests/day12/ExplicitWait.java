package com.automation.tests.day12;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWait {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= DriverFactory.createADriver("chrome");

    }

    @Test
    public void waitForTitle(){
        driver.get("http://google.com");

        WebDriverWait wait=new WebDriverWait(driver, 10);
        //wait up to 10 seconds until title contains Google
        wait.until(ExpectedConditions.titleIs("Google"));

        driver.navigate().to("http://amazon.com");

        wait.until(ExpectedConditions.titleContains("Amazon"));
    }

    @Test
    public void waitForVisibility(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebDriverWait wait=new WebDriverWait(driver,10);

        driver.findElement(By.tagName("button")).click();
        WebElement userName=driver.findElement(By.id("username"));
        WebElement password=driver.findElement(By.id("pwd"));
        WebElement submitBtn=driver.findElement(By.cssSelector("button[type='submit']"));

        wait.until(ExpectedConditions.visibilityOf(userName)).sendKeys("tomsmith");
        wait.until(ExpectedConditions.visibilityOf(password)).sendKeys("SuperSecretPassword");
        wait.until(ExpectedConditions.visibilityOf(submitBtn));
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();

        String expected="Welcome to the Secure Area. When you are done click logout below.";
        String actual=driver.findElement(By.tagName("h4")).getText();
        Assert.assertEquals(actual,expected);

    }

    @Test
    public void elementToBeClickable(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/5");

        WebDriverWait wait=new WebDriverWait(driver,10);
        WebElement userName=driver.findElement(By.id("username"));
        WebElement password=driver.findElement(By.id("pwd"));
        WebElement submitBtn=driver.findElement(By.cssSelector("button[type='submit']"));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loadingoverlay")));
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        userName.sendKeys("tomsmith");
        password.sendKeys("SuperSecretPassword");
        submitBtn.click();

        String expected="Welcome to the Secure Area. When you are done click logout below.";
        String actual=driver.findElement(By.tagName("h4")).getText();
        Assert.assertEquals(actual,expected);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
