package Utilities;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Exelread {
    public static FileInputStream inputStream;
    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;
    public static XSSFRow row;
    public static XSSFCell cell;
    public static String getcell(String filename,String Sheetname,int rowno,int cellno){
        try {
            inputStream = new FileInputStream(filename);
            workbook = new XSSFWorkbook(inputStream);
            sheet = workbook.getSheet(Sheetname);
            cell = workbook.getSheet(Sheetname).getRow(rowno).getCell(cellno);
            workbook.close();
            return  cell.getStringCellValue();


        } catch (IOException e) {
            return "";

        }
    }
    public static int getrowcount(String filename,String sheetname){
        try {
            inputStream = new FileInputStream(filename);
            workbook = new XSSFWorkbook(inputStream);
            sheet = workbook.getSheet(sheetname);

            if (sheet != null) {
                int rows = sheet.getLastRowNum() + 1;
                workbook.close();
                return rows;
            } else {
                return 0; // Handle the case where the sheet is null
            }
        } catch (IOException e) {
            return 0; // Handle the IOException
        }
    }
    public static int getcellcount(String filename,String sheetname){
        try {
            inputStream = new FileInputStream(filename);
            workbook = new XSSFWorkbook(inputStream);
            sheet = workbook.getSheet(sheetname);
            if (sheet != null) {
                int cells = sheet.getRow(1).getLastCellNum();
                workbook.close();
                return cells;
            } else {
                return 0; // Handle the case where the sheet is null
            }
        } catch (IOException e) {
            return 0;
        }
    }


}
