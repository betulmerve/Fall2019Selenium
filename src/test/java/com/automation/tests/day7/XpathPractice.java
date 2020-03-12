package com.automation.tests.day7;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//xpath i her zaman tekrar yazmak yerine class a static variable olarak ekleyebiliriz
//real life genelde soyle yapiliyor
//tum xpathler bir interface e yaziliyor oradan implement ediliyor
public class XpathPractice implements Localize {

    //static String userNameLocator="//label[text()='Username']/following-sibling::input";
    public static void main(String[] args) {

        WebDriver driver= DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/login");
        BrowserUtils.wait(2);
        WebElement element=driver.findElement(By.xpath(userNameLocator));
        element.sendKeys("tomsmith");
        BrowserUtils.wait(1);

        WebElement element1=driver.findElement(By.xpath(passwordLocator));
        element1.sendKeys("SuperSecretPassword");
        BrowserUtils.wait(1);


        //button[@type='submit' or @id='wooden_spoon']
        driver.findElement(By.xpath(loginBtnLocator)).click();
        BrowserUtils.wait(2);




        driver.quit();


    }
}
