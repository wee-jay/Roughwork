package turtlemint.turtle.steps;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import turtlemint.qa.utility.CommanFuntion;
import turtlemint.qa.utility.connectmongodb;

public class testproposedeleteitlater {

	protected static MongoClient mongo;
	public static String Flashotp;
	static String serverip;
	protected static DB db;
	protected static DBCollection collection;
	public static String pedreqid;
	protected static DBObject req1;
	protected static WebDriver driver;
	public static String loginpageurl;
	public static void main(String[] args) throws IOException, InterruptedException 
	{
//		CommanFuntion.loadingconfig();
//		
//		System.setProperty("webdriver.chrome.driver", "/Users/user/Public/Selenium/ChromeDriver/chromedriver");
//		driver = new ChromeDriver();

//		driver.get(CommanFuntion.prop.getProperty("HDFCB2BURL"));
//		driver.manage().window().maximize();
//		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		
//		WebElement number = driver.findElement(By.xpath("//input[@name='mobileNumber']"));
//		number.sendKeys("7021231904");
//		driver.findElement(By.className("submitBtn")).click();
//		loginpageurl = driver.getCurrentUrl();
//		
//		connectmongodb.getotp(loginpageurl);
//		String otp = connectmongodb.Flashotp;
//		
//		driver.findElement(By.className("OTPInput")).sendKeys(otp);
//		CommanFuntion.expclick(driver, driver.findElement(By.className("submitBtn")), 20);
//		
//		CommanFuntion.expclick(driver, driver.findElement(By.xpath("//span[contains(text(),'Create a quote')]")), 10);
//		
//		Thread.sleep(2000);
//		CommanFuntion.expclick(driver, driver.findElement(By.xpath("//div[@value='HEALTH']/child::p")), 10);
//		
//		CommanFuntion.expclick(driver, driver.findElement(By.xpath("//span[contains(text(),'Buy new Policy')]")), 10);
//		driver.findElement(By.xpath("//span[contains(text(),'Suggest Plans')]")).click();;
//		
//		Thread.sleep(2000);
//		CommanFuntion.expclick(driver, driver.findElement(By.xpath("//label[@data-auto='male']/child::img/following::div/child::div")), 30);
//
//		String dealerId = driver.manage().getCookieNamed("pospUserName").getValue();
//		String dppermission = driver.manage().getCookieNamed("permission").getValue();
//		
//		
//		System.out.println("This is pospUserName : " + dealerId);
//		System.out.println("Your logged in parnter's permission is set to : " + dppermission);
		
		
		
		String loginpageurl = "https://ronan.getquote.bajajcapitalinsurance.com/health-insurance/results/AFRZSO1GCG0/self";
		String domain[]= loginpageurl.split("/");
		String server = domain[2].split("[.]")[1];
		String b2clink = domain[2].split("[.]")[1];
		String b2cdb1 = domain[2].split("[.]")[0];
		System.out.println( "one " +b2clink);
		System.out.println("two " +b2cdb1);
		System.out.println("This is second string: " + server);
		
		
	}

}
