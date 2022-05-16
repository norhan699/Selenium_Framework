package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.UserRegistrationpage;
import tests.TestBase;

public class UserRegistration extends TestBase{
	HomePage homeObject;
	UserRegistrationpage registerObject;
	@Given("the user in home page")
	public void the_user_in_home_page() {
	  homeObject = new HomePage(driver);
	  homeObject.openRegistrationPage();
	}
	@When("i click on register button")
	public void i_click_on_register_button() {
	  Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	}
	@When("i entered the user data")
	public void i_entered_the_user_data() {
		registerObject = new UserRegistrationpage(driver);
		registerObject.UserRegistration("mum", "mamy", "mum@gmail.com", "iti", "12345678");
	}
	@Then("the registration page displayed successfully")
	public void the_registration_page_displayed_successfully() {
	   registerObject.userLogOut();
	}

}
