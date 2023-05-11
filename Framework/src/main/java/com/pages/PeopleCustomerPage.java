package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.GenericUtils;
import com.utils.WebActionUtils;

public class PeopleCustomerPage {
	
	WebDriver driver;  
	WebActionUtils element = new WebActionUtils();
    GenericUtils  dropdownsel=new GenericUtils();
    
	@FindBy(xpath="//input[@id='CustomerName']")
	WebElement customerName;
	
	@FindBy(xpath="//input[@id='CustomerEmail']")
	WebElement  customerEmail;
	
	@FindBy(xpath="//input[@id='CustomerPhone']")
	WebElement  customerPhone;
	
	@FindBy(xpath="//input[@id='CustomerDiscount']")
	WebElement  customerDiscount;
	
	@FindBy(xpath="//input[@id='CustomerDiscount']")
	WebElement  addCustomerBtn;
	
	@FindBy(xpath="//input[@id='CustomerDiscount']")
	WebElement  addCustomerSubmitBtn;
	
	@FindBy(xpath="(//span[@class='menu-text'])[6]")
	WebElement  customerLink;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement  customerSearch;
	
	@FindBy(xpath="(//table[@id='Table']//tr//td)[1]")
	WebElement  customerName_searchresult;
	
	@FindBy(xpath="(//table[@id='Table']//tr//td)[2]")
	WebElement  customerPhone_searchresult;
	
	@FindBy(xpath="(//table[@id='Table']//tr//td)[3]")
	WebElement  customerEmail_searchresult;
	
	@FindBy(xpath="(//table[@id='Table']//tr//td)[4]")
	WebElement  customerDidcount_searchresult;
	
	@FindBy(xpath = "(//a[@class='btn btn-default'])[2]")
	WebElement customerEditBtn	;
	
	@FindBy(xpath = "(//button[@class='btn btn-default'] ")
	WebElement AddcustomerClosetBtn	;
	
	
	@FindBy(xpath = "(//a[@class='btn btn-default'])[1]")
	WebElement storeDeleteBtn;
	
	@FindBy(xpath = "//button[@class='btn btn-add']")
	WebElement editSubmitBtn;
	
	@FindBy(xpath="(//a[@class='btn btn-danger']")
	WebElement  conformDeleteMsg;
	
	@FindBy(xpath="(//table[@id='Table']//tr//td)[1]")
	WebElement delete_searchresult;
	
	public  PeopleCustomerPage(WebDriver driver) {
		
		 
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

	public String getcustomerNameFromSearchResult() {
		return element.getTextFunction(driver, customerName_searchresult);

	}

	public String getCustomerPhoneFromSearchResult() {
		return element.getTextFunction(driver, customerPhone_searchresult);

	}

	public String getCustomerEmailFromSearchResult() {
		return element.getTextFunction(driver, customerEmail_searchresult);

	}
	public String getCustomerDiscountFromSearchResult() {
		return element.getTextFunction(driver, customerDidcount_searchresult);

	}
	public void searchByCustomerName(String customerName) {

		element.clickOnTheElement(driver, customerSearch);

		element.entreTheValue(driver, customerSearch, customerName);
	}
	
	public void clickOnCustomerEditSubmit() {
		element.clickOnTheElement(driver, editSubmitBtn);
		
	}
	
	public void clickOnCustomerLink() {
		element.clickOnTheElement(driver, customerLink);
		
	}
	public void clickOnAddCustomerBtn() {
		element.clickOnTheElement(driver, addCustomerBtn);
		
	}
	public void clickOnAddCustomerCloseBtn() {
		element.clickOnTheElement(driver, addCustomerBtn);
		
	}
	
	public void clickOnAddCustomerSubmitBtn() {
		element.clickOnTheElement(driver, customerLink);
		
	}
	public void clickOnCustomerEditIconBtn() {
		element.clickOnTheElement(driver, customerEditBtn);
		
	}
	
	public void clickOnCustomerDeleteIconBtn() {
		element.clickOnTheElement(driver, customerLink);
		
	}
	
	public void clickOnCustomerDeleteConformMsgBtn() {
		element.clickOnTheElement(driver, conformDeleteMsg);
		
	}
	public String getTheSearchResultOfDeletedEntry() {
		return element.getTextFunction(driver, delete_searchresult);

	}
	
	
public Boolean isCustomerNameDisplayed() {
		
		return element.isDisplayedFunction(driver, customerName);

}
public Boolean isCustomerPhoneDisplayed() {
	
	return element.isDisplayedFunction(driver, customerPhone);

}
public Boolean isCustomerEmailDisplayed() {
	
	return element.isDisplayedFunction(driver, customerEmail);

}

public Boolean isCustomerDiscountDisplayed() {
	
	return element.isDisplayedFunction(driver, customerDiscount);

}
public void enterValueForCustomerName(String value) {
	element.clearFunction(customerName);
	element.entreTheValue(driver, customerName, value);
}
public void enterValueForCustomerPhone(String value) {
	element.clearFunction(customerPhone);
	element.entreTheValue(driver, customerPhone, value);
}
public void enterValueForCustomerEmail(String value) {
	element.clearFunction(customerEmail);
	element.entreTheValue(driver, customerEmail, value);
}
public void enterValueForCustomerDiscount(String value) {
	element.clearFunction(customerDiscount);
	element.entreTheValue(driver, customerDiscount, value);
}

}
