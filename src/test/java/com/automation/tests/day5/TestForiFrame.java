package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestForiFrame {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/iframe");
        BrowserUtils.wait(2);
        //before looking for that element, we need to jump tp that frame
        //you can specify : name, id, index or webelement of the frame
        //it is like we are jumping another layer
        driver.switchTo().frame("mce_0_ifr");

        //now this content will ve visible
        WebElement textInput=driver.findElement(By.id("tinymce"));

        System.out.println(textInput.getText());
        BrowserUtils.wait(2);

        textInput.clear(); //to delete text
        textInput.sendKeys("Hello, World!");

        BrowserUtils.wait(2);


        //exit from the frame
        driver.switchTo().defaultContent();
        WebElement heading=driver.findElement(By.tagName("h3"));
        System.out.println(heading.getText());




        driver.quit();

    }
}
