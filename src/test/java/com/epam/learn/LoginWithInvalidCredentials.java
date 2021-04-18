package com.epam.learn;

import com.epam.learn.pageobject.HomePage;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.epam.learn.actions.Elements.findElementWithWait;

public class LoginWithInvalidCredentials extends BaseTest {
    private static final Logger logger = LogManager.getLogger(HomePage.class.getSimpleName());
    @Test
    public void LoginWithInvalidCredentials(){
        homePage.open();
        loginPage.open();
        loginPage.insertEmail("AHT.test0@gmail.com");
        loginPage.clickContinueButton();
        loginPage.insertPassword("Asdf123451212!");
        loginPage.clickSubmitButton();

        assertIncorrectCredentialsMessage();

    }
    @Step("Check incorrect credentials message")
    private void assertIncorrectCredentialsMessage(){
        logger.info("Verifying incorrect credentials message");
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
    }


}
