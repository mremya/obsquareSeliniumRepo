package com.utils;

import org.openqa.selenium.WebDriver;

public class WebBrowserUtils {

	

	/**
	 * 
	 * @param driver
	 * @param url
	 */
	public void launchUrl(WebDriver driver, String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

	/**
	 * 
	 * @param driver
	 * @return
	 */

	public String getTitleOfBrowser(WebDriver driver) {
		String title = null;
		try {
			title = driver.getTitle();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
		return title;
	}

	/**
	 * 
	 * @param driver
	 * @return
	 */
	public String getCurrentUrlOfBrowser(WebDriver driver) {
		String currentUrl = null;
		try {
			currentUrl = driver.getCurrentUrl();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
		return currentUrl;
	}

	/**
	 * 
	 * @param driver
	 * @return
	 */
	public String getPageSourceCodeOfBrowser(WebDriver driver) {
		String pageSource = null;
		try {
			pageSource = driver.getPageSource();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
		return pageSource;
	}

	/**
	 * 
	 * @param driver
	 * @param url
	 */
	public void navigateToNextUrl(WebDriver driver, String url) {

		try {
			driver.navigate().to(url);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

	/**
	 * 
	 * @param driver
	 */
	public void navigateToNextPage(WebDriver driver) {

		try {
			driver.navigate().forward();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

	/**
	 * 
	 * @param driver
	 */
	public void navigateToPreviousPage(WebDriver driver) {

		try {
			driver.navigate().back();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

	/**
	 * 
	 * @param driver
	 */
	public void refreshWebPage(WebDriver driver) {

		try {
			driver.navigate().refresh();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

	/**
	 * 
	 * @param driver
	 */
	public void maximizeWebPageSize(WebDriver driver) {

		try {
			driver.manage().window().maximize();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

	/**
	 * 
	 * @param driver
	 */
	public void minimizeWebPageSize(WebDriver driver) {

		try {
			driver.manage().window().minimize();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

	/**
	 * 
	 * @param driver
	 */
	public void fullScreenWebPage(WebDriver driver) {

		try {
			driver.manage().window().fullscreen();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

	/**
	 * 
	 * @param driver
	 */
	public void closeCurrentWebPage(WebDriver driver) {

		try {
			driver.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

	/**
	 * 
	 * @param driver
	 */
	public void quitWebBrowser(WebDriver driver) {

		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

}
