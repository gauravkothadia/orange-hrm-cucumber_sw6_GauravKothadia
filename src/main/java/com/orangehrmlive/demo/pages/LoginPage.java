package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Utility {

    private static final Logger log = LogManager.getLogger(LoginPage.class.getName());

    @CacheLookup
    @FindBy(name = "username")
    WebElement userNameField;

    @CacheLookup
    @FindBy(name = "password")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//h5[normalize-space()='Login']")
    WebElement loginPanelText;

    @CacheLookup
    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
    WebElement requiredErrorMessage;

    @CacheLookup
    @FindBy(xpath = "//i[@class='oxd-icon bi-exclamation-circle oxd-alert-content-icon']")
    WebElement alertIcon;

    @CacheLookup
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
    WebElement invalidCredentialsErrorMessage;


    public void enterUserName(String uName) {
        sendTextToElement(userNameField, uName);
        log.info("Enter username "+ userNameField.toString()+"  data: "+uName);
    }

    public void enterPassword(String password) {
        sendTextToElement(passwordField, password);
        log.info("Enter password "+ passwordField.toString()+"  data: "+password);
    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
        log.info("Clicking on Login link "+loginButton.toString());
    }

    public void loginToTheApplication(String userName, String pwd){
        enterUserName(userName);
        enterPassword(pwd);
        clickOnLoginButton();
    }

    public String getLoginPanelText() {
        String message = getTextFromElement(loginPanelText);
        log.info("Getting Login Panel Text "+ loginPanelText.toString());
        return message;
    }

    public String getErrorMessage(){
        String errorMessage = "";
        if(requiredErrorMessage.isDisplayed()){
            errorMessage = getTextFromElement(requiredErrorMessage);
            log.info("Getting Required message. "+requiredErrorMessage.toString());
        }else if(waitForElementWithFluentWait(alertIcon,10,2).isDisplayed()){
            errorMessage = getTextFromElement(invalidCredentialsErrorMessage);
            log.info("Getting Required message. "+invalidCredentialsErrorMessage.toString());
        }
        else {
            errorMessage="";
        }
        return errorMessage;
    }
}
