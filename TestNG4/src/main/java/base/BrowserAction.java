package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrowserAction {

    WebDriver driver;

    public BrowserAction(WebDriver driver) {
        super();
    }

    public static void click(WebDriver driver, String locator) {

        driver.findElement(By.xpath(locator)).click();
    }

    public static void enter(WebDriver driver, String locator, String text) {
        driver.findElement(By.xpath(locator)).sendKeys(text);
    }

}
