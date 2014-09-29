package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility.Log;

public class MyFilm_Page {

	
	
	private static WebElement element = null;
	
	public static WebElement uploadNewFilm_button(WebDriver driver){
	element = driver.findElement(By.xpath("html/body/div[2]/section/article/section/article/div/div[1]/a[1]"));
	Log.info("Upload button found");
	return element;
		
		
	}

}