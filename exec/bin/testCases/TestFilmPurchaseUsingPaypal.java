package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import appModules.PaypalPurchase_action;
import appModules.PlayerSignIN_action;
import appModules.PlayerSignUp_action;
import pageObject.FilmDetail_Page;
import pageObject.Page_Header;
import pageObject.UserProfilePurchase_page.UserProfile_Purchase;
import Utility.Constant;
import Utility.Excel;
import Utility.Log;

public class TestFilmPurchaseUsingPaypal {


    private static String slug;
	private static int ran;
	private static String email;
	private static String password;
	
    static Screen s = new Screen();

	Pattern img = new Pattern(Constant.Path_TestData+Constant.Img_TestDataPurcahse + "purchase_signup.png");
	static Pattern img1 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataPurcahse + "email.png");
	static Pattern img2 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataPurcahse + "submit.png");
	Pattern img3 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataPurcahse + "stripe.png");
	Pattern img4 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataPurcahse + "pay.png");
	static Pattern img5 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataPurcahse + "watch.png");
	static Pattern img6 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataPurcahse + "signIn_link.png");
	Pattern img7 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataPurcahse + "signIn_Submit.png");
	static Pattern img8 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataPurcahse + "checkOut.png");
	static Pattern img9 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataPurcahse + "success_screen.png");
	static Pattern img10 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataPurcahse + "download.png");
	static Pattern img11 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataPurcahse + "successScreen_rent.png");
	static Pattern img12 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataPurcahse + "continue_rent.png");
	Pattern img13 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataPurcahse + "stripeCheckOut_Invalid.png");
	static Pattern img14 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataPurcahse + "checkout_radioOption.png");
	static Pattern img15 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataPurcahse + "checkout_pay.png");
	static Pattern img16 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataPurcahse + "paypal_email.png");
	static Pattern img17 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataPurcahse + "paypal_login.png");
	static Pattern img18 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataPurcahse + "paypal_pay.png");
	static Pattern img19 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataPurcahse + "paypal_close.png");
	static Pattern img20 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataPurcahse + "paypal_password.png");

	public TestFilmPurchaseUsingPaypal(String slug, int ran) {

		this.slug = slug;
		this.ran = ran;
		this.email = email;
		this.password = password;

	}

	public static void Execute(WebDriver driver) throws Exception {

		Log.startTestCase("TestFilmPurchaseUsingPaypal");

		try {

			Excel.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"purchase_paypal");
            Log.info("Set excel sheet to read test data");

			Screen s = new Screen();

			 testPurchase_after_signup(driver);
	    	 testPurchase_after_signin(driver);
	    	 testRent_after_signin(driver);

		}

		catch (Exception e) {
		
			Log.error(e.getMessage());
		}

	}	
     

	public static void testPurchase_after_signup(WebDriver driver) throws Exception

	{
		Log.startTestCase("testPurchase_after_signup");

		try

		{

			/* Taking slug from excel sheet to open films detail page */
			slug = Excel.getCellData(1, 3);
			Log.info("test data for film slug set");

			/* opening details page */

			driver.get(Constant.URL + "/index.php/video/" + slug);
			Log.info("films detail page opened");

			/* Click on external purchase link */
			FilmDetail_Page.externalPurcahseLink_Buy(driver).click();
			Log.info("External buy button clicked");

			/* Sigup within player */
			PlayerSignUp_action.Execute(driver);
		    Log.info("User signup within player");
		    
		    

			if (s.exists(img8) != null) {
				Excel.setCellData("Pass", 1, 8);
				Log.info("Chek out screen present");

			} else {
				Excel.setCellData("Fail", 1, 8);
				Log.error("Missing check out screen");
			}

			/* Click on radio button to select paypal */
			s.click(img14);
			Log.info("radio button clicked");

			/* click on pay button of checkout form to open the paypal window */
			s.click(img15);
			Log.info("Pay button clicked");

			/* Purchase flow */
			PaypalPurchase_action.Execute(driver);
			Log.info("Purchase flow completed");

			/* set pay_pal excel sheet to log test result */
			Excel.setExcelFile(Constant.Path_TestData
					+ Constant.File_TestData, "purchase_paypal");

			/* Wait for success screen */
			s.wait(img9, 100);

			if (s.exists(img9) != null) {
				Excel.setCellData("Pass", 2, 8);
				Log.info("Success screen find, purchase made");

			} else {
				Excel.setCellData("Fail", 2, 8);
				Log.error("Success screen not found");

			}

			/* Check for watch and download link on success screen */

			if (s.exists(img5) != null && s.exists(img10) != null) {
				Excel.setCellData("Pass", 3, 8);
				Log.info("Watch and download button found");
			} else {
				Excel.setCellData("Fail", 3, 8);
				Log.error("Watch and download button not found");
			}

			/* Click on download button */
			s.click(img10);
			Log.info("Download button clicked");

			/* waiting to get redirected */
			WebElement element = (new WebDriverWait(driver, 10))
					.until(ExpectedConditions
							.elementToBeClickable(UserProfile_Purchase
									.filmIHaveOwn(driver)));

			/* Getting page title */
			String filmname = driver.getTitle();
			System.out.println(filmname);

			if (password.equals(Excel.getCellData(4, 7))) {
				Excel.setCellData("Pass", 4, 8);
				Log.info("redirected to profile purchase");
			} else {
				Excel.setCellData("Fail", 4, 8);
				Log.info("not redirected to profile purchase");
			}
			
			
			WebElement element2 = (new WebDriverWait(driver, 10))
					.until(ExpectedConditions
							.elementToBeClickable(Page_Header.munuLink(driver)));
			
			Page_Header.munuLink(driver).click();
            Log.info("Menu opened");
  		  
  	      Page_Header.signoutButton(driver).click(); 
  	      Log.info("Clciked on signout");
			
		}

		catch (Exception e) {
			Log.error(e.getMessage());
		}

		Log.endTestCase("TC_001_purchase_as_new_user");

	}

	public static void testPurchase_after_signin(WebDriver driver) throws Exception {

		Log.startTestCase("testPurchase_after_signin");

		try {
			
			/* Get test data from excel */
			slug = Excel.getCellData(6, 3);
			Log.info("test data as film slug set");

			/* openeing film detail page as per tets data */
			driver.get(Constant.URL + "/index.php/video/" + slug);
			Log.info("films detail page opened");

			/* click on external purchase link */
			FilmDetail_Page.externalPurcahseLink_Buy(driver).click();
			Log.info("external purchase link clicked");

			PlayerSignIN_action.Execute(driver);

			/* verify checkout form */

			if (s.exists(img8) != null) {
				Excel.setCellData("Pass", 6, 8);
				Log.info("Check out open");
			} else {
				Excel.setCellData("Fail", 6, 8);
				Log.info("Check out not open");
			}

			/* Click on radio button to select paypal */
			s.click(img14);
			Log.info("radio button clicked");

			/* click on pay button of checkout form to open the paypal window */
			s.click(img15);
			Log.info("Pay button clicked");

			/* Wait for paypal window to open */
			s.wait(img20, 100);

			/* Enter password */
			s.click(img20);
			Log.info("Paypal window opened");
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

			/* set pay_pal excel sheet to log test result */
			Excel.setExcelFile(Constant.Path_TestData
					+ Constant.File_TestData, "purchase_paypal");

			/* Wait for success screen */
			s.wait(img9, 100);

			if (s.exists(img9) != null) {
				Excel.setCellData("Pass", 7, 8);
				Log.info("Success screen find, purchase made");

			} else {
				Excel.setCellData("Pass", 7, 8);
				Log.error("Success screen not found");

			}

			/* Check for watch and download link on success screen */

			if (s.exists(img5) != null && s.exists(img10) != null) {
				Excel.setCellData("Pass", 8, 8);
				Log.info("Watch and download button found");
			} else {
				Excel.setCellData("Pass", 8, 8);
				Log.error("Watch and download button not found");
			}

			/* Click on download button */
			s.click(img10);
			Log.info("Download button clicked");

			/* waiting to get redirected */
			WebElement element = (new WebDriverWait(driver, 10))
					.until(ExpectedConditions
							.elementToBeClickable(UserProfile_Purchase
									.filmIHaveOwn(driver)));

			/* Getting page title */
			String filmname = driver.getTitle();
			System.out.println(filmname);

			if (filmname.equals(Excel.getCellData(4, 7))) {
				Excel.setCellData("Pass", 9, 8);
				Log.info("redirected to profile purchase");
			} else {
				Excel.setCellData("Fail", 9, 8);
				Log.info("not redirected to profile purchase");
			}
		}

		catch (Exception e) {
			Log.error(e.getMessage());
		}

		Log.endTestCase("TC_002_purchaseing_as_registered_user");

	}
	
	  public static void testRent_after_signin(WebDriver driver) throws Exception {
   	   
	    	
			Log.startTestCase("TC_003_renting_film");

			try {
				/* Get test data from excel */
				slug = Excel.getCellData(16, 3);
				Log.info("test dada as film slug set");

				/* openeing film detail page as per tets data */
				driver.get(Constant.URL + "/index.php/video/" + slug);
				Log.info("films detail page opened");

				/* click on external purchase link */
				FilmDetail_Page.externalPurcahseLink_Buy(driver).click();
				Log.info("external purchase link clicked");

				PlayerSignIN_action.Execute(driver);

				/* verify checkout form */

				if (s.exists(img8) != null) {
					Excel.setCellData("Pass", 16, 8);
					Log.info("Check out open");
				} else {
					Excel.setCellData("Fail", 16, 8);
					Log.info("Check out not open");
				}
				
				/*Click on external rent button*/
				FilmDetail_Page.externalPurcahseLink_rent(driver).click();

				/* Click on radio button to select paypal */
				s.click(img14);
				Log.info("radio button clicked");
				
				
				/* click on pay button of checkout form to open the paypal window */
				s.click(img15);
				Log.info("Pay button clicked");

				/* Wait for paypal window to open */
				s.wait(img20, 100);

				/* Enter password */
				s.click(img20);
				Log.info("Paypal window opened");
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

				/* set pay_pal excel sheet to log test result */
				Excel.setExcelFile(Constant.Path_TestData
						+ Constant.File_TestData, "purchase_paypal");

				/* Wait for success screen */
				s.wait(img9, 100);

				if (s.exists(img9) != null) {
					Excel.setCellData("Pass", 17, 8);
					Log.info("Success screen find, purchase made");

				} else {
					Excel.setCellData("Pass", 17, 8);
					Log.error("Success screen not found");

				}

				/* Check for watch and download link on success screen */

				if (s.exists(img5) != null && s.exists(img10) != null) {
					Excel.setCellData("Pass", 18, 8);
					Log.info("Watch and download button found");
				} else {
					Excel.setCellData("Pass", 18, 8);
					Log.error("Watch and download button not found");
				}

				/* Click on download button */
				s.click(img10);
				Log.info("Download button clicked");

				/* waiting to get redirected */
				WebElement element = (new WebDriverWait(driver, 10))
						.until(ExpectedConditions
								.elementToBeClickable(UserProfile_Purchase
										.filmIHaveOwn(driver)));

				/* Getting page title */
				String filmname = driver.getTitle();
				System.out.println(filmname);

				if (filmname.equals(Excel.getCellData(4, 7))) {
					Excel.setCellData("Pass", 19, 8);
					Log.info("redirected to profile purchase");
				} else {
					Excel.setCellData("Fail", 19, 8);
					Log.info("not redirected to profile purchase");
				}
			}

			catch (Exception e) {
				Log.error(e.getMessage());
			}

			Log.endTestCase("TC_002_purchaseing_as_registered_user");

		}



	
	public static void signOut(WebDriver driver) throws Exception {

		try {
			/* Click on menu */
			Page_Header.munuLink(driver).click();
			Log.info("Menu opened");

			/* Click on signout link */
			Page_Header.signoutButton(driver).click();
			Log.info("Signout clicked");

			/* Wait for user to signout */

			WebElement element2 = (new WebDriverWait(driver, 10))
					.until(ExpectedConditions.elementToBeClickable(Page_Header
							.signIN_link(driver)));
			Log.info("user signout");
		}

		catch (Exception e) {
			Log.error(e.getMessage());
		}
	}

}
