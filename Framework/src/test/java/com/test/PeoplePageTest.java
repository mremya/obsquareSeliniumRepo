package com.test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBee;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.PeoplePage;
import com.pages.ProductPage;
import com.pages.StoresPage;
import com.utils.WebBrowserUtils;

public class PeoplePageTest extends AutomationBee {

	
	WebDriver driver;
	WebBrowserUtils webbrowser;
	LoginPage login;
	HomePage homepg;
	ProductPage ppage;
	StoresPage storepage;
	PeoplePage people;
	
	@BeforeMethod
	public void prerun() throws Exception {
		driver = getDriver();
		login = new LoginPage(driver);
		webbrowser = new WebBrowserUtils();
		webbrowser.launchUrl(driver, "https://qalegend.com/restaurant/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		homepg = login.login("admin", "password");
		ppage = homepg.navigateToProductPage();
		storepage=ppage.navigateToStoresPage();
		people=storepage.navigateToPeoplePage();
}
	
	@Test(priority = 1, enabled = true)
	public void validateTheElementInAddWaiterPopup() {
		people.clickOnWaiterOption();
		people.clickOnAddWaiterBtn();
		
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(people.isWaiterNameDisplayed(), "Failure message::waiter name is not displayed");
		soft.assertTrue(people.isWaiterEmailDisplayed(), "Failure message::waiter email  is not displayed");
		soft.assertTrue(people.isWaiterPhoneDisplayed(), "Failure message::waiter phone  is not displayed");
		soft.assertTrue(people.isWaiterStoreDisplayed(), "Failure message::waiter Store  is not displayed");
		soft.assertAll();
	
	}
}
