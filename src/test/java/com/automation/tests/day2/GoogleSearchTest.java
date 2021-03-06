package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {

    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://google.com");
        Thread.sleep(2000);

        //By.name("q") --> name="q"
        //name - it's one of the selenium locators
        //there are 8 locators
        //we use locators to find elements
        //to choose locator, just use By.locator

        WebElement search=driver.findElement(By.name("q"));
        //once we found this element, how to enter the text?
        search.sendKeys("Java", Keys.ENTER);
        Thread.sleep(4000);
        //if see <a> element, it calls link
        //visible text of this link, can be used by selenium to find this element
        WebElement news=driver.findElement(By.linkText("News"));
        news.click(); //to click on the news
        Thread.sleep(4000);



        driver.quit();
    }
}
