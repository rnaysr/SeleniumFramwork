package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{

	public ContactUsPage(WebDriver driver) {
		super(driver);
		
	}
@FindBy(id="FullName")
WebElement fullNameTxt;
@FindBy(id="Email")
WebElement emailTxt;
@FindBy(id="Enquiry")
WebElement inquiryTxt;
@FindBy(name="send-email")
WebElement submitBtn;
@FindBy(css="div.result")
public WebElement resultLbl;

public void contactUs(String fN,String email, String inq)
{
	setTextElementText(fullNameTxt, fN);
	setTextElementText(emailTxt, email);
	setTextElementText(inquiryTxt, inq);
	clickBtn(submitBtn);
}

}
