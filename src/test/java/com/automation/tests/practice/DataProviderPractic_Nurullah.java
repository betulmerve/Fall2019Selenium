package com.automation.tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractic_Nurullah {

    //Data provider - provides data to test cases
    @DataProvider(name = "testData")
    public static Object[] testData(){
        return new Object[]{"404","500"};
    }


    @Test(dataProvider = "testData")
    public void statusCodes(String code) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://practice-cybertekschool.herokuapp.com");
        WebElement statusCodeLink=driver.findElement(By.linkText("Status Codes"));
        statusCodeLink.click();
        WebElement statusCode=driver.findElement(By.linkText(code));
        statusCode.click();

        String expectedMessage="This page returned a "+code+" status code";
        WebElement displayedMessage=driver.findElement(By.tagName("p"));
        String actualMessage=displayedMessage.getText();
        if (actualMessage.contains(expectedMessage)) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        driver.quit();

    }
}
