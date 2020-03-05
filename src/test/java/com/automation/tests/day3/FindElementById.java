package com.automation.tests.day3;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindElementById {

    public static void main(String[] args) throws Exception {

        WebDriver driver= DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/login");

        //eger bir daha kullanmayacaksak reference variable olusturmadan
        //tek satirda da yazabiliriz

        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        Thread.sleep(2000);
        driver.findElement(By.id("wooden_spoon")).click();


        String expected="Welcome to the Secure Area. When you are done click logout below.";

        String actual=driver.findElement(By.className("subheader")).getText();

        if (expected.equals(actual)) {
            System.out.println("PASSED!");
        } else {
            System.out.println("FAILED!");
        }

        //let's click on Logout
        //it looks like a button but actually it is a linkedtext
        //every element with <a> tag is a link
        //if you have couple spaces in the text, just use partialLinkText instead of linkText
        //linkText - equals()
        //partialLinkText - contains() - complete match doesn't required
        WebElement logout=driver.findElement(By.linkText("Logout"));

        String href=logout.getAttribute("href");
        String className=logout.getAttribute("class");
        System.out.println(href);
        System.out.println(className);

        logout.click();

        Thread.sleep(2000);


        //simdi negative testing yapiyoruz
        driver.findElement(By.name("username")).sendKeys("wrong");
        driver.findElement(By.name("password")).sendKeys("wrong");
        Thread.sleep(2000);
        driver.findElement(By.id("wooden_spoon")).click();
        Thread.sleep(2000);

        WebElement errorMessage=driver.findElement(By.id("flash-messages"));
        System.out.println(errorMessage.getText());

        Thread.sleep(2000);

        driver.quit();
    }
}
