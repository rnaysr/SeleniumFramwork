package tests;



import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddProductToShoppingCartPage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddProductToShoppingCartTest extends TestBase {


	SearchPage searchObj;
	ProductDetailsPage detailsObj;
	AddProductToShoppingCartPage cartObj;
	String productName="Apple MacBook Pro 13-inch";
	String qtty="5";
	String emptyTxt="Your Shopping Cart is empty!";
	
	@Test(priority=1)
	public void userSearchProduct() throws InterruptedException
	{
		searchObj=new SearchPage(driver);
		detailsObj=new ProductDetailsPage(driver);
		searchObj.searchWithAutoSuggest(productName);
		Assert.assertTrue(detailsObj.productNameBreadCrumb.getText().equalsIgnoreCase(productName));
		Assert.assertEquals(detailsObj.productNameBreadCrumb.getText(),productName);


	}

	@Test(priority=2)
	public void userAddToCart()
	{
		detailsObj = new ProductDetailsPage(driver);
		detailsObj.clickShooppingCartLink();

	}
	@Test(priority=3)
	public void userUpdateQty() throws InterruptedException {
		cartObj = new AddProductToShoppingCartPage(driver);
		Thread.sleep(1000);
		cartObj.userChangeQuantity(qtty);
		
		Assert.assertTrue(cartObj.totalLbl.getText().contains("$9,000.00"));
	}
	@Test(priority=4)
	public void userEmptycart() {
		cartObj = new AddProductToShoppingCartPage(driver);
		cartObj.userRemoveProductFromShoppingCart();
		Assert.assertTrue(cartObj.emptyLbl.getText().contains(emptyTxt));
		
	}


}
