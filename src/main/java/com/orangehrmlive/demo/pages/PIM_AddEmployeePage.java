package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class PIM_AddEmployeePage extends Utility {

    private static final Logger log = LogManager.getLogger(PIM_AddEmployeePage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement addEmployeeFirstName;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement addEmployeeLastName;

    @CacheLookup
    @FindBy(xpath = "//span[@class='oxd-switch-input oxd-switch-input--active --label-right']")
    WebElement createLoginDetailsToggleButton;

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='Username']/parent::div/following-sibling::div/input")
    WebElement addEmployeeUsername;

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='Employee Id']/parent::div/following-sibling::div/input")
    WebElement addEmployeeEmployeeID;

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='Enabled']")
    WebElement addEmployeeEnabled;

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='Password']/parent::div/following-sibling::div/input")
    WebElement addEmployeePassword;

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='Confirm Password']/parent::div/following-sibling::div/input")
    WebElement addEmployeeConfirmPassword;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement addEmployeeSaveButton;

    static String userNamePart1="";
    static String userNamePart2="";
    static String passwd="";


    public void setAddEmployeeFirstName(String empFirstName){
        sendTextToElement(addEmployeeFirstName,empFirstName);
        userNamePart1=empFirstName;
    }

    public void setAddEmployeeLastName(String empLastName){
        sendTextToElement(addEmployeeLastName,empLastName);
        userNamePart2 = empLastName;
    }

    public void setAddEmployeeEmployeeID(){
        addMoreTextToElement(addEmployeeEmployeeID,"abc");
    }

    public void clickOnCreateLoginDetailsToggle(){
        clickOnElement(createLoginDetailsToggleButton);
    }

    public void setAddEmployeeUsername(String uName){
        sendTextToElement(addEmployeeUsername,userNamePart1+"."+userNamePart2+uName);
    }

    public void setAddEmployeeEnabled(){
        clickOnElement(addEmployeeEnabled);
    }

    public void setAddEmployeePassword(String pwd){
        sendTextToElement(addEmployeePassword,pwd);
        passwd = pwd;
    }

    public void setAddEmployeeConfirmPassword(){
        sendTextToElement(addEmployeeConfirmPassword,passwd);
    }

    public void clickOnSaveButton(){
        clickOnElement(addEmployeeSaveButton);
    }
}
