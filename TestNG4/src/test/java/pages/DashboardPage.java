package pages;
import base.BrowserAction;
import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import util.ExcelUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

public class DashboardPage extends TestBase {

    WebDriver driver;
    Properties dashboardPageProperties = new Properties();
    FileInputStream inputfile = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/objectRepository/DashboardPageObjects");
    ExcelUtility excelUtility;

    public DashboardPage() throws FileNotFoundException {
        this.driver = TestBase.driver;
    }


    public HealthModuleSelectPage health_Vertical_Click() {
        try {
            dashboardPageProperties.load(inputfile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String healthTab = dashboardPageProperties.getProperty("healthTab");
        BrowserAction.click(driver, healthTab);
        return new HealthModuleSelectPage();




    }

}
