package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility.Log;

public class API_Window_Page {


	
	private static WebElement element  = null;
	
	
	//--------------------------------Facebook------------------------------------------//
	
	
	public static WebElement email_facebook(WebDriver driver)throws Exception
	    {
		element = driver.findElement(By.id("email"));
		Log.info("facebook email field found");
		 return element;
		}
	
	public static WebElement password_facebook(WebDriver driver)throws Exception
    {
	element = driver.findElement(By.id("pass"));
	Log.info("facebook password field found");
	 return element;
	}
	
	public static WebElement loginButton_facebook(WebDriver driver)throws Exception
    {
	element = driver.findElement(By.id("u_0_1"));
	Log.info("facebook loging button found");
	 return element;
	}
	
	public static WebElement share_facebook(WebDriver driver)throws Exception
    {
	element = driver.findElement(By.xpath("html/body/div[1]/form/div[2]/div[1]/button[2]"));
	Log.info("facebook share txt found");
	 return element;
	}
	
	
	//--------------------------------Twitter------------------------------------------//
	
	public static WebElement email_twitter(WebDriver driver)throws Exception
    {
	element = driver.findElement(By.id("username_or_email"));
	Log.info("twitter email field found");
	 return element;
	}

   public static WebElement password_twitter(WebDriver driver)throws Exception
    {
    element = driver.findElement(By.id("password"));
    Log.info("twitter pass field found");
    return element;
    }

   public static WebElement allow_twitter(WebDriver driver)throws Exception
    {
     element = driver.findElement(By.id("allow"));
     Log.info("twitter allow button found");
     return element;
    }

	
	
	//--------------------------------Drop box------------------------------------------//
	
	public static WebElement email_dropbox(WebDriver driver)throws Exception
    {
	element = driver.findElement(By.xpath("html/body/div[2]/div[1]/div[1]/form[1]/div[2]/div[2]/input"));
	Log.info("dropbox email field found");
	 return element;
	}
	
	public static WebElement password_dropbox(WebDriver driver)throws Exception
    {
	element = driver.findElement(By.xpath("html/body/div[2]/div[1]/div[1]/form[1]/div[3]/div[2]/input"));
	Log.info("dropbox pass field found");
	 return element;
	}

	public static WebElement submit_dropbox(WebDriver driver)throws Exception
    {
	element = driver.findElement(By.xpath("html/body/div[2]/div[1]/div[1]/form[1]/div[5]/button"));
	Log.info("dropbox submit button found");
	 return element;
	}
	
	public static WebElement allow_dropbox(WebDriver driver)throws Exception
    {
	element = driver.findElement(By.xpath("html/body/div[2]/div[3]/form/button[2]"));
	Log.info("dropbox allow button found");
	 return element;
	}
	
	//------------------------------------s3-----------------------------------------//
	
	public static WebElement access_S3(WebDriver driver)throws Exception
    {
	element = driver.findElement(By.xpath("html/body/div[1]/div/div[1]/form/ul/li[1]/input"));
	Log.info("S3 access key field found");
	 return element;
	}
	
	public static WebElement secretKey_S3(WebDriver driver)throws Exception
    {
	element = driver.findElement(By.xpath("html/body/div[1]/div/div[1]/form/ul/li[2]/input"));
	Log.info("S3 secret key field found");
	 return element;
	 
	}
	
	public static WebElement Bucket_S3(WebDriver driver)throws Exception
    {
	element = driver.findElement(By.xpath("html/body/div[1]/div/div[1]/form/ul/li[5]/input"));
	Log.info("S3 bucket key field found");
	 return element;
	}
	
	public static WebElement submit_S3(WebDriver driver)throws Exception
    {
	element = driver.findElement(By.xpath("html/body/div[1]/div/div[1]/form/ul/li[6]/input"));
	Log.info("S3 submit button found");
	 return element;
	}
	
	//------------------------------------gDrive-----------------------------------------//
	
		public static WebElement email_gDrive(WebDriver driver)throws Exception
	    {
		element = driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/form/input[14]"));
		Log.info("gdrive email field found");
		 return element;
		}
		
		public static WebElement password_gDrive(WebDriver driver)throws Exception
	    {
		element = driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/form/input[15]"));
		Log.info("gdrive password field found");
		 return element;
		}
		
		public static WebElement submit_gDrive(WebDriver driver)throws Exception
	    {
		element = driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/form/input[16]"));
		Log.info("gdrive submit button found");
		 return element;
		}
		
		public static WebElement accept_gDrive(WebDriver driver)throws Exception
	    {
		element = driver.findElement(By.id("html/body/div[2]/div/div[4]/div[3]/form/button[1]"));
		Log.info("gdrive accept button found");
		 return element;
		}
		
	
	
	//------------------------------------------suger Sync--------------------------------//
		
		
		public static WebElement email_sugerSync(WebDriver driver)throws Exception
	    {
		element = driver.findElement(By.xpath("html/body/div[1]/div/div[1]/form/ul/li[1]/input"));
		Log.info("sugersync email field found");
		 return element;
		}
		
		public static WebElement password_sugerSync(WebDriver driver)throws Exception
	    {
		element = driver.findElement(By.xpath("html/body/div[1]/div/div[1]/form/ul/li[2]/input"));
		Log.info("sugersync password field found");
		 return element;
		}
		
		public static WebElement submit_sugerSync(WebDriver driver)throws Exception
	    {
		element = driver.findElement(By.xpath("html/body/div[1]/div/div[1]/form/ul/li[3]/input"));
		Log.info("sugersync submit button found");
		 return element;
		
	    }
		
		
		//-------------------------------------oneDrive------------------//
		
		  public static WebElement email_oneDrive(WebDriver driver)throws Exception
	       {
		   element = driver.findElement(By.xpath("html/body/div[1]/div/div[2]/form/div[1]/div[4]/div/input"));
		   Log.info("onedrive email field found");
		   return element;
		   }
		
		  public static WebElement password_oneDrive(WebDriver driver)throws Exception
	       {
		    element = driver.findElement(By.xpath("html/body/div[1]/div/div[2]/form/div[1]/div[6]/div/input"));
		    Log.info("onedrive password field found");
		    return element;
		   }
		
		  public static WebElement submit_oneDrive(WebDriver driver)throws Exception
	       {
		    element = driver.findElement(By.xpath("html/body/div[1]/div/div[2]/form/div[2]/input"));
		    Log.info("onedrive submit button found");
		    return element;
		    }
		
		
}


