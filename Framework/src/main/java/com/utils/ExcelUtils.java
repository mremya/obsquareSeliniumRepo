package com.utils;

import java.io.FileInputStream;
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
 final static String currentDir = System.getProperty("user.dir");
 static String filePath = currentDir + ".//src//test//resources//RestuarantData.xlsx";

 static XSSFWorkbook workbook;
 static XSSFSheet sheet;
 static FileInputStream fs;
 File file = new File(filePath);
	

 public void getNumberOfRows() throws IOException {
  fs = new FileInputStream(file);
  workbook = new XSSFWorkbook(fs);
  sheet = workbook.getSheetAt(0);
  int rowCount = sheet.getPhysicalNumberOfRows();
  System.out.println(rowCount);
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
public String readStringData(int rowNum, int colNum) throws IOException {

	  fs = new FileInputStream(file);
	  workbook = new XSSFWorkbook(fs);
	  sheet = workbook.getSheetAt(0);
	  String cellValue = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
	  return cellValue;
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
public int readNumericData(int rowNum, int colNum) throws IOException {

	  fs = new FileInputStream(file);
	  workbook = new XSSFWorkbook(fs);
	  sheet = workbook.getSheetAt(0);
	  int cellValue = (int) sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
	  return cellValue;
	 }
		
}