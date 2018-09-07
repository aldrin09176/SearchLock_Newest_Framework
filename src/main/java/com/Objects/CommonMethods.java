package com.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.Utility.BaseDriver;

public class CommonMethods{

	
	private By by;
	private String name;
	private WebElement element;
	BaseDriver bDriver = new BaseDriver();
	
	public CommonMethods (String name, By by) {
		
		this.by = by;
		this.name = name;
	}
	
	private void verifyElement() {
		setElement();
		if (element == null) {
			System.err.println("FAILED: Element "+name+" is not displayed!!");
			Assert.fail();
		}
	}
	
	private void setElement() {
		BaseDriver.waitLoading(1);
		this.element = bDriver.findElement(by);
		
	}
	
	public void verifyDisplayed() {
		
		setElement();
		if (element !=null) {
			System.out.println("Element "+name+" is displayed!");
		}else {
			System.err.println("FAILED: Element "+name+" is not displayed!!");
			Assert.fail();
		}	
	}
	
	public void verifyNotDisplayed() {
		setElement();
		if (element == null) {
			System.out.println("Element "+name+" is not displayed!");
		}else {
			System.err.println("FAILED: Element "+name+" is displayed!!");
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
			System.err.println("FAILED: Element "+name+" is not displayed!!");
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
	

    

    
    

	
}
