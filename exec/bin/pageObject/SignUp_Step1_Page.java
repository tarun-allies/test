package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility.Log;

public class SignUp_Step1_Page {

	
	private static WebElement element = null;
	
	public static WebElement SubmitButton(WebDriver driver){
		element = driver.findElement(By.xpath("html/body/div[1]/section/article/div[1]/div/form[2]/ul/li[7]/button"));
		Log.info("submit button found");
		return element;
		
	}
	
	

}