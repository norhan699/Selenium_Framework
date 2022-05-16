package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends PageBase{

	public Loginpage(WebDriver driver) {
		super(driver);
	}
	 @FindBy(id="Email")
	 WebElement EmailtxtinputField;
	 
	 @FindBy(id="Password")
	 WebElement PasswordtxtinputField;
	  
	 @FindBy(css="button[class='button-1 login-button']")
	 //(css="input.button-1.login-button")
	 WebElement LoginBtnWebElement;
	 
	 public void userLogin(String Email, String Password) {
		 setTxtInTxtInputField(EmailtxtinputField, Email);
		 setTxtInTxtInputField(PasswordtxtinputField, Password);
		 clickButton(LoginBtnWebElement);
	 }
	 

}
