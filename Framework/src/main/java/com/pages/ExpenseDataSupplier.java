package com.pages;

import org.testng.annotations.DataProvider;

public class ExpenseDataSupplier {
	
	 @DataProvider (name = "expenseDataProvider")
     public Object[][] addExpenseDataProvider(){
        Object[][] expensedata=new Object[10][2];
        
        expensedata[1][1]="04/04/2023";
        expensedata[2][1]="abc";
        expensedata[3][1]="Pasta";
        expensedata[4][1]="MNC";
        expensedata[5][1]="1200";
        
        expensedata[6][1]="24/04/2023";
        expensedata[7][1]="pqr";
        expensedata[8][1]="Maggi";
        expensedata[9][1]="Store2";
        expensedata[10][1]="100";
    
		return expensedata;
        	                         
     } 

}
