package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility.Log;

public class FilmCreate_Page {

	
	private static WebElement element = null;
	
	public static WebElement button_UploadFullFilm(WebDriver driver)throws Exception{
		element = driver.findElement(By.xpath("html/body/div[3]/section/article/section/article/div/div/div/div[1]/div[1]/ul/li[1]/div/div[1]/button"));
		Log.info("Create full film button found");
				return element;
		
	}
	
	public static WebElement Text_On_createdFullFilm(WebDriver driver)throws Exception{
		element = driver.findElement(By.xpath("html/body/div[3]/section/article/section/article/div/div/div/div[1]/div[1]/ul/li[1]/div/div[2]/div[2]/p"));
		Log.info("text after film uploaded found");
				return element;
		
	}
	
	
	public static WebElement button_createTrailer(WebDriver driver)throws Exception{
		element = driver.findElement(By.xpath("html/body/div[3]/section/article/section/article/div/div/div/div[1]/div[1]/ul/li[2]/div/div[1]/button"));
		Log.info("Create trailer button for full film found");
				return element;
		
	}
	
	
	public static WebElement text_on_createdTrailer(WebDriver driver)throws Exception{
		element = driver.findElement(By.xpath("html/body/div[3]/section/article/section/article/div/div/div/div[1]/div[1]/ul/li[2]/div/div[2]/div[2]/p"));
		Log.info("text after trailer created found");
				return element;
		
	}
	
	public static WebElement textbox_setting_Form(WebDriver driver)throws Exception{
		element = driver.findElement(By.xpath("html/body/div[3]/section/article/section/article/div/div/div/div[2]/section/div[2]/form/section"));
		Log.info("text for setting found");
		return element;

	}
	
	public static WebElement textbox_cropChekout(WebDriver driver)throws Exception{
		element = driver.findElement(By.id("crop-trailer"));
		Log.info("crop tick box found");
		return element;

	}
	
	public static WebElement settings_saveButton(WebDriver driver)throws Exception{
		element = driver.findElement(By.xpath("html/body/div[3]/section/article/section/article/div/div/div/div[2]/section/div[2]/form/section/ul/li[10]/button"));
		Log.info("save button found");
		return element;

	}
	
	

}
