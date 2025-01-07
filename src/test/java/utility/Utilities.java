package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.Naukri.BasePackage.BaseClass;

public class Utilities extends BaseClass {

	public static JavascriptExecutor js;

	public static int returnDate() {

		Date d = new Date();
		String date = new SimpleDateFormat("HH").format(d);
		int num = Integer.parseInt(date);
		return num;
	}

	public static void scrollUpToElement(WebElement elementName) {

		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", elementName);

	}

	public static void scrollByPixle(WebElement elementName) {

		js = (JavascriptExecutor) driver;
		
		int a;
		 while(elementName.isDisplayed() == false) 
		 {
	        js.executeScript("window.scrollBy(0, 50)");
	        
		 }

	}

	public static void clickAnElement(WebElement elementName) {

		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", elementName);

	}

}
