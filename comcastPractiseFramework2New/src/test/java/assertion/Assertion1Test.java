package assertion;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.samplelogin.LoginPage;

public class Assertion1Test {
	@Test
	public void homePageTest(Method mtd) throws Exception
	{
		
	    System.out.println(mtd.getName()+"Test STARTS");
		String expectedTitle="Home";
	    FileUtility fLib= new FileUtility();
	    WebDriverUtility wLib =new WebDriverUtility();
	    
	    WebDriver d=new ChromeDriver();
	   
	    String URL=fLib.readDataFromProperties("Url");
	    wLib.waitForPageToLoad(d);
	    d.get(URL);
	    String USERNAME = fLib.readDataFromProperties("Username");
		String PASSWORD = fLib.readDataFromProperties("Password");
	    LoginPage lp = new LoginPage(d);
	    lp.loginToApp(USERNAME, PASSWORD);
	    
	    String actTitle=d.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
	    //Hard Assert
	    Assert.assertEquals(actTitle, expectedTitle);
	   
	    Thread.sleep(3000);
		Actions a = new Actions(d);
		a.moveToElement(d.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		d.findElement(By.xpath("//a[text()='Sign Out']")).click();
		d.close();
		System.out.println(mtd.getName()+"Test ENDS");
	    
	}
	@Test
	public void homeLogoTest(Method mtd) throws Exception
	{
		System.out.println(mtd.getName()+"Test STARTS");
		
	    FileUtility fLib= new FileUtility();
	    WebDriverUtility wLib =new WebDriverUtility();
	    
	    WebDriver d=new ChromeDriver();
	   
	    String URL=fLib.readDataFromProperties("Url");
	    wLib.waitForPageToLoad(d);
	    d.get(URL);
	    String USERNAME = fLib.readDataFromProperties("Username");
		String PASSWORD = fLib.readDataFromProperties("Password");
	    LoginPage lp = new LoginPage(d);
	    lp.loginToApp(USERNAME, PASSWORD);
	    
	    boolean status=d.findElement(By.xpath("//img[@src='test/logo/vtiger-crm-logo.gif']")).isDisplayed();
	    
	   //Hard Assert
	    Assert.assertTrue(status);
	    	
	    Thread.sleep(3000);
		Actions a = new Actions(d);
		a.moveToElement(d.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		d.findElement(By.xpath("//a[text()='Sign Out']")).click();
		d.close();
		System.out.println(mtd.getName()+"Test ENDS");
		
	}

}
