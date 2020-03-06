package com.automation.tests.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class VerifyThatElementsGone {

    /**
     * Interview question:
     *
     * how to check if element doesn't exists any more in th DOM (Document Object Model (that HTML code))
     *
     */
    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver=new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        Thread.sleep(2000);
        driver.findElement(By.id("disappearing_button")).click();
        Thread.sleep(2000);

        if (driver.findElements(By.id("disappearing_button")).size()==0) {
            System.out.println("Test passed!");
        } else {
            System.out.println("Test failed!");
        }

        Thread.sleep(2000);

        //to find all buttons 
        List<WebElement> buttons=driver.findElements(By.tagName("button"));

        for (WebElement button:buttons) {
            //click on every button
            button.click();
            Thread.sleep(2000);
            
        }



        driver.quit();



    }
}
