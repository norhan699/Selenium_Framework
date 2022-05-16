package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class UserRegistrationpage extends PageBase
{

	public UserRegistrationpage(WebDriver driver) {
		super(driver);
	}
 
	@FindBy(id="gender-male")
	WebElement GenderRdoBtn;
	
	@FindBy(id="FirstName")
	WebElement FirstNameTxt;
	
	@FindBy(id="LastName")
	WebElement LasttNameTxt;
	
	@FindBy(id="Email")
	WebElement EmailTxt;
	
	@FindBy(id="Company")
	WebElement CompanyNameTxt;
	
	@FindBy(id="Password")
	WebElement PasswordTxt;
	
	@FindBy(id="ConfirmPassword")
	WebElement ConfirmPasswordTxt;
	
	@FindBy(id="register-button")
	WebElement RegisterBtn;
	
	@FindBy(xpath="//select[@name='DateOfBirthDay']//following-sibling::option")
	WebElement DayDropDown;
	
	@FindBy(css="div.result")
	public WebElement SuccessRegistrationMsg;//public 3lshan hnst5dmo bra el class de w howa by default private
	
	@FindBy(linkText = "Log out")
	public WebElement LogOutBtn;// 3lshan hn7tago fel assertion b3d m3ml login
	
	@FindBy (linkText = "My account")
	WebElement MyAccountBtn;
	
	public void UserRegistration(String FirstNmae, String LastName, String Email, String Company, String Password) {
		clickButton(GenderRdoBtn);
		//FirstNameTxt.sendKeys(FirstNmae);//This is the way before refactoring or before updating the code in POM pattern
		setTxtInTxtInputField(FirstNameTxt, FirstNmae);
		setTxtInTxtInputField(LasttNameTxt, LastName);
		setTxtInTxtInputField(EmailTxt, Email);
		//DayDropDown.click();//check correctness
		clickButton(DayDropDown);
		setTxtInTxtInputField(CompanyNameTxt, Company);
		setTxtInTxtInputField(PasswordTxt, Password);
		setTxtInTxtInputField(ConfirmPasswordTxt, Password);
		clickButton(RegisterBtn);
	}
	
	public void userLogOut() {
		clickButton(LogOutBtn);
	}
	public void userEnterMyAccountPage() {

		clickButton(MyAccountBtn);
	}

}
