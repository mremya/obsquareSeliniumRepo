package com.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public class ExcelUtilities {

		 final String currentDir = System.getProperty("user.dir");
		 String filePath = currentDir + ".//src/test//resources//RestuarantData.xlsx";
		 static String excelPath;
		 static XSSFWorkbook workbook;
		 static XSSFSheet sheet;
		 FileInputStream fs;

		 public ExcelUtilities() throws IOException {

		  try {
		   workbook = new XSSFWorkbook(filePath);
		  } catch (IOException e) {
		   e.printStackTrace();
		  }
		  sheet = workbook.getSheetAt(0);
		 }

		 public String readStringData(String sheetname, int rowNum, int colNum) throws IOException {

		  String cellValue = sheet.getRow(rowNum - 1).getCell(colNum - 1).getStringCellValue();
		  return cellValue;
		 }

		}

	/**
	 * 
	 * method to get col count
	 */
	public static int getColCount() {

		int colCount = 0;
		try {
			colCount = sheet.getRow(0).getLastCellNum();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return colCount;

	}
/**
 * 
 * @param fileName
 * @param sheetName
 * @param rowNum
 * @param colNum
 * @return
 * @throws IOException
 */
	public static String readStringData(String sheetName, int rowNum, int colNum) throws IOException {
		

		workbook = new XSSFWorkbook(fs);
		//sheet = workbook.getSheet(sheetName);
		sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell c = row.getCell(colNum);

		return c.getStringCellValue();

	}
/**
 * 
 * @param fileName
 * @param sheetName
 * @param rowNum
 * @param colNum
 * @return
 * @throws IOException
 */
	public static int readIntegerData( String sheetName, int rowNum, int colNum) throws IOException {
		

		workbook = new XSSFWorkbook(excelPath);
		sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell c = row.getCell(colNum);

		return (int) c.getNumericCellValue();

	}
}
