package com.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.constants.AutomationConstants;
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
		soft.assertTrue(homepg.isProductLinkDisplayed(),AutomationConstants.linkDisplayCkeck);
		soft.assertTrue(homepg.isStoresLinkDisplayed(),AutomationConstants.linkDisplayCkeck);
		soft.assertTrue(homepg.isPeopleLinkDisplayed(),AutomationConstants.linkDisplayCkeck);
		soft.assertTrue(homepg.isSalesLinkDisplayed(),AutomationConstants.linkDisplayCkeck);
		soft.assertTrue(homepg.isExpenseLinkDisplayed(),AutomationConstants.linkDisplayCkeck);
		soft.assertTrue(homepg.isCategoryLinkDisplayed(),AutomationConstants.linkDisplayCkeck);
		soft.assertTrue(homepg.isReportLinkDisplayed(),AutomationConstants.linkDisplayCkeck);
		soft.assertTrue(homepg.isSettingsLinkDisplayed(),AutomationConstants.linkDisplayCkeck);
		soft.assertTrue(homepg.isLogOutDisplayed(),AutomationConstants.linkDisplayCkeck);
		soft.assertTrue(homepg.isLanguageLinkDisplayed(),AutomationConstants.linkDisplayCkeck);
		soft.assertAll();
	}
	}


