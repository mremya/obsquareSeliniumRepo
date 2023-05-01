package com.test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ProductPage;
import com.utils.ExcelUtils;
import com.utils.PropertyUtils;
import com.utils.WebBrowserUtils;

public class ProductPageTest extends AutomationBase {
	
	ExcelUtils excelutil;

	WebDriver driver;
	WebBrowserUtils webbrowser;
	LoginPage login;
	HomePage homepg;
	ProductPage ppage;
	Properties prop;

	@BeforeMethod
	public void prerun() throws Exception {
		excelutil=new ExcelUtils( );
		driver = getDriver();
		login = new LoginPage(driver);
		webbrowser = new WebBrowserUtils();
		
		prop=PropertyUtils.getProperty("config.properties");
		login.performlogin(prop.getProperty("username"), prop.getProperty("password"));
		
		
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
	public void validatenAddStoresPopUpfields() {
		ppage.clickOnAddProduct();
		ppage.selectValueForProductType("Standard");
		ppage.enterValueForProductCode("111");         //doubt cannot convert to int
		ppage.enterValueForProductName("maggi");
		ppage.enterValueForProductTax("abc");
		ppage.selectValueForProductAlertQuantity("abc");
		
		ppage.clickOnAddProductSubmit();
		ppage.searchByProductCode("111");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(ppage.getProductCodeFromSearchResult(), "111", "failure message: product code not found");
		soft.assertEquals(ppage.getProductNameFromSearchResult(), "maggi", "failure message: product Name not found");
		
		soft.assertEquals(ppage.getProductTaxFromSearchResult(), "abc", "failure message: product tax not in format  found");
		soft.assertEquals(ppage.getProductPriceFromSearchResult(), "abc", "failure message: product price not is in format found");
		soft.assertAll();
	soft.assertAll();
	}

	@Test(priority = 3, enabled = true)
	
	public void validateValueEntredInAddProductPopUpIsSaved() throws IOException {
		ppage.clickOnAddProduct();
		String ptype = excelutil.readStringData(1, 2);
		String pcode = excelutil.readStringData(2, 2);
		String pname = excelutil.readStringData(3, 2);
		String pcategory = excelutil.readStringData( 4, 2);
		String psupplier = excelutil.readStringData( 5, 2);
		String ppurchasedPrice = excelutil.readStringData (6, 2);
		String ptax = excelutil.readStringData( 7, 2);
		String ptaxMethod = excelutil.readStringData( 8, 2);
		String pprice = excelutil.readStringData( 9, 2);
		String punit = excelutil.readStringData( 10, 2);
		String palertQuantity = excelutil.readStringData(11, 2);
		String pdescription = excelutil.readStringData(12, 2);
	  
	  ppage.selectValueForProductType(ptype);
	  ppage.enterValueForProductCode(pcode); //doubt cannot convert to int
	  ppage.enterValueForProductName(pname);
	  ppage.selectValueForProductCategory(pcategory);
	  ppage.selectValueForProductSupplier(psupplier);
	  ppage.enterValueForProductPurchasePrice(ppurchasedPrice);
	  ppage.enterValueForProductTax(ptax);
	  ppage.selectValueForProductTaxMethod(ptaxMethod);
	  ppage.enterValueForProductPrice(pprice);
	  ppage.enterValueForProductUnit(punit);
	  ppage.selectValueForProductAlertQuantity(palertQuantity);
	  ppage.enterValueForProductDescription(pdescription);
	  ppage.clickOnAddProductSubmit(); ppage.searchByProductCode(pcode); SoftAssert
	  soft = new SoftAssert();
	  soft.assertEquals(ppage.getProductCodeFromSearchResult(), pcode,
	  "failure message: product code not found");
	  soft.assertEquals(ppage.getProductNameFromSearchResult(), pname,
	  "failure message: product Name not found");
	  soft.assertEquals(ppage.getProductCategoryFromSearchResult(), pcategory,
	  "failure message: product fruits not found");
	  soft.assertEquals(ppage.getProductProductDescriptionFromSearchResult(),
	  pdescription , "failure message: product description not found");
	  soft.assertEquals(ppage.getProductTaxFromSearchResult(), ptax,
	  "failure message: product tax not found");
	  soft.assertEquals(ppage.getProductPriceFromSearchResult(), pprice,
	  "failure message: product price not found"); soft.assertAll(); }
	 

	
	  @Test(priority = 4, enabled = true) public void
	  validateEditFunctionOfExistingRecord() throws IOException {
	  
			String pcode = excelutil.readStringData( 18, 2);
			String pname = excelutil.readStringData(15, 2);
			String psupplier = excelutil.readStringData(16, 2);
			String pdescription = excelutil.readStringData(17, 2);
	  
			ppage.searchByProductCode(pcode);
			ppage.clickOnEditProduct();
			ppage.enterValueForProductName(pname);
			ppage.selectValueForProductCategory(psupplier);
			ppage.enterValueForProductDescription(pdescription);
			ppage.clickOnEditProductSubmit();
			ppage.searchByProductCode(pcode);
	  SoftAssert soft = new SoftAssert();
	  soft.assertEquals(ppage.getProductCodeFromSearchResult(), "1234",
	  "failure message: product code not modified");
	  soft.assertEquals(ppage.getProductNameFromSearchResult(), "Cake World",
	  "failure message: product Name is modified");
	  soft.assertEquals(ppage.getProductCategoryFromSearchResult(), "fruits",
	  "failure message: product category is mofied");
	  soft.assertEquals(ppage.getProductProductDescriptionFromSearchResult(),
	  "hello", "failure message: product description not found");
	  soft.assertEquals(ppage.getProductTaxFromSearchResult(), "20",
	  "failure message: product tax not found");
	  soft.assertEquals(ppage.getProductPriceFromSearchResult(), "20",
	  "failure message: product price not found"); soft.assertAll();
	  
	  }
	  
	  @Test(priority = 5, enabled = true) public void
	  validateDeleteFunctiongOfExistingRecord() throws IOException { String
			pcode = excelutil.readStringData(20, 2);
			ppage.searchByProductCode(pcode);
			ppage.clickOnProductDeleteIcon();
			ppage.clickOnDeleteConformMsg();
			ppage.searchByProductCode(pcode);
			assertEquals(ppage.getProductSearchResultOfDeletedEntry(), "No matching records found",
					"failure message:: failed to delete the store entry");
		}

}
