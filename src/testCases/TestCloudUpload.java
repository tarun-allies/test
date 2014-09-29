package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Pattern;

import appModules.CloudUpload_action;
import appModules.SignUp_action;
import pageObject.Container_SelectUploadType;
import pageObject.FilmCreate_Page;
import pageObject.MyFilm_Page;
import pageObject.Page_Header;
import pageObject.SignUp_Page;
import pageObject.SignUp_Step1_Page;
import AutomationFramework.GenerateTestData;
import Utility.Constant;
import Utility.Excel;
import Utility.Log;

public class TestCloudUpload {


    	  
    
    
    	private static WebDriver driver;
    	  
    	  
    	  private static WebElement element;
    	  
    	  static Pattern img = new Pattern(Constant.Path_TestData+Constant.Img_TestDataUploads+"gdrive_accept.png");
    	  
 
	   public static void Execute(WebDriver driver) throws Exception
	   
	   {
		   
		   /*SignUp to IR*/
		  
		   SignUp_action.Execute(driver);
		 
		   SignUp_Step1_Page.SubmitButton(driver).click();
		   
		  element = (new WebDriverWait(driver, 10))
				   .until(ExpectedConditions.elementToBeClickable(Page_Header.munuLink(driver)));
		  
		  Page_Header.munuLink(driver).click();
		  
		  Page_Header.MyFilm_link(driver).click();

	     MyFilm_Page.uploadNewFilm_button(driver).click();
	     
	     testUpload_using_dropBox(driver);
	     testUpload_using_S3(driver);
	     testUpload_using_gDrive(driver);
	     testUpload_using_sugerSync(driver);
	     testUpload_using_oneDrive(driver);
	     testUpload_crossUpload(driver);
	     
	   }
		
	
		
		
		
	   
	   public static void  testUpload_using_dropBox(WebDriver driver) throws Exception
	   {
		   
	   
		
	      	testUpload_fullFilm_trailer_using_dropbox(driver);
	      	testUpload_fullFilm_dropbbox_trailer_using_crop(driver);
	      	
	   }
	   
	   
	   public static void  testUpload_using_S3(WebDriver driver) throws Exception
	   {
		   
	      	testUpload_fullFilm_trailer_using_S3(driver);
	      	testUpload_fullFilm_S3_trailer_using_crop(driver);
	      	
	   }
	   
	   public static void testUpload_using_gDrive(WebDriver driver) throws Exception
	   {
		   
	   
		
	      	testUpload_fullFilm_trailer_using_gDrive(driver);
	      	testUpload_fullFilm_gDrive_trailer_using_crop(driver);
	      	
	   }
	   
	   public static void testUpload_using_sugerSync(WebDriver driver) throws Exception
	   {
		   
	   
		
	      	testUpload_fullFilm_trailer_using_sugerSync(driver);
	      	testUpload_fullFilm_SugerSync_trailer_using_crop(driver);
	      	
	   }
	   
	   public static void testUpload_using_oneDrive(WebDriver driver) throws Exception
	   {
		   
	   
		
	      	testUpload_fullFilm_trailer_using_oneDrive(driver);
	      	testUpload_fullFilm_oneDrive_trailer_using_crop(driver);
	      	
	   }
	   
	   public static void testUpload_crossUpload(WebDriver driver) throws Exception
	   {
		   
	   
		
		   crossUpload_Dropbox_S3(driver);
		   crossUpload_Dropbox_SugerSync(driver);
		   crossUpload_Dropbox_OneDrive(driver);
		   crossUpload_S3_GDrive(driver);
		   crossUpload_S3_SugerSync(driver);
		   CrossUpload_s3_onedrive(driver);
		   CrossUpload_onedrive_sugerSync(driver);
		   CrossUpload_Gdrive_OneDrive(driver);
		   
		   Page_Header.munuLink(driver).click();
		   Log.info("menu link appears");

		   Page_Header.signoutButton(driver).click();
	      	
	   }
	   
	   
	   public static void testUpload_fullFilm_trailer_using_dropbox(WebDriver driver) throws Exception
	   {
		
		          FilmCreate_Page.button_UploadFullFilm(driver).click();
		
		          CloudUpload_action.dropBox_Upload_action(driver);                   // Upload full film
		          
		  		element = (new WebDriverWait(driver, 10))
	      				   .until(ExpectedConditions.elementToBeClickable( FilmCreate_Page.Text_On_createdFullFilm(driver)));
		
		          FilmCreate_Page.button_createTrailer(driver).click();         //  Upload trailer
                                
		          CloudUpload_action.associated_dropbox(driver);
		 
		          element = (new WebDriverWait(driver, 10))
				   .until(ExpectedConditions.elementToBeClickable(FilmCreate_Page.text_on_createdTrailer(driver)));
		   
		          element =  FilmCreate_Page.textbox_setting_Form(driver);
		  
	              Excel.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"FilmUploads_Cloud");
			 
	             if(FilmCreate_Page.Text_On_createdFullFilm(driver).getText().equals(Excel.getCellData(1, 3))
					   && ( element != null))
				
	                {
				    
	    	           Excel.setCellData("Pass", 1,6 );
			        }
			   
	             else
			   
	                {
				
	                  Excel.setCellData("Fail", 1, 6 );
				    }
	             
	             driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 
		          driver.navigate().refresh();   
		          
	   }
	   
	   public static void testUpload_fullFilm_dropbbox_trailer_using_crop(WebDriver driver) throws Exception
	   
	   {
		 
		 

		 
		             FilmCreate_Page.button_UploadFullFilm(driver).click();
		  
		              CloudUpload_action.associated_dropbox(driver);                // Full film
		  
		              element = (new WebDriverWait(driver, 10))
		       				   .until(ExpectedConditions.elementToBeClickable(FilmCreate_Page.Text_On_createdFullFilm(driver)));
		              
		              CloudUpload_action.uploadUsingCrop(driver);
		  
		              element = FilmCreate_Page.textbox_setting_Form(driver);
		  
		              Excel.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"FilmUploads_Cloud");
				 
		               if(FilmCreate_Page.Text_On_createdFullFilm(driver).getText().equals(Excel.getCellData(1, 3))
						   && ( element != null))
					       {
					    
		    	             Excel.setCellData("Pass", 2,6 );
				     
		                  }
				
		               else
				          {
					
		    	              Excel.setCellData("Fail", 2, 6 );
		    	              
				          }
		               
		               driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		    	
		    	      driver.navigate().refresh();  
		    	      
	   }
					 
	public static void testUpload_fullFilm_trailer_using_S3(WebDriver driver)throws Exception
	
	{
  
		    	   
		 
		 
	                  FilmCreate_Page.button_UploadFullFilm(driver).click();
	      
	                   CloudUpload_action.s3_Upload_action(driver);                                    // full film
	                   
	                   element = (new WebDriverWait(driver, 10))
	           				   .until(ExpectedConditions.elementToBeClickable(FilmCreate_Page.Text_On_createdFullFilm(driver)));
	           	
		              FilmCreate_Page.button_createTrailer(driver).click();
		 
		              CloudUpload_action.associated_S3(driver);        // trailer upload
		               
		               element = (new WebDriverWait(driver, 10))
		    				   .until(ExpectedConditions.elementToBeClickable(FilmCreate_Page.text_on_createdTrailer(driver)));
		               
		              
		               element = FilmCreate_Page.textbox_setting_Form(driver);
			  
			           Excel.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"FilmUploads_Cloud");
					 
			           if(FilmCreate_Page.Text_On_createdFullFilm(driver).getText().equals(Excel.getCellData(1, 3))
							   && ( element != null))
						
			              {
						    
			    	         Excel.setCellData("Pass", 3,6 );
					     
			              }
					
			           else
				 	   
			              {
						
		                   Excel.setCellData("Fail", 3, 6 );
			    	
			   	          }
			    
			           driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		   
		                   driver.navigate().refresh();
		                   
	}
		                   
		   
	
	
	public static void 	testUpload_fullFilm_S3_trailer_using_crop(WebDriver driver) throws Exception
	
	{
		      
		          FilmCreate_Page.button_UploadFullFilm(driver).click();
		      
		           CloudUpload_action.associated_S3(driver);
		           
		           element = (new WebDriverWait(driver, 10))
	       				   .until(ExpectedConditions.elementToBeClickable(FilmCreate_Page.Text_On_createdFullFilm(driver)));
		      
		           CloudUpload_action.uploadUsingCrop(driver);      // trailer upload
			  
			       element = FilmCreate_Page.textbox_setting_Form(driver);
			  
			       Excel.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"FilmUploads_Cloud");
					 
			    if(FilmCreate_Page.Text_On_createdFullFilm(driver).getText().equals(Excel.getCellData(1, 3))
							   && ( element != null))
						
			        {
						    
			    	  Excel.setCellData("Pass", 4,6 );
					     
			        }
					
			         else
					   
			       {
						
			    	Excel.setCellData("Fail", 4, 6 );
			    	
			       }
			    
			    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			    	
			    	driver.navigate().refresh(); 
			    	
	}
						 
						
				  
		public static void testUpload_fullFilm_trailer_using_gDrive(WebDriver driver) throws Exception
		
		{
      	
			
  	                FilmCreate_Page.button_UploadFullFilm(driver).click();
  	          
  	                   CloudUpload_action.gdriver_Upload_action(driver);
  	                   
  	                 element = (new WebDriverWait(driver, 10))
  	       				   .until(ExpectedConditions.elementToBeClickable(FilmCreate_Page.Text_On_createdFullFilm(driver)));
			 
			          FilmCreate_Page.button_createTrailer(driver).click();
			 
			          CloudUpload_action.associated_gdrive(driver);
			           
			           element = (new WebDriverWait(driver, 10))
							   .until(ExpectedConditions.elementToBeClickable(FilmCreate_Page.text_on_createdTrailer(driver)));
			 
			           element = FilmCreate_Page.textbox_setting_Form(driver);
				  
				       Excel.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"FilmUploads_Cloud");
						 
				       if(FilmCreate_Page.Text_On_createdFullFilm(driver).getText().equals(Excel.getCellData(1, 3))
								   && ( element != null))
							
				       {
							    
				    	Excel.setCellData("Pass", 3,6 );
						     
				       }
						
				       else
						   
				        {
							
				      	Excel.setCellData("Fail", 3, 6 );
			  
				         }
				       
				       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			 
			           driver.navigate().refresh(); 
			           
		}
			           
			
			      public static void testUpload_fullFilm_gDrive_trailer_using_crop(WebDriver driver) throws Exception
			      
			      {
			 
			 
			          FilmCreate_Page.button_UploadFullFilm(driver).click();
			 
			           CloudUpload_action.associated_gdrive(driver);
			           
			           element = (new WebDriverWait(driver, 10))
		       				   .until(ExpectedConditions.elementToBeClickable(FilmCreate_Page.Text_On_createdFullFilm(driver)));
		      
			           CloudUpload_action.uploadUsingCrop(driver);      // trailer uplaod
			  
			           element = FilmCreate_Page.textbox_setting_Form(driver);
			  
			           Excel.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"FilmUploads_Cloud");
					 
			          if(FilmCreate_Page.Text_On_createdFullFilm(driver).getText().equals(Excel.getCellData(1, 3))
							   && ( element != null))
						
			          {
						    
			    	   Excel.setCellData("Pass", 4,6 );
					     
			          }
					
			          else
					   
			          {
						
			    	  Excel.setCellData("Fail", 4, 6 );
			    	
			    	  }
			          
			          driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			    
			          driver.navigate().refresh();  
			          
			      }
		      

			      
			      public static void testUpload_fullFilm_trailer_using_sugerSync(WebDriver driver) throws Exception
			      
			      {
			    	  
			    	
                    FilmCreate_Page.button_UploadFullFilm(driver).click();
			 
                     CloudUpload_action.sugerSync_Upload_action(driver);
                     
                     element = (new WebDriverWait(driver, 10))
             				   .until(ExpectedConditions.elementToBeClickable(FilmCreate_Page.Text_On_createdFullFilm(driver)));
			 
			        FilmCreate_Page.button_createTrailer(driver).click();
			 
			        CloudUpload_action.associated_sugerSync(driver);
			         
			         element = (new WebDriverWait(driver, 10))
							   .until(ExpectedConditions.elementToBeClickable(FilmCreate_Page.text_on_createdTrailer(driver)));
			  
	                 element = FilmCreate_Page.textbox_setting_Form(driver);
			  
			         Excel.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"FilmUploads_Cloud");
					 
			         if(FilmCreate_Page.Text_On_createdFullFilm(driver).getText().equals(Excel.getCellData(1, 3))
							   && ( element != null))
						
			         {
						    
			    	Excel.setCellData("Pass", 5,6 );
					     
			         }
					
			          else
					   
			        {
						
			    	Excel.setCellData("Fail", 5, 6 );
			    	
			        }
			         
			         driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			 
			        driver.navigate().refresh(); 
			        
			      }
			        
			        
			        
			    	public static void testUpload_fullFilm_SugerSync_trailer_using_crop(WebDriver driver) throws Exception
			    	
			    	{
			        
			  
			  
			       FilmCreate_Page.button_UploadFullFilm(driver).click();
			  
			        CloudUpload_action.associated_sugerSync(driver);
			        
			        element = (new WebDriverWait(driver, 10))
		       				   .until(ExpectedConditions.elementToBeClickable(FilmCreate_Page.Text_On_createdFullFilm(driver)));
			  
			        CloudUpload_action.uploadUsingCrop(driver);      // trailer uplaod
			  
			        element = FilmCreate_Page.textbox_setting_Form(driver);
			  
			        Excel.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"FilmUploads_Cloud");
					 
			        if(FilmCreate_Page.Text_On_createdFullFilm(driver).getText().equals(Excel.getCellData(1, 3))
							   && ( element != null))
						
			         {
						    
			    	  Excel.setCellData("Pass", 6,6 );
					     
			         }
					
			         else
					   
			          {
						
			    	  Excel.setCellData("Fail", 6, 6 );
			    	
			    	   }
			        
			        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			    
			         driver.navigate().refresh();
			         
			    	}
			  
			  
			  
			  public static void testUpload_fullFilm_trailer_using_oneDrive(WebDriver driver) throws Exception
			  
			  {
		      	
			 
			 
			     FilmCreate_Page.button_UploadFullFilm(driver).click();
			  
			      CloudUpload_action.oneDriver_Upload_action(driver);;
			      
			      element = (new WebDriverWait(driver, 10))
	       				   .until(ExpectedConditions.elementToBeClickable(FilmCreate_Page.Text_On_createdFullFilm(driver)));
			  
			     FilmCreate_Page.button_createTrailer(driver).click();
			  
			     CloudUpload_action.associated_oneDrive(driver);
			      
			      element = (new WebDriverWait(driver, 10))
						   .until(ExpectedConditions.elementToBeClickable(FilmCreate_Page.text_on_createdTrailer(driver)));
			  
                  element = FilmCreate_Page.textbox_setting_Form(driver);
			  
			      Excel.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"FilmUploads_Cloud");
					 
			     if(FilmCreate_Page.Text_On_createdFullFilm(driver).getText().equals(Excel.getCellData(1, 3))
							   && ( element != null))
						
			      {
						    
			    	Excel.setCellData("Pass", 7,6 );
					     
			      }
					
			      else
					   
			      {
						
			    	Excel.setCellData("Fail", 7, 6 );
			    	
			      }
			     
			     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			 
			        driver.navigate().refresh();
			        
			        
			  }
			        
			   public static void testUpload_fullFilm_oneDrive_trailer_using_crop(WebDriver driver) throws Exception
			   
			   {
			  
			       FilmCreate_Page.button_UploadFullFilm(driver).click();
			
			     CloudUpload_action.associated_oneDrive(driver);
			     
			     element = (new WebDriverWait(driver, 10))
	       				   .until(ExpectedConditions.elementToBeClickable(FilmCreate_Page.Text_On_createdFullFilm(driver)));
			  
			     CloudUpload_action.uploadUsingCrop(driver);      // trailer uplaod
			  
			     element = FilmCreate_Page.textbox_setting_Form(driver);
			  
			     Excel.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"FilmUploads_Cloud");
					 
			    if(FilmCreate_Page.Text_On_createdFullFilm(driver).getText().equals(Excel.getCellData(1, 3))
							   && ( element != null))
						
			      {
						    
			    	Excel.setCellData("Pass", 8,6 );
					     
			    }
					
			    else
					   
			    {
						
			    	Excel.setCellData("Fail", 8, 6 );
			    	
			    	 
			    }
			    
			    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			    
			    driver.navigate().refresh(); 
			    
			  }
			    
			    
			    public static void crossUpload_Dropbox_S3(WebDriver driver) throws Exception
			    
			    {
			    
			       FilmCreate_Page.button_UploadFullFilm(driver).click();
			    
			     CloudUpload_action.associated_dropbox(driver);   //  full film drop box
			     
			     element = (new WebDriverWait(driver, 10))
	       				   .until(ExpectedConditions.elementToBeClickable(FilmCreate_Page.Text_On_createdFullFilm(driver)));
			     
			    FilmCreate_Page.button_createTrailer(driver).click();
			     
			    CloudUpload_action.associated_S3(driver);        // trailer s3
			     
			     element = (new WebDriverWait(driver, 10))
						   .until(ExpectedConditions.elementToBeClickable(FilmCreate_Page.text_on_createdTrailer(driver)));
			  
                 element = FilmCreate_Page.textbox_setting_Form(driver);
			  
			      Excel.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"FilmUploads_Cloud");
					 
			     if(FilmCreate_Page.Text_On_createdFullFilm(driver).getText().equals(Excel.getCellData(1, 3))
							   && ( element != null))
						
			      {
						    
			    	Excel.setCellData("Pass", 11,6 );
					     
			      }
					
			      else
					   
			      {
						
			    	Excel.setCellData("Fail", 11, 6 );
			    	
			      }
			     
			     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			 
			        driver.navigate().refresh();
			        
			    }
			        
			        
			    public static void crossUpload_Dropbox_GDrive(WebDriver driver) throws Exception
			    
			    {
			    
			    
				    
				      FilmCreate_Page.button_UploadFullFilm(driver).click();
				    
				       CloudUpload_action.associated_dropbox(driver);   //  full film drop box
				       
				       element = (new WebDriverWait(driver, 10))
		       				   .until(ExpectedConditions.elementToBeClickable(FilmCreate_Page.Text_On_createdFullFilm(driver)));
				       
				      FilmCreate_Page.button_createTrailer(driver).click();
				     
				      CloudUpload_action.associated_gdrive(driver); // gdrive
				     
				     element = (new WebDriverWait(driver, 10))
							   .until(ExpectedConditions.elementToBeClickable(FilmCreate_Page.text_on_createdTrailer(driver)));
				  
	                 element = FilmCreate_Page.textbox_setting_Form(driver);
				  
				      Excel.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"FilmUploads_Cloud");
						 
				     if(FilmCreate_Page.Text_On_createdFullFilm(driver).getText().equals(Excel.getCellData(1, 3))
								   && ( element != null))
							
				      {
							    
				    	Excel.setCellData("Pass", 12,6 );
						     
				      }
						
				      else
						   
				      {
							
				    	Excel.setCellData("Fail", 12, 6 );
				    	
				      }
				     
				     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				 
				        driver.navigate().refresh(); 
				        
			    }
			        
				        public static void crossUpload_Dropbox_SugerSync(WebDriver driver) throws Exception
				        {
					    
	
					    
					      FilmCreate_Page.button_UploadFullFilm(driver).click();
					    
					       CloudUpload_action.associated_dropbox(driver);   //  full film drop box
					       
					       element = (new WebDriverWait(driver, 10))
			       				   .until(ExpectedConditions.elementToBeClickable(FilmCreate_Page.Text_On_createdFullFilm(driver)));
					       
					      FilmCreate_Page.button_createTrailer(driver).click();
					     
					      CloudUpload_action.associated_sugerSync(driver); // sugerSync
					     
					     element = (new WebDriverWait(driver, 10))
								   .until(ExpectedConditions.elementToBeClickable(FilmCreate_Page.text_on_createdTrailer(driver)));
					  
		                 element = FilmCreate_Page.textbox_setting_Form(driver);
					  
					      Excel.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"FilmUploads_Cloud");
							 
					     if(FilmCreate_Page.Text_On_createdFullFilm(driver).getText().equals(Excel.getCellData(1, 3))
									   && ( element != null))
								
					      {
								    
					    	Excel.setCellData("Pass", 13,6 );
							     
					      }
							
					      else
							   
					      {
								
					    	Excel.setCellData("Fail", 13, 6 );
					    	
					      }
					     
					     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					 
					        driver.navigate().refresh();
					        
				        }
					        
					        
				        public static void crossUpload_Dropbox_OneDrive(WebDriver driver) throws Exception
				        {
						    
						      FilmCreate_Page.button_UploadFullFilm(driver).click();
						    
						      CloudUpload_action.associated_dropbox(driver);   //  full film drop box
						       
						       element = (new WebDriverWait(driver, 10))
				       				   .until(ExpectedConditions.elementToBeClickable(FilmCreate_Page.Text_On_createdFullFilm(driver)));
						       
						      FilmCreate_Page.button_createTrailer(driver).click();
						     
						      CloudUpload_action.associated_oneDrive(driver); //  oneDrive
						     
						     element = (new WebDriverWait(driver, 10))
									   .until(ExpectedConditions.elementToBeClickable(FilmCreate_Page.text_on_createdTrailer(driver)));
						  
			                 element = FilmCreate_Page.textbox_setting_Form(driver);
						  
						      Excel.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"FilmUploads_Cloud");
								 
						     if(FilmCreate_Page.Text_On_createdFullFilm(driver).getText().equals(Excel.getCellData(1, 3))
										   && ( element != null))
									
						      {
									    
						    	Excel.setCellData("Pass", 14,6 );
								     
						      }
								
						      else
								   
						      {
									
						    	Excel.setCellData("Fail", 14, 6 );
						    	
						      }
						     
						     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
						 
						        driver.navigate().refresh();
						        
				        }
						        
						        
						        public static void crossUpload_S3_GDrive(WebDriver driver) throws Exception
						     
						        {
							    
						      FilmCreate_Page.button_UploadFullFilm(driver).click();
							    
							       CloudUpload_action.associated_S3(driver); //  full film s3
							       
							       element = (new WebDriverWait(driver, 10))
					       				   .until(ExpectedConditions.elementToBeClickable(FilmCreate_Page.Text_On_createdFullFilm(driver)));
							       
							      FilmCreate_Page.button_createTrailer(driver).click();
							     
							      CloudUpload_action.associated_gdrive(driver);  //  gdrive
							     
							     element = (new WebDriverWait(driver, 10))
										   .until(ExpectedConditions.elementToBeClickable(FilmCreate_Page.text_on_createdTrailer(driver)));
							  
				                 element = FilmCreate_Page.textbox_setting_Form(driver);
							  
							      Excel.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"FilmUploads_Cloud");
									 
							     if(FilmCreate_Page.Text_On_createdFullFilm(driver).getText().equals(Excel.getCellData(1, 3))
											   && ( element != null))
										
							      {
										    
							    	Excel.setCellData("Pass", 15,6 );
									     
							      }
									
							      else
									   
							      {
										
							    	Excel.setCellData("Fail", 15, 6 );
							    	
							      }
							     
							     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
							 
							        driver.navigate().refresh();    
							        
						        }
							        
							        
							    //    testcase006_06_Cross_Upload_s3_sugerSync
							        
							        public static void crossUpload_S3_SugerSync(WebDriver driver) throws Exception
							        
							        {
								    
								      FilmCreate_Page.button_UploadFullFilm(driver).click();
								    
								       CloudUpload_action.associated_S3(driver); //  full film s3
								       
								       element = (new WebDriverWait(driver, 10))
						       				   .until(ExpectedConditions.elementToBeClickable(FilmCreate_Page.Text_On_createdFullFilm(driver)));
								       
								      FilmCreate_Page.button_createTrailer(driver).click();
								     
								      CloudUpload_action.associated_sugerSync(driver);  //  sugerSync
								     
								     element = (new WebDriverWait(driver, 10))
											   .until(ExpectedConditions.elementToBeClickable(FilmCreate_Page.text_on_createdTrailer(driver)));
								  
					                 element = FilmCreate_Page.textbox_setting_Form(driver);
								  
								      Excel.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"FilmUploads_Cloud");
										 
								     if(FilmCreate_Page.Text_On_createdFullFilm(driver).getText().equals(Excel.getCellData(1, 3))
												   && ( element != null))
											
								      {
											    
								    	Excel.setCellData("Pass", 16,6 );
										     
								      }
										
								      else
										   
								      {
											
								    	Excel.setCellData("Fail", 16, 6 );
								    	
								      }
								     
								     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
								 
								        driver.navigate().refresh();
								        
							        }
							        
							        
								        
								        
								        public static void CrossUpload_s3_onedrive(WebDriver driver) throws Exception
								        
								        {
									    
									      FilmCreate_Page.button_UploadFullFilm(driver).click();
									    
									       CloudUpload_action.associated_S3(driver); //  full film s3
									       
									       element = (new WebDriverWait(driver, 10))
							       				   .until(ExpectedConditions.elementToBeClickable(FilmCreate_Page.Text_On_createdFullFilm(driver)));
									       
									      FilmCreate_Page.button_createTrailer(driver).click();
									     
									      CloudUpload_action.associated_oneDrive(driver);  //  oneDrive
									     
									     element = (new WebDriverWait(driver, 10))
												   .until(ExpectedConditions.elementToBeClickable(FilmCreate_Page.text_on_createdTrailer(driver)));
									  
						                 element = FilmCreate_Page.textbox_setting_Form(driver);
									  
									      Excel.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"FilmUploads_Cloud");
											 
									     if(FilmCreate_Page.Text_On_createdFullFilm(driver).getText().equals(Excel.getCellData(1, 3))
													   && ( element != null))
												
									      {
												    
									    	Excel.setCellData("Pass", 17,6 );
											     
									      }
											
									      else
											   
									      {
												
									    	Excel.setCellData("Fail", 17, 6 );
									    	
									      }
									     
									     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
									 
									        driver.navigate().refresh();
									        
								        }
			        
			    
                                               public static void CrossUpload_onedrive_sugerSync(WebDriver driver) throws Exception
								        
								        {
										    
									      FilmCreate_Page.button_UploadFullFilm(driver).click();
										    
										       CloudUpload_action.associated_gdrive(driver); //  full film gdrive
										       
										       element = (new WebDriverWait(driver, 10))
								       				   .until(ExpectedConditions.elementToBeClickable(FilmCreate_Page.Text_On_createdFullFilm(driver)));
										       
										      FilmCreate_Page.button_createTrailer(driver).click();
										     
										      CloudUpload_action.associated_sugerSync(driver);  //  sugerSync
										     
										      element = (new WebDriverWait(driver, 10))
													   .until(ExpectedConditions.elementToBeClickable(FilmCreate_Page.text_on_createdTrailer(driver)));
										  
							                 element = FilmCreate_Page.textbox_setting_Form(driver);
										  
										      Excel.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"FilmUploads_Cloud");
												 
										     if(FilmCreate_Page.Text_On_createdFullFilm(driver).getText().equals(Excel.getCellData(1, 3))
														   && ( element != null))
													
										      {
													    
										    	Excel.setCellData("Pass", 18,6 );
												     
										      }
												
										      else
												   
										      {
													
										    	Excel.setCellData("Fail", 18, 6 );
										    	
										      }
										     
										     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
										 
										        driver.navigate().refresh();      
										        
								        }
										        
										        
                                               public static void CrossUpload_Gdrive_OneDrive(WebDriver driver) throws Exception
       								        
       								        {
										        

											    
											      FilmCreate_Page.button_UploadFullFilm(driver).click();
											    
											       CloudUpload_action.associated_gdrive(driver); //  full film gdrive
											       
											       element = (new WebDriverWait(driver, 10))
									       				   .until(ExpectedConditions.elementToBeClickable(FilmCreate_Page.Text_On_createdFullFilm(driver)));
											       
											      FilmCreate_Page.button_createTrailer(driver).click();
											     
											      CloudUpload_action.associated_oneDrive(driver);  //  onedrive
											     
											      element = (new WebDriverWait(driver, 10))
														   .until(ExpectedConditions.elementToBeClickable(FilmCreate_Page.text_on_createdTrailer(driver)));
											  
								                 element = FilmCreate_Page.textbox_setting_Form(driver);
											  
											      Excel.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"FilmUploads_Cloud");
													 
											     if(FilmCreate_Page.Text_On_createdFullFilm(driver).getText().equals(Excel.getCellData(1, 3))
															   && ( element != null))
														
											      {
														    
											    	Excel.setCellData("Pass", 19,6 );
													     
											      }
													
											      else
													   
											      {
														
											    	Excel.setCellData("Fail", 19, 6 );
											    	
											      }
											     
											     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
											 
											        driver.navigate().refresh(); 
											        
       								        }
                                               
}
											        
											        

	   
      
	   


