Feature: Authorization Feature

Scenario: TC.MOBILE.6-User Login with the valid credential (valid email and password)
    Given user on the Login page
    When user input the valid credential of username and password
    And user click Masuk button
    Then user will be redirect to Account page
    
Scenario: TC.MOBILE.7-User want to login using incorrect credential (invalid credentials or credentials didn't exist)
    Given user on the Login page
    When user input wrong credential of username and password
    And user click Masuk button
    Then user will see a notification username and password are invalid

Scenario: TC.MOBILE.8-User tries to login with empty required fields
    Given user on the Login page
    When user did not input any value into required fields
    And user click Masuk button
    Then user will see a notification user must fill email field first
    
Scenario: TC.WEB.9-User Logout to exit current session
		Given user succesfully login to the app 
    When user on Account page
    Then user click Logout button