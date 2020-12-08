
package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase
{
	HomePage homeObject ; 
	UserRegistrationPage registerObject ; 
	LoginPage loginObject ; 
	MyAccountPage myAccountObject ; 
	String oldPW = "0987654321" ; 
	String newPassword = "1234567890" ; 
	String firstName = "Rana" ; 
	String lastName = "Dewan" ; 
	String email = "g5@gmail.com" ; 


	@Test(priority=1)
	public void UserCanRegisterSuccssfully() throws InterruptedException 
	{
		homeObject = new HomePage(driver); 
		homeObject.clickOnRegisterLink();
		registerObject = new UserRegistrationPage(driver); 
		Thread.sleep(1000);
		registerObject.userRegistration(firstName, lastName, email, oldPW);
		Assert.assertTrue(registerObject.successRegisterMsg.getText().contains("Your registration completed"));
	}

	@Test(priority=2)
	public void RegisteredUserCanChangePassword() throws InterruptedException 
	{
		
		registerObject =new UserRegistrationPage(driver);
		registerObject.clickOnMyAccountLink();
		
		myAccountObject = new MyAccountPage(driver) ; 
		myAccountObject.clickChangePasswordLink();
		Thread.sleep(1000);
		
		myAccountObject.changePassword(oldPW, newPassword);
		Assert.assertTrue(myAccountObject.lblResult.getText().contains("Password was changed"));
	}

	@Test(priority=3)
	public void RegisteredUserCanLogout() 
	{
		registerObject.userLogout();
	}

	@Test(priority=4)
	public void RegisteredUserCanLogin() throws InterruptedException 
	{
		homeObject = new HomePage(driver); 
		Thread.sleep(1000);
		homeObject.clickOnLoginLink();
		loginObject = new LoginPage(driver); 
		Thread.sleep(1000);
		loginObject.userLogin(email, newPassword);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}

	@Test(priority=5)
	public void UserLogout() 
	{
		registerObject.userLogout();
	}

}