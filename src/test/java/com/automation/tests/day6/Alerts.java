package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Alerts {

    public static void main(String[] args) {


        WebDriver driver= DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        BrowserUtils.wait(2);

        List<WebElement> buttons=driver.findElements(By.tagName("button"));
        buttons.get(0).click();
        //to get the text from popup message
        String popupText=driver.switchTo().alert().getText();
        System.out.println(popupText);

        driver.switchTo().alert().accept();//to click ok
        String expected="You successfully clicked an alert";
        String actual=driver.findElement(By.id("result")).getText();

        if (expected.equals(actual)) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
            System.out.println("Expected: "+expected);
            System.out.println("Actual: "+actual);
        }
        BrowserUtils.wait(2);

        buttons.get(1).click();//to click on the second button
        //to click cancel
        driver.switchTo().alert().dismiss();

        String expected2="You clicked: Cancel";
        String actual2=driver.findElement(By.id("result")).getText();

        if (expected2.equals(actual2)) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
            System.out.println("Expected: "+expected2);
            System.out.println("Actual: "+actual2);
        }
        BrowserUtils.wait(2);

        buttons.get(2).click();
        //Alert alert=driver.switchTo().alert(); //bu sekilde object olusturabiliriz
        driver.switchTo().alert().sendKeys("Deneme");
        BrowserUtils.wait(2);
        driver.switchTo().alert().accept();


        String actual3=driver.findElement(By.id("result")).getText();

        if (actual3.endsWith("Deneme")) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }


        BrowserUtils.wait(2);
        driver.quit();

    }
}
