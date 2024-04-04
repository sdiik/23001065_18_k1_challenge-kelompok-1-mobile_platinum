Feature: Authorization Feature

  Scenario: TC.MOBILE.6-User Login with the valid credential (valid email and password)
    Given user on the home page
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
    Then user will see a notification user must fill all the required fields first and user will remain on Login page

  Scenario: TC.WEB.9-User Logout to exit current session
    Given user on the application
    When user click Account button on bottom of page
    And user will redirect to Account page
    Then user click Logout button

  Scenario: TC.MOBILE.16-User opens register page
    Given user has opened login page
    When user clicks Daftar button on the login page
    Then user will be redirected to the register page

  Scenario: TC.MOBILE.17-User registers with valid value requirement on the register page
    Given user has opened register page
    When user fills up all required fields with valid value on the register page
    And user clicks Daftar button on the register page
    Then user will be redirected to the home page

  Scenario: TC.MOBILE.18-User registers with registered email on the register page
    Given user has opened register page
    When user fills up all the required fields with valid value except email field with registered email on the register page
    When user clicks Daftar button on the register page
    Then user will be received error message on the register page
