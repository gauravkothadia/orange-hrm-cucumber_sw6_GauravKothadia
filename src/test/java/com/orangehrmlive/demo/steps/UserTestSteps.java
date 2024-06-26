package com.orangehrmlive.demo.steps;

import com.orangehrmlive.demo.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class UserTestSteps {
    @Given("I am on Orange Live HRM home page")
    public void iAmOnOrangeLiveHRMHomePage() {
    }

    @When("I logged in to the application with credentials as username {string} and password {string}")
    public void iLoggedInToTheApplicationWithCredentialsAsUsernameAndPassword(String uName, String pwd) {
        new LoginPage().loginToTheApplication(uName, pwd);
    }

    @And("I clicked on {string} tab")
    public void iClickedOnTab(String adminTab) {
        new SidePanelNavigationPage().clickOnMenuItemLink(adminTab);
    }

    @And("I am able to verify heading as System User {string} text")
    public void iAmAbleToVerifyHeadingAsSystemUserText(String expectedHeading) {
        Assert.assertEquals(new AdminPage().getSystemUserText(), expectedHeading);
    }

    @And("I clicked on Add button")
    public void iClickedOnAddButton() {
        new AdminPage().clickOnAddButton();
    }

    @And("I am able to verify heading as Add User {string} text")
    public void iAmAbleToVerifyHeadingAsAddUserText(String expectedAddUserHeading) {
        Assert.assertEquals(new AddUserPage().getAddUserText(), expectedAddUserHeading);
    }

    @And("I select user role as {string}")
    public void iSelectUserRoleAs(String role) {
        new AddUserPage().setSelectUserRoleDropdown(role);
    }

    @And("I enter Employee Name {string}")
    public void iEnterEmployeeName(String empName) throws InterruptedException {
        new AddUserPage().setEmployeeNameField(empName);
    }

    @And("I enter username as {string}")
    public void iEnterUsernameAs(String uName) {
        new AddUserPage().setUserNameField(uName);
    }

    @And("I select status as {string}")
    public void iSelectStatusAs(String status) {
        new AddUserPage().setSelectStatusDropdown(status);
    }

    @And("I enter password as {string}")
    public void iEnterPasswordAs(String pwd) {
        new AddUserPage().setPasswordField(pwd);
    }

    @And("I enter confirm password as {string}")
    public void iEnterConfirmPasswordAs(String confirmPwd) {
        new AddUserPage().setConfirmPasswordField(confirmPwd);
    }

    @And("I click on save button")
    public void iClickOnSaveButton() {
        new AddUserPage().clickOnSaveButton();
    }

    @Then("I should see the verification message {string}")
    public void iShouldSeeTheVerificationMessage(String confirmationMessage) {
        Assert.assertEquals(new AddUserPage().getSuccessToastMessage(), confirmationMessage);
    }

    @And("I click on the Search button")
    public void iClickOnTheSearchButton() {
        new AdminPage().clickOnSearchButton();
    }

    @Then("I should see the user as {string} in the result list")
    public void iShouldSeeTheUserAsInTheResultList(String expectedUserName) {
        Assert.assertEquals(new AdminPage().getUsernameFromSearchResult(), expectedUserName);
    }

    @When("I click on the checkbox next to the user")
    public void iClickOnTheCheckboxNextToTheUser() {
        new AdminPage().selectTheCheckboxOfResultingUsername();
    }

    @And("I click on the Delete button")
    public void iClickOnTheButton() {
        new AdminPage().clickOnDeleteSelectedButton();
    }

    @And("a popup displayed and I click on the OK button on the popup")
    public void aPopupDisplayedAndIClickOnTheOKButtonOnThePopup() {
        new AdminPage().clickOnYesDeleteButtonOnPopUp();
    }

    @Then("I should see the message {string}")
    public void iShouldSeeTheMessage(String confirmationMessage) {
        Assert.assertEquals(new ViewSystemUsersPage().getSuccessToastMessage(),confirmationMessage);
    }

    @When("I click on the Reset tab")
    public void iClickOnTheResetTab() {
        new AdminPage().clickOnResetButton();
    }
}
