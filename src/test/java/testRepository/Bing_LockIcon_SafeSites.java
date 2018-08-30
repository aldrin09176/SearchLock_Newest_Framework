package testRepository;

import org.testng.annotations.Test;
import com.Objects.SafelistObjects;
import com.Pages.SLURLRedirections;
import com.Utility.BaseDriver;

public class Bing_LockIcon_SafeSites extends BaseDriver{

	SLURLRedirections SLurl = new SLURLRedirections();
	SafelistObjects safelist = new SafelistObjects();
	
	@Test(priority=1)
	public void SafeList_Bing_HomePage() throws Exception
	{
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println("----------------- "+name+" -----------------");
		driver.get(SLurl.bingURL);
		safelist.SafeListChromeWebRedirection();
	}
	
	@Test(priority=2)
	public void SafeList_Bing_Images() throws Exception
	{
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println("----------------- "+name+" -----------------");
		driver.get(SLurl.bingImagesURL);
		safelist.SafeListImagesRedirection_For_BING();
	}
	
	@Test(priority=3)
	public void SafeList_Bing_Videos() throws Exception
	{
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println("----------------- "+name+" -----------------");
		driver.get(SLurl.bingVideoURL);
		safelist.SafeListVideoRedirection();
	}
	
	@Test(priority=4)
	public void SafeList_Bing_Explore() throws Exception
	{
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println("----------------- "+name+" -----------------");
		driver.get(SLurl.bingExploreURL);
		safelist.SafeListChromeWebRedirection();
	}
	
	@Test(priority=4)
	public void SafeList_Bing_Fun() throws Exception
	{
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println("----------------- "+name+" -----------------");
		driver.get(SLurl.bingFunURL);
		safelist.SafeListChromeWebRedirection();
	}
	

}
