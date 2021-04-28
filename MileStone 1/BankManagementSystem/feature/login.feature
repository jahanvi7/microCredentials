Feature: Login Scenerios

  @P1
  Scenario: Login is successful with valid credentials
    Given I am on Login Page
    When I give username and password
    Then I should login successfully

  @P2
  Scenario: Login failed with invalid credentials
  	Given I am on Login Page
    When I give wrong username and password
    Then Login Failed
    
  @P3
  Scenario: Login while a user is already login
  	Given I have already logged in
    When I try to login again
    Then I am not able to login