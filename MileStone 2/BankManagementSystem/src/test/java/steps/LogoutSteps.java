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
public class LogoutSteps {
	
	private RequestSpecification request;
	private Response response;
	Cookies cookies ;

	@Given("I have not logged in")
	public void i_have_not_logged_in() {
		RestAssured.baseURI = "http://localhost:8080";
	}

	@When("I try to logout without login")
	public void i_try_to_logout_without_login() {
		request = given();
		response = request.when().get("/logout");
	}

	
	@Then("Error Message shows")
	public void error_Message_shows() {
		Assert.assertEquals("No User Logged in", response.then().assertThat().extract().body().asString());
	}

	@Given("I have Logged in")
	public void i_have_Logged_in() {
		RestAssured.baseURI = "http://localhost:8080";
		String username = "swami";
		String password = "swami123";
		request = given().body("{ \"username\":\"" + username + "\", \"password\":\"" + password + "\"}");
		response = request.when().get("/login");
		cookies = response.getDetailedCookies();
	}

	@When("I try to logout")
	public void i_try_to_logout() {
		request = given().cookies(cookies);
		response = request.when().get("/logout");
	}

	@Then("Logout Sucessful")
	public void logout_Sucessful() {
		Assert.assertEquals("Logout Successful", response.then().assertThat().extract().body().asString());
	}

}
