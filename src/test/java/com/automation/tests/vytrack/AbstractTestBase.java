package com.automation.tests.vytrack;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import com.automation.utilities.ExcelUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;

public abstract class AbstractTestBase {
    protected WebDriverWait wait;
    protected Actions actions;
    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest test;

    protected static int row=1;
    protected ExcelUtil excelUtil;


    @BeforeTest
    @Parameters("reportName")
    public void setupTest(@Optional String reportName){
        report = new ExtentReports();
        reportName= reportName==null ? "report.html" : reportName+".html";
        String reportPath = "";
        //location of report file
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            reportPath = System.getProperty("user.dir") + "\\test-output\\"+reportName;
        } else {
            reportPath = System.getProperty("user.dir") + "/test-output/"+reportName;
        }
        System.out.println("Report: "+reportName);
        //is a HTML report itself
        htmlReporter = new ExtentHtmlReporter(reportPath);
        //add it to the reporter
        report.attachReporter(htmlReporter);
        htmlReporter.config().setReportName("VYTRACK Test Automation Results");

    }

    @AfterTest
    public void tearDownTest(){
        report.flush();
    }

    @BeforeMethod
   public void setup(){
        String URL= ConfigurationReader.getProperty("qa1");
        Driver.getDriver().get(URL);
        Driver.getDriver().manage().window().maximize();
        wait=new WebDriverWait(Driver.getDriver(),25);
        actions=new Actions(Driver.getDriver());
   }

   @AfterMethod
    public void tearDown(ITestResult iTestResult) throws IOException {
        //if test failed, take a screenshot
        if (iTestResult.getStatus()==ITestResult.FAILURE) {
            String screenshotPath=BrowserUtils.getScreenshot(iTestResult.getName());
            test.fail(iTestResult.getName()); //attach test name that failed
            BrowserUtils.wait(2);
            test.addScreenCaptureFromPath(screenshotPath,"Failed"); //attach screenshot
            test.fail(iTestResult.getThrowable()); //attach console output
            //if excelUtil object was created
            //set value if result column to failed
            if (excelUtil!=null){
                excelUtil.setCellData("FAILED","result",row++);
            }
        }
        BrowserUtils.wait(1);
        Driver.closeDriver();
   }
}
