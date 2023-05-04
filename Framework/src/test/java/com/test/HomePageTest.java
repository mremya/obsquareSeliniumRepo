package com.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utils.PropertyUtils;
import com.utils.WebBrowserUtils;

public class HomePageTest extends AutomationBase {
	
	WebDriver driver;
	WebBrowserUtils webbrowser;
	LoginPage login;
	HomePage homepg;
	Properties prop;
	
	@BeforeMethod
	public void prerun() throws Exception {
		driver=getDriver();
		login =new LoginPage(driver);
		prop=PropertyUtils.getProperty("config.properties");
		homepg=login.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test( enabled = true ,groups= {"smoke"})
	public void validateMenuLinksDisplayedInHomePage() throws Exception {
		
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


