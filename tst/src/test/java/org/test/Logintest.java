package org.test;

import org.openqa.selenium.WebDriver;
import org.pom.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.utility.BrowserUtility;
import org.utility.PropertiesUtility;

public class Logintest {	
	
	WebDriver driver;
	
	@BeforeMethod
	public void bf(String browName){
		BrowserUtility browUtil = new BrowserUtility(browName,PropertiesUtility.getDataFromDataFile("URL"));
		driver = browUtil.getDriver();
	}
  
	
	@Test
  public void f(String usrName, String psswd) {
		LoginPage login = new LoginPage(driver);
		if(login.login(usrName, psswd)){
			
		}
	  
  }
	@AfterMethod
	public void af(){
		
	}
	
}
