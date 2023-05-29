package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.GenericUtils;
import com.utils.WaitUtils;
import com.utils.WebActionUtils;

public class StoresPage {

	WebDriver driver;

	WebActionUtils element = new WebActionUtils();
	GenericUtils dropdownsel = new GenericUtils();
	WaitUtils wait=new WaitUtils();

	@FindBy(xpath = "//input[@id='StoreName']")
	WebElement storeName;

	@FindBy(xpath = "//input[@id='email']")
	WebElement storeEmail;

	@FindBy(xpath = "//input[@id='StorePhone']")
	WebElement storePhone;

	@FindBy(xpath = "(//input[@id='Country']")
	WebElement storeCountry;

	@FindBy(xpath = "//input[@id='City']")
	WebElement storeCity;

	@FindBy(xpath = "//input[@id='Adresse']")
	WebElement storeAddress;

	@FindBy(xpath = "//input[@id='CustomeFooter']")
	WebElement storeCustomerFooter;

	@FindBy(xpath = "//button[@class='btn btn-add']")
	WebElement storeAdd_SubmitBtn;

	@FindBy(xpath = "//button[@class='btn btn-add btn-lg']")
	WebElement storeAddBtn;
	
	@FindBy(xpath = "//button[@class='btn btn-default']")
	WebElement storeAddCloseBtn;
	
	
	@FindBy(xpath = "//input[@class='form-control input-sm']")
	WebElement storeSearchbtn;

	@FindBy(xpath = "(//table[@id='Table']//tr//td)[1]")
	WebElement storeName_searchresult;

	@FindBy(xpath = "(//table[@id='Table']//tr//td)[2]")
	WebElement storeEmail_searchresult;

	@FindBy(xpath = "(//table[@id='Table']//tr//td)[3]")
	WebElement storePhone_searchresult;

	@FindBy(xpath = "(//table[@id='Table']//tr//td)[4]")
	WebElement storeCountry_searchresult;

	@FindBy(xpath = "(//table[@id='Table']//tr//td)[5]")
	WebElement storeCity_searchresult;

	@FindBy(xpath = "(//a[@class='btn btn-default'])[2]")
	WebElement storeEditBtn;

	@FindBy(xpath = "(//table[@id='Table']//tr//td)[1]")
	WebElement storedelete_searchResult;

	@FindBy(xpath = "(//a[@class='btn btn-default'])[1]")
	WebElement storeDeleteBtn;

	@FindBy(xpath = "//button[@class='btn btn-green col-md-6 flat-box-btn waves-effect waves-button']")
	WebElement storeEditSubmitBtn;
	
	@FindBy(xpath="(//span[@class='menu-text'])[4]")
	WebElement peopleLink;

	public StoresPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void searchByStoreName(String storeName) {
		element.clearFunction(storeSearchbtn);
		element.clickOnTheElement(driver, storeSearchbtn);

		element.entreTheValue(driver, storeSearchbtn, storeName);
	}

	public String getTheSearchResultOfDeletedEntry() {
		return element.getTextFunction(driver, storedelete_searchResult);

	}

	public void clickOnstoreAddCloseBtn() {

		element.clickOnTheElement(driver, storeAddCloseBtn);
	}
	
	public void clickOnEditIcon() {

		element.clickOnTheElement(driver, storeEditBtn);
	}

	public void clickOnDeleteIcon() {

		element.clickOnTheElement(driver, storeDeleteBtn);
	}

	public void clickOnEditSubmitIcon() {

		element.clickOnTheElement(driver, storeEditSubmitBtn);
	}

	public Boolean isAddStoreDisplayed() {

		return element.isDisplayedFunction(driver, storeAddBtn);

	}

	public void clickOnAddStoresSubmit() {
		element.clickOnTheElement(driver, storeAdd_SubmitBtn);
	}

	public Boolean isStoreNameDisplayed() {
wait.waitForElementToBeClickable(driver, storeName, 20);
		return element.isDisplayedFunction(driver, storeName);

	}

	public Boolean isStoreEmailDisplayed() {
		wait.waitForElementToBeClickable(driver, storeEmail, 20);
		return element.isDisplayedFunction(driver, storeEmail);

	}

	public Boolean isStorePhoneDisplayed() {
		wait.waitForElementToBeClickable(driver, storePhone, 20);
		return element.isDisplayedFunction(driver, storePhone);

	}

	public Boolean isStoreCountryDisplayed() {
		wait.waitForElementToBeClickable(driver, storeCountry, 20);
		return element.isDisplayedFunction(driver, storeCountry);

	}

	public Boolean isStoreCityDisplayed() {
		wait.waitForElementToBeClickable(driver, storeCity, 20);
		return element.isDisplayedFunction(driver, storeCity);

	}

	public Boolean isStoreAddressDisplayed() {
		wait.waitForElementToBeClickable(driver, storeAddress, 20);
		return element.isDisplayedFunction(driver, storeAddress);

	}

	public Boolean isStoreCustomerFooterDisplayed() {

		return element.isDisplayedFunction(driver, storeCustomerFooter);

	}

	public void clickOnAddStores() {
		element.clickOnTheElement(driver, storeAddBtn);
	}

	public void enterValueForStoreName(String value) {
		wait.waitForElementToBeClickable(driver, storeName, 20);
		element.clearFunction(storeName);
		element.entreTheValue(driver, storeName, value);
	}

	public void enterValueForStoreEmail(String value) {
		element.clearFunction(storeEmail);
		element.entreTheValue(driver, storeEmail, value);
	}

	public void enterValueForStorePhone(String value) {
		element.clearFunction(storePhone);
		element.entreTheValue(driver, storePhone, value);
	}

	public void enterValueForStoreCity(String value) {
		element.clearFunction(storeCity);
		element.entreTheValue(driver, storeCity, value);
	}

	public void enterValueForStoreCountry(String value) {
		element.clearFunction(storeCountry);
		element.entreTheValue(driver, storeCountry, value);
	}

	public void enterValueForStoreAddress(String value) {
		element.clearFunction(storeAddress);
		element.entreTheValue(driver, storeAddress, value);
	}

	public void enterValueForStoreCustomerFooter(String value) {
		element.clearFunction(storeCustomerFooter);
		element.entreTheValue(driver, storeCustomerFooter, value);
	}

	public String getStoreNameFromSearchResult() {
		return element.getTextFunction(driver, storeName_searchresult);

	}

	public String getStoreEmailFromSearchResult() {
		return element.getTextFunction(driver, storeEmail_searchresult);

	}

	public void clearWeblementValue(WebElement element) {
		element.clear();

	}

	public String getStoreCityFromSearchResult() {
		return element.getTextFunction(driver, storeCity_searchresult);

	}

	public String getStoreCountryFromSearchResult() {
		return element.getTextFunction(driver, storeCountry_searchresult);

	}

	public String getStorePhoneFromSearchResult() {
		return element.getTextFunction(driver, storePhone_searchresult);

	}

	
}
