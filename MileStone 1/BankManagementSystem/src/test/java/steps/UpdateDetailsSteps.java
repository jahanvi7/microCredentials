package steps;

import static io.restassured.RestAssured.given;

import com.bank.model.CustomerDetails;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class UpdateDetailsSteps {
	
	private RequestSpecification request;
	private Response response;
	CustomerDetails customer = new CustomerDetails();
	Cookies cookies ;

	@Given("I am on update details page")
	public void i_am_on_update_details_page() {
		RestAssured.baseURI = "http://localhost:8080";
	}

	@When("I enter user details without login")
	public void i_enter_user_details_without_login() {
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
		request = given().body(customer);
		response = request.when().put("/update");
	}

	@Then("I cannot update details")
	public void i_cannot_update_details() {
		Assert.assertEquals("Login to Update the Details", response.then().assertThat().extract().body().asString());
	}
	
	@When("I enter user details")
	public void i_enter_user_details() {
		String username = "jahanvi";
		String password = "jahanvi123";
		request = given().body("{ \"username\":\"" + username + "\", \"password\":\"" + password + "\"}");
		response = request.when().get("/login");
		cookies = response.getDetailedCookies();
		customer.setUsername("jahanvi");
		customer.setName("Jahanvi");
		customer.setPassword("jahanvi123");
		customer.setAccountType("Savings");
		customer.setAddress("Greater Noida");
		customer.setContactNo("9045362287");
		customer.setCountry("India");
		customer.setDateOfBirth("07-08-1998");
		customer.setEmail("jahanvi.gupta@yahoo.com");
		customer.setPan("JEUCS86423Q");
		customer.setState("Uttar Pradesh");
		request = given().cookies(cookies).body(customer);
		response = request.when().put("/update");
	}

	@Then("Updated details successfully")
	public void updated_details_successfully() {
		Assert.assertEquals("Details Updated Successfully", response.then().assertThat().extract().body().asString());
	}
}
