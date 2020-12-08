package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class HoverMenuTest extends TestBase
{
	
	HomePage homeObj;
	@Test
	public void userCanSelectSubCategoryFromMainMenu() throws InterruptedException {
		
		homeObj=new HomePage(driver);
		homeObj.UserChooseNotebooksSubMenu();
		
		Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
	}

}
