package com.test;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.AutomationBee;
import com.pages.LoginPage;
import com.utils.WebBrowserUtils;

public class LoginPageTest extends AutomationBee{
	
WebDriver driver;
WebBrowserUtils webbrowser;
LoginPage login;

@BeforeMethod
public void prerun() throws IOException {
	driver=getDriver();
	login =new LoginPage(driver);
	webbrowser= new WebBrowserUtils();
	webbrowser.launchUrl(driver, "https://qalegend.com/restaurant/login");
}

@Test
public void validateLogin() {
	login.enterValueToUserName("admin");
	login.enterValueToPassword("password");
	login.clickOnTheElement();
}

}
