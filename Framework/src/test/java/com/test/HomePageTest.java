package com.test;

import java.util.Properties;

import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.constants.AutomationConstants;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ProductPage;
import com.utils.PropertyUtils;
import com.utils.WebBrowserUtils;

public class HomePageTest extends AutomationBase {
	
	WebDriver driver;
	WebBrowserUtils webbrowser;
	LoginPage login;
	HomePage hpage;
	ProductPage ppage;
	Properties prop;

	@Test( enabled = true ,groups= {"smoke"})
	public void validateMenuLinksDisplayedInHomePage()  {
		
		login=new LoginPage(driver);
		 hpage= new HomePage(driver);
		 ppage=new ProductPage(driver);
		 prop = new Properties();
		prop=PropertyUtils.getProperty("config.properties");
		hpage=login.login(prop.getProperty("username"), prop.getProperty("password"));
		ppage = hpage.navigateToProductPage();
		
		SoftAssert soft=new SoftAssert();
		soft.assertTrue(hpage.isProductLinkDisplayed(),AutomationConstants.linkDisplayCkeck);
		soft.assertTrue(hpage.isStoresLinkDisplayed(),AutomationConstants.linkDisplayCkeck);
		soft.assertTrue(hpage.isPeopleLinkDisplayed(),AutomationConstants.linkDisplayCkeck);
		soft.assertTrue(hpage.isSalesLinkDisplayed(),AutomationConstants.linkDisplayCkeck);
		soft.assertTrue(hpage.isExpenseLinkDisplayed(),AutomationConstants.linkDisplayCkeck);
		soft.assertTrue(hpage.isCategoryLinkDisplayed(),AutomationConstants.linkDisplayCkeck);
		soft.assertTrue(hpage.isReportLinkDisplayed(),AutomationConstants.linkDisplayCkeck);
		soft.assertTrue(hpage.isSettingsLinkDisplayed(),AutomationConstants.linkDisplayCkeck);
		soft.assertTrue(hpage.isLogOutDisplayed(),AutomationConstants.linkDisplayCkeck);
		soft.assertTrue(hpage.isLanguageLinkDisplayed(),AutomationConstants.linkDisplayCkeck);
		soft.assertAll();
	}
	}


