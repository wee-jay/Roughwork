package pages;


import base.BrowserAction;
import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.CacheLookup;
import util.MongoUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class HealthModuleSelectPage extends TestBase {
    FileInputStream healthmoduleSelectFile;
    Properties healthmoduleselectprop;

    {
        try {
            healthmoduleSelectFile = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/objectrepository/HealthModuleSelectPageObjects");
            healthmoduleselectprop= new Properties();
            healthmoduleselectprop.load(healthmoduleSelectFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HealthModuleSelectPage() {
        this.driver = TestBase.driver;
        //this.driver=driver;
    }

    public void clickBuyNew(){

        String buynewTab=healthmoduleselectprop.getProperty("buynewtab");
        BrowserAction.click(driver,buynewTab);

    }
}
