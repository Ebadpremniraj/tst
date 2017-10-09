package org.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.utility.BrowserUtility;
import org.utility.PropertiesUtility;
import org.utility.WebUtility;

public class LoginPage {
	WebDriver lpdriver;
	@FindBy(xpath="//img[@alt='My Account']")
	WebElement myAcclink;
	@FindBy(xpath="//a[@id='koovs_login_popup']")
	WebElement loginlnk;
	@FindBy(xpath="//input[@id='login_username_p']")
	WebElement txtuserName;
	@FindBy(xpath="//input[@id='login_password_p']")
	WebElement txtPsswd;
	@FindBy(xpath="//div/p[@id='login_text_login']")
	WebElement btnLogin;
	@FindBy(xpath="//a[@id='logOut'][contains(text(),'SIGN OUT')]")
	WebElement logOutlnk;
	
	public LoginPage(WebDriver driver) {
		this.lpdriver = driver;
		PageFactory.initElements(lpdriver,this);	
	}


	public boolean login(String usrName, String psswd){
		
		
		WebUtility webUtil = new WebUtility();
		Actions act = new Actions(lpdriver);
		Action movetoMyAcc = act.moveToElement(myAcclink).build();
		movetoMyAcc.perform();
		if(loginlnk.isDisplayed()){
			loginlnk.click();
			if(txtuserName.isDisplayed()){
				webUtil.webSetText(txtuserName, usrName);
				webUtil.webSetText(txtPsswd, psswd);
				webUtil.webBtnClick(btnLogin);
				WebDriverWait wait = new WebDriverWait(lpdriver, 10);
				wait.until(ExpectedConditions.presenceOfElementLocated((By) myAcclink));
				movetoMyAcc.perform();
				if(logOutlnk.isDisplayed()){
					return true;
				}
				else{
					return false;
				}
					
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
		
	}

}
