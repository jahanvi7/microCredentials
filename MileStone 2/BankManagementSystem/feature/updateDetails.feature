Feature: Updating user details

	@P41
		Scenario: Update details without login
		Given I am on update details page
		When I enter user details without login
		Then I cannot update details
		
	@P42
	Scenario: Update details with login
		Given I am on update details page
		When I enter user details
		Then Updated details successfully