package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility.Log;

public class UserProfilePurchase_page {

public static WebElement element;

public static class UserProfile_Purchase {
	
	private static WebElement element = null;
	
	
	public static WebElement filmIHaveOwn(WebDriver driver){
		
		element = driver.findElement(By.xpath("html/body/div[2]/section/article/section/article/div[2]/ul/li/a/img"));
		Log.info("button found");
		return element;
		
	}

}

}