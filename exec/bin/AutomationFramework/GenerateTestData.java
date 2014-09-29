package AutomationFramework;


import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import Utility.Constant;
import Utility.Excel;

public class GenerateTestData {

	

	private static String sPassword;
	private static String sUsername;
	private static String Fullname;
	
	
	
	public static String[] Execute (WebDriver driver)throws Exception{
		
		Excel.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"TestingData");
		String[] generatedInfo = testData(driver);
	    
		sUsername = generatedInfo[0];
		sPassword = generatedInfo[1];
		Fullname = generatedInfo[2];
		
	    
	      // setting spreadsheet and putting the data
	 
	  Excel.setCellData(sUsername, 1, 1);
	  Excel.setCellData(sPassword, 1, 2);
	  
	  return generatedInfo;
	}   




	public static String[] testData(WebDriver driver) throws Exception
      {
	
        int ran = 1000+ (int)(Math.random() * ((100-1) +1));     
		sUsername = ("seleniumuser"+ran+"@indieiregn.com");
		
		sPassword = RandomStringUtils.randomAlphanumeric(20).toUpperCase();
		
		Fullname = (" Test User");
		
		
		
		String[] rsp = {sUsername, sPassword, Fullname};
        return rsp;

      }

}