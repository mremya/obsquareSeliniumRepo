package com.test;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.constants.AutomationConstants;
import com.pages.ExpenseDataSupplier;
import com.pages.ExpensePage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.PeopleWaiterPage;
import com.pages.ProductPage;
import com.pages.StoresPage;
import com.utils.ExcelUtils;
import com.utils.PropertyUtils;
import com.utils.WebActionUtils;
import com.utils.WebBrowserUtils;

public class ExpensePageTest extends AutomationBase {
	WebDriver driver;
	WebBrowserUtils webbrowser;
	LoginPage login;
	HomePage homepg;
	WebActionUtils webaction;
	ExpensePage expensep;
	Properties prop;

	@Test(priority = 1, enabled = true)
	public void validateTheElementInAddExpensePopup() {
		login = new LoginPage(driver);
		prop = PropertyUtils.getProperty("config.properties");
		login.performlogin(prop.getProperty("username"), prop.getProperty("password"));
		expensep = homepg.navigateToExpensePage();
		
		expensep.clickOnAddExpense();
		
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(expensep.isExpenseDateDisplayed(), AutomationConstants.addDisplayedErrorMsg);
		soft.assertTrue(expensep.isExpenseReferenceDisplayed(), AutomationConstants.addDisplayedErrorMsg);
		soft.assertTrue(expensep.isExpenseCategoryDisplayed(), AutomationConstants.addDisplayedErrorMsg);
		soft.assertTrue(expensep.isExpenseStoreDisplayed(), AutomationConstants.addDisplayedErrorMsg);
		soft.assertTrue(expensep.isExpenseAmountDisplayed(), AutomationConstants.addDisplayedErrorMsg);
		expensep.clickOnaddExpenseCloseBtn();
		soft.assertAll();
		

	}

	//@Test(priority = 2, enabled = true)
	public void validatenAddExpensePopUpfields() {
		ExcelUtils excelutil = new ExcelUtils();
		login = new LoginPage(driver);
		webbrowser = new WebBrowserUtils();
		prop = PropertyUtils.getProperty("config.properties");
		login.performlogin(prop.getProperty("username"), prop.getProperty("password"));
		expensep = homepg.navigateToExpensePage();
		
		String edate = excelutil.readStringData("ExpenseData", 14,2);
		String eamt = excelutil.readStringData("ExpenseData",16,2);
		String estore= excelutil.readStringData("ExpenseData",15,2);
		
		expensep.clickOnAddExpense();
		expensep.enterValueForExpenseDate(edate);
		expensep.selectValueForExpenseStore(estore);
		expensep.enterValueForExpenseAmount(eamt);

		expensep.clickOnAddExpenseSubmit();
		expensep.searchByExpenseStore(estore);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(expensep.getExpensStoreFromSearchResult(),estore,
				AutomationConstants.addFeildValidateErrorMessage);
		soft.assertEquals(expensep.getExpensAmountFromSearchResult(),eamt,
				AutomationConstants.addFeildValidateErrorMessage);
		soft.assertAll();
		expensep.clickOnaddExpenseCloseBtn();

	}

	//@Test(priority = 3, enabled = true, dataProviderClass = ExpenseDataSupplier.class)
	public void validateEnteredValueInAddExpensePopUpIsSaved(String date, String reference, String category, String store,
			String amount) {
		login = new LoginPage(driver);
		webbrowser = new WebBrowserUtils();
		prop = PropertyUtils.getProperty("config.properties");
		login.performlogin(prop.getProperty("username"), prop.getProperty("password"));
		expensep = homepg.navigateToExpensePage();
		
		expensep.clickOnAddExpense();
		expensep.enterValueForExpenseDate(date);
		expensep.enterValueForExpenseReference(reference);
		expensep.enterValueForExpenseAmount(amount);
		expensep.selectValueForExpenseCategory(category);
		expensep.selectValueForExpenseStore(store);
		expensep.clickOnAddExpenseSubmit();
		expensep.searchByExpenseStore(store);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(expensep.getExpensDateFromSearchResult(), date, AutomationConstants.errorMessage);
		soft.assertEquals(expensep.getExpensReferenceFromSearchResult(), reference, AutomationConstants.errorMessage);
		soft.assertEquals(expensep.getExpensCategoryFromSearchResult(),category, AutomationConstants.errorMessage);
		soft.assertEquals(expensep.getExpensAmountFromSearchResult(), store, AutomationConstants.errorMessage);
		soft.assertEquals(expensep.getExpensStoreFromSearchResult(),amount, AutomationConstants.errorMessage);

		soft.assertAll();
	}

	//@Test(priority = 4, enabled = true)
	public void modifyTheExistingRecordOfExpense() {
		ExcelUtils excelutil = new ExcelUtils();
		login = new LoginPage(driver);
		webbrowser = new WebBrowserUtils();
		prop = PropertyUtils.getProperty("config.properties");
		login.performlogin(prop.getProperty("username"), prop.getProperty("password"));
		expensep = homepg.navigateToExpensePage();	
		
		String ecategory = excelutil.readStringData("ExpenseData",18,2);
		String eamt = excelutil.readStringData("ExpenseData",20,2);
		String estore= excelutil.readStringData("ExpenseData",19,2);
		String ereference= excelutil.readStringData("ExpenseData",19,2);
		
		expensep.searchByExpenseStore(estore);
		expensep.clickOnEditIcon();
		expensep.enterValueForExpenseAmount(eamt);
		expensep.enterValueForExpenseReference(ereference);
		expensep.selectValueForExpenseCategory(ecategory);
		expensep.searchByExpenseStore(estore);
		SoftAssert soft = new SoftAssert();

		soft.assertEquals(expensep.getExpensReferenceFromSearchResult(),ereference, AutomationConstants.errorMessage);
		soft.assertEquals(expensep.getExpensCategoryFromSearchResult(),ecategory, AutomationConstants.errorMessage);
		soft.assertEquals(expensep.getExpensAmountFromSearchResult(),eamt, AutomationConstants.errorMessage);
		soft.assertEquals(expensep.getExpensStoreFromSearchResult(), estore, AutomationConstants.errorMessage);
		soft.assertAll();
	}

	//@Test(priority = 5, enabled = true)
	public void validateDeleteFunctiongOfExistingRecord(){
		ExcelUtils excelutil = new ExcelUtils();
		login = new LoginPage(driver);
		webbrowser = new WebBrowserUtils();
		prop = PropertyUtils.getProperty("config.properties");
		login.performlogin(prop.getProperty("username"), prop.getProperty("password"));
		expensep = homepg.navigateToExpensePage();	
		
		String estore= excelutil.readStringData("ExpenseData",23,2);
		expensep.searchByExpenseStore(estore);
		expensep.clickOnDeleteIcon();
		expensep.clickOnDeleteConformMsg();
		expensep.clickOnDeleteOk();
		
		
		expensep.searchByExpenseStore(estore);
		assertEquals(expensep.getTheSearchResultOfDeletedEntry(), "No matching records found",
				AutomationConstants.deleteCheck);
	}

	
}
