package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility.Log;

public class ContainerCloudUpload {


	
	private static WebElement element = null;
	
	
	//-----------------------drop box------------------------------------//
	
	public static WebElement filmContainer_dropbox(WebDriver driver)throws Exception{
		element = driver.findElement(By.xpath("html/body/div[5]/div/section/div/form/div[1]"));
		Log.info("drop box film container found");
		return element;
	}
	
	public static WebElement film_dropbox(WebDriver driver)throws Exception{
		element = driver.findElement(By.xpath("html/body/div[5]/div/section/div/form/div[1]/div/div/div[1]/ul/li[1]/a"));
		Log.info("drop box film on container found");
		return element;
	}
	
	public static WebElement Select_Button_DropBox(WebDriver driver)throws Exception{
		element = driver.findElement(By.xpath("html/body/div[5]/div/section/div/form/div[4]/input"));
		Log.info("drop box film container  submit button found");
		return element;
		
		
	}
	
//------------------------------------ S3--------------------------------------//	
	
	public static WebElement filmContainer_S3(WebDriver driver)throws Exception{
		element = driver.findElement(By.xpath("html/body/div[6]/div/section/div/form/div[1]"));
		Log.info("S3 film container found");
		return element;
	}
	
	public static WebElement film_S3(WebDriver driver)throws Exception{
		element = driver.findElement(By.xpath("html/body/div[6]/div/section/div/form/div[1]/div/div/div/ul/li[1]/a"));
		Log.info("S3 film on container found");
		return element;
	}
	
	public static WebElement Select_Button_S3(WebDriver driver)throws Exception{
		element = driver.findElement(By.xpath("html/body/div[6]/div/section/div/form/div[4]/input[1]"));
		Log.info("S3 film container submit button found");
		return element;
	}
	
	//------------------------------------ gDrive--------------------------------------//	
	
		public static WebElement filmContainer_gDrive(WebDriver driver)throws Exception{
			element = driver.findElement(By.xpath("html/body/div[6]/div/section/div/form/div[1]"));
			Log.info("gdrive film container found");
			return element;
		}
		
		public static WebElement film_gDrive(WebDriver driver)throws Exception{
			element = driver.findElement(By.xpath("html/body/div[6]/div/section/div/form/div[1]/div/div/div/ul/li[1]/a"));
			Log.info("gdrive film on container found");
			return element;
		}
		
		public static WebElement Select_Button_gDrive(WebDriver driver)throws Exception{
			element = driver.findElement(By.xpath("html/body/div[6]/div/section/div/form/div[4]/input[1]"));
			Log.info("gdrive film container submit button found");
			return element;
		}
		
		
		//--------------------------------sugerSync-------------------------------//
		
		public static WebElement filmContainer_sugerSync(WebDriver driver)throws Exception{
			element = driver.findElement(By.xpath("html/body/div[6]/div/section/div/form/div[1]"));
			Log.info("sugersync film container found");
			return element;
		}
		
		public static WebElement form_sugerSync(WebDriver driver)throws Exception{
			element = driver.findElement(By.xpath("html/body/div[6]/div/section/div/form/div[1]/div/div/div/ul/li/a"));
			Log.info("sugersync form on container found");
			return element;
		}
		
		
		public static WebElement film_sugerSync(WebDriver driver)throws Exception{
			element = driver.findElement(By.xpath("html/body/div[6]/div/section/div/form/div[1]/div/div/div/ul/li/ul/li/a"));
			Log.info("sugersync film on container found");
			return element;
		}
		
		
		public static WebElement Select_Button_sugerSync(WebDriver driver)throws Exception{
			element = driver.findElement(By.xpath("html/body/div[6]/div/section/div/form/div[4]/input[1]"));
			Log.info("sugersync film container submit button found");
			return element;
		}
		
		
		
		
		
	//---------------------------------oneDrive--------------------------------------//
		
		public static WebElement filmContainer_oneDrive(WebDriver driver)throws Exception{
			element = driver.findElement(By.xpath("html/body/div[6]/div/section/div/form/div[1]"));
			Log.info("onedrive film container found");
			return element;
		}
		
		public static WebElement film_oneDrive(WebDriver driver)throws Exception{
			element = driver.findElement(By.xpath("html/body/div[6]/div/section/div/form/div[1]/div/div/div/ul/li[4]/a"));
			Log.info("onedrive film on container found");
			return element;
		}
		
		public static WebElement Submit_Button_oneOrive(WebDriver driver)throws Exception{
			element = driver.findElement(By.xpath("html/body/div[6]/div/section/div/form/div[4]/input[1]"));
			Log.info("onedrive film container submit button found");
			return element;
		}
		
		
		
		
		
		
		
		
		
		

}
