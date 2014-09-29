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
 * The testSignIn_Twitter class implements an application that simply test signin using twitter 
 * and displays output result in the excel sheet
 */

public class TestSignIn_Twitter {

	private static String sUsername;
	private static String sPassword;
	private static String Parent_Window;
	private static WebElement element = null;

	public TestSignIn_Twitter (String sUsername, String sPassword,String Parent_Window) 
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

		Log.startTestCase("testSignIn_Twitter");

		/* function for setting excel sheet to read test data */
		setTestData(driver);

		

		/* This will execute all the signIn test cases using twitter */
		test_signIn_Twitter(driver);

	
		Log.endTestCase("testSignIn_Twitter");


	}

	public static void setTestData(WebDriver driver) throws Exception {

		Excel.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "signIn");
		Log.info("Excel sheet set up to fetch test data");
	}

	public static void test_signIn_Twitter(WebDriver driver) throws Exception

	{

		driver.get(Constant.URL +"/index.php/login");

		Parent_Window = driver.getWindowHandle();
		Log.info("saved parent window title");

		SignIn_Page.TwitterButton(driver).click();
		Log.info("Twitter button clicked");

		for (String winHandle : driver.getWindowHandles()) 
		{
			Log.info("twitter pop-up window opened");
			driver.switchTo().window(winHandle);
			Log.info("switched to twitter window");
		}

		sUsername = Excel.getCellData(20, 1);
		Log.info("username been picked up");

		sPassword = Excel.getCellData(20, 2);
		Log.info("password  been picked up");

		API_Twiiter.email_field(driver).clear();
		API_Twiiter.email_field(driver).sendKeys(sUsername);
		Log.info("username entered");

		API_Twiiter.password_field(driver).clear();
		API_Twiiter.password_field(driver).sendKeys(sPassword);
		Log.info("password entered");

		API_Twiiter.allow_button(driver).click();
		Log.info("allow clicked");
		
		API_Twiiter.allow_button(driver).click();

		driver.switchTo().window(Parent_Window);
		Log.info("popup closed, switched to main window");
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		Page_Header.munuLink(driver).click();
		Log.info("menu opened");
		
		Page_Header.signoutButton(driver).click();
		Log.info("signout clicked");

		element = (new WebDriverWait(driver, 10)).until(ExpectedConditions
				.elementToBeClickable(Page_Header.signIN_link(driver)));
		
		Log.info("user signout");

		Excel.setCellData("Pass", 19, 4);
		Log.info("result posted over excelscheet with status as pass");


	}

	
	private static boolean isElementPresent(WebElement webElement) {
		// TODO Auto-generated method stub
		return false;
	}

}


