package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class PageBase {
	protected WebDriver driver;
	public Actions action;

	public PageBase(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	protected static void clickButton(WebElement button) {//static 3lshan a call el method de 3la tool mn 8er ma5od object el awl mnl class dah
		button.click();
	}
	protected static void setTxtInTxtInputField(WebElement TxtInputElement,String value) {
		TxtInputElement.sendKeys(value);
	}


}
