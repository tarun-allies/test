package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Utility.Log;

public class API_facebook {
	
	public static WebElement element = null;
  
	public static WebElement email_field(WebDriver driver) throws Exception
   
	{
		try
		{
			element = driver.findElement(By.id("email"));
			Log.info("facebook email field found on page");
			return element;
		}
		catch (Exception e)
		{
			Log.error("facebook email field not found on page");
			throw (e);
		}
	
	}

   public static WebElement password_field(WebDriver driver) throws Exception
  
   {
	   try
	   {
		    element = driver.findElement(By.id("pass"));
		    Log.info("facebook password field found on page");
		    return element;
	   }
	   catch (Exception e)
	   {
		   Log.error("facebook password field found on page");
			throw (e);
	   }
    
    }

   public static WebElement login_button(WebDriver driver) throws Exception
   
    {
	   try
	   {
		   element = driver.findElement(By.id("u_0_1"));
		   Log.info("facebook login button found on page");
		   return element;
	   }
	   catch (Exception e)
	   {
		   Log.error("facebook login button not found on page");
			throw (e);
	   }
    }
   
   public static WebElement share_button(WebDriver driver) throws Exception
   
   {
	   try
	   {
		   element = driver.findElement(By.xpath("html/body/div[1]/form/div[2]/div[1]/button[2]"));
		   Log.info("facebook share button found on page");
		   return element;
	   }
	   catch (Exception e)
	   {
		   Log.error("facebook share button not found on page");
			throw (e);
	   }
   }
}
