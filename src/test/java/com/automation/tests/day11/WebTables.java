package com.automation.tests.day11;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class WebTables {
    private WebDriver driver;


    @BeforeMethod
    public void setup(){

        WebDriverManager.chromedriver().version("79").setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        //headless mode makes execution twice faster
        //it does everything except file uploading
        //set it to tru to make it work
        chromeOptions.setHeadless(false); //to run browser without GUI. Makes browser invisible.
        driver=new ChromeDriver(chromeOptions);

        driver.get("http://practice.cybertekschool.com/tables");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
    }

    @Test
    public void getColumnNames(){
        List<String> expected = Arrays.asList("Last Name", "First Name", "Email", "Due", "Web Site", "Action");
        //th represents table header cells
        List<WebElement> columnNames=driver.findElements(By.xpath("//table[1]//th"));
        for (WebElement columnName:columnNames) {
            System.out.println(columnName.getText());
        }

        Assert.assertEquals(BrowserUtils.getTextFromWebElements(columnNames), expected);

    }

    @Test
    public void verifyRowCount(){
        List<WebElement> rows=driver.findElements(By.xpath("//table[1]//tbody//tr"));
        Assert.assertEquals(rows.size(),4);
    }

    @Test
    public void getSpecificColumn(){
        List<WebElement> links=driver.findElements(By.xpath("//table[1]//tbody//tr//td[5]"));
        System.out.println(BrowserUtils.getTextFromWebElements(links));
    }

    @Test
    public void deleteEmail(){
        driver.findElement(By.xpath("//table[1]//td[text()='jsmith@gmail.com']/..//a[text()='delete']")).click();
        BrowserUtils.wait(3);
        List<WebElement> rows=driver.findElements(By.xpath("//table[1]//tbody//tr"));
        Assert.assertEquals(rows.size(),3);
        List<WebElement> emails=driver.findElements(By.xpath("//table[1]//td[text()='jsmith@gmail.com']"));
        Assert.assertTrue(emails.isEmpty());
    }

    @Test
    public void getColumnIndexByName(){
        String columnName="Email";
        List<WebElement> columnNames=driver.findElements(By.xpath("//table[2]//th"));

        int index=0;
        for (int i = 0; i < columnNames.size(); i++) {
            String actualColumnName=columnNames.get(i).getText();

            System.out.println(String.format("Column name: %s, position %s",actualColumnName,i));

            if (actualColumnName.equals(columnName)) {
                index=i+1;
                break;
            }
        }
        Assert.assertEquals(index,3);

    }

    @Test
    public void getSpecificCell(){
        String expected="jsmith@gmail.com";
        int row=3;
        int column=5;
        String xpath="//table[1]//tbody//tr["+row+"]//td["+column+"]";

        WebElement cell=driver.findElement(By.xpath(xpath));

        Assert.assertEquals(cell.getText(),expected);
    }

    @AfterMethod
    public void tearDown(){
        BrowserUtils.wait(2);
        driver.quit();
    }

    ////table[1]//td[text()='jsmith@gmail.com']//following-sibling::td/a[text()='delete']
    //same but easier
    ////table[1]//td[text()='jsmith@gmail.com']/..//a[text()='delete']
    //more easier
    ////table[1]//td[text()='jsmith@gmail.com']/..//a[2]
}
