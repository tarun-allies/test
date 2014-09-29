package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility.Log;

public class SignIn_Page {
	
	private static WebElement element = null;

	public static WebElement email_field(WebDriver driver) throws Exception
	
	{
		
		try{
		element = driver.findElement(By.id("signin_username"));
		Log.info("usernamae field found on page");
		return element;
		}
		catch(Exception e)
		{
			Log.error("usernamae field found on page");
			
			throw(e);
		}
	}
	
	public static WebElement password_field(WebDriver driver) throws Exception 
	
	{
		try
		{
		element = driver.findElement(By.id("signin_password"));
		Log.info("password field found on page");
		return element;
		}
		catch(Exception e)
		{
			Log.error("password field not found on page");
			
			throw(e);
		}
		
	}
	
	public static WebElement button_Submit(WebDriver driver) throws Exception  
	
	{
		
		try
		{
			element = driver.findElement(By.cssSelector("button.btn"));
			Log.info("submit button found on page");
			return element;
		}
		catch(Exception e)
		{
			Log.error("submit button not found on page");
			
			throw(e);
		}
		
	}
	
	public static WebElement Error_message(WebDriver driver) throws Exception
	{
		try
		{
		WebElement element = driver.findElement(By.xpath("html/body/div[2]/section/article/form/div[1]"));
		Log.info("error message found on page");
		return element;
		}
		
		catch(Exception e)
		{
			Log.error("error message not found on page");
			
			throw(e);
		}
		
	}
	
		public static WebElement facebookButton(WebDriver driver) throws Exception
		{
		try
		{
			WebElement element = driver.findElement(By.xpath("html/body/div[2]/section/article/div/a[1]/span"));
		
			Log.info("facebook button found on form");
			return element;
			
		}
		
		catch (Exception e)
		{
             Log.error("facebook button not found on form");
			
			throw(e);
		}
	
	}
		
		public static WebElement TwitterButton(WebDriver driver) throws Exception
		{
			try
			{
			WebElement element = driver.findElement(By.xpath("html/body/div[2]/section/article/div/a[2]/span"));
			Log.info("twitter button found on form");
			return element;
			}
			catch(Exception e)
			{
				Log.error("twitter button not found on form");
				
				throw(e);
			}
			
		}
	
	

    public static WebElement lockout_button(WebDriver driver) throws Exception
    
    {
    	try
    	{
    		WebElement element = driver.findElement(By.xpath("html/body/div[2]/section/article/form/fieldset/div[1]/p"));
	        Log.info("lockout text found on page");
	        return element;
		}
    	catch(Exception e)
		{
			Log.error("lockout text not found on page");
			throw(e);
		}
}
    
    public static WebElement forgetPassword_button(WebDriver driver) throws Exception
    {
    	try
    	{
    		WebElement element = driver.findElement(By.xpath("html/body/div[2]/section/article/form/fieldset/div[2]/a[1]"));
        	Log.info("forger password button found on form");
        	return element;
    	}
    	catch(Exception e)
		{
			Log.error("forger password button found on form");
			throw(e);
		}
    }
    
    
    public static WebElement tryAgain_button(WebDriver driver) throws Exception
  
    {
 
    	try
    	{
    		WebElement element = driver.findElement(By.xpath("html/body/div[2]/section/article/form/fieldset/div[2]/a[2]"));
    	    Log.info("try again button found on page");
    	    return element;
        }
    	catch(Exception e)
		{
			Log.error("try again button not found on page");
			throw(e);
		}
    	
    }

}


	
	
	

