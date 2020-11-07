package com.vijay.jdk8related;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

// We can also declare test at class level.
@Test(groups={"Regression"})
public class TestNGDemo {
	
	WebDriver driver;
	
	public static int add(int a , int b)
	{
		return a+b;
	}
	
	public static int sub(int a , int b)
	{
		return a-b;
	}
	
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("This is Before Method implementation.");
	  ChromeOptions opt = new ChromeOptions();
	  opt.setHeadless(true);
	  opt.addArguments("--incognito");
	  System.setProperty("webdriver.chrome.driver", "/Users/user/Public/Selenium/ChromeDriver/chromedriver");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
  }

  @Test(priority=1)
  public void test1() throws InterruptedException {
	  driver.get("https://app.turtlemint.com/life-insurance/complete-application/AG5RIDXHIW1");
	  Thread.sleep(3000);
	  System.out.println(add(10, 20));
	  assertTrue((add(10, 20))==30);
  }
  
  @Test(priority=2)
  public void test2() throws InterruptedException {
	  System.out.println(sub(5, 5));
	  driver.get("https://www.facebook.com");
	  Thread.sleep(3000);
  }
  
  @AfterMethod
  public void afterMethod() {
	  System.out.println("This is After Method implementation.");
	  driver.quit();
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("Inside before class...");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("Inside after class...");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Inside before test...");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Inside after test...");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("This is before suite...");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("This is after suite....");
  }

}
