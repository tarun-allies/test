package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import pageObject.ContainerCloudUpload;
import pageObject.Container_SelectUploadType;
import pageObject.FilmCreate_Page;
import pageObject.MyFilm_Page;
import pageObject.Page_Header;
import pageObject.SignUp_Step1_Page;
import appModules.BrowserUpload_action;
import appModules.CloudUpload_action;
import appModules.SignUp_action;
import Utility.Constant;
import Utility.Excel;
import Utility.Log;

public class TestBrowserUpload {

private static WebElement element;
	
	
	public static void Execute(WebDriver driver) throws Exception
	{
		
		   
		    driver.get(Constant.URL+"/index.php/signup");
			
		    SignUp_action.Execute(driver);
			
			SignUp_Step1_Page.SubmitButton(driver).click();
			
			element = (new WebDriverWait(driver, 10))
					   .until(ExpectedConditions.elementToBeClickable(Page_Header.munuLink(driver)));
			
			Page_Header.munuLink(driver).click();
			Page_Header.MyFilm_link(driver).click();
			
		   
			MyFilm_Page.uploadNewFilm_button(driver).click();
			
			
			
			
		    testBrowser_Full_Film_and_Trailer_Upload(driver);
            testUpload_Full_Film_and_Crop_2min(driver);
            testUpload_Full_Film_Using_Browser_and_Trailer_Using_Cloud(driver);
         
		
			    
			   
			    
			
		
			
		
	   }
	
	
	 public static void  testBrowser_Full_Film_and_Trailer_Upload(WebDriver driver)throws Exception
	  
	 {
	    	
	    Log.info("testBrowser_Full_Film_and_Trailer_Upload start executing");

		
	    FilmCreate_Page.button_UploadFullFilm(driver).click();
	    Log.info("Clicked on upload full film");
	    
	    element = (new WebDriverWait(driver, 10))
				   .until(ExpectedConditions.elementToBeClickable( Container_SelectUploadType.browserUpload_link(driver)));
		
        Container_SelectUploadType.browserUpload_link(driver).click();
        Log.info("Pop up opens, clicked on browser upload link");
        
        element = (new WebDriverWait(driver, 10))
				   .until(ExpectedConditions.elementToBeClickable(Container_SelectUploadType.browserUpload_Button(driver)));
        
        
        Container_SelectUploadType.browserUpload_Button(driver).click();
		
		
		BrowserUpload_action.browserUpload(driver);
		
		FilmCreate_Page.button_createTrailer(driver).click();
	    Log.info("Button to upload create trailer clicked");
		
	    Container_SelectUploadType.browserUpload_link(driver).click();
		Log.info("Container appears, clicked on browser upload link");
		
		Container_SelectUploadType.browserUploadTrailer_Button(driver).click();
		Log.info("Click on upload trailer button");
	
		BrowserUpload_action.browserUploadTrailer(driver);
		
		Log.info("Refreshing the page ");
		
		driver.navigate().refresh();
	
		Log.info("Page gets refreshed ");
		
		Log.info("testBrowser_Full_Film_and_Trailer_Upload executed");
		
	    }
	 
	 public static void testUpload_Full_Film_and_Crop_2min(WebDriver driver) throws Exception
     
     {
		
		Log.startTestCase("TC_002	Full film using browser and trailer using crop	2 min");

		 FilmCreate_Page.button_UploadFullFilm(driver).click();
		    Log.info("Clicked on upload full film");
		    
		    element = (new WebDriverWait(driver, 10))
					   .until(ExpectedConditions.elementToBeClickable( Container_SelectUploadType.browserUpload_link(driver)));
			
	        Container_SelectUploadType.browserUpload_link(driver).click();
	        Log.info("Pop up opens, clicked on browser upload link");
	        
	        element = (new WebDriverWait(driver, 10))
					   .until(ExpectedConditions.elementToBeClickable(Container_SelectUploadType.browserUpload_Button(driver)));
	        
	        
	        Container_SelectUploadType.browserUpload_Button(driver).click();
		
		BrowserUpload_action.browserUploadTrailer(driver);
		 
		 FilmCreate_Page.textbox_cropChekout(driver).click();
		 
		 Log.info("selected crop to upload trailer");
		 
		 Log.info("refreshing the page");
		 
		 driver.navigate().refresh();
		 
		 Log.info("page gets refreshed");
		 
		 Log.endTestCase("TC_002	Full film using browser and trailer using crop	2 min");
		 
     }
		 
	
	 public static void  testUpload_Full_Film_Using_Browser_and_Trailer_Using_Cloud (WebDriver driver) throws Exception
	 
	 {
	 
	 Log.startTestCase("TC_003_1 Full film using browser and trailer using drop box");
	 
	    FilmCreate_Page.button_UploadFullFilm(driver).click();
	    Log.info("Clicked on upload full film");
	    
	    element = (new WebDriverWait(driver, 10))
				   .until(ExpectedConditions.elementToBeClickable( Container_SelectUploadType.browserUpload_link(driver)));
		
        Container_SelectUploadType.browserUpload_link(driver).click();
        Log.info("Pop up opens, clicked on browser upload link");
        
        element = (new WebDriverWait(driver, 10))
				   .until(ExpectedConditions.elementToBeClickable(Container_SelectUploadType.browserUpload_Button(driver)));
        
        
        Container_SelectUploadType.browserUpload_Button(driver).click();
		
		BrowserUpload_action.browserUploadTrailer(driver);
		
		FilmCreate_Page.button_createTrailer(driver).click();
		Log.info("clicked on trailer upload button");
		
		CloudUpload_action.dropBox_Upload_action(driver);
		
		element = (new WebDriverWait(driver, 10))
				   .until(ExpectedConditions.elementToBeClickable(FilmCreate_Page.text_on_createdTrailer(driver)));
	    
	    driver.navigate().refresh();
	    
	    Log.info("Page gets refreshed");
	    
	    Log.endTestCase("TC_003_1 Full film using browser and trailer using cloud Using drop box");
	    
	    //TC_003_2 Full film using browser and trailer using S3
		
	    Log.startTestCase("TC_003_2 Full film using browser and trailer using S3");

	    FilmCreate_Page.button_UploadFullFilm(driver).click();
	    Log.info("Clicked on upload full film");
	    
	    element = (new WebDriverWait(driver, 10))
				   .until(ExpectedConditions.elementToBeClickable( Container_SelectUploadType.browserUpload_link(driver)));
		
        Container_SelectUploadType.browserUpload_link(driver).click();
        Log.info("Pop up opens, clicked on browser upload link");
        
        element = (new WebDriverWait(driver, 10))
				   .until(ExpectedConditions.elementToBeClickable(Container_SelectUploadType.browserUpload_Button(driver)));

        Container_SelectUploadType.browserUpload_Button(driver).click();
		
		BrowserUpload_action.browserUploadTrailer(driver);
		
		FilmCreate_Page.button_createTrailer(driver).click();
		
		Log.info("Clicked to upload trailer");

        CloudUpload_action.s3_Upload_action(driver);
		
		element = (new WebDriverWait(driver, 10))
				   .until(ExpectedConditions.elementToBeClickable(FilmCreate_Page.text_on_createdTrailer(driver)));
	    
	    driver.navigate().refresh();
	
    	 Log.info("page gets refreshed");
		 
		 Log.endTestCase("TC_003_2 Full film using browser and trailer using S3");
	    
	    //TC_003_3 Full film using browser and trailer using gdrive
		 
		 Log.startTestCase("TC_003_3 Full film using browser and trailer using gdrive");
	    
		 FilmCreate_Page.button_UploadFullFilm(driver).click();
		    Log.info("Clicked on upload full film");
		    
		    element = (new WebDriverWait(driver, 10))
					   .until(ExpectedConditions.elementToBeClickable( Container_SelectUploadType.browserUpload_link(driver)));
			
	        Container_SelectUploadType.browserUpload_link(driver).click();
	        Log.info("Pop up opens, clicked on browser upload link");
	        
	        element = (new WebDriverWait(driver, 10))
					   .until(ExpectedConditions.elementToBeClickable(Container_SelectUploadType.browserUpload_Button(driver)));

	        Container_SelectUploadType.browserUpload_Button(driver).click();
		
		BrowserUpload_action.browserUploadTrailer(driver);
		
		FilmCreate_Page.button_createTrailer(driver).click();
		
		Log.info("Clicked on upload trailer button");


        CloudUpload_action.gdriver_Upload_action(driver);
		
		element = (new WebDriverWait(driver, 10))
				   .until(ExpectedConditions.elementToBeClickable(FilmCreate_Page.text_on_createdTrailer(driver)));
	
	    driver.navigate().refresh(); 
	    
	    Log.endTestCase("TC_003_3 Full film using browser and trailer using gdrive");
	    
	    
	  //TC_003_4 Full film using browser and trailer using sugersync
	    
	    Log.startTestCase("TC_003_4 Full film using browser and trailer using sugersync");
	    
	    FilmCreate_Page.button_UploadFullFilm(driver).click();
	    Log.info("Clicked on upload full film");
	    
	    element = (new WebDriverWait(driver, 10))
				   .until(ExpectedConditions.elementToBeClickable( Container_SelectUploadType.browserUpload_link(driver)));
		
        Container_SelectUploadType.browserUpload_link(driver).click();
        Log.info("Pop up opens, clicked on browser upload link");
        
        element = (new WebDriverWait(driver, 10))
				   .until(ExpectedConditions.elementToBeClickable(Container_SelectUploadType.browserUpload_Button(driver)));

        Container_SelectUploadType.browserUpload_Button(driver).click();
		
		BrowserUpload_action.browserUploadTrailer(driver);
		
		FilmCreate_Page.button_createTrailer(driver).click();
		
		Log.info("Clicked on upload trailer button");

		 CloudUpload_action.sugerSync_Upload_action(driver);
		 
		 element = (new WebDriverWait(driver, 10))
				   .until(ExpectedConditions.elementToBeClickable(FilmCreate_Page.text_on_createdTrailer(driver)));
	
	    driver.navigate().refresh();  
	    
	    Log.endTestCase("TC_003_4 Full film using browser and trailer using sugersync");
	    
      //TC_003_5 Full film using browser and trailer using onedrive
	    
	    Log.startTestCase("TC_003_5 Full film using browser and trailer using onedrive");
	    
	    FilmCreate_Page.button_UploadFullFilm(driver).click();
	    Log.info("Clicked on upload full film");
	    
	    element = (new WebDriverWait(driver, 10))
				   .until(ExpectedConditions.elementToBeClickable( Container_SelectUploadType.browserUpload_link(driver)));
		
        Container_SelectUploadType.browserUpload_link(driver).click();
        Log.info("Pop up opens, clicked on browser upload link");
        
        element = (new WebDriverWait(driver, 10))
				   .until(ExpectedConditions.elementToBeClickable(Container_SelectUploadType.browserUpload_Button(driver)));

        Container_SelectUploadType.browserUpload_Button(driver).click();
		
		BrowserUpload_action.browserUploadTrailer(driver);
		
		FilmCreate_Page.button_createTrailer(driver).click();
		
		Log.info("Clicked on upload trailer button");

         CloudUpload_action.oneDriver_Upload_action(driver);
		 
		 element = (new WebDriverWait(driver, 10))
				   .until(ExpectedConditions.elementToBeClickable(FilmCreate_Page.text_on_createdTrailer(driver)));
	
	    driver.navigate().refresh();
	    
	    Log.endTestCase("TC_003_5 Full film using browser and trailer using onedrive");
	    
	    
	 }
	
	
	
	

	

}
