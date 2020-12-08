package steps;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.AddProductToShoppingCartPage;
import pages.CheckOutPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegistrationPage;
import pages.orderDetailsPage;
import tests.TestBase;

public class End2EndTest extends TestBase{

	UserRegistrationPage registerationObj;
	SearchPage searchObj;
	HomePage HomeObj;
	ProductDetailsPage productDetailsObj;
	AddProductToShoppingCartPage shoppingCartObj;
	CheckOutPage checkoutPage;
	orderDetailsPage orderDetailsObj;

	String productName="Apple MacBook Pro 13-inch";

	@Given("^user is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		Assert.assertTrue(driver.getCurrentUrl().contains("demo.nopcommerce.com"));
	}

	@When("^User search for \"([^\"]*)\"$")
	public void user_search_for(String productName) throws Throwable {
		searchObj = new SearchPage(driver);
		searchObj.searchWithAutoSuggest(productName);
		//searchObj.userSearchProduct(productName);
		//searchObj.userClickProductLink();

		productDetailsObj=new ProductDetailsPage(driver);
		Assert.assertTrue(productDetailsObj.productNameBreadCrumb.getText().contains(productName));	

	}

	@When("^User choose to buy two items$")
	public void user_choose_to_buy_two_items() throws Throwable {
		productDetailsObj=new ProductDetailsPage(driver);
		productDetailsObj.clickShooppingCartLink();
	}

	@When("^User moves to checkout cart and enter his personal details on checkout page and place the order$")
	public void user_moves_to_checkout_cart_and_enter_his_personal_details_on_checkout_page_and_place_the_order() throws Throwable {


		shoppingCartObj= new AddProductToShoppingCartPage(driver);
		shoppingCartObj.userCheckout();


		Thread.sleep(1000);


		checkoutPage= new CheckOutPage(driver);
		Thread.sleep(1000);
		checkoutPage.gestUserClickCheckout();

		Thread.sleep(1000);
		checkoutPage.gestuserEnterCheckoutInfo("rana", "Dewan", "r9@gmail.com", "Aruba", "dd", "fr", "87765", "23466788");
		Thread.sleep(1000);
		Assert.assertTrue(checkoutPage.productName.getText().contains("Apple MacBook Pro 13-inch"));

		checkoutPage.userConfirmOrder();

		Assert.assertTrue(checkoutPage.thankyouLbl.isDisplayed());
		Assert.assertTrue(checkoutPage.detailsLink.isDisplayed());



	}

	@Then("^user can view the order and download the invoice$")
	public void user_can_view_the_order_and_download_the_invoice() throws Throwable {
		checkoutPage=new CheckOutPage(driver);
		checkoutPage.userPrintOrder();
		
		Thread.sleep(1000);
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		orderDetailsObj= new orderDetailsPage(driver);

		orderDetailsObj.userClickpdftBtn();
		Thread.sleep(1000);
		orderDetailsObj.userClickPrintBtn();
		Thread.sleep(1000);
		
		registerationObj=new UserRegistrationPage(driver);
		registerationObj.userLogout();


	}
}
