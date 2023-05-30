package com.test;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.constants.AutomationConstants;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.PeopleWaiterPage;
import com.pages.ProductPage;
import com.pages.StoresPage;
import com.utils.ExcelUtils;
import com.utils.PropertyUtils;
import com.utils.WebBrowserUtils;

public class PeopleWaiterPageTest extends AutomationBase {

	WebBrowserUtils webbrowser;
	LoginPage login;
	HomePage homepg;
	ExcelUtils excelutil;
	ProductPage ppage;
	StoresPage storepage;
	PeopleWaiterPage waiter;
	Properties prop;

	@Test(priority = 1, enabled = true, groups = { "smoke" })
	public void validateTheElementInAddWaiterPopup() {
		login = new LoginPage(driver);
		excelutil = new ExcelUtils();
		webbrowser = new WebBrowserUtils();
		prop = PropertyUtils.getProperty("config.properties");
		homepg = login.login(prop.getProperty("username"), prop.getProperty("password"));
		waiter = homepg.navigateToWaiterInPeopleLink();

		waiter.clickOnAddWaiterBtn();

		SoftAssert soft = new SoftAssert();
		soft.assertTrue(waiter.isWaiterNameDisplayed(), AutomationConstants.addDisplayedErrorMsg);
		soft.assertTrue(waiter.isWaiterEmailDisplayed(), AutomationConstants.addDisplayedErrorMsg);
		soft.assertTrue(waiter.isWaiterPhoneDisplayed(), AutomationConstants.addDisplayedErrorMsg);
		soft.assertTrue(waiter.isWaiterStoreDisplayed(), AutomationConstants.addDisplayedErrorMsg);
		soft.assertAll();
		waiter.clickOnaddWaiterCloseBtn();

	}

	@Test(priority = 2, enabled = true, groups = { "sanity" })
	public void validatenAddWaiterPopUpfields() {
		login = new LoginPage(driver);
		excelutil = new ExcelUtils();
		webbrowser = new WebBrowserUtils();
		prop = PropertyUtils.getProperty("config.properties");
		homepg = login.login(prop.getProperty("username"), prop.getProperty("password"));
		waiter = homepg.navigateToWaiterInPeopleLink();

		String waitername = excelutil.readStringData("PeopleWaiter", 14, 2);
		String wemail = excelutil.readStringData("PeopleWaiter", 15, 2);
		String wphone = excelutil.readStringData("PeopleWaiter", 16, 2);
		String wstore = excelutil.readStringData("PeopleWaiter", 17, 2);
		String rwaitername = excelutil.readStringData("PeopleWaiter", 1, 2);
		String rwemail = excelutil.readStringData("PeopleWaiter", 2, 2);
		String rwphone = excelutil.readStringData("PeopleWaiter", 3, 2);
		String rwstore = excelutil.readStringData("PeopleWaiter", 4, 2);
		waiter.clickOnWaiterLink();
		waiter.clickOnAddWaiterBtn();
		waiter.enterValueForWaiterName(waitername);
		waiter.enterValueForWaiterEmail(wemail);
		waiter.enterValueForWaiterPhone(wphone);
		waiter.clickOnsubmitBtnInWaitersAddPopUp();
		waiter.searchByWaitersName(rwaitername);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(waiter.getWaiterEmailFromSearchResult(), rwemail,
				AutomationConstants.addFeildValidateErrorMessage);
		soft.assertEquals(waiter.getWaiterPhoneFromSearchResult(), rwphone,
				AutomationConstants.addFeildValidateErrorMessage);

		soft.assertAll();
	}

	@Test(priority = 3, enabled = true, groups = { "smoke" })
	public void validateValueEntredInAddWaiterPopUpIsSaved() {
		login = new LoginPage(driver);
		excelutil = new ExcelUtils();
		webbrowser = new WebBrowserUtils();
		prop = PropertyUtils.getProperty("config.properties");
		homepg = login.login(prop.getProperty("username"), prop.getProperty("password"));
		waiter = homepg.navigateToWaiterInPeopleLink();
		String waitername = excelutil.readStringData("PeopleWaiter", 1, 2);
		String wemail = excelutil.readStringData("PeopleWaiter", 2, 2);
		String wphone = excelutil.readStringData("PeopleWaiter", 3, 2);
		String wstore = excelutil.readStringData("PeopleWaiter", 4, 2);

		waiter.clickOnWaiterLink();
		waiter.clickOnAddWaiterBtn();
		waiter.selectValueForWaiterStore(wstore);
		waiter.enterValueForWaiterName(waitername);
		waiter.enterValueForWaiterPhone(wphone);
		waiter.enterValueForWaiterEmail(wemail);
		waiter.clickOnsubmitBtnInWaitersAddPopUp();
		waiter.searchByWaitersName("Ramesh");

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(waiter.getWaiterNameFromSearchResult(), waitername, AutomationConstants.errorMessage);
		soft.assertEquals(waiter.getWaiterPhoneFromSearchResult(), wphone, AutomationConstants.errorMessage);
		soft.assertEquals(waiter.getWaiterEmailFromSearchResult(), wemail, AutomationConstants.errorMessage);
		soft.assertEquals(waiter.getWaiterStoreFromSearchResult(), wstore, AutomationConstants.errorMessage);
		soft.assertAll();
	}

	@Test(priority = 4, enabled = true, groups = { "smoke", "sanity" })
	public void validateEditFunctionOfExistingRecord() {
		login = new LoginPage(driver);
		excelutil = new ExcelUtils();
		webbrowser = new WebBrowserUtils();
		prop = PropertyUtils.getProperty("config.properties");
		homepg = login.login(prop.getProperty("username"), prop.getProperty("password"));
		waiter = homepg.navigateToWaiterInPeopleLink();

		String waitername = excelutil.readStringData("PeopleWaiter", 7, 2);
		String wemail = excelutil.readStringData("PeopleWaiter", 8, 2);
		String wphone = excelutil.readStringData("PeopleWaiter", 9, 2);
		String wstore = excelutil.readStringData("PeopleWaiter", 10, 2);
		waiter.clickOnWaiterLink();
		waiter.searchByWaitersName(waitername);
		waiter.clickOnEditIconInWaiter();
		waiter.enterValueForWaiterName(waitername);
		waiter.enterValueForWaiterPhone(wphone);
		waiter.enterValueForWaiterEmail(wemail);
		waiter.clickOnEditWaiterSubmit();
		waiter.searchByWaitersName(waitername);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(waiter.getWaiterNameFromSearchResult(), waitername, AutomationConstants.errorMessage);
		soft.assertEquals(waiter.getWaiterPhoneFromSearchResult(), wphone, AutomationConstants.errorMessage);
		soft.assertEquals(waiter.getWaiterEmailFromSearchResult(), wemail, AutomationConstants.errorMessage);
		soft.assertEquals(waiter.getWaiterStoreFromSearchResult(), wstore, AutomationConstants.errorMessage);
		soft.assertAll();
	}

	@Test(priority = 5, enabled = true, groups = { "smoke", "sanity", "regression" })
	public void validateDeleteFunctiongOfExistingRecord() {
		login = new LoginPage(driver);
		excelutil = new ExcelUtils();
		webbrowser = new WebBrowserUtils();
		prop = PropertyUtils.getProperty("config.properties");
		homepg = login.login(prop.getProperty("username"), prop.getProperty("password"));
		waiter = homepg.navigateToWaiterInPeopleLink();

		String waitername = excelutil.readStringData("PeopleWaiter", 12, 2);
		waiter.clickOnWaiterLink();
		waiter.searchByWaitersName(waitername);
		waiter.clickOnDeleteIconInWaiter();
		waiter.clickOnDeleteConformMsg();
		waiter.searchByWaitersName(waitername);

		assertEquals(waiter.getWaiterSearchResultOfDeletedEntry(), "No matching records found",
				AutomationConstants.deleteCheck);
	}

}
