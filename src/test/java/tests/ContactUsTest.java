package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase {
HomePage home;
ContactUsPage contactUsObj;

String fN="Rana";
String email="test@gmail.com";
String inq="test123";



@Test
public void contactUsTest() throws InterruptedException {
	home =new HomePage(driver);
	home.scrollToButtom();
	home.contactUsClick();
	contactUsObj= new ContactUsPage(driver);
	Thread.sleep(1000);
	contactUsObj.contactUs("rana", "test@gmail.com",  "test");
	Assert.assertTrue(contactUsObj.resultLbl.getText().contains("Your enquiry has been successfully"));
}

}
