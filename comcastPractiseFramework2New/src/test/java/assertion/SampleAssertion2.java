package assertion;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Test
public class SampleAssertion2 {
	@Test//Soft Assert
	public void homePageTest(Method mtd) throws Exception
	{
		
		
	    System.out.println(mtd.getName()+"Test STARTS");
	    SoftAssert assertObj= new SoftAssert();
		System.out.println("Step-1");
		System.out.println("Step-2");
		assertObj.assertEquals("Home", "HomePage");
		System.out.println("Step-3");
		System.out.println("Step-4");
		assertObj.assertEquals("Page", "Page");
		assertObj.assertAll();
		System.out.println(mtd.getName()+"Test ENDS");
	    
	}
	@Test
	public void homeLogoTest(Method mtd) throws Exception
	{
		
		System.out.println(mtd.getName()+"Test STARTS");
		SoftAssert assertObj= new SoftAssert();
		System.out.println("Step-1");
		System.out.println("Step-2");
		assertObj.assertTrue(false);
		System.out.println("Step-3");
		System.out.println("Step-4");
		Assert.assertTrue(true);
		assertObj.assertAll();
		System.out.println(mtd.getName()+"Test ENDS");
		
	}

}
