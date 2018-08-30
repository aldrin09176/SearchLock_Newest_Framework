package com.Pages;

import org.openqa.selenium.By;
import com.Objects.CommonMethods;
import com.Utility.BaseDriver;

public class SearchLockPages extends BaseDriver {
	
	public final CommonMethods lockIconOnSearchBar = new CommonMethods("Lock Icon on Search Bar", By.xpath("//input[contains(@style, 'icon')]"));
	public final CommonMethods lockIconNotification = new CommonMethods("Lock Icon Notification", By.id("sl-tooltip"));
	public final CommonMethods searchBar = new CommonMethods("SearchLock search bar", By.name("q"));
	public final CommonMethods autoSuggestList = new CommonMethods("List of Auto Suggest", By.xpath("//ul[@role='listbox']/li[@role='presentation']"));
	public final CommonMethods amazonResult = new CommonMethods("Amazon Shop in Serp", By.id("productWidget"));
	public final CommonMethods serpWebRedirection = new CommonMethods("Redirection to Web Serp", By.xpath("//li[@class='active']/a[text()='Web']"));
	public final CommonMethods serpImagesRedirection = new CommonMethods("Redirection to Images Serp", By.xpath("//li[@class='active']/a[text()='Images']"));
	public final CommonMethods serpVideosRedirection = new CommonMethods("Redirection to Videos Serp", By.xpath("//li[@class='active']/a[text()='Videos']"));
	public final CommonMethods serpShoppingRedirection = new CommonMethods("Redirection to Shopping Serp", By.xpath("//a[@class='nav-link active'][text()='Shopping']"));
	
	
	public final CommonMethods serpNumberOfResult = new CommonMethods("Number of Result in Serp", By.xpath("//div[@class='wrapper']/div/ul/li/p/a"));
	public final CommonMethods imagesBtn = new CommonMethods("Images Link on Google Home Page", By.xpath("//a[text()='Images']"));
	
	
	public final CommonMethods searchBtnBing = new CommonMethods("Search button on Bing", By.id("sb_form_go"));
	

	
	
	
	
	public String expectedSearchSLbNotification = "This search will be privacy-protected by redirecting to SearchLock. Learn More";
	public String DataSearch = "Sling Bag";
	
	
}
