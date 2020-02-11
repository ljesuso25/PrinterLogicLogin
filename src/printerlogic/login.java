package printerlogic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import printerlogic.pages.*;

public class login {

	
	@Test (description = "Successful scenario of the PrinterLogic Login page")
	
	public void LoginPass() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver80.exe");
		WebDriver driver = new  ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("https://luisonion.printercloud.com/admin");
	   
		//Enter username and password
		LoginPage.username(driver).sendKeys("admin");
		LoginPage.password(driver).sendKeys("12345678");
		//Click the login button
		LoginPage.loginbtn(driver).click();
		
		//Validate the Printer cloud page is loaded
		String actualUrl= driver.getCurrentUrl(); 
		Assert.assertEquals(actualUrl, LoginPage.expectedUrl);
		
	}
	
	
	@Test (description = "Fail scenario of the PrinterLogic Login page using an invalid user")
		
	public void LoginInvalidUser() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver80.exe");
		WebDriver driver = new  ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("https://luisonion.printercloud.com/admin");
	   
		//Enter username and password
		LoginPage.username(driver).sendKeys("InvalidUser");
		LoginPage.password(driver).sendKeys("12345678");
		//Click the login button
		LoginPage.loginbtn(driver).click();
		
		String actualUrl= driver.getCurrentUrl(); 
		Assert.assertEquals(actualUrl, LoginPage.expectedUrl);
		
	}
	
	
	
	
}
