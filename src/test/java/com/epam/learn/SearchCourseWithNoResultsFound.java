package com.epam.learn;

import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchCourseWithNoResultsFound extends BaseTest {

    @Test
    public void SearchCourseWithNoResultsFound() {
        homePage.open();
        explorePage.open();
        explorePage.insertSearchedText("sadf saf afa sf saf", logger);
        assertMessage();

    }

    @Step("Check item not found message")
    private void assertMessage(){
        logger.info("Verifying item not found message");

        Assert.assertTrue(explorePage.notFoundCourseText.isDisplayed());
    }
}