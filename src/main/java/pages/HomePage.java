package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{
	public HomePage(WebDriver driver) {
		super(driver);
		action = new Actions(driver);
	}
	@FindBy (linkText="Register")
	WebElement RegisterLink;
	
	@FindBy (linkText="Log in")
	WebElement LoginLink;
	
	@FindBy (linkText = "Computers")
	WebElement ComputersHoverMenu;
	
	@FindBy (xpath="//a[@href='/notebooks']")
	WebElement NotebookHoverMenu;

 public void openRegistrationPage() {
	 //RegisterLink.click();
	 clickButton(RegisterLink);
 }
 public void openLoginPage() {
	 clickButton(LoginLink);
 }
 public void selectNotebookMenu() {
	action.
	moveToElement(ComputersHoverMenu).
	moveToElement(NotebookHoverMenu).
	click()
	.build().
	perform();
}
 }
