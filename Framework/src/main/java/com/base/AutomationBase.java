package com.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.constants.AutomationConstants;
import com.pages.LoginPage;
import com.utils.PropertyUtils;
import com.utils.WebBrowserUtils;

public class AutomationBase {

	public WebDriver driver;

	
	LoginPage login;
	Properties prop;
	PropertyUtils propUtil;
	WebBrowserUtils webbrowser = new WebBrowserUtils();

	@BeforeMethod
	@Parameters("browserName")
	public void preLaunch(String browserName) {
		launchBrowser(browserName);
		propUtil = new PropertyUtils();
		prop = PropertyUtils.getProperty("config.properties");
		webbrowser.launchUrl(driver, prop.getProperty("url"));
	}

	@BeforeGroups("smoke")
	@Parameters("browserName")
	public void grouping(String browserName) {
		launchBrowser(browserName);
		propUtil = new PropertyUtils();
		prop = PropertyUtils.getProperty("config.properties");
		webbrowser.launchUrl(driver, prop.getProperty("url"));
	}

	public void launchBrowser(String browserName) {
		switch (browserName) {
		case "Chrome":
			launchChromeBrowser();
			break;

		case "Edge":
			launchEdgeBrowser();
			break;

		case "Firefox":
			launchFirefoxBrowser();
			break;

		default:
			throw new RuntimeException(AutomationConstants.browserNameCheck);

		}

	}

	private void launchChromeBrowser() {

		driver = new ChromeDriver();
		//driver.manage().window().maximize();
		webbrowser.maximizeWebPage(driver);

	}

	private void launchFirefoxBrowser() {

		driver = new FirefoxDriver();
		webbrowser.maximizeWebPage(driver);

	}

	private void launchEdgeBrowser() {

		driver = new EdgeDriver();
		webbrowser.maximizeWebPage(driver);

	}
	public WebDriver getDriver() {
		return driver;
	}
	
}
