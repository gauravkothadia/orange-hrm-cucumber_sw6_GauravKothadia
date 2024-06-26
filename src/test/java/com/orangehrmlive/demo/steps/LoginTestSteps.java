package com.orangehrmlive.demo.steps;

import com.orangehrmlive.demo.pages.DashboardPage;
import com.orangehrmlive.demo.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginTestSteps {
    @And("I click on Login button")
    public void iClickOnLoginButton() {
        new LoginPage().clickOnLoginButton();
    }

    @Then("I should see the message {string} after successful login")
    public void iShouldSeeTheMessageAfterSuccessfulLogin(String message) {
        Assert.assertEquals(new DashboardPage().getDashboardHeading(),message);
    }

    @When("I enter username on login page as {string}")
    public void iEnterUsernameOnLoginPageAs(String uName) {
        new LoginPage().enterUserName(uName);
    }

    @And("I enter password on login page as {string}")
    public void iEnterPasswordOnLoginPageAs(String password) {
        new LoginPage().enterPassword(password);
    }

    @Then("I should be able to see the logo displayed")
    public void iShouldBeAbleToSeeTheLogoDisplayed() {
        Assert.assertTrue(new DashboardPage().isLogoDisplayed());
    }

    @And("I click on user profile logo")
    public void iClickOnUserProfileLogo() {
        new DashboardPage().clickOnUserProfile();
    }

    @And("I mouse hover on Logout and click")
    public void iMouseHoverOnLogoutAndClick() {
        new DashboardPage().mouseHoverToLogOutLinkAndClick();
    }

    @Then("I should be able to see the Login Panel text as {string}")
    public void iShouldBeAbleToSeeTheLoginPanelTextAs(String loginPanelText) {
        Assert.assertEquals(new LoginPage().getLoginPanelText(),loginPanelText);
    }

    @Then("I should see error message as {string}")
    public void iShouldSeeErrorMessageAs(String errorMessage) {
        Assert.assertEquals(new LoginPage().getErrorMessage(),errorMessage);
    }
}
