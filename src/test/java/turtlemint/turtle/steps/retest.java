package turtlemint.turtle.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class retest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/user/Public/Selenium/ChromeDriver/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.turtlemint.com/");
		driver.quit();
		
	}

}
