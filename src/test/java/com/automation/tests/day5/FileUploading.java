package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploading {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver=new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/upload");
        BrowserUtils.wait(2);

        WebElement upload=driver.findElement(By.id("file-upload"));
        //String filePath=System.getProperty("user.dir")+"/pom.xml"; //user working directory
        String filePath="/Users/mervefaki/Desktop/download.jpeg";
        //sag tikla option tusuna bas copy as a pathname de
        upload.sendKeys(filePath);
        BrowserUtils.wait(2);

        driver.findElement(By.id("file-submit")).click(); //to upload
        BrowserUtils.wait(2);
        WebElement heading=driver.findElement(By.tagName("h3"));
        System.out.println(heading.getText());

        System.out.println(driver.findElement(By.id("uploaded-files")).getText());


        driver.quit();
    }
}
