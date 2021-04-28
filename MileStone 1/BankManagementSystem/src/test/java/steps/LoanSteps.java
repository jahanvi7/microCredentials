package steps;

import static io.restassured.RestAssured.given;

import com.bank.model.CustomerDetails;
import com.bank.model.Loan;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class LoanSteps {

	private RequestSpecification request;
	private Response response;
	CustomerDetails customer = new CustomerDetails();
	Loan loan = new Loan();
	Cookies cookies ;
	
	@Given("I have logged in")
	public void i_have_logged_in() {
		RestAssured.baseURI = "http://localhost:8080";
		String username = "swami";
		String password = "swami123";
		request = given().body("{ \"username\":\"" + username + "\", \"password\":\"" + password + "\"}");
		response = request.when().get("/login");
		cookies = response.getDetailedCookies();
	}

	@When("I enter loan details to apply for loan")
	public void i_enter_loan_details_to_apply_for_loan() {
		customer.setUsername("swami");
		customer.setName("Shubham Swami");
		customer.setPassword("swami123");
		customer.setAccountType("Current");
		customer.setAddress("Jaipur");
		customer.setContactNo("9045362287");
		customer.setCountry("India");
		customer.setDateOfBirth("01-01-1982");
		customer.setEmail("shubham.swami@gmail.com");
		customer.setPan("fsfsRGSG45dfs");
		customer.setState("Rajasthan");
		loan.setCustomerDetails(customer);
		loan.setDate("12-11-2020");
		loan.setDurationOfLoan(48);
		loan.setLoanAmount(700000);
		loan.setLoanType("Personal");
		loan.setRateOfInterest(1.7f);
		request = given().cookies(cookies).body(loan);
		response = request.when().post("/applyLoan");
	}

	@Then("Applied for Loan Successfully")
	public void applied_for_Loan_Successfully() {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertEquals("Applied for Loan", response.then().assertThat().extract().body().asString());
	}
	
	@Given("I am on apply loan page")
	public void i_am_on_apply_loan_page() {
		RestAssured.baseURI = "http://localhost:8080";
	}

	@When("I enter loan details without login")
	public void i_enter_loan_details_without_login() {
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
		loan.setCustomerDetails(customer);
		loan.setDate("12-11-2020");
		loan.setDurationOfLoan(48);
		loan.setLoanAmount(700000);
		loan.setLoanType("Personal");
		loan.setRateOfInterest(1.7f);
		request = given().body(loan);
		response = request.when().post("/applyLoan");
	}

	@Then("I cannot apply for loan")
	public void i_cannot_apply_for_loan() {
		Assert.assertEquals("Login to Apply for Loan", response.then().assertThat().extract().body().asString());
	}

}
