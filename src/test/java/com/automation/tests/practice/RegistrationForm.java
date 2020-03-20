package com.automation.tests.practice;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationForm {

    private String URL="http://practice.cybertekschool.com/registration_form";
    private WebDriver driver;
    private By firstNameBy=By.name("firstname");
    private By lastNameBy=By.name("lastname");
    private By userNameBy=By.name("username");
    private By emailBy=By.name("email");
    private By passwordBy=By.name("password");
    private By phoneBy=By.name("phone");
    private By genderBy=By.cssSelector("input[value='female']");
    private By birthdayBy=By.name("birthday");
    private By departmentBy=By.name("department");
    private By jobTitleBy=By.name("job_title");

    //languages
    private By cplusplusBy = By.xpath("//label[text()='C++']/preceding-sibling::input");
    private By javaBy = By.xpath("//label[text()='Java']/preceding-sibling::input");
    private By javascriptBy = By.xpath("//label[text()='JavaScript']/preceding-sibling::input");




    @Test
    public void test1(){
        driver.findElement(firstNameBy).sendKeys("Merve");
        driver.findElement(lastNameBy).sendKeys("Cakir");
        driver.findElement(userNameBy).sendKeys("mervecakir");
        driver.findElement(emailBy).sendKeys("merve.cakir@gmail.com");
        driver.findElement(passwordBy).sendKeys("12345678");
        driver.findElement(phoneBy).sendKeys("203-415-6632");
        driver.findElement(genderBy).click();
        driver.findElement(birthdayBy).sendKeys("01/01/1990");

        Select departmentSelect=new Select(driver.findElement(departmentBy));
        departmentSelect.selectByVisibleText("Department of Engineering");

        Select jobtTitleSelect=new Select(driver.findElement(jobTitleBy));
        jobtTitleSelect.selectByVisibleText("SDET");

        driver.findElement(By.id("inlineCheckbox1")).click();
        driver.findElement(By.id("inlineCheckbox2")).click();
        BrowserUtils.wait(3);

        driver.findElement(By.id("wooden_spoon")).click();

        String expected="You've successfully completed registration!";
        String actual=driver.findElement(By.tagName("p")).getText();
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void verifyFirstNameLength(){
        driver.findElement(firstNameBy).sendKeys("a");
        BrowserUtils.wait(3);
        WebElement warningMessage=driver.findElement(By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']"));
        Assert.assertTrue(warningMessage.isDisplayed());
    }

    @Test
    public void verifyAlphabeticLettersOnly(){
        driver.findElement(firstNameBy).sendKeys("12");
        BrowserUtils.wait(2);
        WebElement warningMes2=driver.findElement(By.xpath("//small[text()='first name can only consist of alphabetical letters']"));
        Assert.assertTrue(warningMes2.isDisplayed());
    }


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
