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
import com.pages.PeopleWaiterPage;
import com.pages.ProductPage;
import com.pages.StoresPage;
import com.utils.WebBrowserUtils;

public class PeopleWaiterPageTest extends AutomationBee {

	WebDriver driver;
	WebBrowserUtils webbrowser;
	LoginPage login;
	HomePage homepg;
	ProductPage ppage;
	StoresPage storepage;
	PeopleWaiterPage waiter;

	@BeforeMethod
	public void prerun() throws Exception {
		driver = getDriver();
		login = new LoginPage(driver);
		webbrowser = new WebBrowserUtils();
		webbrowser.launchUrl(driver, "https://qalegend.com/restaurant/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		homepg = login.login("admin", "password");
		ppage = homepg.navigateToProductPage();
		storepage = ppage.navigateToStoresPage();
		waiter = storepage.navigateToPeoplePage();
	}

	 @Test(priority = 1, enabled = true)
	public void validateTheElementInAddWaiterPopup() {
		waiter.clickOnWaiterLink();
		waiter.clickOnAddWaiterBtn();

		SoftAssert soft = new SoftAssert();
		soft.assertTrue(waiter.isWaiterNameDisplayed(), "Failure message::waiter name is not displayed");
		soft.assertTrue(waiter.isWaiterEmailDisplayed(), "Failure message::waiter email  is not displayed");
		soft.assertTrue(waiter.isWaiterPhoneDisplayed(), "Failure message::waiter phone  is not displayed");
		soft.assertTrue(waiter.isWaiterStoreDisplayed(), "Failure message::waiter Store  is not displayed");
		soft.assertAll();

	}

	 @Test(priority = 2, enabled = true)
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
				"failure message: waiters email is not informat");
		soft.assertEquals(waiter.getWaiterPhoneFromSearchResult(), "1234567894",
				"failure message:waiters phone is not informat ");

		soft.assertAll();
	}

	@Test(priority = 3, enabled = true)
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
				"failure message:mismatch in the waitername search result");
		soft.assertEquals(waiter.getWaiterPhoneFromSearchResult(), "1234567894",
				"failure message: mismatch in the waiter phone search result");
		soft.assertEquals(waiter.getWaiterEmailFromSearchResult(), "abc@gmail.com",
				"failure message:mismatch in the waiter email search result");
		soft.assertEquals(waiter.getWaiterStoreFromSearchResult(), "store2",
				"failure message: mismatch in the waiter store search result");
		soft.assertAll();
	}

	@Test(priority = 4, enabled = true)
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
				"failure message : Waiters name is not modified");
		soft.assertEquals(waiter.getWaiterPhoneFromSearchResult(), "1234", "failure message: phone  is not modified");
		soft.assertEquals(waiter.getWaiterEmailFromSearchResult(), "pqr@gmail.com",
				"failure message: the waiter email is not modified");
		soft.assertEquals(waiter.getWaiterStoreFromSearchResult(), "store2",
				"failure message: the waiter store is not  modified");
		soft.assertAll();
	}

	@Test(priority = 5, enabled = true)
	public void validateDeleteFunctiongOfExistingRecord() {
		waiter.clickOnWaiterLink();
		waiter.searchByWaitersName("ammu");
		waiter.clickOnDeleteIconInWaiter();
		waiter.clickOnDeleteConformMsg();
		waiter.searchByWaitersName("ammu");

		assertEquals(waiter.getWaiterSearchResultOfDeletedEntry(), "No matching records found",
				"failure message:: failed to delete the waiter entry");
	}

}
