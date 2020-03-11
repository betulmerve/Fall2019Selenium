package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByTextMultipleOptions {

    public static void main(String[] args) {

        WebDriver driver= DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(2);

        Select languagesSelect=new Select(driver.findElement(By.name("Languages")));
        boolean isMultiple=languagesSelect.isMultiple();
        System.out.println(isMultiple);

        languagesSelect.selectByVisibleText("Java");
        languagesSelect.selectByVisibleText("JavaScript");
        languagesSelect.selectByVisibleText("Python");

        //lets get all selected options
        List<WebElement> selectedLanguages=languagesSelect.getAllSelectedOptions();

        for (WebElement selected:selectedLanguages) {
            System.out.println(selected.getText());
        }

        languagesSelect.deselectByVisibleText("Python"); //to unselect Python
        BrowserUtils.wait(2);
        languagesSelect.deselectAll();
        BrowserUtils.wait(2);









        BrowserUtils.wait(2);
        driver.quit();
    }
}
