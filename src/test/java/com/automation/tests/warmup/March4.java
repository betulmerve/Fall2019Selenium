package com.automation.tests.warmup;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class March4 {
    static WebDriver driver;

    public static void main(String[] args) throws Exception {

        //ebayTest();
        amazonTest();
//        wikipediaTest();
    }

    public static void ebayTest() {
        driver= DriverFactory.createADriver("chrome");
        driver.get("https://www.ebay.com/");
        driver.findElement(By.id("gh-ac")).sendKeys("term");
        driver.findElement(By.id("gh-btn")).click();
        WebElement searchResults=driver.findElement(By.tagName("h1"));
        System.out.println(searchResults.getText().split(" ")[0]);
        driver.quit();
    }

    public static void amazonTest() throws Exception{
        driver= DriverFactory.createADriver("chrome");
        driver.get("https://www.amazon.com/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("term");
        driver.findElement(By.className("nav-input")).submit();

        Thread.sleep(2000);

        String title=driver.getTitle();

        if (title.contains("term")) {
            System.out.println("PASSED!");
        } else {
            System.out.println("FAILED!");
        }

        driver.quit();
    }

    public static void wikipediaTest() {
        driver= DriverFactory.createADriver("chrome");
        driver.get("https://www.wikipedia.org/");
        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver", Keys.ENTER);
        driver.findElement(By.partialLinkText("Selenium (software)")).click();

        if (driver.getCurrentUrl().endsWith("Selenium_(software)")) {
            System.out.println("PASSED!");
        } else {
            System.out.println("FAILED!");
        }

        driver.quit();
    }
}
