package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Readconfiguration {

	Properties pro;     //java ki class properties class for read
	
	String path= "Config.properties";   //jise read krna he
	
	//constructor
	
	public Readconfiguration() throws IOException
	{
		pro= new Properties();
		
		try {
	// to open config.properties file in input mode and load file		
			FileInputStream fis= new FileInputStream(path);      //read only
			pro.load(fis);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//method for browser keyword to fetch the  value
	public String getbrowser()
	{
		String value = pro.getProperty("browser");
		if(value!=null)
		{
			return value;
		
		}
		else
		{
			throw new RuntimeException("url not found");
		}
	}
}
