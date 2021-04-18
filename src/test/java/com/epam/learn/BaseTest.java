package com.epam.learn;

import com.epam.learn.listeners.TestReporter;
import com.epam.learn.listeners.TestResultsListener;
import com.epam.learn.pageobject.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.*;

@Listeners({TestResultsListener.class, TestReporter.class})
public abstract class BaseTest {

    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static final Logger assertLogger = LogManager.getLogger("Assert");
    protected static final Logger logger = LogManager.getLogger(HomePage.class.getSimpleName());
    protected DriverManager driverManager;
    protected PropertyManager propertyManager;
    protected HomePage homePage = null;
    protected ExplorePage explorePage = null;
    protected LoginPage loginPage = null;

    @Parameters({"browserName","testDataFileName"})
    @BeforeClass
    public void setup(@Optional("Chrome") String browserName
            , @Optional("clothsStore.properties") String testDataFileName){
        driverManager = new DriverManager();
        driver.set(driverManager.getDriver(browserName, "Grid"));
        ITestContext context = Reporter.getCurrentTestResult().getTestContext();
        context.setAttribute("WebDriver", driver.get());

        propertyManager = new PropertyManager(testDataFileName);
        homePage = new HomePage(driver.get(), propertyManager);
        loginPage = new LoginPage(driver.get(), propertyManager);
        explorePage = new ExplorePage(driver.get(), propertyManager);
        loginPage = new LoginPage(driver.get(), propertyManager);
    }

    @AfterMethod
    public void browserReset(){
        driver.get().manage().deleteAllCookies();

    }

    @AfterClass
    public void cleanUp(){
        driver.get().quit();
        driver.remove();
    }
}
