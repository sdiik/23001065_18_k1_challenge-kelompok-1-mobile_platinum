@SearchProducts
Feature: Mobile get a search products feature

  @Positive
  Scenario: TC.MOBILE.34-User can gets list of products based on correct keyword in the search
    Given user has opened homepage
    When user input alphabert in search field
    Then user will successfully get list of products based on the correct keywords

  @Negative
  Scenario: TC.MOBILE.35-User cannot gets list of products based on uncorrect keyword in the search
    Given user has opened homepage
    When user input characters in search field
    Then user will unsuccessfull get list of products based on the uncorrect keywords
