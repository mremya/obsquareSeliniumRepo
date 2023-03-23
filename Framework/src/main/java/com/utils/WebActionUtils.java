package com.utils;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebActionUtils {

	/**
	 * 
	 * @param textbook
	 * @param driver
	 */
	public void entreTheValue(WebDriver driver, WebElement element, String input) {

		try {
			element.sendKeys(input);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			//System.out.println(e.getCause());
		}
	}

	/**
	 * 
	 * @param radiobutton
	 * @param driver
	 */
	public void clickOnTheElement(WebDriver driver, WebElement element) {

		try {
			element.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param radiobutton
	 * @param driver
	 */
	public void clearFunction(WebElement radiobutton) {

		try {
			radiobutton.clear();
		} catch (Exception e) {
			e.getMessage();
			e.getCause();
		}
	}

	/**
	 * 
	 * @param submitbutton
	 * @param driver
	 */
	public void submitFunction(WebDriver driver, WebElement element) {

		try {
			element.submit();
		} catch (Exception e) {
			e.getMessage();
			e.getCause();
		}
	}

	/**
	 * 
	 * @param radiobutton
	 * @param driver
	 * @return
	 */

	public boolean isSelectedFunction(WebDriver driver, WebElement element) {

		boolean temp = false;
		try {
			temp = element.isSelected();
		} catch (Exception e) {
			e.getMessage();
			e.getCause();
		}

		return temp;

	}

	/**
	 * 
	 * @param submitbutton
	 * @param driver
	 * @return
	 */
	public boolean isEnabledFunction(WebDriver driver, WebElement element) {
		boolean temp = false;

		try {
			temp = element.isEnabled();
		} catch (Exception e) {
			e.getMessage();
			e.getCause();
		}
		return temp;

	}

	/**
	 * 
	 * @param submitbutton
	 * @param driver
	 * @return
	 */
	public boolean isDisplayedFunction(WebDriver driver, WebElement element) {
		boolean temp = false;

		try {
			temp = element.isDisplayed();
		} catch (Exception e) {
			e.getMessage();
			e.getCause();
		}
		return temp;

	}

	/**
	 * 
	 * @param textbox
	 * @param driver
	 * @return
	 */
	public String getTextFunction(WebDriver driver, WebElement element) {
		String temp = null;

		try {
			temp = element.getText();
		} catch (Exception e) {
			e.getMessage();
			e.getCause();
		}

		return temp;

	}

	/**
	 * 
	 * @param searchbox
	 * @param driver
	 * @return
	 */
	public String getTextTagNameFunction(WebDriver driver, WebElement element) {

		String temp = null;
		try {
			temp = element.getTagName();
		} catch (Exception e) {
			e.getMessage();
			e.getCause();

		}
		return temp;

	}

	/**
	 * 
	 * @param textbox
	 * @param driver
	 * @return
	 */
	public String getAttributeFunction(WebDriver driver, WebElement element, String attribute) {
		String temp = null;

		try {
			temp = element.getAttribute(attribute);
		} catch (Exception e) {
			e.getMessage();
			e.getCause();
		}
		return temp;

	}

	/**
	 * 
	 * @param textbox
	 * @param driver
	 * @return
	 */
	public Dimension getSizeFunction(WebDriver driver, WebElement element) {

		Dimension temp = null;
		try {
			temp = element.getSize();
		} catch (Exception e) {
			e.getMessage();
			e.getCause();
		}
		return temp;

	}

	/**
	 * 
	 * @param textbox
	 * @param driver
	 * @return
	 */
	public Point getLocationFunction(WebDriver driver, WebElement element) {

		Point temp = null;
		try {
			temp = element.getLocation();
		} catch (Exception e) {
			e.getMessage();
			e.getCause();
		}
		return temp;
	}

	/**
	 * 
	 * @param textbox
	 * @param driver
	 * @return
	 */
	public String getCssValueFunction(WebDriver driver, WebElement element, String attribute) {

		String temp = null;
		try {
			temp = element.getCssValue(attribute);
		} catch (Exception e) {
			e.getMessage();
			e.getCause();
		}
		return temp;
	}

}
