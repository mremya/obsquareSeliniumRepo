package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public final static String currentDir = System.getProperty("user.dir");
	public static String filePath = currentDir + ".//src/test//resources//RestaurantData.xlsx";
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static FileInputStream fs;
	File file = new File(filePath);

	public void ExcelUtilities() {
		try {
			workbook = new XSSFWorkbook(filePath);
		} catch (IOException e) {
			throw new RuntimeException("Error during reading filepath");
		}
		sheet = workbook.getSheetAt(0);
	}
/**
 * function to get row count
 */
	public void getNumberOfRows() {
		try {
			fs = new FileInputStream(file);
			workbook = new XSSFWorkbook(fs);
		} catch (IOException e) {
			throw new RuntimeException("Error during reading file");
		}
		sheet = workbook.getSheetAt(0);
		int rowCount = sheet.getPhysicalNumberOfRows();
		
	}
/**
 * 
 * @param sheetname
 * @param rowNum
 * @param colNum
 * @return
 */
	public String readStringData(String sheetname, int rowNum, int colNum) {
		try {
			fs = new FileInputStream(file);
			workbook = new XSSFWorkbook(fs);
		} catch (IOException e) {
			throw new RuntimeException("Error during reading file");
		}
		sheet = workbook.getSheet(sheetname);
		String cellValue = sheet.getRow(rowNum - 1).getCell(colNum - 1).getStringCellValue();
		return cellValue;
	}
/**
 * 
 * @param sheetname
 * @param rowNum
 * @param colNum
 * @return
 */
	public int readNumericData(String sheetname, int rowNum, int colNum) {
		try {
			fs = new FileInputStream(file);
			workbook = new XSSFWorkbook(fs);
		} catch (IOException e) {
			throw new RuntimeException("Error during reading file");
		}
		sheet = workbook.getSheet(sheetname);
		int cellValue = (int) sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
		return cellValue;
	}
}