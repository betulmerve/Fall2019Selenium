package com.automation.tests.homework;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Softskill_HW {

    private WebDriver driver=Driver.getDriver();
    private WebDriverWait wait;


    @Test
    public void createVehicleModelTest(){
        driver.get("https://qa2.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager67");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);

        Actions actions=new Actions(driver);
        BrowserUtils.waitForPageToLoad(10);
        actions.moveToElement(driver.findElement(By.xpath("//span[@class='title title-level-1' and contains(text(),'Fleet')]"))).
                perform();
        BrowserUtils.wait(5);
        WebElement vehicleModel=driver.findElement(By.xpath("//span[@class='title title-level-2' and text()='Vehicles Model']"));
        vehicleModel.click();
        BrowserUtils.wait(5);
        driver.findElement(By.partialLinkText("Create Vehicles Model")).click();
        BrowserUtils.wait(5);
        driver.findElement(By.cssSelector("[id^=custom_entity_type_ModelName]")).sendKeys("Civic");
        driver.findElement(By.cssSelector("[id^=custom_entity_type_Make]")).sendKeys("Honda");
        Select selectRequest=new Select(driver.findElement(By.cssSelector("[id^='custom_entity_type_Canberequested']")));
        selectRequest.selectByVisibleText("No");
        driver.findElement(By.cssSelector("[id^=custom_entity_type_CatalogValue]")).sendKeys("100");
        driver.findElement(By.cssSelector("[id^=custom_entity_type_CO2Fee]")).sendKeys("100");
        driver.findElement(By.cssSelector("[id^=custom_entity_type_Cost]")).sendKeys("100");
        driver.findElement(By.cssSelector("[id^=custom_entity_type_TotalCost]")).sendKeys("100");
        driver.findElement(By.cssSelector("[id^=custom_entity_type_CO2Emissions]")).sendKeys("100");
        Select selectFuel=new Select(driver.findElement(By.cssSelector("[id^='custom_entity_type_FuelType']")));
        selectFuel.selectByVisibleText("Gasoline");
        driver.findElement(By.cssSelector("[id^=custom_entity_type_Vendors]")).sendKeys("Xray");
        BrowserUtils.wait(5);
        driver.findElement(By.xpath("//button[@class='btn btn-success action-button']")).click();
        BrowserUtils.wait(5);
        Driver.closeDriver();

    }

}
