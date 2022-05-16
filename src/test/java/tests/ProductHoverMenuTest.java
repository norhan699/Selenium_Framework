package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class ProductHoverMenuTest extends TestBase
{
	HomePage home;
	@Test
	public void userCanSelectSubCategoryFromMainMenu() {
		home= new HomePage(driver);
		home.selectNotebookMenu();
		Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
	}

	
}
