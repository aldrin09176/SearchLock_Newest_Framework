package testRepository;

import org.testng.annotations.Test;

import com.Objects.SafelistObjects;
import com.Pages.SLURLRedirections;
import com.Utility.BaseDriver;

public class MyWebSearch_LockIcon_SafeSites extends BaseDriver{

	SLURLRedirections SLurl = new SLURLRedirections();
	SafelistObjects safelist = new SafelistObjects();
	
	//priority 14
	
	@Test(priority=14)
	public void SafeList_MyWeb_HomePage() throws Exception
	{
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println("----------------- "+name+" -----------------");
		driver.get(SLurl.myWebSearchURL);
		safelist.SafeListChromeWebRedirection();
	}
}