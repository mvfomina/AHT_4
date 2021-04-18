package com.epam.learn.pageobject;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static com.epam.learn.actions.Elements.findElementWithWait;

public class LoginPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(LoginPage.class.getSimpleName());


    private final String LOGIN_PAGE_TITLE = propertyManager.getProperty("loginpage.title");

    @FindBy(xpath = "//*[@class=\"uui-caption _1djZg _28khP _371ux\" and contains(text(),'Log In')]")
    public WebElement loginPageClick;

    @FindBy(xpath = "//*[@id=\"username\"]")
    public WebElement emailText;

    @FindBy(xpath = "//*[@id=\"password\"]")
    public WebElement passwordText;

    @FindBy(xpath = "//*[@id=\"kc-login-next\"]")
    public WebElement continueButton;

    @FindBy(xpath = "//*[@id=\"kc-login\"]")
    public WebElement submitButton;


    @FindBy(xpath = "//*[@class=\"error-text\"]")
    public WebElement errorMessage;

    public LoginPage(WebDriver driver, PropertyManager propertyManager){
        super(driver, propertyManager);
    }

    @Step("Open login page")
    public LoginPage open() {
        logger.info("Trying to open login page");
        loginPageClick.click();
        checkPageTitle(LOGIN_PAGE_TITLE, logger);
        return this;
    }


    @Step("Insert Email")
    public LoginPage insertEmail(String email){
        logger.info("Inserting email");
        emailText.sendKeys(email);
        return this;
    }

    @Step("Insert Password")
    public LoginPage insertPassword(String password){
        logger.info("Inserting password");
       // WebElement textbox = driver.findElement(By.id("password"));
       // textbox.sendKeys(Keys.ENTER);
//findElementWithWait(passwordText.findElement(), driver,logger).sendKeys(Keys.ENTER);
        passwordText.sendKeys(password);
      //  enterTextIntoField(passwordText.getText(), password,logger);
        return this;
    }

    @Step("Press Continue button")
    public LoginPage clickContinueButton(){
        logger.info("Click continue button");
        continueButton.click();
   //     clickOnElement(CONTINUE_BUTTON, logger);
        return this;
    }

    @Step("Press Submit button")
    public LoginPage clickSubmitButton(){
        logger.info("Click continue button");
        submitButton.click();
      //  clickOnElement(SUBMIT_BUTTON, logger);
        return this;
    }
}
