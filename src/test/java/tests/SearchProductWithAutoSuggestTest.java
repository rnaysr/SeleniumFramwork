package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductWithAutoSuggestTest extends TestBase{
	SearchPage searchPageObj;
	ProductDetailsPage productDetailsObj;
	String productName="Apple MacBook Pro 13-inch";
	
	@Test
	public void SearchWithAutoSuggest() {
	
		
			
			try {
				searchPageObj=new SearchPage(driver);
				productDetailsObj=new ProductDetailsPage(driver);
				
				searchPageObj.searchWithAutoSuggest("mac");
				
			} catch (InterruptedException e) {
				System.out.println("Error : "+e.getMessage());
			}
			Assert.assertEquals(productDetailsObj.productNameBreadCrumb.getText(),productName);
		
	}

}
