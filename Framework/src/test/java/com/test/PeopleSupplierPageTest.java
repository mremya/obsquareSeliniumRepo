package com.test;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.constants.AutomationConstants;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.PeopleCustomerPage;
import com.pages.PeopleSupplierPage;
import com.pages.PeopleWaiterPage;
import com.pages.ProductPage;
import com.pages.StoresPage;
import com.utils.ExcelUtils;
import com.utils.PropertyUtils;
import com.utils.WebBrowserUtils;

public class PeopleSupplierPageTest extends AutomationBase {

	WebDriver driver;
	WebBrowserUtils webbrowser;
	LoginPage login;
	ExcelUtils excelutil;
	HomePage homepg;
	ProductPage ppage;
	StoresPage storepage;
	PeopleWaiterPage waiter;
	PeopleSupplierPage supplier;
	Properties prop;

	@BeforeMethod
	public void prerun() throws Exception {
		driver = getDriver();
		login = new LoginPage(driver);
		excelutil = new ExcelUtils();
		webbrowser = new WebBrowserUtils();
		prop = PropertyUtils.getProperty("config.properties");
		login.performlogin(prop.getProperty("username"), prop.getProperty("password"));
		waiter= homepg.navigateToPeoplePage();
	}

	@Test(priority = 1, enabled = true, groups = { "sanity" })
	public void validateTheElementInAddSupplierPopup() {
		supplier.clickOnSuplierLink();
		supplier.clickOnAddSupplierBtn();
		
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(supplier.isSupplierNameDisplayed(), AutomationConstants.addDisplayedErrorMsg);
		soft.assertTrue(supplier.isSupplierPhoneDisplayed(), AutomationConstants.addDisplayedErrorMsg);
		soft.assertTrue(supplier.isSupplierEmailDisplayed(), AutomationConstants.addDisplayedErrorMsg);
		soft.assertTrue(supplier.isSupplierNoteDisplayed(), AutomationConstants.addDisplayedErrorMsg);
		supplier.clickOnSupplierAddCloseBtn();
		soft.assertAll();

	}

	@Test(priority = 2, enabled = true, groups = { "regression" })
	public void validateAddSupplierPopUpfields() {
		
		String sname = excelutil.readStringData("PeopleSupplier",13, 2);
		String sphone = excelutil.readStringData("PeopleSupplier",14, 2);
		String semail = excelutil.readStringData("PeopleSupplier",15, 2);
		String snote = excelutil.readStringData("PeopleSupplier",15, 2);
		
		
		String rsname = excelutil.readStringData("PeopleSupplier",1, 2);
		String rsphone = excelutil.readStringData("PeopleSupplier",2, 2);
		String rsemail = excelutil.readStringData("PeopleSupplier",3,2);
		String rsnote = excelutil.readStringData("PeopleSupplier",4,2);
		
		supplier.clickOnSuplierLink();
		supplier.clickOnAddSupplierBtn();
		supplier.enterValueForSupplierName(sname);
		supplier.enterValueForSupplierEmail(semail);
		supplier.enterValueForSupplierPhone(sphone);
		supplier.enterValueForSupplierNote(snote);

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(supplier.getSupplierEmailFromSearchResult(), rsemail,
				AutomationConstants.addFeildValidateErrorMessage);
		soft.assertEquals(supplier.getSupplierPhoneFromSearchResult(),rsphone,
				AutomationConstants.addFeildValidateErrorMessage);
		soft.assertEquals(supplier.getSupplierNameFromSearchResult(),rsname,
				AutomationConstants.addFeildValidateErrorMessage);

		soft.assertAll();
	}

	@Test(priority = 3, enabled = true, groups = { "sanity" })
	public void validateValueEntredInAddSupplierPopUpIsSaved() {
		String sname = excelutil.readStringData("PeopleSupplier",1, 2);
		String sphone = excelutil.readStringData("PeopleSupplier",2, 2);
		String semail = excelutil.readStringData("PeopleSupplier",3,2);
		String snote = excelutil.readStringData("PeopleSupplier",4,2);
		
		
		supplier.clickOnSuplierLink();
		supplier.clickOnAddSupplierBtn();
		supplier.enterValueForSupplierName(sname);
		supplier.enterValueForSupplierEmail(semail);
		supplier.enterValueForSupplierPhone(sphone);
		supplier.enterValueForSupplierNote(snote);
		supplier.clickOnSupplierAddSubmitBtn();
		supplier.searchBySupplierName(sname);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(supplier.getSupplierNameFromSearchResult(),sname, AutomationConstants.errorMessage);
		soft.assertEquals(supplier.getSupplierEmailFromSearchResult(),semail,
				AutomationConstants.errorMessage);
		soft.assertEquals(supplier.getSupplierPhoneFromSearchResult(), sphone, AutomationConstants.errorMessage);

		soft.assertAll();
	}

	@Test(priority = 4, enabled = true, groups = { "smoke" })
	public void modifyTheExistingRecordOfSupplier() {
		String sname = excelutil.readStringData("PeopleSupplier",1, 2);
		String sphone = excelutil.readStringData("PeopleSupplier",2, 2);
		String semail = excelutil.readStringData("PeopleSupplier",3,2);
		
		
		String esname = excelutil.readStringData("PeopleSupplier",6, 2);
		String esphone = excelutil.readStringData("PeopleSupplier",7, 2);
		String esemail = excelutil.readStringData("PeopleSupplier",8,2);
		
		
		supplier.clickOnSuplierLink();
		supplier.searchBySupplierName(sname);
		supplier.clickOnSupplierEditIconBtn();
		supplier.enterValueForSupplierName(esname);
		supplier.enterValueForSupplierEmail(esemail);
		supplier.enterValueForSupplierPhone(esphone);
		supplier.clickOnSupplierEditSubmitBtn();
		supplier.searchBySupplierName(esname);

		SoftAssert soft = new SoftAssert();

		soft.assertEquals(supplier.getSupplierNameFromSearchResult(), sname, AutomationConstants.errorMessage);
		soft.assertEquals(supplier.getSupplierEmailFromSearchResult(),semail,
				AutomationConstants.errorMessage);
		soft.assertEquals(supplier.getSupplierPhoneFromSearchResult(),sphone, AutomationConstants.errorMessage);

		soft.assertAll();
	}

	@Test(priority = 5, enabled = true, groups = { "smoke" })
	public void validateDeleteFunctiongOfExistingRecord() {
		String sname = excelutil.readStringData("PeopleSupplier",10, 2);
		supplier.clickOnSuplierLink();
		supplier.searchBySupplierName(sname);
		supplier.clickOnSupplierDeleteIconBtn();
		supplier.clickOnSupplierDeleteConformMsg();
		supplier.searchBySupplierName(sname);
		assertEquals(supplier.getTheSearchResultOfDeletedEntry(), "No matching records found",
				AutomationConstants.deleteCheck);
	}
}
