package util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtility {

    static Workbook book;
    private static Sheet scenariosheet;
    private static Cell currentCell;

    public static Object[][] getTestData(String sheetName) {

        FileInputStream file = null;
        ////**** Opening an excel
        File fileOpen=new File(System.getProperty("user.dir")+"/src/resources/TestDataSCN.xlsx");

        try {
            file = new FileInputStream(fileOpen);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            book = new XSSFWorkbook(file);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        scenariosheet = book.getSheet(sheetName);
        Object[][] data = new Object[scenariosheet.getLastRowNum()][scenariosheet.getRow(0).getLastCellNum()];

        int rowCount = scenariosheet.getLastRowNum()-scenariosheet.getFirstRowNum();

        for (int i=0;i<scenariosheet.getLastRowNum();i++){
            Row row = scenariosheet.getRow(i);
            for (int k = 0; k < row.getLastCellNum(); k++) {
                currentCell=row.getCell(k);
             //   data[i][k]=currentCell;
                data[i][k] = scenariosheet.getRow(i + 1).getCell(k).toString();
            }
        }
        try {
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

}
