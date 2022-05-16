package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText = "Change password")
	WebElement ChangePassLink;
	
	@FindBy(id="OldPassword")
	WebElement OldPassinputTxtField;
	
	@FindBy(id="NewPassword")
	WebElement NewPassinputTxtField;
	
	@FindBy(id="ConfirmNewPassword")
	WebElement ConfirmNewPassinputTxtField;
	
	@FindBy(css="button[class='button-1 change-password-button']")
	WebElement ChangePassBtn;
	
	
				
	public void RedirecttoChangePassPage() {
		clickButton(ChangePassLink);
	}
	
	public void userChangeHisPass(String oldPass,String newPass ) {
		setTxtInTxtInputField(OldPassinputTxtField, oldPass);
		setTxtInTxtInputField(NewPassinputTxtField, newPass);
		setTxtInTxtInputField(ConfirmNewPassinputTxtField, newPass);
		clickButton(ChangePassBtn);
	}
	
	

}
