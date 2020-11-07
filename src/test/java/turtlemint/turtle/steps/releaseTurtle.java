package turtlemint.turtle.steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class releaseTurtle {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/user/Public/Selenium/ChromeDriver/chromedriver");
		WebDriver driver = new ChromeDriver();
		Actions act = new Actions(driver);
		WebElement insuredm1, self;
		driver.get("https://flash.planturtle.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='tab-cta tab-flex']/a[@class='quote-cta'][3]")).click();
		driver.findElement(By.xpath("//div[@data-url='buy-new-policy']")).click();
		driver.findElement(By.xpath("//label[@data-auto='male']")).click();
		insuredm1=driver.findElement(By.xpath("//input[@data-auto='insured-self']"));
		act.moveToElement(insuredm1).click().build().perform();
		driver.findElement(By.xpath("//div[@data-auto='Next']")).click();
		//select age--->
		driver.findElement(By.id("self")).click();
		driver.findElement(By.xpath("//input[@data-auto='searchage']")).sendKeys("26");
		self = driver.findElement(By.xpath("//a[@tabindex='-1']"));
		self.click();
		driver.findElement(By.xpath("//div[@data-auto='Next']")).click();
		driver.findElement(By.xpath("//div[@data-auto='Next']")).click();
		//enter pin code--->
		driver.findElement(By.xpath("//input[@data-auto='pincode']")).sendKeys("400709");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@data-auto='Next']")).click();
		driver.findElement(By.xpath("//div[@data-auto='Next']")).click();
		driver.findElement(By.xpath("//div[@data-auto='Next']")).click();
		driver.findElement(By.xpath("//div[@data-auto='Next']")).click();

	}

}
