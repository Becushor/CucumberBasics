Feature: LoginFeature
  This feature deals with the login functionality

  Scenario: Login with correct username and password
    Given I navigate to the main web page
    And I click sign in button to insert data
    And I insert correct email and password
      | email                   | password  |
      | blablablatocika@mail.ru | Password1 |
    And I click sign in button
    Then I should see the user page
