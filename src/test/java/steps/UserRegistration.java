package steps;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import pages.UserRegistrationPage;
import tests.TestBase;

public class UserRegistration extends TestBase {
	HomePage homeObject;
	UserRegistrationPage registerObject;


	@Given("^User in home page$")
	public void user_in_home_page() throws Throwable {
		homeObject= new HomePage(driver);
		homeObject.clickOnRegisterLink();
	}

	@When("^I click on register link$")
	public void i_click_on_register_link() throws Throwable {
		Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	}

	/*@When("^I entered user data$")
public void i_entered_user_data() throws Throwable {
  registerObject=new UserRegistrationPage(driver);
  registerObject.userRegistration("Rana", "diwan", "test@gmail.com", "12345678");
}*/
	@When("^I entered \"([^\"]*)\" , \"([^\"]*)\", \"([^\"]*)\" , \"([^\"]*)\"$")
	public void i_entered(String firstname, String lastname, String email, String password) throws Throwable
	{
		registerObject=new UserRegistrationPage(driver);
		Thread.sleep(1000);
		registerObject.userRegistration(firstname , lastname, email, password);
		Thread.sleep(1000);

	}

	@Then("^The registration page displayed successfully$")
	public void the_registration_page_displayed_successfully() throws Throwable {
		registerObject=new UserRegistrationPage(driver);
		Thread.sleep(1000);
		registerObject.userLogout();
		Thread.sleep(1000);
	}

}
