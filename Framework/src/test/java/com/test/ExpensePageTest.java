package com.test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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
	

	@BeforeMethod
	public void prerun() throws Exception {
		driver = getDriver();
		login = new LoginPage(driver);
		webbrowser = new WebBrowserUtils();
		prop=PropertyUtils.getProperty("config.properties");
		login.performlogin(prop.getProperty("username"), prop.getProperty("password"));
		ppage = homepg.navigateToProductPage();
		storepage = ppage.navigateToStoresPage();
		waiter = storepage.navigateToPeoplePage();
		expensep=waiter.navigateToExpensePage();
	}
	
	
	@Test(priority = 1, enabled = true )
	public void validateTheElementInAddExpensePopup() {

		expensep.clickOnAddExpense();

		SoftAssert soft = new SoftAssert();
	soft.assertTrue(expensep.isExpenseDateDisplayed(), AutomationConstants.addDisplayedErrorMsg);
		soft.assertTrue(expensep.isExpenseReferenceDisplayed(), AutomationConstants.addDisplayedErrorMsg);
		soft.assertTrue(expensep.isExpenseCategoryDisplayed(), AutomationConstants.addDisplayedErrorMsg);
		soft.assertTrue(expensep.isExpenseStoreDisplayed(), AutomationConstants.addDisplayedErrorMsg);
		soft.assertTrue(expensep.isExpenseAmountDisplayed(), AutomationConstants.addDisplayedErrorMsg);
		
		soft.assertAll();

	}
	
	@Test(priority = 2, enabled = true )
	public void validatenAddExpensePopUpfields() {
		expensep.clickOnAddExpense();
		expensep.selectValueForExpenseStore("Shibina");
		expensep.enterValueForExpenseAmount("xyz");
		
		expensep.clickOnAddExpenseSubmit();
		expensep.searchByExpenseStore("MNC");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(expensep.getExpensStoreFromSearchResult(), "MNC",AutomationConstants.addFeildValidateErrorMessage);
		soft.assertEquals(expensep.getExpensAmountFromSearchResult(), "10", AutomationConstants.addFeildValidateErrorMessage);
		soft.assertAll();
	
	}
	@Test(priority = 3, enabled = true,dataProviderClass = ExpenseDataSupplier.class)
	public void validateEnteredValueInAddExpensePopUpIsSaved(String date,String ref,String cat , String store , String amt) {
		expensep.clickOnAddExpense();
		expensep.enterValueForExpenseDate(date);
		expensep.enterValueForExpenseReference(ref);
		expensep.enterValueForExpenseAmount(amt);
		expensep.selectValueForExpenseCategory(cat);
		expensep.selectValueForExpenseStore(store);
		expensep.clickOnAddExpenseSubmit();
		expensep.searchByExpenseStore("MNC");
	SoftAssert soft = new SoftAssert();
	soft.assertEquals(expensep.getExpensDateFromSearchResult(), "04\04\2023", AutomationConstants.);
	soft.assertEquals(expensep.getExpensReferenceFromSearchResult(), "abc", "failure message: expense reference data mismatch");
	soft.assertEquals(expensep.getExpensCategoryFromSearchResult(), "Pasta", "failure message: expense category data mismatch");
	soft.assertEquals(expensep.getExpensAmountFromSearchResult(), "1200", "failure message: expense amount data mismatch");
	soft.assertEquals(expensep.getExpensStoreFromSearchResult(), "MNC", "failure message: expense store data mismatch");
	
	soft.assertAll();
	}
	
	@Test(priority = 4, enabled = true)
	public void modifyTheExistingRecordOfExpense() {
		expensep.searchByExpenseStore("MNC");
		expensep.clickOnEditIcon();
		expensep.enterValueForExpenseAmount("4500");
		expensep.enterValueForExpenseReference("xyz");
		expensep.selectValueForExpenseCategory("ginger");
		expensep.selectValueForExpenseStore("stor2");
		expensep.searchByExpenseStore("MNC");
		SoftAssert soft = new SoftAssert();
		
		soft.assertEquals(expensep.getExpensReferenceFromSearchResult(), "abc", "failure message: expense reference data mismatch");
		soft.assertEquals(expensep.getExpensCategoryFromSearchResult(), "Pasta", "failure message: expense category data mismatch");
		soft.assertEquals(expensep.getExpensAmountFromSearchResult(), "1200", "failure message: expense amount data mismatch");
		soft.assertEquals(expensep.getExpensStoreFromSearchResult(), "MNC", "failure message: expense store data mismatch");
	soft.assertAll();
	}
	

	
	@Test(priority = 5, enabled = true)
	public void validateDeleteFunctiongOfExistingRecord() throws IOException {
		expensep.selectValueForExpenseStore("Shibina");
		expensep.clickOnDeleteIcon();
		expensep.clickOnDeleteConformMsg();
		expensep.clickOnDeleteOk();
		expensep.selectValueForExpenseStore("Shibina");
		assertEquals(storepage.getTheSearchResultOfDeletedEntry(), "No matching records found",AutomationConstants.deleteCheck);
		
	}
	


}
