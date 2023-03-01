package test.com.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestTrail {

	@Test(priority =1)
	public void firstPage() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
		WebElement textbook = driver.findElement(By.id("single-input-field"));

		textbook.sendKeys("welcome to obsquare automation testing");
		WebElement messgbox = driver.findElement(By.id("button-one"));
		messgbox.click();

		WebElement msg = driver.findElement(By.id("message-one"));

		System.out.println(msg.getText());

		Assert.assertEquals(msg.getText(), "Your Message :  to obsquare automation testing",
				"failure message :mismatch found");

	}

	@Test(priority =2)
	public void getTotalSuccess() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");

		WebElement input1 = driver.findElement(By.id("value-a"));
		input1.sendKeys("23");

		WebElement input2 = driver.findElement(By.id("value-b"));
		input2.sendKeys("10");

		WebElement msggettotal = driver.findElement(By.id("button-two"));

		msggettotal.click();

		WebElement msgTotal = driver.findElement(By.id("message-two"));
		System.out.println(msgTotal.getText());

		Assert.assertEquals(msgTotal.getText(), "Total A + B : 33", "Addition is 33:: pass");
	}

	@Test(priority =3)
	public void getTotalFail() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");

		WebElement input1 = driver.findElement(By.id("value-a"));
		input1.sendKeys("23");

		WebElement input2 = driver.findElement(By.id("value-b"));
		input2.sendKeys("10");

		WebElement msggettotal = driver.findElement(By.id("button-two"));

		msggettotal.click();

		WebElement msgTotal = driver.findElement(By.id("message-two"));
		System.out.println(msgTotal.getText());

		Assert.assertEquals(msgTotal.getText(), "Total A + B : 37",
				"Addition is failed : mismatch is found in the result");

	}

	@Test(priority =4 , enabled= true)
	public void singleCheckBox() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/check-box-demo.php");

		WebElement checkbox = driver.findElement(By.className("form-check-label"));
		checkbox.click();

		WebElement msg = driver.findElement(By.id("message-one"));
		System.out.println(msg.getText());
		Assert.assertEquals(msg.getText(), "Success - Check box is checked", "msg matched: pass");

	}

	@Test(priority =5 , enabled= true)
	public void singleCheckBoxFail() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/check-box-demo.php");

		WebElement checkbox = driver.findElement(By.className("form-check-label"));
		checkbox.click();

		WebElement msg = driver.findElement(By.id("message-one"));
		System.out.println(msg.getText());
		Assert.assertEquals(msg.getText(), "Check box is checked", "msg mismatched: Fail");

	}

	@Test(priority =5)
	public void multiCheckBox() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/check-box-demo.php");

		List<WebElement> selectAllButton = driver.findElements(By.className("check-box-list"));
		for (WebElement button : selectAllButton) {
			button.click();
		}

		WebElement unselectbutton = driver.findElement(By.id("button-two"));
		String str = unselectbutton.getAttribute("value");
		System.out.println(unselectbutton.getAttribute("value"));
		// System.out.println("selected box msg:"+unselectbutton.getText());
		
		Assert.assertEquals(unselectbutton.getAttribute("value"), "Unselect All", "All the checkbox got selected");
	}

}
