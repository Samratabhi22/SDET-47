package com.GenericLibrary;



import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mysql.cj.jdbc.Driver;

public class WebDriverUtility
{
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
		
	}
	
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
	}
	
	public void elementTObeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));		
	}
	
	public void select(WebElement element, String value)
	{
		Select sel =new Select(element);
		sel.selectByValue(value);
	}
	
	public void select(WebElement element, int index)
	{
		Select sel =new Select(element);
		sel.selectByIndex(index);
	}
	
	public void select(String visibleText, WebElement element)
	{
		Select sel =new Select(element);
		sel.selectByVisibleText(visibleText);
	}
	
	public void mousehover(WebDriver driver, WebElement element)
	{
		Actions act =new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void dragAnddrop(WebDriver driver, WebElement src, WebElement dest)
	{
		Actions act =new Actions(driver);
		act.dragAndDrop(src, dest).perform();
		
	}
	
	public void doubleClickAction(WebDriver driver)
	{
		Actions act =new Actions(driver);
		act.doubleClick().perform();	
	}
	
	public void rightClick(WebDriver driver)
	{
		Actions act =new Actions(driver);
		act.contextClick().perform();
	}
	
	public void enterKeyPress(WebDriver driver)
	{
		Actions act =new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	
	public void enterKey(WebDriver driver) throws Throwable
	{
		Robot r =new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
	}
	
	public void enterRelease(WebDriver driver) throws Throwable
	{
		Robot r =new Robot();
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void switchToFrame(WebDriver driver, String nameOrID)
	{
		driver.switchTo().frame(nameOrID);
	}
	
	public void switchToFrame(WebDriver driver, WebElement address)
	{
		driver.switchTo().frame(address);
	}
	
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
		
	}
	
	public void switchToFrame(WebDriver driver, int indexNum)
	{
		driver.switchTo().frame(indexNum);
	}
	
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	public void switchToWindow(WebDriver driver, String partialTitle)
	{
		//step1: use getWindowHandles to capture all window id's
		Set<String> windows =driver.getWindowHandles();
		
		//step2: iterate through the windows
		Iterator<String> it =windows.iterator();
		
		//step3: check whether there is next window
		while(it.hasNext())
		{
			//step4: capture current window id
			String winId =it.next();
			
			//step5: switch to current window and capture title
		    String currentWinTiltle =driver.switchTo().window(winId).getTitle();
		    
		    //step6: check whether current window is expected
		    if(currentWinTiltle.contains(partialTitle))
		    {
		    	break;
		    }
		}
	}
	
	
	public static String getScreenShot(WebDriver driver, String ScreenShotName) throws Throwable
	{
		TakesScreenshot ts =(TakesScreenshot) driver;
		File src =ts.getScreenshotAs(OutputType.FILE);
		String path =".\\screenshot\\"+ScreenShotName+".png";
		File dest =new File(path);
		FileUtils.copyFile(src, dest);
		return path;
		
	}
	
	public void scrollBarAction(WebDriver driver)
	{
		JavascriptExecutor jse =(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,800)", "");
	}
	
	public void scrollAction(WebDriver driver, WebElement element)
	{
		JavascriptExecutor jse =(JavascriptExecutor) driver;
		int y=element.getLocation().getY();
		jse.executeScript("window.scrollBy(0,"+y+")", element);
	}	
	
	public void navigateBack(WebDriver driver)
	{
		driver.navigate().back();
	}
}
