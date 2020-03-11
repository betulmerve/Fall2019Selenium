package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RegistrationForm {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver=new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/registration_form");
        BrowserUtils.wait(2);

        //enter first name
        driver.findElement(By.name("firstname")).sendKeys("Merve");
        BrowserUtils.wait(1);
        driver.findElement(By.name("lastname")).sendKeys("Cakir");
        BrowserUtils.wait(1);
        driver.findElement(By.name("username")).sendKeys("mervecakir");
        BrowserUtils.wait(1);
        driver.findElement(By.name("email")).sendKeys("mcakir@gmail.com");
        BrowserUtils.wait(1);
        driver.findElement(By.name("password")).sendKeys("12345678");
        BrowserUtils.wait(1);
        driver.findElement(By.name("phone")).sendKeys("203-415-6632");
        BrowserUtils.wait(1);

        List<WebElement> genders=driver.findElements(By.name("gender"));
        genders.get(1).click(); //to select female

        driver.findElement(By.name("birthday")).sendKeys("01/03/1989");
        BrowserUtils.wait(1);

        driver.findElement(By.id("inlineCheckbox2")).click();
        BrowserUtils.wait(2);

        driver.findElement(By.id("wooden_spoon")).click();
        BrowserUtils.wait(2);


        driver.quit();


    }
}
