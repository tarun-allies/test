package testCases;

import org.openqa.selenium.WebDriver;

import appModules.SignUp_action;
import pageObject.SignUp_Page;
import Utility.Constant;
import Utility.Excel;
import Utility.Log;

public class TestSignUp_Email {

	
	private static final String Path_TestData = null;
	private static final String Sheet2 = null;
	private static String email;
	private static String password;
	private static String fullname;
	private static String month;
	private static String day;
	private static String year;

	
	
	public TestSignUp_Email(String email, String password, String fullname, String month, String day, String year){
		
		this.email = email;
		this.password = password;
		this.fullname = fullname;
		this.month = month;
        this.day = day;
        this.year = year;
	}
			
	
	public static void Execute(WebDriver driver)throws Exception{
		
		//** Setting data sheet
		
		Excel.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"signUp");
		Log.info("Excel sheet for signup set to fetch test data");
		
		
		for(int i = 1; i<=14 ; i++)
		{
			 email = Excel.getCellData(i, 2);
		     password = Excel.getCellData(i, 3);
	         fullname = Excel.getCellData(i, 4);
	         month = (Excel.getCellData(i, 6));
	      
	         SignUp_action.Execute(driver);
	         
	         String x = "Fail";
	         
	         if(SignUp_Page.ErrorMessage_BlankEmail(driver).getText().equals(Excel.getCellData(i, 8)))
	        		 {
	        	            x = "Pass";
	        		 }
	                     Excel.setCellData(x, i, 9);
		}
		
	}
	
}
	