package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage  extends PageBase{

	public CheckOutPage(WebDriver driver) {
		super(driver);
	}



	@FindBy (css="div.page-title")
	public  WebElement checkoutPageTitle;
	
	@FindBy (css="input.button-1.checkout-as-guest-button")
	public WebElement checkoutGuestBtn;

	//BillingInfo
	@FindBy (id="BillingNewAddress_FirstName")
	public  WebElement fnTxt;
	@FindBy (id="BillingNewAddress_LastName")
	public  WebElement lnTxt;
	@FindBy (id="BillingNewAddress_Email")
	public  WebElement emailTxt;
	@FindBy (id="BillingNewAddress_CountryId")
	public  WebElement countryList;
	@FindBy (id="BillingNewAddress_City")
	public  WebElement cityTxt;
	@FindBy (id="BillingNewAddress_Address1")
	public  WebElement addressTxt;
	@FindBy (id="BillingNewAddress_ZipPostalCode")
	public  WebElement postcodeTxt;
	@FindBy (id="BillingNewAddress_PhoneNumber")
	public  WebElement phonenumberTxt;
	@FindBy (css="input.button-1.new-address-next-step-button")
	public  WebElement contBtn1;

	//ShippingMethodInfo

	@FindBy (id="shippingoption_1")
	public  WebElement shippingRadioBtn;
	@FindBy (css="input.button-1.shipping-method-next-step-button")
	public  WebElement contBtn2;


	//PaymentInfo

	@FindBy (id="paymentmethod_0")
	public  WebElement paymentRadioBtn;
	@FindBy (css="input.button-1.payment-method-next-step-button")
	public  WebElement contBtn3;


	@FindBy (css="input.button-1.payment-info-next-step-button")
	public  WebElement contBtn4;


	@FindBy (css="input.button-1.confirm-order-next-step-button")
	public  WebElement confirmBtn;
	@FindBy (css="a.product-name")
	public  WebElement productName;

	

	@FindBy (css="div.page-title")
	public  WebElement thankyouLbl;


	@FindBy (linkText="Click here for order details.")
	public  WebElement detailsLink;


	public void userEnterCheckoutInfo( String countryN ,String cityN , String addressN , String code, String phoneN) throws InterruptedException {

		select = new Select(countryList);
		select.selectByVisibleText(countryN);
		setTextElementText(cityTxt, cityN);
		setTextElementText(addressTxt, addressN);
		setTextElementText(postcodeTxt, code);
		setTextElementText(phonenumberTxt, phoneN);
		clickBtn(contBtn1);
		Thread.sleep(1000);
		clickBtn(shippingRadioBtn);
		clickBtn(contBtn2);
		Thread.sleep(1000);
		clickBtn(paymentRadioBtn);
		clickBtn(contBtn3);
		Thread.sleep(1000);
		clickBtn(contBtn4);
		Thread.sleep(1000);
		

	}
	public void gestuserEnterCheckoutInfo(String fN, String lN, String email
			, String countryN ,String cityN , String addressN , String code, String phoneN) throws InterruptedException {

		setTextElementText(fnTxt, fN);
		setTextElementText(lnTxt, lN);
		setTextElementText(emailTxt, email);
		select = new Select(countryList);
		select.selectByVisibleText(countryN);
		setTextElementText(cityTxt, cityN);
		setTextElementText(addressTxt, addressN);
		setTextElementText(postcodeTxt, code);
		setTextElementText(phonenumberTxt, phoneN);
		clickBtn(contBtn1);
		Thread.sleep(1000);
		clickBtn(shippingRadioBtn);
		clickBtn(contBtn2);
		Thread.sleep(1000);
		clickBtn(paymentRadioBtn);
		clickBtn(contBtn3);
		Thread.sleep(1000);
		clickBtn(contBtn4);
		Thread.sleep(1000);
		

	}
	public void userConfirmOrder() {
		clickBtn(confirmBtn);
	}
	public void userPrintOrder() {
		clickBtn(detailsLink);
	}

	public void gestUserClickCheckout() {
		clickBtn(checkoutGuestBtn);
	}


}
