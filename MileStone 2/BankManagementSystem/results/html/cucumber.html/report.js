$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:feature/login.feature");
formatter.feature({
  "name": "Login Scenerios",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "login is successful with valid credentials",
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
formatter.uri("file:feature/register.feature");
formatter.feature({
  "name": "Registering a new user",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "register new user",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@P1"
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
  "name": "Registration successful",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.RegisterSteps.registration_successful()"
});
formatter.result({
  "error_message": "junit.framework.ComparisonFailure: expected:\u003cUser[ Added]\u003e but was:\u003cUser[name already exists]\u003e\r\n\tat junit.framework.Assert.assertEquals(Assert.java:100)\r\n\tat junit.framework.Assert.assertEquals(Assert.java:107)\r\n\tat steps.RegisterSteps.registration_successful(RegisterSteps.java:48)\r\n\tat ✽.Registration successful(file:///D:/Training/AMEX/BankManagementSystem/feature/register.feature:7)\r\n",
  "status": "failed"
});
});