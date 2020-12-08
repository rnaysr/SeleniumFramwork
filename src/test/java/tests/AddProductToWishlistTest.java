package tests;



import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishlistPage;

public class AddProductToWishlistTest extends TestBase {

	SearchPage searchPageObj;
	ProductDetailsPage productDetailsPageObj;
	WishlistPage wishListPageObj;
	String productName="Apple MacBook Pro 13-inch";
	String emptyText="The wishlist is empty!";


	@Test(priority=1)
	public void userSearchProductWithAutosuggest() throws InterruptedException
	{
		searchPageObj =new SearchPage(driver)	;
		searchPageObj.searchWithAutoSuggest(productName);
		productDetailsPageObj=new ProductDetailsPage(driver);
		Assert.assertTrue(productDetailsPageObj.productNameBreadCrumb.getText().contains(productName));


	}

	@Test(priority=2)
	public void userRemoveFromWishlistPage()
	{
		productDetailsPageObj=new ProductDetailsPage(driver);
		productDetailsPageObj.addToWishlistBtn();

		wishListPageObj= new WishlistPage(driver);


		Assert.assertTrue(wishListPageObj.wishlistHeader.isDisplayed());

		Assert.assertTrue(wishListPageObj.productNameCell.getText().contains(productName));
	}

	@Test(priority=3)
	public void UserRemoveProductFromCart() throws InterruptedException {
		wishListPageObj= new WishlistPage(driver);
		Thread.sleep(1000);
		wishListPageObj.clickToEmptyWishlist();
		Assert.assertTrue(wishListPageObj.emptyLbl.getText().contains(emptyText));

	}







}
