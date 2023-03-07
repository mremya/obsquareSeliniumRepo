package com.utils;

import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GenericUtils {
	
	public void selectByValue(Driver driver , WebElement element, String value) {
		Select select =new Select(element);
		try {
			select.selectByValue(value);
		} catch (Exception e) {
			e.getMessage();
			e.getCause();
		}
		
	}

	public void selectByIndex(Driver driver ,WebElement element, int index) {
		Select select =new Select(element);
		try {
			select.selectByIndex(index);
		} catch (Exception e) {
			e.getMessage();
			e.getCause();
		}
		
	}

	public void selectByVisibleText(Driver driver , WebElement element, String value) {
		Select select =new Select(element);
		try {
			select.selectByVisibleText(value);
		} catch (Exception e) {
			e.getMessage();
			e.getCause();
		}
		
	}
	public List<WebElement> getOption(Driver driver , WebElement element) {

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
	
	public List<WebElement> getAllselectedOPtions(Driver driver , WebElement element) {

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
	
	
	public void  getFirstSelectedOptions(Driver driver , WebElement element) {

		Select select=new Select(element);
		
		try {
			select.getFirstSelectedOption();
		} catch (Exception e) {
			e.getMessage();
			e.getCause();
		}
	}
	
	public void  deSelectAll(Driver driver , WebElement element) {

		Select select=new Select(element);
		
		try {
			select.deselectAll();
		} catch (Exception e) {
			e.getMessage();
			e.getCause();
		}
	}
	
	
	public void  deSelectByIndex(Driver driver , WebElement element, int index) {

		Select select=new Select(element);
		
		try {
			select.deselectByIndex(index);
		} catch (Exception e) {
			e.getMessage();
			e.getCause();
		}
	}
	
	
	public void  deSelectByValue(Driver driver , WebElement element, String value ) {

		Select select=new Select(element);
		
		try {
			select.deselectByValue(value);
		} catch (Exception e) {
			e.getMessage();
			e.getCause();
		}
	}
	
	public void  deSelectByVisibleText(Driver driver , WebElement element, String value ) {

		Select select=new Select(element);
		
		try {
			select.deselectByVisibleText(value);
		} catch (Exception e) {
			e.getMessage();
			e.getCause();
		}
	}
}










