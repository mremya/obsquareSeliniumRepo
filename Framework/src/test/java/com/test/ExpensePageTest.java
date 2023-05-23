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
	ProductPage ppage;
	StoresPage storepage;
	WebActionUtils webaction;
	PeopleWaiterPage waiter;
	ExpensePage expensep;
	Properties prop;

	@Test(priority = 1, enabled = true)
	public void validateTheElementInAddExpensePopup() {
		login = new LoginPage(driver);
		webbrowser = new WebBrowserUtils();
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

	@Test(priority = 2, enabled = true)
	public void validatenAddExpensePopUpfields() {
		
		login = new LoginPage(driver);
		webbrowser = new WebBrowserUtils();
		prop = PropertyUtils.getProperty("config.properties");
		login.performlogin(prop.getProperty("username"), prop.getProperty("password"));
		expensep = homepg.navigateToExpensePage();
		
		expensep.clickOnAddExpense();
		expensep.enterValueForExpenseDate("2023-02-04");
		//expensep.enterValueForExpenseReference(reference);
		expensep.enterValueForExpenseAmount("xyz");

		expensep.clickOnAddExpenseSubmit();
		expensep.searchByExpenseStore("MNC");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(expensep.getExpensStoreFromSearchResult(), "MNC",
				AutomationConstants.addFeildValidateErrorMessage);
		soft.assertEquals(expensep.getExpensAmountFromSearchResult(), "10",
				AutomationConstants.addFeildValidateErrorMessage);
		soft.assertAll();
		expensep.clickOnaddExpenseCloseBtn();

	}

	@Test(priority = 3, enabled = true, dataProviderClass = ExpenseDataSupplier.class)
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

	@Test(priority = 4, enabled = true)
	public void modifyTheExistingRecordOfExpense() {
		login = new LoginPage(driver);
		webbrowser = new WebBrowserUtils();
		prop = PropertyUtils.getProperty("config.properties");
		login.performlogin(prop.getProperty("username"), prop.getProperty("password"));
		expensep = homepg.navigateToExpensePage();	
		
		expensep.searchByExpenseStore("MNC");
		expensep.clickOnEditIcon();
		expensep.enterValueForExpenseAmount("4500");
		expensep.enterValueForExpenseReference("xyz");
		expensep.selectValueForExpenseCategory("ginger");
		expensep.selectValueForExpenseStore("stor2");
		expensep.searchByExpenseStore("MNC");
		SoftAssert soft = new SoftAssert();

		soft.assertEquals(expensep.getExpensReferenceFromSearchResult(), "abc", AutomationConstants.errorMessage);
		soft.assertEquals(expensep.getExpensCategoryFromSearchResult(), "Pasta", AutomationConstants.errorMessage);
		soft.assertEquals(expensep.getExpensAmountFromSearchResult(), "1200", AutomationConstants.errorMessage);
		soft.assertEquals(expensep.getExpensStoreFromSearchResult(), "MNC", AutomationConstants.errorMessage);
		soft.assertAll();
	}

	@Test(priority = 5, enabled = true)
	public void validateDeleteFunctiongOfExistingRecord(){
		login = new LoginPage(driver);
		webbrowser = new WebBrowserUtils();
		prop = PropertyUtils.getProperty("config.properties");
		login.performlogin(prop.getProperty("username"), prop.getProperty("password"));
		expensep = homepg.navigateToExpensePage();	
		
		
		expensep.searchByExpenseStore("MNC");
		expensep.clickOnDeleteIcon();
		expensep.clickOnDeleteConformMsg();
		expensep.clickOnDeleteOk();
		
		
		expensep.searchByExpenseStore("MNC");
		assertEquals(expensep.getTheSearchResultOfDeletedEntry(), "No matching records found",
				AutomationConstants.deleteCheck);
	}

	
}
