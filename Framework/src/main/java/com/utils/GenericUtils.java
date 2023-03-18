package com.utils;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GenericUtils {
	
	
	/**
	 * 
	 * @param WebDriver
	 * @param element
	 * @param value
	 */
	public void selectByValue(WebDriver driver , WebElement element, String value) {
		Select select =new Select(element);
		try {
			select.selectByValue(value);
		} catch (Exception e) {
			e.getMessage();
			e.getCause();
		}
		
	}
/**
 * 
 * @param WebDriver
 * @param element
 * @param index
 */
	public void selectByIndex(WebDriver driver ,WebElement element, int index) {
		Select select =new Select(element);
		try {
			select.selectByIndex(index);
		} catch (Exception e) {
			e.getMessage();
			e.getCause();
		}
		
	}
/**
 * 
 * @param WebDriver
 * @param element
 * @param value
 */
	public void selectByVisibleText(WebDriver driver , WebElement element, String value) {
		Select select =new Select(element);
		try {
			select.selectByVisibleText(value);
		} catch (Exception e) {
			e.getMessage();
			e.getCause();
		}
		
	}
	/**
	 * 
	 * @param WebDriver
	 * @param element
	 * @return
	 */
	public List<WebElement> getOption(WebDriver driver , WebElement element) {

		List<WebElement> option=null;
		Select select=new Select(element);
		try {
			select.getOptions();
		} catch (Exception e) {
			e.getMessage();
			e.getCause();
		}
		return option;

	}
	/**
	 * 
	 * @param WebDriver
	 * @param element
	 * @return
	 */
	public List<WebElement> getAllselectedOPtions(WebDriver driver , WebElement element) {

		List<WebElement> option=null;
		Select select=new Select(element);
		try {
			select.getAllSelectedOptions();
		} catch (Exception e) {
			e.getMessage();
			e.getCause();
		}
		return option;

	}
	
	/**
	 * 
	 * @param WebDriver
	 * @param element
	 */
	public void  getFirstSelectedOptions(WebDriver driver , WebElement element) {

		Select select=new Select(element);
		
		try {
			select.getFirstSelectedOption();
		} catch (Exception e) {
			e.getMessage();
			e.getCause();
		}
	}
	/**
	 * 
	 * @param WebDriver
	 * @param element
	 */
	public void  deSelectAll(WebDriver driver , WebElement element) {

		Select select=new Select(element);
		
		try {
			select.deselectAll();
		} catch (Exception e) {
			e.getMessage();
			e.getCause();
		}
	}
/**
 * 	
 * @param WebDriver
 * @param element
 * @param index
 */
	
	public void  deSelectByIndex(WebDriver driver , WebElement element, int index) {

		Select select=new Select(element);
		
		try {
			select.deselectByIndex(index);
		} catch (Exception e) {
			e.getMessage();
			e.getCause();
		}
	}
	
	/**
	 * 
	 * @param WebDriver
	 * @param element
	 * @param value
	 */
	public void  deSelectByValue(WebDriver driver , WebElement element, String value ) {

		Select select=new Select(element);
		
		try {
			select.deselectByValue(value);
		} catch (Exception e) {
			e.getMessage();
			e.getCause();
		}
	}
	/**
	 * 
	 * @param WebDriver
	 * @param element
	 * @param value
	 */
	public void  deSelectByVisibleText(WebDriver driver , WebElement element, String value ) {

		Select select=new Select(element);
		
		try {
			select.deselectByVisibleText(value);
		} catch (Exception e) {
			e.getMessage();
			e.getCause();
		}
	}
	
	public void dismissAnAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
		
	}
	
	public void acceptAnAlert(WebDriver driver) {
		driver.switchTo().alert().accept();  
		
	}
	
	public void enterValueToAnAlert(WebDriver driver, String input) {
		driver.switchTo().alert().sendKeys(input);   
			
		}
	
	public void getTitleOfAlert(WebDriver driver) {
	
		driver.switchTo().alert().getText(); 
	}
	
	
}










