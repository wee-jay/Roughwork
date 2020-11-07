package turtlemint.qa.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Properties;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.mongodb.Cursor;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;


import turtlemint.qa.base.TestBase;

public class CommanFuntion {

	
	static WebDriver driver;
	public static Properties prop;
	
	public static void main (String args []) {
		
	}
	public static void expclick(WebDriver driver, WebElement locator, int timeout)
	{
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
	}

	public static void loadingconfig() throws IOException
	{
		prop = new Properties();
		try
		{
			FileInputStream file = new FileInputStream("/Users/user/eclipse-workspace/turtle/src/main/java/turtlemint/qa/config/config.properties");
					prop.load(file);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
