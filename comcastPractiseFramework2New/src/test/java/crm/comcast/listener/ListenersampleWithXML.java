package crm.comcast.listener;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.baseutility.Base;
import com.comcast.crm.baseutility.BaseClass;

public class ListenersampleWithXML extends BaseClass {
	@Test
	public void createContactTest()
	{
		System.out.println("Execute create contact test");
		String var = d.getTitle();
		Assert.assertEquals(var, "Home");
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		System.out.println("Step 4");
		
	}
	@Test
	public void createContactWithPhnoTest()
	{
		System.out.println("Execute create contact with phno  test");
		
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		System.out.println("Step 4");
	}
	

}
