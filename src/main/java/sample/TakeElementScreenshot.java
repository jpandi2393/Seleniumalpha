package sample;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeElementScreenshot {

	public static void main(String[] args) throws IOException {

		 WebDriverManager.chromedriver().setup();
		 
		 WebDriver driver = new ChromeDriver();
		 
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 
	
	//Screenshot(user_name,"Screenshot_email");
	
	Screenshot(driver,"Full_page");
	
	login(driver);
	
	
}
	
	public static void Screenshot(WebDriver driver,String filename)
	{
		File Src_File=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		//File Src_File_pwd=element.getScreenshotAs(OutputType.FILE);
		
		try
		{
			FileUtils.copyFile(Src_File,new File("./target/screenshots/"+ filename+getDateTimeStamp()+".png"));
			
			
			//FileUtils.copyFile(Src_File_pwd,new File("./target/screenshots/"+ filename+".png"));
		}
		
		
		
		
		
		
		
		catch(IOException e)
		
		{
			e.printStackTrace();
		}
		
		
 
	}
	
	public static void login(WebDriver driver)
	
	{
				
    driver.get("http://upgrade-qa2.enphase.com");
		 
	WebElement user_name = driver.findElement(By.id("usernameOrEmail"));
	
	user_name.sendKeys("admin@enphaseenergy.com");
	
	WebElement pwd = driver.findElement(By.id("password"));
	
	pwd.sendKeys("Store123$%");
	
	WebElement submit = driver.findElement(By.name("submit"));
	
	submit.click();
	
	//driver.quit();

		
	}
	
	
	
	public static String getDateTimeStamp()
	{
	    // creates a date time stamp that is Windows OS filename compatible
	    return new SimpleDateFormat("MMM dd HH.mm.ss").format(Calendar.getInstance().getTime());
	}
	


} 
