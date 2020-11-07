package turtlemint.turtle.steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.ScrollAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.interactions.Actions;

public class Turtlemintt {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/user/Public/Selenium/ChromeDriver/chromedriver");
		WebDriver driver = new ChromeDriver();
		
//		 WebDriverManager.chromedriver().setup();
//	        WebDriver driver = new ChromeDriver();
	        
		Actions act = new Actions(driver);
		WebElement a, insuredm1, self, stitle, stitle1 = null;
//		driver.get("https://www.turtlemint.com");
		driver.get("https://app.ronan.stage.mintpro.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 20);

		//FOR PROD
//		driver.findElement(By.xpath("//div[@class='tab-cta tab-flex']/a[@class='quote-cta'][3]")).click();
//		driver.findElement(By.xpath("//div[@data-url='buy-new-policy']")).click();
		
		//FOR STAGE
		Thread.sleep(2000);
//		driver.findElement(By.xpath("//a[@data-auto='health-vertical-tab']")).click();
//		driver.findElement(By.xpath("//div[@data-auto='buyNewPolicy']")).click();
		
		
		driver.findElement(By.xpath("//label[@data-auto='male']")).click();
		insuredm1=driver.findElement(By.xpath("//input[@data-auto='insured-self']"));
		act.moveToElement(insuredm1).click().build().perform();
		driver.findElement(By.xpath("//div[@data-auto='Next']")).click();
		//select age--->
		driver.findElement(By.id("self")).click();
		driver.findElement(By.xpath("//input[@data-auto='searchage-self']")).sendKeys("26");
		self = driver.findElement(By.xpath("//a[@tabindex='-1']"));
		self.click();
		driver.findElement(By.xpath("//div[@data-auto='Next']")).click();
		driver.findElement(By.xpath("//div[@data-auto='Next']")).click();
		//enter pin code--->
		driver.findElement(By.xpath("//input[@data-auto='pincode']")).sendKeys("400709");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@data-auto='Next']")).click();
		//skip 3 slides--->
		driver.findElement(By.xpath("//div[@data-auto='Next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@data-auto='Next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@data-auto='Next']")).click();
		Thread.sleep(2000);
		//Results page--->
		driver.findElement(By.xpath("//button[@data-auto='close-tour-popup']")).click();;
		
		//Select CIGNA insurer ProHealth Plus Plan
		driver.findElement(By.xpath("//div//following::button[@data-auto='CTA_CTPHPS']")).click();
		driver.findElement(By.xpath("//div[@class='flex']/button")).click();
		
	// Filling of checkout form
		
		//	Contact Details
		driver.findElement(By.xpath("//input[@data-auto='proposer.mobile']")).sendKeys("7021231904");
		driver.findElement(By.xpath("//input[@data-auto='proposer.email']")).sendKeys("vijay.b@turtlemint.com");
		driver.findElement(By.xpath("//button[@data-auto='Continue']")).click();
		
		// Insured Details
		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,-1450)", "");
		
		
//		stitle = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-auto='select proposer']//child::span[@tabindex='-1']//child::span//following-sibling::i")));
//		stitle.click();
//		driver.findElement(By.xpath("//span[@class='ui-select-choices-row-inner']")).click();
//		stitle1 = driver.findElement(By.xpath("//div[@id='ui-select-choices-row-0-0']"));
//		stitle1.click();

		//Self marital status
		WebElement selfms = driver.findElement(By.xpath("//div[@data-auto='insuredmembers.0.maritalstatus-uiSelect']"));
		act.moveToElement(selfms).perform();
		act.moveToElement(selfms).click().build().perform();
		WebElement selfms1 = driver.findElement(By.xpath("//div[@id='ui-select-choices-row-2-1']"));
		act.moveToElement(selfms1).click().build().perform();
		
		driver.findElement(By.xpath("//input[@data-auto='insuredMembers.0.fname']")).sendKeys("InsuredFNAME");
		driver.findElement(By.xpath("//input[@data-auto='insuredMembers.0.lname']")).sendKeys("InsuredLNAME");
		driver.findElement(By.xpath("//input[@data-auto='insuredMembers.0.height_feet']")).sendKeys("5");
		driver.findElement(By.xpath("//input[@data-auto='insuredMembers.0.height_inches']")).sendKeys("7");
		driver.findElement(By.xpath("//input[@data-auto='insuredmembers.0.weight']")).sendKeys("63");
		
		// Select Self title
		WebElement selfp2 = driver.findElement(By.xpath("//div[@data-auto='insuredmembers.0.title-uiSelect']"));
		act.moveToElement(selfp2).perform();
		act.moveToElement(selfp2).click().build().perform();
		WebElement selfp3 = driver.findElement(By.xpath("//li[@id='ui-select-choices-1']"));
		act.moveToElement(selfp3).click().build().perform();
		
		// Select proposer type
		WebElement selfp = driver.findElement(By.xpath("//div[@data-auto='select proposer']"));
		act.moveToElement(selfp).perform();
		act.moveToElement(selfp).click().perform();
		WebElement selfp1 = driver.findElement(By.xpath("//div[@id='ui-select-choices-row-0-0']"));
		act.moveToElement(selfp1).click().build().perform();
		
		driver.findElement(By.xpath("//input[@data-auto='proposer.nomineeFName']")).sendKeys("NomineeFname");
		driver.findElement(By.xpath("//input[@data-auto='proposer.nomineeLName']")).sendKeys("NomineeLname");
		
		// Nominee relationship
		WebElement element= driver.findElement(By.xpath("//div[@data-auto='relationship']"));
		act.moveToElement(element).perform();
		act.moveToElement(element).click().perform();
		WebElement element1=driver.findElement(By.xpath("//div[@id='ui-select-choices-row-4-4']"));
		act.moveToElement(element1).click().build().perform();
		
		// Nominee title
		WebElement nomineet = driver.findElement(By.xpath("//div[@data-auto='proposer.nomineetitle-uiSelect']"));
		act.moveToElement(nomineet).perform();
		act.moveToElement(nomineet).click().build().perform();
		WebElement nomineet1 = driver.findElement(By.xpath("//div[@id='ui-select-choices-row-3-2']"));
		act.moveToElement(nomineet1).click().build().perform();
		driver.findElement(By.xpath("//button[@data-auto='Continue']")).click();
		
		// Medical History
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[@data-auto='Continue']")).click();
		
		// Mailing Address
		driver.findElement(By.xpath("//input[@data-auto='addrLine1']")).sendKeys("Airport road");
		driver.findElement(By.xpath("//input[@data-auto='addrLine2']")).sendKeys("Andheri");
		driver.findElement(By.xpath("//button[@data-auto='Continue']")).click();
		
		// 

		
	}

}
