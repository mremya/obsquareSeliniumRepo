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
 final static String currentDir = System.getProperty("user.dir");
 public static String filePath = currentDir + ".//src/test//resources//RestuarantData.xlsx";

 static XSSFWorkbook workbook;
 static XSSFSheet sheet;
 static FileInputStream fs;
 File file = new File(filePath);
	
 
 public void ExcelUtilities() {
	 try {
		workbook=new XSSFWorkbook(filePath);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 sheet=workbook.getSheetAt(0);
 }

 public void getNumberOfRows()  {
  try {
	fs = new FileInputStream(file);
	workbook = new XSSFWorkbook(fs);
} catch (IOException e) {
	throw new RuntimeException("Error while reading file");
}
  
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
public String readStringData(int rowNum, int colNum)  {

	  try {
		fs = new FileInputStream(file);
		workbook = new XSSFWorkbook(fs);
	} catch (IOException e) {
		throw new RuntimeException("Error while reading file");
	}
	  
	  sheet = workbook.getSheetAt(0);
	  String cellValue = sheet.getRow(rowNum-1).getCell(colNum-1).getStringCellValue();
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
public int readNumericData(int rowNum, int colNum)  {

	  try {
		fs = new FileInputStream(file);
		workbook = new XSSFWorkbook(fs);
	} catch (IOException e) {
		throw new RuntimeException("Error while reading file");
	}
	  
	  sheet = workbook.getSheetAt(0);
	  int cellValue = (int) sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
	  return cellValue;
	 }
		
}