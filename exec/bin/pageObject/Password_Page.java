package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility.Log;



public class Password_Page {
	
	private static WebElement element = null;
	
	
	
	public static WebElement txt_password(WebDriver driver)
	{
		element = driver.findElement(By.xpath("html/body/div[2]/section/article/h1"));
		Log.info("text for forget password found");
		return element;
	}
	
	public static WebElement txt_passwordField(WebDriver driver)
	{
		element = driver.findElement(By.xpath("html/body/div[2]/section/article/form/ul/li[1]/input"));
		Log.info("forger passoword password field found");
		return element;
	}
	
	public static WebElement txt_passwordReset_button(WebDriver driver)
	{
		element = driver.findElement(By.xpath("html/body/div[2]/section/article/form/ul/li[2]/button"));
		Log.info("reset password button found");
		return element;
	}

}

