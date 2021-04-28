package steps;

import static io.restassured.RestAssured.given;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class LoginSteps {

	private RequestSpecification request;
	private Response response;
	Cookies cookies ;

	@Given("^I am on Login Page$")
	public void i_am_on_Login_Page() throws Throwable {
		RestAssured.baseURI = "http://localhost:8080";
	}

	@When("^I give username and password$")
	public void i_give_username_and_password() throws Throwable {
		String username = "swami";
		String password = "swami123";
		request = given().body("{ \"username\":\"" + username + "\", \"password\":\"" + password + "\"}");
		response = request.when().get("/login");
	}

	@Then("^I should login successfully$")
	public void i_should_login_successfully() throws Throwable {
		Assert.assertEquals("Login Successful", response.then().assertThat().extract().body().asString());
	}

	@When("I give wrong username and password")
	public void i_give_wrong_username_and_password() {
		String username = "swamii";
		String password = "swami123";
		request = given().body("{ \"username\":\"" + username + "\", \"password\":\"" + password + "\"}");
		response = request.when().get("/login");
	}

	@Then("Login Failed")
	public void login_Failed() {
		Assert.assertEquals("Invalid Credentials", response.then().assertThat().extract().body().asString());
	}
	
	@Given("I have already logged in")
	public void i_have_already_logged_in() {
		RestAssured.baseURI = "http://localhost:8080";
		String username = "swami";
		String password = "swami123";
		request = given().body("{ \"username\":\"" + username + "\", \"password\":\"" + password + "\"}");
		response = request.when().get("/login");
		cookies = response.getDetailedCookies();
	}

	@When("I try to login again")
	public void i_try_to_login_again() {
		String username = "monica";
		String password = "monica123";
		request = given().cookies(cookies).body("{ \"username\":\"" + username + "\", \"password\":\"" + password + "\"}");
		response = request.when().get("/login");
	}

	@Then("I am not able to login")
	public void i_am_not_able_to_login() {
		Assert.assertEquals("A User Already Logged In", response.then().assertThat().extract().body().asString());
	}
}
