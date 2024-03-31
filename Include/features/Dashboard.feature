Feature: Dashboard Feature

Scenario Outline: <case_id>-User on <page> can go back to Dashboard
    Given user is on <page> page
    When user want to return to the home page
    Then user click Beranda button in bottom bar
    
    Examples: 
    | case_id        | page         |
    | TC.MOBILE.10	 | notification |
    | TC.MOBILE.11	 | transaction  |
    | TC.MOBILE.12	 | account      |