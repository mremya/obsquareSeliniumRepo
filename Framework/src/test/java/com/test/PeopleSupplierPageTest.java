package com.test;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
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
		prop=PropertyUtils.getProperty("config.properties");
		login.performlogin(prop.getProperty("username"), prop.getProperty("password"));
		ppage = homepg.navigateToProductPage();
		storepage = ppage.navigateToStoresPage();
		waiter = storepage.navigateToPeoplePage();

	}

	@Test(priority = 1, enabled = true ,groups= {"sanity"})
	public void validateTheElementInAddSupplierPopup() {
		supplier.clickOnSuplierLink();
		supplier.clickOnAddSupplierBtn();
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(supplier.isSupplierNameDisplayed(), "Failure message::supplier name is not displayed");
		soft.assertTrue(supplier.isSupplierPhoneDisplayed(), "Failure message::supplier Phone  is not displayed");
		soft.assertTrue(supplier.isSupplierEmailDisplayed(), "Failure message::supplier Email  is not displayed");
		soft.assertTrue(supplier.isSupplierNoteDisplayed(), "Failure message::supplier note  is not displayed");
		soft.assertAll();

	}

	@Test(priority = 2, enabled = true ,groups= {"regression"})
	public void validateAddSupplierPopUpfields() {
		supplier.clickOnSuplierLink();
		supplier.clickOnAddSupplierBtn();
		supplier.enterValueForSupplierName("Anjali");
		supplier.enterValueForSupplierEmail("##@gmail.com");
		supplier.enterValueForSupplierPhone("1475");
		supplier.enterValueForSupplierNote("Hello");

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(supplier.getSupplierEmailFromSearchResult(), "abc@gmail.com",
				"failure message: supplier email is not in format");
		soft.assertEquals(supplier.getSupplierPhoneFromSearchResult(), "1234567894",
				"failure message:  supplier phone is not informat ");
		soft.assertEquals(supplier.getSupplierNameFromSearchResult(), "Anjali",
				"failure message:  supplier name mismatch ");

		soft.assertAll();
	}

	@Test(priority = 3, enabled = true ,groups= {"sanity"})
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
		soft.assertEquals(supplier.getSupplierNameFromSearchResult(), "Rakesh",
				"failure message:mismatch in the supplier name search result");
		soft.assertEquals(supplier.getSupplierEmailFromSearchResult(), "abc@gmail.com",
				"failure message: mismatch in the supplier Email search result");
		soft.assertEquals(supplier.getSupplierPhoneFromSearchResult(), "147545687",
				"failure message:mismatch in the supplier Phone search result");

		soft.assertAll();
	}

	@Test(priority = 4, enabled = true ,groups= {"smoke"})
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

		soft.assertEquals(supplier.getSupplierNameFromSearchResult(), "Rakesh",
				"failure message:mismatch in the supplier name search result");
		soft.assertEquals(supplier.getSupplierEmailFromSearchResult(), "pqr@gmail.com",
				"failure message: mismatch in the supplier Email search result");
		soft.assertEquals(supplier.getSupplierPhoneFromSearchResult(), "2255884417",
				"failure message:mismatch in the supplier Phone search result");

		soft.assertAll();
	}
	
	@Test(priority = 5, enabled = true ,groups= {"smoke"})
	public void validateDeleteFunctiongOfExistingRecord() {
		supplier.clickOnSuplierLink();
		supplier.searchBySupplierName("Rakesh");
		supplier.clickOnSupplierDeleteIconBtn();
		supplier.clickOnSupplierDeleteConformMsg();
		supplier.searchBySupplierName("Rakesh");
		assertEquals(supplier.getTheSearchResultOfDeletedEntry(), "No matching records found",
				"failure message:: failed to delete the supplier entry");
	}
}

