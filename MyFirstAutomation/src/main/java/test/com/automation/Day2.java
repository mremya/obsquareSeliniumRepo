package test.com.automation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day2 {

	public static void main(String[] args) throws AWTException, InterruptedException {
		WebDriver driver=new ChromeDriver();
	
      /*   
		driver.get("D:/basic%20syntax.html");
		
		
		
		
		//WebElement textbook=driver.findElement(By.name("textnm"));
		//WebElement textbook=driver.findElement(By.className("C1"));
		WebElement textbook=driver.findElement(By.id("001"));
		textbook.sendKeys("Remya");
		
		
		WebElement radio1=driver.findElement(By.id("002"));
		//WebElement radio1=driver.findElement(By.name("radiobutton1"));
		//WebElement radio1=driver.findElement(By.className("C2"));
		
		
		//WebElement radio2=driver.findElement(By.id("003"));
		//WebElement radio2=driver.findElement(By.name("radiobutton2"));
		WebElement radio2=driver.findElement(By.className("C3"));
		radio2.click();
		
		//WebElement checbox=driver.findElement(By.id("004"));
		//WebElement checbox=driver.findElement(By.name("chbox"));
		WebElement checbox=driver.findElement(By.className("C4"));
		checbox.click();
		
		WebElement button=driver.findElement(By.id("005"));
	//	WebElement button=driver.findElement(By.name("okbutton"));
		//WebElement button=driver.findElement(By.className("C5"));
	button.click();
		
		
		//***********link text webelement*************
	//	WebElement refbutton=driver.findElement(By.linkText("Click me"));
		WebElement refbutton=driver.findElement(By.partialLinkText(" me"));
		refbutton.click();*/
		
driver.get("http://webdriveruniversity.com/File-Upload/index.html");
		
		Thread.sleep(2000);
		
		WebElement uploadBtn = driver.findElement(By.id("myFile"));
		uploadBtn.click();
		
		
		Robot robot = new Robot(); 
		
		 String path = "C:\\Users\\HP\\Desktop\\SS\\NewSchema.txt";
		 
	       StringSelection stringSelection = new StringSelection(path);
	       
	       Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	       clipboard.setContents(stringSelection, stringSelection); 
	       
	       robot.keyPress(KeyEvent.VK_CONTROL);
	       robot.keyPress(KeyEvent.VK_V);
	       robot.keyRelease(KeyEvent.VK_V);
	       robot.keyRelease(KeyEvent.VK_CONTROL);
	       
	       robot.keyPress(KeyEvent.VK_ENTER);

	       robot.keyRelease(KeyEvent.VK_ENTER);
	}

}
