package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegisterationParallelTesting extends TestBase2 {
	HomePage homeObj;
	UserRegistrationPage userPageObj;
	LoginPage loginObj;


	Faker fakeData = new Faker();
	String firstName=fakeData.name().firstName();
	String lastName=fakeData.name().lastName();
	String email=fakeData.internet().emailAddress();
	String pw=fakeData.number().digits(8).toString();

	@Test(priority=1)
	public  void userRegisterSuccessfully() throws InterruptedException {
		homeObj= new HomePage(getDriver());
		homeObj.clickOnRegisterLink();


		userPageObj=new UserRegistrationPage(getDriver());
		Thread.sleep(1000);
		userPageObj.userRegistration(firstName, lastName, email, pw);
		System.out.println("user data is : "+firstName+" ,  "+lastName+" ,  "+email+" ,  "+pw+".");
		Assert.assertTrue(userPageObj.successRegisterMsg.getText().contains("Your registration completed"));

		Thread.sleep(1000);
		userPageObj.userLogout();

		Thread.sleep(1000);
		homeObj= new HomePage(getDriver());
		Thread.sleep(1000);
		homeObj.clickOnLoginLink();
		Thread.sleep(1000);
		loginObj=new LoginPage(getDriver());
		Thread.sleep(1000);
		loginObj.userLogin(email, pw);
		Thread.sleep(1000);

		Assert.assertTrue(loginObj.lblLogout.getText().contains("Log out"));
		Thread.sleep(1000);

	}
}
