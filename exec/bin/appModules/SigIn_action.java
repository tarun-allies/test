package appModules;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObject.API_Twiiter;
import pageObject.API_facebook;
import pageObject.Page_Header;
import pageObject.Password_Page;
import pageObject.SignIn_Page;
import Utility.Constant;
import Utility.Excel;
import Utility.Log;


/**
 * The SignIn_Action class implements an application that simply test signin and
 * displays output result in the excel sheet
 */

public class SigIn_action {

	private static String sUsername;
	private static String sPassword;
	private static String Parent_Window;
	private static WebElement element = null;

	public SigIn_action(String sUsername, String sPassword,String Parent_Window) 
	{

		this.sUsername = sUsername;
		this.sPassword = sPassword;
		this.Parent_Window = Parent_Window;
	}

	/**
	 * This method invokes all the signIn test cases
	 */

	public static void Execute(WebDriver driver, String sUsername, String sPassword) throws Exception 
	
	{
        try
         {
		
        element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(SignIn_Page.email_field(driver)));
		
        SignIn_Page.email_field(driver).clear();
		SignIn_Page.email_field(driver).sendKeys(sUsername);
		Log.info("username entered into email field");

		SignIn_Page.password_field(driver).clear();
		SignIn_Page.password_field(driver).sendKeys(sPassword);
		Log.info("password entered into password field");

		SignIn_Page.button_Submit(driver).click();
		Log.info("Button submitted succesfully");
		
		
	}

        catch(Exception e)
        {
        	throw (e);
        }
	

	}



	private static boolean isElementPresent(WebElement webElement) {
		// TODO Auto-generated method stub
		return false;
	}

}

