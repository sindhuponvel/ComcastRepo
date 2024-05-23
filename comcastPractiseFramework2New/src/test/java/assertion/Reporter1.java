package assertion;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Reporter1 {
	@Test
	public void homePageTest(Method mtd) throws Exception
	{
		
		Reporter.log(mtd.getName()+"Test STARTS");
		Reporter.log("Step-1",true);
		Reporter.log("Step-2");
		//Assert.assertEquals("Home", "HomePage");
		Reporter.log("Step-3");
		Reporter.log("Step-4");
		//Assert.assertEquals("Page", "Page");
		Reporter.log(mtd.getName()+"Test ENDS");
	    
	}


}
