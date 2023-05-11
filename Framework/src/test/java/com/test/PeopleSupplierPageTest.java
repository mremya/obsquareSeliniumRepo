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
import com.utils.PropertyUtils;
import com.utils.WebBrowserUtils;

public class PeopleSupplierPageTest extends AutomationBase {

	WebDriver driver;
	WebBrowserUtils webbrowser;
	LoginPage login;
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
		webbrowser = new WebBrowserUtils();
		prop = PropertyUtils.getProperty("config.properties");
		login.performlogin(prop.getProperty("username"), prop.getProperty("password"));
		waiter= homepg.navigateToPeoplePage();
	}

	@Test(priority = 1, enabled = true, groups = { "sanity" })
	public void validateTheElementInAddSupplierPopup() {
		supplier.clickOnSuplierLink();
		supplier.clickOnAddSupplierBtn();
		supplier.clickOnSupplierAddCloseBtn();
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(supplier.isSupplierNameDisplayed(), AutomationConstants.addDisplayedErrorMsg);
		soft.assertTrue(supplier.isSupplierPhoneDisplayed(), AutomationConstants.addDisplayedErrorMsg);
		soft.assertTrue(supplier.isSupplierEmailDisplayed(), AutomationConstants.addDisplayedErrorMsg);
		soft.assertTrue(supplier.isSupplierNoteDisplayed(), AutomationConstants.addDisplayedErrorMsg);
		soft.assertAll();

	}

	@Test(priority = 2, enabled = true, groups = { "regression" })
	public void validateAddSupplierPopUpfields() {
		supplier.clickOnSuplierLink();
		supplier.clickOnAddSupplierBtn();
		supplier.enterValueForSupplierName("Anjali");
		supplier.enterValueForSupplierEmail("##@gmail.com");
		supplier.enterValueForSupplierPhone("1475");
		supplier.enterValueForSupplierNote("Hello");

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(supplier.getSupplierEmailFromSearchResult(), "abc@gmail.com",
				AutomationConstants.addFeildValidateErrorMessage);
		soft.assertEquals(supplier.getSupplierPhoneFromSearchResult(), "1234567894",
				AutomationConstants.addFeildValidateErrorMessage);
		soft.assertEquals(supplier.getSupplierNameFromSearchResult(), "Anjali",
				AutomationConstants.addFeildValidateErrorMessage);

		soft.assertAll();
	}

	@Test(priority = 3, enabled = true, groups = { "sanity" })
	public void validateValueEntredInAddSupplierPopUpIsSaved() {
		supplier.clickOnSuplierLink();
		supplier.clickOnAddSupplierBtn();
		supplier.enterValueForSupplierName("Rakesh");
		supplier.enterValueForSupplierEmail("abc@gmail.com");
		supplier.enterValueForSupplierPhone("147545687");
		supplier.enterValueForSupplierNote("Hello");
		supplier.clickOnSupplierAddSubmitBtn();
		supplier.searchBySupplierName("Rakesh");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(supplier.getSupplierNameFromSearchResult(), "Rakesh", AutomationConstants.errorMessage);
		soft.assertEquals(supplier.getSupplierEmailFromSearchResult(), "abc@gmail.com",
				AutomationConstants.errorMessage);
		soft.assertEquals(supplier.getSupplierPhoneFromSearchResult(), "147545687", AutomationConstants.errorMessage);

		soft.assertAll();
	}

	@Test(priority = 4, enabled = true, groups = { "smoke" })
	public void modifyTheExistingRecordOfSupplier() {
		supplier.clickOnSuplierLink();
		supplier.searchBySupplierName("Rakesh");
		supplier.clickOnSupplierEditIconBtn();
		supplier.enterValueForSupplierName("Rakesh");
		supplier.enterValueForSupplierEmail("pqr@gmail.com");
		supplier.enterValueForSupplierPhone("2255884417");
		supplier.clickOnSupplierEditSubmitBtn();
		supplier.searchBySupplierName("Rakesh");

		SoftAssert soft = new SoftAssert();

		soft.assertEquals(supplier.getSupplierNameFromSearchResult(), "Rakesh", AutomationConstants.errorMessage);
		soft.assertEquals(supplier.getSupplierEmailFromSearchResult(), "pqr@gmail.com",
				AutomationConstants.errorMessage);
		soft.assertEquals(supplier.getSupplierPhoneFromSearchResult(), "2255884417", AutomationConstants.errorMessage);

		soft.assertAll();
	}

	@Test(priority = 5, enabled = true, groups = { "smoke" })
	public void validateDeleteFunctiongOfExistingRecord() {
		supplier.clickOnSuplierLink();
		supplier.searchBySupplierName("Rakesh");
		supplier.clickOnSupplierDeleteIconBtn();
		supplier.clickOnSupplierDeleteConformMsg();
		supplier.searchBySupplierName("Rakesh");
		assertEquals(supplier.getTheSearchResultOfDeletedEntry(), "No matching records found",
				AutomationConstants.deleteCheck);
	}
}
