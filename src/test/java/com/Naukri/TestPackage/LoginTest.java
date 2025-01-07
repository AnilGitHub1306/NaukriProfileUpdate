package com.Naukri.TestPackage;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.Naukri.BasePackage.BaseClass;
import com.Naukri.POMPackage.LogIn;

import utility.Utilities;

public class LoginTest extends BaseClass {
	
	@Test
	public void TC001_LoginWithValideCredentials() throws InterruptedException, AWTException {
		
		LogIn logInObj =  new LogIn(driver);
		logInObj.clickLogInTextButton();
		Thread.sleep(3000);
		logInObj.enterUserName();
		Thread.sleep(3000);
		logInObj.enterPassword();
		Thread.sleep(3000);
		logInObj.clickLogInButton();
		Thread.sleep(3000);
		logInObj.clickMenuButton();
		Thread.sleep(3000);
		logInObj.clickViewAndUpdateProfileText();
		Thread.sleep(3000);
		logInObj.clickUpdateResumeButton();
		logInObj.uploadResume();
	}
	

}
