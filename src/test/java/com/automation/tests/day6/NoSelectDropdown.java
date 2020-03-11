package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NoSelectDropdown {

    //bu non select dropdown oldugu icin Select object yaratmaya gerek yok
    public static void main(String[] args) {

        WebDriver driver= DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(2);

        driver.findElement(By.id("dropdownMenuLink")).click(); //to expand dropdown
        BrowserUtils.wait(2);

        List<WebElement> links=driver.findElements(By.className("dropdown-item"));

        for (WebElement link:links) {
            System.out.println(link.getText()+" : "+ link.getAttribute("href"));
        }

        driver.findElement(By.linkText("Amazon")).click(); //click on option


        BrowserUtils.wait(2);
        driver.quit();


    }
}
