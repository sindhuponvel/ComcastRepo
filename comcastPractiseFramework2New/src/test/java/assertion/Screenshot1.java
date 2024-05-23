package assertion;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class Screenshot1 {
	
	@Test
	public void takeScreenshot() throws IOException {
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		d.get("https://www.netflix.com/in/");
		EventFiringWebDriver edriver = new EventFiringWebDriver(d);
		File srcFile=edriver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("/comcastPractiseFramework/screenshot.test.png"));
	
		
		
	}

}
