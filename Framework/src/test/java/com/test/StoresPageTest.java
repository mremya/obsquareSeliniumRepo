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
	HomePage homepg;
	ProductPage ppage;
	StoresPage storepage;
	WebActionUtils webaction;
	Properties prop;

	@BeforeMethod
	public void prerun() throws Exception {
		
		driver = getDriver();
		login = new LoginPage(driver);
		webbrowser = new WebBrowserUtils();
		prop=PropertyUtils.getProperty("config.properties");
		login.performlogin(prop.getProperty("username"), prop.getProperty("password"));
		ppage = homepg.navigateToProductPage();
		storepage=ppage.navigateToStoresPage();

	}

	@Test(priority = 1, enabled = true)
	public void validateTheElementInAddStorePopup() {

		storepage.clickOnAddStores();
		
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(storepage.isStoreNameDisplayed(), "Failure message::Store name is not displayed");
		soft.assertTrue(storepage.isStoreEmailDisplayed(), "Failure message::Stores email  is not displayed");
		soft.assertTrue(storepage.isStorePhoneDisplayed(), "Failure message::Stores phone  is not displayed");
		soft.assertTrue(storepage.isAddStoreDisplayed(), "Failure message::Store city is not displayed");
		soft.assertTrue(storepage.isStoreCountryDisplayed(), "Failure message::Stores Country  is not displayed");
		soft.assertTrue(storepage.isStoreCustomerFooterDisplayed(), "Failure message::Stores custormer footer  is not displayed");
		soft.assertTrue(storepage.isStoreAddressDisplayed(), "Failure message::Stores address  is not displayed");
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
	storepage.searchByStoreName("althaf");;
	SoftAssert soft = new SoftAssert();
	soft.assertEquals(storepage.getStoreNameFromSearchResult(), "althaf", "failure message: store name not found");
	soft.assertEquals(storepage.getStoreEmailFromSearchResult(), "abc@gmail.com", "failure message: store email not found");
	soft.assertEquals(storepage.getStorePhoneFromSearchResult(), "1234567894", "failure message: store phone not found");
	soft.assertEquals(storepage.getStoreCityFromSearchResult(), "Trivandrum", "failure message: store city not found");
	soft.assertEquals(storepage.getStoreCountryFromSearchResult(), "India", "failure message: store country not found");
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
		
	soft.assertEquals(storepage.getStoreNameFromSearchResult(), "cake world","failure message ::store name is not modified");
	soft.assertEquals(storepage.getStoreEmailFromSearchResult(), "alpha@gmail.com","failure message::store email is not modified");
	soft.assertEquals(storepage.getStorePhoneFromSearchResult(), "7894561234","failure message:: store phone is not modified");
	soft.assertEquals(storepage.getStoreCityFromSearchResult(), "lanka","failure message :: store city is modified");
	soft.assertEquals(storepage.getStoreCountryFromSearchResult(), "sri lanka","failure message :: store Country is modified");
	soft.assertAll();
	}
	

@Test(priority = 5, enabled = true)
public void deleteExistingRecord() {
	storepage.searchByStoreName("alsaj");
	storepage.clickOnDeleteIcon();
	storepage.searchByStoreName("alsaj");
	assertEquals(storepage.getTheSearchResultOfDeletedEntry(), "No matching records found","failure message:: failed to delete the store entry");;
	
}

@Test(priority = 2, enabled = true)
public void validatenAddStoresPopUpfields() {
	storepage.clickOnAddStores();
storepage.enterValueForStoreName("Alfy");
storepage.enterValueForStoreEmail("abc@gm@il.com");
storepage.enterValueForStorePhone("123456789445789");

storepage.clickOnAddStoresSubmit();
storepage.searchByStoreName("althaf");;
SoftAssert soft = new SoftAssert();
soft.assertEquals(storepage.getStoreNameFromSearchResult(), "Alfy", "failure message: store name not found");
soft.assertEquals(storepage.getStoreEmailFromSearchResult(), "abc@gmail.com", "failure message: store email is not informat");
soft.assertEquals(storepage.getStorePhoneFromSearchResult(), "1234567894", "failure message: store phone should be of 10digit ");

soft.assertAll();
}

}
