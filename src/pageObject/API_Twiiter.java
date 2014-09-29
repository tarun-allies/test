package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Utility.Log;

public class API_Twiiter {
	
	public static WebElement element = null;
  
	public static WebElement email_field(WebDriver driver) throws Exception
   
	{
		try
		{
			element = driver.findElement(By.id("username_or_email"));
			Log.info("twitter email field found on page");
			return element;
		}
		catch (Exception e)
		{
			Log.error("twitter email field not found on page");
			throw (e);
		}
	
	}

   public static WebElement password_field(WebDriver driver) throws Exception
  
   {
	   try
	   {
		   element = driver.findElement(By.id("password"));
		    Log.info("twitter password field found on page");
		    return element;
	   }
	   catch (Exception e)
	   {
		   Log.error("twitter password field found on page");
			throw (e);
	   }
    
    }

   public static WebElement allow_button(WebDriver driver) throws Exception
   
    {
	   try
	   {
		   element = driver.findElement(By.id("allow"));
		   Log.info("twitter allow button found on page");
		   return element;
	   }
	   catch (Exception e)
	   {
		   Log.error("twitter allow button not found on page");
			throw (e);
	   }
    }
}
