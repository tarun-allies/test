package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility.Log;

public class FilmDetail_Page {


	
	private static WebElement element = null;
	
	public static WebElement shareLink_Facebook(WebDriver driver){
		element = driver.findElement(By.xpath("html/body/div[1]/section[2]/article/div[1]/div/div/div[1]/a[1]/span"));
		Log.info("facebook share link found");
		return element;
		
	}
	
	public static WebElement shareLink_Twitter(WebDriver driver){
		element = driver.findElement(By.xpath("html/body/div[1]/section[2]/article/div[1]/div/div/div[1]/a[2]/span"));
		Log.info("twitter share link found");
		return element;
		
	}
	
	
	public static WebElement externalPurcahseLink_Buy(WebDriver driver)
	    {
		element = driver.findElement(By.xpath("html/body/div[1]/section[2]/article/div[2]/div[1]/div[2]/a[2]/span"));
		Log.info("external purchase buy button found");
		return element;
		}
	
	public static WebElement externalPurcahseLink_rent(WebDriver driver)
    {
	element = driver.findElement(By.xpath("html/body/div[1]/section[2]/article/div[2]/div[1]/div[2]/a[1]/span"));
	Log.info("external purchase rent button found");
	return element;
	}
	
	public static WebElement player_TextOnInvalidCArd(WebDriver driver)
    {
	element = driver.findElement(By.xpath("html/body/div[1]/section[1]/div/div/p"));
	Log.info("text on player for invalid card found");
	return element;
	}
	
	public static WebElement player_BackButtonOnInvalidCard(WebDriver driver)
    {
	element = driver.findElement(By.xpath("html/body/div[1]/section[1]/div/div/a"));
	Log.info("back button on invalid card screen found");
	return element;
	}
	
}
