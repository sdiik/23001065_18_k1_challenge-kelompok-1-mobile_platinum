Feature: CRUD Product Mobile

  Background: User already login
    Given user on the home page
    When user input the valid credential of username and password
    And user click Masuk button
    Then user will be redirect to Account page

  @positive
  Scenario Outline: <case_id>-User can <result> product
    Given user has opened jual page
    When user input valid credential in all required fields and user select <button> in selling page
    Then user successfully <result> product

    Examples: 
      | case_id      | button    | result  |
      | TC.MOBILE.11 | Terbitkan | create  |
      | TC.MOBILE.12 | Preview   | preview |

  @negative
  Scenario: TC.MOBILE.13-User as seller can't leave product picture blank
    Given user has opened jual page
    When user input valid credential in all required fields except upload picture and click terbitkan button in selling page
    Then user will fail create product
