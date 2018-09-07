package com.Utility;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader 
{
	public static String MainPropertyPath = "./src/main/resources/Properties/MainConfig.properties";
	
	public static String ChromeDriver = (ConfigReader.getTestPlatform().equalsIgnoreCase("windows")) ? System.getProperty("user.dir")
			+ "/src/main/resources/BrowserDrivers/chromedriver.exe" : System.getProperty("user.dir")
			+ "/src/main/resources/BrowserDrivers/chromedriver";
	
	public static String FirefoxDriver = (ConfigReader.getTestPlatform().equalsIgnoreCase("windows")) ? System.getProperty("user.dir")
			+ "/src/main/resources/BrowserDrivers/geckodriver.exe" : System.getProperty("user.dir")
			+ "/src/main/resources/BrowserDrivers/geckodriver";
	
	public static String getTestBrowser()
	{
		String tbrowser = setReadProperty("TestBrowser",MainPropertyPath);
		return tbrowser;
	}
	
	public static String getTestBrowserVersion()
	{
		String tbrowserVersion = setReadProperty("TestBrowser_Version",MainPropertyPath);
		return tbrowserVersion;
	}
	
	public static String getTestPlatform()
	{
		String tplatform = setReadProperty("TestPlatform",MainPropertyPath);
		return tplatform;
	}
	
	public static String getTestPlatformVersion()
	{
		String tplatformVersion = setReadProperty("Platform_Version",MainPropertyPath);
		return tplatformVersion;
	}
	
	public static String getTestExtension()
	{
		String textension = setReadProperty("TestExtension",MainPropertyPath);
		return textension;
	}
	
	public static String setReadProperty(String field,String path){
       
        Properties prop = new Properties();
        
        try
        {           
            prop.load(new FileInputStream(path));
        }
        catch (IOException e)
        {
            System.out.println("Could not open Config file");     
        }   
        return prop.getProperty(field);
        
    }
    
	public String getUsername()
	{
		String sUsername = setReadProperty("username",MainPropertyPath);
		return sUsername;
	}
	
	public String getPassword()
	{
		String sPassword = setReadProperty("password",MainPropertyPath);
		return sPassword;
	}
	
	


}

