package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.WebActionUtils;

public class LoginPage {
	
	WebDriver driver;  
	
		WebActionUtils element=  new WebActionUtils();
		
		@FindBy(xpath="//input[@name='username']")
		WebElement username;
		
	    @FindBy(xpath="//input[@name='password']")
		WebElement password;
	    @FindBy(xpath="//input[@name='submit']")
	    WebElement loginSubmit;
	    
	    @FindBy(xpath="//h1[@class='text-center choose_store']")
	    WebElement loginHomePage;
	    
	  
	    
	    public LoginPage(WebDriver  driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
	    
	 public void enterValueToUserName( String usernm) {
		 element.entreTheValue(driver, username,usernm);
		 System.out.println("username"+usernm );
	 }

	 public void enterValueToPassword(String pasword) {
		 element.entreTheValue(driver, password, pasword);
	 }
	 
	 public Boolean isSuccessHomeLoginMsg() {
		 return element.isDisplayedFunction(driver, loginHomePage);
	 }
	 
	 public void clickOnTheLoginSubmit() {
			element.clickOnTheElement(driver, loginSubmit);
		}

	 
	 public void performlogin(String username , String password) throws Exception {
		 enterValueToUserName(username);
		enterValueToPassword(password);
		clickOnTheLoginSubmit();
		 
		
		 
	 }

	 public HomePage login(String username , String password) throws Exception {
		 enterValueToUserName(username);
		enterValueToPassword(password);
		clickOnTheLoginSubmit();
		 
		return new HomePage(driver);
		 
	 }
}
