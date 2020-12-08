package tests;



import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDTAndCSVFile extends TestBase {
	HomePage homeObj;
	UserRegistrationPage userPageObj;
	LoginPage loginObj;



	CSVReader reader;

	@Test(priority=1)
	public  void userRegisterSuccessfully() throws InterruptedException, CsvValidationException, IOException {

		String CSV_File= System.getProperty("user.dir")+"/src/test/java/data/userregdata.csv";
		reader= new CSVReader(new FileReader(CSV_File) );

		String[] csvCell;
		while (( csvCell = reader.readNext()) != null)  
		{
			String firstName=csvCell[0];
			String lastName=csvCell[1];
			String email=csvCell[2];
			String pw=csvCell[3];
			homeObj= new HomePage(driver);
			homeObj.clickOnRegisterLink();
			userPageObj=new UserRegistrationPage(driver);
			Thread.sleep(1000);
			userPageObj.userRegistration(firstName, lastName, email, pw);
			Assert.assertTrue(userPageObj.successRegisterMsg.getText().contains("Your registration completed"));
			Thread.sleep(1000);
			userPageObj.userLogout();
			Thread.sleep(1000);
			homeObj= new HomePage(driver);
			homeObj.clickOnLoginLink();
			Thread.sleep(1000);
			loginObj=new LoginPage(driver);
			Thread.sleep(1000);
			loginObj.userLogin(email, pw);
			Thread.sleep(1000);
			Assert.assertTrue(loginObj.lblLogout.getText().contains("Log out"));
			userPageObj.userLogout();
			Thread.sleep(1000);


		}


	}


}
