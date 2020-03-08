package com.automation.tests.day5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxesTest {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79.0").setup();
        WebDriver driver=new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/checkboxes");

        //verify that first checkbox is not selected and second is selected
        List<WebElement> checkBoxes=driver.findElements(By.tagName("input"));

        if (!checkBoxes.get(0).isSelected() && checkBoxes.get(1).isSelected()) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

        //lets click on the first checkbox and verify that it is clicked
        checkBoxes.get(0).click();
        if (checkBoxes.get(0).isSelected()) {
            System.out.println("PASSED");
            System.out.println("checkbox 1 is selected");
        } else {
            System.out.println("FAILED");
            System.out.println("checkbox 1 is not selected");
        }

        driver.quit();

    }
}
