package printerlogic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
		
		//Validate the PrinterLogic Saas main page is loaded
		String actualUrl= driver.getCurrentUrl(); 
		Assert.assertEquals(actualUrl, LoginPage.expectedUrl);
		By xpath = By.xpath("//*[@id=\"logo\"]/img");
		WebElement element = (new WebDriverWait(driver,5)).until(ExpectedConditions.presenceOfElementLocated(xpath));
		if (element.isDisplayed()) {
			System.out.println("Element is present");
		}else {
			System.out.println("Element is not present");
		}
		
		
		driver.close();
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
		
	
		// Invalid username or password message is displayed
		WebElement actualMsg = driver.findElement(By.id("logintext"));
		WebDriverWait wait = new WebDriverWait(driver,3);
		wait.until(ExpectedConditions.textToBePresentInElement(actualMsg,  "Invalid username or password."));
	
		
		
		//Login window is still displayed
		if (driver.findElement(By.xpath("//*[@id=\"thebody\"]/div[14]")) != null) {
			System.out.println("Element is present");
		}else {
			System.out.println("Element is not present");
		}

		driver.close();
	}
	
	
	

	@Test (description = "Fail scenario of the PrinterLogic Login page using a valid user but aninvalid password")
		
	public void LoginInvalidPassword() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver80.exe");
		WebDriver driver = new  ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("https://luisonion.printercloud.com/admin");
	   
		//Enter username and password
		LoginPage.username(driver).sendKeys("admin");
		LoginPage.password(driver).sendKeys("p@ssword");
		//Click the login button
		LoginPage.loginbtn(driver).click();
		
	
		// Invalid username or password message is displayed
		WebElement actualMsg = driver.findElement(By.id("logintext"));
		WebDriverWait wait = new WebDriverWait(driver,3);
		wait.until(ExpectedConditions.textToBePresentInElement(actualMsg,  "Invalid username or password."));
	
		
		
		//Login window is still displayed
		if (driver.findElement(By.xpath("//*[@id=\"thebody\"]/div[14]")) != null) {
			System.out.println("Element is present");
		}else {
			System.out.println("Element is not present");
		}

		driver.close();
	}
	
	
	
	@Test (description = "Fail scenario of the PrinterLogic Login page without user and password")
	
	public void LoginEmptyFields() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver80.exe");
		WebDriver driver = new  ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("https://luisonion.printercloud.com/admin");
	   
	
		
		//Click the login button 
		LoginPage.loginbtn(driver).click();
		
	
		// Message is displayed
		String actualMsg = driver.findElement(By.id("logintext")).getText();
		Assert.assertEquals(actualMsg, "Please enter your username and password:");
	
		
		
		
		
		// Enter username
		LoginPage.username(driver).sendKeys("admin");
		//Click the login button 
		LoginPage.loginbtn(driver).click();
		actualMsg = driver.findElement(By.id("logintext")).getText();
		Assert.assertEquals(actualMsg, "Please enter your username and password:");
		
		
		
		
		
		// Clear username
		LoginPage.username(driver).clear();
		//Enter password
		LoginPage.password(driver).sendKeys("12345678");
		//Click the login button 
		LoginPage.loginbtn(driver).click();
		actualMsg = driver.findElement(By.id("logintext")).getText();
		Assert.assertEquals(actualMsg, "Please enter your username and password:");
				
		
		
		
		
		
		//Login window is still displayed
		if (driver.findElement(By.xpath("//*[@id=\"thebody\"]/div[14]")) != null) {
			System.out.println("Element is present");
		}else {
			System.out.println("Element is not present");
		}
				
		

		driver.close();
	}
	
	
	
	@Test (description = "Lost Password scenario")
	
	public void LostPassword() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver80.exe");
		WebDriver driver = new  ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("https://luisonion.printercloud.com/admin");
	   
		
		//Click the Lost Password button
		LoginPage.lostpwd(driver).click();
	
		
		//Validate the Forgot Password window
		String forgotMsg = driver.findElement(By.xpath("//*[@id=\"password-body\"]/p[1]")).getText();
		Assert.assertEquals(forgotMsg, "Please enter your email address below, and we’ll send you instructions to reset your password.");
		
		
		
		driver.close();
	}
}
