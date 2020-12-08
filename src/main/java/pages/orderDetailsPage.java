package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class orderDetailsPage extends PageBase {

	public orderDetailsPage(WebDriver driver) {
		super(driver);

	}

	@FindBy (css="a.button-2.print-order-button")
	public  WebElement printBtn;
	@FindBy (css="a.button-2.pdf-invoice-button")
	public  WebElement pdfBtn;

	public void userClickPrintBtn() {
		clickBtn(printBtn);
	}
	public void userClickpdftBtn() {
		clickBtn(pdfBtn);
	}
}
