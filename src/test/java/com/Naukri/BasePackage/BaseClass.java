package com.Naukri.BasePackage;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	@BeforeTest
	public void setUp() {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions"); // Disable extensions
		options.setAcceptInsecureCerts(true);
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--disable-notifications");
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.default_content_setting_values.notifications", 2); // 2 means block notifications
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--disable-features=IsolateOrigins,site-per-process");
		options.addArguments("--disable-ads"); // Although this does not guarantee complete ad blocking, it helps reduce
												// some ads
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.naukri.com/");
	}

//	@AfterTest
	public void tearDown() {
		if (driver != null) {
			driver.close();
		}

	}

}
