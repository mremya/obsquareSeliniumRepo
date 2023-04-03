package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.utils.WebActionUtils;

public class PeopleSupplierPage {


	WebDriver driver;  
	WebActionUtils element = new WebActionUtils();
	
	@FindBy(xpath="(//span[@class='menu-text'])[7]")
	WebElement supplierLink;
	
	@FindBy(xpath="//button[@class='btn btn-add btn-lg']")
	WebElement addSupplierBtn;
	
	@FindBy(xpath="//input[@id='SupplierName']")
	WebElement supplierName;
	
	@FindBy(xpath="//input[@id='SupplierPhone']")
	WebElement supplierPhone;
	
	@FindBy(xpath="//input[@id='SupplierEmail']")
	WebElement supplierEmail;
	
	@FindBy(xpath="//div[@class='note-editable panel-body']")
	WebElement supplierNote;
	
	@FindBy(xpath="//button[@class='btn btn-add']")
	WebElement supplierAddSubmitBtn;
	
	@FindBy(xpath="(//table[@id='Table']//tr//td)[1]")
	WebElement supplierName_searchResult;
	
	@FindBy(xpath="//button[@class='btn btn-add']")
	WebElement supplierPhone_searchResult;
	
	@FindBy(xpath="//button[@class='btn btn-add']")
	WebElement supplierEmail_searchResult;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement  supplierSearch;
	
	@FindBy(xpath="(//a[@class='btn btn-default'])[2]")
	WebElement  supplierEditBtn
;	
	@FindBy(xpath="(//a[@class='btn btn-default'])[1]")
	WebElement  supplierDeleteBtn;
	

	@FindBy(xpath = "//button[@class='btn btn-add']")
	WebElement supplierEditSubmitBtn;
	
	@FindBy(xpath="(//a[@class='btn btn-danger']")
	WebElement  conformDeleteMsg;
	
	@FindBy(xpath="(//table[@id='Table']//tr//td)[1]")
	WebElement delete_searchresult;
	
	public String getTheSearchResultOfDeletedEntry() {
		return element.getTextFunction(driver, delete_searchresult);

	}
	public void clickOnSupplierEditSubmitBtn() {
		element.clickOnTheElement(driver, supplierEditSubmitBtn);
		
	}
	public void clickOnSupplierDeleteConformMsg() {
		element.clickOnTheElement(driver, conformDeleteMsg);
		
	}
	
	public void clickOnSupplierEditIconBtn() {
		element.clickOnTheElement(driver, supplierEditBtn);
		
	}
	
	
	
	public void clickOnSupplierDeleteIconBtn() {
		element.clickOnTheElement(driver, supplierDeleteBtn);
		
	}
	
	public void searchBySupplierName(String supplierName) {

		element.clickOnTheElement(driver, supplierSearch);

		element.entreTheValue(driver, supplierSearch, supplierName);
	}
	
	
	public String getSupplierEmailFromSearchResult() {
		return element.getTextFunction(driver, supplierEmail_searchResult);

	}
	public String getSupplierNameFromSearchResult() {
		return element.getTextFunction(driver, supplierName_searchResult);
	}
	
	public String getSupplierPhoneFromSearchResult() {
		return element.getTextFunction(driver, supplierPhone_searchResult);
	}
	public void clickOnSuplierLink() {
		element.clickOnTheElement(driver, supplierLink);
		
	}
	
	public void clickOnSupplierAddSubmitBtn() {
		element.clickOnTheElement(driver, supplierAddSubmitBtn);
		
	}
	public void clickOnAddSupplierBtn() {
		element.clickOnTheElement(driver, addSupplierBtn);
}

public Boolean isSupplierNameDisplayed() {
		
		return element.isDisplayedFunction(driver, supplierName);

}
public Boolean isSupplierPhoneDisplayed() {
	
	return element.isDisplayedFunction(driver, supplierPhone);

}
public Boolean isSupplierEmailDisplayed() {
	
	return element.isDisplayedFunction(driver, supplierEmail);

}

public Boolean isSupplierNoteDisplayed() {
	
	return element.isDisplayedFunction(driver, supplierNote);

}

public void enterValueForSupplierName(String value) {
	element.clearFunction(supplierName);
	element.entreTheValue(driver, supplierName, value);
}
public void enterValueForSupplierPhone(String value) {
	element.clearFunction(supplierPhone);
	element.entreTheValue(driver, supplierPhone, value);
}
public void enterValueForSupplierEmail(String value) {
	element.clearFunction(supplierEmail);
	element.entreTheValue(driver, supplierEmail, value);
}
public void enterValueForSupplierNote(String value) {
	element.clearFunction(supplierNote);
	element.entreTheValue(driver, supplierNote, value);
}





}
