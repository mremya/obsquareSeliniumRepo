package test.com.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day1 {

	public static void main(String[] args) {
		
	WebDriver driver= new ChromeDriver();  //child class of web driver
		//WebDriver driver= new FirefoxDriver();
	
	driver.get("https://www.google.com");
driver.get("http://hrm.qabible.in/hrms/admin");

	
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

}
