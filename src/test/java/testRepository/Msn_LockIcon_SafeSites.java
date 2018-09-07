package testRepository;

import org.testng.annotations.Test;

import com.Objects.SafelistObjects;
import com.Pages.SLURLRedirections;
import com.Utility.BaseDriver;

public class Msn_LockIcon_SafeSites extends BaseDriver{

	SLURLRedirections SLurl = new SLURLRedirections();
	SafelistObjects safelist = new SafelistObjects();
	
	//priority 16-27
	
	@Test(priority=16)
	public void SafeList_Msn_HomePage() throws Exception
	{
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println("----------------- "+name+" -----------------");
		driver.get(SLurl.msnURL);
		safelist.SafeListChromeWebRedirection_For_MSN();
	}
	
	@Test(priority=17)
	public void SafeList_Msn_Weather() throws Exception
	{
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println("----------------- "+name+" -----------------");
		driver.get(SLurl.msnWeatherURL);
		safelist.SafeListChromeWebRedirection_For_MSN();
	}
	
	@Test(priority=18)
	public void SafeList_Msn_News() throws Exception
	{
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println("----------------- "+name+" -----------------");
		driver.get(SLurl.msnNewsURL);
		safelist.SafeListChromeWebRedirection_For_MSN();
	}
	
	@Test(priority=19)
	public void SafeList_Msn_Entertainment() throws Exception
	{
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println("----------------- "+name+" -----------------");
		driver.get(SLurl.msnEntertainmentURL);
		safelist.SafeListChromeWebRedirection_For_MSN();
	}
	
	@Test(priority=20)
	public void SafeList_Msn_Sports() throws Exception
	{
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println("----------------- "+name+" -----------------");
		driver.get(SLurl.msnSportsURL);
		safelist.SafeListChromeWebRedirection_For_MSN();
	}
	
	@Test(priority=21)
	public void SafeList_Msn_Money() throws Exception
	{
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println("----------------- "+name+" -----------------");
		driver.get(SLurl.msnMoneysURL);
		safelist.SafeListChromeWebRedirection_For_MSN();
	}
	
	@Test(priority=22)
	public void SafeList_Msn_LifeStyle() throws Exception
	{
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println("----------------- "+name+" -----------------");
		driver.get(SLurl.msnLifestyleURL);
		safelist.SafeListChromeWebRedirection_For_MSN();
	}
	
	@Test(priority=23)
	public void SafeList_Msn_Health() throws Exception
	{
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println("----------------- "+name+" -----------------");
		driver.get(SLurl.msnHealthURL);
		safelist.SafeListChromeWebRedirection_For_MSN();
	}
	
	@Test(priority=24)
	public void SafeList_Msn_Food() throws Exception
	{
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println("----------------- "+name+" -----------------");
		driver.get(SLurl.msnFoodURL);
		safelist.SafeListChromeWebRedirection_For_MSN();
	}
	
	@Test(priority=25)
	public void SafeList_Msn_Travel() throws Exception
	{
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println("----------------- "+name+" -----------------");
		driver.get(SLurl.msnTravelURL);
		safelist.SafeListChromeWebRedirection_For_MSN();
	}
	
	@Test(priority=26)
	public void SafeList_Msn_Autos() throws Exception
	{
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println("----------------- "+name+" -----------------");
		driver.get(SLurl.msnAutosURL);
		safelist.SafeListChromeWebRedirection_For_MSN();
	}
	
	@Test(priority=27)
	public void SafeList_Msn_Videos() throws Exception
	{
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println("----------------- "+name+" -----------------");
		driver.get(SLurl.msnVideosURL);
		safelist.SafeListChromeWebRedirection_For_MSN();
	}

}