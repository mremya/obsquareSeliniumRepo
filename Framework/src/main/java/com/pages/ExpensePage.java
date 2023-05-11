package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.GenericUtils;
import com.utils.WebActionUtils;

public class ExpensePage {
	
	WebDriver driver;  
	WebActionUtils element = new WebActionUtils();
	 GenericUtils  dropdownsel=new GenericUtils();
	 
	 WebDriverWait expwait= new WebDriverWait(driver, Duration.ofSeconds(20));  //explicit wait declaration
	
	@FindBy(xpath="//button[@class='btn btn-add btn-lg']")
	WebElement addExpense;
	
	@FindBy(xpath="//input[@id='Date']")
	WebElement eDate;
	
	@FindBy(xpath="//input[@id='Reference']")
	WebElement eReference;
	
	@FindBy(xpath="//select[@id='Category']")
	WebElement eCategory;
	
	@FindBy(xpath="//select[@id='store_id']")
	WebElement eStore;
	
	@FindBy(xpath="//input[@id='Amount']")
	WebElement eAmount;
	
	
	@FindBy(xpath="//button[@class='btn btn-add']")
	WebElement addExpense_submit;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement searchbtn;
	
	
	@FindBy(xpath="(//table[@id='Table']//tr//td)[1]")
	WebElement expenseDate_searchresult;
	
	@FindBy(xpath="(//table[@id='Table']//tr//td)[2]")
	WebElement expenseReference_searchresult;
	
	@FindBy(xpath="(//table[@id='Table']//tr//td)[3]")
	WebElement expenseAmount_searchresult;
	
	@FindBy(xpath="(//table[@id='Table']//tr//td)[4]")
	WebElement expenseCategory_searchresult;
	
	@FindBy(xpath="(//table[@id='Table']//tr//td)[5]")
	WebElement expenseStore_searchresult;
	
	@FindBy(xpath = "(//a[@class='btn btn-default'])[1]")
	WebElement expenseDeleteBtn;
	
	@FindBy(xpath = "(//a[@class='btn btn-default'])[2]")
	WebElement expenseEditBtn;
	
	@FindBy(xpath = "(//button[@class='confirm']")
	WebElement expenseDeleteConformMsg;
	
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[1]")
	WebElement expenseDelete_searchResult;
	
	@FindBy(xpath = "(//button[@class='confirm']")
	WebElement okConformationForDelete;
	
	@FindBy(xpath = "//button[@class='btn btn-add']")
	WebElement editSubmitBtn;
	
	@FindBy(xpath = "//button[@class='btn btn-default']")
	WebElement addExpenseCloseBtn;
	
	public  ExpensePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnaddExpenseCloseBtn() {

		element.clickOnTheElement(driver, addExpenseCloseBtn);
	}
	
	public void clickOnEditSubmit() {

		element.clickOnTheElement(driver, editSubmitBtn);
	}
	
	
	public String getTheSearchResultOfDeletedEntry() {
		return element.getTextFunction(driver, expenseDelete_searchResult);

	}
	
	public void clickOnDeleteIcon() {

		element.clickOnTheElement(driver, expenseDeleteBtn);
	}
	public void clickOnDeleteOk() {

		element.clickOnTheElement(driver, okConformationForDelete);
	}
	
	public void clickOnDeleteConformMsg() {

		element.clickOnTheElement(driver, expenseDeleteConformMsg);
	}
	
	public void clickOnEditIcon() {

		element.clickOnTheElement(driver, expenseEditBtn);
	}
	
	public String getExpensDateFromSearchResult() {
		return element.getTextFunction(driver, expenseDate_searchresult);
		
	}	
	public String getExpensReferenceFromSearchResult() {
		return element.getTextFunction(driver, expenseReference_searchresult);
		
	}	
	
	public String getExpensAmountFromSearchResult() {
		return element.getTextFunction(driver, expenseAmount_searchresult);
		
	}	
	
	public String getExpensStoreFromSearchResult() {
		return element.getTextFunction(driver, expenseStore_searchresult);
		
	}	
	public String getExpensCategoryFromSearchResult() {
		return element.getTextFunction(driver, expenseCategory_searchresult);
		
	}	
	public void clickOnAddExpense() {
		 element.clickOnTheElement(driver, addExpense);
	 }
	
public Boolean isExpenseDateDisplayed() {
		
		return element.isDisplayedFunction(driver, eDate);

}
public Boolean isExpenseReferenceDisplayed() {
	
	return element.isDisplayedFunction(driver, eReference);

}
public Boolean isExpenseCategoryDisplayed() {
	
	return element.isDisplayedFunction(driver, eCategory);

}
public Boolean isExpenseStoreDisplayed() {
	
	return element.isDisplayedFunction(driver, eStore);

}

public void searchByExpenseStore(String expenseReference) {
	element.clearFunction(searchbtn);
	element.clickOnTheElement(driver, searchbtn);
	element.entreTheValue(driver, searchbtn, expenseReference);
}
public void clickOnAddExpenseSubmit() {
	 element.clickOnTheElement(driver, addExpense_submit);
}
	
public Boolean isExpenseAmountDisplayed() {
	
	return element.isDisplayedFunction(driver, eAmount);

}
public void selectValueForExpenseCategory(String value) {
	dropdownsel.selectByValue(driver,eCategory , value);
}

public void selectValueForExpenseStore(String value) {
	dropdownsel.selectByValue(driver,eStore , value);
}
public void enterValueForExpenseDate(String code) {
	element.clearFunction(eDate);
	element.entreTheValue(driver, eDate, code);
}

public void enterValueForExpenseReference(String code) {
	element.clearFunction(eReference);
	element.entreTheValue(driver, eReference, code);
}
public void enterValueForExpenseAmount(String amt) {
	element.clearFunction(eAmount);
	element.entreTheValue(driver, eAmount, amt);
}

	

}
