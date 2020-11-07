package turtlemint.qa.utility;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Signup {
	public static WebDriver driver;

	
	public static String register()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/user/Public/Selenium/ChromeDriver/chromedriver");
		driver = new ChromeDriver();
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Vijay Bhangur");
		String mail = RandomStringUtils.random(8, true, true)+"@turtlemint.com";
		return mail;

	}
	
	public static void main (String[] args)
	{
		String email = Signup.register();
		System.out.println(email);
	}

}
