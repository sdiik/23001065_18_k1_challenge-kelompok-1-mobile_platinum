Feature: Mobile sold product feature

  @Positive
  Scenario: TC.MOBILE.34-Seller gets list of product sold
    Given seller already in account page
    When seller click my selling list
    Then seller will successfull gets list of products sold

  @Negative
  Scenario: TC.MOBILE.35-Seller cannot gets list of product sold
    Given seller already in account page
    When seller click my selling list
    Then seller will unsuccessfull gets list of products sold
