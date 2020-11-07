package steps;

import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.HealthModuleSelectPage;
import util.ExcelUtility;
import util.MongoUtil2;

import java.io.FileNotFoundException;
import java.util.Iterator;


public class DashboardTest<dataProvider> extends TestBase{


    DashboardPage dashboardPage;
    HealthModuleSelectPage healthModuleSelectPage;
    WebDriver driver;
    static String sheetName = "B2C-P2";


   @BeforeMethod
    public void setUp() {
       TestBase.initialize();

        try {
            dashboardPage = new DashboardPage();
            healthModuleSelectPage = new HealthModuleSelectPage();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @DataProvider
    public Object[][] getTestData(){
       Object data[][]=  ExcelUtility.getTestData(sheetName);
        return data;
    }

    @Test(dataProvider = "getTestData")
    public void HealthVerticalClick(String Need,String	Application,String	vertical,String	InsuredMember,
                                    String	SelfAge,String SpouseAge,String	MotherAge,String FatherAge,
                                    String	Son1Age,String Son2Age,String	Daughter1Age,String	Daughter2Age,
                                    String	Maternity,String ChildPlanning,String PED,String PEDMember,
                                    String	Disease,String Bucket,String CoverAmount,String	Deductible,
                                    String	PlanID,String scenario)
    {
        if (vertical.equals("health")){
            dashboardPage.health_Vertical_Click();

            // healthModuleSelectPage =

            HealthModuleSelectTest healthModuleSelectTest=new HealthModuleSelectTest();
            healthModuleSelectTest.HealthModuleSelect(Need,Application,vertical,InsuredMember,
                    	SelfAge,SpouseAge,MotherAge,FatherAge, Son1Age,Son2Age,Daughter1Age,Daughter2Age,
                    	Maternity, ChildPlanning,PED,PEDMember, Disease, Bucket,CoverAmount,Deductible, PlanID,
                        scenario);

            Integer a=MongoUtil2.getOTP();
            System.out.println(a);
        }

        else {
            System.out.println("Module did not work");
        }
    }
}
