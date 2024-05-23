package com.comcast.crm.baseutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.databaseutility.DatabaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility1.LoginPage1;

public class BaseClass {

	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public DatabaseUtility dLib = new DatabaseUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public FileUtility fLib = new FileUtility();
	public WebDriver d;
	public static WebDriver sdriver;
	public ExtentReports report;
	public ExtentSparkReporter spark;

	@BeforeSuite
	public void configBS() throws Exception {
		System.out.println("Connect to db");
		dLib.getDBConnection();
	    

	}

	@BeforeClass
	public void configBC() throws Exception {
		System.out.println("Connect to browser");
		String BROWSER = fLib.readDataFromProperties("Browser");
		String brow = BROWSER;
		if (brow.equals("Chrome")) {
			d = new ChromeDriver();
		} else if (brow.equals("Edge")) {
			d = new EdgeDriver();
		} else {
			d = new FirefoxDriver();
		}
		sdriver = d;

	}

	@BeforeMethod
	public void configBM() throws Exception {
		d.manage().window().maximize();
		wLib.waitForPageToLoad(d);
		String URL = fLib.readDataFromProperties("Url");
		d.get(URL);
		LoginPage1 lp = new LoginPage1(d);
		String USERNAME = fLib.readDataFromProperties("Username");
		String PASSWORD = fLib.readDataFromProperties("Password");
		lp.loginToApp(USERNAME, PASSWORD);

	}
	
	@AfterMethod
	public void configAM()
	{
	 com.comcast.crm.objectrepositoryutility1.HomePage hp = new com.comcast.crm.objectrepositoryutility1.HomePage(d);
	 hp.signOut();
	}
	
	@AfterClass
	public void configAC()
	{
	System.out.println("Close the browser");
	d.quit();
	}
	
	@AfterSuite
	public void configAS() throws Exception {
		System.out.println("close db connection");
		dLib.closeDBConnection();
		report.flush();
	}
	
	
	
}
