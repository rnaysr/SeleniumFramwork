package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProductReviewPage extends PageBase{

	public AddProductReviewPage(WebDriver driver) {
		super(driver);

	}
	@FindBy(name="AddProductReview.Title")
	WebElement reviewTitleTxt;

	@FindBy(name="AddProductReview.ReviewText")
	WebElement Text;

	@FindBy(name="add-review")
	WebElement submitBtn;

	@FindBy(id="addproductrating_4")
	WebElement reviewRadioBtn;

	@FindBy(css="div.result")
	public WebElement resultLbl;


	public void userAddReview(String reviewTitle , String reviewTxt) 
	{

		setTextElementText(reviewTitleTxt, reviewTitle);
		setTextElementText(Text, reviewTxt);
		clickBtn(reviewRadioBtn);
		clickBtn(submitBtn);

	}



}
