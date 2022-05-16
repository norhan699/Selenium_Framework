package tests;

//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.HomePage;
import pages.Loginpage;
import pages.UserRegistrationpage;

public class UserRegistrationTestwithDDTAndCSV extends TestBase {
	HomePage home;
	UserRegistrationpage register;
	Loginpage login;
	CSVReader reader;
	@Test
	public void UserCanRegisterSuccessfully() throws CsvValidationException, IOException
	{
		//get path of CSV file
		String CSVFilePath = System.getProperty("user.dir")+"/src/test/java/data/UserData.csv";
		reader =new CSVReader(new FileReader(CSVFilePath));
		String[] csvCell;
		//Loop on data from beginning of the csv file till the end
		while( (csvCell = reader.readNext() ) != null)
		{
			String FirstName   = csvCell[0];
			String lastName    = csvCell[1];
			String Email       = csvCell[2];
			String CompanyName = csvCell[3];
			String Password    = csvCell[4];
			home = new HomePage(driver);
			home.openRegistrationPage();
			register = new UserRegistrationpage(driver);
			register.UserRegistration(FirstName,lastName, Email, CompanyName, Password);
			Assert.assertTrue(register.SuccessRegistrationMsg.getText().equals("Your registration completed"));
			register.userLogOut();
			home.openLoginPage();
			login = new Loginpage(driver);
			login.userLogin( Email, Password);
			//Assert.assertTrue(register.LogOutBtn.isDisplayed()); //OR
			Assert.assertTrue(register.LogOutBtn.getText().equals("Log out"));
			register.userLogOut();
		}
		
	}

}
