package appModules;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import Utility.Constant;
import Utility.Log;

public class BrowserUpload_action {
	
	private static String email;
	private static String password;
	
	static Pattern img1 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataUploads+"movie.png");
	static Pattern img2 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataUploads+"film_link.png");
	static Pattern img3 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataUploads+"upload-popup.png");
	static Pattern img4 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataUploads+"desktop_open.png");
	static Pattern img5 = new Pattern(Constant.Path_TestData+Constant.Img_TestDataUploads+"popup-button.png");
	
	static Screen s = new Screen();
	
	
	public void Excecute(WebDriver driver) throws Exception
	
	{
		browserUpload(driver);
		browserUploadTrailer(driver);
		
	}
	
	
	public static void browserUpload(WebDriver driver) throws Exception 
	{
	

	s.wait(img1, 100);
	Log.info("Opened desktop window");
	s.click(img1);
	Log.info("Click on movie");
	
	s.wait(img2, 100);
	Log.info("opened film to be upload");
	s.click(img2);
	Log.info("Click to select the film");
	
	s.wait(img4, 100);
	s.click(img4);
	Log.info("Click on open button to upload");
	
	s.wait(img3, 1000);
	s.click(img3);
	Log.info("Success upload pop-up opens");
	
	s.click(img5);
	Log.info("Click to close it");
	
	}
	
	
public static void browserUploadTrailer(WebDriver driver) throws Exception
	
	{
		
		s.wait(img2, 100);
		Log.info("opened film to be upload");
		s.click(img2);
		Log.info("Click to select the film");
		
		s.wait(img4, 100);
		s.click(img4);
		Log.info("Click on open button to upload");
		
		s.wait(img3, 1000);
		s.click(img3);
		Log.info("Success upload pop-up opens");
		
		s.click(img5);
		Log.info("Click to close it");
		
		
		
	}
	

}
