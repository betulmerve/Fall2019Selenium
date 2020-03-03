package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitVsClose {

    //.close  --> close 1 window
    //.quit   --> close all windows
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/open_new_tab");

        Thread.sleep(4000);

        driver.close(); //sadece ilk acilan tab kapandi
        //driver.quit(); //tum sekmeler kapandi


    }
}

/*
Selenium can jump in between windows. If you have opened more then 1 window during test execution,
by calling quit() method you can be sure that anything that was opened by webdriver will be closed.
Wheres close() - can close only one window.
Yo jump in  between windows, you need to write a code. Selenium never switch automatically.
 */
