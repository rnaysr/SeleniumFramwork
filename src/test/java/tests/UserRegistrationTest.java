package tests;



import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase {
	HomePage homeObj;
	UserRegistrationPage userPageObj;
	LoginPage loginObj;
	String firstName="Rana"; 
	String lastName="Dewan";
	String email="g2@gmail.com";
	String pw="0987654";

	@Test(priority=1)
	public  void userRegisterSuccessfully() throws InterruptedException {
		homeObj= new HomePage(driver);
		homeObj.clickOnRegisterLink();


		userPageObj=new UserRegistrationPage(driver);
		Thread.sleep(1000);
		userPageObj.userRegistration(firstName, lastName, email, pw);

		Assert.assertTrue(userPageObj.successRegisterMsg.getText().contains("Your registration completed"));
	}
	@Test(priority=2)
	public void userCanLogoutSuccessfully() {
		userPageObj.userLogout();

	}
	@Test(priority=3)
	public void userCanLogin() throws InterruptedException {
		homeObj= new HomePage(driver);
		homeObj.clickOnLoginLink();
		Thread.sleep(1000);
		loginObj=new LoginPage(driver);
		Thread.sleep(1000);
		loginObj.userLogin(email, pw);
		Thread.sleep(1000);

		Assert.assertTrue(loginObj.lblLogout.getText().contains("Log out"));

	}

}
