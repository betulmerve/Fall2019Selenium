package com.automation.pages.activities;

import com.automation.pages.AbstractPageBase;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CalendarEventsPage extends AbstractPageBase {

    @FindBy(css= "[title='Create Calendar event']")
    private WebElement createCalendarEvent;

    @FindBy(className ="select2-chosen")
    private WebElement owner;

    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_start']")
    private WebElement startDate;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_start']")
    private WebElement startTime;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_end']")
    private WebElement endTime;

    @FindBy(className = "grid-header-cell__label")
    private List<WebElement> columnNames;

    @FindBy(css = "[id^='oro_calendar_event_form_title-uid']")
    private WebElement title;

    @FindBy(css = "iframe[id^='oro_calendar_event_form_description-uid']")
    private WebElement descriptionFrame;

    @FindBy(id = "tinymce")
    private WebElement descriptionTextAre;

    @FindBy(css = "[class='btn-group pull-right'] >button")
    private WebElement saveAndClose;

    @FindBy(xpath = "(//div[@class='control-label'])[1]")
    private WebElement generalInfoTitle;

    @FindBy(xpath = "//label[text()='Description']//following-sibling::div//div")
    private WebElement generalInfoDescription;

    public void enterCalendarEventTitle(String titleValue){
        BrowserUtils.waitForPageToLoad(20);
        BrowserUtils.wait(3);
        wait.until(ExpectedConditions.visibilityOf(title)).sendKeys(titleValue);
        BrowserUtils.wait(3);
    }

    public void enterCalendarEventDescription(String description) {
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(descriptionFrame));
        BrowserUtils.wait(3);
        descriptionTextAre.sendKeys(description);
        driver.switchTo().defaultContent(); //exit from the frame

    }
    public void clickOnSaveAndClose(){
        wait.until(ExpectedConditions.elementToBeClickable(saveAndClose)).click();
    }

    public String getGeneralInfoTitle(){
        BrowserUtils.waitForPageToLoad(20);
        return generalInfoTitle.getText();
    }

    public String getGeneralInfoDescription(){
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Description']//following-sibling::div//div")));
        return generalInfoDescription.getText();
    }


    public String getOwnerName(){
        BrowserUtils.waitForPageToLoad(10);
        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("select2-chosen")));
        wait.until(ExpectedConditions.visibilityOf(owner));
        return owner.getText().trim();
    }

    public void clickToCreateCalenderEvent(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(createCalendarEvent)).click();

    }

    public String getStartDate(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(startDate));
        BrowserUtils.scrollTo(startDate);
        return startDate.getAttribute("value");
    }

    public String getStartTime(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(startTime));
        BrowserUtils.scrollTo(startTime);
        return startTime.getAttribute("value");
    }
    public String getEndTime(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(endTime));
        BrowserUtils.scrollTo(endTime);
        return endTime.getAttribute("value");
    }

    public List<String> getColumnNames(){
        BrowserUtils.waitForPageToLoad(10);
        return BrowserUtils.getTextFromWebElements(columnNames);
    }

}
