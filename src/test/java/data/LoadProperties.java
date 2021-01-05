package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class LoadProperties
{

	//class to load properties [ userdata.properties ] file   from the  properties package in the main 
	public static Properties userData= loadProperties(System.getProperty("user.dir")+"\\src\\main\\java\\properties\\userdata.properties");

	//load soucelabs account data
	public static Properties soucelabsData= loadProperties(System.getProperty("user.dir")+"\\src\\main\\java\\properties\\soucelabsUser.properties");


	private static Properties loadProperties(String path) 
	{
		Properties pro= new Properties();
		//stream for reading file 
		try {
			FileInputStream stream= new FileInputStream(path);
			try {
				pro.load(stream);
			} catch (IOException e) {
				System.out.println("Error Occured: "+ e.getMessage());

			}
		} catch (FileNotFoundException e) {
			System.out.println("Error Occured: "+ e.getMessage());

		}
		return pro;
	}
}