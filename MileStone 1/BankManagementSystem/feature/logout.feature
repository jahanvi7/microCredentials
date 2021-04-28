Feature: Logout Scenerios

	@P51
	Scenario: Logout without login
		Given I have not logged in
		When I try to logout without login
		Then Error Message shows
		
	@P52
	Scenario: Logout after login
		Given I have Logged in
		When I try to logout
		Then Logout Sucessful