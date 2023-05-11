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
import com.pages.PeopleWaiterPage;
import com.pages.ProductPage;
import com.pages.StoresPage;
import com.utils.PropertyUtils;
import com.utils.WebBrowserUtils;

public class PeopleCoustomerPageTest extends AutomationBase {

	WebDriver driver;
	WebBrowserUtils webbrowser;
	LoginPage login;
	HomePage homepg;
	ProductPage ppage;
	StoresPage storepage;
	PeopleWaiterPage waiter;
	PeopleCustomerPage customer;
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
	public void validateTheElementInAddCustomerPopup() {
		customer.clickOnCustomerLink();
		customer.clickOnAddCustomerBtn();
		customer.clickOnAddCustomerCloseBtn();
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(customer.isCustomerNameDisplayed(), "Failure message::customer name is not displayed");
		soft.assertTrue(customer.isCustomerPhoneDisplayed(), "Failure message::customer Phone  is not displayed");
		soft.assertTrue(customer.isCustomerEmailDisplayed(), "Failure message::customer Email  is not displayed");
		soft.assertTrue(customer.isCustomerDiscountDisplayed(), "Failure message::customer discount  is not displayed");
		soft.assertAll();

	}

	@Test(priority = 2, enabled = true, groups = { "smoke", "sanity" })
	public void validateAddCustomerPopUpfields() {
		customer.clickOnCustomerLink();
		customer.clickOnAddCustomerBtn();
		customer.enterValueForCustomerName("Anish");
		customer.enterValueForCustomerEmail("##@gmail.com");
		customer.enterValueForCustomerPhone("1475");
		customer.enterValueForCustomerDiscount("abc");
		customer.searchByCustomerName("Anish");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(customer.getCustomerEmailFromSearchResult(), "abc@gmail.com",
				AutomationConstants.addFeildValidateErrorMessage);
		soft.assertEquals(customer.getCustomerPhoneFromSearchResult(), "1234567894",
				AutomationConstants.addFeildValidateErrorMessage);
		soft.assertEquals(customer.getCustomerDiscountFromSearchResult(), "12",
				AutomationConstants.addFeildValidateErrorMessage);
		soft.assertAll();
	}

	@Test(priority = 3, enabled = true, groups = { "smoke", "regression" })
	public void validateValueEntredInAddWaiterPopUpIsSaved() {
		customer.clickOnCustomerLink();
		customer.clickOnAddCustomerBtn();
		customer.enterValueForCustomerName("Anish");
		customer.enterValueForCustomerEmail("abc@gmail.com");
		customer.enterValueForCustomerPhone("147545687");
		customer.enterValueForCustomerDiscount("10");
		customer.clickOnAddCustomerSubmitBtn();
		customer.searchByCustomerName("Anish");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(customer.getcustomerNameFromSearchResult(), "Anish", AutomationConstants.errorMessage);
		soft.assertEquals(customer.getCustomerEmailFromSearchResult(), "abc@gmail.com",
				AutomationConstants.errorMessage);
		soft.assertEquals(customer.getCustomerPhoneFromSearchResult(), "147545687", AutomationConstants.errorMessage);
		soft.assertEquals(customer.getCustomerDiscountFromSearchResult(), "10", AutomationConstants.errorMessage);
		soft.assertAll();
	}

	@Test(priority = 4, enabled = true, groups = { "regression" })
	public void modifyTheExistingRecordOfStores() {

		customer.clickOnCustomerLink();
		customer.searchByCustomerName("Anish");
		customer.clickOnCustomerEditIconBtn();
		customer.enterValueForCustomerDiscount("2");
		customer.enterValueForCustomerEmail("anuj@gmail.com");
		customer.enterValueForCustomerPhone("4567531821");
		customer.clickOnCustomerEditSubmit();
		customer.searchByCustomerName("Anish");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(customer.getcustomerNameFromSearchResult(), "Anish", AutomationConstants.errorMessage);
		soft.assertEquals(customer.getCustomerEmailFromSearchResult(), "anuj@gmail.com",
				AutomationConstants.errorMessage);
		soft.assertEquals(customer.getCustomerPhoneFromSearchResult(), "4567531821", AutomationConstants.errorMessage);
		soft.assertEquals(customer.getCustomerDiscountFromSearchResult(), "2", AutomationConstants.errorMessage);
		soft.assertAll();
	}

	@Test(priority = 5, enabled = true, groups = { "smoke" })
	public void validateDeleteFunctiongOfExistingRecord() {
		customer.clickOnCustomerLink();
		customer.searchByCustomerName("Anish");
		customer.clickOnCustomerDeleteIconBtn();
		customer.clickOnCustomerDeleteConformMsgBtn();
		customer.searchByCustomerName("Anish");
		assertEquals(customer.getTheSearchResultOfDeletedEntry(), "No matching records found",
				AutomationConstants.deleteCheck);
	}

}
