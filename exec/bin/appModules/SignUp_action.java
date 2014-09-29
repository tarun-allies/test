package appModules;

import org.openqa.selenium.WebDriver;

import pageObject.SignUp_Page;
import AutomationFramework.GenerateTestData;
import Utility.Constant;
import Utility.Excel;
import Utility.Log;


public class SignUp_action {
	
	private static final String Path_TestData = null;
	private static final String Sheet2 = null;
	private static String sUsername;
	private static String sPassword;
	private static String Fullname;
	private static String month;
	private static String day;
	private static String year;

	
	
	public SignUp_action(String sUsername, String sPassword, String Fullname, String month, String day, String year){
		
		this.sUsername = sUsername;
		this.sPassword = sPassword;
		this.Fullname = Fullname;
		this.month = month;
        this.day = day;
        this.year = year;
	}
			
	

	
	
   public static void Execute(WebDriver driver) throws Exception {
	   
	   driver.get(Constant.URL+"/index.php/signup");
	   
	   String[] generatedInfo = GenerateTestData.Execute(driver);
	    
	    sUsername = generatedInfo[0];
	    sPassword = generatedInfo[1];
	    Fullname = generatedInfo[2];
	    month  = ("Jan");
	    
	    SignUP(driver, sUsername, sPassword, Fullname, month);
   }

   
 

public static void SignUP(WebDriver driver, String sUsername, String sPassword, String fullname, String month) throws Exception 

{
	   SignUp_Page.field_Email(driver).clear();
	   SignUp_Page.field_Email(driver).sendKeys(sUsername);
	 
	  SignUp_Page.field_Password(driver).clear();
	  SignUp_Page.field_Password(driver).sendKeys(sPassword);
	
	  SignUp_Page.field_FullNmae(driver).clear();
	  SignUp_Page.field_FullNmae(driver).sendKeys(Fullname);
	

	  SignUp_Page.field_DOB_Month(driver).sendKeys(month);
	
	
	  SignUp_Page.value_DOB_Date(driver).sendKeys("10");
	
	 SignUp_Page.value_DOB_Year(driver).sendKeys("1990");
	
	 SignUp_Page.button_IdentifyAS(driver).click();
	 
	 SignUp_Page.submitButton(driver).click(); 

}

}



