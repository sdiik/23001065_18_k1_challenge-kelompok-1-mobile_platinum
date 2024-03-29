Feature: transaction feature

  @positive
  Scenario: TC.MOBILE.1-buyers send trade offers
    Given buyers succesfully register to the app
    When buyers input all correct values for offer information
    Then buyers will successfully send trade offers to sellers

  @negative
  Scenario: TC.MOBILE.2-buyers send trade offers without login to the app
    Given buyers logged out from the app
    When buyers click negotiation button
    Then buyers will be redirected to login page

  @negative
  Scenario: TC.MOBILE.3-tries to input offer price with string value
    Given buyers succesfully register to the app
    When buyers input string values in the offer price box
    Then buyers will not be able to input the string values
