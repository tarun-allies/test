package appModules;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import Utility.Constant;
import Utility.Excel;
import Utility.Log;

public class PaypalPurchase_action {
	
	private static String slug;
	private static int ran;
	private static String email;
	private static String password;
	
    static Screen s = new Screen();

	static Pattern img16 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataPurcahse + "paypal_email.png");
	static Pattern img17 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataPurcahse + "paypal_login.png");
	static Pattern img18 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataPurcahse + "paypal_pay.png");
	static Pattern img19 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataPurcahse + "paypal_close.png");
	static Pattern img20 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataPurcahse + "paypal_password.png");
	


	public static void Execute(WebDriver driver) throws Exception {

		try {

			/* set another excel sheet to get the credentials */

			Excel.setExcelFile(Constant.Path_TestData
					+ Constant.File_TestData, "Credentials");
			Log.info("Get excel seet having credentilas");

			/* Get test data from excel sheet */
			String paypal_id;
			paypal_id = Excel.getCellData(1, 1);
			Log.info("Get username from excel sheet having credentials");
			String paypal_password;
			password = Excel.getCellData(1, 2);
			System.out.println(password);
			Log.info("Get password from excel seet having credentilas");

			/* Entered username and password and login to paypal */

			s.wait(img16, 100);
			s.click(img16);
			s.type(paypal_id);
			Log.info("username entered");

			s.type(Key.TAB);
			s.type("12345678");
			Log.info("password entered");

			/* Click on login */
			s.wait(img17, 100);
			s.click(img17);
			Log.info("Login button clicked");
			s.wait(img18, 100);
			Log.info("user login to paypal");

			/* Click on pay */
			s.click(img18);
			Log.info("Pay button clicked");
			s.wait(img19, 100);
			Log.info("payment made");

			/* Click close */
			s.click(img19);
			Log.info("Close button cliked");
		}

		catch (Exception e) {
			Log.error(e.getMessage());
		}

	}

}
