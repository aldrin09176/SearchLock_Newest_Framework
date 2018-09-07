package testRepository;

import org.testng.annotations.Test;

import com.Objects.HelperMethods;
import com.Objects.SafelistObjects;
import com.Pages.SLURLRedirections;
import com.Pages.SearchLockPages;
import com.Utility.BaseDriver;

public class Google_LockIcon_SafeSites extends BaseDriver{

	SLURLRedirections SLurl = new SLURLRedirections();
	SafelistObjects safelist = new SafelistObjects();
	SearchLockPages SLPages = new SearchLockPages();
	HelperMethods helper = new HelperMethods();
	
	//priority 1-5
	
	@Test(priority=1, testName="C8152+C8585+C8558_Check SearchLock icon and notification on Google Homepage")
	public void SafeList_Google_HomePage() throws Exception
	{
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println("----------------- "+name+" -----------------");
		driver.get(SLurl.searchlockURL);
		driver.get(SLurl.googleURL);
		safelist.SafeListChromeWebRedirection();
	}
	
	@Test(priority=2, testName="C8333+C8592+C8559_Check SearchLock icon and notification on Google Images page")
	public void SafeList_Google_Images() throws Exception
	{
		helper.switchTab();
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println("----------------- "+name+" -----------------");
		driver.get(SLurl.googleImageURL);
		safelist.SafeListImageRedirection();
	}
	
	@Test(priority=3, testName="C8336+C8596+C8808_Check SearchLock icon and notification on Google Images page via Images link")
	public void SafeList_Google_ImagesLink() throws Exception
	{
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println("----------------- "+name+" -----------------");
		driver.get(SLurl.googleURL);
		SLPages.imagesBtn.click();
		safelist.SafeListImageRedirection();
	}
	
	@Test(priority=4, testName="C8727+C8593+C8560_Check SearchLock icon and notification on video.google.com page")
	public void SafeList_Google_Videos() throws Exception
	{
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println("----------------- "+name+" -----------------");
		driver.get(SLurl.googleVideoURL);
		safelist.SafeListVideoRedirection();
	}
	
	@Test(priority=5, testName="C8338+C8594_Check SearchLock icon and notification on google.com/shopping page")
	public void SafeList_Google_Shopping() throws Exception
	{
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println("----------------- "+name+" -----------------");
		driver.get(SLurl.googleShoppingURL);
		safelist.SafeListShoppingRedirection();
	}
}
