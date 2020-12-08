package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishlistPage extends PageBase{

	public WishlistPage(WebDriver driver) {
		super(driver);

	}
	@FindBy (name="removefromcart")
	WebElement removeCheckbox;
	
	@FindBy (css="td.product")
	public WebElement wishlistHeader;
	
	@FindBy (css="a.product-name")
	public WebElement productNameCell;
	
	@FindBy(name="updatecart")
	WebElement updateWishlistBtn;

	@FindBy(css="div.no-data")
	public WebElement emptyLbl;
	
	public void clickToEmptyWishlist()
	{
		clickBtn(removeCheckbox);
		clickBtn(updateWishlistBtn);
	}
}

