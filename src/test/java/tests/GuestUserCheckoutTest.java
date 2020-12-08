package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddProductToShoppingCartPage;
import pages.CheckOutPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegistrationPage;
import pages.orderDetailsPage;

public class GuestUserCheckoutTest extends TestBase{

	UserRegistrationPage registerationObj;
	SearchPage searchObj;
	String productName="Apple MacBook Pro 13-inch";
	HomePage HomeObj;
	ProductDetailsPage productDetailsObj;
	AddProductToShoppingCartPage shoppingCartObj;
	CheckOutPage checkoutPage;
	orderDetailsPage orderDetailsObj;

	@Test(priority=1)
	public void userSearchProduct() throws InterruptedException
	{
		searchObj = new SearchPage(driver);
		searchObj.searchWithAutoSuggest(productName);
		//searchObj.userSearchProduct(productName);
		//searchObj.userClickProductLink();

		productDetailsObj=new ProductDetailsPage(driver);
		Assert.assertTrue(productDetailsObj.productNameBreadCrumb.getText().contains(productName));	

	}

	@Test(priority=2)
	public void userAddToCart() throws InterruptedException
	{

		productDetailsObj=new ProductDetailsPage(driver);
		productDetailsObj.clickShooppingCartLink();
	}
	@Test(priority=3)
	public void userCheckout() throws InterruptedException
	{

		shoppingCartObj=new AddProductToShoppingCartPage(driver);
		shoppingCartObj.userCheckout();
		Thread.sleep(1000);
		checkoutPage= new CheckOutPage(driver);
		checkoutPage.gestUserClickCheckout();
	}
	
	@Test(priority=4)
	public void gestUserFillInfo() throws InterruptedException
	{

		checkoutPage= new CheckOutPage(driver);
		checkoutPage.gestuserEnterCheckoutInfo("rana", "Dewan", "r@gmail.com", "Aruba", "dd", "fr", "87765", "23466788");

		Assert.assertTrue(checkoutPage.productName.getText().contains("Apple MacBook Pro 13-inch"));

		checkoutPage.userConfirmOrder();

		Assert.assertTrue(checkoutPage.thankyouLbl.isDisplayed());
		Assert.assertTrue(checkoutPage.detailsLink.isDisplayed());

	}
	@Test(priority=5)
	public void userPrintpdfCheckout() throws InterruptedException{

		checkoutPage=new CheckOutPage(driver);
		checkoutPage.userPrintOrder();
		Thread.sleep(1000);

		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		orderDetailsObj= new orderDetailsPage(driver);

		orderDetailsObj.userClickpdftBtn();
		Thread.sleep(1000);
		orderDetailsObj.userClickPrintBtn();
	}


	



}
