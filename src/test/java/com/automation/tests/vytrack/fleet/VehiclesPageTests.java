package com.automation.tests.vytrack.fleet;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class VehiclesPageTests {
    private WebDriver driver;
    private String URL="https://qa2.vytrack.com/user/login";
    private String username = "storemanager85";
    private String password = "UserUser123";
    private By usernameBy= By.id("prependedInput");
    private By passwordBy=By.id("prependedInput2");
    private By fleetBy=By.xpath("//span[@class='title title-level-1' and contains(text(), 'Fleet')]");
    private By subTitleBy=By.className("oro-subtitle");
    private By pageNumBy=By.cssSelector("input[type='number']");



    @Test
    public void verifyPageSubTitle(){

        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(10);
        //click to fleet
        //driver.findElement(fleetBy).click();
        //BrowserUtils.wait(2);
        //move to element instead of click
        Actions actions=new Actions(driver);
        //Actions class is used for more advanced browser interactions
        actions.moveToElement(driver.findElement(fleetBy)).perform();
        //every action should end with perform

        BrowserUtils.wait(5);

        driver.findElement(By.linkText("Vehicles")).click();
        BrowserUtils.wait(10);
        WebElement subTitle=driver.findElement(subTitleBy);
        System.out.println(subTitle.getText());

        String expected="All cars";
        String actual=subTitle.getText();
        Assert.assertEquals(expected,actual);


    }

    @Test
    public void verifyPageNumber(){
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(3);
        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(fleetBy)).perform();
        BrowserUtils.wait(3);
        driver.findElement(By.linkText("Vehicles")).click();
        BrowserUtils.wait(5);


        String expected1="1";
        String actual=driver.findElement(pageNumBy).getAttribute("value");
        Assert.assertEquals(expected1,actual);
    }


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void teardown(){
        if (driver!=null) {
            driver.quit();
            driver=null;
        }
    }

}
