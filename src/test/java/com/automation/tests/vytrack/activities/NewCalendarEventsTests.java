package com.automation.tests.vytrack.activities;

import com.automation.pages.LoginPage;
import com.automation.pages.activities.CalendarEventsPage;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.DateTimeUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class NewCalendarEventsTests extends AbstractTestBase {

    LoginPage loginPage=new LoginPage();
    CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
    /*
     * Test Case: Default options
     * Login as sales manager
     * Go to Activities --> Calendar Events
     * Click on Create Calendar Event
     * Default owner name should be current user/

     */

    @Test
    public void defaultOptionsTest(){
        loginPage.login();
        calendarEventsPage.navigateTo("Activities","Calendar Events");
        calendarEventsPage.clickToCreateCalender();
        Assert.assertEquals(calendarEventsPage.getOwnerName(), calendarEventsPage.getCurrentUserName());
        String actualStartDate=calendarEventsPage.getStartDate();
        String expectedStartDate=DateTimeUtilities.getTodaysDate("MMM dd, yyyy");
        Assert.assertEquals(actualStartDate,expectedStartDate);
    }

    /*
     * Test Case: Time difference
     * Login as sales manager
     * Go to Activities --> Calendar Events
     * Click on Create Calendar Event
     *
     * Verify that difference between start and end time is 1 hour
     */

    @Test
    public void timeDifferenceTest(){
        loginPage.login();
        calendarEventsPage.navigateTo("Activities","Calendar Events");
        calendarEventsPage.clickToCreateCalender();
        String startTime=calendarEventsPage.getStartTime();
        String endTime=calendarEventsPage.getEndTime();
        String format="h:m a";
        long actual=DateTimeUtilities.getTimeDifference(startTime,endTime,format);
        Assert.assertEquals(actual,1,"Time difference is not correct");

    }

    @Test
    public void verifyColumnNamesTest(){

        loginPage.login();
        calendarEventsPage.navigateTo("Activities","Calendar Events");

        List<String> expected= Arrays.asList("TITLE", "CALENDAR", "START", "END", "RECURRENT", "RECURRENCE", "INVITATION STATUS");

        Assert.assertEquals(calendarEventsPage.getColumnNames(),expected);
    }
}
