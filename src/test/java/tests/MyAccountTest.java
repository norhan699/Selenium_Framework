package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.Loginpage;
import pages.MyAccountPage;
import pages.UserRegistrationpage;

public class MyAccountTest  extends TestBase  {
	HomePage home;
	UserRegistrationpage register;
	Loginpage login;
	MyAccountPage myAccount;
	String FirstName ="Reem";
	String LastName ="Medhat";
	String Email ="Reem877@gmail.com";
	String CompanyName= "El Asher";
	String oldPass="123456";
	String newPass="123456789";
 
	@Test(priority = 1)
	public void UserCanRegisterSuccessfully()
	{
		home = new HomePage(driver);
		home.openRegistrationPage();
		register = new UserRegistrationpage(driver);
		register.UserRegistration(FirstName, LastName, Email,CompanyName , oldPass);
		Assert.assertTrue(register.SuccessRegistrationMsg.getText().equals("Your registration completed"));
	}
	

	@Test(dependsOnMethods = "UserCanRegisterSuccessfully")
	public void UserGoToChangePasswordPage() {
		register.userEnterMyAccountPage();
		myAccount = new MyAccountPage(driver);
		myAccount.RedirecttoChangePassPage();
		
	}
	@Test(dependsOnMethods = "UserGoToChangePasswordPage")
	public void UserChangePasswordSuccessfully() {
		
		myAccount.userChangeHisPass(oldPass, newPass);
		
	}
}
