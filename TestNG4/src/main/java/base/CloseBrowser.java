package base;

import org.testng.annotations.AfterSuite;

public class CloseBrowser extends TestBase{

   @AfterSuite
    public void quitbrowser() {
        driver.quit();
    }
}
