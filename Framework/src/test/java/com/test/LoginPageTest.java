package com.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.AutomationBase;
import com.constants.AutomationConstants;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utils.PropertyUtils;

public class LoginPageTest extends AutomationBase {

	WebDriver driver;

	LoginPage login;
	Properties prop;
	HomePage hpage;

	@Test(enabled = true, groups = { "smoke" }, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateLogin() throws Exception {
		driver = getDriver();
		login = new LoginPage(driver);
		prop = new Properties();
		prop = PropertyUtils.getProperty("config.properties");
		login.performlogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(login.isSuccessHomeLoginMsg(), AutomationConstants.loginCkeck);
	}

}
