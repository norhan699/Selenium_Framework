package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.Loginpage;
import pages.UserRegistrationpage;

public class UserRegistrationTest extends TestBase {
	HomePage home;
	UserRegistrationpage register;
	Loginpage login;
 
	@Test(priority = 1)
	@Severity(SeverityLevel.CRITICAL)
	@Description("User navigate to home page and enter his credentials")
	@Link(name = "google",url = "http://www.google.com")
	public void UserCanRegisterSuccessfully()
	{
		home = new HomePage(driver);
		home.openRegistrationPage();
		register = new UserRegistrationpage(driver);
		register.UserRegistration("Reham", "Medhat", "Reham275@gmail.com", "El Asher", "123456");
		Assert.assertTrue(register.SuccessRegistrationMsg.getText().equals("Your registration completed"));
	}
	@Test(dependsOnMethods ="UserCanRegisterSuccessfully")
	public void RegistereduserCanLogOut() {
		register.userLogOut();
	}
	@Test(dependsOnMethods ="RegistereduserCanLogOut")
	public void RegistereduserCanLogIn() {
		home.openLoginPage();
		login = new Loginpage(driver);
		login.userLogin( "Ream275@gmail.com", "123456");
		//Assert.assertTrue(register.LogOutBtn.isDisplayed()); //OR
		Assert.assertTrue(register.LogOutBtn.getText().equals("Log out"));
	}
}
