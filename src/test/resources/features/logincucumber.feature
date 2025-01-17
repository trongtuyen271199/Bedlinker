# @Ignore
Feature: Login functionality cucumber

  Scenario Outline: Login case
    Given the user is on the homepage
    When user enters username "<username>"
    When user enters password "<pass>"
    When user submit login
    Then verify login successfully "<expectedMessageLoginSuccess>"

    Examples: Page titles
      | username                       | pass            | expectedMessageLoginSuccess |
      | admin                          | Admin#2021      | true                        |    