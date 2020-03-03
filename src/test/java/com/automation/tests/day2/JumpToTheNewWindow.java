package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.plaf.TableHeaderUI;
import java.util.Set;

public class JumpToTheNewWindow {

    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/open_new_tab");

        Thread.sleep(5000);

        //every window has some id, this id calls window handle
        //based on window handle, we can switch in between windows

        String windowHandle=driver.getWindowHandle();
        System.out.println(windowHandle);

        System.out.println("Before switch : "+driver.getCurrentUrl());

        Set<String> windowHandles=driver.getWindowHandles();
        System.out.println(windowHandles);

        //since we have all windows and we know the original id of window
        //we can say switch to something if it is not equals to old window id
        for (String windowId:windowHandles) {

            if (!windowId.equals(windowHandle)) {
                //to jump to the new window
                driver.switchTo().window(windowId);
            }

        }

        System.out.println("After switch : "+driver.getCurrentUrl());

        driver.close();
    }

    //this method helps to switch in between windows based on page title
    public static void switchToWindowBasedOnTitle(String pageTitle, WebDriver driver) {
        Set<String> windows=driver.getWindowHandles();

        for (String eachWindow:windows) {

            driver.switchTo().window(eachWindow);
            if (driver.getTitle().equals(pageTitle)) {
                break;
            }
            
        }
    }
}
