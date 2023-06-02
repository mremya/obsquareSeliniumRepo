package com.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionAndJavaScriptExecutorUtils {

	Actions action;
	JavascriptExecutor js;

	/**
	 * Perform Click Action on the Web Element
	 * 
	 * @param driver
	 * @param element
	 */
	public void clickMethodOnWebElement(WebDriver driver, WebElement element) {
		action = new Actions(driver);
		try {
			action.moveToElement(element).click().build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Right click on WebElement
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClickMethodOnWebElement(WebDriver driver, WebElement element) {
		action = new Actions(driver);
		try {
			action.contextClick(element).click().build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Double click on WebElement
	 * 
	 * @param driver
	 * @param element
	 */
	public void doubleClickMethodOnWebElement(WebDriver driver, WebElement element) {
		action = new Actions(driver);
		try {
			action.doubleClick(element).build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void clickAndHoldMethodOnWebElement(WebDriver driver, WebElement element) {
		action = new Actions(driver);
		try {
			action.clickAndHold(element).build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * drag and drop the webelement
	 * 
	 * @param driver
	 * @param dragElement
	 * @param dropElement
	 */
	public void dragAndDropMethodOnWebelement(WebDriver driver, WebElement dragElement, WebElement dropElement) {
		action = new Actions(driver);
		try {
			action.dragAndDrop(dragElement, dropElement).build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Method to move cursor according to mentioned x and y coordinate
	 * 
	 * @param driver
	 * @param coordinateX
	 * @param coordinateY
	 */
	public void moveByOffsetMethodByXAndYCoordinate(WebDriver driver, int coordinateX, int coordinateY) {
		action = new Actions(driver);
		try {
			action.moveByOffset(coordinateX, coordinateY).build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 /**
	 * Method to scroll down the page
	 */
	  public void scrollDown(WebDriver driver,int  coordinateX, int coordinateY) {
		  try { 
			  js =(JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(coordinateX,coordinateY)"); 
	  } catch(Exception e)
		  { // TODO Auto-generated catch block 
		  e.printStackTrace();
		  
		  }
	  }
	  
	  

	    /**
		 * Method to scroll up the page
		 */
	
	  public void scrollUp(WebDriver driver, int coordinateX, int coordinateY) {
		  try {
			  js=(JavascriptExecutor) driver;
			  js.executeScript("window.scrollBy(coordinateX,-coordinateY)");
		  }catch(Exception e){
			    // TODO Auto-generated catch block 
			   e.printStackTrace(); 
			   
	  
	    
	   }
	   
   }
	  
	    

}
