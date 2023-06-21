Feature: LoginFeature
  This feature deals with the login functionality

  Scenario: Login with correct username and password
    Given I navigate to the login page
    And I click login button to insert data
    And I insert username and password
      | username | password |
      | admin    | password |
    And I click login button
    Then I should see the userform page
