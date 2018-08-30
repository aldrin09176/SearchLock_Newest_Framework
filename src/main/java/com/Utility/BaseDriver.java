package com.Utility;

import java.io.File;
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
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;

public class BaseDriver {

	public static WebDriver driver = initializeWebBrowser();
	private static final int IMPLICIT_TIMEOUT_SECONDS = 3;
	private static final int EXPLICIT_TIMEOUT_SECONDS = 3;
	private static final int SEARCH_LIMIT = 5;

	
	public static WebDriver initializeWebBrowser()
	{
		if(ConfigReader.getTestBrowser().equalsIgnoreCase("Chrome"))
		{
		    //-------------------Code for Running on the Local Machine----------------------------------
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
	        options.addExtensions(new File(ConfigReader.getExtensionName()));
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
//	        options.addExtensions(new File(ConfigReader.getExtensionName()));
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
		}
		else if(ConfigReader.getTestBrowser().equalsIgnoreCase("Firefox"))
		{
			//-------------------To install an XPI file on the Firefox Developer Edition Browser (Not working any longer)----------------------------------
//			//Binary Path. Location of the Firefox Developer Edition
//			System.setProperty("webdriver.gecko.driver", config.FirefoxDriver);
//			File pathToBinary = new File("C:\\Program Files\\Firefox Developer Edition\\firefox.exe");
//			FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
//			//Profile for installing Extension
//			FirefoxProfile firefoxprofile = new FirefoxProfile();
//			//Extension Path (.xpi file)
//			File addonpath = new File(ConfigReader.OldSLExtensionFirefox);
//			firefoxprofile.addExtension(addonpath);
//			//Initialize Firefox
//			driver = new FirefoxDriver(ffBinary,firefoxprofile);
			
			//-------------------To install an XPI file on the normal Firefox Browser (Not working any longer)----------------------------------
//			System.setProperty("webdriver.gecko.driver", config.FirefoxDriver);
//			FirefoxProfile firefoxprofile = new FirefoxProfile();
//			File addonpath = new File(ConfigReader.OldSLExtensionFirefox);
//			firefoxprofile.addExtension(addonpath);
//			driver = new FirefoxDriver(firefoxprofile);
			String os = System.getProperty("os.name").toLowerCase();
			
			if(os.contains("windows"))
			{
				System.setProperty("webdriver.gecko.driver",ConfigReader.FirefoxDriver);
				ProfilesIni profile = new ProfilesIni();
				FirefoxProfile myprofile = profile.getProfile("profileToolsQA"); 
				myprofile.setPreference("dom.popup_maximum", 0);
				myprofile.setPreference("privacy.popups.showBrowserMessage", false);
				//Depricated on Selenium Version greather than v3.12.0
				//driver = new FirefoxDriver(myprofile);
			}
			else if (os.contains("mac")) 
			{
				System.setProperty("webdriver.gecko.driver",ConfigReader.FirefoxDriver);
				FirefoxBinary binary = new FirefoxBinary();
				File firefoxProfileFolder = new File("/Users/asy/Library/Application Support/Firefox/Profiles/wef58crr.firefoxprofile");
			    FirefoxProfile profile = new FirefoxProfile(firefoxProfileFolder);
			  //Depricated on Selenium Version greather than v3.12.0
			  //driver = new FirefoxDriver(binary, profile);
			}
		}
		driver.manage().timeouts().implicitlyWait(IMPLICIT_TIMEOUT_SECONDS,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
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
	
	public static WebElement findElement (By by) {
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
	
}
