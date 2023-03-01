package test.com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IsAndGetMethod {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();  //child class of web driver
		
		driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
		WebElement msgtext=driver.findElement(By.id("single-input-field"));
		msgtext.sendKeys("automation testing");
		System.out.println(msgtext.isEnabled());
		System.out.println(msgtext.isDisplayed());
		System.out.println(msgtext.isSelected());
		System.out.println(msgtext.getTagName());
		System.out.println(msgtext.getText());
		System.out.println(msgtext.getLocation());
		System.out.println(msgtext.getSize());
		
		

	}

}
