package extendreporttest;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendReportScreenshotMain {
	public ExtentSparkReporter spark;
	public ExtentReports report;

	@BeforeSuite
	public void configBS() {
		spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CONTACT result");
		spark.config().setReportName("CRM report");
		spark.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("Browser", "Chome-12");

	}

	@AfterSuite
	public void configAS() {
		report.flush();
	}

	@Test
	public void createContactTest() {
		WebDriver d = new ChromeDriver();
		d.get("http://localhost:8888");
		
		TakesScreenshot edriver=(TakesScreenshot)d;
		String filePath=edriver.getScreenshotAs(OutputType.BASE64);

		ExtentTest test = report.createTest("createContactTest");

		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "Navigate to contat page");
		test.log(Status.INFO, "Create contact");

		if ("HDFC".equals("HDFCgh")) {
			test.log(Status.PASS, "Contact is created");
		} else {
			test.addScreenCaptureFromBase64String(filePath,"Errorfile");
		}

	}

}
