package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.GenericUtils;
import com.utils.WebActionUtils;

public class PeopleWaiterPage {
	
	WebDriver driver;  
	WebActionUtils element = new WebActionUtils();
    GenericUtils  dropdownsel=new GenericUtils();
	
	@FindBy(xpath="(//span[@class='menu-text'])[5]")
	private WebElement waiterLink;
	
	@FindBy(xpath="//button[@class='btn btn-add btn-lg']")
	 private WebElement  addWaiterBtn;
	
	@FindBy(xpath="//input[@id='WaiterName']")
	private WebElement  waiterName;
	
	@FindBy(xpath="//input[@id='WaiterPhone']")
	private WebElement  waiterPhone;
	
	@FindBy(xpath="//input[@id='WaiterEmail']")
	private WebElement  waiterEmail;
     
	@FindBy(xpath="//select[@id='WaiterStore']")
	private WebElement  waiterStore;
	
	@FindBy(xpath="//button[@class='btn btn-add']")
	private WebElement  addWaiterSubmitBtn;
	
	@FindBy(xpath="//button[@class='btn btn-add']")
	private WebElement  addWaiterCloseBtn;
	
	
	@FindBy(xpath="//input[@type='search']")
	private WebElement  waiterSearchBtn;
	
	@FindBy(xpath="(//table[@id='Table']//tr//td)[1]")
	private WebElement  waiterName_SearchResult;
	
	@FindBy(xpath="(//table[@id='Table']//tr//td)[3]")
	private WebElement  waiterEmail_SearchResult;
	
	@FindBy(xpath="(//table[@id='Table']//tr//td)[2]")
	 private WebElement  waiterPhone_SearchResult;
	
	@FindBy(xpath="(//table[@id='Table']//tr//td)[4]")
	private WebElement  waiterStore_SearchResult;
	
	@FindBy(xpath="(//a[@class='btn btn-default'])[2]")
	private WebElement  editicon;
	
	@FindBy(xpath="//button[@class='btn btn-add']")
	private WebElement  editiconSubmit;
	
	@FindBy(xpath="(//a[@class='btn btn-default'])[1]")
	private WebElement  deleteIcon;
	
	@FindBy(xpath="(//a[@class='btn btn-danger']")
	private WebElement  conformDeleteMsg;
	
	@FindBy(xpath="(//table[@id='Table']//tr//td)[1]")
	private WebElement  delete_searchresult;
	
	@FindBy(xpath="(//span[@class='menu-text'])[9]")
	 private WebElement expenseLink;
	
	public PeopleWaiterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getWaiterSearchResultOfDeletedEntry() {
		return element.getTextFunction(driver, delete_searchresult);
		
	}
	public void clickOnaddWaiterCloseBtn() {
		 element.clickOnTheElement(driver, addWaiterCloseBtn);
	}
	
	public void clickOnDeleteConformMsg() {
		 element.clickOnTheElement(driver, conformDeleteMsg);
	}
	public void clickOnEditIconInWaiter() {
		 element.clickOnTheElement(driver, editicon);
	}
	
	public void clickOnDeleteIconInWaiter() {
		 element.clickOnTheElement(driver, deleteIcon);
	}
	
	public void clickOnEditWaiterSubmit() {
		 element.clickOnTheElement(driver, editiconSubmit);
	}
	
	

	public void clickOnWaiterLink() {
		element.clickOnTheElement(driver, waiterLink);
		
	}
	
	public void clickOnAddWaiterBtn() {
		 element.clickOnTheElement(driver, addWaiterBtn);
	}
	
	public void clickOnsubmitBtnInWaitersAddPopUp() {
		 element.clickOnTheElement(driver, addWaiterSubmitBtn);
	}
	
	
	
public Boolean isWaiterNameDisplayed() {
		
		return element.isDisplayedFunction(driver, waiterName);

}
public Boolean isWaiterPhoneDisplayed() {
	
	return element.isDisplayedFunction(driver, waiterPhone);

}
public Boolean isWaiterEmailDisplayed() {
	
	return element.isDisplayedFunction(driver, waiterEmail);

}
public Boolean isWaiterStoreDisplayed() {
	
	return element.isDisplayedFunction(driver, waiterStore);

}

public void enterValueForWaiterName(String value) {
	element.clearFunction(waiterName);
	element.entreTheValue(driver, waiterName, value);
}

public void enterValueForWaiterPhone(String value) {
	element.clearFunction(waiterPhone);
	element.entreTheValue(driver, waiterPhone, value);
}

public void enterValueForWaiterEmail(String value) {
	element.clearFunction(waiterEmail);
	element.entreTheValue(driver, waiterEmail, value);
}

public void selectValueForWaiterStore(String value) {
	dropdownsel.selectByValue(driver, waiterStore, value);
}

public void searchByWaitersName(String waiterName) {
	
	element.clearFunction(waiterSearchBtn);
	element.clickOnTheElement(driver, waiterSearchBtn);
	
	element.entreTheValue(driver, waiterSearchBtn, waiterName);
}

public String getWaiterNameFromSearchResult() {
	return element.getTextFunction(driver, waiterName_SearchResult);
	
}	

public String getWaiterPhoneFromSearchResult() {
	return element.getTextFunction(driver, waiterPhone_SearchResult);
	
}	

public String getWaiterEmailFromSearchResult() {
	return element.getTextFunction(driver, waiterEmail_SearchResult);
	
}	
public String getWaiterStoreFromSearchResult() {
	return element.getTextFunction(driver, waiterStore_SearchResult);
	
}	

	
}
