package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ComparePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class CompareTest extends TestBase{

	String firstProductName="Apple MacBook Pro 13-inch";
	String secondProductName="Asus N551JK-XO076H Laptop";
	String emptyText="You have no items to compare.";

	SearchPage searchObj;
	ProductDetailsPage detailsObj;
	ComparePage compareObj;

	@Test(priority=1)
	public void userCompareTwoProducts1() throws InterruptedException
	{
		searchObj=new SearchPage(driver);
		detailsObj=new ProductDetailsPage(driver);
		compareObj= new ComparePage(driver);


		searchObj.searchWithAutoSuggest("mac");
		Assert.assertTrue(detailsObj.productNameBreadCrumb.getText().contains(firstProductName));
		detailsObj.addProductToComparePage();
		Assert.assertTrue(compareObj.firstProductName.isDisplayed());
	}

	@Test(priority=2)
	public void userCompareTwoProducts2() throws InterruptedException
	{
		searchObj=new SearchPage(driver);
		detailsObj=new ProductDetailsPage(driver);
		compareObj= new ComparePage(driver);
		
		//searchObj.searchWithAutoSuggest("Asus");
		searchObj.searchWithAutoSuggest(secondProductName);
		Assert.assertTrue(detailsObj.productNameBreadCrumb.getText().contains(secondProductName));
		detailsObj.addProductToComparePage();
		
		Assert.assertTrue(compareObj.secondProductName.isDisplayed());
		}
	
	
	@Test(priority=3)
	public void userCompareTwoProducts3() throws InterruptedException
	{

		compareObj= new ComparePage(driver);
		compareObj.compareProducts();

	}

	@Test(priority=4)
	public void clearCompareList()
	{

		compareObj.clearCompareList();
		Assert.assertTrue(compareObj.emptyLbl.getText().contains(emptyText));
	}








}
