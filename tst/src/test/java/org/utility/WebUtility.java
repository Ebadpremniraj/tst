package org.utility;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebUtility {
	private static Logger Log = Logger.getLogger(Logger.class.getName());
	public void webBtnClick(WebElement we) {
		Log.info("Click on WebButton");
		we.click();
	}
	public void webSetText(WebElement we, String text) {
		Log.info("Set value: "+ text+" in text field");
		we.sendKeys(text);
	}
	public boolean iSDisplayed(WebElement elm) {
		Log.info("verify element is displayed");
		return(elm.isDisplayed());
	}
	public boolean objectExist(By objXpath, WebDriver driver)
	{
		Log.info("objectExist function called");
		WebElement appPage= null;
		try
		{
			appPage = driver.findElement(objXpath);
			WebUtility webUtility = new WebUtility();
			if (webUtility.iSDisplayed(appPage))
				
				return true;
			else
				return false;
		}
		catch (NoSuchElementException ex) 
		{
			ex.printStackTrace();
			Log.error(ex.getStackTrace());
			return false;
		}
			
	}

	
}
