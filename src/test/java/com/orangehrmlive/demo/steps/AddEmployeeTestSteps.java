package com.orangehrmlive.demo.steps;

import com.orangehrmlive.demo.pages.PIM_AddEmployeePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class AddEmployeeTestSteps {
    @When("I enter Employee first name as {string}")
    public void iEnterEmployeeFirstNameAs(String fName) {
        new PIM_AddEmployeePage().setAddEmployeeFirstName(fName);
    }

    @And("I enter Employee last name as {string}")
    public void iEnterEmployeeLastNameAs(String lName) {
        new PIM_AddEmployeePage().setAddEmployeeLastName(lName);
    }

    @And("I enter additional text to autogenerated id as abc")
    public void iEnterAdditionalTextToAutogeneratedIdAsAbc() {
        new PIM_AddEmployeePage().setAddEmployeeEmployeeID();
    }

    @And("I click on Create Login Details toggle button")
    public void iClickOnCreateLoginDetailsToggleButton() {
        new PIM_AddEmployeePage().clickOnCreateLoginDetailsToggle();
    }

    @And("I entered the username as {string}")
    public void iEnteredTheUsernameAs(String uName) {
        new PIM_AddEmployeePage().setAddEmployeeUsername(uName);
    }

    @And("I selected Enabled radio button")
    public void iSelectedEnabledRadioButton() {
        new PIM_AddEmployeePage().setAddEmployeeEnabled();
    }

    @And("I entered password as {string}")
    public void iEnteredPasswordAs(String pwd) {
        new PIM_AddEmployeePage().setAddEmployeePassword(pwd);
    }

    @And("I password entered in confirm password field")
    public void iPasswordEnteredInConfirmPasswordField() {
        new PIM_AddEmployeePage().setAddEmployeeConfirmPassword();
    }

    @And("I clicked on Save button")
    public void iClickedOnSaveButton() {
        new PIM_AddEmployeePage().clickOnSaveButton();
    }
}
