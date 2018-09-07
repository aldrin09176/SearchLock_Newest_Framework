package testRepository;

import org.testng.annotations.Test;

import com.Objects.SafelistObjects;
import com.Pages.SLURLRedirections;
import com.Utility.BaseDriver;

public class Ask_LockIcon_SafeSites extends BaseDriver{

	SLURLRedirections SLurl = new SLURLRedirections();
	SafelistObjects safelist = new SafelistObjects();
	
	//priority 11-12
	
	@Test(priority=11)
	public void SafeList_Ask_HomePage() throws Exception
	{
		//System.out.println(SLURLRedirections.lockIconNotificationElement());
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println("----------------- "+name+" -----------------");
		driver.get(SLurl.getAskURL());
		safelist.SafeListChromeWebRedirection();
	}
	
	@Test(priority=12)
	public void SafeList_Ask_Video() throws Exception
	{
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println("----------------- "+name+" -----------------");
		driver.get(SLurl.getAskVideoURL());
		safelist.SafeListVideoRedirection();
	}
}
