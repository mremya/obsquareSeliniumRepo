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
import com.pages.PeopleWaiterPage;
import com.pages.ProductPage;
import com.pages.StoresPage;
import com.utils.PropertyUtils;
import com.utils.WebBrowserUtils;

public class PeopleWaiterPageTest extends AutomationBase {

	WebDriver driver;
	WebBrowserUtils webbrowser;
	LoginPage login;
	HomePage homepg;
	ProductPage ppage;
	StoresPage storepage;
	PeopleWaiterPage waiter;
	Properties prop;

	
		@BeforeMethod
		public void prerun() throws Exception {
			
			driver = getDriver();
			login = new LoginPage(driver);
			webbrowser = new WebBrowserUtils();
			prop=PropertyUtils.getProperty("config.properties");
			login.performlogin(prop.getProperty("username"), prop.getProperty("password"));
			waiter = homepg.navigateToPeoplePage();
}

	 @Test(priority = 1, enabled = true ,groups= {"smoke"})
	public void validateTheElementInAddWaiterPopup() {
		waiter.clickOnWaiterLink();
		waiter.clickOnAddWaiterBtn();
		waiter.clickOnaddWaiterCloseBtn();
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(waiter.isWaiterNameDisplayed(), AutomationConstants.addDisplayedErrorMsg);
		soft.assertTrue(waiter.isWaiterEmailDisplayed(),AutomationConstants.addDisplayedErrorMsg);
		soft.assertTrue(waiter.isWaiterPhoneDisplayed(), AutomationConstants.addDisplayedErrorMsg);
		soft.assertTrue(waiter.isWaiterStoreDisplayed(), AutomationConstants.addDisplayedErrorMsg);
		soft.assertAll();

	}

	 @Test(priority = 2, enabled = true,groups= {"sanity"})
	public void validatenAddWaiterPopUpfields() {
		 waiter.clickOnWaiterLink();
		waiter.clickOnAddWaiterBtn();
		waiter.enterValueForWaiterName("Arav");
		waiter.enterValueForWaiterEmail("##@gmail.com");
		waiter.enterValueForWaiterPhone("1475");
		waiter.clickOnsubmitBtnInWaitersAddPopUp();
		waiter.searchByWaitersName("Arav");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(waiter.getWaiterEmailFromSearchResult(), "abc@gmail.com",
				AutomationConstants.addFeildValidateErrorMessage);
		soft.assertEquals(waiter.getWaiterPhoneFromSearchResult(), "1234567894",
				AutomationConstants.addFeildValidateErrorMessage);

		soft.assertAll();
	}

	@Test(priority = 3, enabled = true , groups= {"smoke"})
	public void validateValueEntredInAddWaiterPopUpIsSaved() {
		waiter.clickOnWaiterLink();
		waiter.clickOnAddWaiterBtn();
		waiter.selectValueForWaiterStore("store2");
		waiter.enterValueForWaiterName("Ramesh");
		waiter.enterValueForWaiterPhone("1234567894");
		waiter.enterValueForWaiterEmail("abc@gmail.com");
		waiter.clickOnsubmitBtnInWaitersAddPopUp();
		waiter.searchByWaitersName("Ramesh");

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(waiter.getWaiterNameFromSearchResult(), "Ramesh",
				AutomationConstants.errorMessage);
		soft.assertEquals(waiter.getWaiterPhoneFromSearchResult(), "1234567894",
				AutomationConstants.errorMessage);
		soft.assertEquals(waiter.getWaiterEmailFromSearchResult(), "abc@gmail.com",
				AutomationConstants.errorMessage);
		soft.assertEquals(waiter.getWaiterStoreFromSearchResult(), "store2",
				AutomationConstants.errorMessage);
		soft.assertAll();
	}

	@Test(priority = 4, enabled = true ,groups= {"smoke","sanity"})
	public void validateEditFunctionOfExistingRecord() {
		waiter.clickOnWaiterLink();
		
		waiter.searchByWaitersName("Ramesh");

		waiter.clickOnEditIconInWaiter();
		waiter.enterValueForWaiterEmail("pqr@gmail.com");
		waiter.enterValueForWaiterPhone("1234");

		waiter.selectValueForWaiterStore("store2");
		waiter.clickOnEditWaiterSubmit();
		waiter.searchByWaitersName("Ramesh");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(waiter.getWaiterNameFromSearchResult(), "Ramesh",
				AutomationConstants.errorMessage);
		soft.assertEquals(waiter.getWaiterPhoneFromSearchResult(), "1234",AutomationConstants.errorMessage);
		soft.assertEquals(waiter.getWaiterEmailFromSearchResult(), "pqr@gmail.com",
				AutomationConstants.errorMessage);
		soft.assertEquals(waiter.getWaiterStoreFromSearchResult(), "store2",
				AutomationConstants.errorMessage);
		soft.assertAll();
	}

	@Test(priority = 5, enabled = true, groups= {"smoke","sanity" ,"regression"})
	public void validateDeleteFunctiongOfExistingRecord() {
		waiter.clickOnWaiterLink();
		waiter.searchByWaitersName("ammu");
		waiter.clickOnDeleteIconInWaiter();
		waiter.clickOnDeleteConformMsg();
		waiter.searchByWaitersName("ammu");

		assertEquals(waiter.getWaiterSearchResultOfDeletedEntry(), "No matching records found",
				AutomationConstants.deleteCheck);
	}

}
