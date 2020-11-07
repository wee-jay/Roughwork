package turtlemint.qa.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import turtlemint.qa.base.TestBase;

public class BrowserAction extends TestBase {

	WebDriver driver;
	
	static void click(By element, WebDriver driver) {
		
		driver.findElements(element);
	}
	
	
}
