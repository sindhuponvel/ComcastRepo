package com.comcast.crm.listenertimeutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.baseutility.Base;
import com.comcast.crm.baseutility.BaseClass;

public class ListenerImpClass1 implements ITestListener,ISuiteListener {
	public static ExtentReports report;
	public ExtentSparkReporter spark;
	public static ExtentTest test;
	@Override
	public void onStart(ISuite suite) {
		System.out.println("Report configuration");
		spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CONTACT result");
		spark.config().setReportName("CRM report");
		spark.config().setTheme(Theme.DARK);

		 report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("Browser", "Chome-12");
		
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report backup");
		report.flush();
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("=======>"+result.getMethod().getMethodName()+"<======START=====");
		test=report.createTest(result.getMethod().getMethodName());
	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("=======>"+result.getMethod().getMethodName()+"<======END=====");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName=result.getMethod().getMethodName();
		
		String time = new Date().toString().replace(":","_").replace(" ","_");
		

		TakesScreenshot edriver= (TakesScreenshot)BaseClass.sdriver;
		String filePath=edriver.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(filePath,testName+"_"+time);
		
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	

}
