package turtlemint.turtle.steps;

import org.testng.annotations.Test;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import java.util.ArrayList;
import org.bson.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;

public class NewTestdummy {
  
	WebDriver driver;
	MongoCollection<Document> doc;
	
	
	
	@BeforeSuite
	public void beforeSuite() {
		@SuppressWarnings("resource")
		MongoClient mc = new MongoClient("localhost:27017");
		MongoDatabase db = mc.getDatabase("Dumping");
		db.createCollection("Sampletest");
		doc = db.getCollection("Sampletest");
	}
  
  
	@BeforeTest
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
  
	}
  
  
	@Test

	public void f() {
		driver.get("https://www.amazon.com/");
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		int linkcount = driver.findElements(By.xpath("//a")).size();
		Document d1 = new Document();
		d1.append("URL", url);
		d1.append("Page Title", title);
		d1.append("Total hyperlinks", linkcount);
		ArrayList<Document> ar = new ArrayList<Document>();
		ar.add(d1);
		doc.insertMany(ar);
		
	}
  
  
	@AfterTest
  
	public void afterTest() {
		driver.quit();
	}

  
  
	@AfterSuite
  
	public void afterSuite() {
  
	}

	
}
