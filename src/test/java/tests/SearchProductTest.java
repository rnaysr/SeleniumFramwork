package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductTest extends TestBase {
	
	SearchPage searchPageObj;
	ProductDetailsPage productDetailsObj;
	String productName="Apple MacBook Pro 13-inch";
	@Test
	public void searchProductTest() {
		searchPageObj=new SearchPage(driver);
		productDetailsObj=new ProductDetailsPage(driver);
		searchPageObj.userSearchProduct(productName);
		searchPageObj.userClickProductLink();
		Assert.assertTrue(productDetailsObj.productNameBreadCrumb.getText().equalsIgnoreCase(productName));
		Assert.assertEquals(productDetailsObj.productNameBreadCrumb.getText(),productName);
		
	}
	
}
