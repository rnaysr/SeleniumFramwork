package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage  extends PageBase{

	public MyAccountPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(linkText="Change password")
	WebElement changePasswordLink;

	@FindBy(id="OldPassword")
	WebElement oldPasswordTxt;

	@FindBy(id="NewPassword")
	WebElement newPasswordTxt;

	@FindBy(id="ConfirmNewPassword")
	WebElement confirmPasswordTxt;

	@FindBy(css="input.button-1.change-password-button")
	WebElement changePasswordBtn;


	@FindBy(css="div.result")
	public WebElement lblResult;

	public void clickChangePasswordLink() {
		clickBtn(changePasswordLink);
	}
	public void changePassword (String oldPassword, String newPassword)
	{
		oldPasswordTxt.clear();
		oldPasswordTxt.click();
		setTextElementText(oldPasswordTxt, oldPassword);
		oldPasswordTxt.sendKeys(oldPassword);

		newPasswordTxt.clear();
		newPasswordTxt.click();
		setTextElementText(newPasswordTxt, newPassword);
		newPasswordTxt.sendKeys(newPassword);

		confirmPasswordTxt.clear();
		confirmPasswordTxt.click();
		setTextElementText(confirmPasswordTxt, newPassword);
		confirmPasswordTxt.sendKeys(newPassword);
		
		clickBtn(changePasswordBtn);

	}

}
