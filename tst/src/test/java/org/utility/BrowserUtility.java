package org.utility;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.os.WindowsUtils;

public class BrowserUtility {
	private static Logger Log = Logger.getLogger(Logger.class.getName());
	private WebDriver driver = null;
	public String browserName = "";
	public BrowserUtility(String brwName, String url) 
	{
		browserName = brwName;
//		System.out.println("------------------------------------");
//		System.out.println("Open URL : " + url);
		
		switch (brwName.toString().toUpperCase()) {
		case "CHROME":
			System.setProperty("webdriver.chrome.driver", "lib\\chromedriver.exe");
			driver = new ChromeDriver();
			Log.info("Chrome Browser Instantiated");
			driver.get(url);
			Log.info("Open URL : " + url);
			break;
		case "IEXPLORE":
			System.setProperty("webdriver.ie.driver", "lib\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.get("http://localhost:8888");
			Log.info("IE Browser Instantiated");
			driver.get(url);
			Log.info("Open URL : " + url);
			break;
		case "MOZILLA":
			driver = new FirefoxDriver();
		default:
			driver =null;
			System.out.println("Browser name does not exist");
			Log.warn("Browser name does not exist");
			break;
		}
		
	}
	public BrowserUtility(String brwName) 
	{
		browserName = brwName;
		switch (brwName.toString().toUpperCase()) {
		case "CHROME":
			System.setProperty("webdriver.chrome.driver", "lib\\chromedriver.exe");
			driver = new ChromeDriver();
			Log.info("Chrome Browser Instantiated");
			break;
		case "IEXPLORE":
			System.setProperty("webdriver.ie.driver", "lib\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.get("http://localhost:8888");
			Log.info("IE Browser Instantiated");
			//driver.get(url);
			//Log.info("Open URL : " + url);
			break;
		case "MOZILLA":
			driver = new FirefoxDriver();
		default:
			driver =null;
			System.out.println("Browser name does not exist");
			Log.warn("Browser name does not exist");
			break;
		}
		
	}
	
	public void openUrl(String url)
	{
		Log.info("Open URL function called ");
		driver.get(url);
		Log.info("Open URL : " + url);
	}
	public void closeBrowser() {
		Log.info("Close Browser function called");
		driver.quit();
		
		switch (browserName.toString().toUpperCase()) 
		{
		case "CHROME":
			WindowsUtils.killByName("chrome.exe");
			Log.info("Killed chrome.exe");
			break;
		case "IEXPLORE":
			WindowsUtils.killByName("iexplore.exe");
			Log.info("Killed iexplore.exe");
			break;
		default:
			break;
		}
	}
	public boolean getDriverStatus() {
		Log.info("getDriverStatus function is called");
		if(driver != null) {
			Log.info("Driver is instantiated");
			return true;
		}
		else {
			Log.warn("Driver is not instantiated");
			return false;
		}
	}
	public WebDriver getDriver() {
		return (driver);
	}
	
	
}
