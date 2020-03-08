package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RadioButtons {

    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().version("79.0").setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().maximize();
        //Thread.sleep(2000);
        BrowserUtils.wait(2);

        List<WebElement> radioButtons=driver.findElements(By.tagName("input"));



        for (WebElement radioButton:radioButtons) {

            //return true if button is already selected
            boolean isSelected=radioButton.isSelected();
            System.out.println(radioButton.getAttribute("id")+" is selected? : "+ isSelected);
            //to check if button can be clicked
            if (radioButton.isEnabled()) {
                radioButton.click();
                System.out.println("Clicked on: "+radioButton.getAttribute("id"));
                BrowserUtils.wait(1);
            } else {
                System.out.println("Button is disabled, not clicked: "+radioButton.getAttribute("id"));
            }
            System.out.println();

        }





        driver.quit();
    }
}
