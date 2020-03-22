package com.automation.tests.day9;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ActionsTests {

    private WebDriver driver;
    private Actions actions;




    @Test
    public void hoverOnImage(){
        driver.get("http://practice.cybertekschool.com/hovers");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
        WebElement img1=driver.findElement(By.xpath("(//img)[1]"));
        WebElement img2=driver.findElement(By.xpath("(//img)[2]"));
        WebElement img3=driver.findElement(By.xpath("(//img)[3]"));
        //build() is needed when you have couple of actions
        //always end with perform()
        actions.moveToElement(img1).pause(1000).
                moveToElement(img2).pause(1000).
                moveToElement(img3).
                build().perform();
        BrowserUtils.wait(3);
        //hover on the first image, verify "name:user1" is displayed
        actions.moveToElement(img1).perform();
        WebElement imgText1=driver.findElement(By.xpath("//h5[text()='name: user1']"));
        Assert.assertTrue(imgText1.isDisplayed());

        actions.moveToElement(img2).perform();
        WebElement imgText2=driver.findElement(By.xpath("//h5[text()='name: user2']"));
        Assert.assertTrue(imgText2.isDisplayed());

        actions.moveToElement(img3).perform();
        WebElement imgText3=driver.findElement(By.xpath("//h5[text()='name: user3']"));
        Assert.assertTrue(imgText3.isDisplayed());
    }

    @Test
    public void jqueryMenuTest(){
        driver.get("http://practice.cybertekschool.com/jqueryui/menu");
        driver.manage().window().maximize();

        WebElement first=driver.findElement(By.id("ui-id-3"));
        WebElement second=driver.findElement(By.id("ui-id-4"));
        WebElement third=driver.findElement(By.id("ui-id-5"));


        actions.moveToElement(first).pause(1000).
                moveToElement(second).pause(1000).
                click(third).build().perform();
    }
    @Test
    public void dragAndDropTest(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
        //click on accept cookies

       driver.findElement(By.xpath("//button[text()='Accept Cookies']")).click();
        BrowserUtils.wait(2);

        WebElement earth=driver.findElement(By.id("droptarget"));
        WebElement moon=driver.findElement(By.id("draggable"));

        actions.dragAndDrop(moon,earth).perform();

        String expected="You did great!";
        String actual=earth.getText();
        Assert.assertEquals(actual,expected);

    }

    @BeforeMethod
    public void setup(){
        driver= DriverFactory.createADriver("chrome");
        actions=new Actions(driver);


    }

    @AfterMethod
    public void tearDown(){
        BrowserUtils.wait(3);
        driver.quit();
    }
}
