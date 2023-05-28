package com.test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
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
import com.utils.WebBrowserUtils;

public class ProductPageTest extends AutomationBase {

	ExcelUtils excelutil;
	
	WebBrowserUtils webbrowser;
	LoginPage login;
	HomePage hpage;
	ProductPage ppage;
	Properties prop;
	StoresPage storepage;

	

	@Test(priority = 1, enabled = true)
	public void validateTheElementInAddProductPopup() throws Exception {
		excelutil = new ExcelUtils();
		login = new LoginPage(driver);
		hpage = new HomePage(driver);
		ppage = new ProductPage(driver);
		prop = new Properties();
		webbrowser = new WebBrowserUtils();
		prop = PropertyUtils.getProperty("config.properties");
		login.performlogin(prop.getProperty("username"), prop.getProperty("password"));
		ppage = hpage.navigateToProductPage();

		ppage.clickOnAddProduct();
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(ppage.isProductTypeDisplayed(),"failure message: product type not found");
		//soft.assertTrue(ppage.isproductCodeDisplayed(), "failure message: product code not found");
		soft.assertTrue(ppage.isProductCategoryDisplayed(),"failure message: product category not found");
		soft.assertTrue(ppage.isProductNameDisplayed(),"failure message: product name not found");
		soft.assertTrue(ppage.isProductSupplierDisplayed(), "failure message: product supplier not found");
		soft.assertTrue(ppage.isProductPurchasePriceDisplayed(),"failure message: product purchase not found");
		soft.assertTrue(ppage.isProductUnitDisplayed(), "failure message: product unit not found");
		soft.assertTrue(ppage.isProductPriceDisplayed(),"failure message: product price not found");
		soft.assertTrue(ppage.isProductTaxDisplayed(), "failure message: product tax not found");
		soft.assertTrue(ppage.isProductAlertQuantityDisplayed(),"failure message: product Alert quantity not found");
		soft.assertTrue(ppage.isProductOptionsDisplayed(), "failure message: product option not found");
		ppage.waitForClickOnAddCloseButton();
		ppage.clickOnAddProductClose();
		soft.assertAll();

	}

	@Test(priority = 2, enabled = true)
	public void validatenTheValueInAddProductPopUpfields() {
		excelutil = new ExcelUtils();
		login = new LoginPage(driver);
		hpage = new HomePage(driver);
		ppage = new ProductPage(driver);
		prop = new Properties();
		webbrowser = new WebBrowserUtils();
		prop = PropertyUtils.getProperty("config.properties");
		login.performlogin(prop.getProperty("username"), prop.getProperty("password"));
		ppage = hpage.navigateToProductPage();

		
		
		String pcode = excelutil.readStringData("Product", 2, 3);
		String pname = excelutil.readStringData("Product",3, 3);
		String ptax = excelutil.readStringData("Product",7, 3);
		String palertQuantity = excelutil.readStringData("Product",11, 3);
		ppage.clickOnAddProduct();
		ppage.enterValueForProductCode(pcode); 
		ppage.enterValueForProductName(pname);
		ppage.enterValueForProductTax(ptax);
		ppage.selectValueForProductAlertQuantity(palertQuantity);
		ppage.clickOnAddProductSubmit();
		ppage.clickOnStockCloseButton();
		ppage.searchByProductCode(pcode);
		SoftAssert soft = new SoftAssert();
		
		soft.assertEquals(ppage.getProductTaxFromSearchResult(), ptax,
				"failure message: product tax not found");
		soft.assertEquals(ppage.getProductPriceFromSearchResult(), palertQuantity,
				"failure message: product price not found");
		soft.assertAll();

	}

	@Test(priority = 3, enabled = true)

	public void validateValueEntredInAddProductPopUpFieldIsSaved()  {
		excelutil = new ExcelUtils();
		login = new LoginPage(driver);
		hpage = new HomePage(driver);
		ppage = new ProductPage(driver);
		prop = new Properties();
		webbrowser = new WebBrowserUtils();
		prop = PropertyUtils.getProperty("config.properties");
		login.performlogin(prop.getProperty("username"), prop.getProperty("password"));
		ppage = hpage.navigateToProductPage();

		
		
		ppage.clickOnAddProduct();
		String ptype = excelutil.readStringData("Product",1, 2);
		String pcode = excelutil.readStringData("Product",2, 2);
		String pname = excelutil.readStringData("Product",3, 2);
		String pcategory = excelutil.readStringData("Product",4, 2);
		String psupplier = excelutil.readStringData("Product",5, 2);
		String ppurchasedPrice = excelutil.readStringData("Product",6, 2);
		String ptax = excelutil.readStringData("Product",7, 2);
		String ptaxMethod = excelutil.readStringData("Product",8, 2);
		String pprice = excelutil.readStringData("Product",9, 2);
		String punit = excelutil.readStringData("Product",10, 2);
		String palertQuantity = excelutil.readStringData("Product",11, 2);
		String pdescription = excelutil.readStringData("Product",12, 2);

		ppage.selectValueForProductType(ptype);
		ppage.enterValueForProductCode(pcode); 
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
		ppage.clickOnAddProductSubmit();
		ppage.clickOnStockCloseButton();
		
		ppage.searchByProductCode(pcode);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(ppage.getProductCodeFromSearchResult(), pcode, "failure message: product code not found");
		soft.assertEquals(ppage.getProductNameFromSearchResult(), pname, "failure message: product Name not found");
		soft.assertEquals(ppage.getProductCategoryFromSearchResult(), pcategory,
				"failure message: product fruits not found");
		soft.assertEquals(ppage.getProductProductDescriptionFromSearchResult(), pdescription,
				"failure message: product description not found");
		soft.assertEquals(ppage.getProductTaxFromSearchResult(), ptax, "failure message: product tax not found");
		soft.assertEquals(ppage.getProductPriceFromSearchResult(), pprice, "failure message: product price not found");
		soft.assertAll();
	}

	@Test(priority = 4, enabled = true)
	public void validateEditFunctionOfExistingRecord()  {
		
		excelutil = new ExcelUtils();
		login = new LoginPage(driver);
		hpage = new HomePage(driver);
		ppage = new ProductPage(driver);
		prop = new Properties();
		webbrowser = new WebBrowserUtils();
		prop = PropertyUtils.getProperty("config.properties");
		login.performlogin(prop.getProperty("username"), prop.getProperty("password"));
		ppage = hpage.navigateToProductPage();

		

		String pcode = excelutil.readStringData("Product",18, 2);
		String pname = excelutil.readStringData("Product",15, 2);
		String psupplier = excelutil.readStringData("Product",16, 2);
		String pdescription = excelutil.readStringData("Product",17, 2);
		String pcategory = excelutil.readStringData("Product",4, 2);
		String ptax = excelutil.readStringData("Product",7, 4);
		String pprice = excelutil.readStringData("Product",9, 3);

		ppage.searchByProductCode(pcode);
		ppage.clickOnEditProduct();
		ppage.enterValueForProductName(pname);
		ppage.selectValueForProductCategory(pcategory);
		ppage.selectValueForProductCategory(psupplier);
		ppage.enterValueForProductDescription(pdescription);
		ppage.enterValueForProductTax(ptax);
		ppage.enterValueForProductPrice(pprice);
		ppage.clickOnEditProductSubmit();
		ppage.searchByProductCode(pcode);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(ppage.getProductCodeFromSearchResult(), pcode, "failure message: product code not modified");
		soft.assertEquals(ppage.getProductNameFromSearchResult(), pname, "failure message: product Name is modified");
		soft.assertEquals(ppage.getProductCategoryFromSearchResult(), pcategory,
				"failure message: product category is mofied");
		soft.assertEquals(ppage.getProductProductDescriptionFromSearchResult(), pdescription,
				"failure message: product description not found");
		soft.assertEquals(ppage.getProductTaxFromSearchResult(), ptax, "failure message: product tax not found");
		soft.assertEquals(ppage.getProductPriceFromSearchResult(), pprice, "failure message: product price not found");
		soft.assertAll();

	}

	@Test(priority = 5, enabled = true)
	public void validateDeleteFunctiongOfExistingRecord(){
		excelutil = new ExcelUtils();
		login = new LoginPage(driver);
		hpage = new HomePage(driver);
		ppage = new ProductPage(driver);
		prop = new Properties();
		webbrowser = new WebBrowserUtils();
		prop = PropertyUtils.getProperty("config.properties");
		login.performlogin(prop.getProperty("username"), prop.getProperty("password"));
		ppage = hpage.navigateToProductPage();

		
		
		String pcode = excelutil.readStringData("Product",20, 2);
		ppage.searchByProductCode(pcode);
		ppage.clickOnProductDeleteIcon();
		ppage.clickOnDeleteConformMsg();
		ppage.searchByProductCode(pcode);
		assertEquals(ppage.getProductSearchResultOfDeletedEntry(), "No matching records found",
				AutomationConstants.deleteCheck);
	}

}
