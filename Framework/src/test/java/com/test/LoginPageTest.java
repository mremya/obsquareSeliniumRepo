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

LoginPage login;
Properties prop;



@Test
public void validateLogin() throws Exception {
	driver=getDriver();
 login=new LoginPage(driver);
 prop=new Properties();

	prop=PropertyUtils.getProperty("config.properties");
	login.performlogin(prop.getProperty("username"), prop.getProperty("password"));
	
	assertTrue(login.isSuccessHomeLoginMsg(),"Failure msg Login is failed");
}


}
