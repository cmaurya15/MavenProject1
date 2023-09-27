package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserOperations 
{

	WebDriver driver;
	
	public WebDriver LaunchBrowser(String BrowserName) 
	{		
		System.out.println(BrowserName);
		
		switch (BrowserName) 
		{
		case "Firefox":
			System.setProperty("webdriver.gecko.driver", "c:\\geckodriver.exe");
			driver=new FirefoxDriver();
			
			break;
			
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
			driver=new ChromeDriver();
			
			break;
			
		case "Edge":
			System.setProperty("webdriver.edge.driver", "c:\\msedgedriver.exe");
			driver=new EdgeDriver();
			
			break;

		default:
			break;
		}
		return driver;
			
	}
	
	public void LaunchApplication(String url) throws Exception
	{
		driver.manage().window().maximize();
		
		Thread.sleep(4000);
		driver.get(url);
		
	}
	
	public String GetTitle() throws Exception 
	{
		Thread.sleep(4000);
		String title= driver.getTitle();
		return title;
		
	}
	
	

}
