Feature: LoginFeature
  This feature deals with the login functionality

  Scenario: Login with correct username and password
    Given I navigate to the login page
    And I click login button to insert data
    And I insert email, password, profession, fName, lName, coutry
      | email                   | password  | profession | fName | lName | country              |
      | blablablatocika@mail.ru | Password1 | QA         | Nicu  | Gutu  | Moldova, Republic of |
    And I click login button
    Then I should see the userform page
