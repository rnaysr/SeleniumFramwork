package tests;



import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDTAndDataProvider extends TestBase {
	HomePage homeObj;
	UserRegistrationPage userPageObj;
	LoginPage loginObj;

	// ARRAY OF DATA 
	@DataProvider(name="testData")
	public static Object[][]  userData()
	{
		return new Object[][] 
				{
			{"rana" , "diwan" , "test5@gmail.com" , "12345678"},
			{"moh" , "mo2" , "test6@gmail.com", "123456789"}
				};

	}


	@Test(priority=1, dataProvider="testData")
	public  void userRegisterSuccessfully(String firstName,String lastName,String email, String pw) throws InterruptedException {
		homeObj= new HomePage(driver);
		homeObj.clickOnRegisterLink();


		userPageObj=new UserRegistrationPage(driver);
		Thread.sleep(1000);
		userPageObj.userRegistration(firstName, lastName, email, pw);

		Assert.assertTrue(userPageObj.successRegisterMsg.getText().contains("Your registration completed"));
		Thread.sleep(1000);
		userPageObj.userLogout();

		homeObj= new HomePage(driver);
		Thread.sleep(1000);
		homeObj.clickOnLoginLink();
		Thread.sleep(1000);
		loginObj=new LoginPage(driver);
		Thread.sleep(1000);
		loginObj.userLogin(email, pw);
		Thread.sleep(1000);

		Assert.assertTrue(loginObj.lblLogout.getText().contains("Log out"));
		userPageObj.userLogout();

	}


}
