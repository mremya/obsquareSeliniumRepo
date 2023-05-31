package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.WebActionUtils;

public class HomePage {
	WebDriver driver;
	WebActionUtils element = new WebActionUtils();
	
	@FindBy(xpath = "(//span[@class='menu-text'])[1]")
	private WebElement posLink;

	@FindBy(xpath = "(//span[@class='menu-text'])[2]")
	private WebElement productLink;

	@FindBy(xpath = "(//span[@class='menu-text'])[3]")
	private WebElement storesLink;

	@FindBy(xpath = "(//span[@class='menu-text'])[4]")
	private WebElement peopleLink;
	
	@FindBy(xpath = "(//span[@class='menu-text'])[5]")
	private WebElement waiterLink;
	
	
	@FindBy(xpath="(//span[@class='menu-text'])[6]")
	private WebElement  customerLink;
	
	@FindBy(xpath="(//span[@class='menu-text'])[7]")
	private WebElement  supplierLink;
	

	@FindBy(xpath = "(//span[@class='menu-text'])[8]")
	private WebElement salesLink;

	@FindBy(xpath = "(//span[@class='menu-text'])[9]")
	private WebElement expenseLink;

	@FindBy(xpath = "(//span[@class='menu-text'])[10]")
	private WebElement categoryLink;

	@FindBy(xpath = "(//span[@class='menu-text'])[14]")
	private WebElement reportLink;

	@FindBy(xpath = "(//span[@class='menu-text'])[13]")
	private WebElement settingLink;

	@FindBy(xpath = "//li[@class='dropdown language']")
	private WebElement languageLink;

	@FindBy(xpath = "//i[@class='fa fa-sign-out fa-lg']")
	private WebElement logOut;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public Boolean isProductLinkDisplayed() {
		System.out.println("product link::" + productLink);
		return element.isDisplayedFunction(driver, productLink);

	}

	public Boolean isStoresLinkDisplayed() {
		System.out.println("store link::" + storesLink);
		return element.isDisplayedFunction(driver, storesLink);
	}

	public Boolean isPosLinkDisplayed() {

		return element.isDisplayedFunction(driver, posLink);
	}

	public Boolean isPeopleLinkDisplayed() {

		return element.isDisplayedFunction(driver, peopleLink);
	}

	public Boolean isSalesLinkDisplayed() {

		return element.isDisplayedFunction(driver, salesLink);
	}

	public Boolean isExpenseLinkDisplayed() {

		return element.isDisplayedFunction(driver, expenseLink);
	}

	public Boolean isCategoryLinkDisplayed() {

		return element.isDisplayedFunction(driver, categoryLink);
	}

	public Boolean isReportLinkDisplayed() {

		return element.isDisplayedFunction(driver, reportLink);
	}

	public Boolean isSettingsLinkDisplayed() {

		return element.isDisplayedFunction(driver, settingLink);
	}

	public Boolean isLanguageLinkDisplayed() {

		return element.isDisplayedFunction(driver, languageLink);
	}

	public Boolean isLogOutDisplayed() {

		return element.isDisplayedFunction(driver, logOut);
	}

	public ProductPage navigateToProductPage() {

		element.clickOnTheElement(driver, productLink);

		return new ProductPage(driver);

	}
	public StoresPage navigateToStoresPage() {

		element.clickOnTheElement(driver, storesLink);

		return new StoresPage(driver);

	}
	public ExpensePage navigateToExpensePage() {

		element.clickOnTheElement(driver, expenseLink);

		return new ExpensePage(driver);

	}
	public PeopleWaiterPage navigateToPeoplePage() {

		element.clickOnTheElement(driver, peopleLink);

		return new PeopleWaiterPage(driver);

	}
	
	public PeopleCustomerPage navigateToCustomersInPeopleLink() {
		element.clickOnTheElement(driver, peopleLink);
		element.clickOnTheElement(driver, customerLink);
		return new PeopleCustomerPage(driver);
	}
	
	public PeopleSupplierPage navigateToSuplierInPeopleLink() {
		element.clickOnTheElement(driver, peopleLink);
		element.clickOnTheElement(driver, supplierLink);
		return new PeopleSupplierPage(driver);
	}

	public PeopleWaiterPage navigateToWaiterInPeopleLink() {
		element.clickOnTheElement(driver, peopleLink);
		element.clickOnTheElement(driver, waiterLink);
		return new PeopleWaiterPage(driver);
	}

}