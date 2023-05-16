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
	ExcelUtils excelutil;
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
		excelutil = new ExcelUtils();
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
		String sname = excelutil.readStringData("Store",1,2);
		String semail = excelutil.readStringData("Store",2,2);
		String sphone = excelutil.readStringData("Store",3,2);
		String scountry = excelutil.readStringData("Store",4,2);
		String scity = excelutil.readStringData("Store",5,2);
		String saddress= excelutil.readStringData("Store",6,2);
		String sfooter= excelutil.readStringData("Store",7,2);
		
		storepage.clickOnAddStores();
		storepage.enterValueForStoreName(sname);
		storepage.enterValueForStoreEmail(semail);
		storepage.enterValueForStorePhone(sphone);
		storepage.enterValueForStoreAddress(scountry);
		storepage.enterValueForStoreCity(scity);
		storepage.enterValueForStoreCountry(saddress);
		storepage.enterValueForStoreCustomerFooter(sfooter);
		storepage.clickOnAddStoresSubmit();
		storepage.searchByStoreName(sname);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(storepage.getStoreNameFromSearchResult(), sname, AutomationConstants.errorMessage);
		soft.assertEquals(storepage.getStoreEmailFromSearchResult(), semail, AutomationConstants.errorMessage);
		soft.assertEquals(storepage.getStorePhoneFromSearchResult(),sphone, AutomationConstants.errorMessage);
		soft.assertEquals(storepage.getStoreCityFromSearchResult(), scity, AutomationConstants.errorMessage);
		soft.assertEquals(storepage.getStoreCountryFromSearchResult(),scountry, AutomationConstants.errorMessage);
		soft.assertAll();
	}

	@Test(priority = 4, enabled = true)
	public void modifyTheExistingRecordOfStores() {
		String sname = excelutil.readStringData("Store",10,2);
		String semail = excelutil.readStringData("Store",11,2);
		String sphone = excelutil.readStringData("Store",12,2);
		String scountry = excelutil.readStringData("Store",13,2);
		String scity = excelutil.readStringData("Store",14,2);
		String saddress= excelutil.readStringData("Store",15,2);
		
		
		storepage.searchByStoreName(sname);
		storepage.clickOnEditIcon();
		storepage.enterValueForStoreName(sname);
		storepage.enterValueForStoreEmail(semail);
		storepage.enterValueForStorePhone(sphone);
		storepage.enterValueForStoreCountry(scountry);
		storepage.enterValueForStoreCity(scity);
		storepage.enterValueForStoreCountry(saddress);
		storepage.clickOnEditSubmitIcon();
		storepage.searchByStoreName(sname);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(storepage.getStoreNameFromSearchResult(),sname, AutomationConstants.errorMessage);
		soft.assertEquals(storepage.getStoreEmailFromSearchResult(),semail,AutomationConstants.errorMessage);
		soft.assertEquals(storepage.getStorePhoneFromSearchResult(), sphone, AutomationConstants.errorMessage);
		soft.assertEquals(storepage.getStoreCityFromSearchResult(), scity, AutomationConstants.errorMessage);
		soft.assertEquals(storepage.getStoreCountryFromSearchResult(),scountry, AutomationConstants.errorMessage);
		soft.assertAll();
	}

	@Test(priority = 5, enabled = true)
	public void deleteExistingRecord() {
		String sname = excelutil.readStringData("Store",18,2);
		storepage.enterValueForStoreName(sname);
		storepage.searchByStoreName(sname);
		storepage.clickOnDeleteIcon();
		storepage.searchByStoreName(sname);
		assertEquals(storepage.getTheSearchResultOfDeletedEntry(), "No matching records found",
				AutomationConstants.deleteCheck);

	}

	@Test(priority = 2, enabled = true)
	public void validatenAddStoresPopUpfields() {
		String sname = excelutil.readStringData("Store",21,2);
		String semail = excelutil.readStringData("Store",22,2);
		String sphone = excelutil.readStringData("Store",23,2);
		storepage.enterValueForStoreName(sname);
		storepage.enterValueForStoreEmail(semail);
		storepage.enterValueForStorePhone(sphone);
		storepage.clickOnAddStores();
		storepage.enterValueForStoreName(sname);
		storepage.enterValueForStoreEmail(semail);
		storepage.enterValueForStorePhone(sphone);
		storepage.clickOnAddStoresSubmit();
		storepage.searchByStoreName(sname);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(storepage.getStoreNameFromSearchResult(), sname, AutomationConstants.errorMessage);
		soft.assertEquals(storepage.getStoreEmailFromSearchResult(),semail, AutomationConstants.errorMessage);
		soft.assertEquals(storepage.getStorePhoneFromSearchResult(),sphone, AutomationConstants.errorMessage);
		soft.assertAll();
	}

}
