package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest  extends TestBase{
	HomePage homeObj;
	ProductDetailsPage productDetailsObj;
	SearchPage searchPageObj;

	String productName="Apple MacBook Pro 13-inch";


	@Test(priority=1)
	public void userChangeCurrency() throws InterruptedException {
		homeObj=new HomePage(driver);

		homeObj.changeCurrency();
		Thread.sleep(1000);

	}

	@Test(priority=2)
	public void SearchProduct() throws InterruptedException {	

		searchPageObj=new SearchPage(driver);
		productDetailsObj=new ProductDetailsPage(driver);

		searchPageObj.userSearchProduct(productName);
		Thread.sleep(1000);
		searchPageObj.userClickProductLink();
		Assert.assertEquals(productDetailsObj.productNameBreadCrumb.getText(),productName);

		Assert.assertTrue(productDetailsObj.productPriceLbl.getText().contains("€"));
		System.out.println(productDetailsObj.productPriceLbl.getText());
	}


}
