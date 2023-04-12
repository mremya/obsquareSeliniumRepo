package com.test;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.AutomationBase;
import com.pages.LoginPage;
import com.utils.PropertyUtils;
import com.utils.WebBrowserUtils;

public class LoginPageTest extends AutomationBase{
	
WebDriver driver;
WebBrowserUtils webbrowser;
LoginPage login;
Properties prop;

@BeforeMethod
public void prerun() throws IOException {
	driver=getDriver();
	login =new LoginPage(driver);
	webbrowser= new WebBrowserUtils();
	prop=PropertyUtils.getProperty("config.properties");
	webbrowser.launchUrl(driver,prop.getProperty("url"));
}

@Test
public void validateLogin() {
	login.enterValueToUserName(prop.getProperty("username"));
	login.enterValueToPassword(prop.getProperty("password"));
	login.clickOnTheElement();
	assertTrue(login.isSuccessHomeLoginMsg(),"Failure msg Login failed");
}

}
