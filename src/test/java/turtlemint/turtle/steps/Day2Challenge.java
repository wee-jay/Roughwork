package seleniumChallanges;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Day2Challenge {

	
	private static WebDriver driver;
	private static Actions act;
	
	
	public static void main(String[] args) {
		String URL = "https://www.noon.com/uae-en/";
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		
		String carousel1="Recommended For You";
		String carousel2="Top picks in laptops";
		String carousel3="Top deals in mobiles";
		
		try {
			printAllProducts(carousel1);
			printAllProducts(carousel2);
			printAllProducts(carousel3);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.quit();
		
	}
	
	
/*
 * 	      Method to do the entire job. 
 *  	  Right from reaching to Carousel, waiting for all elements to load and then printing each products present in list.
 */
	public static void printAllProducts(String carousel) throws InterruptedException
	{
		System.out.println("\n------------------------------Here are the products for "+carousel+"-------------------------------");
		act = new Actions(driver);
		
		List <WebElement> products;
		WebElement carouselScroller;
		if(carousel=="" || carousel==null)
		{
			System.out.println("Kindly enter valid carousel name.");
		}
		
		else
		{
			String productsListPath = "//h3[contains(text(),'"+carousel+"')]/"
					+ "parent::div/parent::div/parent::div/div/div/div/div/div/a/div/div/div[@data-qa='product-name']";
			String carouselPath ="//h3[contains(text(),'"+carousel+"')]/"
					+ "parent::div/parent::div/parent::div/div/div[contains(@class,'swiper-button-next')]";
		
/*
 * 			Running loop to keep scrolling the page till the elements for Carousel gets loaded in DOM.
 */
			while(driver.findElements(By.xpath(productsListPath)).size()==0)
			{
				act.sendKeys(Keys.PAGE_DOWN);
				act.perform();
			}
			
			products = driver.findElements(By.xpath(productsListPath));		
			carouselScroller = driver.findElement(By.xpath(carouselPath));
			
//			Scroll to Carousel right arrow.
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", carouselScroller);
			
/*
 * 			Start the iteration for provided Carousel.
 */
			int counter=0;
			for(WebElement elem : products)
			{
				if (counter<7)
				{
					try {
				        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", elem);
					}
					
					catch(Exception StaleElementReferenceException)
					{
						System.out.println("Caught this exception while scrolling to element -> " + StaleElementReferenceException.getMessage());
					}

/*
 * 			Received blank value so re-attempting with thread sleep method and again scrolling into that element view
 */
					if(elem.getText().equals(""))
					{
						Thread.sleep(500);
						((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", elem);						System.out.print(elem.getAttribute("textContent")+", ");	
					}
					else
					{
						System.out.print(elem.getAttribute("textContent"));
						System.out.print(", ");
						counter++;
					}
				}
				
/*
 *          Clicking on right arrow of Carousel after printing 7 products
 *          when it is displayed and is in enabled mode.
 */			
				else
				{
					if(carouselScroller.isDisplayed() && carouselScroller.isEnabled())
					{
						try 
						{
							((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", carouselScroller);
							Thread.sleep(500);
							carouselScroller.click();
						}
						catch (Exception ElementClickInterceptedException)
						{
							System.out.println("Exception occurred so scrolling down to click Carousel right arrow.");
							act.sendKeys(Keys.PAGE_DOWN);
							act.perform();
							Thread.sleep(500);
							carouselScroller.click();
						}
						counter=0;
					}
				}
				
			}
		}

	}
	
}
 