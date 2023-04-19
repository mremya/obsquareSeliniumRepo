package test.com.automation;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Day1 {
	WebDriver driver;

	public static void main(String[] args) throws IOException {
		
	WebDriver driver= new ChromeDriver();  //child class of web driver
		//WebDriver driver= new FirefoxDriver();
	Day1 d=new Day1();
	
	driver.get("https://www.google.com");
driver.get("http://hrm.qabible.in/hrms/admin");

d.getScreenShot("C:\\Users\\hp\\Desktop\\passed","testingSS");

	System.out.println(driver.getTitle());
	System.out.println(driver.getCurrentUrl());
	//System.out.println(driver.getPageSource());
	
	//navigation cmd
	
	driver.navigate().to("https://www.myntra.com");
	System.out.println(driver.getTitle());
	System.out.println(driver.getCurrentUrl());
	
	driver.navigate().back();
	driver.navigate().forward();
	driver.navigate().refresh();
	driver.manage().window().maximize();
	driver.manage().window().minimize();
	//driver.close();
	//driver.quit();

	}
public void getScreenShot(String path , String filename) throws IOException {
		
		try {
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, new  File(path+ filename+".png"));
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
