package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends Utility {

    private static final Logger log = LogManager.getLogger(DashboardPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-topbar-header-title']//h6")
    WebElement dashboardHeading;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-brand-banner']//img")
    WebElement logoElement;

    @CacheLookup
    @FindBy(xpath = "//img[@class='oxd-userdropdown-img']")
    WebElement userProfileImage;

    @CacheLookup
    @FindBy(linkText = "Logout")
    WebElement logOutLink;

    public String getDashboardHeading(){
        log.info("Getting the Dashboard page heading "+ dashboardHeading.toString());
        return getTextFromElement(dashboardHeading);
    }

    public boolean isLogoDisplayed(){
        log.info("Checking the logo is displayed "+ logoElement.toString());
        return logoElement.isDisplayed();
    }

    public void clickOnUserProfile(){
        clickOnElement(userProfileImage);
        log.info("Clicking on user profile image "+userProfileImage.toString());
    }

    public void mouseHoverToLogOutLinkAndClick(){
        mouseHoverToElementAndClick(logOutLink);
        log.info("Clicking on logout link "+logOutLink.toString());
    }
}
