package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTests {
    private WebDriver driver;

    @Test
    public void googleSearchTest(){
        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("java", Keys.ENTER);
        BrowserUtils.wait(2);
        List<WebElement> searchItems= driver.findElements(By.tagName("h3"));

        for (WebElement each:searchItems) {
            String var=each.getText();
            if (!var.isEmpty()) {
                System.out.println(var);
                //verify that every search result contains java
                Assert.assertTrue(var.toLowerCase().contains("java"));
            }
        }

    }

    @Test(description = "Search for Java book on Amazon")
    public void amazonSearchTest(){
        driver.get("http://amazon.com");
        driver.manage().window().maximize();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java",Keys.ENTER);
        BrowserUtils.wait(2);
        //find all links inside h2 elements, because h2 element is no clickable itself
        //hyperlinks must be clickable
        List<WebElement> searchItems= driver.findElements(By.xpath("//h2//a"));
        searchItems.get(0).click();
        BrowserUtils.wait(2);
        WebElement title=driver.findElement(By.tagName("h1"));
        Assert.assertTrue(title.getText().toLowerCase().contains("java"));

        //so h2 elements are not clickable, even though they contain links
        //that's why, instead of collection all h2 elements
        //we collected all hyperlinks
        //every hyperlink represent some search item

    }

    @BeforeMethod
    public void setup(){
        //setup webdriver
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
    }

    @AfterMethod
    public void teardown(){
        //close browser and destroy webdriver object
        driver.quit();

    }
}
