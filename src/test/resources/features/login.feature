Feature: Login functionality cucumber

  Scenario Outline: Login case
    Given the user is on the homepage
    When user enters username "<usernamel>"
    When user enters password "<pass>"
    When user submit login
    Then verify login error username  "<expectedMessageErrorUsername>"
    Then verify login error pass "<expectedMessageErrorPass>"
    Then verify login null username "<expectedMessageNullUsername>"
    Then verify login null pass "<expectedMessageNullPass>"
    Then verify login successfully "<expectedLoginSuccess>"
    # Then user click avatar
    # Then user submit logout

    Examples:
      | usernamel      | pass            | expectedMessageErrorUsername | expectedMessageErrorPass | expectedMessageNullUsername | expectedMessageNullPass | expectedLoginSuccess |
      | Adminerror     | Admin#2021      | true                         | false                    | false                       | false                   | false               | 
      | admin          | Admin#erro      | false                        | true                     | false                       | false                   | false               | 
      |                | Admin#2021      | false                        | false                    | true                        | false                   | false               |
      | admin          |                 | false                        | false                    | false                       | true                    | false               |
      | admin          | Admin#2021      | false                        | false                    | false                       | false                   | true                |
