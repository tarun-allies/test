package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Utility.Log;



public class Page_Header {
	
	private static WebElement element = null;
	
	public static WebElement munuLink(WebDriver driver){
		element = driver.findElement(By.id("menu-h"));
		Log.info("menu link found");
		return element;
		
	}
	
	public static WebElement signoutButton(WebDriver driver){
		element = driver.findElement(By.xpath("html/body/header/article/nav/ul/li[3]/ul/li[6]/a"));
		Log.info("signout link found");
		return element;
		
	}
	
	public static WebElement searchBar(WebDriver driver){
		element = driver.findElement(By.xpath(".//*[@id='filter-films-autocomplete']"));
		Log.info("search bar found");
		return element;
		
	}
	
	
	public static WebElement signIN_link(WebDriver driver){
		element = driver.findElement(By.id("hd-login"));
		Log.info("signin link found");
		return element;
		
	}
	
	public static WebElement MyFilm_link(WebDriver driver){
		element = driver.findElement(By.xpath("html/body/header/article/nav/ul/li[3]/ul/li[2]/a"));
		Log.info("my film link found");
		return element;
		
	}
	

}


