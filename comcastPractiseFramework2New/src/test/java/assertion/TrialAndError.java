package assertion;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.FileUtility;

public class TrialAndError {
	@Test
	public void testCase() throws Exception

	{
		
	FileUtility fLib= new FileUtility();
	String BROWSER = fLib.readDataFromProperties("Browser");
	WebDriver d;
	String brow = BROWSER;
	if (brow.equals("Chrome")) {
		d = new EdgeDriver();
	} else if (brow.equals("Edge")) {
		d = new EdgeDriver();
	} else {
		d = new FirefoxDriver();
	}
	
			
	
		
		
		
	}

}
