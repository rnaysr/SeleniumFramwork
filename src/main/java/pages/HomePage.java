package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {

		super(driver);
		jse=(JavascriptExecutor)driver;

		action= new Actions(driver);

	}
	@FindBy(linkText="Register")
	WebElement registerLink;

	@FindBy(linkText="Log in")
	WebElement loginLink;

	@FindBy(linkText="Contact us")
	WebElement contactUsLink;

	@FindBy(id="customerCurrency")
	WebElement currencyDDL;


	@FindBy(linkText="Computers ")
	WebElement computersMenu;


	@FindBy(linkText="Notebooks ")
	WebElement notbooksSubMenu;

	public void clickOnRegisterLink() {
		//registerLink.click();
		clickBtn(registerLink);		
	}

	public void clickOnLoginLink() {
		clickBtn(loginLink);
	}
	public void contactUsPageScroll() {
		scrollToButtom();	

	}
	public void contactUsClick() {
		clickBtn(contactUsLink);
	}
	public void changeCurrency() {
		select=new Select(currencyDDL);
		select.selectByVisibleText("Euro");
	}
	public void UserChooseNotebooksSubMenu() throws InterruptedException
	{

		action.moveToElement(computersMenu).moveToElement(notbooksSubMenu).click().build().perform();
	}

}
