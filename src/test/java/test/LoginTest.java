package test;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import elementMethods.MethodsLoginPage;
import utilities.BrowserOperations;
import utilities.FileOperations;

public class LoginTest 
{
	WebDriver driver;
	@Test
	@Parameters("browsername")
	public void MethodLoginTest(String browsername) throws Exception
	{
		
		BrowserOperations objBrowserOperations=new BrowserOperations();
		driver= objBrowserOperations.LaunchBrowser(browsername);
		//driver= objBrowserOperations.LaunchBrowser("Firefox");
		
		FileOperations objFileOperations=new FileOperations();
		objBrowserOperations.LaunchApplication(objFileOperations.ReadPropertyFile("url"));
		
		String actualTitle= objBrowserOperations.GetTitle();
		
		Assert.assertEquals(actualTitle,"OrangeHRM");
		
		
		MethodsLoginPage objMethodsLoginPage=new MethodsLoginPage(driver);	
		
		objMethodsLoginPage.Method_EnterUserName();
		objMethodsLoginPage.Method_EnterPassword();
		objMethodsLoginPage.Method_ClickLogin();
		
		
		System.out.println(objMethodsLoginPage.Method_GetLoginName());
		Assert.assertEquals(objMethodsLoginPage.Method_GetLoginName(), objFileOperations.ReadPropertyFile("loginUser"));
	}
	
	@Test
	public void Method_Fail_1()
	{
		Assert.fail("Test case failed");
	}
	
	@AfterMethod
	public void CaptureScreenShot(ITestResult result) throws Exception
	{
		if (result.getStatus()==ITestResult.FAILURE) 
		{
			Thread.sleep(5000);
			TakesScreenshot screenshot= (TakesScreenshot)driver;
			File scFile= screenshot.getScreenshotAs(OutputType.FILE);	
			FileHandler.copy(scFile, new File(".\\src\\test\\ScreenShot\\Error.png"));
		}
		
		
	}

}
