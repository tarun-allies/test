package testCases;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import appModules.SigIn_action;
import pageObject.API_Twiiter;
import pageObject.API_facebook;
import pageObject.Page_Header;
import pageObject.Password_Page;
import pageObject.SignIn_Page;
import Utility.Constant;
import Utility.Excel;
import Utility.Log;


/**
 * The testSignIn_LockOut class implements an application that simply test signin lockout and
 * displays output result in the excel sheet
 */

public class TestSignIn_LockOut {

	private static String sUsername;
	private static String sPassword;
	private static String Parent_Window;
	private static WebElement element = null;

	public TestSignIn_LockOut (String sUsername, String sPassword,String Parent_Window) 
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

		Log.startTestCase("testSignIn_LockOut");

		/* function for setting excel sheet to read test data */
		setTestData(driver);

		/* This will execute all the test cases for account lockOut */
		test_lockOut(driver);

		Log.endTestCase("testSignIn_LockOut");


	}


	public static void test_lockOut(WebDriver driver) throws Exception

	{

		driver.get(Constant.URL +"/index.php/login");

		test_account_Lockout_When_Email_Is_Wrong(driver);
		test_account_Lockout_When_Entered_Password_Is_Wrong(driver);
		test_try_again_and_use_same_email(driver);
		test_resetMyPassword_on_lockout(driver);

	}

	

	public static void setTestData(WebDriver driver) throws Exception {

		Excel.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "signIn");
		Log.info("Excel sheet set up to fetch test data");
	}

	

	public static void test_account_Lockout_When_Email_Is_Wrong(WebDriver driver)
			throws Exception {
		
		sUsername = Excel.getCellData(25, 1);
		Log.info("username been picked up");

		sPassword = Excel.getCellData(25, 2);
		Log.info("password  been picked up");


		for (int i = 0; i<=4; i++)
          {
			 SigIn_action.Execute(driver, sUsername, sPassword);
			Log.info("signin action has been executed");
	    
          }

		if (SignIn_Page.lockout_button(driver).getText()
				.contains(Excel.getCellData(25, 3))) {
			Excel.setCellData("Pass", 25, 4);
			Log.info("result posted over excelscheet with status as pass");
		} else {
			Excel.setCellData("Fail", 25, 4);
			Log.info("result posted over excelscheet with status as fail");
		}
		
		}

	

	public static void test_account_Lockout_When_Entered_Password_Is_Wrong(
			WebDriver driver) throws Exception

	{

		driver.get(Constant.URL +"/index.php/login");

		sUsername = Excel.getCellData(26, 1);
		Log.info("username been picked up");

		sPassword = Excel.getCellData(26, 2);
		Log.info("password  been picked up");

		Excel.setExcelFile(
				Constant.Path_TestData + Constant.File_TestData, "signIn");

		for (int i = 0; i <= 4; i++)

		{
			SigIn_action.Execute(driver, sUsername, sPassword);
			Log.info("signin action has been executed");
			
		}

		if (SignIn_Page.lockout_button(driver).getText()
				.contains(Excel.getCellData(26, 3))) {
			Excel.setCellData("Pass", 26, 4);
			Log.info("result posted over excelscheet with status as pass");
		} else {
			Excel.setCellData("Fail", 26, 4);
			Log.info("result posted over excelscheet with status as fail");
		}
		
		

	}

	public static void test_try_again_and_use_same_email(WebDriver driver)
			throws Exception

	{

		SignIn_Page.tryAgain_button(driver).click();

		SigIn_action.Execute(driver, sUsername, sPassword);
		Log.info("signin action has been executed");

		if (SignIn_Page.lockout_button(driver).getText()
				.contains(Excel.getCellData(27, 3))) {
			Excel.setCellData("Pass", 27, 4);
			Log.info("result posted over excelscheet with status as pass");
		} else {
			Excel.setCellData("Fail", 27, 4);
			Log.info("result posted over excelscheet with status as fail");
		}

	}

	public static void test_resetMyPassword_on_lockout(WebDriver driver)
			throws Exception

	{

		SignIn_Page.forgetPassword_button(driver).click();

		element = (new WebDriverWait(driver, 10).until(ExpectedConditions
				.elementToBeClickable(Password_Page.txt_password(driver))));

	

	}

	private static boolean isElementPresent(WebElement webElement) {
		// TODO Auto-generated method stub
		return false;
	}

}


