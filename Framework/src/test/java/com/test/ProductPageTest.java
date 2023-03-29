package com.test;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBee;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ProductPage;
import com.utils.WebBrowserUtils;

public class ProductPageTest extends AutomationBee {

	WebDriver driver;
	WebBrowserUtils webbrowser;
	LoginPage login;
	HomePage homepg;
	ProductPage ppage;

	@BeforeMethod
	public void prerun() throws Exception {
		driver = getDriver();
		login = new LoginPage(driver);
		webbrowser = new WebBrowserUtils();
		webbrowser.launchUrl(driver, "https://qalegend.com/restaurant/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		homepg = login.login("admin", "password");
		ppage = homepg.navigateToProductPage();

	}

	@Test(priority = 1, enabled = true)
	public void validateTheElementInAddProductPopup() {

		ppage.clickOnAddProduct();

		SoftAssert soft = new SoftAssert();
		soft.assertTrue(ppage.isProductTypeDisplayed(), "Failure message::product type is not displayed");
		soft.assertTrue(ppage.isproductCodeDisplayed(), "Failure message::product code  is not displayed");
		soft.assertTrue(ppage.isProductCategoryDisplayed(), "Failure message::product category  is not displayed");
		soft.assertTrue(ppage.isProductNameDisplayed(), "Failure message::product name  is not displayed");
		soft.assertTrue(ppage.isProductSupplierDisplayed(), "Failure message::product supplier  is not displayed");
		soft.assertTrue(ppage.isProductPurchasePriceDisplayed(),
				"Failure message::product purchase price  is not displayed");
		soft.assertTrue(ppage.isProductUnitDisplayed(), "Failure message::product unit  is not displayed");
		soft.assertTrue(ppage.isProductPriceDisplayed(), "Failure message::product price  is not displayed");
		soft.assertTrue(ppage.isProductTaxDisplayed(), "Failure message::product tax  is not displayed");
		soft.assertTrue(ppage.isProductTaxMethodDisplayed(), "Failure message::product tax Method is not displayed");
		soft.assertTrue(ppage.isProductAlertQuantityDisplayed(),
				"Failure message::product alert quantity  is not displayed");
		soft.assertTrue(ppage.isProductOptionsDisplayed(), "Failure message::product option is not displayed");
		soft.assertAll();

	}

	@Test(priority = 2, enabled = true)
	public void validateValueEntredInAddProductPopUpIsSaved() {
		ppage.clickOnAddProduct();
		ppage.selectValueForProductType("Standard");
		ppage.enterValueForProductCode("1212");
		ppage.enterValueForProductName("Maza");
		ppage.selectValueForProductCategory("fruits");
		ppage.selectValueForProductSupplier("anu");
		ppage.enterValueForProductPurchasePrice("10.00");
		ppage.enterValueForProductTax("10");
		ppage.selectValueForProductTaxMethod("inclusive");
		ppage.enterValueForProductPrice("10");
		ppage.enterValueForProductUnit("Laza");
		ppage.selectValueForProductAlertQuantity("10");
		ppage.enterValueForProductDescription("Hello");
		ppage.clickOnAddProductSubmit();
		ppage.searchByProductCode("1212");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(ppage.getProductCodeFromSearchResult(), "1212", "failure message: product code not found");
		soft.assertEquals(ppage.getProductNameFromSearchResult(), "Maza", "failure message: product Name not found");
		soft.assertEquals(ppage.getProductCategoryFromSearchResult(), "fruits",
				"failure message: product fruits not found");
		soft.assertEquals(ppage.getProductProductDescriptionFromSearchResult(), "hello",
				"failure message: product description not found");
		soft.assertEquals(ppage.getProductTaxFromSearchResult(), "10", "failure message: product tax not found");
		soft.assertEquals(ppage.getProductPriceFromSearchResult(), "10", "failure message: product price not found");
		soft.assertAll();
	}

	@Test(priority = 3, enabled = true)
	public void validateEditFunctionOfExistingRecord() {
		ppage.searchByProductCode("1234");
		ppage.clickOnEditProduct();
		ppage.enterValueForProductName("Cake World");
		ppage.selectValueForProductCategory("burger");
		ppage.enterValueForProductDescription("Hello");
		ppage.clickOnEditProductSubmit();
		ppage.searchByProductCode("1234");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(ppage.getProductCodeFromSearchResult(), "1234", "failure message: product code not modified");
		soft.assertEquals(ppage.getProductNameFromSearchResult(), "Cake World",
				"failure message: product Name is modified");
		soft.assertEquals(ppage.getProductCategoryFromSearchResult(), "fruits",
				"failure message: product category is mofied");
		soft.assertEquals(ppage.getProductProductDescriptionFromSearchResult(), "hello",
				"failure message: product description not found");
		soft.assertEquals(ppage.getProductTaxFromSearchResult(), "20", "failure message: product tax not found");
		soft.assertEquals(ppage.getProductPriceFromSearchResult(), "20", "failure message: product price not found");
		soft.assertAll();

	}

	@Test(priority = 4, enabled = true)
	public void validateDeleteFunctiongOfExistingRecord() {

		ppage.searchByProductCode("1234");
		ppage.clickOnProductDeleteIcon();
		ppage.clickOnDeleteConformMsg();
		ppage.searchByProductCode("1234");
		assertEquals(ppage.getProductSearchResultOfDeletedEntry(), "No matching records found",
				"failure message:: failed to delete the store entry");
	}

}
