package com.Naukri.POMPackage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.Utilities;

public class LogIn {

	private WebDriver driver;

	public LogIn(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Login']")
	private WebElement logInTextButton;
	@FindBy(xpath = "//input[@placeholder='Enter your active Email ID / Username']")
	private WebElement userNameField;
	@FindBy(xpath = "//input[@placeholder='Enter your password']")
	private WebElement passwordField;
	@FindBy(xpath = "//button[text()='Login']")
	private WebElement logInButton;
	@FindBy(xpath = "//div[contains(@class,'nI-gNb-drawer')][2]")
	private WebElement menuButton;
	@FindBy(xpath = "//a[text()='View & Update Profile']")
	private WebElement viewAndUpdateProfileText;
	@FindBy(xpath = "//div[contains(text(),'3 year experience as Software Test Engineer')]")
	private WebElement resumeHeadlineField;
	@FindBy(xpath = "//input[@value='Update resume']")
	private WebElement updateResumeButton;

	public void clickLogInTextButton() {
		logInTextButton.click();
	}

	public void enterUserName() {
		userNameField.clear();
		userNameField.sendKeys("anadhav1993@gmail.com");
	}

	public void enterPassword() {
		passwordField.clear();
		passwordField.sendKeys("Cubpa2677n");
	}

	public void clickLogInButton() {
		logInButton.click();
	}

	public void clickMenuButton() {
		menuButton.click();
	}

	public void clickViewAndUpdateProfileText() {
		Utilities.clickAnElement(viewAndUpdateProfileText);
		// viewAndUpdateProfileText.click();
	}

	public void enterTextInResumeHeadlineField1() {
		Utilities.scrollUpToElement(resumeHeadlineField);
		resumeHeadlineField.clear();
		resumeHeadlineField.sendKeys(
				"3 year experience as Software Test Engineer using Selenium, Java, Test-NG, Maven, POM. Manual testing, Functional, Sanity, Smoke, Regression. API with Postman. Database with Mysql. Hands-on exp in JIRA, Github, Jenkins. Knowledge in BDD, Rest assured");
	}

	public void enterTextInResumeHeadlineField2() {

		if (resumeHeadlineField.isDisplayed() != true) {
			Utilities.scrollUpToElement(resumeHeadlineField);
		} else {
			resumeHeadlineField.clear();
			resumeHeadlineField.sendKeys(
					"3 year experience as Software Test Engineer using Selenium, Java, Test-NG, Maven, POM. Manual testing, Functional, Sanity, Smoke, Regression. API with Postman. Database with Mysql. Hands-on exp in JIRA, Github, Jenkins. Knowledge in BDD, Rest Assured");
		}

	}

	public void clickUpdateResumeButton() {
		updateResumeButton.click();

		String filePath = System.getProperty("user.dir") + File.separator + "testData" + File.separator + "Resume.pdf";
		updateResumeButton.sendKeys(filePath);
	}

	public void uploadResume() throws AWTException {
		StringSelection filepath = new StringSelection(System.getProperty("user.dir") + File.separator + "testData" + File.separator + "Resume.pdf");

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		
		System.out.println("File Copied");

		Robot rb = new Robot();
		rb.delay(2000);

		
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		System.out.println("Press v");

		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		System.out.println("release v");
		rb.delay(2000);

		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		System.out.println("enter done");
		rb.delay(2000);
	}
	
	

}
