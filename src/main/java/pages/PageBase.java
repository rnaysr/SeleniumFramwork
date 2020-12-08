package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
	//create driver to treat with elements on page object =actual web driver that work with test 
	protected WebDriver driver;
	public JavascriptExecutor jse;
	public Select select;
	public Actions action;

	// create constructor
	public PageBase(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	protected static void clickBtn(WebElement button) {
		button.click();
		
	}
	protected static void setTextElementText(WebElement textElement, String value )
	{
	textElement.sendKeys(value);	
	}
	public void scrollToButtom() {
		jse.executeScript("scrollBy(0,2500)");
	}
	public void clearText(WebElement element) {
		element.clear();
		
	}
	
}
