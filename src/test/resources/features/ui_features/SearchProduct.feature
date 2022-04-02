@search

Feature: SearchProduct

  Scenario Outline: SearchCriteria

    Given user is on the home page
    And user clicks to login
    When user enters correct credentials "username" "password"
    And  user selects "<category>" from dropdown
    Then user enters "<keyword>" on search button
    And  user checks that all results contain "<keyword>"
    Then user closes browser

    Examples: keywords
      | category | keyword     |
      #| Baby     | kinderwagen |
      #| Bücher   | kafka       |
      | Computer | macbook     |


