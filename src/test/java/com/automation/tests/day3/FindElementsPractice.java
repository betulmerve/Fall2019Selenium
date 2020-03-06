package com.automation.tests.day3;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsPractice {
    public static void main(String[] args) throws Exception {

//        WebDriverManager.chromedriver().setup();
//        WebDriver driver=new ChromeDriver();

        WebDriver driver= DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");
        WebElement fullName=driver.findElement(By.name("full_name"));
        fullName.sendKeys("Betul Cakir");
        Thread.sleep(2000);
        WebElement email=driver.findElement(By.name("email"));
        email.sendKeys("merve.faki@gmail.com");
        Thread.sleep(2000);
        WebElement signUp=driver.findElement(By.name("wooden_spoon"));
        //when you see type="submit", you can use submit() instead of click()
        //it make sense to use when click() method doesn't work
        signUp.submit();
        Thread.sleep(2000);

        String excepted="Thank you for signing up. Click the button below to return to the home page.";
        WebElement message=driver.findElement(By.className("subheader"));
        String actual=message.getText();
        if (excepted.equals(actual)) {
            System.out.println("PASSED!");
        } else {
            System.out.println("FAILED!");
        }



        driver.quit();

    }
}