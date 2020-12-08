package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase {

	public ProductDetailsPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(css="strong.current-item")
	public WebElement productNameBreadCrumb;

	@FindBy(css="input.button-2.email-a-friend-button")
	WebElement emailFriendLink;

	@FindBy(css="span.price-value-4")
	public WebElement productPriceLbl;

	@FindBy(linkText="Add your review")
	WebElement reviewLink;


	@FindBy(id="add-to-wishlist-button-4")
	WebElement addToWishlistBtn;


	@FindBy(linkText="wishlist")
	WebElement toWishlistPage;

	@FindBy(css="div.product-name")
	public  WebElement productNameLbl;



	@FindBy(className="compare-products")
	public  WebElement addToCompareListBtn;



	@FindBy(linkText="product comparison")
	public  WebElement productComparisonLink;


	@FindBy(id="add-to-cart-button-4")
	public  WebElement addToShoppingCartBtn;

	@FindBy(linkText="shopping cart")
	public  WebElement shoppingCartLink;

	public void clickOnEmailFriendLink() {
		clickBtn(emailFriendLink);
	}


	public void clickShooppingCartLink() {
		clickBtn(addToShoppingCartBtn);
		clickBtn(shoppingCartLink);
	}

	public void clickReviewLink() {
		clickBtn(reviewLink);
	}

	public void addToWishlistBtn() {
		clickBtn(addToWishlistBtn);
		clickBtn(toWishlistPage);

	}


	public void addProductToComparePage() {
		clickBtn(addToCompareListBtn);
		clickBtn(productComparisonLink);

	}

}
