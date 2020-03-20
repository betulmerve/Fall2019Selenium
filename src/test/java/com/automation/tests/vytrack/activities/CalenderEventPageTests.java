package com.automation.tests.vytrack.activities;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class CalenderEventPageTests {

    private WebDriver driver;
    private Actions actions;
    private String userName="storemanager85";
    private String password="UserUser123";
    private By userNameBy= By.id("prependedInput");
    private By passwordBy=By.id("prependedInput2");
    private By activitiesBy=By.xpath("//span[@class='title title-level-1' and contains(text(), 'Activities')]");
    private By createBtnBy=By.cssSelector("a[title='Create Calendar event']");
    private By currentUserBy=By.cssSelector("#user-menu>a");
    private By ownerBy=By.cssSelector("span[class='select2-chosen']");
    private By titleBy=By.name("oro_calendar_event_form[title]");
    //id nin sonu surekli degistigi icin contains kullandik
    private By startDateBy=By.cssSelector("[id*='date_selector_oro_calendar_event_form_start-uid']");
    private By startTimeBy=By.cssSelector("[id*='time_selector_oro_calendar_event_form_start-uid']");


    @Test
    public void verifyCreateButton(){
        Assert.assertTrue(driver.findElement(createBtnBy).isDisplayed());
    }

    /**
     * Click on Create Calendar Event
     * Default owner name should be current user
     * Default title should be blank
     * Default start date should be current date
     * Default start time should be current time
     */
    @Test(description = "Default options")
    public void verifyDefaultValues(){
        driver.findElement(createBtnBy).click();
        BrowserUtils.wait(3);
        //default name
        String currentUserName=driver.findElement(currentUserBy).getText().trim();
        String ownerName=driver.findElement(ownerBy).getText().trim();
        Assert.assertEquals(currentUserName,ownerName);
        //default title
        //input elements dont contain text! they have value
        String defaultTitle=driver.findElement(titleBy).getAttribute("value");
        Assert.assertTrue(defaultTitle.isEmpty());
        //default start date
        String expectedDate= LocalDate.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
        String actualDate=driver.findElement(startDateBy).getAttribute("value");
        Assert.assertEquals(actualDate,expectedDate);
        //default start time
        //time zone farkli imis o yuzden hata veriyordu California time zone a cevirdik
        String expectedTime= LocalTime.now(ZoneId.of("GMT-7")).format(DateTimeFormatter.ofPattern("h:m a"));
        String actualTime=driver.findElement(startTimeBy).getAttribute("value");
        Assert.assertEquals(actualTime,expectedTime);






    }




    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
        driver.get("https://qa2.vytrack.com/user/login");
        driver.manage().window().maximize();
        actions=new Actions(driver);
        BrowserUtils.wait(3);
        driver.findElement(userNameBy).sendKeys(userName);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(3);
        //hover over activities
        actions.moveToElement(driver.findElement(activitiesBy)).perform();
        BrowserUtils.wait(3);
        driver.findElement(By.linkText("Calendar Events")).click();
        BrowserUtils.wait(5);

    }

    @AfterMethod
    public void tearDown(){
        if (driver!=null) {
            driver.quit();
            driver=null;
        }
    }
}
