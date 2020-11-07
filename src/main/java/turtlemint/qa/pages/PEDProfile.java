package turtlemint.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import turtlemint.qa.base.TestBase;
import turtlemint.qa.utility.CommanFuntion;

public class PEDProfile extends TestBase {
	protected static WebDriver driver=TestBase.driver;
	protected static Actions act;
	
	public void init() throws IOException {
		initialization();
	}
	
	
//	driver.findElement(By.xpath("//a[@data-auto='health-vertical-tab']")).click();
//	
//	
//	driver.findElement(By.xpath("//span/child::a[@data-auto='health-vertical-tab']")).click();
//	driver.findElement(By.xpath("//div[@data-auto='buyNewPolicy']")).click();
//
//	driver.findElement(By.xpath("//label[@data-auto='male']")).click();
//	WebElement insuredm1=driver.findElement(By.xpath("//input[@data-auto='insured-self']"));
//	
//	
//	act.moveToElement(insuredm1).click().build().perform();
//	driver.findElement(By.xpath("//div[@data-auto='Next']")).click();
//	
//	//Select age--->
//	driver.findElement(By.id("self")).click();
//	driver.findElement(By.xpath("//input[@data-auto='searchage-self']")).sendKeys("26");
//	WebElement self = driver.findElement(By.xpath("//a[@tabindex='-1']"));
//	self.click();
//	driver.findElement(By.xpath("//div[@data-auto='Next']")).click();
//	driver.findElement(By.xpath("//label[@id='preDiseaseStatusYesLabel']")).click();

	
	private static void diseaseSelectSelf(WebDriver driver) {
		WebElement PED = driver.findElement(By.xpath("//button[@id='selectDisease-self']"));
		act.moveToElement(PED).click().build().perform();
		WebElement PED1 = driver.findElement(By.xpath("//input[@data-auto='self_Heart diseases']"));
		act.moveToElement(PED1).click().build().perform();
		driver.findElement(By.id("Next")).click();
		
	}
	//enter pin code--->
	
	void enterPincode(WebDriver driver) throws InterruptedException{
		driver.findElement(By.xpath("//input[@data-auto='pincode']")).sendKeys("400709");
		Thread.sleep(1000);
		CommanFuntion.expclick(driver, driver.findElement(By.xpath("//div[@data-auto='Next']")), 5); 
		
		//skip 3 slides--->
		CommanFuntion.expclick(driver, driver.findElement(By.xpath("//div[@data-auto='Next']")), 5);
		CommanFuntion.expclick(driver, driver.findElement(By.xpath("//div[@data-auto='Next']")), 5);
		Thread.sleep(500);
	}
	

}

	

