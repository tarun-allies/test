package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility.Log;

public class Container_SelectUploadType {


	
	private static WebElement element = null;
	
	public static WebElement dropBox_link(WebDriver driver)throws Exception{
		element = driver.findElement(By.xpath("html/body/div[4]/div/section/div[2]/ul[1]/li[1]/p[1]/img"));
		Log.info("dropbox link found");
		return element;
		
		
	}
	
	
	public static WebElement S3_link(WebDriver driver)throws Exception{
		element = driver.findElement(By.xpath("html/body/div[4]/div/section/div[2]/ul[1]/li[2]/p[1]/img"));
		Log.info("S3 link found");
		return element;
		
		}
	
	public static WebElement gDrive_link(WebDriver driver)throws Exception{
		element = driver.findElement(By.xpath("html/body/div[4]/div/section/div[2]/ul[2]/li[1]/p[1]/img"));
		Log.info("gdrive link found");
		return element;
		
		}
	
	public static WebElement sugerSync_link(WebDriver driver)throws Exception{
		element = driver.findElement(By.xpath("html/body/div[4]/div/section/div[2]/ul[2]/li[2]/p[1]/img"));
		Log.info("sugersync link found");
		return element;
		
		}
	
	public static WebElement oneDrive_link(WebDriver driver)throws Exception{
		element = driver.findElement(By.xpath("html/body/div[4]/div/section/div[2]/ul[2]/li[3]/p[1]/img"));
		Log.info("onedrive link found");
		return element;
		
		}
	
	public static WebElement browserUpload_link(WebDriver driver)throws Exception{
		element = driver.findElement(By.xpath("html/body/div[4]/div/section/div[1]/ul/li[2]/span"));
		Log.info("browserupload link found");
		return element;
		
		}
	
	
	public static WebElement browserUpload_Button(WebDriver driver)throws Exception{
		element = driver.findElement(By.xpath("html/body/div[4]/div/section/div[3]/div/ul/li[1]/button"));
		Log.info("browser upload full film button found");
		return element;
		
		}
	
	public static WebElement browserUploadTrailer_Button(WebDriver driver)throws Exception{
		element = driver.findElement(By.id("trailer-movie-popup"));
		Log.info("browser upload trailer button found");
		return element;
		
		}
	
	
	
	
	
	

}
