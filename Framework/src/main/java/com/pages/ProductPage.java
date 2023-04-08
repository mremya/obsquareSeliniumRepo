package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.GenericUtils;
import com.utils.WebActionUtils;

public class ProductPage {
	WebDriver driver;  
	

	WebActionUtils element = new WebActionUtils();
     GenericUtils  dropdownsel=new GenericUtils();
	
	@FindBy( xpath ="(//select[@class='form-control'])[2]")
	WebElement productType;
	
	@FindBy(xpath="//input[@id='ProductCode']")
	WebElement  productCode;
	
	@FindBy(xpath="//input[@id='ProductName']")
	WebElement productName;
	
	@FindBy(xpath="//select[@id='Category']")
	WebElement productCategory;
	
	@FindBy(xpath="//select[@id='Supplier']")
	WebElement productSupplier;
	
	@FindBy(xpath="//input[@id='PurchasePrice']")
	WebElement productPurchasePrice;
	
	@FindBy(xpath="//input[@id='Tax']")
	WebElement productTax;
	
	@FindBy(xpath="//select[@id='taxType']")
	WebElement productTaxMethod;
	
	@FindBy(xpath="//input[@id='Price']")
	WebElement productPrice	;
	
	@FindBy(xpath="//input[@id='Unit']")
	WebElement productUnit	;
	
	@FindBy(xpath="//input[@id='AlertQt']")
	WebElement productAlertQuantity;
	
	@FindBy(xpath="//textarea[@id='ProductOptions']")
	WebElement productOptions;
	
	@FindBy(xpath="//div[@class='note-editable panel-body']")
	WebElement productDescription;
	
	@FindBy(xpath="//button[@class='btn btn-add btn-lg']")
	WebElement addProduct;
	
	@FindBy(xpath="//button[@class='btn btn-add']")
	WebElement addProduct_submit;
	
	@FindBy(xpath="(//table[@id='Table']//tr//td)[1]")
	WebElement productcode_searchresult;
	
	@FindBy(xpath="(//table[@id='Table']//tr//td)[2]")
	WebElement productname_searchresult;
	
	@FindBy(xpath="(//table[@id='Table']//tr//td)[3]")
	WebElement productcategory_searchresult;
	
	@FindBy(xpath="(//table[@id='Table']//tr//td)[4]")
	WebElement productdescription_searchresult;
	
	@FindBy(xpath="(//table[@id='Table']//tr//td)[5]")
	WebElement producttax_searchresult;
	
	@FindBy(xpath="(//table[@id='Table']//tr//td)[6]")
	WebElement productprice_searchresult;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement searchbtn;
	
	@FindBy(xpath="(//a[@class='btn btn-default'])[3]")
	WebElement editicon;
	
	@FindBy(xpath="(//a[@class='btn btn-default'])[1]")
	WebElement deleteicon;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement editiconSubmit;
	
	@FindBy(xpath="(//span[@class='menu-text'])[3]")
	WebElement storesLink;
	
	@FindBy(xpath="//a[@class='btn btn-danger']")
	WebElement conformDeleteMsg;
	
	@FindBy(xpath="(//table[@id='Table']//tr//td)[1]")
	WebElement delete_searchresult;
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnDeleteConformMsg() {
		 element.clickOnTheElement(driver, conformDeleteMsg);
	}
	public Boolean isAddProductDisplayed() {
		
		return element.isDisplayedFunction(driver, addProduct);

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
	
	return element.isDisplayedFunction(driver, productCode);

}

public void selectValueForProductSupplier(String value) {
	dropdownsel.selectByValue(driver,productSupplier , value);
}
	
public void selectValueForProductType(String value) {
	dropdownsel.selectByValue(driver,productType , value);
}
public void enterValueForProductCode(String code) {
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
	
	
public StoresPage navigateToStoresPage() {

	element.clickOnTheElement(driver, storesLink);

	return new StoresPage(driver);

}
	
	
	
	
	
	
	
}
