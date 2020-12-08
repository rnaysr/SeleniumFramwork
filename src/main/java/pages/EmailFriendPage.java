package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriendPage extends PageBase {

	public EmailFriendPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(id="FriendEmail")
	WebElement friendEmailTxt;
	@FindBy(id="PersonalMessage")
	WebElement friendPersonalMsgTxt;
	@FindBy(name="send-email")
	WebElement sendMailBtn;
	@FindBy(css="div.result")
	public WebElement resultLbl;
	
	public void userSendEmailFriend(String FM ,String PM)
	{
		setTextElementText(friendEmailTxt, FM);
		setTextElementText(friendPersonalMsgTxt, PM);
		clickBtn(sendMailBtn);
	}

}
