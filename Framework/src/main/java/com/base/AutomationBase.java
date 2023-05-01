package com.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
	public void preRun(String browserName) throws Exception {
		launchBrowser(browserName);
		login =new LoginPage(driver);
		webbrowser= new WebBrowserUtils();
		prop=PropertyUtils.getProperty("config.properties");
		webbrowser.launchUrl(driver,prop.getProperty("url"));
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
			System.out.println( AutomationConstants.browserNameCheck);
			
			break;
		}

	}

	private void launchChromeBrowser() throws Exception {
		try {

			ChromeOptions ops = new ChromeOptions();
			  ops.addArguments("--remote-allow-origins=*");
			  WebDriver driver = new ChromeDriver(ops);
			// driver=new ChromeDriver();
			
			  webbrowser.maximizeWebPageSize(driver);
		} catch (Exception e) {
			throw new Exception(e);

		}
	}

	private void launchFirefoxBrowser() throws Exception {
		try {

			driver = new FirefoxDriver();
			webbrowser.maximizeWebPageSize(driver);
		} catch (Exception e) {
			throw new Exception(e);

		}
	}

	private void launchEdgeBrowser() throws Exception {
		try {

			driver = new EdgeDriver();
			webbrowser.maximizeWebPageSize(driver);
		} catch (Exception e) {
			throw new Exception(e);

		}
	}

	public  WebDriver getDriver() {// to return the driver
		return driver;
	}
@AfterTest
	public void quitBrowser() {
	webbrowser.closeCurrentWebPage(driver);
	}
}
