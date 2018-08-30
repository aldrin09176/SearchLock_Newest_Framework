package com.Objects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.Pages.SearchLockPages;
import com.Utility.BaseDriver;

public class CommonMethods extends BaseDriver{

	
	private By by;
	private String name;
	private WebElement element;
	
	public CommonMethods (String name, By by) {
		
		this.by = by;
		this.name = name;
	}
	
	private void verifyElement() {
		setElement();
		if (element == null) {
			System.err.println("Element "+name+" is not displayed!!");
			Assert.fail();
		}
	}
	
	private void setElement() {
		BaseDriver.waitLoading(1);
		this.element = BaseDriver.findElement(by);
		
	}
	
	public void verifyDisplayed() {
		
		setElement();
		if (element !=null) {
			System.out.println("Element "+name+" is displayed!");
		}else {
			System.err.println("Element "+name+" is not displayed!!");
			Assert.fail();
		}	
	}
	
	public void verifyNotDisplayed() {
		setElement();
		if (element == null) {
			System.out.println("Element "+name+" is not displayed!");
		}else {
			System.err.println("Element "+name+" is displayed!!");
			Assert.fail();
		}
	}
	
	public void verifyIfEqual(String ExpectedRes) 
	{
		setElement();
		if (element !=null) {
			System.out.println("Element "+name+" is displayed!");
			Assert.assertEquals(element.getText(), ExpectedRes);
		}else {
			System.err.println("Element "+name+" is not displayed!!");
			Assert.fail();
		}	
	}
	
	
	public void click() {
		
		verifyElement();
		element.click();
	}
	
	public void setText(String text) {
		verifyElement();
		element.clear();
		element.sendKeys(text);
	}
	
	//Select data on the dropdown
	public void selectByVisibleText(String text) {
		verifyElement();
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	public String getText() {
		
		verifyElement();
		return element.getText();
	}
	
	public void submitText() {
		verifyElement();
		element.submit();
	}
	
	public static void switchTab()
	{
		System.out.println("SwitchTab");
		BaseDriver.waitLoading(2);
	   	ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	   	BaseDriver.waitLoading(2);
	    driver.switchTo().window(tabs.get(1));
	    BaseDriver.waitLoading(1);
		driver.close();
		BaseDriver.waitLoading(2);
	    driver.switchTo().window(tabs.get(0));
	    driver.get("https://www.google.com/");
	}
	
    public static void isSearchLockSerpPresentInURL() {
        String src = driver.getCurrentUrl();
     if(src.contains("results.searchlock.com"))
     {
    	 System.out.println("Correct URL Serp found: " + src);
     }
     else
     {
 		System.err.println("Incorrect URL Serp found: +" + src);
    	 Assert.fail();
     }

    }
    
    public static void checkTheNumberOfSearchResultonSL() {
		List<WebElement> findElements = driver.findElements(By.xpath("//div[@class='wrapper']/div/ul/li/p/a"));
		
		int x = findElements.size();
		if(x >= 10) 
		{
			System.out.println("Correct number of Search Result found: " + x);
		}
		else
		{
	 		System.err.println("Incorrect number of Search Result found: " + x);
	    	Assert.fail();
		}
//	    //To check all lahat ng lumabas na searches title
//	    for (WebElement webElement : findElements)
//	    {
//	        System.out.println(webElement.getAttribute("href"));
//	    }
	}
    
	public static void clickLockIcon()
	{
		WebElement firefox_lockIcon = driver.findElement(By.id("slck_tiphvr"));
		Actions builder = new Actions(driver);
		Action mouseOverHome = builder.moveToElement(firefox_lockIcon).build();
		mouseOverHome.perform();
	}
	
}
