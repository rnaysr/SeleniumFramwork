package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProductToShoppingCartPage  extends PageBase{

	public AddProductToShoppingCartPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(name="removefromcart")
	public WebElement removeFromCartCheckBox;
	@FindBy(css="input.button-2.update-cart-button")
	public WebElement updateCartCheckBtn;
	@FindBy(className="qty-input")
	public WebElement qtyText;
	@FindBy(css="span.product-subtotal")
	public WebElement totalLbl;
	@FindBy(css="div.no-data")
	public WebElement emptyLbl;

	@FindBy(id="termsofservice")
	public WebElement termsCheckbox;
	@FindBy(id="checkout")
	public WebElement checkoutBtn;


	public void userChangeQuantity(String qty) {
		clearText(qtyText);
		setTextElementText(qtyText, qty);
		clickBtn(updateCartCheckBtn);

	}
	
	public void userRemoveProductFromShoppingCart() {
		clickBtn(removeFromCartCheckBox);
		clickBtn(updateCartCheckBtn);
	}

	public void userCheckout() {
		clickBtn(termsCheckbox);
		clickBtn(checkoutBtn);
	}


}
