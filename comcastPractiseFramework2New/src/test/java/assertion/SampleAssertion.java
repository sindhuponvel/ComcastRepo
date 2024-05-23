package assertion;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.samplelogin.LoginPage;

public class SampleAssertion {
	@Test//hard assert
	public void homePageTest(Method mtd) throws Exception
	{
		
	    System.out.println(mtd.getName()+"Test STARTS");
		System.out.println("Step-1");
		System.out.println("Step-2");
		Assert.assertEquals("Home", "HomePage");
		System.out.println("Step-3");
		System.out.println("Step-4");
		Assert.assertEquals("Page", "Page");
		System.out.println(mtd.getName()+"Test ENDS");
	    
	}
	@Test
	public void homeLogoTest(Method mtd) throws Exception
	{
		System.out.println(mtd.getName()+"Test STARTS");
		System.out.println("Step-1");
		System.out.println("Step-2");
		Assert.assertTrue(true);
		System.out.println("Step-3");
		System.out.println("Step-4");
		Assert.assertTrue(false);
		System.out.println(mtd.getName()+"Test ENDS");
		
	}
	

}
