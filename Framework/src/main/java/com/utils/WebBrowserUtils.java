package com.utils;

import org.openqa.selenium.WebDriver;

public class WebBrowserUtils {

	WebDriver driver;

	public void launchUrl(WebDriver driver, String url) {

		try {
			driver.get(url);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

	public void getTitleOfBrowser() {

		try {
			driver.getTitle();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

	public void getCurrentUrlOfBrowser() {

		try {
			driver.getCurrentUrl();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

	public void getPageSourceCodeOfBrowser() {

		try {
			driver.getPageSource();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

	public void navigateToNextUrl(String url) {

		try {
			driver.navigate().to(url);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

	public void navigateToNextPage() {

		try {
			driver.navigate().forward();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

	public void navigateToPreviousPage() {

		try {
			driver.navigate().back();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

	public void refreshWebPage() {

		try {
			driver.navigate().refresh();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

	public void maximizeWebPageSize() {

		try {
			driver.manage().window().maximize();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

	public void minimizeWebPageSize() {

		try {
			driver.manage().window().minimize();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

	public void fullScreenWebPage() {

		try {
			driver.manage().window().fullscreen();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

	public void closeCurrentWebPage() {

		try {
			driver.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

	public void quitWebBrowser() {

		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

}
