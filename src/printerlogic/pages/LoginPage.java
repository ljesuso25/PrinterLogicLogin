package printerlogic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;




public class LoginPage {
	

	
	 private static WebElement element = null;
	
	
	public static String expectedUrl = "https://luisonion.printercloud.com/admin/";
	
	 
	 
	//Username field
	public static WebElement username(WebDriver driver) {
		element = driver.findElement(By.id("relogin_user"));
		
		return element;
	}
	 
	 
	//Password field
	public static WebElement password(WebDriver driver) {
		element = driver.findElement(By.id("relogin_password"));
		
		return element;
	}
	
	//Login button
	public static WebElement loginbtn(WebDriver driver) {
		element = driver.findElement(By.id("admin-login-btn"));
		
		return element;
	}
	
	
	//Lost password
	public static WebElement lostpwd(WebDriver driver) {
		element = driver.findElement(By.id("forgot-password"));
		
		return element;
	}

}
