package utilities;


import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Helper {
	//Method to take screenshot for failure Test case

	public static void captureScreenshot(WebDriver driver,String screenshotName) throws IOException
	{

		Path destination=Paths.get("./Screenshots/",screenshotName +".png");
		Files.createDirectories(destination.getParent());
		FileOutputStream out=new FileOutputStream(destination.toString());
		out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
		out.close();


	}


	//	// Another Method to take screenshot for failure Test case
	//	public static void  takeScreenshot(ITestResult result , WebDriver driver) throws IOException {
	//		if (ITestResult.FAILURE==result.getStatus())
	//		{
	//			TakesScreenshot ts= (TakesScreenshot) driver;
	//			File source=ts.getScreenshotAs(OutputType.FILE);
	//			FileUtils.copyFile(source, new File("./Screenshots/"+result.getName()+".png"));
	//
	//		}
	//
	//
	//	}	

}

