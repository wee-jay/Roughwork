import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Webscraping1 {
	
	MongoCollection<Document> Doc;
	MongoClient mongoo;
	private WebDriver driver;
	
	@BeforeSuite
	public void connectmongo()
	{
		mongoo = new MongoClient("mongodb://localhost:27017");
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

	@org.testng.annotations.Test
	public void scraping()
	{
		driver.get("https://www.amazon.com");
		String url = driver.getCurrentUrl();
		String pageTitle = driver.getTitle();
		Document d1 = new Document();
		d1.append("URL", url);
		d1.append("Page Title", pageTitle);
		
		List<Document> ar = new ArrayList<Document>();
		ar.add(d1);
		
		Doc.insertMany(ar);
	}
	
	@AfterTest
	public void packup()
	{
		driver.quit();
		mongoo.close();
	}
}
