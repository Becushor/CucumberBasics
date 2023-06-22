Feature: SignUp Feature
  This feature deals with the signup functionality

  Scenario: SignUp with correct credentials
    Given I navigate to the main page
    And I click SignUp button to insert data
    And I insert the following credentials
      | email                   | password  | profession | fName | lName | country              |
      | blablablatocika@mail.ru | Password1 | QA         | Nicu  | Gutu  | Moldova, Republic of |
    And I select the avatar picture
    And I click confirmation button
    Then I should see the popUp
