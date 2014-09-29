package appModules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import AutomationFramework.GenerateTestData;
import Utility.Constant;
import Utility.Excel;
import Utility.Log;

public class PlayerSignIN_action {


	private static final WebDriver driver = null;
	private static String sUsername;
	private static String sPassword;
	private static String slug;
	private static String card_number;
	private static String text;
	private static WebElement element = null;
	
	
    static Pattern img1 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataPurcahse+"email.png");
    static Pattern img6 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataPurcahse+"signIn_link.png");
    static Pattern img12 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataPurcahse+"continue_rent.png");

    
    static Screen s = new Screen();


public static void Execute(WebDriver driver) throws Exception 

{
	
	
	Excel.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"TestingData" );
	
	sUsername = Excel.getCellData(1, 1);
	sPassword = Excel.getCellData(1, 2);
	
     s.wait(img1, 100);
     Log.info("Signup screen opened");

     s.click(img6);
     Log.info("Click on signin link");
     
     s.click(img1);                        // SignIN  form
	 s.type(sUsername);
     Log.info("Email Entererd");
     
     s.type(Key.TAB);
     
     System.out.println(sPassword);
     s.type(sPassword);
     Log.info("Password eneterd");

     s.doubleClick(img12);
     Log.info("Clicked on signin");
}


}