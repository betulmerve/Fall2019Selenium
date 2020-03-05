package com.automation.tests.warmup;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class March4 {

    public static void main(String[] args) {

        ebayTest();
        amazonTest();
        wikipediaTest();
    }

    public static void ebayTest() {
        WebDriver driver= DriverFactory.createADriver("chrome");
        driver.get("https://www.ebay.com/");
        driver.findElement(By.id("gh-ac")).sendKeys("term");
        driver.findElement(By.id("gh-btn")).click();
        String number=driver.findElement(By.tagName("h1")).getText().split(" ")[0];
        System.out.println(number);
        driver.quit();
    }

    public static void amazonTest() {
        WebDriver driver= DriverFactory.createADriver("chrome");
        driver.get("https://www.amazon.com/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("term");
        driver.findElement(By.className("nav-input")).submit();

        String title=driver.getTitle();

        if (title.contains("term")) {
            System.out.println("PASSED!");
        } else {
            System.out.println("FAILED!");
        }

        driver.quit();
    }

    public static void wikipediaTest() {
        WebDriver driver= DriverFactory.createADriver("chrome");
        driver.get("https://www.wikipedia.org/");
        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver", Keys.ENTER);
        driver.findElement(By.partialLinkText("selenium (software)")).click();

        if (driver.getCurrentUrl().endsWith("Selenium_(software)")) {
            System.out.println("PASSED!");
        } else {
            System.out.println("FAILED!");
        }

        driver.quit();
    }
}
