package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBoxes {

    public static void main(String[] args) {

        WebDriver driver= DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");
        BrowserUtils.wait(2);

        List<WebElement> checkBoxes=driver.findElements(By.tagName("input"));

        //checkBoxes.get(0).click(); //click on first checkbox

        //go over from collection of checkboxes
        for (int i = 0; i < checkBoxes.size(); i++) {
            if (checkBoxes.get(i).isDisplayed() && checkBoxes.get(i).isEnabled() && !checkBoxes.get(i).isSelected()) {
                checkBoxes.get(i).click(); //click on second checkbox
                System.out.println((i+1) +" checkbox is clicked");
                BrowserUtils.wait(2);
            } else {
                System.out.println((i+1) +" checkbox is not clicked");
            }

        }



        driver.quit();


    }
}
