package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);

	}
	@FindBy (id="Email")
	public WebElement emailTxtBox;
	@FindBy (css="input#Password.password")
	public WebElement passwordTxtBox;
	@FindBy (css="input.button-1.login-button")
	public WebElement loginBtn;
	@FindBy (linkText="Log out")
	public WebElement lblLogout;


	public void userLogin(String email, String password){
		setTextElementText(emailTxtBox, email);
		passwordTxtBox.click();
		passwordTxtBox.clear();



		setTextElementText(passwordTxtBox, password);
		passwordTxtBox.sendKeys(password);
		clickBtn(loginBtn);
	}







}
