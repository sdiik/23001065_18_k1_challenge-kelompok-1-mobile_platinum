@SearchProductByCategory
Feature: Mobile get a products by category feature

  Scenario Outline: <case_id>-User can filter by <type> the products
    Given user has opened homepage
    When user select and press the <type> button in the category filter
    Then user will successfully get list <type> products

    Examples: 
      | case_id      | type       							|
      | TC.MOBILE.32 | computer and accessories	|
      | TC.MOBILE.33 | electronic								|
