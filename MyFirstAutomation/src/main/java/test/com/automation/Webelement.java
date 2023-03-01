package test.com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Webelement {
@Test
	public void sum() {
		

		WebDriver driver=new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
		WebElement textbook=driver.findElement(By.id("single-input-field"));
		
		textbook.sendKeys("welcome to obsquare automation testing");
	
		WebElement input1=driver.findElement(By.id("value-a"));
		input1.sendKeys("23");
		
		WebElement input2=driver.findElement(By.id("value-b"));
		input2.sendKeys("10");
		
		WebElement button=driver.findElement(By.id("button-two"));
		button.click();
		
		WebElement sum=driver.findElement(By.id("message-two"));
		System.out.println(sum.getText());
		
		Assert.assertEquals(sum.getText(), "Total A + B : 33","test passed");
	}

}
