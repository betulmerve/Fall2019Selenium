package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonsTest {

    public static void main(String[] args) {

        WebDriver driver= DriverFactory.createADriver("chrome");

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        driver.manage().window().maximize();
        BrowserUtils.wait(2);

        WebElement blackButton=driver.findElement(By.id("black"));

        //if visible and eligible click
        if (blackButton.isDisplayed() && blackButton.isEnabled()) {
            System.out.println("Clicked on black button");
            blackButton.click();
        } else {
            System.out.println("failed to clicked on black button");
        }


        //how do we verify that button clicked

        if (blackButton.isSelected()) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }



        driver.quit();
    }
}
