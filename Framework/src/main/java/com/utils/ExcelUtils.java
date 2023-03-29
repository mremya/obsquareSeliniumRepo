package com.utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static final String currentDir = System.getProperty("user.dir");
	public static String filePath = currentDir + "/src/test/resources/ ";
	String file = "TEST.xlsx";

	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public ExcelUtils(String fileName, String sheetName) throws IOException {
		String excelPath = filePath + fileName;
		workbook = new XSSFWorkbook(excelPath);
		sheet = workbook.getSheetAt(0);
	}

	/**
	 * 
	 * method to get row count
	 */
	public static int getRowCount() {

		int rowCount = 0;

		try {
			rowCount = sheet.getPhysicalNumberOfRows();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rowCount;
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
	public static String readStringData(String fileName, String sheetName, int rowNum, int colNum) throws IOException {
		String excelPath = filePath + fileName;

		workbook = new XSSFWorkbook(excelPath);
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
	public static int readIntegerData(String fileName, String sheetName, int rowNum, int colNum) throws IOException {
		String excelPath = filePath + fileName;

		workbook = new XSSFWorkbook(excelPath);
		sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell c = row.getCell(colNum);

		return (int) c.getNumericCellValue();

	}
}
