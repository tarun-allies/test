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
 * The testSignInValidationMessages class implements an application that simply test validation on user signin action and
 * displays output result in the excel sheet
 */

public class TestSignInValidationMessages {

	private static String sUsername;
	private static String sPassword;
	private static String Parent_Window;
	private static WebElement element = null;

	public TestSignInValidationMessages (String sUsername, String sPassword,String Parent_Window) 
	{

		this.sUsername = sUsername;
		this.sPassword = sPassword;
		this.Parent_Window = Parent_Window;
	}

	/**
	 * This method invokes all the signIn validation test cases
	 */

	public static void Execute(WebDriver driver) throws Exception

	{

		Log.startTestCase("testSignInValidationMessages");

		/* function for setting excel sheet to read test data */
		setTestData(driver);

		/* This will execute all the signIn test cases using email */
		test_signIN_Email_Validation(driver);

		Log.endTestCase("testSignInValidationMessages");


	}

	public static void test_signIN_Email_Validation(WebDriver driver) throws Exception

	{

		driver.get(Constant.URL+"/index.php/login");
		Log.info("SignIn page has been crowled");
		
		setTestData(driver);

		test_Validation_With_Only_Email(driver);
		test_Validation_With_Only_Password(driver);
		test_Validation_With_right_email_and_wrong_password(driver);
		test_Validation_With_wrong_email_and_right_password(driver);
		test_Validation_With_userNname_and_password(driver);
		test_Validation_With_right_userName_and_wrong_password(driver);
		test_Validation_With_wrong_userName_and_right_password(driver);
		test_Validation_With_email_and_password_field_blank(driver);
		test_Validation_using_browser_back_button_post_signOut(driver);

		Log.endTestCase("SignIn Email");

	}

	

	public static void setTestData(WebDriver driver) throws Exception {

		Excel.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "signIn");
		Log.info("Excel sheet set up to fetch test data");
	}

	public static void test_Validation_With_Only_Email(WebDriver driver) throws Exception

	{
     	Log.info("test_Validation_With_Only_Email executing");
		sUsername = Excel.getCellData(2, 1);
		Log.info("username been picked up");
		sPassword = Excel.getCellData(2, 2);
		Log.info("password has been picked up");

		SigIn_action.Execute(driver, sUsername, sPassword);
		Log.info("signin action has been executed");

		if (SignIn_Page.Error_message(driver).getText()
				.equals(Excel.getCellData(2, 3))) {
			Excel.setCellData("Pass", 2, 4);
			Log.info("result posted over excelscheet with status as pass");
		} else {
			Excel.setCellData("Fail", 2, 4);
			Log.info("result posted over excelscheet with status as fail");
		}

		Log.endTestCase("Test case TC_001 executed and result posted executed");

	}

	public static void test_Validation_With_Only_Password(WebDriver driver) throws Exception {

		Log.info("test_Validation_With_Only_Password executing");

		sUsername = Excel.getCellData(3, 1);
		Log.info("username been picked up");

		sPassword = Excel.getCellData(3, 2);
		Log.info("password  been picked up");

		SigIn_action.Execute(driver, sUsername, sPassword);
		Log.info("signin action has been executed");

		if (SignIn_Page.Error_message(driver).getText()
				.equals(Excel.getCellData(3, 3))) {
			Excel.setCellData("Pass", 3, 4);
			Log.info("result posted over excelscheet with status as pass");
		} else {
			Excel.setCellData("Fail", 3, 4);
			Log.info("result posted over excelscheet with status as fail");
		}

		Log.endTestCase("Test case TC_002 executed and result posted executed");

	}

	public static void test_Validation_With_right_email_and_wrong_password(WebDriver driver) throws Exception {

		Log.info("test_Validation_With_right_email_and_wrong_password executing");

		sUsername = Excel.getCellData(4, 1);
		Log.info("username been picked up");

		sPassword = Excel.getCellData(4, 2);
		Log.info("password  been picked up");

		SigIn_action.Execute(driver, sUsername, sPassword);
		Log.info("signin action has been executed");
		
		element = (new WebDriverWait(driver, 10)).until(ExpectedConditions
				.elementToBeClickable(SignIn_Page.Error_message(driver)));

		if (SignIn_Page.Error_message(driver).getText()
				.equals(Excel.getCellData(4, 3))) {
			Excel.setCellData("Pass", 4, 4);
			Log.info("result posted over excelscheet with status as pass");
		} else {
			Excel.setCellData("Fail", 4, 4);
			Log.info("result posted over excelscheet with status as fail");
		}

		Log.info("test_Validation_With_right_email_and_wrong_password executed");

	}

	public static void test_Validation_With_wrong_email_and_right_password(WebDriver driver) throws Exception

	{

		Log.info("test_Validation_With_wrong_email_and_right_password executing");

		sUsername = Excel.getCellData(5, 1);

		sPassword = Excel.getCellData(5, 2);
		Log.info("password  been picked up");

		SigIn_action.Execute(driver, sUsername, sPassword);
		Log.info("signin action has been executed");

		if (SignIn_Page.Error_message(driver).getText()
				.equals(Excel.getCellData(5, 3))) {
			Excel.setCellData("Pass", 5, 4);
			Log.info("result posted over excelscheet with status as pass");
		} else {
			Excel.setCellData("Fail", 5, 4);
			Log.info("result posted over excelscheet with status as fail");
		}

		Log.info("test_Validation_With_wrong_email_and_right_password executed");

	}

	public static void test_Validation_With_userNname_and_password(WebDriver driver) throws Exception

	{
		Log.info("test_Validation_With_userNname_and_password executing");

		sUsername = Excel.getCellData(6, 1);
		Log.info("username been picked up");

		sPassword = Excel.getCellData(6, 2);
		Log.info("password  been picked up");

		SigIn_action.Execute(driver, sUsername, sPassword);
		Log.info("signin action has been executed");

		Log.info("user successfully signin");
		
		element = (new WebDriverWait(driver, 10)).until(ExpectedConditions
				.elementToBeClickable(Page_Header.munuLink(driver)));

		Page_Header.munuLink(driver).click();
		Log.info("menu link appears");

		Page_Header.signoutButton(driver).click();
		
		element = (new WebDriverWait(driver, 10)).until(ExpectedConditions
				.elementToBeClickable(Page_Header.signIN_link(driver)));
		Log.info("user successfully signout");

		Excel.setCellData("Pass", 6, 4);
		Log.info("result posted over excelscheet with status as pass");

		Log.info("test_Validation_With_userNname_and_password executed");

	}

	public static void test_Validation_With_right_userName_and_wrong_password(WebDriver driver) throws Exception

	{

		Log.info("test_Validation_With_right_userName_and_wrong_password");

		driver.get(Constant.URL +"/index.php/login");

		sUsername = Excel.getCellData(7, 1);
		Log.info("username been picked up");

		sPassword = Excel.getCellData(7, 2);
		Log.info("password  been picked up");

		SigIn_action.Execute(driver, sUsername, sPassword);
		Log.info("signin action has been executed");

		if (SignIn_Page.Error_message(driver).getText()
				.equals(Excel.getCellData(7, 3))) {
			Excel.setCellData("Pass", 7, 4);
			Log.info("result posted over excelscheet with status as pass");

		} else {
			Excel.setCellData("Fail", 7, 4);
			Log.info("result posted over excelscheet with status as fail");
		}

		Log.info("test_Validation_With_right_userName_and_wrong_password executed");

	}

	public static void test_Validation_With_wrong_userName_and_right_password(WebDriver driver) throws Exception

	{

		Log.info("test_Validation_With_wrong_userName_and_right_password executing");

		sUsername = Excel.getCellData(8, 1);
		Log.info("username been picked up");

		sPassword = Excel.getCellData(8, 2);
		Log.info("password  been picked up");

		SigIn_action.Execute(driver, sUsername, sPassword);
		Log.info("signin action has been executed");

		if (SignIn_Page.Error_message(driver).getText()
				.equals(Excel.getCellData(8, 3))) {
			Excel.setCellData("Pass", 8, 4);
			Log.info("result posted over excelscheet with status as pass");
		} else {
			Excel.setCellData("Fail", 8, 4);
			Log.info("result posted over excelscheet with status as fail");
		}
		Log.info("test_Validation_With_wrong_userName_and_right_password executed");

	}

	public static void test_Validation_With_email_and_password_field_blank(WebDriver driver) throws Exception

	{

		Log.info("test_Validation_With_email_and_password_field_blank executing");

		sUsername = Excel.getCellData(9, 1);
		Log.info("username been picked up");

		sPassword = Excel.getCellData(9, 2);
		Log.info("password  been picked up");

		SigIn_action.Execute(driver, sUsername, sPassword);
		Log.info("signin action has been executed");

		if (SignIn_Page.Error_message(driver).getText()
				.equals(Excel.getCellData(9, 3))) {
			Excel.setCellData("Pass", 9, 4);
			Log.info("result posted over excelscheet with status as pass");
		} else {
			Excel.setCellData("Fail", 9, 4);
			Log.info("result posted over excelscheet with status as pass");
		}

		Log.info("test_Validation_With_email_and_password_field_blank executed");

	}

	public static void test_Validation_using_browser_back_button_post_signOut(WebDriver driver) throws Exception

	{
		Log.info("test_Validation_using_browser_back_button_post_signOut executing");

		sUsername = Excel.getCellData(10, 1);
		Log.info("username been picked up");

		sPassword = Excel.getCellData(10, 2);
		Log.info("password  been picked up");

		SigIn_action.Execute(driver, sUsername, sPassword);
		Log.info("signin action has been executed");

		Page_Header.munuLink(driver).click();
		Page_Header.signoutButton(driver).click();

		driver.navigate().back();

		Excel.setCellData("Pass", 10, 4);

		Log.info("test_Validation_using_browser_back_button_post_signOut executed");

	}

	

	private static boolean isElementPresent(WebElement webElement) {
		// TODO Auto-generated method stub
		return false;
	}

}


