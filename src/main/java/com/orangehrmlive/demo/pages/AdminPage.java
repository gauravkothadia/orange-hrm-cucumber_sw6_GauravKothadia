package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AdminPage extends Utility {

    private static final Logger log = LogManager.getLogger(AddUserPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-table-filter-header-title']//h5")
    WebElement systemUserText;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Add']")
    WebElement addButton;

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='Username']/parent::div/following-sibling::div//input")
    WebElement userNameField;

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='User Role']/parent::div/following-sibling::div//div[@class='oxd-select-wrapper']")
    WebElement selectUserRoleDropdown;

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='Status']/parent::div/following-sibling::div//div[@class='oxd-select-wrapper']")
    WebElement selectStatusDropdown;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Search']")
    WebElement searchButton;

    @CacheLookup
    @FindBy(xpath = "//div[@role='columnheader'or normalize-space()='Username'][2]/ancestor::div[@role='rowgroup']/following-sibling::div[@class='oxd-table-body']//div[@class='oxd-table-cell oxd-padding-cell'][2]")
    WebElement searchedUsernameInResult;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-table-card-cell-checkbox']//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']")
    WebElement checkboxOfSearchResultItem;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Delete Selected']")
    WebElement deleteSelectedButton;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Yes, Delete']")
    WebElement yesDeleteButtonOnPopUp;

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='Employee Name']/parent::div/following-sibling::div//input")
    WebElement employeeNameField;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='(1) Record Found']")
    WebElement recordsFound;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Reset']")
    WebElement resetButton;

    public String getSystemUserText(){
        log.info("Getting system users text displayed "+systemUserText.toString());
        return getTextFromElement(systemUserText);
    }

    public void clickOnAddButton(){
        clickOnElement(addButton);
        log.info("Clicking on Add button "+addButton.toString());
    }

    public void setSelectUserRoleDropdown(String role){
        mouseHoverToElementAndClick(selectUserRoleDropdown);
        typeKeysAndEnter(role.split("")[0]);
        log.info("Selecting User roles "+selectUserRoleDropdown.toString()+" as "+role);
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

    public void clickOnSearchButton(){
        clickOnElement(searchButton);
        log.info("Clicking on Search button "+searchButton.toString());
    }
    public String getUsernameFromSearchResult(){
        log.info("Getting username from result list."+searchedUsernameInResult.toString());
        return getTextFromElement(searchedUsernameInResult);
    }

    public void selectTheCheckboxOfResultingUsername(){
        log.info("Selecting in the checkbox of resulting uername "+checkboxOfSearchResultItem.toString());
        clickOnElement(checkboxOfSearchResultItem);
    }

    public void clickOnDeleteSelectedButton(){
        log.info("Click on Delete Selected button "+deleteSelectedButton.toString());
        clickOnElement(deleteSelectedButton);
    }

    public void clickOnYesDeleteButtonOnPopUp(){
        log.info("Click on Yes Delete button on the pop up "+yesDeleteButtonOnPopUp.toString());
        clickOnElement(yesDeleteButtonOnPopUp);
    }

    public void setEmployeeNameField(String empName) throws InterruptedException {
        sendTextToElement(employeeNameField, empName);
        Thread.sleep(5000);
        selectAutoPopulateFirstEntryByArrowKeysAndEnter(employeeNameField);
        log.info("Entering the Employee Name "+employeeNameField.toString()+" as "+empName);
    }

    public String getRecordsFound(){
        log.info("Getting the records found. "+recordsFound.toString());
        return getTextFromElement(recordsFound);
    }

    public void clickOnResetButton(){
        clickOnElement(resetButton);
        log.info("Clicking on Reset button "+resetButton.toString());
    }
}
