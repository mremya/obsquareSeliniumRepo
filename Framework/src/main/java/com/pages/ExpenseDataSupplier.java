package com.pages;

import org.testng.annotations.DataProvider;

import com.utils.ExcelUtils;

public class ExpenseDataSupplier {
	ExcelUtils excelutil= new ExcelUtils();
	 @DataProvider (name = "expenseDataProvider")
     public Object[][] addExpenseDataProvider(){
		 
        Object[][] expensedata=new Object[5][2];
        
        expensedata[0][0]=excelutil.readStringData("ExpenseData", 2, 2);
        expensedata[1][0]=excelutil.readStringData("ExpenseData", 3, 2);
        expensedata[2][0]=excelutil.readStringData("ExpenseData", 4, 2);
        expensedata[3][0]=excelutil.readStringData("ExpenseData", 5, 2);
        expensedata[4][0]=excelutil.readStringData("ExpenseData", 6, 2);
        
        expensedata[0][1]=excelutil.readStringData("ExpenseData", 8, 2);
        expensedata[1][1]=excelutil.readStringData("ExpenseData", 9, 2);
        expensedata[2][1]=excelutil.readStringData("ExpenseData", 10, 2);
        expensedata[3][1]=excelutil.readStringData("ExpenseData", 11, 2);
        expensedata[4][1]=excelutil.readStringData("ExpenseData", 2, 2);
    
		return expensedata;
        	                         
     } 
	 

	 

}
