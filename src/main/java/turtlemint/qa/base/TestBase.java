package turtlemint.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import turtlemint.qa.utility.CommanFuntion;

public class TestBase {
	
	public static WebDriver driver;
	static Properties prop;
	
	public static void initialization() throws IOException
	{
		FileInputStream ip=new FileInputStream("/Users/user/eclipse-workspace/turtle/src/main/java/turtlemint/qa/config/config.properties");
		Properties prop=new Properties();
		prop.load(ip);
		
		String browsers = prop.getProperty("browser");
		switch("browsers") {
		case "chrome":System.setProperty("webdriver.chrome.driver", "/Users/user/Public/Selenium/ChromeDriver/chromedriver");
					  driver = new ChromeDriver();
					  break;
		default:
			break;
		}
		
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get(prop.getProperty("RonanB2BHDFCurl"));
	
	}
	

}
