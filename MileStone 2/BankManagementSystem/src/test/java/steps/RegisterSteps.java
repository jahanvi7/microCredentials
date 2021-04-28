package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

import static io.restassured.RestAssured.given;

import com.bank.model.CustomerDetails;

@SuppressWarnings("deprecation")
public class RegisterSteps {

	private RequestSpecification request;
	private Response response;
	CustomerDetails customer = new CustomerDetails();
	Cookies cookies;
	
	@Given("^I am on register page and enter user details$")
	public void i_am_on_register_page_and_enter_user_details() {
		RestAssured.baseURI = "http://localhost:8080";
		customer.setUsername("jahanvi");
		customer.setName("Jahanvi");
		customer.setPassword("jahanvi123");
		customer.setAccountType("Savings");
		customer.setAddress("Greater Noida");
		customer.setContactNo("9045362287");
		customer.setCountry("India");
		customer.setDateOfBirth("07-08-1998");
		customer.setEmail("jahanvi.gupta@gmail.com");
		customer.setPan("JEUCS86423Q");
		customer.setState("Uttar Pradesh");
	}

	@When("^I send POST Request$")
	public void i_send_POST_Request() {
		request =  given()
				.body(customer);
		response = request.when()
				.post("/register");
	}

	@Then("^Registration Successful$")
	public void registration_successful() {
		Assert.assertEquals("User Added", response.then().assertThat().extract().body().asString());
	}
	
	@Given("^I am on register page and enter existing user details$")
	public void i_am_on_register_page_and_enter_existing_user_details() throws Throwable {
		RestAssured.baseURI = "http://localhost:8080";
		customer.setUsername("jahanvi");
		customer.setName("Jahanvi");
		customer.setPassword("jahanvi123");
		customer.setAccountType("Savings");
		customer.setAddress("Greater Noida");
		customer.setContactNo("9045362287");
		customer.setCountry("India");
		customer.setDateOfBirth("07-08-1998");
		customer.setEmail("jahanvi.gupta@gmail.com");
		customer.setPan("JEUCS86423Q");
		customer.setState("Uttar Pradesh");
	}

	@Then("^Registration Unsuccessful$")
	public void registration_Unsuccessful() throws Throwable {
		Assert.assertEquals("Username already exists", response.then().assertThat().extract().body().asString());
	}
	
	@Given("^I am already logged in$")
	public void i_am_already_logged_in() throws Throwable {
		RestAssured.baseURI = "http://localhost:8080";
		String username = "swami";
		String password = "swami123";
		request = given().body("{ \"username\":\"" + username + "\", \"password\":\"" + password + "\"}");
		response = request.when().get("/login");
		cookies = response.getDetailedCookies();
	}

	@When("^I try to register$")
	public void i_try_to_register() throws Throwable {
		customer.setUsername("jahanvi");
		customer.setName("Jahanvi");
		customer.setPassword("jahanvi123");
		customer.setAccountType("Savings");
		customer.setAddress("Greater Noida");
		customer.setContactNo("9045362287");
		customer.setCountry("India");
		customer.setDateOfBirth("07-08-1998");
		customer.setEmail("jahanvi.gupta@gmail.com");
		customer.setPan("JEUCS86423Q");
		customer.setState("Uttar Pradesh");
		request =  given().cookies(cookies)
				.body(customer);
		response = request.when()
				.post("/register");
	}

	@Then("^I am not able to register$")
	public void i_am_not_able_to_register() throws Throwable {
		Assert.assertEquals("Cannot Register a user while logged in", response.then().assertThat().extract().body().asString());
	}

	
}
