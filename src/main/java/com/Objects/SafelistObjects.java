package com.Objects;

import org.openqa.selenium.By;

import com.Pages.SLURLRedirections;
import com.Pages.SearchLockPages;
import com.Utility.BaseDriver;

public class SafelistObjects extends BaseDriver {
	
	SearchLockPages SLPages = new SearchLockPages();
	SLURLRedirections SLurl = new SLURLRedirections();

	public void SafeListChromeWebRedirection() throws Exception
	{
		SLPages.lockIconOnSearchBar.verifyDisplayed();
		SLPages.lockIconNotification.verifyIfEqual(SLPages.expectedSearchSLbNotification);
		SLPages.searchBar.setText(SLPages.DataSearch);
		SLPages.autoSuggestList.verifyNotDisplayed();
		SLPages.searchBar.submitText();
		SLPages.amazonResult.verifyDisplayed();
		SLPages.serpWebRedirection.verifyDisplayed();
		CommonMethods.isSearchLockSerpPresentInURL();
		CommonMethods.checkTheNumberOfSearchResultonSL();
	}
	
	public void SafeListImageRedirection() throws Exception
	{
		SLPages.lockIconOnSearchBar.verifyDisplayed();
		SLPages.lockIconNotification.verifyIfEqual(SLPages.expectedSearchSLbNotification);
		SLPages.searchBar.setText(SLPages.DataSearch);
		SLPages.autoSuggestList.verifyNotDisplayed();
		SLPages.searchBar.submitText();
		SLPages.serpImagesRedirection.verifyDisplayed();
		CommonMethods.isSearchLockSerpPresentInURL();
	}
	
	public void SafeListVideoRedirection() throws Exception
	{
		SLPages.lockIconOnSearchBar.verifyDisplayed();
		SLPages.lockIconNotification.verifyIfEqual(SLPages.expectedSearchSLbNotification);
		SLPages.searchBar.setText(SLPages.DataSearch);
		SLPages.autoSuggestList.verifyNotDisplayed();
		SLPages.searchBar.submitText();
		SLPages.serpVideosRedirection.verifyDisplayed();
		CommonMethods.isSearchLockSerpPresentInURL();
	}
	
	public void SafeListShoppingRedirection() throws Exception
	{
		SLPages.lockIconOnSearchBar.verifyDisplayed();
		SLPages.lockIconNotification.verifyIfEqual(SLPages.expectedSearchSLbNotification);
		SLPages.searchBar.setText(SLPages.DataSearch);
		SLPages.autoSuggestList.verifyNotDisplayed();
		SLPages.searchBar.submitText();
		SLPages.serpShoppingRedirection.verifyDisplayed();
	}
	
	public void SafeListImagesRedirection_For_BING() throws Exception
	{
		SLPages.lockIconOnSearchBar.verifyDisplayed();
		SLPages.lockIconNotification.verifyIfEqual(SLPages.expectedSearchSLbNotification);
		SLPages.searchBar.setText(SLPages.DataSearch);
		SLPages.autoSuggestList.verifyNotDisplayed();
	}
	
}
