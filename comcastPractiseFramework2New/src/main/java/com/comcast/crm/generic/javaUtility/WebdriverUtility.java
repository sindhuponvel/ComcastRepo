package com.comcast.crm.generic.javaUtility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility {
	
	public void waitForPageToLoad(WebDriver d)
	{
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void waitForElementPage(WebDriver d,WebElement element)
	{
	WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(20));
	wait.until(ExpectedConditions.visibilityOf(element));	
	}
	
	public void select(WebElement element,String text)
	{
		Select sel= new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public void select(WebElement element,int index)
	{
		Select sel= new Select(element);
		sel.selectByIndex(index);
	}
    
	public void windowBasedOnPartialUrl(WebDriver d,String partialUrl)
	{
		Set<String> set = d.getWindowHandles();
		Iterator<String> it= set.iterator();
		while(it.hasNext())
		{
			String windowID=it.next();
			d.switchTo().window(windowID);
			String actUrl= d.getCurrentUrl();
			if(actUrl.contains(partialUrl))
			{
				break;
			}
		}
		}
		public void windowBasedOnPartialTitle(WebDriver d,String partialTitle)
		{
			Set<String> set = d.getWindowHandles();
			Iterator<String> it= set.iterator();
			while(it.hasNext())
			{
				String windowID=it.next();
				d.switchTo().window(windowID);
				String actUrl= d.getTitle();
				if(actUrl.contains(partialTitle))
				{
					break;
				}
			}
		}
		
		
		public void switchToFrame(WebDriver d,String nameID)
		{
			d.switchTo().frame(nameID);
		}
		
		public void switchToFrame(WebDriver d,int index)
		{
			d.switchTo().frame(index);
		}
		
		public void switchToFrame(WebDriver d,WebElement element)
		{
			d.switchTo().frame(element);
		}
		
		public void moveToElement(WebDriver d, WebElement element)
		{
			Actions act = new Actions(d);
			act.moveToElement(element).perform();
		}
		
		public void contextClick(WebDriver d, WebElement element)
		{
			Actions act = new Actions(d);
			act.contextClick(element).perform();
		}
		
		public void doubleClick(WebDriver d, WebElement element)
		{
			Actions act = new Actions(d);
			act.doubleClick(element).perform();
		}
		
		
		public void dragAndDrop(WebDriver d,WebElement ele1, WebElement ele2)
		{
			Actions act = new Actions(d);
			act.dragAndDrop(ele1, ele2).perform();
		}
		
		
		
		

}