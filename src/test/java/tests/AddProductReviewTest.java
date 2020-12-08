package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddProductReviewPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class AddProductReviewTest extends TestBase{
	HomePage homeObj;
	UserRegistrationPage userPageObj;
	AddProductReviewPage  AddProductReviewObj;
	String firstName="Rana"; 
	String lastName="Dewan";
	String email="g4@gmail.com";
	String password="ranadewan";


	ProductDetailsPage productDetailsObj;
	SearchPage searchPageObj;

	String productName="Apple MacBook Pro 13-inch";



	//Registration
	@Test(priority=1)
	public  void userRegisterSuccessfully() throws InterruptedException {
		homeObj= new HomePage(driver);
		homeObj.clickOnRegisterLink();
		Thread.sleep(1000);
		userPageObj=new UserRegistrationPage(driver);
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

	//Add Review
	@Test(priority=3)
	public void userAddReview() {
		productDetailsObj=new ProductDetailsPage(driver);
		productDetailsObj.clickReviewLink();
		AddProductReviewObj=new AddProductReviewPage(driver);
		AddProductReviewObj.userAddReview("review title", "review text");
		Assert.assertTrue(AddProductReviewObj.resultLbl.getText().contains("Product review is successfully added."));
	}
	//Log Out
	@Test(priority=4)
	public void userCanLogoutSuccessfully() {
		userPageObj.userLogout();

	}
}
