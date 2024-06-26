Feature: User Test Features

  @smoke @sanity @regression
  Scenario: Admin should be able to add user successfully
    Given I am on Orange Live HRM home page
    When I logged in to the application with credentials as username "Admin" and password "admin123"
    And I clicked on "Admin" tab
    And I am able to verify heading as System User "System Users" text
    And I clicked on Add button
    And I am able to verify heading as Add User "Add User" text
    And I select user role as "Admin"
    And I enter Employee Name "Joseph Evans"
    And I enter username as "joseph"
    And I select status as "Disable"
    And I enter password as "pwdAbc123#"
    And I enter confirm password as "pwdAbc123#"
    And I click on save button
    Then I should see the verification message "Successfully Saved"

  @sanity @regression
  Scenario: search The User Created And Verify It
    Given I am on Orange Live HRM home page
    When I logged in to the application with credentials as username "Admin" and password "admin123"
    And I clicked on "Admin" tab
    And I am able to verify heading as System User "System Users" text
    And I enter username as "joseph"
    And I select user role as "Admin"
    And I select status as "Disable"
    And I click on the Search button
    Then I should see the user as "joseph" in the result list

  @regression
  Scenario: verify That Admin Should Delete The User Successfully
    Given I am on Orange Live HRM home page
    When I logged in to the application with credentials as username "Admin" and password "admin123"
    And I clicked on "Admin" tab
    And I am able to verify heading as System User "System Users" text
    And I enter username as "joseph"
    And I select user role as "Admin"
    And I select status as "Disable"
    And I click on the Search button
    Then I should see the user as "joseph" in the result list
    When I click on the checkbox next to the user
    And I click on the Delete button
    And a popup displayed and I click on the OK button on the popup
    Then I should see the message "Successfully Deleted"

  @regression
  Scenario Outline: search The User And Verify The Message Record Found
    Given I am on Orange Live HRM home page
    When I logged in to the application with credentials as username "Admin" and password "admin123"
    And I clicked on "Admin" tab
    And I am able to verify heading as System User "System Users" text
    And I enter username as "<username>"
    And I select user role as "<userRole>"
    And I enter Employee Name "<employeeName>"
    And I select status as "<status>"
    And I click on the Search button
    Then I should see the message "(1) Record Found"
    Then I should see the user as "<username>" in the result list
    When I click on the Reset tab

    Examples:
      | username     | userRole | employeeName  | status |
      | Admin        | Admin    | Paul Collings | Enable |
      | Cassidy.Hope | ESS      | Cassidy Hope  | Enable |
      | Nina.Patel   | ESS      | Nina Patel    | Enable |
      | Odis.Adalwin | Admin    | Odis Adalwin  | Enable |