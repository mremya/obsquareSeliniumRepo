package test.com.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class CSSXpath {

	public static void main(String[] args) {


		WebDriver driver=new ChromeDriver();
		driver.get("D:/basic%20syntax.html");
		
		//WebElement textbook=driver.findElement(By.xpath("//input[@id='001']"));
		WebElement textbook=driver.findElement(By.cssSelector("input[id='001']"));
		textbook.sendKeys("Remya");
		
		
		//WebElement radio1=driver.findElement(By.xpath("//input[@id='002']"));
		//WebElement radio1=driver.findElement(By.cssSelector("input[id='002']"));
		//radio1.click();
		List<WebElement> list= driver.findElements(By.xpath("//input[@id='002']"));
		for(WebElement input: list) {
			
		input.click();
		}
		
	//Xpath=//tagname[@attribute='value']
		
		//WebElement radio2=driver.findElement(By.xpath("//input[@id='003']"));
		WebElement radio2=driver.findElement(By.cssSelector("input[id='003']"));
		radio2.click();
		
		
		//WebElement checbox=driver.findElement(By.xpath("//input[@id='004']"));
		WebElement checbox=driver.findElement(By.cssSelector("input[id='004']"));
		checbox.click();
		
		//WebElement button=driver.findElement(By.xpath("//input[@id='005']"));
		WebElement button=driver.findElement(By.cssSelector("//input[id='005']"));
		button.click();
		
		
	
	}


}
