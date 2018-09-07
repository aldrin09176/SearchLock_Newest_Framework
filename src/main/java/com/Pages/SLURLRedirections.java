package com.Pages;

import com.Utility.BaseDriver;

public class SLURLRedirections extends BaseDriver{

	public String searchlockURL = "https://searchlock.com";
	
	public String googleURL = "https://google.com";
	public String googleImageURL = "https://images.google.com";
	public String googleVideoURL = "https://www.google.com/videohp";
	public String googleShoppingURL = "https://www.google.com/shopping";
	
	public String bingURL = "https://www.bing.com/";
	public String bingImagesURL = "https://www.bing.com/images/";
	public String bingVideoURL = "https://www.bing.com/video/";
	public String bingExploreURL = "https://www.bing.com/explore/";
	public String bingFunURL = "https://www.bing.com/fun";
	
	public String myWayURL = "https://hp.myway.com/";
	
	public String myWebSearchURL = "https://hp.mywebsearch.com/";
	
	public String wowURL = "https://wow.com";
	
	public String msnURL = "https://www.msn.com/en-us";
	public String msnWeatherURL = "https://www.msn.com/en-us";
	public String msnNewsURL = "https://www.msn.com/en-us/news";
	public String msnEntertainmentURL = "https://www.msn.com/en-us/entertainment";
	public String msnSportsURL = "https://www.msn.com/en-us/sports";
	public String msnMoneysURL = "https://www.msn.com/en-us/money";
	public String msnLifestyleURL = "https://www.msn.com/en-us/lifestyle";
	public String msnHealthURL = "http://www.msn.com/en-us/health";
	public String msnFoodURL = "http://www.msn.com/en-us/foodanddrink";
	public String msnTravelURL = "http://www.msn.com/en-us/travel";
	public String msnAutosURL = "http://www.msn.com/en-us/autos";
	public String msnVideosURL = "http://www.msn.com/en-us/videos";
		
	public String getAskURL()
	{
		String sgetAskURL = null;
		if(BaseDriver.extensionName.contains("france"))
		{
			sgetAskURL = "https://fr.ask.com/";
		}
		else if(BaseDriver.extensionName.contains("germany"))
		{
			sgetAskURL = "https://de.ask.com/";
		}
		else
		{
			sgetAskURL = "http://www.ask.com/";
		}
		return sgetAskURL;
	}
	
	public String getAskVideoURL()
	{
		String sAskVideoURL = null;
		if(BaseDriver.extensionName.contains("france"))
		{
			sAskVideoURL = "https://fr.ask.com/youtube";
		}					
		else if(BaseDriver.extensionName.contains("germany"))
		{
			sAskVideoURL = "https://de.ask.com/youtube";					
		}
		else
		{
			sAskVideoURL = "http://www.ask.com/youtube";
		}
		return sAskVideoURL;
	}
	
	

	
	
		
	
	
	
	
		
	
}
