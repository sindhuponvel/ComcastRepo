package crm.comcast.listener;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.baseutility.Base;
import com.comcast.crm.baseutility.BaseClass;
//@Listeners(com.comcast.crm.listenertimeutility.ListenerImpClass1.class)
public class ListenerScreenshotWithTimeTest extends BaseClass{
	@Test
	public void createContactTest()
	{
		System.out.println("Execute create contact ");
		String var=d.getTitle();
		Assert.assertEquals(var, "Home");
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
	}
	
	@Test
	public void createContactWithPhnnoTest()
	{
		System.out.println("Execute create contact with Phone Number");
		
		
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
	}
	
	
	

}
