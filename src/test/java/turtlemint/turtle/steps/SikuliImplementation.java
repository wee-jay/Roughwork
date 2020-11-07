package turtlemint.turtle.steps;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.lowagie.text.Image;


public class SikuliImplementation {
	public static WebDriver driver;
	public static WebElement Next;
	
	
	public static void main(String[] args) throws InterruptedException, FindFailed {
		System.setProperty("webdriver.chrome.driver", "/Users/user/Public/Selenium/ChromeDriver/chromedriver");
		ChromeOptions browseroptions = new ChromeOptions();
		browseroptions.addArguments("--incognito", "--disable-logging");
		
		driver = new ChromeDriver(browseroptions);
		driver.manage().window().maximize();
		driver.get("https://app.turtlemint.com/life-insurance/complete-application/AG5RIDXHIW1");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//file-handler[@data-auto='proposal_form']/div/div/div/div/button")).click();
		
//		Implementation of SIKULI and verify the existence of resource / file at given location.
		if(ImagePath.add("/Users/user/eclipse-workspace/turtle/"+"downloadimage.png"))
		{
			System.out.println("File found at location:- "+"/Users/user/eclipse-workspace/turtle");
		}
		else
		{
			System.out.println("File not found at given location in imagepath ... :(");
		}
		
		Screen s = new Screen();
		
//		Make sure u give complete path of resource and not just current directory or folder path
		Pattern p = new Pattern("/Users/user/eclipse-workspace/turtle/"+"downloadimage.png");
		s.wait(p,10);
		s.hover(p);
		s.click(p);
		s.click(p);
		Pattern q = new Pattern("/Users/user/eclipse-workspace/turtle/"+"open.png");
		s.wait(q,10);
		s.click(q);
		
		
//		WebElement article;
//		article = driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right']/li/a[contains(text(),'Articles')]"));
//		getscreenshat(article, "Article");
//		driver.switchTo().newWindow(WindowType.TAB);
//		
//		Set <String> shandle = driver.getWindowHandles();
//		
//		List<String> handles = new ArrayList<String>(shandle);
//		System.out.println("First window handle is:- "+ handles.get(0));
//		System.out.println("Secondwindow handle is:- "+ handles.get(1));
//		
//		
//		driver.get("https://www.google.com");
//		System.out.println("Second window title:- "+driver.getTitle());
//		driver.close();
//		driver.switchTo().window(handles.get(0));
//		System.out.println("Main window title:- "+driver.getTitle());
//		driver.quit();
//	
	}	
	
	public static void getscreenshat(WebElement elem, String Filename)
	{
		File fil = elem.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(fil, new File ("./target/screenshot/"+Filename+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
