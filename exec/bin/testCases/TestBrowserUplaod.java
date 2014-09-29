package testCases;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import pageObject.ContainerCloudUpload;
import pageObject.Container_SelectUploadType;
import pageObject.FilmCreate_Page;
import pageObject.MyFilm_Page;
import pageObject.Page_Header;
import pageObject.SignUp_Step1_Page;
import appModules.BrowserUpload_action;
import appModules.SignUp_action;
import Utility.Constant;
import Utility.Excel;
import Utility.Log;

public class TestBrowserUplaod {


	private static String email;
	private static String password;
	
	static Pattern img1 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataUploads+"movie.png");
	static Pattern img2 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataUploads+"film_link.png");
	static Pattern img3 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataUploads+"upload-popup.png");
	static Pattern img4 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataUploads+"desktop_open.png");
	static Pattern img5 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataUploads+"popup-button.png");
	
	static Screen s = new Screen();
	
	public TestBrowserUplaod(String email, String password) {
		
		this.email = email;
		this.password = password;
	}
	
	
	
	public static void Execute(WebDriver driver) throws Exception
	{
		
		Excel.setExcelFile(Constant.Path_TestData+Constant.File_TestData, "TestingData");
		
		
		
		   email =  Excel.getCellData(1, 1);
		   password  =  Excel.getCellData(1, 2);
		   String fullname = "Test User";
		   String month = "Jan";
		   String day = "12";
		   String year = "1990";
		   
		   
		    driver.get(Constant.URL+"/index.php/signup");
			
		    SignUp_action.Execute(driver);
			
			SignUp_Step1_Page.SubmitButton(driver).click();
			
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
		
		Container_SelectUploadType.browserUpload_link(driver).click();
		Log.info("Pop up opens, clicked on browser upload link");
		
		Container_SelectUploadType.browserUpload_Button(driver).click();
		Log.info("clicked on browser upload button to open desktop window");
		
		
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
		
		Container_SelectUploadType.browserUpload_link(driver).click();
        Log.info("Pop up opens, clicked on browser upload link");
     
		Container_SelectUploadType.browserUpload_Button(driver).click();
		
		Log.info("clicked on browser upload button to open desktop window");
		
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
	 
	 Log.startTestCase("TC_003_1 Full film using browser and trailer using cloud Using drop box");
	 
	    FilmCreate_Page.button_createTrailer(driver).click();
	    Log.info("Clicked on upload full film");
		
        Container_SelectUploadType.browserUpload_link(driver).click();
        Log.info("Pop up opens, clicked on browser upload link");
		
		Container_SelectUploadType.browserUpload_Button(driver).click();
		Log.info("clicked on browser upload button to open desktop window");
		
		BrowserUpload_action.browserUploadTrailer(driver);
		
		FilmCreate_Page.button_createTrailer(driver).click();
		Log.info("clicked on trailer upload button");

	    ContainerCloudUpload.film_dropbox(driver);
	    
	    Log.info("Film uploaded, refreshing the page");
	    
	    driver.navigate().refresh();
	    
	    Log.info("Page gets refreshed");
	    
	    Log.endTestCase("TC_003_1 Full film using browser and trailer using cloud Using drop box");
	    
	    //TC_003_2 Full film using browser and trailer using S3
		
	    Log.startTestCase("TC_003_2 Full film using browser and trailer using S3");

	    FilmCreate_Page.button_UploadFullFilm(driver).click();
	    
	    Log.info("Clicked on upload full film button");
		
        Container_SelectUploadType.browserUpload_link(driver).click();
        
        Log.info("popup appears, clicked on browser upload link");
		
		Container_SelectUploadType.browserUpload_Button(driver).click();
		
		Log.info("Clicked on upload button");
		
		BrowserUpload_action.browserUploadTrailer(driver);
		
		FilmCreate_Page.button_createTrailer(driver).click();
		
		Log.info("Clicked to upload trailer");

	    ContainerCloudUpload.film_S3(driver);
	
	    
	    driver.navigate().refresh();
		 
		 Log.info("page gets refreshed");
		 
		 Log.endTestCase("TC_003_2 Full film using browser and trailer using S3");
	    
	    //TC_003_3 Full film using browser and trailer using gdrive
		 
		 Log.startTestCase("TC_003_3 Full film using browser and trailer using gdrive");
	    
         FilmCreate_Page.button_UploadFullFilm(driver).click();
         
         Log.info("Clicked on upload full film button");
		
        Container_SelectUploadType.browserUpload_link(driver).click();
        
        Log.info("Clicked on browser upload link");
		
		Container_SelectUploadType.browserUpload_Button(driver).click();
		
		Log.info("Clicked on upload button");
		
		BrowserUpload_action.browserUploadTrailer(driver);
		
		FilmCreate_Page.button_createTrailer(driver).click();
		
		Log.info("Clicked on upload trailer button");

	   ContainerCloudUpload.film_gDrive(driver);
	
	    driver.navigate().refresh(); 
	    
	    Log.endTestCase("TC_003_3 Full film using browser and trailer using gdrive");
	    
	    
	  //TC_003_4 Full film using browser and trailer using sugersync
	    
	    Log.startTestCase("TC_003_4 Full film using browser and trailer using sugersync");
	    
        FilmCreate_Page.button_UploadFullFilm(driver).click();
        
        Log.info("Clicked on upload full film button");
		
        Container_SelectUploadType.browserUpload_link(driver).click();
        
        Log.info("Clicked on browser upload link");
		
		Container_SelectUploadType.browserUpload_Button(driver).click();
		
		Log.info("Clicked on upload button");
		
		BrowserUpload_action.browserUploadTrailer(driver);
		
		FilmCreate_Page.button_createTrailer(driver).click();
		
		Log.info("Clicked on upload trailer button");

		ContainerCloudUpload.film_sugerSync(driver);
	
	    driver.navigate().refresh();  
	    
	    Log.endTestCase("TC_003_4 Full film using browser and trailer using sugersync");
	    
      //TC_003_5 Full film using browser and trailer using onedrive
	    
	    Log.startTestCase("TC_003_5 Full film using browser and trailer using onedrive");
	    
        FilmCreate_Page.button_UploadFullFilm(driver).click();
        
        Log.info("Clicked on upload full film button");
		
        Container_SelectUploadType.browserUpload_link(driver).click();
        
        Log.info("Clicked on browser upload link");
		
		Container_SelectUploadType.browserUpload_Button(driver).click();
		
		Log.info("Clicked on upload button");
		
		BrowserUpload_action.browserUploadTrailer(driver);
		
		FilmCreate_Page.button_createTrailer(driver).click();
		
		Log.info("Clicked on upload trailer button");

		ContainerCloudUpload.film_oneDrive(driver);
	
	    driver.navigate().refresh();
	    
	    Log.endTestCase("TC_003_5 Full film using browser and trailer using onedrive");
	    
	    
	 }
	
	
	
	

	

}
