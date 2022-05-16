package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.Loginpage;
import pages.UserRegistrationpage;

public class UserRegistrationTestWithDDTandDataProvider extends TestBase {
	HomePage home;
	UserRegistrationpage register;
	Loginpage login;
 
	@DataProvider(name="testData")
	public static Object[][] userData(){
		return new Object[][] {
			{"Aml","wael","Amlxxx@gmail.com","El Asher","123456"},
			{"Nada","Mokhtar","Nadaxxx@gmail.com","ITI","1234567"}
		};
		
	}
	
	@Test(priority = 1, dataProvider = "testData")//same as @DataProvider(name="testData")<---
	public void UserCanRegisterSuccessfully(String Fname, String Lname, String Email,String Company, String password)
	{//7tena kol 7aga fe method wa7da 3lsha el dataprovider msh ht5rog mnl mehid l8aiedt ma t5ls kol el data ele fel userData
		home = new HomePage(driver);
		home.openRegistrationPage();
		register = new UserRegistrationpage(driver);
		register.UserRegistration(Fname, Lname, Email, Company, password);
		Assert.assertTrue(register.SuccessRegistrationMsg.getText().equals("Your registration completed"));
		register.userLogOut();
		home.openLoginPage();
		login = new Loginpage(driver);
		login.userLogin( Email, password);
		//Assert.assertTrue(register.LogOutBtn.isDisplayed()); //OR
		Assert.assertTrue(register.LogOutBtn.getText().equals("Log out"));
		register.userLogOut();
	}
	@Test(dependsOnMethods ="UserCanRegisterSuccessfully",enabled = false)
	public void RegistereduserCanLogOut() {
		register.userLogOut();
	}
	@Test(dependsOnMethods ="RegistereduserCanLogOut",enabled = false)
	public void RegistereduserCanLogIn() {
		home.openLoginPage();
		login = new Loginpage(driver);
		login.userLogin( "Nada275@gmail.com", "123456");
		//Assert.assertTrue(register.LogOutBtn.isDisplayed()); //OR
		Assert.assertTrue(register.LogOutBtn.getText().equals("Log out"));
	}
}
