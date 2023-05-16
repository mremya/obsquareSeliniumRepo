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
import com.utils.ExcelUtils;
import com.utils.PropertyUtils;
import com.utils.WebBrowserUtils;

public class PeopleCoustomerPageTest extends AutomationBase {

	WebDriver driver;
	WebBrowserUtils webbrowser;
	LoginPage login;
	ExcelUtils excelutil;
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
		excelutil = new ExcelUtils();
		prop = PropertyUtils.getProperty("config.properties");
		login.performlogin(prop.getProperty("username"), prop.getProperty("password"));
		waiter= homepg.navigateToPeoplePage();
	}

	@Test(priority = 1, enabled = true, groups = { "sanity" })
	public void validateTheElementInAddCustomerPopup() {
		customer.clickOnCustomerLink();
		customer.clickOnAddCustomerBtn();
		
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(customer.isCustomerNameDisplayed(), "Failure message::customer name is not displayed");
		soft.assertTrue(customer.isCustomerPhoneDisplayed(), "Failure message::customer Phone  is not displayed");
		soft.assertTrue(customer.isCustomerEmailDisplayed(), "Failure message::customer Email  is not displayed");
		soft.assertTrue(customer.isCustomerDiscountDisplayed(), "Failure message::customer discount  is not displayed");
		customer.clickOnAddCustomerCloseBtn();
		soft.assertAll();

	}

	@Test(priority = 2, enabled = true, groups = { "smoke", "sanity" })
	public void validateAddCustomerPopUpfields() {
		String cname = excelutil.readStringData("PeopleWaiter",15,2);
		String cphone = excelutil.readStringData("PeopleWaiter",16, 2);
		String cemail = excelutil.readStringData("PeopleWaiter",17, 2);
		String cdiscount = excelutil.readStringData("PeopleWaiter",18, 2);
		String rcname = excelutil.readStringData("PeopleWaiter",1,2);
		String rcphone = excelutil.readStringData("PeopleWaiter",2, 2);
		String rcemail = excelutil.readStringData("PeopleWaiter",3, 2);
		String rcdiscount= excelutil.readStringData("PeopleWaiter",4,2);
		
		customer.clickOnCustomerLink();
		customer.clickOnAddCustomerBtn();
		customer.enterValueForCustomerName(cname);
		customer.enterValueForCustomerEmail(cemail);
		customer.enterValueForCustomerPhone(cphone);
		customer.enterValueForCustomerDiscount(cdiscount);
		customer.searchByCustomerName(rcname);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(customer.getCustomerEmailFromSearchResult(),rcname,
				AutomationConstants.addFeildValidateErrorMessage);
		soft.assertEquals(customer.getCustomerPhoneFromSearchResult(),rcphone,
				AutomationConstants.addFeildValidateErrorMessage);
		soft.assertEquals(customer.getCustomerDiscountFromSearchResult(),rcdiscount,
				AutomationConstants.addFeildValidateErrorMessage);
		soft.assertAll();
	}

	@Test(priority = 3, enabled = true, groups = { "smoke", "regression" })
	public void validateValueEntredInAddWaiterPopUpIsSaved() {
		String cname = excelutil.readStringData("PeopleWaiter",1,2);
		String cphone = excelutil.readStringData("PeopleWaiter",2, 2);
		String cemail = excelutil.readStringData("PeopleWaiter",3, 2);
		String cdiscount= excelutil.readStringData("PeopleWaiter",4,2);
		
		customer.clickOnCustomerLink();
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
		String cname = excelutil.readStringData("PeopleWaiter",7,2);
		String cphone = excelutil.readStringData("PeopleWaiter",8, 2);
		String cemail = excelutil.readStringData("PeopleWaiter",9, 2);
		String cdiscount= excelutil.readStringData("PeopleWaiter",10,2);
		
		
		customer.clickOnCustomerLink();
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
		String cname = excelutil.readStringData("PeopleWaiter",17,2);
		customer.clickOnCustomerLink();
		customer.searchByCustomerName(cname);
		customer.clickOnCustomerDeleteIconBtn();
		customer.clickOnCustomerDeleteConformMsgBtn();
		customer.searchByCustomerName(cname);
		assertEquals(customer.getTheSearchResultOfDeletedEntry(), "No matching records found",
				AutomationConstants.deleteCheck);
	}

}
