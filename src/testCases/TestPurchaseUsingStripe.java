package testCases;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import appModules.PlayerSignIN_action;
import appModules.PlayerSignUp_action;
import appModules.StripePurchase_action;
import pageObject.FilmDetail_Page;
import pageObject.Page_Header;
import pageObject.UserProfilePurchase_page.UserProfile_Purchase;
import Utility.Constant;
import Utility.Excel;
import Utility.Log;

public class TestPurchaseUsingStripe {

	
	private static final WebDriver driver = null;
	private static String email;
	private static String pass;
	private static String slug;
	private static String card_number;
	private static String text;
	private static WebElement element = null;
	
	static Pattern img = new Pattern(Constant.Path_TestData+Constant.Img_TestDataPurcahse+"purchase_signup.png");
    static Pattern img1 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataPurcahse+"email.png");
    static Pattern img2 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataPurcahse+"submit.png");
    static Pattern img3 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataPurcahse+"stripe.png");
    static Pattern img4 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataPurcahse+"pay.png");
    static Pattern img5 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataPurcahse+"watch.png");
    static Pattern img6 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataPurcahse+"signIn_link.png");
    Pattern img7 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataPurcahse+"signIn_Submit.png");
    static Pattern img8 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataPurcahse+"checkOut.png");
    static Pattern img9 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataPurcahse+"success_screen.png");
    static Pattern img10 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataPurcahse+"download.png");
    static Pattern img11 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataPurcahse+"successScreen_rent.png");
    static Pattern img12 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataPurcahse+"continue_rent.png");
    Pattern img13 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataPurcahse+"stripeCheckOut_Invalid.png");
    
    static Screen s = new Screen();


    public TestPurchaseUsingStripe(String slug, String card_number, String email, String pass, String text)
  
    {
    	this.slug = slug;
    	this.card_number = card_number;
    	this.pass = pass;
    	this.text = text;
    }
	
	      public static void Execute(WebDriver driver)throws Exception
	       
	      {
	    	 
	       
	    	  
	    	  Log.startTestCase("TestFilmPurchaseUsingStripe");
	    	  
	    	   testPurchase_after_signup(driver);
	    	   testPurchase_after_signin(driver);
	    	   testRent_after_signin(driver);
	          
	           
	           
	           Log.endTestCase("StripePurchase_action.Execute_Action");
		  
	       }
		  
		                

	       public static void testPurchase_after_signup(WebDriver driver) throws Exception
	          
	       {
	    	   
	    	   Log.info("testPurchasing_film_as_a_new_user starts executing");
		
	    	   Excel.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"purchase_stripe");
	    	   Log.info("set excel sheet for test data");
		   
	           slug = Excel.getCellData(1, 3);
	           Log.info("test data for film slug set");
	    
	           driver.get(Constant.URL+"/index.php/video/"+slug);
	           Log.info("Fils deatil page opened");
	    
	           FilmDetail_Page.externalPurcahseLink_Buy(driver).click();
	           Log.info("External purchase link clciked");
	           
	           PlayerSignUp_action.Execute(driver);
	            Log.info("User signed in");
	           
	         
	           
	           Excel.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"purchase_stripe");
	           
	    
	            s.wait(img8, 100);  // test presence of checkout form: stripe 
	            Log.info("Check out csreen appears");

               if (s.exists(img8) != null) 
              
               {
            	   
        	      Excel.setCellData("Pass", 1, 6);
                }
               
               else
                
               {
            	   
                  Excel.setCellData("Fail", 1, 6);
                  
                }
	
	 
                StripePurchase_action.Execute(driver);           // Stripe purchase flow
                
                s.wait(img9, 100);            //------Success Screen-------//
                Log.info("Success screen appears");
             
                if(s.exists(img9) != null)             // Test success screen
        	    {
                   Excel.setCellData("Pass", 2, 6);

                 }
               else
                 {
                   Excel.setCellData("Fail", 2, 6); 
                 }
          
          
                //-----Watch And Download link on success screen------//
	         
              if(s.exists(img5) != null && s.exists(img10) != null)
                 {
                  Excel.setCellData("Pass", 3, 6);
                 }
                 else
                 {
                  Excel.setCellData("Fail", 3, 6); 
                 }
          
          

              //-----Click on download link------//
 
                s.click(img10);
                
                Log.info("Click on download");
 
               element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(UserProfile_Purchase.filmIHaveOwn(driver)));
               Log.info("Film present in purchase library");
                text = driver.getTitle();
                System.out.println(text);
 
                 if(text.equals(Excel.getCellData(4,5)))
		           {
	                Excel.setCellData("Pass", 4, 6);
		           }
                 else
                   {
	                Excel.setCellData("Fail", 4, 6); 
                   }
              
              Page_Header.munuLink(driver).click();
              Log.info("Menu opened");
    		  
    	      Page_Header.signoutButton(driver).click(); 
    	      Log.info("Clciked on signout");
    	      
    	     
    	     element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(Page_Header.signIN_link(driver)));
    	     
    	     Log.info("User Signout");
    	     
    	     Log.info("testPurchasing_film_as_a_new_user starts executing");
          
	
	           }
	



	
	         public static void  testPurchase_after_signin(WebDriver driver) throws Exception 
	           
	         {
	        	 
	        	   Log.info("testPurchasing_film_as_registered_user");
		 
	        	   slug = Excel.getCellData(5, 3);
	        	   Log.info("test data for film slug set");
	      
		          driver.get(Constant.URL+"/index.php/video/"+slug);
		          Log.info("films detail page opened");
 
                  FilmDetail_Page.externalPurcahseLink_Buy(driver).click();
                  Log.info("Clicked on external purchase link");
         
                  PlayerSignIN_action.Execute(driver);
                  
         
                   //--Test SignIN: test presence of checkout form: stripe---//
                  
                  Excel.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"purchase_stripe");
	         
                    s.wait(img8, 100);
                    
                    Log.info("Check out form appears");

                  if (s.exists(img8) != null) 
                    {
	                   Excel.setCellData("Pass", 5, 6);
                    }
                  else
                    {
	                   Excel.setCellData("Fail",5, 6);
                    }
           
           
                  StripePurchase_action.Execute(driver);
                  
                  s.wait(img9, 100);            //------Success Screen-------//
                  
                  Log.info("Success screen apears");
           

                    
    
                if(s.exists(img9) != null)
                   {
   	                 Excel.setCellData("Pass", 6, 6);
                   }
                else
                   {
                 	 Excel.setCellData("Fail", 6, 6); 
                   }
    
    
               //-----Watch And Download link on success screen------//

               if(s.exists(img5) != null && s.exists(img10) != null)
                 {
	                Excel.setCellData("Pass", 7, 6);
	             }

               else
                 {
	                Excel.setCellData("Fail", 7, 6); 
	             }

             //-----Click on download link------//

                s.click(img10);
                
                Log.info("Clciked on download link");



              text = driver.getTitle();
              System.out.println(text);

               if(text.equals(Excel.getCellData(8,5)))
		           {
	                Excel.setCellData("Pass", 8, 6);
		           }
                     else
                   {
	                 Excel.setCellData("Fail", 8, 6); 
                     }


                Page_Header.munuLink(driver).click();
                
                Log.info("Menu opened");
                   Page_Header.signoutButton(driver).click(); 
                   Log.info("Clicked on signout");
 
              element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(Page_Header.signIN_link(driver)));
              
              Log.info("user signout");
              
              Log.endTestCase("TC_001_1_purchasing_as_registered_user");
	
	
	}
	
	
	
	        public static void testRent_after_signin(WebDriver driver) throws Exception 
	         {
	  
	            Log.info("testRent_after_signin");
	            
	        	slug = Excel.getCellData(9, 3);
	        	Log.info("test data for film slug set");
                 
           	    driver.get(Constant.URL+"/index.php/video/"+slug);  
           	    Log.info("films detail page opened");
           			      
                FilmDetail_Page.externalPurcahseLink_rent(driver).click();
                Log.info("External purchase link clicked");
                
                PlayerSignIN_action.Execute(driver);
                

	            //-- Test SibgnIN: test presence of checkout form: stripe---//
                
                Excel.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"purchase_stripe");
 
                       s.wait(img8, 100);
                       
                       Log.info("Checkout screen appears");
 
                         if (s.exists(img8) != null) 
                            {
	                           Excel.setCellData("Pass", 9, 6);
                            }
                         else
                            {
	                          Excel.setCellData("Fail", 9, 6);
                            }
                         
                         
                         FilmDetail_Page.externalPurcahseLink_rent(driver).click();                             // Page state is lost as page gets reloded, hence clicking on rent again
                         Log.info("external rent button clicked");
                         
                         StripePurchase_action.Execute(driver);
                         
                         s.wait(img11, 100);            //------Success Screen-------//
                         
                         Log.info("Success creen appears");

                         if(s.exists(img11) != null)
                              {
	                             Excel.setCellData("Pass", 10, 6);
                              }
                         else
                              {
	                             Excel.setCellData("Fail", 10, 6); 
	                          }

                          //-----Only Watch link on success screen------//
 
                             if(s.exists(img5) != null )
                                 {
	                               Excel.setCellData("Pass", 11, 6);
                                 }
                                   else
                                {
	                               Excel.setCellData("Fail", 11, 6); 
	                            }
 
                       //-----Click on Watch link------//
           
                    s.click(img5);
                    
                    Log.info("Click on watch button");
                    
                    Excel.setCellData("Pass", 12, 6);
 
                 
 

               Page_Header.munuLink(driver).click();
               
               Log.info("Menu opened");
               
               Page_Header.signoutButton(driver).click(); 
               Log.info("Clicked on signout link");
               
                element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(Page_Header.signIN_link(driver)));
                Log.info("user signout");
                
                Log.endTestCase("TC_002_renting_a_film");

	        	 }
	
	        
	         
	
	           
	           
	
	
	          
	          
	          
	        
             
             

	private static boolean assertTrue(boolean b) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

	

}
