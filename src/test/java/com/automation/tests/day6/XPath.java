package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XPath {

    public static void main(String[] args) {

        WebDriver driver= DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        BrowserUtils.wait(2);

        WebElement bt1=driver.findElement(By.xpath("//button[@onclick='button1()']"));
        bt1.click();
        //if you dont know or skip tagname use *
        //it means any tagname
        //   //*[@onclick='button1()']

        System.out.println(driver.findElement(By.id("result")).getText());

        //click on button2
        //WebElement btn2=driver.findElement(By.xpath("//button[@onclick='button2()']"));
        WebElement button2=driver.findElement(By.xpath("//button[text()='Button 2']"));
        //btn2.click();
        button2.click();

        System.out.println(driver.findElement(By.id("result")).getText());

        //button 3 id'nin diger yarisi surekli degisiyor, o yuzden xpath soyle yazabiliriz
        //button[starts-with(@id,'button_')] --to match beginning of an attribute

        WebElement btn3=driver.findElement(By.xpath("//button[starts-with(@id,'button_')]"));
        btn3.click();

        System.out.println(driver.findElement(By.id("result")).getText());

        //button 4
        WebElement btn4=driver.findElement(By.xpath("//button[contains(@id,'button_')][1]"));
        btn4.click();

        System.out.println(driver.findElement(By.id("result")).getText());

        //button 5
        WebElement btn5=driver.findElement(By.xpath("//button[contains(text(), '5')]"));
        btn5.click();

        System.out.println(driver.findElement(By.id("result")).getText());


        //button[contains(@id,'_button')][2]

        BrowserUtils.wait(2);
        driver.quit();

    }
}
