package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AddUserPage extends Utility {

    private static final Logger log = LogManager.getLogger(AddUserPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//div[@class='orangehrm-card-container']/h6")
    WebElement addUserText;

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='User Role']/parent::div/following-sibling::div//div[@class='oxd-select-wrapper']")
    WebElement selectUserRoleDropdown;

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='Employee Name']/parent::div/following-sibling::div//input")
    WebElement employeeNameField;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-autocomplete-text-input--after']")
    WebElement employeeNameAutoComplete;

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='Username']/parent::div/following-sibling::div//input")
    WebElement userNameField;

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='Status']/parent::div/following-sibling::div//div[@class='oxd-select-wrapper']")
    WebElement selectStatusDropdown;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']")
    WebElement confirmPasswordField;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement saveButton;

    @CacheLookup
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']")
    WebElement successToastMessage;

    public String getAddUserText(){
        log.info("Getting Add User text "+addUserText.toString());
        return getTextFromElement(addUserText);
    }

    public void setSelectUserRoleDropdown(String role){
        mouseHoverToElementAndClick(selectUserRoleDropdown);
        typeKeysAndEnter(role.split("")[0]);
        log.info("Selecting User roles "+selectUserRoleDropdown.toString()+" as "+role);
    }
    public void setEmployeeNameField(String empName) throws InterruptedException {
        sendTextToElement(employeeNameField, empName);
        Thread.sleep(5000);
        selectAutoPopulateFirstEntryByArrowKeysAndEnter(employeeNameField);
        log.info("Entering the Employee Name "+employeeNameField.toString()+" as "+empName);
    }

    public void setUserNameField(String uName){
        sendTextToElement(userNameField, uName);
        log.info("Entering the Username "+userNameField.toString()+" as "+uName);
    }

    public void setSelectStatusDropdown(String status){
        mouseHoverToElementAndClick(selectStatusDropdown);
        typeKeysAndEnter(status.split("")[0]);
        log.info("Selecting Status "+selectStatusDropdown.toString()+" as "+status);
    }

    public void setPasswordField(String pwd){
        sendTextToElement(passwordField,pwd);
        log.info("Entering password "+passwordField.toString());
    }

    public void setConfirmPasswordField(String cpwd){
        sendTextToElement(confirmPasswordField,cpwd);
        log.info("Entering password confirmation "+confirmPasswordField.toString());
    }
    public void clickOnSaveButton(){
        clickOnElement(saveButton);
        log.info("Clicking on Save button"+saveButton.toString());
    }

    public String getSuccessToastMessage(){
        log.info("Getting success message "+successToastMessage.toString());
        return getTextFromElement(waitForElementWithFluentWait(successToastMessage,10,2));
    }
}
