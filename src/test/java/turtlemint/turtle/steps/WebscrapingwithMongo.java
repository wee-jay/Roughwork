package turtlemint.turtle.steps;

import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebscrapingwithMongo {

	MongoCollection<Document> Doc;
	
	WebDriver driver;
	
	@BeforeSuite
	public void connectmongo()
	{
		@SuppressWarnings("resource")
		MongoClient mongoo = new MongoClient("localhost:27017");
		MongoDatabase db = mongoo.getDatabase("Scraping");
		db.createCollection("Webscrapingdata");
		Doc = db.getCollection("Webscrapingdata");

	}
	
	@BeforeTest
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	}

	@Test
	public void scraping()
	{
		driver.get("https://www.flipkart.com");
		String url = driver.getCurrentUrl();
//		String pageTitle = driver.getTitle();
		int linkscount = driver.findElements(By.xpath("//a")).size();
		Document d1 = new Document();
		d1.append("URL", url);
		d1.append("Total Links", linkscount+1);
		List<Document> ar = new ArrayList<Document>();
		ar.add(d1);
		Doc.insertMany(ar);
		
	}
	
	@AfterTest
	public void packup()
	{
		driver.quit();
		
	}

}
