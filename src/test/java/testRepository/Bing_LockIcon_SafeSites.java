package testRepository;

import org.testng.annotations.Test;
import com.Objects.SafelistObjects;
import com.Pages.SLURLRedirections;
import com.Utility.BaseDriver;

public class Bing_LockIcon_SafeSites extends BaseDriver{

	SLURLRedirections SLurl = new SLURLRedirections();
	SafelistObjects safelist = new SafelistObjects();
	
	//Priority 6-10
	
	@Test(priority=6)
	public void SafeList_Bing_HomePage() throws Exception
	{
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println("----------------- "+name+" -----------------");
		driver.get(SLurl.bingURL);
		safelist.SafeListChromeWebRedirection();
	}
	
	@Test(priority=7)
	public void SafeList_Bing_Images() throws Exception
	{
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println("----------------- "+name+" -----------------");
		driver.get(SLurl.bingImagesURL);
		safelist.SafeListImagesRedirection_For_BING();
	}
	
	@Test(priority=8)
	public void SafeList_Bing_Videos() throws Exception
	{
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println("----------------- "+name+" -----------------");
		driver.get(SLurl.bingVideoURL);
		safelist.SafeListVideoRedirection_For_Bing();
	}
	
	//Can't be run because of the Bing Explore button issue from their website. 
	@Test(priority=9)
	public void SafeList_Bing_Explore() throws Exception
	{
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println("----------------- "+name+" -----------------");
		driver.get(SLurl.bingExploreURL);
		safelist.SafeListChromeWebRedirection_For_BING();
	}
	
	@Test(priority=9)
	public void SafeList_Bing_Fun() throws Exception
	{
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println("----------------- "+name+" -----------------");
		driver.get(SLurl.bingFunURL);
		safelist.SafeListChromeWebRedirection_For_BING();
	}
	

}
