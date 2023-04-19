package test.com.automation;

import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DropSelect {
	WebDriver driver; 
	
	@BeforeTest
	public void launchBrowser() {

		 driver = new ChromeDriver();
		driver.get("http://www.uitestpractice.com/Students/Form");
	}
	
	@Test(enabled= false)
	public void selectCountry() {
		
	//	WebElement droplist= driver.findElement(By.id("sel1"));
		WebElement droplist=driver.findElement(By.xpath("//select[@id='sel1']"));
		
		Select selcountry=new Select(droplist);
		
		selcountry.selectByVisibleText("Bahrain");
		//gitselcountry.selectByIndex(3);
		
	}
@Test
	public void formInfo(){
	
	WebElement firstName=driver.findElement(By.xpath("//input[@id='firstname']"));
	firstName.sendKeys("Remya");
	
	WebElement lastName=driver.findElement(By.xpath("//input[@id='lastname']"));
			lastName.sendKeys("Nair");
			
			
		//	WebElement dateSelecter=driver.findElement(By.xpath("//input[@id='datepicker']"));
			
			WebElement telNum=driver.findElement(By.xpath("//input[@id='phonenumber']"));
			telNum.sendKeys("1234567897");
			
			
			WebElement userName=driver.findElement(By.xpath("//input[@id='username']"));
			userName.sendKeys("arush");
			
			WebElement email=driver.findElement(By.xpath("//input[@id='email']"));
			email.sendKeys("remyanair1992@gmail.com");
			
			WebElement aboutYourself=driver.findElement(By.xpath("//textarea[@id='comment']"));
			aboutYourself.sendKeys("automation testing class");
			
			WebElement password=driver.findElement(By.xpath("//input[@id='pwd']"));
			password.sendKeys("1234");
			
			WebElement submitButton=driver.findElement(By.xpath("//button[@class='btn btn-default']"));
			
			submitButton.click();
}





}
			
			
			
			
			
			
			
			
			
			
			
			
			


