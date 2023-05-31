package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.GenericUtils;
import com.utils.WaitUtils;
import com.utils.WebActionUtils;

public class ProductPage {
	WebDriver driver;  
	

	WebActionUtils element = new WebActionUtils();
     GenericUtils  dropdownsel=new GenericUtils();
     WaitUtils wait=new WaitUtils();
	
	@FindBy( xpath ="(//select[@class='form-control'])[2]")
	private WebElement productType;
	
	@FindBy(xpath = "(//button[@class='btn btn-add hiddenpr'])[1]")
	private WebElement stockSubmitButton;
	
	@FindBy( xpath ="(//button[@class='btn btn-default'])[2]")
	private WebElement addProductCloseBtn;
	
	@FindBy(xpath="//input[@id='ProductCode']")
	private WebElement  productCode;
	
	@FindBy(xpath="//input[@id='ProductName']")
	private WebElement productName;
	
	@FindBy(xpath="//select[@id='Category']")
	private WebElement productCategory;
	
	@FindBy(xpath="//select[@id='Supplier']")
	private WebElement productSupplier;
	
	@FindBy(xpath="//input[@id='PurchasePrice']")
	private WebElement productPurchasePrice;
	
	@FindBy(xpath="//input[@id='Tax']")
	private WebElement productTax;
	
	@FindBy(xpath="//select[@id='taxType']")
	private WebElement productTaxMethod;
	
	@FindBy(xpath="//input[@id='Price']")
	private WebElement productPrice	;
	
	@FindBy(xpath="//input[@id='Unit']")
	private WebElement productUnit	;
	
	@FindBy(xpath="//input[@id='AlertQt']")
	private WebElement productAlertQuantity;
	
	@FindBy(xpath="//textarea[@id='ProductOptions']")
	private WebElement productOptions;
	
	@FindBy(xpath="//div[@class='note-editable panel-body']")
	private WebElement productDescription;
	
	@FindBy(xpath="//button[@class='btn btn-add btn-lg']")
	private WebElement addProduct;
	
	@FindBy(xpath="(//button[@class='btn btn-add'])[1]")
	private WebElement addProduct_submit;
	
	@FindBy(xpath="(//table[@id='Table']//tr//td)[1]")
	private WebElement productcode_searchresult;
	
	@FindBy(xpath="(//table[@id='Table']//tr//td)[2]")
	private WebElement productname_searchresult;
	
	@FindBy(xpath="(//table[@id='Table']//tr//td)[3]")
	private WebElement productcategory_searchresult;
	
	@FindBy(xpath="(//table[@id='Table']//tr//td)[4]")
	private WebElement productdescription_searchresult;
	
	@FindBy(xpath="(//table[@id='Table']//tr//td)[5]")
	private WebElement producttax_searchresult;
	
	@FindBy(xpath="(//table[@id='Table']//tr//td)[6]")
	private WebElement productprice_searchresult;
	
	
	@FindBy(xpath="//input[@type='search']")
	private WebElement searchbtn;
	
	@FindBy(xpath="(//a[@class='btn btn-default'])[3]")
	private WebElement editicon;
	
	@FindBy(xpath="(//a[@class='btn btn-default'])[1]")
	private WebElement deleteicon;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement editiconSubmit;
	
	@FindBy(xpath="(//span[@class='menu-text'])[3]")
	private WebElement storesLink;
	
	@FindBy(xpath="//a[@class='btn btn-danger']")
	private WebElement conformDeleteMsg;
	
	@FindBy(xpath="(//table[@id='Table']//tr//td)[1]")
	private WebElement delete_searchresult;
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnDeleteConformMsg() {
		 element.clickOnTheElement(driver, conformDeleteMsg);
	}
	public Boolean isAddProductDisplayed() {
		wait.waitForElementToBeClickable(driver, addProduct, 20);
		return element.isDisplayedFunction(driver, addProduct);

}
	
public void clickOnStocksubmitButton() {
	wait.waitForElementToBeClickable(driver, stockSubmitButton, 20);
	
		 element.clickOnTheElement(driver, stockSubmitButton);
		 
		
	 }
	
	public void clickOnAddProduct() {
		 element.clickOnTheElement(driver, addProduct);
	 }
	
	public void clickOnProductDeleteIcon() {
		 element.clickOnTheElement(driver, deleteicon);
	 }
	 
	
public Boolean isProductTypeDisplayed() {
		
		return element.isDisplayedFunction(driver, productType);

}
public Boolean isProductNameDisplayed() {
	
	return element.isDisplayedFunction(driver, productName);

}

public Boolean isProductCategoryDisplayed() {
	wait.waitForElementToBeClickable(driver, productCategory, 20);
	return element.isDisplayedFunction(driver, productCategory);

}

public Boolean isProductSupplierDisplayed() {
	
	return element.isDisplayedFunction(driver, productSupplier);

}

public Boolean isProductPurchasePriceDisplayed() {
	
	return element.isDisplayedFunction(driver, productPurchasePrice);

}

public Boolean isProductTaxDisplayed() {
	
	return element.isDisplayedFunction(driver, productTax);

}
public Boolean isProductTaxMethodDisplayed() {
	
	return element.isDisplayedFunction(driver, productTaxMethod);

}

public Boolean isProductPriceDisplayed() {
	
	return element.isDisplayedFunction(driver, productPrice);

}
	
public Boolean isProductAlertQuantityDisplayed() {
	
	return element.isDisplayedFunction(driver, productAlertQuantity);

}
	
public Boolean isProductUnitDisplayed() {
	
	return element.isDisplayedFunction(driver, productUnit);

}
	

public Boolean isProductOptionsDisplayed() {
	
	return element.isDisplayedFunction(driver, productOptions);

}

public Boolean isProductDescriptionDisplayed() {
	
	return element.isDisplayedFunction(driver, productDescription);

}

public Boolean isproductCodeDisplayed() {
	wait.waitForElementToBeClickable(driver, productCode, 20);
	
	return element.isDisplayedFunction(driver, productCode);

}

public void selectValueForProductSupplier(String value) {
	dropdownsel.selectByValue(driver,productSupplier , value);
}
	
public void selectValueForProductType(String value) {
	dropdownsel.selectByValue(driver,productType , value);
}
public void enterValueForProductCode(String code) {
	wait.waitForElementToBeClickable(driver, productCode, 20);
	element.clearFunction(productCode);
	element.entreTheValue(driver, productCode, code);
}

public void enterValueForProductName(String value) {
	element.clearFunction(productName);
	element.entreTheValue(driver, productName, value);
}
	
public void selectValueForProductCategory(String value) {
	dropdownsel.selectByValue(driver, productCategory, value);
}

public void enterValueForProductTax(String value) {
	element.clearFunction(productTax);
	element.entreTheValue(driver, productTax, value);
}

public void selectValueForProductTaxMethod(String value) {
	dropdownsel.selectByValue(driver, productTaxMethod, value);
}

public void enterValueForProductPrice(String value) {
	element.clearFunction(productPrice);
	element.entreTheValue(driver, productPrice, value);
}

public void enterValueForProductOption(String value) {
	element.clearFunction(productOptions);
	element.entreTheValue(driver, productOptions, value);
}

public void selectValueForProductAlertQuantity(String value) {
	element.entreTheValue(driver, productAlertQuantity, value);
}


public void enterValueForProductDescription(String value) {
	element.clearFunction(productDescription);
	element.entreTheValue(driver, productDescription, value);
}
public void enterValueForProductPurchasePrice(String value) {
	element.clearFunction(productPurchasePrice);
	element.entreTheValue(driver, productPurchasePrice, value);
}

public void enterValueForProductUnit(String value) {
	element.clearFunction(productUnit);
	element.entreTheValue(driver, productUnit, value);
}
	
public void clickOnAddProductSubmit() {
	 element.clickOnTheElement(driver, addProduct_submit);
}
	
public void clickOnAddProductClose() {
	wait.waitForElementToBeClickable(driver, addProductCloseBtn, 20);
	 element.clickOnTheElement(driver, addProductCloseBtn);
}

public String getProductCodeFromSearchResult() {
	return element.getTextFunction(driver, productcode_searchresult);
	
}	

public String getProductNameFromSearchResult() {
	return element.getTextFunction(driver, productname_searchresult);
	
}	

public String getProductCategoryFromSearchResult() {
	return element.getTextFunction(driver, productcategory_searchresult);
	
}	

public String getProductProductDescriptionFromSearchResult() {
	return element.getTextFunction(driver, productdescription_searchresult);
	
}	

public String getProductSearchResultOfDeletedEntry() {
	return element.getTextFunction(driver, delete_searchresult);
	
}	

public String getProductTaxFromSearchResult() {
	return element.getTextFunction(driver, producttax_searchresult);
	
}

public String getProductPriceFromSearchResult() {
	return element.getTextFunction(driver, productprice_searchresult);
	
}
public void searchByProductCode(String productcode) {
	wait.waitForElementToBeClickable(driver, searchbtn, 20);
	element.clearFunction(searchbtn);
	element.clickOnTheElement(driver, searchbtn);
	element.entreTheValue(driver, searchbtn, productcode);
}
	
public void clickOnEditProduct() {
		 element.clickOnTheElement(driver, editicon);
}
	
public void clickOnEditProductSubmit() {
		 element.clickOnTheElement(driver, editiconSubmit);
}
		
public void clearTheWebElementValue(WebElement webelement1) {
	
	element.clearFunction(webelement1);
}	
public void waitForClickOnAddCloseButton() {
	
	wait.waitForElementToBeClickable(driver, addProductCloseBtn, 20);
}	

public void waitForVisibleOfAddProductCategoryButton() {
	
	wait.waitForElementToBeClickable(driver, addProductCloseBtn, 20);
}	
}
