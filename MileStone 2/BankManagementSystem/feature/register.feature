Feature: Registering a new user

	@P12
	Scenario: Register new user
		Given I am on register page and enter user details
		When I send POST Request
		Then Registration Successful
		
	@P22
	Scenario: Registration with existing username
		Given I am on register page and enter existing user details
		When I send POST Request
		Then Registration Unsuccessful
		
	@P23
	Scenario: Registration while a user already logged in
		Given I am already logged in 
		When I try to register
		Then I am not able to register
		