package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ComparePage extends PageBase{

	public ComparePage(WebDriver driver) {
		super(driver);

	}
	
	
	@FindBy(tagName="tr")
	List<WebElement> allRows;
	@FindBy(tagName="td")
	List<WebElement> allCol;
	@FindBy(css="div.no-data")
	public WebElement emptyLbl;
	@FindBy(css="a.clear-list")
	WebElement clearListBtn;
	
	@FindBy(linkText="Asus N551JK-XO076H Laptop")
	public WebElement secondProductName;
	
	@FindBy(linkText="Apple MacBook Pro 13-inch")
	public WebElement firstProductName;




	public void clearCompareList () {
		clickBtn(clearListBtn);
	}

	public void compareProducts() {
		
		System.out.println(allRows.size());
		System.out.println(allCol.size());
		
		for (WebElement row : allRows ) {
			System.out.println(row.getText() + "\t");

			for (WebElement col: allCol)
			{
				System.out.println(col.getText() + "\t");
			}

		}
	}

}
