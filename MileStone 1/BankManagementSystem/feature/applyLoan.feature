Feature: Applying for Loan

	@P31
	Scenario: Apply for Loan
		Given I have logged in 
		When I enter loan details to apply for loan
		Then Applied for Loan Successfully
		
	@P32
	Scenario: Applying for loan without login
		Given I am on apply loan page
		When I enter loan details without login
		Then I cannot apply for loan 