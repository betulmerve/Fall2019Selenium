package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class PracticeTests {
    private WebDriver driver;


    @Test
    public void loginTest(){

        driver.findElement(By.linkText("Form Authentication")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        driver.findElement(By.id("wooden_spoon")).click();
        BrowserUtils.wait(2);
        String actual=driver.findElement(By.tagName("h4")).getText();
        String expected="Welcome to the Secure Area. When you are done click logout below.";
        //if assertion failes - it will throw exception and message will be printed
        Assert.assertEquals(actual,expected,"Sub-header message is not matching!");

    }

    @Test
    public void forgotPasswordTest(){
        driver.findElement(By.linkText("Forgot Password")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.name("email")).sendKeys("merve.faki@gmail.com", Keys.ENTER);
        String expected="Your e-mail's been sent!";
        String actual=driver.findElement(By.tagName("h4")).getText();
        Assert.assertEquals(expected,actual,"Messega is not matching!");

    }

    @Test
    public void checkboxTest1(){
        driver.findElement(By.linkText("Checkboxes")).click();
        BrowserUtils.wait(2);
        List<WebElement>checkboxes=driver.findElements(By.tagName("input"));
        checkboxes.get(0).click();
        BrowserUtils.wait(2);
        Assert.assertTrue(checkboxes.get(0).isSelected(),"Checkbox#1 is not selected!");
    }






    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().version("79").setup();
//Interview questions: how to handle SSL issues in selenium?
        //ChromeOptions - used to customize browser for test
//        ChromeOptions chromeOptions=new ChromeOptions();
        //to ignore "your connection is not private" issue
//        chromeOptions.setAcceptInsecureCerts(true);
        driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
