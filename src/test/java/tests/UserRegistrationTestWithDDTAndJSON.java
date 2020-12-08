package tests;



import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import data.JsonDataReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDTAndJSON extends TestBase {
	HomePage homeObj;
	UserRegistrationPage userPageObj;
	LoginPage loginObj;


	@Test(priority=1)
	public  void userRegisterSuccessfully() throws InterruptedException, JsonIOException, JsonSyntaxException, IOException, ParseException {
		JsonDataReader jsonReader=new JsonDataReader();
		jsonReader.JsonReader();

		homeObj= new HomePage(driver);
		homeObj.clickOnRegisterLink();


		userPageObj=new UserRegistrationPage(driver);
		userPageObj.userRegistration(jsonReader.firstname,jsonReader.lastname,jsonReader.email,jsonReader.password);

		Assert.assertTrue(userPageObj.successRegisterMsg.getText().contains("Your registration completed"));

		userPageObj.userLogout();
		Thread.sleep(1000);

		homeObj= new HomePage(driver);
		homeObj.clickOnLoginLink();
		Thread.sleep(1000);

		loginObj=new LoginPage(driver);
		Thread.sleep(1000);
		loginObj.userLogin(jsonReader.email, jsonReader.password);
		Thread.sleep(1000);

		Assert.assertTrue(loginObj.lblLogout.getText().contains("Log out"));
		userPageObj.userLogout();
		Thread.sleep(1000);

	}


}
