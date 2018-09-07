package testRepository;

import org.testng.annotations.Test;

import com.Objects.SafelistObjects;
import com.Pages.SLURLRedirections;
import com.Utility.BaseDriver;

public class MyWay_LockIcon_SafeSites extends BaseDriver{

	SLURLRedirections SLurl = new SLURLRedirections();
	SafelistObjects safelist = new SafelistObjects();
	
	//priority 13
	
	@Test(priority=13)
	public void SafeList_MyWay_HomePage() throws Exception
	{
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println("----------------- "+name+" -----------------");
		driver.get(SLurl.myWayURL);
		safelist.SafeListChromeWebRedirection();
	}
}
