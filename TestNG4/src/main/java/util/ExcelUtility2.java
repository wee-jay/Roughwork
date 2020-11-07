package util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ExcelUtility2 {


    public static ArrayList<String> getData(String testCasename) throws FileNotFoundException, IOException {
        ArrayList<String> a = new ArrayList<String>();
        FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir")+"/src/resources/TestDataSCN.xlsx");
        XSSFWorkbook xssfWorkbook = null;
        try {
            xssfWorkbook = new XSSFWorkbook(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Get the numnber of sheets
        int sheetscount = xssfWorkbook.getNumberOfSheets();
        for (int i = 0; i < sheetscount; i++) {
            //get sheetname
            if (xssfWorkbook.getSheetName(i).equalsIgnoreCase("TestData")) {
                XSSFSheet sheet = xssfWorkbook.getSheetAt(i);
                //GetRowname by identifing the coloumn.
                Iterator<Row> rows = sheet.iterator();
                Row firstrow = rows.next();
                Iterator<Cell> ce = firstrow.cellIterator();
                ce.next();
                int k = 0;
                int coloumn = 0;
                while (ce.hasNext()) {
                    Cell vaule = ce.next();
                    if (vaule.getStringCellValue().equalsIgnoreCase("TestCases")) {
                        coloumn = k;
                    }
                    k++;
                }
                System.out.println(coloumn);
                while (rows.hasNext()) {
                    Row r = rows.next();
                    if (r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(testCasename)) {
                        Iterator<Cell> cv = r.cellIterator();
                        while (cv.hasNext()) {
                            Cell c = cv.next();
                            if (c.getCellType() == CellType.STRING) {
                                a.add(c.getStringCellValue());  //add data to arraylist
                            } else {
                                a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
                            }
                        }
                    }
                }
            }
        }
        return a;
    }



}

