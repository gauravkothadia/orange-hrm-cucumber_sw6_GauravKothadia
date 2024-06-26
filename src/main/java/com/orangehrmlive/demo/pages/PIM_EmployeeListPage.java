package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class PIM_EmployeeListPage extends Utility {

    private static final Logger log = LogManager.getLogger(PIM_EmployeeListPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Add']")
    WebElement addButton;

    public void clickOnAddButton(){
        clickOnElement(addButton);
        log.info("Clicking on the Add button on Employee list section of PIM tab");
    }
}
