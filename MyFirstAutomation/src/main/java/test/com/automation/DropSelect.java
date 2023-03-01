package test.com.automation;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropSelect {
	@Test
	public void selectCountry() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.uitestpractice.com/Students/Form");
		
	//	WebElement droplist= driver.findElement(By.id("sel1"));
		WebElement droplist=driver.findElement(By.xpath("//select[@id='sel1']"));
		
		Select selcountry=new Select(droplist);
		
		selcountry.selectByVisibleText("Bahrain");
		//gitselcountry.selectByIndex(3);
		
	}

}
