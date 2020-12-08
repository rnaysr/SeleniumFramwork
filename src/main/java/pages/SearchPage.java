package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase{

	public SearchPage(WebDriver driver) {
		super(driver);

	}
	@FindBy(id="small-searchterms")
	WebElement searchText;

	@FindBy(css="input.button-1.search-box-button")
	WebElement searchBtn;

	@FindBy(linkText="Apple MacBook Pro 13-inch")
	 public WebElement productLink;

	//@FindBy(linkText="Asus N551JK-XO076H Laptop")
	//WebElement productLink;



	@FindBy(id="ui-id-1")
	public List<WebElement> searchList;

	public void searchWithAutoSuggest(String productName) throws InterruptedException 
	{
		setTextElementText(searchText, productName);
		Thread.sleep(100);
		searchList.get(0).click();


	}
	// normal search 
	public void userSearchProduct(String inputSearch) {
		setTextElementText(searchText, inputSearch);
		clickBtn(searchBtn);
	}
	public void userClickProductLink() {
		clickBtn(productLink);
	}

}
