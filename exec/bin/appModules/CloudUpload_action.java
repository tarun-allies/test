package appModules;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import pageObject.API_Window_Page;
import pageObject.ContainerCloudUpload;
import pageObject.Container_SelectUploadType;
import pageObject.FilmCreate_Page;
import Utility.Constant;
import Utility.Excel;

public class CloudUpload_action {


    	private	static String email;
    	private	static String password;
    	private	static String fullname;
    	private	static String month;
    	private	static String day;
    	private	static String year;
    	  
    	  
    	  
    	  private static WebElement element;
    	  
    	  static Pattern img = new Pattern(Constant.Path_TestData+Constant.Img_TestDataUploads+"gdrive_accept.png");
    	  
    	  public CloudUpload_action(String email, String password, WebElement element){
    		  
    		  this.email = email;
    		  this.password = password;
    		  this.element = element;
    	  }
	

	
	   public static void Execute(WebDriver driver) throws Exception
	   
	   {
		
		   uploadUsingCrop(driver);
		   
		   dropBox_Upload_action(driver);
		   associated_dropbox(driver);
		  
		   s3_Upload_action(driver);
		   associated_S3(driver);
		   
		   gdriver_Upload_action(driver);
		   associated_gdrive(driver);
		   
		   
		   sugerSync_Upload_action(driver);
		   associated_sugerSync(driver);
		   
		   oneDriver_Upload_action(driver);
		   associated_oneDrive(driver);
		   
	  }   
	   
      
	   
               public static void dropBox_Upload_action(WebDriver driver) throws Exception
               
               {
            	 
                String Parent_window = driver.getWindowHandle();
         		
         		Container_SelectUploadType.dropBox_link(driver).click();
         		
         		for(String WinHandle : driver.getWindowHandles())
         		{
         			driver.switchTo().window(WinHandle);
         		}
         		
         		Excel.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"Credentials");
         		
         		email = Excel.getCellData(3, 1);
         		password = Excel.getCellData(3, 2);
         		
         		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
         		
         		API_Window_Page.email_dropbox(driver).clear();
         		API_Window_Page.email_dropbox(driver).sendKeys(email);
         		API_Window_Page.password_dropbox(driver).sendKeys(password);;
         		
         		API_Window_Page.submit_dropbox(driver).click();
         		
         		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
         		
         		API_Window_Page.allow_dropbox(driver).click();
         		
         		driver.switchTo().window(Parent_window);
         		
         		 element = (new WebDriverWait(driver, 10))
         				   .until(ExpectedConditions.elementToBeClickable(ContainerCloudUpload.filmContainer_dropbox(driver)));
         		
         		 element = (new WebDriverWait(driver, 10))
         				   .until(ExpectedConditions.elementToBeClickable( ContainerCloudUpload.film_dropbox(driver)));
         		 
         		ContainerCloudUpload.film_dropbox(driver).click();
         		 
         		ContainerCloudUpload.Select_Button_DropBox(driver).click();
         		
         		element = (new WebDriverWait(driver, 10))
      				   .until(ExpectedConditions.elementToBeClickable( FilmCreate_Page.Text_On_createdFullFilm(driver)));
         		 
         		 
         		 
         		  }
             
             
             public static void associated_dropbox(WebDriver driver) throws Exception
             
             {
            	 
            	 String Parent_window = driver.getWindowHandle();
            	 
            	 Container_SelectUploadType.dropBox_link(driver).click();
            	  
            	   for(String WinHandle : driver.getWindowHandles())
            		   {
            		  
            		   driver.switchTo().window(WinHandle);
            		   
            		   }
                		   
           		        driver.switchTo().window(Parent_window);
           		        
           			   element = (new WebDriverWait(driver, 10))
         				   .until(ExpectedConditions.elementToBeClickable(ContainerCloudUpload.filmContainer_dropbox(driver)));
            	
           
   		          ContainerCloudUpload.film_dropbox(driver).click();
   		 
   		         ContainerCloudUpload.Select_Button_DropBox(driver).click();
   		         
            		   
   		        	 
            	 
             }
             
             public static void uploadUsingCrop(WebDriver driver) throws Exception
             {
            	 
            	 element = (new WebDriverWait(driver, 10))
         				   .until(ExpectedConditions.elementToBeClickable(FilmCreate_Page.textbox_cropChekout(driver)));
            	 
            	 FilmCreate_Page.textbox_cropChekout(driver).click();
            	 
              }
             
             
             public static void s3_Upload_action(WebDriver driver) throws Exception{
            	 
            	 String Parent_window1 = driver.getWindowHandle();
        		 
        		 Container_SelectUploadType.S3_link(driver).click();
        		 
        		 for (String WinHandles1 : driver.getWindowHandles())
        		 {
        		      driver.switchTo().window(WinHandles1);
        	     }
        	
        		 Excel.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"Credentials");
        		 
        		 String accessKey = Excel.getCellData(4, 1);
        		 String secretKey = Excel.getCellData(4, 2);
        		 String bucketName = Excel.getCellData(4, 3);
        		 
        		 API_Window_Page.access_S3(driver).sendKeys(accessKey);
        		 API_Window_Page.secretKey_S3(driver).sendKeys(secretKey);
        		 API_Window_Page.Bucket_S3(driver).sendKeys(bucketName);
        		 
        		 API_Window_Page.submit_S3(driver).click();
        		 
        		 driver.switchTo().window(Parent_window1);
        		 
        		  element = (new WebDriverWait(driver, 10))
        		 		   .until(ExpectedConditions.elementToBeClickable(ContainerCloudUpload.filmContainer_S3(driver)));
        		  
        		  element = (new WebDriverWait(driver, 10))
        				   .until(ExpectedConditions.elementToBeClickable(ContainerCloudUpload.film_S3(driver)));
        		 
        		 ContainerCloudUpload.film_S3(driver).click();
        		 
        		 ContainerCloudUpload.Select_Button_S3(driver).click();
             }
             
             public static void associated_S3(WebDriver driver) throws Exception
             
             {
            	 
            	 String Parent_window1 = driver.getWindowHandle();
            	 
            	 Container_SelectUploadType.S3_link(driver).click();
            	 
            	 for (String WinHandles1 : driver.getWindowHandles())
        		 {
        		      driver.switchTo().window(WinHandles1);
        	     }
            	 
            	 
            	 driver.switchTo().window(Parent_window1);
            	 
        		 
       	          element = (new WebDriverWait(driver, 50))
       				   .until(ExpectedConditions.elementToBeClickable(ContainerCloudUpload.filmContainer_S3(driver)));
       	      
       	          element = (new WebDriverWait(driver, 10))
       				   .until(ExpectedConditions.elementToBeClickable(ContainerCloudUpload.film_S3(driver)));
       		 
       		      ContainerCloudUpload.film_S3(driver).click();
       		 
       		      ContainerCloudUpload.Select_Button_S3(driver).click();  
       		 
                
            	 
            	   }
             
             public static void gdriver_Upload_action(WebDriver driver) throws Exception {
            	 
            	 String Parent_window2 = driver.getWindowHandle();
    			 
    			 Container_SelectUploadType.gDrive_link(driver).click();
    			 
    			 for(String WinHandles2 : driver.getWindowHandles())
    			 {
    				 driver.switchTo().window(WinHandles2);
    			 }
    			 
    			 Excel.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"Credentials");
    			 
    		          email = Excel.getCellData(5, 1);
    		          password = Excel.getCellData(5, 2);
    		
    			 API_Window_Page.email_gDrive(driver).sendKeys(email);
    			 API_Window_Page.password_gDrive(driver).sendKeys(password);
    			 
    			 API_Window_Page.submit_gDrive(driver).click();
    			 
    			
    			 
    		      Screen s = new Screen();
    		      s.wait(img ,100);
    		      s.click(img);

    			 
    			 driver.switchTo().window(Parent_window2);
    			 
    		     element = (new WebDriverWait(driver, 50))
    					   .until(ExpectedConditions.elementToBeClickable(ContainerCloudUpload.filmContainer_gDrive(driver)));
    			 
                    element = (new WebDriverWait(driver, 50))
    					   .until(ExpectedConditions.elementToBeClickable(ContainerCloudUpload.film_gDrive(driver)));


    			 ContainerCloudUpload.film_gDrive(driver).click();
    			 
    			 ContainerCloudUpload.Select_Button_gDrive(driver).click();
    			 
             }
             
             public static void associated_gdrive(WebDriver driver) throws Exception 
             
             {
                  String Parent_window2 = driver.getWindowHandle();
    			 
                  Container_SelectUploadType.gDrive_link(driver).click();
    			 
    			 for(String WinHandles2 : driver.getWindowHandles())
    			 {
    				 driver.switchTo().window(WinHandles2);
    			 }
            	 
    			 driver.switchTo().window(Parent_window2);
    			 
    			 element = (new WebDriverWait(driver, 10))
    					   .until(ExpectedConditions.elementToBeClickable(ContainerCloudUpload.filmContainer_gDrive(driver)));
    			 
    			 ContainerCloudUpload.film_gDrive(driver).click();
    			 
    			 ContainerCloudUpload.Select_Button_gDrive(driver).click(); 
    			 
    	         
    	         
             }
             
             
             public static void sugerSync_Upload_action(WebDriver driver) throws Exception
            
             {
            	 String Parent_window3 = driver.getWindowHandle();
    			 
   			  Container_SelectUploadType.sugerSync_link(driver).click();
   			 
   			  for(String WinHandles2 : driver.getWindowHandles())
   			  {
   				 driver.switchTo().window(WinHandles2);
   			  }
   			 
   			  Excel.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"Credentials");
   			 
   			  email = Excel.getCellData(6, 1);
   			  password =  Excel.getCellData(6, 2);
   		
   			 API_Window_Page.email_sugerSync(driver).sendKeys(email);
   			 API_Window_Page.password_sugerSync(driver).sendKeys(password);
   			 
   			 API_Window_Page.submit_sugerSync(driver).click();
   			 
   			 driver.switchTo().window(Parent_window3);
   			 
   			 element = (new WebDriverWait(driver, 10))
   					   .until(ExpectedConditions.elementToBeClickable(ContainerCloudUpload.filmContainer_sugerSync(driver)));
   			 
   			 element = (new WebDriverWait(driver, 10))
   					   .until(ExpectedConditions.elementToBeClickable(ContainerCloudUpload.form_sugerSync(driver)));
   			 
   			 ContainerCloudUpload.form_sugerSync(driver).click();
   			 
   			 element = (new WebDriverWait(driver, 10))
   					   .until(ExpectedConditions.elementToBeClickable(ContainerCloudUpload.film_sugerSync(driver)));
   			 
   			 ContainerCloudUpload.film_sugerSync(driver).click();
   			 
   			 ContainerCloudUpload.Select_Button_sugerSync(driver).click();
            	 
            	 
            	 
             }
             
             public static void associated_sugerSync(WebDriver driver) throws Exception
             
             {
            	 String Parent_window2 = driver.getWindowHandle();
    			 
            	 Container_SelectUploadType.sugerSync_link(driver).click();
   			 
   			 for(String WinHandles2 : driver.getWindowHandles())
   			 {
   				 driver.switchTo().window(WinHandles2);
   			 }
           	 
   			 driver.switchTo().window(Parent_window2);
   			 
   			element = (new WebDriverWait(driver, 10))
					   .until(ExpectedConditions.elementToBeClickable(ContainerCloudUpload.filmContainer_sugerSync(driver)));
            	 
            	 
            	 element = (new WebDriverWait(driver, 10)
    					   .until(ExpectedConditions.elementToBeClickable(ContainerCloudUpload.form_sugerSync(driver))));
    			 
    			 ContainerCloudUpload.form_sugerSync(driver).click();
    			 
    			 element = (new WebDriverWait(driver, 10))
    					   .until(ExpectedConditions.elementToBeClickable(ContainerCloudUpload.film_sugerSync(driver)));
    			 
    			 ContainerCloudUpload.film_sugerSync(driver).click();
    			 
    			 ContainerCloudUpload.Select_Button_sugerSync(driver).click();  
    			 
    			
            	 
            	 
             }
             
             public static void oneDriver_Upload_action(WebDriver driver) throws Exception 
             
             {
            	 
            	 String Parent_window4 = driver.getWindowHandle();
   			  
   			    Container_SelectUploadType.oneDrive_link(driver).click();
   			 
   			     for(String WinHandles2 : driver.getWindowHandles())
   			     {
   				 driver.switchTo().window(WinHandles2);
   			     }
   			 
   			  Excel.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"Credentials");
   			 
   			  email = Excel.getCellData(7, 1);
   			  password =  Excel.getCellData(7, 2);
   		
   			 API_Window_Page.email_oneDrive(driver).sendKeys(email);
   			 API_Window_Page.password_oneDrive(driver).sendKeys(password);
   			 
   			 API_Window_Page.submit_oneDrive(driver).click();
   			 
   			 driver.switchTo().window(Parent_window4);
   			 
   			 element = (new WebDriverWait(driver, 10))
   					   .until(ExpectedConditions.elementToBeClickable(ContainerCloudUpload.filmContainer_oneDrive(driver)));
   			 
   			 element = (new WebDriverWait(driver, 10))
   					   .until(ExpectedConditions.elementToBeClickable(ContainerCloudUpload.film_oneDrive(driver)));
   			 
   			 
   			 ContainerCloudUpload.film_oneDrive(driver).click();
   			 
   			 ContainerCloudUpload.Submit_Button_oneOrive(driver).click();
             }
             
             
             public static void associated_oneDrive(WebDriver driver) throws Exception 
            
             {
            	 
            
                 Container_SelectUploadType.oneDrive_link(driver).click();
   		
           	       element = (new WebDriverWait(driver, 10))
    					   .until(ExpectedConditions.elementToBeClickable(ContainerCloudUpload.filmContainer_oneDrive(driver)));
    		     

    			 
    			 
    			 ContainerCloudUpload.film_oneDrive(driver).click();
    			 
    			 ContainerCloudUpload.Submit_Button_oneOrive(driver).click(); 
            	 
             }
             
          
            	

      }
