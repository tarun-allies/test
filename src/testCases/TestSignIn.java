package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import appModules.SigIn_action;
import pageObject.Page_Header;
import Utility.Constant;
import Utility.Excel;
import Utility.Log;


/**
 * The testSignIn class implements an application that simply test signin and
 * displays output result in the excel sheet
 */

public class TestSignIn {

	private static String sUsername;
	private static String sPassword;
	private static String Parent_Window;
	private static WebElement element = null;

	public TestSignIn (String sUsername, String sPassword,String Parent_Window) 
	{

		this.sUsername = sUsername;
		this.sPassword = sPassword;
		this.Parent_Window = Parent_Window;
	}

	/**
	 * This method will set the test data from excel and then use
	 * this test data in the test_signIN_Email method
	 */

	public static void Execute(WebDriver driver) throws Exception

	{

		Log.startTestCase("SignIn_Email");

		/* function for setting excel sheet to read test data */
		setTestData(driver);

		/* This will execute all the signIn test cases using email */
		test_signIN_Email(driver);

	}
	
	
	/**
	 * This method will call the signIn_action and will pass the test data into it 
	 * 
	 */

	public static void test_signIN_Email(WebDriver driver) throws Exception

	{

		Log.startTestCase("SignIn Email");

		try
		{
		
			driver.get(Constant.URL+"/index.php/login");	
		    Log.info("SignIn page has been crowled");

            sUsername = Excel.getCellData(1, 1);
		    Log.info("username been picked up");
		    System.out.println(sUsername);

		    sPassword = Excel.getCellData(1, 2);
		    Log.info("password  been picked; up");
		    System.out.println(sPassword);

		    SigIn_action.Execute(driver, sUsername, sPassword);
		    Log.info("signin action has been executed");
		    
		    element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(Page_Header.munuLink(driver)));

		    Log.info("user successfully signin");
		    
		    String user = Page_Header.munuLink(driver).getText();
		    
		    Assert.assertEquals(user,"Tarun Sahu");
		    		
		    Page_Header.munuLink(driver).click();
		    Log.info("menu link appears");

		    Page_Header.signoutButton(driver).click();
		
		   element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(Page_Header.signIN_link(driver)));
		   Log.info("user successfully signout");

		   Excel.setCellData("Pass", 1, 4);
		   Log.info("result posted over excelscheet with status as pass");

		   Log.endTestCase("test_signIN_Email");
		
		}
		catch (Exception e)
		{
			throw (e);
		}

	}



	/**
	 * This method will set the excel sheet to fetch test data
	 */

	public static void setTestData(WebDriver driver) throws Exception
	{

		Excel.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "signIn");
		Log.info("Excel sheet set up to fetch test data");
	}


	
	

	

	

	private static boolean isElementPresent(WebElement webElement) {
		// TODO Auto-generated method stub
		return false;
	}

}


