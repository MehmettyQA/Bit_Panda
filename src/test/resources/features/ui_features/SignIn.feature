@login
  Feature: Register

    Scenario: logging in to amazon

      Given user is on the home page
      And user clicks to login
      When user enters correct credentials "username" "password"
      Then user should login successfully

