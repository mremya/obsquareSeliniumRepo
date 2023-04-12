package com.test;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.PeopleCustomerPage;
import com.pages.PeopleWaiterPage;
import com.pages.ProductPage;
import com.pages.StoresPage;
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

	@BeforeMethod
	public void prerun() throws Exception {
		driver = getDriver();
		login = new LoginPage(driver);
		webbrowser = new WebBrowserUtils();
		webbrowser.launchUrl(driver, "https://qalegend.com/restaurant/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		homepg = login.login("admin", "password");
		ppage = homepg.navigateToProductPage();
		storepage = ppage.navigateToStoresPage();
		waiter = storepage.navigateToPeoplePage();
		// customer= storepage.navigateToPeoplePage();
	}

	@Test(priority = 1, enabled = true)
	public void validateTheElementInAddCustomerPopup() {
		customer.clickOnCustomerLink();
		customer.clickOnAddCustomerBtn();

		SoftAssert soft = new SoftAssert();
		soft.assertTrue(customer.isCustomerNameDisplayed(), "Failure message::customer name is not displayed");
		soft.assertTrue(customer.isCustomerPhoneDisplayed(), "Failure message::customer Phone  is not displayed");
		soft.assertTrue(customer.isCustomerEmailDisplayed(), "Failure message::customer Email  is not displayed");
		soft.assertTrue(customer.isCustomerDiscountDisplayed(), "Failure message::customer discount  is not displayed");
		soft.assertAll();

	}

	@Test(priority = 2, enabled = true)
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
				"failure message: customer email is not informat");
		soft.assertEquals(customer.getCustomerPhoneFromSearchResult(), "1234567894",
				"failure message:customer phone is not informat ");
		soft.assertEquals(customer.getCustomerDiscountFromSearchResult(), "12",
				"failure message:customer discount is not informat ");

		soft.assertAll();
	}

	@Test(priority = 3, enabled = true)
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
		soft.assertEquals(customer.getcustomerNameFromSearchResult(), "Anish",
				"failure message:mismatch in the customer name search result");
		soft.assertEquals(customer.getCustomerEmailFromSearchResult(), "abc@gmail.com",
				"failure message: mismatch in the customer Email search result");
		soft.assertEquals(customer.getCustomerPhoneFromSearchResult(), "147545687",
				"failure message:mismatch in the customer Phone search result");
		soft.assertEquals(customer.getCustomerDiscountFromSearchResult(), "10",
				"failure message: mismatch in the customer discount search result");
		soft.assertAll();
	}

	@Test(priority = 4, enabled = true)
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
		soft.assertEquals(customer.getcustomerNameFromSearchResult(), "Anish",
				"failure message:mismatch in the customer name search result");
		soft.assertEquals(customer.getCustomerEmailFromSearchResult(), "anuj@gmail.com",
				"failure message: mismatch in the customer Email search result");
		soft.assertEquals(customer.getCustomerPhoneFromSearchResult(), "4567531821",
				"failure message:mismatch in the customer Phone search result");
		soft.assertEquals(customer.getCustomerDiscountFromSearchResult(), "2",
				"failure message: mismatch in the customer discount search result");
		soft.assertAll();
	}

	@Test(priority = 5, enabled = true)
	public void validateDeleteFunctiongOfExistingRecord() {
		customer.clickOnCustomerLink();
		customer.searchByCustomerName("Anish");
		customer.clickOnCustomerDeleteIconBtn();
		customer.clickOnCustomerDeleteConformMsgBtn();
		customer.searchByCustomerName("Anish");
		assertEquals(customer.getTheSearchResultOfDeletedEntry(), "No matching records found",
				"failure message:: failed to delete the customer entry");
	}

}
