package extendreporttest;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendReportSample {

	@Test
	public void createContactTest() {
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CONTACT result");
		spark.config().setReportName("CRM report");
		spark.config().setTheme(Theme.DARK);

		ExtentReports report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("Browser", "Chome-12");
		ExtentTest test = report.createTest("createContactTest");

		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "Navigate to contat page");
		test.log(Status.INFO, "Create contact");

		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "Contact is created");
		} else {
			test.log(Status.FAIL, "Contact is not created");
		}
		report.flush();
		//test.log(Status.INFO, "Login to application");

	}
}
