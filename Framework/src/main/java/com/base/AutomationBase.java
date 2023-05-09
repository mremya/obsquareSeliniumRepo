package com.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.constants.AutomationConstants;
import com.pages.LoginPage;
import com.utils.PropertyUtils;
import com.utils.WebBrowserUtils;

public class AutomationBase {

	static WebDriver driver;

	WebBrowserUtils webbrowser;
	LoginPage login;
	Properties prop;

	@BeforeTest
	@Parameters("browserName")
	public void preLaunch(String browserName) {
		try {
			launchBrowser(browserName);
			login = new LoginPage(driver);
			webbrowser = new WebBrowserUtils();

			prop = PropertyUtils.getProperty("config.properties");
		} catch (Exception e) {
			throw new RuntimeException("Error while reading config property file");
		}
		webbrowser.launchUrl(driver, prop.getProperty("url"));
	}

	public void launchBrowser(String browserName) throws Exception {
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
		driver.manage().window().maximize();
		//webbrowser.maximizeWebPageSize(driver);

	}

	private void launchFirefoxBrowser() {

		driver = new FirefoxDriver();
		//webbrowser.maximizeWebPageSize(driver);

	}

	private void launchEdgeBrowser() {

		driver = new EdgeDriver();
		//webbrowser.maximizeWebPageSize(driver);

	}

	public WebDriver getDriver() {// to return the driver
		return driver;
	}

	//@AfterTest
	public void quitBrowser() {
		webbrowser.closeCurrentWebPage(driver);
	}
}
