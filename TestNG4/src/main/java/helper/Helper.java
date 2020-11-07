//package helper;
//
//import jdk.internal.org.jline.utils.Log;
//import net.lightbody.bmp.BrowserMobProxyServer;
//import org.apache.poi.ss.usermodel.DataFormat;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.*;
//
//public class Helper {
//
//
//    public static WebElement getElement(WebDriver driver, String sLocator) {
//        try {
//            return driver.findElement(By.xpath(sLocator));
//        } catch (Exception e) {
//            Log.error("Failed to return the WebElement | Class: GenericMethods | method: getElement " + e.getMessage());
//        }
//        return null;
//    }
//
////    public static List<String> getData(String fileName){
////
////     //   return Files.readLines(fileName, UTF16);
////    }
//
//    public static List<WebElement> getElements(WebDriver driver, String sLocator){
//        return driver.findElements(By.xpath(sLocator));
//    }
//
//    public static String getColorName (WebDriver driver, String sLocator){
//        String textcolor=driver.findElement(By.xpath(sLocator)).getCssValue("color");
//        return textcolor;
//    }
//
//    public static int getNumberOfWindows (WebDriver driver){
//        Set<String> allwindowHandles=driver.getWindowHandles();
//        ArrayList<String> tabs=new ArrayList<String>(allwindowHandles);
//        return tabs.size();
//    }
//
//    public static int getDate(){
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(new Date());
//        return cal.get(Calendar.DAY_OF_MONTH);
//    }
//
//    public static int getMonth (){
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(new Date());
//        return cal.get(Calendar.MONTH);
//    }
//
////    public static boolean isClickable(WebElement element, WebDriver driver){}
////
////    public static void setUrl (String env, String tenant){}
////
////    public static void setDashboardUrl (String env, String tenant){}
////
////    public static boolean checkBrokenLinks(WebDriver driver, String sLocator){}
////
////    public static List <String> getBlackListedUrls (){}
////
////    public static BrowserMobProxyServer getServer (BrowserMobProxyServer server) {}
//
//}
