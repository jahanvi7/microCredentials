$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:feature/applyLoan.feature");
formatter.feature({
  "name": "Applying for Loan",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Apply for Loan",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@P31"
    }
  ]
});
formatter.step({
  "name": "I have logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.LoanSteps.i_have_logged_in()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter loan details to apply for loan",
  "keyword": "When "
});
formatter.match({
  "location": "steps.LoanSteps.i_enter_loan_details_to_apply_for_loan()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Applied for Loan Successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.LoanSteps.applied_for_Loan_Successfully()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Applying for loan without login",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@P32"
    }
  ]
});
formatter.step({
  "name": "I am on apply loan page",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.LoanSteps.i_am_on_apply_loan_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter loan details without login",
  "keyword": "When "
});
formatter.match({
  "location": "steps.LoanSteps.i_enter_loan_details_without_login()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I cannot apply for loan",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.LoanSteps.i_cannot_apply_for_loan()"
});
formatter.result({
  "status": "passed"
});
formatter.uri("file:feature/login.feature");
formatter.feature({
  "name": "Login Scenerios",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Login is successful with valid credentials",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@P1"
    }
  ]
});
formatter.step({
  "name": "I am on Login Page",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.LoginSteps.i_am_on_Login_Page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I give username and password",
  "keyword": "When "
});
formatter.match({
  "location": "steps.LoginSteps.i_give_username_and_password()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should login successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.LoginSteps.i_should_login_successfully()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Login failed with invalid credentials",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@P2"
    }
  ]
});
formatter.step({
  "name": "I am on Login Page",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.LoginSteps.i_am_on_Login_Page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I give wrong username and password",
  "keyword": "When "
});
formatter.match({
  "location": "steps.LoginSteps.i_give_wrong_username_and_password()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Login Failed",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.LoginSteps.login_Failed()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Login while a user is already login",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@P3"
    }
  ]
});
formatter.step({
  "name": "I have already logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.LoginSteps.i_have_already_logged_in()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I try to login again",
  "keyword": "When "
});
formatter.match({
  "location": "steps.LoginSteps.i_try_to_login_again()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am not able to login",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.LoginSteps.i_am_not_able_to_login()"
});
formatter.result({
  "status": "passed"
});
formatter.uri("file:feature/logout.feature");
formatter.feature({
  "name": "Logout Scenerios",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Logout without login",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@P51"
    }
  ]
});
formatter.step({
  "name": "I have not logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.LogoutSteps.i_have_not_logged_in()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I try to logout without login",
  "keyword": "When "
});
formatter.match({
  "location": "steps.LogoutSteps.i_try_to_logout_without_login()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Error Message shows",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.LogoutSteps.error_Message_shows()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Logout after login",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@P52"
    }
  ]
});
formatter.step({
  "name": "I have Logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.LogoutSteps.i_have_Logged_in()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I try to logout",
  "keyword": "When "
});
formatter.match({
  "location": "steps.LogoutSteps.i_try_to_logout()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Logout Sucessful",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.LogoutSteps.logout_Sucessful()"
});
formatter.result({
  "status": "passed"
});
formatter.uri("file:feature/register.feature");
formatter.feature({
  "name": "Registering a new user",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Register new user",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@P12"
    }
  ]
});
formatter.step({
  "name": "I am on register page and enter user details",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.RegisterSteps.i_am_on_register_page_and_enter_user_details()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I send POST Request",
  "keyword": "When "
});
formatter.match({
  "location": "steps.RegisterSteps.i_send_POST_Request()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Registration Successful",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.RegisterSteps.registration_successful()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Registration with existing username",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@P22"
    }
  ]
});
formatter.step({
  "name": "I am on register page and enter existing user details",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.RegisterSteps.i_am_on_register_page_and_enter_existing_user_details()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I send POST Request",
  "keyword": "When "
});
formatter.match({
  "location": "steps.RegisterSteps.i_send_POST_Request()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Registration Unsuccessful",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.RegisterSteps.registration_Unsuccessful()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Registration while a user already logged in",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@P23"
    }
  ]
});
formatter.step({
  "name": "I am already logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.RegisterSteps.i_am_already_logged_in()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I try to register",
  "keyword": "When "
});
formatter.match({
  "location": "steps.RegisterSteps.i_try_to_register()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am not able to register",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.RegisterSteps.i_am_not_able_to_register()"
});
formatter.result({
  "status": "passed"
});
formatter.uri("file:feature/updateDetails.feature");
formatter.feature({
  "name": "Updating user details",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Update details without login",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@P41"
    }
  ]
});
formatter.step({
  "name": "I am on update details page",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.UpdateDetailsSteps.i_am_on_update_details_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter user details without login",
  "keyword": "When "
});
formatter.match({
  "location": "steps.UpdateDetailsSteps.i_enter_user_details_without_login()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I cannot update details",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.UpdateDetailsSteps.i_cannot_update_details()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Update details with login",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@P42"
    }
  ]
});
formatter.step({
  "name": "I am on update details page",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.UpdateDetailsSteps.i_am_on_update_details_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter user details",
  "keyword": "When "
});
formatter.match({
  "location": "steps.UpdateDetailsSteps.i_enter_user_details()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Updated details successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.UpdateDetailsSteps.updated_details_successfully()"
});
formatter.result({
  "status": "passed"
});
});