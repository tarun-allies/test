package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Utility.Log;

public class SignUp_Page {

	
	private static WebElement element = null;
	
	public static WebElement field_Email(WebDriver driver) throws Exception
	
	{
		try
		{
		element = driver.findElement(By.id("sf_guard_user_email_address"));
		Log.info("email field found on from");
		return element;
		}
		catch (Exception e)
		{
			Log.error("email field not found on form");
			throw(e);
		}
	}
	
	
	public static WebElement field_Password(WebDriver driver) throws Exception
	{
	try
	{
		element = driver.findElement(By.xpath(".//*[@id='sf_guard_user_password']"));
		Log.info("password field found on form");
		return element;
		}
	catch (Exception e)
	{
		Log.error("password field not found on form");
		throw(e);
	}
	}
	

	public static WebElement field_FullNmae(WebDriver driver) throws Exception
	{
		try
		{
		element = driver.findElement(By.id("sf_guard_user_full_name"));
		Log.info("full name field found on form");
		return element;
		}
		catch (Exception e)
		{
			Log.error("full name field not found on form");
			throw(e);
		}
		}
	
	public static WebElement field_DOB_Month(WebDriver driver) throws Exception
	{
		try
		{
		element = driver.findElement(By.xpath("html/body/div[2]/section/article/div/form/ul/li[7]/select[1]"));
		Log.info("dob_month field found on form");
		return element;
	}
		catch (Exception e)
		{
			Log.error("dob_month field not found on form");
			throw(e);
		}
		}
	
	public static WebElement Null_Value_dropdown_Month(WebDriver driver) throws Exception
	{
		try
		{
			element = driver.findElement(By.xpath("/html/body/div[2]/section/article/div/form/ul/li[7]/select/option"));
			Log.info(" null value found on drop down of DOB");
			return element;
		}
		
		catch (Exception e)
		{
			Log.error("null value not found on drop down of DOB");
			throw(e);
		}
		}
	
	
	public static WebElement value_DOB_Date(WebDriver driver) throws Exception
	{
		try
		{
		element = driver.findElement(By.xpath("html/body/div[2]/section/article/div/form/ul/li[7]/select[2]"));
		Log.info("value for dob_day found on drop down");
		return element;
		
	}
		catch (Exception e)
		{
			Log.error("value for dob_day not found on drop down");
			throw(e);
		}
		}
	
	public static WebElement NullValue_dropDown_Day(WebDriver driver) throws Exception
	{
		try {
		element = driver.findElement(By.xpath("/html/body/div[2]/section/article/div/form/ul/li[7]/select[2]/option"));
		Log.info(" null value found on drop down for day");
		return element;
		}
		catch (Exception e)
		{
			Log.error("null value found on drop down for day");
			throw(e);
		}
		}


	public static WebElement value_DOB_Year(WebDriver driver) throws Exception
	{
		try
		{
		element = driver.findElement(By.xpath(".//*[@id='sf_guard_user_dob_year']"));
		Log.info("value on drop dob_year found");
		return element;
		
	}
		catch (Exception e)
		{
			Log.error("value on drop dob_year not found");
			throw(e);
		}
		}
	
	public static WebElement NullValue_dropDpwn_Year(WebDriver driver) throws Exception
	{
		try
		{
		element = driver.findElement(By.xpath("/html/body/div[2]/section/article/div/form/ul/li[7]/select[3]/option"));
		Log.info("null value on drop down found on year");
		return element;
	}
		catch (Exception e)
		{
			Log.error("null value on drop down not found on year");
			throw(e);
		}
		}
	

	public static WebElement button_IdentifyAS(WebDriver driver) throws Exception
	{
		try
		{
		element =  driver.findElement(By.xpath(".//*[@id='sf_guard_user_gender_M']"));
		Log.info("I identify as radio button found on form");
		return element;
		}
		catch (Exception e)
		{
			Log.error("I identify as radio button not found on form");
			throw(e);
		}
		}
	
	public static WebElement submitButton(WebDriver driver) throws Exception
	{
		try
		{
       element = driver.findElement(By.xpath(".//*[@id='auth-form']/ul/li[9]/button[1]"));
       Log.info("submit button found on form");
       return element;
	}
		catch (Exception e)
		{
			Log.error("submit button not found on form");
			throw(e);
		}
		}
	
	public static WebElement ErrorMessage_BlankEmail(WebDriver driver) throws Exception
	{
		try
		{
	       element = driver.findElement(By.xpath("html/body/div[2]/section/article/div/form/div[1]/div"));
	       Log.info("text message found on form for blank email");
	       return element;
		}
		catch (Exception e)
		{
			Log.error("text message not found on form for blank mail");
			throw(e);
		}
		}
		
	
	public static WebElement ErrorMessage_Password(WebDriver driver) throws Exception
	{
		try
		{
	       element = driver.findElement(By.xpath("html/body/div[2]/section/article/div/form/div[1]/div"));
	       Log.info("text message found on form for wrong password");
	       return element;
		}
		catch (Exception e)
		{
			Log.error("text message not found on form for wrong password");
			throw(e);
		}
		}
	
	
	public static WebElement ErrorMessage_withoutDOB(WebDriver driver) throws Exception
	{
		try
		{
	       element = driver.findElement(By.xpath("html/body/div[2]/section/article/div/form/div[1]/div"));
	       Log.info("text message found on form for without DOB");
	       return element;
		}
		catch (Exception e)
		{
			Log.error("text message found on form for without DOB");
			throw(e);
		}
		}
	
	public static WebElement ErrorMessage_IdetifyAs(WebDriver driver) throws Exception
	{
		try
		{
	       element = driver.findElement(By.xpath("html/body/div[2]/section/article/div/form/div[1]/div"));
	       Log.info("text message found on form for I identify as");
	       return element;
		}
		catch (Exception e)
		{
			Log.error("text message not found on form for I identify as");
			throw(e);
		}
		}
	
	public static WebElement ErrorMessage_FullName(WebDriver driver) throws Exception
	{
		try
		{
	       element = driver.findElement(By.xpath("html/body/div[2]/section/article/div/form/div[1]/div[1]"));
	       Log.info("text message found on form for full name");
	       return element;
		}
		catch (Exception e)
		{
			Log.error("text message not found on form for full name");
			throw(e);
		}
		}
	
	public static WebElement ErrorMessage_lessThen13(WebDriver driver) throws Exception
	{
		try
		{
	       element = driver.findElement(By.xpath("html/body/div[2]/section/article/div/form/div[1]/div"));
	       Log.info("text message found on form on age less then 13");
	       return element;
		}
		catch (Exception e)
		{
			Log.error("text message not found on form on age less then 13");
			throw(e);
		}
		}
	
	public static WebElement ErrorMessage_Invalid_DOB(WebDriver driver) throws Exception
	{
		try
		{
	       element = driver.findElement(By.xpath("html/body/div[2]/section/article/div/form/div[1]/div"));
	       Log.info("text message found on form on invalid DOB");
	       return element;
		}
		catch (Exception e)
		{
			Log.error("text message found on form for invalid DDOB");
			throw(e);
		}
		}
	
	
	public static WebElement ErrorMessage_Already_Registererd_User(WebDriver driver) throws Exception
	{
		try
		{
	       element = driver.findElement(By.xpath("html/body/div[2]/section/article/div/form/div[1]/div"));
	       Log.info("text message found on form on alreday registered user");
	       return element;
		}
		catch (Exception e)
		{
			Log.error("text message not found on form on alreday registered user");
			throw(e);
		}
		}
	
	 
	public static WebElement ErrorMessage_Invalid_Email(WebDriver driver) throws Exception
	{
		try
		{
	       element = driver.findElement(By.xpath("html/body/div[2]/section/article/div/form/div[1]/div"));
	       Log.info("text message found on form on invalid email");
	       return element;
		}
		catch (Exception e)
		{
			Log.error("text message found on form on invalid email");
			throw(e);
		}
		}
	
}

