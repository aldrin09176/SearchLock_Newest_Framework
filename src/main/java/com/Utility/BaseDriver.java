package com.Utility;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.Pages.SearchLockPages;

public class BaseDriver {
	
	public static WebDriver driver = null;
	private final int IMPLICIT_TIMEOUT_SECONDS = 3;
	private final int EXPLICIT_TIMEOUT_SECONDS = 3;
	private final int SEARCH_LIMIT = 5;
	public static String extensionName = "";

	
	@BeforeTest
	@Parameters("myBrowser")
	public void initializeWebBrowser(String myExtension) throws Exception
	{
			extensionName = myExtension;
			System.out.println("-----------------------------------------Extension Version " + myExtension + " -----------------------------------------");
//		    //-------------------Code for Running on the Local Machine----------------------------------
			System.setProperty("webdriver.chrome.driver", ConfigReader.ChromeDriver);
			ChromeOptions options = new ChromeOptions();
	        Map<String, Object> prefs = new HashMap<String, Object>();
	        prefs.put("profile.default_content_settings.popups", 2); //Disable Chrome notification. 0=Default , 1=Allow , 2=Block
	        //Code for running the browser to English Language (It's Either the below code (Line 38 or the Line 47)
	        //prefs.put("intl.accept_languages", "us");
	        prefs.put("credentials_enable_service", false);
	        prefs.put("password_manager_enabled", false);
	        //Below Code is for reading the Google Chrome Profile
	        //options.addArguments("user-data-dir=C:\\Users\\Asy\\AppData\\Local\\Google\\Chrome\\User Data\\GCTesting\\");
	        options.addExtensions(new File(System.getProperty("user.dir")+"/src/main/resources/Extension/production/"+myExtension));
	        options.setExperimentalOption("prefs", prefs);
	        options.addArguments("--test-type");
	        //options.addArguments("--lang=us");
	        options.addArguments("disable-infobars");
	        options.addArguments("start-maximized");
			//Create Capabilities
	        DesiredCapabilities cap = DesiredCapabilities.chrome();
	        cap.setCapability(ChromeOptions.CAPABILITY, options);
	        cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
	        driver = new ChromeDriver(cap);
	        
	        //-------------------Code for Running on the BrowserStack----------------------------------	
//			ChromeOptions options = new ChromeOptions();
//	        Map<String, Object> prefs = new HashMap<String, Object>();
//	        prefs.put("profile.default_content_settings.popups", 2); //Disable Chrome notification. 0=Default , 1=Allow , 2=Block
//	        //Code for running the browser to English Language (It's Either the below code (Line 61 or the Line 67)
//	        prefs.put("intl.accept_languages", "en-GB");
//	        prefs.put("credentials_enable_service", false);
//	        prefs.put("password_manager_enabled", false);
//	        options.addExtensions(new File(System.getProperty("user.dir")+"/src/main/resources/Extension/production/"+myExtension));
//	        options.setExperimentalOption("prefs", prefs);
//	        options.addArguments("--test-type");
//	        //options.addArguments("--lang=en");
//	        options.addArguments("disable-infobars");
//	        options.addArguments("start-maximized");
//			//Create Capabilities
//			DesiredCapabilities caps = new DesiredCapabilities();
//			caps.setCapability(ChromeOptions.CAPABILITY, options);
//	        caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
//	        caps.setCapability("os", ConfigReader.getTestPlatform());
//	        caps.setCapability("os_version", ConfigReader.getTestPlatformVersion());
//	        //caps.setCapability("resolution", "1680x1050");
//	        caps.setCapability("browser", ConfigReader.getTestBrowser());
//	        caps.setCapability("browser_version", ConfigReader.getTestBrowserVersion());
//	        caps.setCapability("browserstack.selenium_version", "3.5.2");
//	        caps.setCapability("browserstack.local", "false");
//			//Create a URL / Username in BrowserStack = aldrinsy2 / AccessKey in BrowserStack = MEs4wUroYXMMqwpisEgr
//			String stringUrl = "https://aldrinsy2:MEs4wUroYXMMqwpisEgr@hub-cloud.browserstack.com/wd/hub";
//			URL serverUrl = null;
//			try {
//				serverUrl = new URL(stringUrl);
//			} catch (MalformedURLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			driver = new RemoteWebDriver(serverUrl,caps); 
	       
	    	driver.manage().timeouts().implicitlyWait(IMPLICIT_TIMEOUT_SECONDS,TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}

	public static void waitLoading(int i) 
	{
		
		try {
			Thread.sleep(i*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public WebElement findElement (By by) {
		BaseDriver.waitLoading(1);
		WebElement element = null;
		int i = 0;
		
		while (i != SEARCH_LIMIT && element == null) {
			i++;
			try {
				element = new WebDriverWait(driver, EXPLICIT_TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(by));
			} catch (Exception e) {
				element = null;
			}
		}
		
		if (element != null) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
			jse.executeScript("arguments[0].scrollIntoView(true);window.scrollBy(0, -window.innerHeight /4);", element);

			Actions actions = new Actions(driver);
			actions.moveToElement(element);
			actions.perform();
		}
		
		return element;
	}
	
	@AfterTest
	public void exitWebDriver(){
	driver.quit();	
	}
	
}
