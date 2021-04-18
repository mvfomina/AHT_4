package com.epam.learn;

import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExploreScheduleCourses extends BaseTest {

    @Test
    public void exploreScheduleCourses(){
        homePage.open();
        explorePage.open();
        explorePage.clickSchedule();
        assertScheduleCourses();

    }
    @Step("Check schedule courses")
    private void assertScheduleCourses(){
        logger.info("Check schedule courses");
        Assert.assertTrue(explorePage.foundCourse.isDisplayed());
    }
}