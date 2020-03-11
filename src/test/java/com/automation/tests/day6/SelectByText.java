package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByText {
    public static void main(String[] args) {

        WebDriver driver= DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(2);
        WebElement simpleDropdown=driver.findElement(By.id("dropdown"));
        Select selectSimpleDropdown=new Select(simpleDropdown);
        selectSimpleDropdown.selectByVisibleText("Option 2");
        BrowserUtils.wait(2);
        selectSimpleDropdown.selectByVisibleText("Option 1");
        BrowserUtils.wait(2);

        //select your DOB

        Select selectYear=new Select(driver.findElement(By.id("year")));
        selectYear.selectByVisibleText("1988");
        Select selectMonth=new Select(driver.findElement(By.id("month")));
        selectMonth.selectByVisibleText("September");
        Select selectDay=new Select(driver.findElement(By.id("day")));
        selectDay.selectByVisibleText("3");


        //select all months one by one
        List<WebElement> months=selectMonth.getOptions();

        for (WebElement month: months) {
            selectMonth.selectByVisibleText(month.getText());
            BrowserUtils.wait(1);
        }


        Select stateSelect=new Select(driver.findElement(By.id("state")));
        stateSelect.selectByVisibleText("Connecticut");
        //option that is currently selected
        String selected=stateSelect.getFirstSelectedOption().getText();
        //sadece getFirstSelectedOption deyince webelement geliyor, value gormek icin getText dememiz lazim
        String expected="Connecticut";

        if (selected.equals(expected)) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }

        List<WebElement> states=stateSelect.getOptions();
        for (WebElement state:states) {
            System.out.println(state.getText());
        }






        BrowserUtils.wait(2);
        driver.quit();

    }
}
