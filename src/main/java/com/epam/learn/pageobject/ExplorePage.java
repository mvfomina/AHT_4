package com.epam.learn.pageobject;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExplorePage extends BasePage {

    private static final Logger logger = LogManager.getLogger(ExplorePage.class.getSimpleName());

    @FindBy(xpath = "//*[contains(text(),'SCHEDULE')]")
    public WebElement scheduleItem;

    @FindBy(xpath = "//*[@class=\"uui-caption\" and contains(text(),'Explore')]")
    public WebElement explorePageClick;

    private final String EXPLORE_PAGE_TITLE = propertyManager.getProperty("explorepage.title");

    @FindBy(xpath = "//*[@class=\"uui-caption\" and contains(text(),'Explore')]")
    public WebElement searchTextInserted;

    @FindBy(xpath = "//*[@class=\"_1u_LK ScheduleViewList_container__3Ul1Z _2NFXE\"]")
    public WebElement foundCourse;

    @FindBy(xpath = "//*[@class=\"BigCard_headerCaption__zpa2N\" and contains(text(),'TRIZ for Kids')]")
    public WebElement foundCourseText;

    @FindBy(xpath = "//*[contains(text(),'No Results Found')]")
    public WebElement notFoundCourseText;

    public ExplorePage(WebDriver driver, PropertyManager propertyManager){
        super(driver, propertyManager);
    }

    @Step("Open login page")
    public ExplorePage open() {
        logger.info("Trying to open login page");
        explorePageClick.click();
        checkPageTitle(EXPLORE_PAGE_TITLE, logger);
        return this;
    }


    @Step("Insert searched text")
    public ExplorePage insertSearchedText(String searchedText, Logger logger){
        logger.info("Inserting searched text");
        searchTextInserted.sendKeys(searchedText);
        //enterTextIntoField(searchTextInserted, searchedText, logger);
        return this;
    }


    @Step("Press Schedule")
    public ExplorePage clickSchedule(){
        logger.info("Click schedule");
        scheduleItem.click();
        return this;
    }

}
