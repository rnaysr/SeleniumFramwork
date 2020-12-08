package tests;



import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDTAndExcel extends TestBase {
	HomePage homeObj;
	UserRegistrationPage userPageObj;
	LoginPage loginObj;

	@DataProvider(name="ExcelData")
	public Object[][] userRegisterData() throws IOException
	{
		//get data from excel reader class
		ExcelReader ER= new ExcelReader();
		return ER.getExcelData();
	}

	@Test(dataProvider="ExcelData")
	public  void userRegisterSuccessfully(String firstName,String lastName,String email,String pw) throws InterruptedException {
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
