package tests;

import java.io.IOException;
import java.lang.ref.PhantomReference;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import utilities.Helper;

public class TestBase extends AbstractTestNGCucumberTests{

	public static WebDriver driver;
	public static String downloadPath=System.getProperty("user.dir")+"\\Downloads";
	public static ChromeOptions chromeOption() {
		ChromeOptions option= new ChromeOptions();
		HashMap<String, Object> chromePrefs=new HashMap<String, Object>();
		chromePrefs.put("profile.default.content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		option.setExperimentalOption("prefs", chromePrefs);
		option.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		return option;
	}

	public static FirefoxOptions firefoxOption() {
		FirefoxOptions option= new FirefoxOptions();
		option.addPreference("browser.download.folderList", 2);
		option.addPreference("browser.download.dir",  downloadPath);
		option.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");
		option.addPreference("browser.download.manager.showWhenStarting", false);
		return option;

	}

	@BeforeSuite
	@Parameters({"browser"})
	public void startDriver(@Optional("chrome") String browserName ) {
		if (browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");

			driver=new ChromeDriver(chromeOption());	
		}
		else if (browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");

			driver=new FirefoxDriver( firefoxOption());	
		}
		else if (browserName.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\Drivers\\IEDriverServer.exe");

			driver=new InternetExplorerDriver();	
		}
		// Headless Browser
		else if (browserName.equalsIgnoreCase("headless"))
		{
			DesiredCapabilities caps= new DesiredCapabilities();
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
					System.getProperty("user.dir")+"\\Drivers\\phantomjs.exe");

			String[] PhantomJsArgs= {"--web-security=no","--ignore-ssl-errors=yes"};
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS,PhantomJsArgs);
			driver = new PhantomJSDriver(caps);

		}
		else if (browserName.equalsIgnoreCase("chrome-headless"))
		{
			System.setProperty("webdriver.chrome.driver", 
					System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");

			ChromeOptions options= new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("--window-size=1920,1080");
			driver= new ChromeDriver(options);

		}


		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.navigate().to("https://demo.nopcommerce.com/");

	}



	@AfterSuite
	public void stopDriver() {

		driver.quit();
	}


	//Take screenshot when TC fail and add it in the screenshot folder
	@AfterMethod
	public void screenshotOnFailure(ITestResult result) throws IOException {
		if(result.getStatus()== ITestResult.FAILURE) 
		{
			System.out.println("Failed !");
			System.out.println("Taking Screenshot....");
			Helper.captureScreenshot(driver, result.getName());		
			//Helper.takeScreenshot(result, driver);
		}




	}




}
