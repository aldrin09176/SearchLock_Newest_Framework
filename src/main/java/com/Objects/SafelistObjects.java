package com.Objects;

import java.util.ArrayList;

import com.Pages.SLURLRedirections;
import com.Pages.SearchLockPages;
import com.Utility.BaseDriver;

public class SafelistObjects extends BaseDriver {
	
	SearchLockPages SLPages = new SearchLockPages();
	SLURLRedirections SLurl = new SLURLRedirections();
	HelperMethods helper = new HelperMethods();

	public void SafeListChromeWebRedirection() throws Exception
	{
		SLPages.lockIconOnSearchBar.verifyDisplayed();
		//SLPages.lockIconNotification.verifyIfEqual(SLPages.expectedSearchSLbNotification);
		helper.getTextValue(SLPages.lockIconNotificationElement());
		SLPages.searchBar.setText(SLPages.DataSearch);
		SLPages.autoSuggestList.verifyNotDisplayed();
		SLPages.searchBar.submitText();
		SLPages.amazonResult.verifyDisplayed();
		SLPages.serpWebRedirection.verifyDisplayed();
		helper.isSearchLockSerpPresentInURL();
		helper.checkTheNumberOfSearchResultonSL();
	}
	
	public void SafeListImageRedirection() throws Exception
	{
		SLPages.lockIconOnSearchBar.verifyDisplayed();
		//SLPages.lockIconNotification.verifyIfEqual(SLPages.expectedSearchSLbNotification);
		helper.getTextValue(SLPages.lockIconNotificationElement());
		SLPages.searchBar.setText(SLPages.DataSearch);
		SLPages.autoSuggestList.verifyNotDisplayed();
		SLPages.searchBar.submitText();
		SLPages.serpImagesRedirection.verifyDisplayed();
		helper.isSearchLockSerpPresentInURL();
	}

	public void SafeListVideoRedirection() throws Exception
	{
		SLPages.lockIconOnSearchBar.verifyDisplayed();
		//SLPages.lockIconNotification.verifyIfEqual(SLPages.expectedSearchSLbNotification);
		helper.getTextValue(SLPages.lockIconNotificationElement());
		SLPages.searchBar.setText(SLPages.DataSearch);
		SLPages.autoSuggestList.verifyNotDisplayed();
		SLPages.searchBar.submitText();
		SLPages.serpVideosRedirection.verifyDisplayed();
		helper.isSearchLockSerpPresentInURL();
	}
	
	public void SafeListShoppingRedirection() throws Exception
	{
		SLPages.lockIconOnSearchBar.verifyDisplayed();
		//SLPages.lockIconNotification.verifyIfEqual(SLPages.expectedSearchSLbNotification);
		helper.getTextValue(SLPages.lockIconNotificationElement());
		SLPages.searchBar.setText(SLPages.DataSearch);
		SLPages.autoSuggestList.verifyNotDisplayed();
		SLPages.searchBar.submitText();
		SLPages.serpShoppingRedirection.verifyDisplayed();
	}
	
	public void SafeListChromeWebRedirection_For_BING() throws Exception
	{
		SLPages.lockIconOnSearchBar.verifyDisplayed();
		//SLPages.lockIconNotification.verifyIfEqual(SLPages.expectedSearchSLbNotification);
		helper.getTextValue(SLPages.lockIconNotificationElement());
		SLPages.searchBar.setText(SLPages.DataSearch);
		SLPages.autoSuggestList.verifyNotDisplayed();
	}
	
	public void SafeListImagesRedirection_For_BING() throws Exception
	{
		SLPages.lockIconOnSearchBar.verifyDisplayed();
		//SLPages.lockIconNotification.verifyIfEqual(SLPages.expectedSearchSLbNotification);
		helper.getTextValue(SLPages.lockIconNotificationElement());
		SLPages.searchBar.setText(SLPages.DataSearch);
		SLPages.autoSuggestList.verifyNotDisplayed();
	}
	
	public void SafeListVideoRedirection_For_Bing() throws Exception
	{
		SLPages.lockIconOnSearchBar.verifyDisplayed();
		//SLPages.lockIconNotification.verifyIfEqual(SLPages.expectedSearchSLbNotification);
		helper.getTextValue(SLPages.lockIconNotificationElement());
		SLPages.searchBar.setText(SLPages.DataSearch);
		SLPages.autoSuggestList.verifyNotDisplayed();
	}
	
	public void SafeListChromeWebRedirection_For_MSN() throws Exception
	{
		SLPages.lockIconOnSearchBar.verifyDisplayed();
		//SLPages.lockIconNotification.verifyIfEqual(SLPages.expectedSearchSLbNotification);
		helper.getTextValue(SLPages.lockIconNotificationElement());
		SLPages.searchBar.setText(SLPages.DataSearch);
		SLPages.autoSuggestList.verifyNotDisplayed();
		SLPages.searchBar.submitText();
		
	   	ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
    
	    SLPages.amazonResult.verifyDisplayed();
		SLPages.serpWebRedirection.verifyDisplayed();
		helper.isSearchLockSerpPresentInURL();
		helper.checkTheNumberOfSearchResultonSL();

	    driver.close();
	    driver.switchTo().window(tabs2.get(0));
	}
	
}
