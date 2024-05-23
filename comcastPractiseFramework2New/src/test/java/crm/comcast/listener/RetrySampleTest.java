package crm.comcast.listener;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.baseutility.BaseClass;

public class RetrySampleTest extends BaseClass{
	@Test(retryAnalyzer = com.comcast.retryanalyserutility.RetryAnalyserImp.class)
	public void createContact()
	{
		System.out.println("Execute create contact test");
		String var = d.getTitle();
		Assert.assertEquals(var, "Home");
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		System.out.println("Step 4");
	}

}
