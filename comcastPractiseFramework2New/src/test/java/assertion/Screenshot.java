package assertion;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class Screenshot {
	@Test
	public void takeScreenshot() throws Exception
	{
		
		 WebDriver d= new ChromeDriver();
		 d.manage().window().maximize();
		 d.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 d.get("http://localhost:8888/");
		
		 //step - 1 : Create an object for EventFiring WebDriver
		 EventFiringWebDriver ed= new EventFiringWebDriver(d);
		 
		//Step 2 2: use getScreenshotAs() to get file type of screenshot
		 File srcFile=ed.getScreenshotAs(OutputType.FILE);
		 
		 //step 3  : Store on local driver
		 FileUtils.copyFile(srcFile, new File("/comcastPractiseFramework/Screenshot.test.png"));
		 
		
	}

}
