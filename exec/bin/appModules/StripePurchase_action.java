package appModules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import Utility.Constant;
import Utility.Log;




public class StripePurchase_action {

	
	private static final WebDriver driver = null;
	private static String email;
	private static String pass;
	private static String slug;
	private static String card_number;
	private static String text;
	private static WebElement element = null;
	

    static Pattern img3 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataPurcahse+"stripe.png");
    static Pattern img4 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataPurcahse+"pay.png");

    static Screen s = new Screen();


    public StripePurchase_action(String slug, String card_number, String email, String pass, String text)
  
    {
    	this.slug = slug;
    	this.card_number = card_number;
    	this.pass = pass;
    	this.text = text;
    }
               	
               	public static void Execute(WebDriver driver) throws Exception
               
               	{
               		
               	  valid_card_details(driver);
   	              Log.info("card details set");

	        	     s.wait(img3, 100);
                     s.click(img3);
                     s.type(card_number);
                     Log.info("Card number enterd");
	        	  
                     s.type(Key.TAB);
                     s.type("06/17");
                     Log.info("CArd expiry date entered");

                     s.type(Key.TAB);
                     s.type("123");
                     Log.info("Code enterd");

                     s.click(img4);
                     Log.info("Clicked on pay");

                    
	            }
               	
                public static void valid_card_details(WebDriver driver) throws Exception
  	          
  	          {
  	        	  
                           card_number =  "4242424242424242";
  	          }
  	          
  	          
              
  	          public static void invalid_card_details(WebDriver driver) throws Exception
  	          
  	          {
  	        	 
                         card_number = "4007000000027";
  	          }
  	      
              
  	          
  	          public static void declined_card_details(WebDriver driver) throws Exception
  	          
  	          {
  	        	  
                      card_number = "4000000000000002";
  	          }
	          
	          
	       
             
             

	private static boolean assertTrue(boolean b) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

	

}
