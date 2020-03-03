package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {

    public static void main(String[] args) throws Exception {
        //to start selenium script we need:
        // setup webdriver(browser driver) and create webdriver object

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        //In selenium, everything starts from WebDriver interface
        //ChromeDriver extends RemoteWebDriver --> implements WebDriver
        driver.get("http://google.com"); //to open a website
        driver.manage().window().maximize();//to maximize browser
        Thread.sleep(3000); //for demo, wait 3 sec
        //method that return page title
        //you can also see it as a tab name in browser
        String title=driver.getTitle();//returns title of the page
        String expectedTitle="Google";
        System.out.println("title = " + title);
        if (expectedTitle.equals(title)) {
            System.out.println("TEST PASSED!");
        } else {
            System.out.println("TEST FAILED!");
        }

        driver.navigate().to("http://amazon.com");
        if (driver.getTitle().toLowerCase().contains("amazon")) {
            System.out.println("TEST PASSED!");
        } else {
            System.out.println("TEST FAILED!");
        }
        //come back to google
        driver.navigate().back();
        verifyEquals(driver.getTitle(),"Google");
        //move forward in the browser history
        driver.navigate().forward();
        System.out.println("Title = " + driver.getTitle());
        System.out.println("URL: "+ driver.getCurrentUrl());

        //reload page
        driver.navigate().refresh();

        //must be at the end
        driver.close();//to close browser
    }

    public static void verifyEquals(String arg1,String arg2) {
        if (arg1.equals(arg2)) {
            System.out.println("TEST PASSED!");
        } else {
            System.out.println("TEST FAILED!");
        }
    }


}
