package AutomationFramework;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import testCases.TestBrowserUpload;
import testCases.TestCloudUpload;
import testCases.TestFilmPurchaseUsingPaypal;
import testCases.TestPurchaseUsingStripe;
import testCases.TestSignIn;
import testCases.TestSignInValidationMessages;
import testCases.TestSignIn_Facebook;
import testCases.TestSignIn_LockOut;
import testCases.TestSignUp_Email;
import appModules.PlayerSignUp_action;
import appModules.SigIn_action;

public class TestStagingModules {
	
	public static WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws Exception

	{
		DOMConfigurator.configure("log4j.xml");
		
		driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
	}
	
	@AfterMethod
	public void terminate() throws Exception
	{
		//driver.quit();
	}
	
	
// @Test
  public void testSignIn() throws Exception 
  
  {
	TestSignIn.Execute(driver);
	  
  }
  
// @Test
  public void testSignInValidationMessages() throws Exception 
  
  {
	TestSignInValidationMessages.Execute(driver);
	  
  }
  
  
// @Test
  public void testSignInFacebook() throws Exception 
  
  {
	TestSignIn_Facebook.Execute(driver);
	  
  }
  
  
  
//@Test
  public void testSignInTwitter() throws Exception 
  
  {
	TestSignIn.Execute(driver);
	  
  }
  
//@Test
 public void testAccountLockout() throws Exception 
  
  {
	TestSignIn_LockOut.Execute(driver);
	  
  }
  
// @Test
  public void testSignUpEmail() throws Exception 
   
   {
 	TestSignUp_Email.Execute(driver);
 	  
   }
  
//  @Test
  public void testPurchaseUsingStripe() throws Exception 
  
  {
	TestPurchaseUsingStripe.Execute(driver);
	  
  }
  
  
// @Test
  public void testPurchaseUsingPaypal() throws Exception 
  
  {
	TestFilmPurchaseUsingPaypal.Execute(driver);
	  
  }
  
//  @Test
  public void testUploadCloud() throws Exception 
  
  {
	  
	TestCloudUpload.Execute(driver);

  }
  
  @Test
  public void testBrowserUpload() throws Exception 
  
  {
	  
	TestBrowserUpload.Execute(driver);

  }
  
}
