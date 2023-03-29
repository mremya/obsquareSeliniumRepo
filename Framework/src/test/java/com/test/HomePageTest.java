package com.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBee;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utils.WebBrowserUtils;

public class HomePageTest extends AutomationBee {
	
	WebDriver driver;
	WebBrowserUtils webbrowser;
	LoginPage login;
	HomePage homepg;
	
	@BeforeMethod
	public void prerun() throws Exception {
		driver=getDriver();
		login =new LoginPage(driver);
		webbrowser= new WebBrowserUtils();
		webbrowser.launchUrl(driver, "https://qalegend.com/restaurant/login");
		homepg=login.login("admin","password");
	}

	@Test
	public void validateMenuLinksDisplayedInHomePage() {
		SoftAssert soft=new SoftAssert();
		soft.assertTrue(homepg.isProductLinkDisplayed(), "Failure message::productlink is not displayed");
		soft.assertTrue(homepg.isStoresLinkDisplayed(), "Failure message::storelink is not displayed");
		soft.assertTrue(homepg.isPeopleLinkDisplayed(),"Failure message::peoplelink is not displayed");
		soft.assertTrue(homepg.isSalesLinkDisplayed(),"Failure message::saleslink is not displayed");
		soft.assertTrue(homepg.isExpenseLinkDisplayed(),"Failure message::Expenselink is not displayed");
		soft.assertTrue(homepg.isCategoryLinkDisplayed(),"Failure message::categorylink is not displayed");
		soft.assertTrue(homepg.isReportLinkDisplayed(),"Failure message::Reportlink is not displayed");
		soft.assertTrue(homepg.isSettingsLinkDisplayed(),"Failure message::Settinglink is not displayed");
		soft.assertTrue(homepg.isLogOutDisplayed(),"Failure message::logout link is not displayed");
		soft.assertTrue(homepg.isLanguageLinkDisplayed(),"Failure message::language link is not displayed");
		soft.assertAll();
	}
	}


