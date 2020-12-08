package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailFriendPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class EmailFriendTest extends TestBase {
	HomePage homeObj;
	UserRegistrationPage userPageObj;
	ProductDetailsPage productDetailsObj;
	EmailFriendPage emailFriendObj;
	SearchPage searchPageObj;

	String productName="Apple MacBook Pro 13-inch";

	String firstName="Rana"; 
	String lastName="Dewan";
	String email="g1@gmail.com";
	String password="ranadewan";
	//Registration
	@Test(priority=1)
	public  void userRegisterSuccessfully() throws InterruptedException {
		homeObj= new HomePage(driver);
		homeObj.clickOnRegisterLink();


		userPageObj=new UserRegistrationPage(driver);
		Thread.sleep(1000);
		userPageObj.userRegistration(firstName, lastName, email, password);

		Assert.assertTrue(userPageObj.successRegisterMsg.getText().contains("Your registration completed"));
	}

	//Search Product

	@Test(priority=2)
	public void searchProductTest() {
		searchPageObj=new SearchPage(driver);
		productDetailsObj=new ProductDetailsPage(driver);
		searchPageObj.userSearchProduct(productName);
		searchPageObj.userClickProductLink();
		Assert.assertTrue(productDetailsObj.productNameBreadCrumb.getText().equalsIgnoreCase(productName));
		Assert.assertEquals(productDetailsObj.productNameBreadCrumb.getText(),productName);

	}
	//Email Friend
	@Test(priority=3)
	public void userEmailFriend() throws InterruptedException {
		productDetailsObj=new ProductDetailsPage(driver);
		productDetailsObj.clickOnEmailFriendLink();
		emailFriendObj=new 	EmailFriendPage(driver);
		Thread.sleep(1000);
		emailFriendObj.userSendEmailFriend("moha@test.com", "Check this nice product");
	Assert.assertTrue(emailFriendObj.resultLbl.getText().contains("Your message has been sent."));
	}
	//Log Out
	@Test(priority=4)
	public void userCanLogoutSuccessfully() {
		userPageObj.userLogout();

	}

}
