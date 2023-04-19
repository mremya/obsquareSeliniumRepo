package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.WebActionUtils;

public class HomePage {
	WebDriver driver;

	WebActionUtils element = new WebActionUtils();

	// @FindBy(xpath = "//span[text='POS']")
	@FindBy(xpath = "(//span[@class='menu-text'])[1]")
	WebElement posLink;

	@FindBy(xpath = "(//span[@class='menu-text'])[2]")
	WebElement productLink;

	@FindBy(xpath = "(//span[@class='menu-text'])[3]")
	WebElement storesLink;

	@FindBy(xpath = "(//span[@class='menu-text'])[4]")
	WebElement peopleLink;

	@FindBy(xpath = "(//span[@class='menu-text'])[8]")
	WebElement salesLink;

	@FindBy(xpath = "(//span[@class='menu-text'])[9]")
	WebElement expenseLink;

	@FindBy(xpath = "(//span[@class='menu-text'])[10]")
	WebElement categoryLink;

	@FindBy(xpath = "(//span[@class='menu-text'])[14]")
	WebElement reportLink;

	@FindBy(xpath = "(//span[@class='menu-text'])[13]")
	WebElement settingLink;

	@FindBy(xpath = "//li[@class='dropdown language']")
	WebElement languageLink;

	@FindBy(xpath = "//i[@class='fa fa-sign-out fa-lg']")
	WebElement logOut;

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

}