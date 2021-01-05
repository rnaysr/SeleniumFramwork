package tests;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import data.LoadProperties;
import utilities.Helper;

public class TestBase2 {

	//soucelabs configratuion
	public static final String USERNAME=LoadProperties.soucelabsData.getProperty("username");
	public static final String ACCESS_KEY=LoadProperties.soucelabsData.getProperty("accesskey");
	public static final String SouceURl="http://"+USERNAME+":"+ACCESS_KEY+ LoadProperties.soucelabsData.getProperty("seleniumURL");


	public static String BaseURL="https://demo.nopcommerce.com";

	protected ThreadLocal<RemoteWebDriver> driver=null;

	@BeforeClass
	@Parameters(value= {"browser"})
	public void setUp(@Optional("chrome")String browser) throws MalformedURLException {
		driver=new ThreadLocal<RemoteWebDriver>();

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browserName", browser);

		//selenium grid local
		//driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps));

		// run on soucelabs
		driver.set(new RemoteWebDriver(new URL(SouceURl), caps));

		getDriver().navigate().to(BaseURL);
	}
	public WebDriver getDriver() {
		return driver.get();
	}
	@AfterClass
	public void stopDriver() {
		getDriver().quit();
		driver.remove();
	}
	//Take screenshot when TC fail and add it in the screenshot folder
	@AfterMethod
	public void screenshotOnFailure(ITestResult result) throws IOException {
		if(result.getStatus()== ITestResult.FAILURE) 
		{
			System.out.println("Failed !");
			System.out.println("Taking Screenshot....");
			Helper.captureScreenshot(getDriver(), result.getName());		
			//Helper.takeScreenshot(result, driver);
		}
	}







}
