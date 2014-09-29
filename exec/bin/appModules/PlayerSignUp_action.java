package appModules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import pageObject.FilmDetail_Page;
import AutomationFramework.GenerateTestData;
import Utility.Constant;
import Utility.Excel;

public class PlayerSignUp_action {
	

	private static final WebDriver driver = null;
	private static String sUsername;
	private static String sPassword;
	private static String slug;
	private static String card_number;
	private static String text;
	private static WebElement element = null;
	
	
    static Pattern img1 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataPurcahse+"email.png");
    
    static Pattern img2 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataPurcahse+"submit.png");
    
    static Pattern img6 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataPurcahse+"signIn_link.png");
   
    static Pattern img12 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataPurcahse+"continue_rent.png");

    
    static Screen s = new Screen();



public static void Execute(WebDriver driver) throws Exception

{
	


    String[] generatedInfo = GenerateTestData.Execute(driver);
    
    sUsername = generatedInfo[0];
    sPassword = generatedInfo[1];

    s.wait(img1, 100);
    s.click(img1);
    s.type(img1,"TEST USER");

    s.type(Key.TAB);
    s.type(sUsername);

    s.type(Key.TAB);
    s.type(sPassword);

    s.doubleClick(img2);

 }

}
