package steps;

import base.TestBase;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HealthModuleSelectPage;
import util.ExcelUtility;
import util.ExcelUtility3;

import java.util.Iterator;

public class HealthModuleSelectTest extends TestBase {

    private WebDriver driver;
    HealthModuleSelectPage healthModuleSelectPage = new HealthModuleSelectPage();
    ExcelUtility excelUtility;
    static String sheetName = "B2C-P2";



        public void HealthModuleSelect(String Need,String	Application,String	vertical,String	InsuredMember,
                                       String	SelfAge,String SpouseAge,String	MotherAge,String FatherAge,
                                       String	Son1Age,String Son2Age,String	Daughter1Age,String	Daughter2Age,
                                       String	Maternity,String ChildPlanning,String PED,String PEDMember,
                                       String	Disease,String Bucket,String CoverAmount,String	Deductible,
                                       String	PlanID,String scenario)
        {
        if (Need.equals("BNP")) {
            healthModuleSelectPage.clickBuyNew();


        } else {
            System.out.println("Module condition did not run");
        }


    }
}

