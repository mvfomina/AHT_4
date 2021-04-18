package com.epam.learn;

import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SearchCourseFound extends BaseTest {

    @Test
    public void SearchCourseWithNoResultsFound() {
        homePage.open();
        explorePage.open();
        explorePage.insertSearchedText("triz for kids", logger);
        assertMessage();

    }

    @Step("Check item found message")
    private void assertMessage(){
        logger.info("Verifying item found message");
        Assert.assertTrue(explorePage.foundCourseText.isDisplayed());
 }
}