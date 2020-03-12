package com.automation.tests.day6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Trial {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver=new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/login");

        WebElement element=driver.findElement(By.xpath("//label[text()='Username']/following-sibling::input"));
        System.out.println(element.getAttribute("type"));



        driver.quit();

    }
}
