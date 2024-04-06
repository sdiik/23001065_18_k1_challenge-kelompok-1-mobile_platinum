@SoldProducts
Feature: Mobile sold product feature

  @Positive
  Scenario: TC.MOBILE.36-Seller gets list of product sold
    Given seller already in account page
    When seller click my selling list
    Then seller will successfull gets list of products sold

  @Negative
  Scenario: TC.MOBILE.37-Seller cannot gets list of product sold
    Given seller already in account page
    When seller click my selling list
    Then seller will unsuccessfull gets list of products sold
