package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.GenericUtils;
import com.utils.WaitUtils;
import com.utils.WebActionUtils;

public class PeopleCustomerPage {
	
	WebDriver driver;  
	WebActionUtils element = new WebActionUtils();
    GenericUtils  dropdownsel=new GenericUtils();
    WaitUtils wait=new WaitUtils();
    
	@FindBy(xpath="//input[@id='CustomerName']")
	private WebElement customerName;
	
	@FindBy(xpath="//input[@id='CustomerEmail']")
	private WebElement  customerEmail;
	
	@FindBy(xpath="//input[@id='CustomerPhone']")
	private WebElement  customerPhone;
	
	@FindBy(xpath="//input[@id='CustomerDiscount']")
	private WebElement  customerDiscount;
	
	@FindBy(xpath="//button[@class='btn btn-add btn-lg']")
	private WebElement  addCustomerBtn;
	
	@FindBy(xpath="//button[@class='btn btn-add']")
	private WebElement  addCustomerSubmitBtn;
	
	@FindBy(xpath="(//span[@class='menu-text'])[6]")
	private WebElement  customerLink;
	
	@FindBy(xpath="//input[@type='search']")
	private WebElement  customerSearch;
	
	@FindBy(xpath="(//table[@id='Table']//tr//td)[1]")
	private WebElement  customerName_searchresult;
	
	@FindBy(xpath="(//table[@id='Table']//tr//td)[2]")
	private WebElement  customerPhone_searchresult;
	
	@FindBy(xpath="(//table[@id='Table']//tr//td)[3]")
	private WebElement  customerEmail_searchresult;
	
	@FindBy(xpath="(//table[@id='Table']//tr//td)[4]")
	private WebElement  customerDidcount_searchresult;
	
	@FindBy(xpath = "(//a[@class='btn btn-default'])[2]")
	private WebElement customerEditBtn	;
	
	@FindBy(xpath = "(//button[@class='btn btn-default'] ")
	private WebElement AddcustomerClosetBtn	;
	
	
	@FindBy(xpath = "(//a[@class='btn btn-default'])[1]")
	private WebElement storeDeleteBtn;
	
	@FindBy(xpath = "//button[@class='btn btn-add']")
	private WebElement editSubmitBtn;
	
	@FindBy(xpath="(//a[@class='btn btn-danger']")
	private WebElement  conformDeleteMsg;
	
	@FindBy(xpath="(//table[@id='Table']//tr//td)[1]")
	private WebElement delete_searchresult;
	
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
		element.clickOnTheElement(driver, AddcustomerClosetBtn);
		
	}
	
	public void clickOnAddCustomerSubmitBtn() {
		//wait.waitForElementToBeClickable(driver, addCustomerSubmitBtn, 20);
		element.clickOnTheElement(driver, addCustomerSubmitBtn);
		
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
public void customerImplicitwait() {
	wait.implicitWait(driver, 20);

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
	wait.waitForElementToBeClickable(driver, customerName, 20);
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
