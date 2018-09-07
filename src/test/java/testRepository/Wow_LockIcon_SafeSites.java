package testRepository;

import org.testng.annotations.Test;

import com.Objects.SafelistObjects;
import com.Pages.SLURLRedirections;
import com.Utility.BaseDriver;

public class Wow_LockIcon_SafeSites extends BaseDriver{

	SLURLRedirections SLurl = new SLURLRedirections();
	SafelistObjects safelist = new SafelistObjects();
	
	//priority 15
	
	@Test(priority=15)
	public void SafeList_WOW_HomePage() throws Exception
	{
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println("----------------- "+name+" -----------------");
		driver.get(SLurl.wowURL);
		safelist.SafeListChromeWebRedirection();
	}
}