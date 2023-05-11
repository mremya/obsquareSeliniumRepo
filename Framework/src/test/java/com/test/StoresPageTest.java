package com.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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
import com.pages.ProductPage;
import com.pages.StoresPage;
import com.utils.ExcelUtils;
import com.utils.PropertyUtils;
import com.utils.WebActionUtils;
import com.utils.WebBrowserUtils;

public class StoresPageTest extends AutomationBase {
	WebDriver driver;
	WebBrowserUtils webbrowser;
	LoginPage login;
	HomePage hpage;
	ProductPage ppage;
	StoresPage storepage;
	WebActionUtils webaction;
	Properties prop;

	@BeforeMethod
	public void prerun() throws Exception {

		driver = getDriver();
		login = new LoginPage(driver);
		hpage = new HomePage(driver);
		ppage = new ProductPage(driver);
		webbrowser = new WebBrowserUtils();
		prop = PropertyUtils.getProperty("config.properties");
		login.performlogin(prop.getProperty("username"), prop.getProperty("password"));
		storepage=hpage.navigateToStoresPage();

	}

	@Test(priority = 1, enabled = true)
	public void validateTheElementInAddStorePopup() {

		storepage.clickOnAddStores();
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(storepage.isStoreNameDisplayed(), AutomationConstants.addFeildValidateErrorMessage);
		soft.assertTrue(storepage.isStoreEmailDisplayed(), AutomationConstants.addFeildValidateErrorMessage);
		soft.assertTrue(storepage.isStorePhoneDisplayed(), AutomationConstants.addFeildValidateErrorMessage);
		soft.assertTrue(storepage.isAddStoreDisplayed(), AutomationConstants.addFeildValidateErrorMessage);
		soft.assertTrue(storepage.isStoreCountryDisplayed(), AutomationConstants.addFeildValidateErrorMessage);
		soft.assertTrue(storepage.isStoreCustomerFooterDisplayed(), AutomationConstants.addFeildValidateErrorMessage);
		soft.assertTrue(storepage.isStoreAddressDisplayed(), AutomationConstants.addFeildValidateErrorMessage);
		storepage.clickOnstoreAddCloseBtn();
		soft.assertAll();

	}

	@Test(priority = 3, enabled = true)
	public void validateEnteredValueInAddStoresPopUpIsSaved() {
		storepage.clickOnAddStores();
		storepage.enterValueForStoreName("althaf");
		storepage.enterValueForStoreEmail("abc@gmail.com");
		storepage.enterValueForStorePhone("1234567894");
		storepage.enterValueForStoreAddress("kerala");
		storepage.enterValueForStoreCity("Trivandrum");
		storepage.enterValueForStoreCountry("India");
		storepage.enterValueForStoreCustomerFooter("made by althaf");
		storepage.clickOnAddStoresSubmit();
		storepage.searchByStoreName("althaf");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(storepage.getStoreNameFromSearchResult(), "althaf", AutomationConstants.errorMessage);
		soft.assertEquals(storepage.getStoreEmailFromSearchResult(), "abc@gmail.com", AutomationConstants.errorMessage);
		soft.assertEquals(storepage.getStorePhoneFromSearchResult(), "1234567894", AutomationConstants.errorMessage);
		soft.assertEquals(storepage.getStoreCityFromSearchResult(), "Trivandrum", AutomationConstants.errorMessage);
		soft.assertEquals(storepage.getStoreCountryFromSearchResult(), "India", AutomationConstants.errorMessage);
		soft.assertAll();
	}

	@Test(priority = 4, enabled = true)
	public void modifyTheExistingRecordOfStores() {
		storepage.searchByStoreName("cake world");
		storepage.clickOnEditIcon();
		storepage.enterValueForStoreCountry("India");
		storepage.enterValueForStoreCity("Pune");
		storepage.clickOnEditSubmitIcon();
		storepage.searchByStoreName("cake world");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(storepage.getStoreNameFromSearchResult(), "cake world", AutomationConstants.errorMessage);
		soft.assertEquals(storepage.getStoreEmailFromSearchResult(), "alpha@gmail.com",AutomationConstants.errorMessage);
		soft.assertEquals(storepage.getStorePhoneFromSearchResult(), "7894561234", AutomationConstants.errorMessage);
		soft.assertEquals(storepage.getStoreCityFromSearchResult(), "lanka", AutomationConstants.errorMessage);
		soft.assertEquals(storepage.getStoreCountryFromSearchResult(), "sri lanka", AutomationConstants.errorMessage);
		soft.assertAll();
	}

	@Test(priority = 5, enabled = true)
	public void deleteExistingRecord() {
		storepage.searchByStoreName("alsaj");
		storepage.clickOnDeleteIcon();
		storepage.searchByStoreName("alsaj");
		assertEquals(storepage.getTheSearchResultOfDeletedEntry(), "No matching records found",
				AutomationConstants.deleteCheck);

	}

	@Test(priority = 2, enabled = true)
	public void validatenAddStoresPopUpfields() {
		storepage.clickOnAddStores();
		storepage.enterValueForStoreName("Alfy");
		storepage.enterValueForStoreEmail("abc@gm@il.com");
		storepage.enterValueForStorePhone("123456789445789");
		storepage.clickOnAddStoresSubmit();
		storepage.searchByStoreName("althaf");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(storepage.getStoreNameFromSearchResult(), "Alfy", AutomationConstants.errorMessage);
		soft.assertEquals(storepage.getStoreEmailFromSearchResult(), "abc@gmail.com", AutomationConstants.errorMessage);
		soft.assertEquals(storepage.getStorePhoneFromSearchResult(), "1234567894", AutomationConstants.errorMessage);
		soft.assertAll();
	}

}
