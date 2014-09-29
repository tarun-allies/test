package testCases;

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
 * The testSignIn_Facebook class implements an application that simply test signin using facebook
 *  and displays output result in the excel sheet
 */

public class TestSignIn_Facebook {

	private static String sUsername;
	private static String sPassword;
	private static String Parent_Window;
	private static WebElement element = null;

	public TestSignIn_Facebook (String sUsername, String sPassword,String Parent_Window) 
	{

		this.sUsername = sUsername;
		this.sPassword = sPassword;
		this.Parent_Window = Parent_Window;
	}

	/**
	 * This method invokes all the signIn test cases
	 */

	public static void Execute(WebDriver driver) throws Exception

	{

		Log.startTestCase("testSignIn_Facebook");

		/* function for setting excel sheet to read test data */
		setTestData(driver);

		/* This will execute all the signIn test cases using Facebook */
		test_signIn_Facebook(driver);

		Log.endTestCase("testSignIn_Facebook");

	
	}


	

	public static void setTestData(WebDriver driver) throws Exception {

		Excel.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "signIn");
		Log.info("Excel sheet set up to fetch test data");
	}

	
	public static void test_signIn_Facebook(WebDriver driver) throws Exception

	{
		
		driver.get(Constant.URL+"/index.php/login");
		Log.info("SignIn page has been crowled");

		String Parent_Window = driver.getWindowHandle();
		Log.info("Cureent window title saved");

		SignIn_Page.facebookButton(driver).click();
		Log.info("facebook button clicked");

		for (String winHandle : driver.getWindowHandles()) {
			Log.info("Facebook popup opened");
			driver.switchTo().window(winHandle);
			Log.info("switched to facebook pop-up window");
		}

		sUsername = Excel.getCellData(16, 1);
		Log.info("username been picked up");

		sPassword = Excel.getCellData(16, 2);
		Log.info("password  been picked up");
		
		API_facebook.email_field(driver).clear(); // facebook popup window
		API_facebook.email_field(driver).sendKeys(sUsername);
		Log.info("username enterd");
		API_facebook.password_field(driver).clear();
		API_facebook.password_field(driver).sendKeys(sPassword);
		Log.info("password entered");
		
		element = (new WebDriverWait(driver, 10)).until(ExpectedConditions
				.elementToBeClickable(API_facebook.login_button(driver)));

		API_facebook.login_button(driver).click();
		Log.info("SignIn button clicked");

		driver.switchTo().window(Parent_Window);
		Log.info("popup closed, switch to main window");
		
		element = (new WebDriverWait(driver, 10)).until(ExpectedConditions
				.elementToBeClickable(Page_Header.munuLink(driver)));

		Page_Header.munuLink(driver).click();
		Log.info("Click on menu");

		Page_Header.signoutButton(driver).click();
		Log.info("signout button clicked");

		element = (new WebDriverWait(driver, 10)).until(ExpectedConditions
				.elementToBeClickable(Page_Header.signIN_link(driver)));

		Log.info("user signout");

		Excel.setCellData("Pass", 16, 4);

		Log.info("Test case TC_010 executed and result posted successfully");

	}

	

	private static boolean isElementPresent(WebElement webElement) {
		// TODO Auto-generated method stub
		return false;
	}

}


