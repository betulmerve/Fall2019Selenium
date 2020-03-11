package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectByIndex {
    public static void main(String[] args) {
        WebDriver driver= DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(2);

        Select stateSelect=new Select(driver.findElement(By.id("state")));
        stateSelect.selectByIndex(7);

        String expected="Connecticut";
        String actual=stateSelect.getFirstSelectedOption().getText();
        if (expected.equals(actual) ){
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }

        BrowserUtils.wait(2);
        driver.quit();
    }
}
