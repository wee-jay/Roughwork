package turtlemint.turtle.steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class feautomationlocaltesting {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/user/Public/Selenium/ChromeDriver/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions act = new Actions(driver);
		WebElement a, insuredm1, self, stitle, stitle1 = null;
		driver.get("https://www.turtlemint.com/");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.findElement(By.xpath("//div[@class='tab-cta tab-flex']/a[@class='quote-cta'][3]")).click();
		driver.findElement(By.xpath("//div[@data-url='buy-new-policy']")).click();
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
		Thread.sleep(2000);
		a = driver.findElement(By.id("CTA_CTPHPS"));
		act.moveToElement(a);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CTA_CTPHPS']")));
		wait.until(ExpectedConditions.elementToBeClickable(a));
		Thread.sleep(2000);
		a.click();
		driver.findElement(By.xpath("//div[@class='flex']/button")).click();
		
		//Filling of checkout form
		
		//	Contact Details
		driver.findElement(By.xpath("//input[@data-auto='proposer.mobile']")).sendKeys("7021231904");
		driver.findElement(By.xpath("//input[@data-auto='proposer.email']")).sendKeys("vijay.b@turtlemint.com");
		driver.findElement(By.xpath("//button[@data-auto='Continue']")).click();
		
		// Insurer Details
		
		js.executeScript("window.scrollBy(0,-1450)", "");
		
		
		stitle = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='tabs hidden-xs ng-scope']")));
		stitle.click();
		a= driver.findElement(By.xpath("//div[@data-auto='select proposer']"));
		a.getLocation();
		a.click();
		
	
		// driver.findElement(By.xpath("//span[@class='ui-select-choices-row-inner']")).click();
		stitle1 = driver.findElement(By.xpath("//li[@id='ui-select-choices-4']"));
		stitle1.click();

	}

}
