package com.Objects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.Pages.SearchLockPages;
import com.Utility.BaseDriver;

public class HelperMethods extends BaseDriver{
	
	SearchLockPages SLPages = new SearchLockPages();

    public void getTextValue(WebElement locator)
	{
    	
    		if(locator.getText().equals(SLPages.expectedSearchSLbNotification))
    		{
    			System.out.println("SearchLock Notification is correct");
    		}
    		else 
    		{
    			System.err.println("FAILED: Incorrect SearchLock Notification:" + SLPages.expectedSearchSLbNotification);
    			Assert.fail();
    		}
    }

   
    
	public void clickLockIcon()
	{
		WebElement firefox_lockIcon = BaseDriver.driver.findElement(By.id("slck_tiphvr"));
		Actions builder = new Actions(BaseDriver.driver);
		Action mouseOverHome = builder.moveToElement(firefox_lockIcon).build();
		mouseOverHome.perform();
	}
	
	public void switchTab()
	{
		System.out.println("Switch Tab to close the Welcome Page New Tab");
		BaseDriver.waitLoading(2);
	   	ArrayList<String> tabs = new ArrayList<String> (BaseDriver.driver.getWindowHandles());
	   	BaseDriver.waitLoading(2);
	    BaseDriver.driver.switchTo().window(tabs.get(1));
	    BaseDriver.waitLoading(1);
	    BaseDriver.driver.close();
		BaseDriver.waitLoading(2);
		BaseDriver.driver.switchTo().window(tabs.get(0));
		BaseDriver.driver.get("https://www.google.com/");
	}
	
    public void isSearchLockSerpPresentInURL() {
        String src = BaseDriver.driver.getCurrentUrl();
     if(src.contains("results.searchlock.com"))
     {
    	 System.out.println("Correct URL Serp found: " + src);
     }
     else
     {
 		System.err.println("FAILED: Incorrect URL Serp found: +" + src);
    	 Assert.fail();
     }

    }
    
    public void checkTheNumberOfSearchResultonSL() {
		List<WebElement> findElements = BaseDriver.driver.findElements(By.xpath("//div[@class='wrapper']/div/ul/li/p/a"));
		
		int x = findElements.size();
		if(x >= 10) 
		{
			System.out.println("Number of Search Result found: " + x);
		}
		else
		{
	 		System.err.println("FAILED: Incorrect number of Search Result found: " + x);
	    	Assert.fail();
		}
//	    //To check all lahat ng lumabas na searches title
//	    for (WebElement webElement : findElements)
//	    {
//	        System.out.println(webElement.getAttribute("href"));
//	    }
	}
	
	
}
