package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class UserRegistrationPage extends PageBase {

	public UserRegistrationPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="gender-male")
	WebElement genderRadioBtn;
	@FindBy(id="FirstName")
	WebElement fnTxtBox;
	@FindBy(id="LastName")
	WebElement lnTxtBox;
	@FindBy(id="Email")
	WebElement emailTxtBox;
	@FindBy(css="input#Password")
	WebElement passwordTxtBox;
	@FindBy(id="ConfirmPassword")
	WebElement confirmPasswordTxt;
	@FindBy(id="register-button")
	WebElement registerBtn;

	@FindBy(css="div.result")
	public WebElement successRegisterMsg;

	@FindBy(linkText="Log out")
	public WebElement logoutLink;

	@FindBy(linkText="My account")
	WebElement myAccountLink;

	@FindBy(linkText="Log in")
	WebElement loginBtn;




	public void clickOnMyAccountLink() {
		clickBtn(myAccountLink);
	}
	public void userLogin() {
		clickBtn(loginBtn);
	}
	public void userLogout() {
		clickBtn(logoutLink);
	}
	public void userRegistration(String firstname, String lastname, String email, String password) {

		genderRadioBtn.click();
		fnTxtBox.sendKeys(firstname);
		lnTxtBox.sendKeys(lastname);
		emailTxtBox.sendKeys(email);
		passwordTxtBox.sendKeys(password);
		confirmPasswordTxt.sendKeys(password);
		registerBtn.click();
	}

}
