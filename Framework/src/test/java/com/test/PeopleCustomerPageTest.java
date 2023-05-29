package com.test;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
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
import com.utils.ExcelUtils;
import com.utils.PropertyUtils;
import com.utils.WebBrowserUtils;

public class PeopleCustomerPageTest extends AutomationBase {

	
	WebBrowserUtils webbrowser;
	LoginPage login;
	ExcelUtils excelutil;
	HomePage homepg;
	ProductPage ppage;
	StoresPage storepage;
	PeopleWaiterPage waiter;
	PeopleCustomerPage customer;
	Properties prop;


	//@Test(priority = 1, enabled = true, groups = { "sanity" })
	public void validateTheElementInAddCustomerPopup() {
		login = new LoginPage(driver);
		webbrowser = new WebBrowserUtils();
		excelutil = new ExcelUtils();
		prop = PropertyUtils.getProperty("config.properties");
		homepg=login.login(prop.getProperty("username"), prop.getProperty("password"));
		customer= homepg.navigateToCustomersInPeopleLink();
		
		//customer.clickOnCustomerLink();
		customer.clickOnAddCustomerBtn();
		customer.customerImplicitwait();
		SoftAssert soft = new SoftAssert();
		soft.assertFalse(customer.isCustomerNameDisplayed(), "Failure message::customer name is not displayed");
		soft.assertFalse(customer.isCustomerPhoneDisplayed(), "Failure message::customer Phone  is not displayed");
		soft.assertFalse(customer.isCustomerEmailDisplayed(), "Failure message::customer Email  is not displayed");
		soft.assertFalse(customer.isCustomerDiscountDisplayed(), "Failure message::customer discount  is not displayed");
		customer.clickOnAddCustomerCloseBtn();
		soft.assertAll();

	}

	//@Test(priority = 2, enabled = true, groups = { "smoke", "sanity" })
	public void validateAddCustomerPopUpfields() {
		login = new LoginPage(driver);
		webbrowser = new WebBrowserUtils();
		excelutil = new ExcelUtils();
		prop = PropertyUtils.getProperty("config.properties");
		homepg=login.login(prop.getProperty("username"), prop.getProperty("password"));
		customer= homepg.navigateToCustomersInPeopleLink();
		
		String cname = excelutil.readStringData("PeopleCustomer",15,2);
		String cphone = excelutil.readStringData("PeopleCustomer",16, 2);
		String cemail = excelutil.readStringData("PeopleCustomer",17, 2);
		String cdiscount = excelutil.readStringData("PeopleCustomer",18, 2);
		String rcname = excelutil.readStringData("PeopleCustomer",1,2);
		String rcphone = excelutil.readStringData("PeopleCustomer",2, 2);
		String rcemail = excelutil.readStringData("PeopleCustomer",3, 2);
		String rcdiscount= excelutil.readStringData("PeopleCustomer",4,2);
		
		
		customer.clickOnAddCustomerBtn();
		customer.enterValueForCustomerName(cname);
		customer.enterValueForCustomerEmail(cemail);
		customer.enterValueForCustomerPhone(cphone);
		customer.enterValueForCustomerDiscount(cdiscount);
		customer.clickOnAddCustomerSubmitBtn();
		customer.searchByCustomerName(rcname);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(customer.getCustomerEmailFromSearchResult(),rcemail,
				AutomationConstants.addFeildValidateErrorMessage);
		soft.assertEquals(customer.getCustomerPhoneFromSearchResult(),rcphone,
				AutomationConstants.addFeildValidateErrorMessage);
		soft.assertEquals(customer.getCustomerDiscountFromSearchResult(),rcdiscount,
				AutomationConstants.addFeildValidateErrorMessage);
		soft.assertAll();
	}

	@Test(priority = 3, enabled = true, groups = { "smoke", "regression" })
	public void validateValueEntredInAddWaiterPopUpIsSaved() {
		login = new LoginPage(driver);
		webbrowser = new WebBrowserUtils();
		excelutil = new ExcelUtils();
		prop = PropertyUtils.getProperty("config.properties");
		homepg=login.login(prop.getProperty("username"), prop.getProperty("password"));
		customer= homepg.navigateToCustomersInPeopleLink();
		
		String cname = excelutil.readStringData("PeopleCustomer",1,2);
		String cphone = excelutil.readStringData("PeopleCustomer",2, 2);
		String cemail = excelutil.readStringData("PeopleCustomer",3, 2);
		String cdiscount= excelutil.readStringData("PeopleCustomer",4,2);
		
		
		customer.clickOnAddCustomerBtn();
		customer.enterValueForCustomerName(cname);
		customer.enterValueForCustomerEmail(cemail);
		customer.enterValueForCustomerPhone(cphone);
		customer.enterValueForCustomerDiscount(cdiscount);
		customer.clickOnAddCustomerSubmitBtn();
		customer.searchByCustomerName(cname);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(customer.getcustomerNameFromSearchResult(),cname, AutomationConstants.errorMessage);
		soft.assertEquals(customer.getCustomerEmailFromSearchResult(),cemail,
				AutomationConstants.errorMessage);
		soft.assertEquals(customer.getCustomerPhoneFromSearchResult(),cphone, AutomationConstants.errorMessage);
		soft.assertEquals(customer.getCustomerDiscountFromSearchResult(),cdiscount, AutomationConstants.errorMessage);
		soft.assertAll();
	}

	@Test(priority = 4, enabled = true, groups = { "regression" })
	public void modifyTheExistingRecordOfStores() {
		login = new LoginPage(driver);
		webbrowser = new WebBrowserUtils();
		excelutil = new ExcelUtils();
		prop = PropertyUtils.getProperty("config.properties");
		homepg=login.login(prop.getProperty("username"), prop.getProperty("password"));
		customer= homepg.navigateToCustomersInPeopleLink();
		
		String cname = excelutil.readStringData("PeopleCustomer",7,2);
		String cphone = excelutil.readStringData("PeopleCustomer",8, 2);
		String cemail = excelutil.readStringData("PeopleCustomer",9, 2);
		String cdiscount= excelutil.readStringData("PeopleCustomer",10,2);
		
		
		
		customer.searchByCustomerName(cname);
		customer.clickOnCustomerEditIconBtn();
		customer.enterValueForCustomerDiscount(cdiscount);
		customer.enterValueForCustomerEmail(cemail);
		customer.enterValueForCustomerPhone(cphone);
		customer.clickOnCustomerEditSubmit();
		customer.searchByCustomerName("Anish");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(customer.getcustomerNameFromSearchResult(),cname, AutomationConstants.errorMessage);
		soft.assertEquals(customer.getCustomerEmailFromSearchResult(),cemail,
				AutomationConstants.errorMessage);
		soft.assertEquals(customer.getCustomerPhoneFromSearchResult(),cphone, AutomationConstants.errorMessage);
		soft.assertEquals(customer.getCustomerDiscountFromSearchResult(),cdiscount, AutomationConstants.errorMessage);
		soft.assertAll();
	}

	@Test(priority = 5, enabled = true, groups = { "smoke" })
	public void validateDeleteFunctiongOfExistingRecord() {
		login = new LoginPage(driver);
		webbrowser = new WebBrowserUtils();
		excelutil = new ExcelUtils();
		prop = PropertyUtils.getProperty("config.properties");
		homepg=login.login(prop.getProperty("username"), prop.getProperty("password"));
		customer= homepg.navigateToCustomersInPeopleLink();
		
		String cname = excelutil.readStringData("PeopleCustomer",17,2);
		customer.clickOnCustomerLink();
		customer.searchByCustomerName(cname);
		customer.clickOnCustomerDeleteIconBtn();
		customer.clickOnCustomerDeleteConformMsgBtn();
		customer.searchByCustomerName(cname);
		assertEquals(customer.getTheSearchResultOfDeletedEntry(), "No matching records found",
				AutomationConstants.deleteCheck);
	}

}
